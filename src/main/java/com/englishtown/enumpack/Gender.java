package com.englishtown.enumpack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum Gender {

    DEFAULT("U"), //U
    MALE("M"),
    FEMALE("F");


    private final String gender;

    private Gender(String gender) {
        this.gender = gender;
    }

    public String getGender(){
        return this.gender;
    }

    private static final Logger logger = LoggerFactory.getLogger(Gender.class);


    public static Gender getGender(String genderIn){
        Gender gender = null;
        logger.info("genderin [{}]",genderIn);
        switch (genderIn){
            case "":
                gender = Gender.DEFAULT;
                break;

            case "Male":
                gender =  Gender.MALE;
                break;

            case "Female":
                gender =  Gender.FEMALE;
                break;

            default:
                logger.warn("Can not get gender from string [{}]", genderIn);
                break;
        }

        return gender;
    }

}
