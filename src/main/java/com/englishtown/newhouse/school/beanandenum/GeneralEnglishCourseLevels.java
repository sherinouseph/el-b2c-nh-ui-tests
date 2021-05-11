package com.englishtown.newhouse.school.beanandenum;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum GeneralEnglishCourseLevels {

    BEGINNERS_1(0),
    BEGINNERS_2(1),
    BEGINNERS_3(2),

    ELEMENTARY_4(3),
    ELEMENTARY_5(4),
    ELEMENTARY_6(5),

    INTERMEDIATE_7(6),
    INTERMEDIATE_8(7),
    INTERMEDIATE_9(8),

    UPPER_INTERMEDIATE_10(9),
    UPPER_INTERMEDIATE_11(10),
    UPPER_INTERMEDIATE_12(11),

    ADVANCED_13(12),
    ADVANCED_14(13),
    ADVANCED_15(14),

    UPPER_ADVANCED_16(15);








    private static final Logger logger = LoggerFactory.getLogger(GeneralEnglishCourseLevels.class);


    private final int levelNumber ;


    GeneralEnglishCourseLevels(int levelNumber) {

     this.levelNumber=levelNumber;
    }




    public int getLevelNumber() {
        return levelNumber;
    }





}
