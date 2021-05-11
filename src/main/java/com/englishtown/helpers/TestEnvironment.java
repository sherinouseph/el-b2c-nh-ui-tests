package com.englishtown.helpers;

/**
 * Created by nikol.marku on 10/02/2015.
 */

public enum TestEnvironment {
    Local("local"),
    QA("qa"),
    QA2("qa2"),
    Staging("staging"),
    UAT("uat"),
    Live("live"),
    EnglishLive("englishlive"),
    QA_ELIVE("qa-"),
    STAGING_ELIVE("stg-");

    private final String env;

    private TestEnvironment(String env) {
        this.env = env;
    }

    public String getEnv(){
        return env;
    }

    public TestEnvironment getCurrentEnumEnvironment(String env){
        switch(env){
            case "live":
                return TestEnvironment.Live;
            case "qa":
                return TestEnvironment.QA;
            case "qa2":
                return TestEnvironment.QA2;
            case "staging":
                return TestEnvironment.Staging;
            case "uat":
                return TestEnvironment.UAT;
            case "englishlive":
                return TestEnvironment.EnglishLive;
            case "qa-":
                return TestEnvironment.QA_ELIVE;
            case "stg-":
                return TestEnvironment.STAGING_ELIVE;
            case "local":
                return TestEnvironment.Local;
            default:
                throw new IllegalArgumentException();
        }
    }


}