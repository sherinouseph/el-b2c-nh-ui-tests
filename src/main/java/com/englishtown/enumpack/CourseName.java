package com.englishtown.enumpack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum CourseName {

    GENERAL_ENGLISH("General English"),
    BUSINESS("Business"),
    INDUSTRY("Industry"),
    TRAVEL("Travel"),
    TOEFL_TOEIC_PREP("Toefl/Toeic preparation");

    private final String courseName;

    private CourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseName(){
        return this.courseName;
    }

    private static final Logger logger = LoggerFactory.getLogger(CourseName.class);

}
