package com.example.hamzakhan.ucpportal;

/**
 * Created by Hamza khan on 26/01/2018.
 */

public class Get_result {


    public String getQuiz1() {
        return quiz1;
    }

    public void setQuiz1(String quiz1) {
        this.quiz1 = quiz1;
    }

    public String getQuiz2() {
        return quiz2;
    }

    public void setQuiz2(String quiz2) {
        this.quiz2 = quiz2;
    }

    public String getQuiz3() {
        return quiz3;
    }

    public void setQuiz3(String quiz3) {
        this.quiz3 = quiz3;
    }

    public String getQuiz4() {
        return quiz4;
    }

    public void setQuiz4(String quiz4) {
        this.quiz4 = quiz4;
    }

    public String getAss1() {
        return ass1;
    }

    public void setAss1(String ass1) {
        this.ass1 = ass1;
    }

    public String getAss2() {
        return ass2;
    }

    public void setAss2(String ass2) {
        this.ass2 = ass2;
    }

    public String getAss3() {
        return ass3;
    }

    public void setAss3(String ass3) {
        this.ass3 = ass3;
    }

    public String getAss4() {
        return ass4;
    }

    public void setAss4(String ass4) {
        this.ass4 = ass4;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getFinals() {
        return finals;
    }

    public void setFinals(String finals) {
        this.finals = finals;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public Get_result(String quiz1, String quiz2, String quiz3, String quiz4, String ass1, String ass2, String ass3, String ass4, String mid, String finals,String project, String other) {
        this.quiz1 = quiz1;
        this.quiz2 = quiz2;
        this.quiz3 = quiz3;
        this.quiz4 = quiz4;
        this.ass1 = ass1;
        this.ass2 = ass2;
        this.ass3 = ass3;
        this.ass4 = ass4;
        this.mid = mid;
        this.finals = finals;
        this.project = project;
        this.other = other;
    }

    private String quiz1,quiz2,quiz3,quiz4,ass1,ass2,ass3,ass4,mid,finals,project,other;

}
