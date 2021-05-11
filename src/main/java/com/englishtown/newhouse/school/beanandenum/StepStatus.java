package com.englishtown.newhouse.school.beanandenum;

//level number here is the code to get the selectors of each levels in a course
//level number=0,means the test which is using this enum should use the LEVEL named "automotive"

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum StepStatus {

    COMPLETED("Completed"),
    CONTINUE("continue"),
    START("start");



    private static final Logger logger = LoggerFactory.getLogger(StepStatus.class);


    private final String stepStatus ;


    StepStatus(String stepStatus) {

     this.stepStatus=stepStatus;
    }




    public String getStepStatus() {
        return stepStatus;
    }





}
