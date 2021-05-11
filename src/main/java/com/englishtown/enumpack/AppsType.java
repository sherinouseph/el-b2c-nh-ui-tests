package com.englishtown.enumpack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum AppsType {

    ANDROID_PHONE("android_phone"),
    ANDROID_TABLET("android_tablet"),
    IOS_PHONE("ios_phone"),
    IOS_TABLET("ios_tablet");

    private final String appType;

    private AppsType(String appType) {
        this.appType = appType;
    }

    public String getAppType(){
        return this.appType;
    }

    private static final Logger logger = LoggerFactory.getLogger(AppsType.class);

}
