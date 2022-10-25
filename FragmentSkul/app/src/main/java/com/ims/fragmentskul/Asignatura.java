package com.ims.fragmentskul;

import java.io.Serializable;

public class Asignatura implements Serializable {

    private final String courseCode;
    private final String courseName;

    public Asignatura(String courseCode, String courseName){
        this.courseCode = courseCode;
        this.courseName = courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }
}
