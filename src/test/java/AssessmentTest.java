import com.continuum.Assessment;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

public class AssessmentTest {
    Assessment assessment;
    Assessment anotherAssessment;

    @Before
    public void setUp(){
        assessment = new Assessment();
        anotherAssessment = new Assessment();

    }

    @Test
    public void shouldKnowThatAnAssessmentCanBeCreatedWithNoAttributesSet(){
        assertEquals(assessment, anotherAssessment);
    }

    @Test
    public void shouldKnowThatAnAssessmentCanBeCreatedWithFeatureTeamsSet(){
        assessment.setFeatureTeams("featureTeams");
        anotherAssessment.setFeatureTeams("featureTeams");

        assertEquals(assessment, anotherAssessment);
    }

    @Test
    public void shouldKnowThatAssessmentsWithDifferentFeatureTeamValuesAreNotEqual(){
        assessment.setFeatureTeams("featureTeams");
        anotherAssessment.setFeatureTeams("anotherFeatureTeams");

        assertThat(assessment, is(not(equalTo(anotherAssessment))));
    }

    @Test
    public void shouldKnowThatAnAssessmentCanBeCreatedWithEnvironmentsSet(){
        assessment.setEnvironments("environments");
        anotherAssessment.setEnvironments("environments");

        assertEquals(assessment, anotherAssessment);
    }

    @Test
    public void shouldKnowThatAssessmentsWithDifferentEnvironmentsValuesAreNotEqual(){
        assessment.setEnvironments("environments");
        anotherAssessment.setEnvironments("anotherEnvironments");

        assertThat(assessment, is(not(equalTo(anotherAssessment))));
    }

    @Test
    public void shouldKnowThatAnAssessmentCanBeCreatedWithQASet(){
        assessment.setQa("qa");
        anotherAssessment.setQa("qa");

        assertEquals(assessment, anotherAssessment);
    }

    @Test
    public void shouldKnowThatAssessmentsWithDifferentQAValuesAreNotEqual(){
        assessment.setQa("qa");
        anotherAssessment.setQa("anotherQa");

        assertThat(assessment, is(not(equalTo(anotherAssessment))));
    }

    @Test
    public void shouldKnowThatAnAssessmentCanBeCreatedWithReleaseManagementSet(){
        assessment.setRelease("release");
        anotherAssessment.setRelease("release");

        assertEquals(assessment, anotherAssessment);
    }

    @Test
    public void shouldKnowThatAssessmentsWithDifferentReleaseManagementValuesAreNotEqual(){
        assessment.setRelease("release");
        anotherAssessment.setRelease("anotherRelease");

        assertThat(assessment, is(not(equalTo(anotherAssessment))));
    }

    @Test
    public void shouldKnowThatAnAssessmentCanBeCreatedWithTeamingSet(){
        assessment.setTeaming("teaming");
        anotherAssessment.setTeaming("teaming");

        assertEquals(assessment, anotherAssessment);
    }

    @Test
    public void shouldKnowThatAssessmentsWithDifferentTeamingValuesAreNotEqual(){
        assessment.setTeaming("teaming");
        anotherAssessment.setTeaming("anotherTeaming");

        assertThat(assessment, is(not(equalTo(anotherAssessment))));
    }

    @Test
    public void shouldKnowThatAnAssessmentCanBeCreatedWithDesignSet(){
        assessment.setDesign("design");
        anotherAssessment.setDesign("design");

        assertEquals(assessment, anotherAssessment);
    }

    @Test
    public void shouldKnowThatAssessmentsWithDifferentDesignValuesAreNotEqual(){
        assessment.setDesign("design");
        anotherAssessment.setDesign("anotherDesign");

        assertThat(assessment, is(not(equalTo(anotherAssessment))));
    }

    @Test
    public void shouldKnowThatAnAssessmentCanBeCreatedWithRiskSet(){
        assessment.setRisk("risk");
        anotherAssessment.setRisk("risk");

        assertEquals(assessment, anotherAssessment);
    }

