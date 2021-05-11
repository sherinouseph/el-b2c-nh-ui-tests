package com.englishtown.enumpack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum MyMonth {

    DEFAULT(0),
    JANUARY(1),
    FEBRUARY(2),
    MARCH(3),
    APRIL(4),
    MAY(5),
    JUNE(6),
    JULY(7),
    AUGUST(8),
    SEPTEMBER(9),
    OCTOBER(10),
    NOVEMBER(11),
    DECEMBER(12);


    private final int monthIndex; // start at 1

    private MyMonth(int monthIndex) {
        this.monthIndex = monthIndex;
    }

    public int getMonthIndex(){
        return this.monthIndex;
    }

    private static final Logger logger = LoggerFactory.getLogger(MyMonth.class);

}
