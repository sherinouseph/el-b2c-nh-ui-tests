package com.englishtown.enumpack;
/**
 *  General English ...
 "levelCode": "01",
 "id": 3,
 "code": "Beginner",
 "name": "I know almost no English.",
 "descr": "Hello"
 *
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum EnrollmentLevel {
    //levelCode | ID | CODE
    BEGINNERS("01", "3","Beginner"),
    Elementary("04", "4","Elementary"),
    INTERMEDIATE("07", "5","Intermediate"),
    UPPER_INTERMEDIATE("10", "6","Upper Intermediate"),
    ADVANCED("7", "13","Advanced"),
    UPPER_ADVANCED("16", "8","Upper Advanced");

    private final String levelCode;
    private final String id;
    private final String code;

    public String getLevelCode() {
        return levelCode;
    }

    public String getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    EnrollmentLevel(String levelCode, String id, String code){
        this.levelCode = levelCode;
        this.id = id;
        this.code = code;
    }

    private static final Logger logger = LoggerFactory.getLogger(EnrollmentLevel.class);

}
