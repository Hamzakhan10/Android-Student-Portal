package com.example.hamzakhan.ucpportal;

/**
 * Created by Hamza khan on 14/12/2017.
 */

public class get_announcements {

    public get_announcements(String subject,String date,String annoucment)
    {
        this.setSubject(subject);
        this.setAnnoucment(annoucment);
        this.setDate(date);


    }


    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getAnnoucment() {
        return annoucment;
    }

    public void setAnnoucment(String annoucment) {
        this.annoucment = annoucment;
    }

    private String subject;
    private String annoucment;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    private String date;
}
