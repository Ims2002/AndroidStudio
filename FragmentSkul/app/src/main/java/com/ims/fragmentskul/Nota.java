package com.ims.fragmentskul;

import java.io.Serializable;

public class Nota implements Serializable {
    private final String mark;
    private final String courseCode;

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
