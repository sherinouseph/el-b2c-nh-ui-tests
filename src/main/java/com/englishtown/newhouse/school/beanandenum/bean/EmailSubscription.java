package com.englishtown.newhouse.school.beanandenum.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
//import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/*
@JsonFormat(shape=JsonFormat.Shape.ARRAY)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonRootName("emailSubscriptions")*/
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmailSubscription implements JsonResponse {

    @JsonProperty("SubscribeToPartnerPromo")
    boolean isSubscribeToPartnerPromo;
    @JsonProperty("SubscribeToDailyLesson")
    boolean isSubscribeToDailyLesson;
    @JsonProperty("SubscribeToMarketCampaign")
    boolean isSubscribeToMarketCampaign;
    @JsonProperty("SubscribeToStudyPlanEmail")
    boolean isSubscribeToStudyPlanEmail;

    public EmailSubscription(){};

    public EmailSubscription(boolean isSubscribeToPartnerPromo, boolean isSubscribeToDailyLesson, boolean isSubscribeToMarketCampaign, boolean isSubscribeToStudyPlanEmail) {
        this.isSubscribeToPartnerPromo = isSubscribeToPartnerPromo;
        this.isSubscribeToDailyLesson = isSubscribeToDailyLesson;
        this.isSubscribeToMarketCampaign = isSubscribeToMarketCampaign;
        this.isSubscribeToStudyPlanEmail = isSubscribeToStudyPlanEmail;
    }

    @Override
    public String toString() {
        return "\nEmailSubscription{" +
                "\nisSubscribeToPartnerPromo=" + isSubscribeToPartnerPromo +
                ", \nSubscribeToDailyLesson=" + isSubscribeToDailyLesson +
                ", \nisSubscribeToMarketCampaign=" + isSubscribeToMarketCampaign +
                ", \nisSubscribeToStudyPlanEmail=" + isSubscribeToStudyPlanEmail +
                "\n}";
    }

    public boolean isSubscribeToPartnerPromo() {
        return isSubscribeToPartnerPromo;
    }

    public void setSubscribeToPartnerPromo(boolean subscribeToPartnerPromo) {
        isSubscribeToPartnerPromo = subscribeToPartnerPromo;
    }

    public boolean isSubscribeToDailyLesson() {
        return isSubscribeToDailyLesson;
    }

    public void setSubscribeToDailyLesson(boolean subscribeToDailyLesson) {
        isSubscribeToDailyLesson = subscribeToDailyLesson;
    }

    public boolean isSubscribeToMarketCampaign() {
        return isSubscribeToMarketCampaign;
    }

    public void setSubscribeToMarketCampaign(boolean subscribeToMarketCampaign) {
        isSubscribeToMarketCampaign = subscribeToMarketCampaign;
    }

    public boolean isSubscribeToStudyPlanEmail() {
        return isSubscribeToStudyPlanEmail;
    }

    public void setSubscribeToStudyPlanEmail(boolean subscribeToStudyPlanEmail) {
        isSubscribeToStudyPlanEmail = subscribeToStudyPlanEmail;
    }

}


/**
 BlogListDTO retrievedBlogs = given()
 .spec(spec)
 .when()
 .get("blogs")
 .then()
 .statusCode(200)
 .extract().as(BlogListDTO.class);
 **/