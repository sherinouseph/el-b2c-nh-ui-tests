package com.englishtown.newhouse.school.beanandenum.bean;

import com.englishtown.enumpack.Language;
import com.englishtown.newhouse.school.beanandenum.SchoolStudentBean;
import com.englishtown.newhouse.school.beanandenum.enums.PrivacySetting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Nikol 2018
 * emails setting and profile setting
 *
 */

public class StudentProfileSettingBean extends SchoolStudentBean {
    private static final Logger logger = LoggerFactory.getLogger(SchoolStudentBean.class);

    // privacy settings
    private PrivacySetting profileStatus;           // same as below 3 stings but with des
    private PrivacySetting profileViewableBy;
    private PrivacySetting profileChatAccessContact;
    private boolean isShowAsOnlineByDefault;         //  displayProfileStatus;
    private boolean isProfileViewableByEveryone;     //  profileViewableBy;      canProfileViewableByEveryone
    private boolean isReceiveMessageFromEveryone;    //  chatAccessibilityBy  CanReceiveMessageFromEveryone
    // emails
    private String emailLanguage;
    private boolean isMotivationEmails;
    private boolean isUpdatesAndSpecialOffers;
    private boolean isDailyEnglishLesson;
    private boolean isNotificationOnSchooltips;
    private boolean isNotificationOnNews;



    public StudentProfileSettingBean() {
        super();
    }

    public StudentProfileSettingBean(String userEmail, String user_id, String levelName, int levelNumber, int unitNumber,
                                     int lessonNumber,int stepNumber, String country, Language lang,
                                     int noOfCompletedLessons, int noOfCompletedSteps, String step1Status,
                                     String step2Status,String step3Status,String step4Status) {
        super( userEmail, user_id, levelName, levelNumber, unitNumber,
        lessonNumber, stepNumber, country, lang, noOfCompletedLessons,
        noOfCompletedSteps, step1Status, step2Status, step3Status, step4Status);
    }





    public String getEmailLanguage() {
        return emailLanguage;
    }

    public void setEmailLanguage(String emailLanguage) {
        this.emailLanguage = emailLanguage;
    }

    public boolean isShowAsOnlineByDefault() {
        return isShowAsOnlineByDefault;
    }

    public void setShowAsOnlineByDefault(boolean showAsOnlineByDefault) {
        isShowAsOnlineByDefault = showAsOnlineByDefault;
    }

    public boolean isProfileViewableByEveryone() {
        return isProfileViewableByEveryone;
    }

    public void setProfileViewableByEveryone(boolean profileViewableByEveryone) {
        isProfileViewableByEveryone = profileViewableByEveryone;
    }

    public boolean isReceiveMessageFromEveryone() {
        return isReceiveMessageFromEveryone;
    }

    public void setReceiveMessageFromEveryone(boolean receiveMessageFromEveryone) {
        isReceiveMessageFromEveryone = receiveMessageFromEveryone;
    }

    public boolean isMotivationEmails() {
        return isMotivationEmails;
    }

    public void setMotivationEmails(boolean motivationEmails) {
        isMotivationEmails = motivationEmails;
    }

    public boolean isUpdatesAndSpecialOffers() {
        return isUpdatesAndSpecialOffers;
    }

    public void setUpdatesAndSpecialOffers(boolean updatesAndSpecialOffers) {
        isUpdatesAndSpecialOffers = updatesAndSpecialOffers;
    }

    public boolean isDailyEnglishLesson() {
        return isDailyEnglishLesson;
    }

    public void setDailyEnglishLesson(boolean dailyEnglishLesson) {
        isDailyEnglishLesson = dailyEnglishLesson;
    }

    public boolean isNotificationOnNews() {
        return isNotificationOnNews;
    }

       public void setNotificationOnNews(boolean notificationOnNews) {
        isNotificationOnNews = notificationOnNews;
    }

    public boolean isNotificationOnSchooltips() {
        return isNotificationOnSchooltips;
    }

    public void setOnboardingAndSchooltips(boolean isNotificationOnSchooltip) {
        isNotificationOnSchooltips = isNotificationOnSchooltip;
    }

    @Override
    public String toString() {
        return super.toString()+"\n"+"StudentProfileSettingBean{" +
                ", isCoachingEmails=" + isMotivationEmails +
                ", isUpdatesAndSpecialOffers=" + isUpdatesAndSpecialOffers +
                ", isDailyEnglishLesson=" + isDailyEnglishLesson +
                ", isNotificationOnNewMessage=" + isNotificationOnNews +
                ", isNotificationOnSchooltips=" + isNotificationOnSchooltips +
                '}';
    }
}
