package com.continuum;

import spark.Filter;
import spark.Request;
import spark.Response;
import spark.Route;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;

import static com.continuum.JsonUtil.json;
import static spark.Spark.*;

public class ContinuumService {


    private static String[] getDBDetails() {
        try {
            Properties props = new Properties();
            String configFile = System.getProperty("user.dir") + "/config/config.properties";
            InputStream in = new FileInputStream(configFile);
            props.load(in);
            in.close();

            String[] dbDetails = new String[4];
            dbDetails[0] = props.get("CONTINUUM_DB_URL").toString();
            dbDetails[1] = props.get("CONTINUUM_DB_USERNAME").toString();
            dbDetails[2] = props.get("CONTINUUM_DB_PASSWORD").toString();
            dbDetails[3] = props.get("MY_SQL_URL").toString();

            return dbDetails;
        }
        catch (Exception exception){
            return new String[] {"", "", "", ""};
        }
    }

    private static ArrayList<String> getDistinctDetailsFor(String distinctType, String query) {
        Connection conn = null;
        Statement stmt = null;
        ArrayList<String> distinctResults = new ArrayList<String>();

        String[] dbDetails = getDBDetails();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(dbDetails[0], dbDetails[1], dbDetails[2]);
            stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(query);

            while (resultSet.next()){
                distinctResults.add(resultSet.getString(distinctType));
            }
            return distinctResults;
        }
        catch (Exception exception){
            return new ArrayList<String>();
        }
    }

    private static Assessments getAssessmentsByDate(String dateAssessed, String portfolio, Boolean removeRawData, ArrayList<String> previousDates){
        Connection conn = null;
        Statement stmt = null;
        ArrayList<Assessment> assessments = new ArrayList<Assessment>();
        String[] dbDetails = getDBDetails();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(dbDetails[0], dbDetails[1], dbDetails[2]);
            stmt = conn.createStatement();

            String queryStatement = "SELECT * from ContinuumAssessmentResults where dateassessed = '";

            for(String date: previousDates){
                queryStatement += date + "' OR dateassessed = '";
            }

            int length = " OR dateassessed = '".length();
            queryStatement = queryStatement.substring(0, queryStatement.length() - length) + " AND portfolio = '" + portfolio + "'";

            ResultSet resultSet = stmt.executeQuery(queryStatement);

            int numberOfRecords = 0;
            double overallStrategy = 0;
            double overallPlanning = 0;
            double overallCoding = 0;
            double overallCI = 0;
            double overallIncident = 0;
            double overallRisk = 0;
            double overallDesign = 0;
            double overallTeaming = 0;
            double overallRelease = 0;
            double overallQA = 0;
            double overallEnvironments = 0;
            double overallFeatureTeams = 0;

            ArrayList<String> teamObtained = new ArrayList<String>();

            while (resultSet.next()){
                String teamName = resultSet.getString("teamName");
                if(!teamObtained.contains(teamName)) {
                    Assessment assessment = new Assessment();
                    assessment.setTeamName(teamName);

                    String strategy = resultSet.getString("strategy");
                    assessment.setStrategy(strategy);
                    overallStrategy += Integer.parseInt(strategy);

                    String planning = resultSet.getString("planning");
                    assessment.setPlanning(planning);
                    overallPlanning += Integer.parseInt(planning);

                    String coding = resultSet.getString("coding");
                    assessment.setCoding(coding);
                    overallCoding += Integer.parseInt(coding);

                    String ci = resultSet.getString("ci");
                    assessment.setCi(ci);
                    overallCI += Integer.parseInt(ci);

                    String incident = resultSet.getString("incident");
                    assessment.setIncident(incident);
                    overallIncident += Integer.parseInt(incident);

                    String risk = resultSet.getString("risk");
                    assessment.setRisk(risk);
                    overallRisk += Integer.parseInt(risk);

                    String design = resultSet.getString("design");
                    assessment.setDesign(design);
                    overallDesign += Integer.parseInt(design);

                    String teaming = resultSet.getString("teaming");
                    assessment.setTeaming(teaming);
                    overallTeaming += Integer.parseInt(teaming);

                    String release = resultSet.getString("release");
                    assessment.setRelease(release);
                    overallRelease += Integer.parseInt(release);

                    String quality = resultSet.getString("quality");
                    assessment.setQa(quality);
                    overallQA += Integer.parseInt(quality);

                    String environments = resultSet.getString("environments");
                    assessment.setEnvironments(environments);
                    overallEnvironments += Integer.parseInt(environments);

                    String featureteams = resultSet.getString("featureteams");
                    assessment.setFeatureTeams(featureteams);
                    overallFeatureTeams += Integer.parseInt(featureteams);

                    if (!removeRawData) {
                        String rawData = resultSet.getString("rawdata");
                        assessment.setRawData(rawData);
                    }

                    numberOfRecords++;
                    assessments.add(assessment);
                    teamObtained.add(teamName);
                }
            }
            Assessment assessmentOverall = new Assessment();
            assessmentOverall.setTeamName("Average For All The Teams");
            assessmentOverall.setStrategy(String.valueOf(overallStrategy/numberOfRecords));
            assessmentOverall.setPlanning(String.valueOf(overallPlanning/numberOfRecords));
            assessmentOverall.setCoding(String.valueOf(overallCoding/numberOfRecords));
            assessmentOverall.setCi(String.valueOf(overallCI/numberOfRecords));
            assessmentOverall.setIncident(String.valueOf(overallIncident/numberOfRecords));
            assessmentOverall.setRisk(String.valueOf(overallRisk/numberOfRecords));
            assessmentOverall.setDesign(String.valueOf(overallDesign/numberOfRecords));
            assessmentOverall.setTeaming(String.valueOf(overallTeaming/numberOfRecords));
            assessmentOverall.setRelease(String.valueOf(overallRelease/numberOfRecords));
            assessmentOverall.setQa(String.valueOf(overallQA/numberOfRecords));
            assessmentOverall.setEnvironments(String.valueOf(overallEnvironments/numberOfRecords));
            assessmentOverall.setFeatureTeams(String.valueOf(overallFeatureTeams/numberOfRecords));
            assessments.add(assessmentOverall);

            return new Assessments(dateAssessed, portfolio, assessments);
        }
        catch (Exception exception){
            return new Assessments(dateAssessed, portfolio, new ArrayList<Assessment>());
        }
    }

    private static ArrayList<String> getPreviousAssessmentDates(String currentDateString, ArrayList<String> otherDates){
        ArrayList<String> previousDates = new ArrayList<String>();

        previousDates.add(currentDateString);

        for(String assessmentDate: otherDates){
            try {
                DateFormat format = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
                Date date = format.parse(assessmentDate);
                Date currentDate = format.parse(currentDateString);

                if(date.before(currentDate)){
                    previousDates.add(assessmentDate);
                }
            }
            catch (Exception ex){

            }
        }

        return previousDates;
    }

    private static ArrayList<Assessments> getAssessments(Boolean removeRawData){

        String portfolioQuery = "SELECT DISTINCT portfolio from ContinuumAssessmentResults";
        ArrayList<Assessments> allAssessmentsDone = new ArrayList<Assessments>();
        ArrayList<String> assessmentPortfolios = getDistinctDetailsFor("portfolio", portfolioQuery);
        for(String portfolio: assessmentPortfolios){
            String dateQuery = "SELECT DISTINCT dateassessed from ContinuumAssessmentResults WHERE portfolio = '" + portfolio + "'";
            ArrayList<String> assessmentDates = getDistinctDetailsFor("dateassessed", dateQuery);
            for(String assessmentDate: assessmentDates){
                allAssessmentsDone.add(getAssessmentsByDate(assessmentDate, portfolio, removeRawData, getPreviousAssessmentDates(assessmentDate, assessmentDates)));
            }
        }

        return allAssessmentsDone;
    }

    private static Assessment getAssessmentForTeam(String teamName, Boolean removeRawData){
        Connection conn = null;
        Statement stmt = null;
        Assessment assessment = new Assessment();
        String[] dbDetails = getDBDetails();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(dbDetails[0], dbDetails[1], dbDetails[2]);
            stmt = conn.createStatement();

            String queryStatement = "SELECT * from ContinuumAssessmentResults where teamName = '"
                    + teamName + "'";
            ResultSet resultSet = stmt.executeQuery(queryStatement);


            while (resultSet.next()){
                assessment.setTeamName(resultSet.getString("teamName"));

                String strategy = resultSet.getString("strategy");
                assessment.setStrategy(strategy);

                String planning = resultSet.getString("planning");
                assessment.setPlanning(planning);

                String coding = resultSet.getString("coding");
                assessment.setCoding(coding);

                String ci = resultSet.getString("ci");
                assessment.setCi(ci);

                String incident = resultSet.getString("incident");
                assessment.setIncident(incident);

                String risk = resultSet.getString("risk");
                assessment.setRisk(risk);

                String design = resultSet.getString("design");
                assessment.setDesign(design);

                String teaming = resultSet.getString("teaming");
                assessment.setTeaming(teaming);

                String release = resultSet.getString("release");
                assessment.setRelease(release);

                String quality = resultSet.getString("quality");
                assessment.setQa(quality);

                String environments = resultSet.getString("environments");
                assessment.setEnvironments(environments);

                String featureteams = resultSet.getString("featureteams");
                assessment.setFeatureTeams(featureteams);

                if(!removeRawData) {
                    String rawData = resultSet.getString("rawdata");
                    assessment.setRawData(rawData);
                }
            }

            return assessment;
        }
        catch (Exception exception){
            return assessment;
        }
    }

    private static void createDatabaseIfItDoesNotExists(){
        Connection conn = null;
        Statement statement = null;
        String[] dbDetails = getDBDetails();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(dbDetails[3], dbDetails[1], dbDetails[2]);
            statement = conn.createStatement();
            statement.executeUpdate("CREATE DATABASE IF NOT EXISTS ContinuumAssessment;");
            createTableIfItDoesNotExists();
        }
        catch (Exception exception){

        }
    }

    private static void createTableIfItDoesNotExists(){
        Connection conn = null;
        Statement statement = null;
        String[] dbDetails = getDBDetails();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(dbDetails[0], dbDetails[1], dbDetails[2]);
            statement = conn.createStatement();
            String sqlCreate = "CREATE TABLE IF NOT EXISTS ContinuumAssessmentResults"
                    + "  (teamName           VARCHAR(150),"
                    + "   strategy           INTEGER,"
                    + "   planning           INTEGER,"
                    + "   coding             INTEGER,"
                    + "   ci                 INTEGER,"
                    + "   incident           INTEGER,"
                    + "   risk               INTEGER,"
                    + "   design             INTEGER,"
                    + "   teaming            INTEGER,"
                    + "   release            INTEGER,"
                    + "   quality            INTEGER,"
                    + "   environments       INTEGER,"
                    + "   featureteams       INTEGER,"
                    + "   dateassessed       VARCHAR(100),"
                    + "   portfolio          VARCHAR(150),"
                    + "   rawdata            VARCHAR(200)"
                    + "   UNIQUE KEY 'my_unique_key' ('teamName','dateassessed','portfolio'))";

            statement.execute(sqlCreate);
        }
        catch (Exception exception){

        }
    }

    public static void main(String[] args) {

        port(8080);

        post("/saveTeamData", new Route() {
            public Object handle(Request request, Response response) throws Exception {

                createDatabaseIfItDoesNotExists();
                Connection conn = null;
                Statement stmt = null;

                String teamName = request.queryParams("teamName");
                String strategy = request.queryParams("strategy");
                String planning = request.queryParams("planning");
                String coding = request.queryParams("coding");
                String ci = request.queryParams("ci");
                String incident = request.queryParams("incident");
                String risk = request.queryParams("risk");
                String design = request.queryParams("design");
                String teaming = request.queryParams("teaming");
                String release = request.queryParams("release");
                String qa = request.queryParams("qa");
                String environments = request.queryParams("environments");
                String featureTeams = request.queryParams("featureTeams");
                DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                String dateOfEvaluation = dateFormat.format(new Date());
                String portfolioName = request.queryParams("portfolioName");
                String rawData = request.queryParams("rawData");
                String[] dbDetails = getDBDetails();

                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    conn = DriverManager.getConnection(dbDetails[0], dbDetails[1], dbDetails[2]);
                    stmt = conn.createStatement();

                    String sql = String.format("REPLACE INTO ContinuumAssessmentResults " +
                                    "VALUES ('%s',%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,'%s', '%s', '%s')", teamName, strategy, planning, coding, ci,
                            incident, risk, design, teaming, release, qa, environments, featureTeams, dateOfEvaluation, portfolioName, rawData);

                    int insertedRecord = stmt.executeUpdate(sql);

                    if (insertedRecord > 0) {
                        return "Successfully inserted record";
                    } else {
                        return "Record not inserted";
                    }
                }
                catch (SQLException exception){
                    return "Error Code: " + exception.toString();
                }

            }
        });

        get("/assessments", new Route() {
            public Object handle(Request req, Response res) throws Exception {
                Boolean removeRawData = Boolean.valueOf(req.queryParams("noRawData"));
                return getAssessments(removeRawData);
            }
        }, json());


        get("/assessment", new Route() {
            public Object handle(Request request, Response response) throws Exception {
                String teamName = request.queryParams("teamName");
                Boolean removeRawData = Boolean.valueOf(request.queryParams("noRawData"));
                Assessment teamAssessment = getAssessmentForTeam(teamName, removeRawData);
                return teamAssessment;
            }
        }, json());


        options("/*",
                new Route() {
                    public Object handle(Request request, Response response) throws Exception {

                        String accessControlRequestHeaders = request
                                .headers("Access-Control-Request-Headers");
                        if (accessControlRequestHeaders != null) {
                            response.header("Access-Control-Allow-Headers",
                                    accessControlRequestHeaders);
                        }

                        String accessControlRequestMethod = request
                                .headers("Access-Control-Request-Method");
                        if (accessControlRequestMethod != null) {
                            response.header("Access-Control-Allow-Methods",
                                    accessControlRequestMethod);
                        }

                        return "OK";
                    }
                });

        before(new Filter() {
            public void handle(Request request, Response response) throws Exception {
                response.header("Access-Control-Allow-Origin", "*");
            }
        });
    }
}