    @Test
    public void shouldKnowThatAssessmentsWithDifferentRiskValuesAreNotEqual(){
        assessment.setRisk("risk");
        anotherAssessment.setRisk("anotherRisk");

        assertThat(assessment, is(not(equalTo(anotherAssessment))));
    }

    @Test
    public void shouldKnowThatAnAssessmentCanBeCreatedWithIncidentSet(){
        assessment.setIncident("incident");
        anotherAssessment.setIncident("incident");

        assertEquals(assessment, anotherAssessment);
    }

    @Test
    public void shouldKnowThatAssessmentsWithDifferentIncidentValuesAreNotEqual(){
        assessment.setIncident("incident");
        anotherAssessment.setIncident("anotherIncident");

        assertThat(assessment, is(not(equalTo(anotherAssessment))));
    }

    @Test
    public void shouldKnowThatAnAssessmentCanBeCreatedWithCISet(){
        assessment.setCi("ci");
        anotherAssessment.setCi("ci");

        assertEquals(assessment, anotherAssessment);
    }

    @Test
    public void shouldKnowThatAssessmentsWithDifferentCIValuesAreNotEqual(){
        assessment.setCi("ci");
        anotherAssessment.setCi("anotherCI");

        assertThat(assessment, is(not(equalTo(anotherAssessment))));
    }

    @Test
    public void shouldKnowThatAnAssessmentCanBeCreatedWithCodingSet(){
        assessment.setCoding("coding");
        anotherAssessment.setCoding("coding");

        assertEquals(assessment, anotherAssessment);
    }

    @Test
    public void shouldKnowThatAssessmentsWithDifferentCodingValuesAreNotEqual(){
        assessment.setCoding("coding");
        anotherAssessment.setCoding("anotherCoding");

        assertThat(assessment, is(not(equalTo(anotherAssessment))));
    }

    @Test
    public void shouldKnowThatAnAssessmentCanBeCreatedWithPlanningSet(){
        assessment.setPlanning("planning");
        anotherAssessment.setPlanning("planning");

        assertEquals(assessment, anotherAssessment);
    }

    @Test
    public void shouldKnowThatAssessmentsWithDifferentPlanningValuesAreNotEqual(){
        assessment.setPlanning("planning");
        anotherAssessment.setPlanning("anotherPlanning");

        assertThat(assessment, is(not(equalTo(anotherAssessment))));
    }

    @Test
    public void shouldKnowThatAnAssessmentCanBeCreatedWithStrategySet(){
        assessment.setStrategy("strategy");
        anotherAssessment.setStrategy("strategy");

        assertEquals(assessment, anotherAssessment);
    }

    @Test
    public void shouldKnowThatAssessmentsWithDifferentStrategyValuesAreNotEqual(){
        assessment.setStrategy("strategy");
        anotherAssessment.setStrategy("anotherStrategy");

        assertThat(assessment, is(not(equalTo(anotherAssessment))));
    }

    @Test
    public void shouldKnowThatAnAssessmentCanBeCreatedWithTeamNameSet(){
        assessment.setTeamName("teamName");
        anotherAssessment.setTeamName("teamName");

        assertEquals(assessment, anotherAssessment);
    }

    @Test
    public void shouldKnowThatAssessmentsWithDifferentTeamNameValuesAreNotEqual(){
        assessment.setTeamName("teamName");
        anotherAssessment.setTeamName("anotherTeamName");

        assertThat(assessment, is(not(equalTo(anotherAssessment))));
    }

    @Test
    public void shouldKnowThatAnAssessmentCanBeCreatedWithRawDataSet(){
        assessment.setRawData("rawData");
        anotherAssessment.setRawData("rawData");

        assertEquals(assessment, anotherAssessment);
    }

    @Test
    public void shouldKnowThatAssessmentsWithDifferentRawDataValuesAreNotEqual(){
        assessment.setRawData("rawData");
        anotherAssessment.setRawData("anotherRawData");

        assertThat(assessment, is(not(equalTo(anotherAssessment))));
    }
}
