package com.englishtown.newhouse.school.beanandenum;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum TravelCourseLevels {

    TRV_TRAVELENGLISH(0);






    private static final Logger logger = LoggerFactory.getLogger(TravelCourseLevels.class);


    private final int levelNumber ;


    TravelCourseLevels(int levelNumber) {

     this.levelNumber=levelNumber;
    }




    public int getLevelNumber() {
        return levelNumber;
    }





}
