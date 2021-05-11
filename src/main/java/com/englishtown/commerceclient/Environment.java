package com.englishtown.commerceclient;

public enum Environment {
    Local,
    QA,
    Staging,
    UAT,
    Live,
    QA2;

    public static Environment getCurrentEnvironment(String envValue){
        switch(envValue){
            case "live":
                return Environment.Live;
            case "uat":
                return Environment.UAT;
            case "qa":
                return Environment.QA;
            case "qa2":
                return Environment.QA2;
            case "staging":
                return Environment.Staging;
            case "local":
                return Environment.Local;
            default:
                throw new IllegalArgumentException();
        }
    }


}
