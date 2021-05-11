package com.englishtown.newhouse.school.beanandenum.enums;
/**
 * Nikol 2019 Feb
 *
 * Api call
 *Request URL: https://qa-englishlive.ef.com/1/api/student-settings/v1/student/settings/studyplan
 * Request Method: PUT
 * Status Code: 201 Created
 *
 * {"settings":[{"key":"email","value":{"isSubscribed":false}}]}
 *
 * Request URL: https://qa-englishlive.ef.com/1/api/student-settings/v1/student/settings/notification-preferences
 * Request Method: PUT
 * Status Code: 201 Created
 *
 * {"settings":[{"key":"enable_study_notification","value":false}]}
 *
 * {"settings":[{"key":"email","value":{"isSubscribed":false}}]}
 * {"settings":[{"key":"enable_study_notification","value":false}]}
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum StudentSettings {

    STUDENT_SETTINGS_STUDYPLAN_TRUE ("studyplan", "email", true),
    STUDENT_SETTINGS_STUDYPLAN_FASLE ("studyplan", "email", false),
    STUDENT_SETTINGS_NOTIFICATION_PREFERENCES_TRUE ("notification-preferences", "enable_study_notification", true),
    STUDENT_SETTINGS_NOTIFICATION_PREFERENCES_FASLE ("notification-preferences", "enable_study_notification", false);


    private final String group;
    private final String key;
    private final boolean value;

    private StudentSettings(String group, String key, boolean value) {
        this.group = group;
        this.key = key;
        this.value = value;
    }

    public String getGroup(){
        return this.group;
    }

    public String getKey(){
        return this.key;
    }

    public boolean getValue() {
        return value;
    }

    private static final Logger logger = LoggerFactory.getLogger(StudentSettings.class);


}
