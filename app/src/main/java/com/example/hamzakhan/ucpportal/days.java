package com.example.hamzakhan.ucpportal;

/**
 * Created by Hamza khan on 03/12/2017.
 */

public class days {

    private String day;
    private String time;
    private String r_no;

    public String getOc_names() {
        return Oc_names;
    }

    public void setOc_names(String oc_names) {
        Oc_names = oc_names;
    }

    private String Oc_names;

    public days(String day, String time, String r_no,String oc_names) {
        this.day = day;
        this.time = time;
        this.r_no = r_no;
        this.Oc_names=oc_names;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getR_no() {
        return r_no;
    }

    public void setR_no(String r_no) {
        this.r_no = r_no;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }


}
