package com.englishtown.dataprovider.bin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by nikol.marku on 19 Sept 2017
 *
 * Lead bean is used to set the data for the lead used to be posted to EF services
 *
 */

// TODO when needed

public class LeadBean {
    private static final Logger logger = LoggerFactory.getLogger(LeadBean.class);

    private String LeadId;
    private String LeadType;
    private String InsertDate;
    private String UpdateDate;
    private String FirstName;
    private String LastName;
    private String Email;
    private String Country;
    private String Partner;
    private String Language;
    private String GAClientId;
    private boolean SubscribeToPartnerPromo;
    private boolean SubscribeToDailyLesson;
    private boolean SubscribeToMarketCampaign;
    private boolean SubscribeToStudyPlanEmail;



    public LeadBean(){

    }

    public LeadBean(String leadId){
        this.LeadId = leadId;
    }

    public void print(){
        logger.info(this.toString());
    }

    @Override
    public String toString() {
        return "LeadBean{" +
                "LeadId='" + LeadId + '\'' +
                ", LeadType='" + LeadType + '\'' +
                ", InsertDate='" + InsertDate + '\'' +
                ", UpdateDate='" + UpdateDate + '\'' +
                ", FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", Email='" + Email + '\'' +
                ", Country='" + Country + '\'' +
                ", Partner='" + Partner + '\'' +
                ", Language='" + Language + '\'' +
                ", GAClientId='" + GAClientId + '\'' +
                ", SubscribeToPartnerPromo=" + SubscribeToPartnerPromo +
                ", SubscribeToDailyLesson=" + SubscribeToDailyLesson +
                ", SubscribeToMarketCampaign=" + SubscribeToMarketCampaign +
                ", SubscribeToStudyPlanEmail=" + SubscribeToStudyPlanEmail +
                '}';
    }

    public String getLeadId() {
        return LeadId;
    }

    public void setLeadId(String leadId) {
        LeadId = leadId;
    }

    public String getLeadType() {
        return LeadType;
    }

    public void setLeadType(String leadType) {
        LeadType = leadType;
    }

    public String getInsertDate() {
        return InsertDate;
    }

    public void setInsertDate(String insertDate) {
        InsertDate = insertDate;
    }

    public String getUpdateDate() {
        return UpdateDate;
    }

    public void setUpdateDate(String updateDate) {
        UpdateDate = updateDate;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getPartner() {
        return Partner;
    }

    public void setPartner(String partner) {
        Partner = partner;
    }

    public String getLanguage() {
        return Language;
    }

    public void setLanguage(String language) {
        Language = language;
    }

    public String getGAClientId() {
        return GAClientId;
    }

    public void setGAClientId(String GAClientId) {
        this.GAClientId = GAClientId;
    }

    public boolean isSubscribeToPartnerPromo() {
        return SubscribeToPartnerPromo;
    }

    public void setSubscribeToPartnerPromo(boolean subscribeToPartnerPromo) {
        SubscribeToPartnerPromo = subscribeToPartnerPromo;
    }

    public boolean isSubscribeToDailyLesson() {
        return SubscribeToDailyLesson;
    }

    public void setSubscribeToDailyLesson(boolean subscribeToDailyLesson) {
        SubscribeToDailyLesson = subscribeToDailyLesson;
    }

    public boolean isSubscribeToMarketCampaign() {
        return SubscribeToMarketCampaign;
    }

    public void setSubscribeToMarketCampaign(boolean subscribeToMarketCampaign) {
        SubscribeToMarketCampaign = subscribeToMarketCampaign;
    }

    public boolean isSubscribeToStudyPlanEmail() {
        return SubscribeToStudyPlanEmail;
    }

    public void setSubscribeToStudyPlanEmail(boolean subscribeToStudyPlanEmail) {
        SubscribeToStudyPlanEmail = subscribeToStudyPlanEmail;
    }


}
