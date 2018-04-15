package com.example.hamzakhan.ucpportal;

/**
 * Created by Hamza khan on 29/01/2018.
 */

public class Get_attendance {


    public Get_attendance(String status, String date) {
        this.status = status;
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    String status;
    String date;

}
