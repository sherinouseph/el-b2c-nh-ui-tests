package com.englishtown.newhouse.school.beanandenum.enums;
/**
 * Nikol 2018 Oct
 *
 * Api call to change privacy setting  https://qa-englishlive.ef.com/1/shared/api/user-settings/v1/users/settings/chat
 *  {settings: [{key: "chat_status", value: 5/1/4}]}
 *  {"settings":[{"key":"profile_privacy","value":"Public"}]}  {"settings":[{"key":"profile_privacy","value":"Friends"}]}
 *  {"settings":[{"key":"chat_privacy","value":"Public"}]}     {"settings":[{"key":"chat_privacy","value":"Friends"}]}
 *
 */

import com.englishtown.tests.core.BaseTest;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum ProfilePrivacySettingKey {

    CHAT_STATUS_1(1, "chat_status", "1"),   // 5-OFFLINE 4-BUSY  1-ONLINE
    CHAT_STATUS_4(4, "chat_status", "4"),
    CHAT_STATUS_5(5, "chat_status", "5"),
    PROFILE_PRIVACY_PULIC  (1, "profile_privacy", "Public"),  //"Public" "Friends"}
    PROFILE_PRIVACY_FRIENDS(2, "profile_privacy", "Friends"),
    CHAT_PRIVACY_PUBLIC    (1, "chat_privacy",    "Public"),        //"Public" "Friends"}
    CHAT_PRIVACY_FRIENDS   (2, "chat_privacy",    "Friends");

    private final int    id;
    private final String key;
    private final String value;

    private ProfilePrivacySettingKey(int id, String key, String value) {
        this.key = key;
        this.id = id;
        this.value = value;
    }

    public String getKey(){
        return this.key;
    }

    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    private static final Logger logger = LoggerFactory.getLogger(ProfilePrivacySettingKey.class);


}
