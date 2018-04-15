package com.example.hamzakhan.ucpportal;

/**
 * Created by Hamza khan on 04/02/2018.
 */

public class Course_catalog_get {
    String Oc_names;
    String quiz;
    String ass;

    public Course_catalog_get(String oc_names, String quiz, String ass, String midterm, String finals, String project, String others) {
        Oc_names = oc_names;
        this.quiz = quiz;
        this.ass = ass;
        this.midterm = midterm;
        this.finals = finals;
        this.project = project;
        this.others = others;
    }

    String midterm;

    public String getFinals() {
        return finals;
    }

    public void setFinals(String finals) {
        this.finals = finals;
    }

    public String getOc_names() {
        return Oc_names;
    }

    public void setOc_names(String oc_names) {
        Oc_names = oc_names;
    }

    public String getQuiz() {
        return quiz;
    }

    public void setQuiz(String quiz) {
        this.quiz = quiz;
    }

    public String getAss() {
        return ass;
    }

    public void setAss(String ass) {
        this.ass = ass;
    }

    public String getMidterm() {
        return midterm;
    }

    public void setMidterm(String midterm) {
        this.midterm = midterm;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getOthers() {
        return others;
    }

    public void setOthers(String others) {
        this.others = others;
    }

    String finals;
    String project;
    String others;
}
