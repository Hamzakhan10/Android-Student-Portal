package com.example.hamzakhan.ucpportal;

/**
 * Created by Hamza khan on 14/01/2018.
 */

public class Courses_get_data {

    private String Oc_names;
    private String sec_id;
    public Courses_get_data(String name,String sec_id) {
        this.Oc_names = name;
        this.sec_id=sec_id;


    }

    public String getSec_id() {
        return sec_id;
    }

    public void setSec_id(String sec_id) {
        this.sec_id = sec_id;
    }








    public String getOc_names() {
        return Oc_names;
    }

    public void setOc_names(String oc_names) {
        this.Oc_names = oc_names;
    }

}
