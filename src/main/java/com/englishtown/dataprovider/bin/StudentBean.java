package com.englishtown.dataprovider.bin;
/**
 * Student
 *
 *
 * Nikol Dec 2017
 */

import com.englishtown.enumpack.Channel;
import com.englishtown.newhouse.school.beanandenum.enums.Enroll;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

public class StudentBean implements Serializable {
    private static final Logger logger = LoggerFactory.getLogger(StudentBean.class);

    protected String userEmail;
    protected String user_id;    // EFId
    protected String uuid;
    protected String student_level_name = "BEGINNER";     // default level name Beginner
    protected Enroll enroll;
    protected String student_level_id = "3";                // default level 1
    protected String student_level_code = "01";
    protected String student_current_unit = "Unit 1";    // Unit 1-6 unit-navigator
    protected int studentLessonNumber = 3;
    protected String student_id;
    protected String account_id;
    protected String isEnrolled = "false";   // defaults
    protected String isPatched  = "false";
    protected String school_id  = "b2c.englishlive";
    protected String businessUnit = "b2c";
    protected String country = "GB";
    protected String offer_id ="32282";
    protected String order_id ; //>0
    protected String lang = "EN";
    protected String channel = "channel";
    protected String motivation_id = "2";
    protected String leadType = "2";
    protected String telephoneNumber;

    protected String etag = "goes";
    protected String ptn = "MKGE";  //partner
    protected String xefaccess;

    // extra info
    protected String hasOffersTransactionId = "hasOffersTransactionIdTest";
    protected String googleClickId = "googleClickIdTest";
    protected String marinClickId  = "marinClickId";
    protected String utmSource     = "utmSourceTest";
    protected String utmMedium     = "utmMediumTest";
    protected String utmCampaign   = "utmCampaignTest";
    protected String utmTerm       = "utmTermTest";
    protected String utmContent    = "utmContentTest";
    protected String utmAdGroup    = "utmAdGroupTest";
    protected String referredBy    = "3";  // int
    protected String referredFrom  = "SherinAndNMTest";


    public StudentBean(){};

    public StudentBean(String country, String lang, String offer_id, Channel channel){
        this.country = country;
        this.lang = lang;
        this.offer_id = offer_id;
        this.channel = channel.getChannel();
        toString();
    }

    public StudentBean(String userEmail, String user_id, String student_level_name, String student_level_id, String student_level_code,
                       String student_current_unit, int studentLessonNumber, String student_id,
                       String account_id, String isEnrolled, String isPatched, String country, String offer_id, String order_id) {
        this.userEmail = userEmail;
        this.user_id = user_id;
        this.student_level_name = student_level_name;
        this.student_level_id = student_level_id;
        this.student_level_code = student_level_code;
        this.student_current_unit = student_current_unit;
        this.studentLessonNumber = studentLessonNumber;
        this.student_id = student_id;
        this.account_id = account_id;
        this.isEnrolled = isEnrolled;
        this.isPatched = isPatched;
        this.country = country;
        this.offer_id = offer_id;
        this.order_id = order_id;
    }

