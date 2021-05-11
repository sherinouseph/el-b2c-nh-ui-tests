package com.englishtown.newhouse.school.beanandenum;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum CourseCodeNumber {

    GENERAL_ENGLISH("GE",0,"General English"),
    BUSINESS("BE",1,"Business"),
    INDUSTRY("IND",2,"Industry"),
    TRAVEL("TRV",3,"Travel"),
    TOEFL_TOEIC_PREP("TT",4,"Toefl Toeic");


    private static final Logger logger = LoggerFactory.getLogger(CourseCodeNumber.class);


    private final String courseCode;
    private final int courseNumber ;
    private final String courseName;

    CourseCodeNumber(String courseCode, int courseNumber, String courseName) {

        this.courseCode = courseCode;
        this.courseNumber    = courseNumber;
        this.courseName = courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }


    public int getCourseNumber() {
        return courseNumber;
    }





}
