package com.continuum;

import java.util.ArrayList;

public class Assessments {
    private String dateAssessed;
    private String portfolio;
    private ArrayList<Assessment> assessments;

    public Assessments(String dateAssessed, String portfolio, ArrayList<Assessment> assessments) {
        this.dateAssessed = dateAssessed;
        this.portfolio = portfolio;
        this.assessments = assessments;
    }
}
