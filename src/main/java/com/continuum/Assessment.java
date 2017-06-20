package com.continuum;

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

    public Assessment() {
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

    public void setRawData(String rawData) {
        this.rawData = rawData;
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
