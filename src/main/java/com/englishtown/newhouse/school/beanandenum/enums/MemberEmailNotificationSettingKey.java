package com.englishtown.newhouse.school.beanandenum.enums;
/**
 * Nikol 2018 Oct
 *
 * Api call
 *   *     {"SubscribeToStudyPlanEmail":true}
 *      *  {"SubscribeToMarketCampaign":true}
 *      *  {"SubscribeToDailyLesson":true}
 *      *  {"SubscribeToPartnerPromo":true}
 *
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum MemberEmailNotificationSettingKey {

    SUBSCRIBE_TO_STUDYPLAN_TRUE ("SubscribeToStudyPlanEmail", true),
    SUBSCRIBE_TO_STUDYPLAN_FALSE("SubscribeToStudyPlanEmail", false),
    SUBSCRIBE_TO_MARKETCAMPAIGN_TRUE("SubscribeToMarketCampaign", true),
    SUBSCRIBE_TO_MARKETCAMPAIGN_FALSE("SubscribeToMarketCampaign", false),
    SUBSCRIBE_TO_DAILYLESSON_TRUE("SubscribeToDailyLesson", true),
    SUBSCRIBE_TO_DAILYLESSON_FALSE("SubscribeToDailyLesson", false),
    SUBSCRIBE_TO_PARTNERPROMO_TRUE("SubscribeToPartnerPromo", true),
    SUBSCRIBE_TO_PARTNERPOROMO_FALSE("SubscribeToPartnerPromo", false);

    private final String key;
    private final boolean value;

    private MemberEmailNotificationSettingKey(String key, boolean value) {
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
