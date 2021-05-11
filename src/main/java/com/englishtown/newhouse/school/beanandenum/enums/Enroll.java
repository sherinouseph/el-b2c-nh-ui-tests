package com.englishtown.newhouse.school.beanandenum.enums;
/**
 * nikol 2018 Nov
 * Enroll Api call
 *
 *  ("id": "0", "code": "Test",               "levelNo" : "0",  "levelTemplateId" : "0" ),
 *  ("id": "1", "code": "Beginner",           "levelNo" : "01", "levelTemplateId" : "20000507"),
 *  ("id": "2", "code": "Elementary",         "levelNo" : "04", "levelTemplateId" : "20000526"),
 *  ("id": "3", "code": "Intermediate",       "levelNo" : "07", "levelTemplateId" : "20000548"),
 *  ("id": "4", "code": "Upper Intermediate", "levelNo" : "10", "levelTemplateId" : "20000585"),
 *  ("id": "5", "code": "Advanced",           "levelNo" : "13", "levelTemplateId" : "20000608"),
 *  ("id": "6", "code": "Upper Advanced",     "levelNo" : "16", "levelTemplateId" : "20000611");
 *
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum Enroll {
    TEST               ("0", "Test",               "0",  "0" ),
    BEGINNER           ("1", "Beginner",           "01", "20000507"),
    ELEMENTARY         ("2", "Elementary",         "04", "20000526"),
    INTERMEDIATE       ("3", "Intermediate",       "07", "20000548"),
    UPPER_INTERMEDIATE ("4", "Upper Intermediate", "10", "20000585"),
    ADVANCED           ("5", "Advanced",           "13", "20000608"),
    UPPER_ADVANCED     ("6", "Upper Advanced",     "16", "20000611");

    //"id": "0", "code": "Test",  "levelNo" : "0",  "levelTemplateId" : "0"

    private static final Logger logger = LoggerFactory.getLogger(Enroll.class);

    private final String id;
    private final String code ;
    private final String levelNo;
    private final String levelTemplateId;

    Enroll(String id, String code, String levelNo, String levelTemplateId) {
        this.id = id;
        this.code = code;
        this.levelNo = levelNo;
        this.levelTemplateId = levelTemplateId;
    }

    public String getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getLevelNo() {
        return levelNo;
    }

    public String getLevelTemplateId() {
        return levelTemplateId;
    }
}
