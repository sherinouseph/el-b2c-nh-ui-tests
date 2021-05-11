package com.englishtown.newhouse.school.beanandenum;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum BusinessCourseLevels {

    BE_CORRESPONDENCE(0),
    BE_MANAGMENT(1),
    BE_MEETINGS(2),
    BE_NEGOTIATIONS(3),
    BE_PRESENTATIONS(4),
    BE_SOCIALSKILLS(5),
    BE_TELEPHONING(6),
    BE_PROJECTMANAGEMENT(7);







    private static final Logger logger = LoggerFactory.getLogger(BusinessCourseLevels.class);


    private final int levelNumber ;


    BusinessCourseLevels(int levelNumber) {

     this.levelNumber=levelNumber;
    }




    public int getLevelNumber() {
        return levelNumber;
    }





}
