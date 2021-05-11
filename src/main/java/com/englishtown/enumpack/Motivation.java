package com.englishtown.enumpack;
/**
 *  General English ...
 "id": 2,
 "code": "career",
 *
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum Motivation {
         // ID | CODE
    CAREER(2,"career"),
    TRAVELING(3,"traveling"),
    TEST(4,"test"),
    DEVELOPMENT(5,"development"),
    ANOTHER(6,"another");

    private final int id;
    private final String code;


    public int getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    Motivation(int id, String code){
        this.id = id;
        this.code = code;
    }

    private static final Logger logger = LoggerFactory.getLogger(Motivation.class);

}
