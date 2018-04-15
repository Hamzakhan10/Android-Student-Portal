package com.example.hamzakhan.ucpportal;

/**
 * Created by Hamza khan on 08/01/2018.
 */

public class list_courses {

    private String head;
    private static final String URL_DATA="http://ucpportal.000webhostapp.com/get_courses.php";
    private String desc;
    private String image_url;

    public list_courses(String head, String desc, String image_url) {
        this.head = head;
        this.desc = desc;
        this.image_url = image_url;
    }

    public String getHead() {
        return head;
    }

    public String getDesc() {
        return desc;
    }

    public String getImage_url() {
        return image_url;
    }
}
