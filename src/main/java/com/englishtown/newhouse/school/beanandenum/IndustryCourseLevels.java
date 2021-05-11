package com.englishtown.newhouse.school.beanandenum;

//level number here is the code to get the selectors of each levels in a course
//level number=0,means the test which is using this enum should use the LEVEL named "automotive"

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum IndustryCourseLevels {

    IND_AUTOMOTIVE(0),
    IND_BANKINGANDFINANCE(1),
    IND_CONSTRUCTION(2),
    IND_SCIENCES(3),
    IND_HOSPITALITY(4),
    IND_INSURANCE(5),
    IND_IT(6),
    IND_LAW(7),
    IND_LOGISTICS(8),
    IND_MEDICAL(9),
    IND_OFFICE(10),
    IND_OIL(11),
    IND_PHARMACY(12),
    IND_SOCIETYANDLEISURE(13),
    IND_TELECOMMUNICATIONS(14),
    IND_TRAVEL(15),
    IND_RESEARCH(16);


    private static final Logger logger = LoggerFactory.getLogger(IndustryCourseLevels.class);


    private final int levelNumber ;


    IndustryCourseLevels(int levelNumber) {

     this.levelNumber=levelNumber;
    }




    public int getLevelNumber() {
        return levelNumber;
    }





}
