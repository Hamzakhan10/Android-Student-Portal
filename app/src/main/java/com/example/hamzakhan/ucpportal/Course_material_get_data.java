package com.example.hamzakhan.ucpportal;

/**
 * Created by Hamza khan on 16/01/2018.
 */

public class Course_material_get_data {
    public Course_material_get_data(String courseFile)
    {
        this.courseFile=courseFile;
    }
    public String getCourseFile() {
        return courseFile;
    }

    public void setCourseFile(String courseFile) {
        this.courseFile = courseFile;
    }

    private String courseFile;
}
