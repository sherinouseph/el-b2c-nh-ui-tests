package com.englishtown.newhouse.school.beanandenum;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum GenderChatProfile {

    MALE(0,"Male"),
    FEMALE(1,"Female"),
    EVERYONE(2,"Everyone");


    private static final Logger logger = LoggerFactory.getLogger(GenderChatProfile.class);

    private final int index ;
    private final String gender;


    GenderChatProfile(int index,String gender) {
        this.index = index;
        this.gender = gender;

    }

    public int getIndex() {
        return index;
    }

    public String getGender() {
        return gender;
    }


}
