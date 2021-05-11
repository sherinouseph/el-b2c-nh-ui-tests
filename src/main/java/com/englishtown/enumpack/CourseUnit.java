package com.englishtown.enumpack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum CourseUnit {

    UNIT_1("Unit 1"),
    UNIT_2("Unit 2"),
    UNIT_3("Unit 3"),
    UNIT_4("Unit 4"),
    UNIT_5("Unit 5"),
    UNIT_6("Unit 6"),
    UNIT_1_TR("Ünite 1");

    private final String unitName;

    private CourseUnit(String unitName) {
        this.unitName = unitName;
    }

    public String getUnitName(){
        return this.unitName;
    }

    public String getUnitNameTxt(){
        return this.unitName.split(" ")[0];
    }

    public String getUnitNumber(){
        return this.unitName.split(" ")[1];
    }

    private static final Logger logger = LoggerFactory.getLogger(CourseUnit.class);

}
