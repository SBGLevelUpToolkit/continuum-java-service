package com.continuum;

import java.util.HashMap;
import java.util.Map;

public class Assessment {
    private String teamName;
    private String strategy;
    private String planning;
    private String coding;
    private String ci;
    private String incident;
    private String risk;
    private String design;
    private String teaming;
    private String release;
    private String qa;
    private String environments;
    private String featureTeams;
    private String rawData;
    private String recommendedCapabilities;
    private String capabilitiesToStop;
    private String remedyId;

    private transient Map<String, String> remedyMapping;

    public Assessment() {
        remedyMapping = new HashMap<String, String>();
        remedyMapping.put("Account Origination", "SGP000000004868");
        remedyMapping.put("ATM", "SGP000000012552");
        remedyMapping.put("Bancassurance", "SGP000000000832");
        remedyMapping.put("Credit Collections", "SGP000000012760");
        remedyMapping.put("Credit Scoring and Account Management", "");
        remedyMapping.put("Digital New Features", "SGP000000012212");
        remedyMapping.put("Digital Rollout", "SGP000000012755");
        remedyMapping.put("Digital Security", "SGP000000012551");
        remedyMapping.put("GoldenEye", "SGP000000008152");
        remedyMapping.put("Service Digitisation", "SGP000000012212");
        remedyMapping.put("Value Exchange", "SGP000000007062");
        remedyMapping.put("Acquiring - Rest of Africa", "SGP000000010758");
        remedyMapping.put("Diners Auths and Release Compliance", "SGP000000012754");
        remedyMapping.put("Diners Digitalization", "SGP000000001181");
        remedyMapping.put("Diners Transactional", "SGP000000001182");
        remedyMapping.put("EMV - Squad 1", "SGP000000012756");
        remedyMapping.put("EMV - Squad 2", "SGP000000012757");
        remedyMapping.put("Issuing - Customer Experience (Genesis)", "SGP000000010756");
        remedyMapping.put("Issuing - Innovation", "SGP000000010756");
        remedyMapping.put("Issuing - Product Squad 1", "SGP000000010756");
        remedyMapping.put("Issuing - Product Squad 2", "SGP000000010756");
        remedyMapping.put("Issuing - Rest of Africa", "SGP000000010756");
        remedyMapping.put("RoA Switch(Sparrow)", "SGP000000012211");
        remedyMapping.put("Cash - Acquiring", "SGP000000004986");
        remedyMapping.put("Cash - Production", "SGP000000009359");
        remedyMapping.put("Cash - Regulatory", "SGP000000004988");
        remedyMapping.put("FASS/GC/COSS", "SGP000000004771");
        remedyMapping.put("GOSS and Outsourced Production", "SGP000000004779");
        remedyMapping.put("Robotic Process Automation", "SGP000000005755");
        remedyMapping.put("Workflow - GOSS", "SGP000000004779");
        remedyMapping.put("Auto-Recons Legacy", "SGP000000004390");
        remedyMapping.put("Bulk Payments", "SGP000000011757");
        remedyMapping.put("Emerging Payments", "SGP000000008750");
        remedyMapping.put("IntelliMatch", "SGP000000007090");
        remedyMapping.put("Merchant Solutions Service", "SGP000000001127");
        remedyMapping.put("Money Transfers and ACB", "SGP000000004875");
        remedyMapping.put("Online Payments - Squad 1", "SGP000000012613");
        remedyMapping.put("Online Payments - Squad 2", "SGP000000012613");
        remedyMapping.put("Online Payments - Squad 3", "SGP000000012613");
        remedyMapping.put("Payment Data", "SGP000000012450");
        remedyMapping.put("Postilion/Base 24 - Squad 1", "SGP000000010757");
        remedyMapping.put("Postilion/Base 24 - Squad 2", "SGP000000010757");
        remedyMapping.put("Postilion/Base 24 - Squad 3", "SGP000000010757");
        remedyMapping.put("Fleet", "SGP000000001311");
        remedyMapping.put("VAF - Squad 1", "SGP000000001315");
        remedyMapping.put("VAF - Squad 2 with Genesis", "SGP000000001294");
        remedyMapping.put("ML/TF and Sanctions", "SGP000000004881");
        remedyMapping.put("Surveillance and Reporting", "SGP000000004963");
        remedyMapping.put("Deal Pricing and ALM", "SGP000000009355");
        remedyMapping.put("Econ and Reg Capital - Squad 1", "SGP000000012784");
        remedyMapping.put("Econ and Reg Capital - Squad 2", "SGP000000009253");
        remedyMapping.put("Finance Central - Squad 1", "SGP000000009357");
        remedyMapping.put("Finance Central - Squad 2", "SGP000000009357");
        remedyMapping.put("Finance Re-engineering", "SGP000000008057");
        remedyMapping.put("Procurement", "SGP000000004736");
        remedyMapping.put("Move Management", "SGP000000000970");
        remedyMapping.put("Physical Security", "SGP000000000970");
        remedyMapping.put("Real Estate Projects", "SGP000000000970");
        remedyMapping.put("HC Enablement", "SGP000000004968");
        remedyMapping.put("HC SAP", "SGP000000009855");
        remedyMapping.put("Marketing and Communications", "SGP000000008851");
        remedyMapping.put("GFCC", "SGP000000007062");
        remedyMapping.put("IOR", "SGP000000004980");
        remedyMapping.put("AML DevOps", "SGP000000009856");
        remedyMapping.put("Analytics and Third Party", "SGP000000011850");
        remedyMapping.put("Big Data", "SGP000000011651");
        remedyMapping.put("CIB", "SGP000000001175");
        remedyMapping.put("Data Management and Governance", "SGP000000001176");
        remedyMapping.put("Data Science", "SGP000000009870");
        remedyMapping.put("Data Warehousing - Squad 1", "SGP000000001172");
        remedyMapping.put("Data Warehousing - Squad 2", "SGP000000001173");
        remedyMapping.put("Enterprise BI", "SGP000000001170");
        remedyMapping.put("Human Capital", "SGP000000004990");
        remedyMapping.put("RDM, MDM and MRI", "SGP000000011750");
        remedyMapping.put("Reporting Services", "SGP000000001171");
        remedyMapping.put("Rest of Africa", "SGP000000001182");
        remedyMapping.put("SAP HANA Services (Hybris)", "SGP000000001178");
        remedyMapping.put("Wealth", "SGP000000004897");
        remedyMapping.put("Card and Emerging Payments", "SGP000000008750");
        remedyMapping.put("Client Side Framework", "SGP000000001125");
        remedyMapping.put("Customer Foundation", "SGP000000007551");
        remedyMapping.put("Corporate and Commercial Banking and International Payments", "SGP000000011757");
        remedyMapping.put("Data and Analytics", "SGP000000011850");
        remedyMapping.put("Investments", "SGP000000004783");
        remedyMapping.put("Digital ID and Entitlements", "SGP000000001090");
        remedyMapping.put("Insurance, Homeloans, VAF, Kids", "SGP000000010760");
        remedyMapping.put("Order Management", "SGP000000009859");
        remedyMapping.put("Personal and SE - Account Management", "SGP000000009859");
        remedyMapping.put("Personal and SE - Transactional and VAS", "SGP000000009859");
        remedyMapping.put("Staff Foundation", "SGP000000007551");
        remedyMapping.put("Virtual Banking - Squad 1", "SGP000000004525");
        remedyMapping.put("Virtual Banking - Squad 2", "SGP000000004525");
        remedyMapping.put("Web for Customer", "SGP000000007450");
        remedyMapping.put("Web for Staff", "SGP000000004956");
        remedyMapping.put("Web Presence and Community", "SGP000000004980");
        remedyMapping.put("Domain Architecture", "SGP000000001195");
        remedyMapping.put("BPM", "SGP000000004995");
        remedyMapping.put("ECM", "SGP000000001220");
        remedyMapping.put("ESB", "SGP000000004926");
        remedyMapping.put("Agile Tools", "SGP000000004992");
        remedyMapping.put("Application Performance Monitoring", "SGP000000004998");
        remedyMapping.put("Aris", "SGP000000004991");
        remedyMapping.put("Business Applications", "SGP000000001202");
        remedyMapping.put("Mainframe Tools", "SGP000000010150");
        remedyMapping.put("Sharepoint", "SGP000000001198");
        remedyMapping.put("Source Code Management", "SGP000000004992");
        remedyMapping.put("Teamtrack", "SGP000000001199");
        remedyMapping.put("Technical Enablement", "SGP000000004993");
        remedyMapping.put("Tools and Support", "SGP000000004992");
        remedyMapping.put("CDI/RSS", "SGP000000001202");
        remedyMapping.put("Natural and .NET Applications", "SGP000000001211");
        remedyMapping.put("Credit - Account Maintenance", "SGP000000010771");
        remedyMapping.put("Credit: Collections", "SGP000000001287");
        remedyMapping.put("Credit: Origination", "SGP000000001157");
        remedyMapping.put("E3", "SGP000000001118");
        remedyMapping.put("Customer Insights and Analytics", "SGP000000001160");
        remedyMapping.put("EIM Data Change", "SGP000000009874");
        remedyMapping.put("EIM Data Remediation", "SGP000000004858");
        remedyMapping.put("Banking Statements", "SGP000000004879");
        remedyMapping.put("Registration and Login", "SGP000000001160");
        remedyMapping.put("SEO Payments", "SGP000000001160");
        remedyMapping.put("SEO Profile Management", "SGP000000009874");
        remedyMapping.put("SEO Registration", "SGP000000009874");
        remedyMapping.put("USSD", "SGP000000009874");
        remedyMapping.put("Aris", "SGP000000004991");
        remedyMapping.put("ATM - Squad 1", "SGP000000010776");
        remedyMapping.put("ATM - Squad 2", "SGP000000010777");
        remedyMapping.put("CCC", "SGP000000004983");
        remedyMapping.put("Customer 1st and Ciboodle - Squad 1", "SGP000000001227");
        remedyMapping.put("Customer 1st and Ciboodle - Squad 2", "SGP000000001218");
        remedyMapping.put("eSignature / OFV", "SGP000000001141");
        remedyMapping.put("NDS - Squad 1", "SGP000000010772");
        remedyMapping.put("NDS - Squad 2", "SGP000000010772");
        remedyMapping.put("NDS - Squad 3", "SGP000000010772");
        remedyMapping.put("Branch Accounting", "SGP000000001285");
        remedyMapping.put("Homeloans - Squad 1", "SGP000000001193");
        remedyMapping.put("Homeloans - Squad 2", "SGP000000001194");
        remedyMapping.put("Instant Money - Digital Messaging", "SGP000000001140");
        remedyMapping.put("Instant Money - Transit", "SGP000000004875");
        remedyMapping.put("Instant Money - VAS", "SGP000000010766");
        remedyMapping.put("Instant Money - Wallets", "SGP000000001140");
        remedyMapping.put("Statements", "SGP000000001142");
        remedyMapping.put("Unsecured Lending", "SGP000000009863");
        remedyMapping.put("Insurance - Coverage Squad 1", "SGP000000007150");
        remedyMapping.put("Insurance - Coverage Squad 2", "SGP000000007150");
        remedyMapping.put("Wealth and Investments and Fiduciary", "SGP000000004783");
    }

