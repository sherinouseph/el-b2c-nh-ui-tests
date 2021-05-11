package com.englishtown.enumpack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum DownloadAppType {

    PHONE_IOS(1),
    PHONE_ANDROID(2),
    TABLET_IOS(3),
    TABLET_ANDROID(4);

    private final int appTypeId;

    private DownloadAppType(int appTypeId) {
        this.appTypeId = appTypeId;
    }

    public int getAppTypeId(){
        return this.appTypeId;
    }

    private static final Logger logger = LoggerFactory.getLogger(DownloadAppType.class);

}
