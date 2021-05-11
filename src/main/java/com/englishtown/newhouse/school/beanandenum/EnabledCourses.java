package com.englishtown.newhouse.school.beanandenum;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum EnabledCourses {

    SPIN_TRUE_TOEFLTOEIC_TRUE(true,true),
    SPIN_FALSE_TOEFLTOEIC_FALSE(false,false),
    SPIN_TRUE_TOEFLTOEIC_FALSE(true,false),
    SPIN_FALSE_TOEFLTOEIC_TRUE(false,true);


    private static final Logger logger = LoggerFactory.getLogger(EnabledCourses.class);


    private final boolean isSpinCoursePresent;
    private final boolean isToeflToeicPresent;

    EnabledCourses(boolean isSpinCoursePresent, boolean isToeflToeicPresent) {

        this.isSpinCoursePresent = isSpinCoursePresent;
        this.isToeflToeicPresent    = isToeflToeicPresent;
    }

    public boolean getSpinCourseStatus() {
        return isSpinCoursePresent;
    }


    public boolean getToeflToeicPresent() {
        return isToeflToeicPresent;
    }





}
