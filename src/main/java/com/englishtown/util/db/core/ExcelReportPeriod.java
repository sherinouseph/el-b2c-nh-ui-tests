package com.englishtown.util.db.core;

/**
 * Created by nikol.marku on 17/11/2015.
 */
public enum ExcelReportPeriod {
    LAST_DAY("LAST_DAY"),
    LAST_WEEK("LAST_WEEK"),
    LAST_MONTH("LAST_MONTH"),
    LAST_THREE_MONTHS("LAST_THREE_MONTHS"),
    LAST_SIX_MONTHS("LAST_THREE_MONTHS"),
    LAST_YEAR("LAST_YEAR");

    private final String period;

    private ExcelReportPeriod(String period) {
            this.period= period;
    }

    public String getPeriod(){
            return period;
        }
}
