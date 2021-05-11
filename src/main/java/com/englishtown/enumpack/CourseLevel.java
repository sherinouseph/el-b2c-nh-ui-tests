package com.englishtown.enumpack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum CourseLevel {

    BUSINESS("Business"),   // shown on select topic to book a PL
    TOEIC("TOEIC"),         // same as above
    BEGINNERS_1("1 Beginner"),
    BEGINNERS_2("2 Beginner"),
    BEGINNERS_3("3 Beginner"),

    ELEMENTARY_4("4 Elementary "),
    ELEMENTARY_5("5 Elementary"),
    ELEMENTARY_6("6 Elementary"),

    INTERMEDIATE_7("7 Intermediate"),
    INTERMEDIATE_8("8 Intermediate"),
    INTERMEDIATE_9("9 Intermediate"),

    UPPER_INTERMEDIATE_10("10 Upper Intermediate"),
    UPPER_INTERMEDIATE_11("11 Upper Intermediate"),
    UPPER_INTERMEDIATE_12("12 Upper Intermediate"),

    ADVANCED_13("13 Advanced"),
    ADVANCED_14("14 Advanced"),
    ADVANCED_15("15 Advanced"),

    UPPER_ADVANCED_16("16 Upper Advanced");


    private final String courseLevel;

    private CourseLevel(String courseLevel) {
        this.courseLevel = courseLevel;
    }

    public String getCourseLevel(){
        return this.courseLevel;
    }

    /**
     * gets only first part of the name e.g 10 Upper Intermediate will get Upper
     * @return
     */
    public String getCourseLevelName(){
        /* this is better ...
        String levelName = "";
        String [] levelNames =  this.courseLevel.split(" ");
        int count = -1;
        for(String item : levelNames){
            count++;
            if(count != 1)   // remove number
                levelName = levelName + item;
        }*/
        return this.courseLevel.split(" ")[1];
    }

    public String getCourseLevelNumber(){
        return this.courseLevel.split("")[0];
    }

    private static final Logger logger = LoggerFactory.getLogger(CourseLevel.class);

}