    public void setFeatureTeams(String featureTeams) {
        this.featureTeams = featureTeams;
    }

    public void setEnvironments(String environments) {
        this.environments = environments;
    }

    public void setQa(String qa) {
        this.qa = qa;
    }

    public void setRelease(String release) {
        this.release = release;
    }

    public void setTeaming(String teaming) {
        this.teaming = teaming;
    }

    public void setDesign(String design) {
        this.design = design;
    }

    public void setRisk(String risk) {
        this.risk = risk;
    }

    public void setIncident(String incident) {
        this.incident = incident;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public void setCoding(String coding) {
        this.coding = coding;
    }

    public void setPlanning(String planning) {
        this.planning = planning;
    }

    public void setStrategy(String strategy) {
        this.strategy = strategy;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public void setRecommendedCapabilities(String recommendedCapabilities){ this.recommendedCapabilities = recommendedCapabilities;}

    public void setCapabilitiesToStop(String capabilitiesToStop){this.capabilitiesToStop = capabilitiesToStop;}

    public void setRawData(String rawData) {
        this.rawData = rawData;
    }

    public double removeValueFromAssessment(String attribute, double value){
        if(attribute.equals("Strategy")){
            return value - Double.parseDouble(this.strategy);
        }

        if(attribute.equals("Planning")){
            return value - Double.parseDouble(this.planning);
        }

        if(attribute.equals("Coding")){
            return value - Double.parseDouble(this.coding);
        }

        if(attribute.equals("CI")){
            return value - Double.parseDouble(this.ci);
        }

        if(attribute.equals("Incident")){
            return value - Double.parseDouble(this.incident);
        }

        if(attribute.equals("Risk")){
            return value - Double.parseDouble(this.risk);
        }

        if(attribute.equals("Design")){
            return value - Double.parseDouble(this.design);
        }

        if(attribute.equals("Teaming")){
            return value - Double.parseDouble(this.teaming);
        }

        if(attribute.equals("Release")){
            return value - Double.parseDouble(this.release);
        }

        if(attribute.equals("QA")){
            return value - Double.parseDouble(this.qa);
        }

        if(attribute.equals("Environments")){
            return value - Double.parseDouble(this.environments);
        }

        if(attribute.equals("FeatureTeams")){
            return value - Double.parseDouble(this.featureTeams);
        }

        return 0.0;
    }

    public void setRemedyId(){
        this.remedyId = remedyMapping.get(this.teamName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Assessment that = (Assessment) o;

        if (teamName != null ? !teamName.equals(that.teamName) : that.teamName != null) return false;
        if (strategy != null ? !strategy.equals(that.strategy) : that.strategy != null) return false;
        if (planning != null ? !planning.equals(that.planning) : that.planning != null) return false;
        if (coding != null ? !coding.equals(that.coding) : that.coding != null) return false;
        if (ci != null ? !ci.equals(that.ci) : that.ci != null) return false;
        if (incident != null ? !incident.equals(that.incident) : that.incident != null) return false;
        if (risk != null ? !risk.equals(that.risk) : that.risk != null) return false;
        if (design != null ? !design.equals(that.design) : that.design != null) return false;
        if (teaming != null ? !teaming.equals(that.teaming) : that.teaming != null) return false;
        if (release != null ? !release.equals(that.release) : that.release != null) return false;
        if (qa != null ? !qa.equals(that.qa) : that.qa != null) return false;
        if (environments != null ? !environments.equals(that.environments) : that.environments != null) return false;
        if (featureTeams != null ? !featureTeams.equals(that.featureTeams) : that.featureTeams != null) return false;
        return rawData != null ? rawData.equals(that.rawData) : that.rawData == null;
    }

    @Override
    public int hashCode() {
        int result = teamName != null ? teamName.hashCode() : 0;
        result = 31 * result + (strategy != null ? strategy.hashCode() : 0);
        result = 31 * result + (planning != null ? planning.hashCode() : 0);
        result = 31 * result + (coding != null ? coding.hashCode() : 0);
        result = 31 * result + (ci != null ? ci.hashCode() : 0);
        result = 31 * result + (incident != null ? incident.hashCode() : 0);
        result = 31 * result + (risk != null ? risk.hashCode() : 0);
        result = 31 * result + (design != null ? design.hashCode() : 0);
        result = 31 * result + (teaming != null ? teaming.hashCode() : 0);
        result = 31 * result + (release != null ? release.hashCode() : 0);
        result = 31 * result + (qa != null ? qa.hashCode() : 0);
        result = 31 * result + (environments != null ? environments.hashCode() : 0);
        result = 31 * result + (featureTeams != null ? featureTeams.hashCode() : 0);
        result = 31 * result + (rawData != null ? rawData.hashCode() : 0);
        return result;
    }
}
