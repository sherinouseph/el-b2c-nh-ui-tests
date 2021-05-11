package com.englishtown.enumpack;
/**
 * After paying
 * before entering the school
 * YOUR MOTIVATION
 * YOUR LEVEL
 * START LEARNING
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum EnrollmentSteps {

    DEFAULT("0"),   // USER LAND ON THIS
    MOTIVATION("YOUR MOTIVATION"),
    LEVEL("YOUR LEVEL"),
    LEARNING("START LEARNING");

    private final String step;

    private EnrollmentSteps(String step) {
        this.step = step;
    }

    public String getStep(){
        return this.step;
    }

    private static final Logger logger = LoggerFactory.getLogger(EnrollmentSteps.class);

}
