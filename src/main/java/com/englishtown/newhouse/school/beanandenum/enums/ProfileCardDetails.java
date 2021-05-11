package com.englishtown.newhouse.school.beanandenum.enums;
/**
 * nikol 2018 May
 *
 * model
 English Level         Beginner
 Gender
 Age
 Living in             United Kingdom
 Native language
 Industry
 Chat accessibility    All
 *
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum ProfileCardDetails {

    ENGLISH_LEVEL(0),
    GENDER(1),
    AGE(2),
    LIVINGIN(3),
    NATIVELANGUAGE(4),
    INDUSTRY(5),
    CHAT_ACCESSIBILITY(6);


    private static final Logger logger = LoggerFactory.getLogger(ProfileCardDetails.class);
    private final int id ;

    ProfileCardDetails(int id) {
        this.id = id;
    }


    public int getId() {
        return id;
    }



}
