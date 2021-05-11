package com.englishtown.newhouse.school.beanandenum.enums;
/**
 * nikol 2018 May
 *
 * model [AVATAR, STATUS, NAME, FLAG]
 *
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum ContactCardDetails {

    AVATAR(0),
    STATUS(1),
    NAME(2), // FULL NAME
    FLAG(3);


    private static final Logger logger = LoggerFactory.getLogger(ContactCardDetails.class);
    private final int id ;

    ContactCardDetails(int id) {
        this.id = id;
    }


    public int getId() {
        return id;
    }



}
