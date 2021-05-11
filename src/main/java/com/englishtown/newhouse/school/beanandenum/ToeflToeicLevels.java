package com.englishtown.newhouse.school.beanandenum;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum ToeflToeicLevels {

    TT_TOEFL(0),
    TT_TOEIC(1);






    private static final Logger logger = LoggerFactory.getLogger(ToeflToeicLevels.class);


    private final int levelNumber ;


    ToeflToeicLevels(int levelNumber) {

     this.levelNumber=levelNumber;
    }




    public int getLevelNumber() {
        return levelNumber;
    }





}
