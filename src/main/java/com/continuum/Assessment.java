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
}
