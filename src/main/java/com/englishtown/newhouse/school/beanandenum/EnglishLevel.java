package com.englishtown.newhouse.school.beanandenum;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum EnglishLevel {

    BEGINNER(0,"Beginner"),
    INTERMEDIATE(1,"Intermediate"),
    ADVANCED(2,"Advanced");


    private static final Logger logger = LoggerFactory.getLogger(EnglishLevel.class);


    private final String englishLevelName;
    private final int englishLevelcode ;


    EnglishLevel(int englishLevelcode,String englishLevelName) {
        this.englishLevelName = englishLevelName;
        this.englishLevelcode = englishLevelcode;
    }


    public static Logger getLogger() {
        return logger;
    }

    public String getEnglishLevelName() {
        return englishLevelName;
    }

    public int getEnglishLevelcode() {
        return englishLevelcode;
    }
}
