package com.englishtown.newhouse.school.beanandenum.enums;
/**
 * Nikol 2018 Oct
 *
 * Api call
 *  * {"settings":[{"key":"is_notify_im","value":true}]}     NEW MESSAGE
 *      * {"settings":[{"key":"is_friend_request","value":true}]}
 *      * {"settings":[{"key":"enable_study_notification","value":true}]}
 *
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum ChatNotificationSettingKey {

    NOTIFY_NEWMESSAGE_TRUE ("is_notify_im", true),
    NOTIFY_NEWMESSAGE_FALSE("is_notify_im", false),
    NOTIFY_FRIENDREQUEST_TRUE("is_friend_request", true),
    NOTIFY_FRIENDREQUEST_FALSE("is_friend_request", false);
    //NOTIFY_STUDYNOTIFICATION_TRUE("enable_study_notification", true),
    //NOTIFY_STUDYNOTIFICATION_FALSE("enable_study_notification", false);


    private final String key;
    private final boolean value;

    private ChatNotificationSettingKey(String key, boolean value) {
        this.key = key;
        this.value = value;
    }

    public String getKey(){
        return this.key;
    }

    public boolean getValue() {
        return value;
    }

    private static final Logger logger = LoggerFactory.getLogger(MemberEmailNotificationSettingKey.class);

}