    public StudentBean(String userEmail, String user_id, String uuid, String student_id, String account_id, String isEnrolled,
                       String isPatched, String school_id, String businessUnit) {
        this.userEmail = userEmail;
        this.user_id = user_id;
        this.student_id = student_id;
        this.account_id = account_id;
        this.isEnrolled = isEnrolled;
        this.isPatched  = isPatched;
        this.school_id  = school_id;
        this.businessUnit = businessUnit;
        this.uuid = uuid;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getStudent_level_name() {
        return student_level_name;
    }

    public void setStudent_level_name(String student_level_name) {
        this.student_level_name = student_level_name;
    }

    public String getStudent_level_id() {
        return student_level_id;
    }

    public void setStudent_level_id(String student_level_id) {
        this.student_level_id = student_level_id;
    }

    public String getStudent_current_unit() {
        return student_current_unit;
    }

    public void setStudent_current_unit(String student_current_unit) {
        this.student_current_unit = student_current_unit;
    }

    public int getStudentLessonNumber() {
        return studentLessonNumber;
    }

    public void setStudentLessonNumber(int studentLessonNumber) {
        this.studentLessonNumber = studentLessonNumber;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getAccount_id() {
        return account_id;
    }

    public void setAccount_id(String account_id) {
        this.account_id = account_id;
    }

    public String getIsEnrolled() {
        return isEnrolled;
    }

    public void setIsEnrolled(String isEnrolled) {
        this.isEnrolled = isEnrolled;
    }

    public String getIsPatched() {
        return isPatched;
    }

    public void setIsPatched(String isPatched) {
        this.isPatched = isPatched;
    }

    public String getBusinessUnit() {
        return businessUnit;
    }

    public void setBusinessUnit(String businessUnit) {
        this.businessUnit = businessUnit;
    }

    public String getSchool_id() {
        return school_id;
    }

    public void setSchool_id(String school_id) {
        this.school_id = school_id;
    }


    public String getStudent_level_code() {
        return student_level_code;
    }

    public void setStudent_level_code(String student_level_code) {
        this.student_level_code = student_level_code;
    }


    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getOffer_id() {
        return offer_id;
    }

    public void setOffer_id(String offer_id) {
        logger.info("setOffer_id [{}]", offer_id);
        this.offer_id = offer_id;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }


    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }


    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }
    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }


    public String getEtag() {
        return etag;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }

    public String getPtn() {
        return ptn;
    }

    public void setPtn(String ptn) {
        this.ptn = ptn;
    }


    public String getHasOffersTransactionId() {
        return hasOffersTransactionId;
    }

    public void setHasOffersTransactionId(String hasOffersTransactionId) {
        this.hasOffersTransactionId = hasOffersTransactionId;
    }

    public String getGoogleClickId() {
        return googleClickId;
    }

    public void setGoogleClickId(String googleClickId) {
        this.googleClickId = googleClickId;
    }

    public String getMarinClickId() {
        return marinClickId;
    }

    public void setMarinClickId(String marinClickId) {
        this.marinClickId = marinClickId;
    }

    public String getUtmSource() {
        return utmSource;
    }

    public void setUtmSource(String utmSource) {
        this.utmSource = utmSource;
    }

    public String getUtmMedium() {
        return utmMedium;
    }

    public void setUtmMedium(String utmMedium) {
        this.utmMedium = utmMedium;
    }

    public String getUtmCampaign() {
        return utmCampaign;
    }

    public void setUtmCampaign(String utmCampaign) {
        this.utmCampaign = utmCampaign;
    }

    public String getUtmTerm() {
        return utmTerm;
    }

    public void setUtmTerm(String utmTerm) {
        this.utmTerm = utmTerm;
    }

    public String getUtmContent() {
        return utmContent;
    }

    public void setUtmContent(String utmContent) {
        this.utmContent = utmContent;
    }

    public String getUtmAdGroup() {
        return utmAdGroup;
    }

    public void setUtmAdGroup(String utmAdGroup) {
        this.utmAdGroup = utmAdGroup;
    }

    public String getReferredBy() {
        return referredBy;
    }

    public void setReferredBy(String referredBy) {
        this.referredBy = referredBy;
    }

    public String getReferredFrom() {
        return referredFrom;
    }

    public void setReferredFrom(String referredFrom) {
        this.referredFrom = referredFrom;
    }

    public String getLeadType() {
        return leadType;
    }

    public void setLeadType(String leadType) {
        this.leadType = leadType;
    }

    public Enroll getEnroll() {
        return enroll;
    }

    public void setEnroll(Enroll enroll) {
        this.enroll = enroll;
    }

    @Override
    public String toString() {
        return "StudentBean{" +
                "userEmail='" + userEmail + '\'' +
                ", user_id='" + user_id + '\'' +
                ", uuid='" + uuid + '\'' +
                ", student_level_name='" + student_level_name + '\'' +
                ", enroll='" + enroll + '\'' +
                ", student_level_id='" + student_level_id + '\'' +
                ", student_level_code='" + student_level_code + '\'' +
                ", student_current_unit='" + student_current_unit + '\'' +
                ", studentLessonNumber=" + studentLessonNumber +
                ", student_id='" + student_id + '\'' +
                ", account_id='" + account_id + '\'' +
                ", isEnrolled='" + isEnrolled + '\'' +
                ", isPatched='" + isPatched + '\'' +
                ", school_id='" + school_id + '\'' +
                ", businessUnit='" + businessUnit + '\'' +
                ", country='" + country + '\'' +
                ", offer_id='" + offer_id + '\'' +
                ", order_id='" + order_id + '\'' +
                ", lang='" + lang + '\'' +
                ", channel='" + channel + '\'' +
                ", motivation_id='" + motivation_id + '\'' +
                ", etag='" + etag + '\'' +
                ", ptn='" + ptn + '\'' +
                ", hasOffersTransactionId='" + hasOffersTransactionId + '\'' +
                ", googleClickId='" + googleClickId + '\'' +
                ", marinClickId='" + marinClickId + '\'' +
                ", utmSource='" + utmSource + '\'' +
                ", utmMedium='" + utmMedium + '\'' +
                ", utmCampaign='" + utmCampaign + '\'' +
                ", utmTerm='" + utmTerm + '\'' +
                ", utmContent='" + utmContent + '\'' +
                ", utmAdGroup='" + utmAdGroup + '\'' +
                ", referredBy='" + referredBy + '\'' +
                ", referredFrom='" + referredFrom + '\'' +
                ", xefaccess='" + xefaccess + '\'' +
                '}';
    }

    /*public String toString() {
        String sFormat = "%1$-25s %2$-25s";
        String s = "\n***********************************************************************\n";
        s = s + String.format(sFormat,  "\nuserEmail :", getUserEmail() );
        s = s + String.format(sFormat,  "\nuser_id :", getUser_id()) ;
        s = s + String.format(sFormat,  "\nuuid :", getUuid() );
        s = s + String.format(sFormat,  "\nstudent_level_name :", getStudent_level_name()) ;
        s = s + String.format(sFormat,  "\nstudent_level_id :", getStudent_level_id()) ;
        s = s + String.format(sFormat,  "\nstudent_level_code :", getStudent_level_code() );
        s = s + String.format(sFormat,  "\nstudent_current_unit :", getStudent_current_unit() );
        s = s + String.format(sFormat,  "\nstudentLessonNumber :", getStudentLessonNumber()) ;
        s = s + String.format(sFormat,  "\nstudent_id :", getStudent_id() );
        s = s + String.format(sFormat,  "\naccount_id :", getAccount_id() );
        s = s + String.format(sFormat,  "\nisEnrolled :", getIsEnrolled() );
        s = s + String.format(sFormat,  "\nisPatched :", getIsPatched() );
        s = s + String.format(sFormat,  "\nschool_id :", getSchool_id() );
        s = s + String.format(sFormat,  "\nibusinessUnit :", getBusinessUnit() );
        s = s + String.format(sFormat,  "\ncountry :", getCountry() );
        s = s + String.format(sFormat,  "\noffer_id :", getOffer_id() );
        s = s + String.format(sFormat,  "\norder_id :", getOrder_id() );
        s = s + String.format(sFormat,  "\nlang :", getLang() );
        s = s + String.format(sFormat,  "\nmotivation_id :", getMotivation_id() );
        s = s + String.format(sFormat,  "\netag :", getEtag() );
        s = s + String.format(sFormat,  "\nptn :", getPtn() );
        s = s + "\n***********************************************************************\n";
        return s;
    }*/

    public void print(){
        logger.info(this.toString());
    }


    public String getMotivation_id() {
        return motivation_id;
    }

    public void setMotivation_id(String motivation_id) {
        this.motivation_id = motivation_id;
    }


    public String getXefaccess() {
        return xefaccess;
    }

    public void setXefaccess(String xefaccess) {
        this.xefaccess = xefaccess;
    }




}


/** LEVEL
 "levelCode": null,
 "id": 1,
 "code": "Test your English",
 "name": "I'm not sure I want to take a placement test(20 minutes).",
 "descr": "This test result
 */