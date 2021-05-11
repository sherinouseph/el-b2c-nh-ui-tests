package com.englishtown.newhouse.school.beanandenum.enums;
/**
 * Nikol 2018 Oct
 *
 * Privacy Setting [Appear Online, Appear Offline, Appear Busy, Everyone, Only my friends]
 *
 */

import com.englishtown.tests.core.BaseTest;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum PrivacySetting {

    EN_APPEAR_ONLINE_TRUE(true,             "Appear Online", 0),
    EN_APPEAR_OFFLINE_FALSE(false,          "Appear Offline", 1),
    EN_APPEAR_BUSY_FALSE(false,             "Appear Busy", 2),
    EN_PROFILE_VIEWABLE_EVERYONE(true,      "Everyone", 0),
    EN_PROFILE_VIEWABLE_ONLY_FRIENDS(false, "Only my friends", 1),
    EN_CHAT_ACCESS_EVERYONE(true,           "Everyone", 0),
    EN_CHAT_ACCESS_ONLY_FRIENDS(false,      "Only my friends", 1);

    // TR
    //APPEAR_ONLINE_TRUE(true,             "Çevrim İçi Görün", 0),
    /*APPEAR_ONLINE_TRUE(true,             "Online Görün", 0),
    //APPEAR_OFFLINE_FALSE(false,          "Çevrim Dışı Görün", 1),
    APPEAR_OFFLINE_FALSE(false,          "Çevrimdışı Görün", 1),
    APPEAR_BUSY_FALSE(false,             "Meşgul Görün", 2),
    PROFILE_VIEWABLE_EVERYONE(true,      "Herkes", 0),
    PROFILE_VIEWABLE_ONLY_FRIENDS(false, "Sadece arkadaşlarım", 1),
    CHAT_ACCESS_EVERYONE(true,           "Herkes", 0),
    CHAT_ACCESS_ONLY_FRIENDS(false,      "Sadece arkadaşlarım", 1);*/

    private final boolean status;
    private final String des;
    private final int id; // id of the select element to remove language

    private PrivacySetting(boolean status, String des, int id) {
        this.status = status;
        this.des = des;
        this.id = id;
    }

    public boolean getStatus(){
        return this.status;
    }

    public String getDes(){
        return this.des;
    }

    public int getId(){ return this.id; }

    private static final Logger logger = LoggerFactory.getLogger(PrivacySetting.class);

    public static PrivacySetting getFromDesString(String des) {
        logger.info("Get setting  from Des String ... [{}]", des);
        des = des.trim();

        for (PrivacySetting setting : PrivacySetting.values()) {
            if (StringUtils.equalsIgnoreCase(setting.des, des)) {
                logger.info("Returning match [{}]", setting);
                return setting;
            }
        }
        BaseTest.failTest("Can not get setting from String [" + des + "]");
        return null;
    }


}

//APPEAR_ONLINE_FALSE(false,  "Appear Online"),    //APPEAR_OFFLINE_TRUE(true,   "Appear Offline"), //APPEAR_BUSY_TRUE(true,   "Appear Busy"),