package com.ims.fragmentskul;

public class Nota {
    private String mark;
    private String courseCode;

    public Nota(String mark, String courseCode) {
        this.mark = mark;
        this.courseCode = courseCode;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getMark() {
        return mark;
    }
}
