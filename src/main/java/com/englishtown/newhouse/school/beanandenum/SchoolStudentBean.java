package com.englishtown.newhouse.school.beanandenum;
/**
 * Student
 *
 *
 *
 */

import com.englishtown.enumpack.Gender;
import com.englishtown.enumpack.Language;
import com.englishtown.enumpack.MyMonth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SchoolStudentBean {
    private static final Logger logger = LoggerFactory.getLogger(SchoolStudentBean.class);


    protected String userEmail; //email address or username
    protected String user_id;
    protected String country = "GB";
    //protected String lang = "EN";
    protected Language language;

    protected String firstName;
    protected String lastName;
    protected MyMonth birthdayMonth; // Jan-Dec
    protected String birthdayDate;     //30
    protected String birthDayYear;     // "1985"
    protected String currentPassword;
    protected String newPassword;      // change the password to this one
    protected String verifyPassword;
    protected Gender gender;  // Male Female  " "
    protected String mobilePhone;
    protected String homePhone;
    protected String billingAddress;
    protected String city;
    protected String postCode;


    protected String levelName ;           // default level name Beginner
    protected int levelNumber;                  // default level 1
    protected int unitNumber;
    protected int lessonNumber;
    protected int courseNumber;

    protected String step1Status;
    protected String step2Status;
    protected String step3Status;
    protected String step4Status;

    protected int noOfCompletedLessons;
    protected int noOfCompletedSteps;
    protected int stepNumber;

    //used in progress and tes tpage


    protected String totalTime;
    protected String totalScore;
    protected boolean lessonCompleted;


    public SchoolStudentBean(){};


    public SchoolStudentBean(String totalTime, String totalScore, boolean lessonCompleted) {
        this.totalTime = totalTime;
        this.totalScore = totalScore;
        this.lessonCompleted = lessonCompleted;
    }


    public SchoolStudentBean( String totalT,String country, Language lang) {
        this.userEmail = userEmail;
        this.country = country;
        this.language = lang;
    }

    public SchoolStudentBean( String userEmail, String user_id, String levelName, int levelNumber, int unitNumber,
                              int lessonNumber,int stepNumber, String country, Language lang, int noOfCompletedLessons,
                              int noOfCompletedSteps,String step1Status,String step2Status,String step3Status,String step4Status) {
        this.userEmail = userEmail;
        this.user_id = user_id;
        this.levelName = levelName;
        this.levelNumber = levelNumber;
        this.unitNumber = unitNumber;
        this.lessonNumber = lessonNumber;
        this.stepNumber = stepNumber;
        this.country = country;
        this.language = lang;
        this.noOfCompletedLessons=noOfCompletedLessons;
        this.noOfCompletedSteps=noOfCompletedSteps;
        this.step1Status=step1Status;
        this.step2Status=step2Status;
        this.step3Status=step3Status;
        this.step4Status=step4Status;
    }


    public String getStep1Status() {
        return step1Status;
    }

    public String getStep2Status() {
        return step2Status;
    }

    public String getStep3Status() {
        return step3Status;
    }
    public String getStep4Status() {
        return step4Status;
    }

    public void setStep1Status(String step1Status) {
        this.step1Status = step1Status;
    }

    public void setStep2Status(String step2Status) {
        this.step2Status = step2Status;
    }

    public void setStep3Status(String step3Status) {
        this.step3Status = step3Status;
    }
    public void setStep4Status(String step4Status) {
        this.step4Status = step4Status;
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

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public int getLevelNumber() {
        return levelNumber;
    }

    public void setLevelNumber(int levelNumber) {
        this.levelNumber = levelNumber;
    }

    public int getUnitNumber() {
        return unitNumber;
    }

    public void setUnitNumber(int unitNumber) {
        this.unitNumber = unitNumber;
    }

    public int getLessonNumber() {
        return lessonNumber;
    }

    public void setLessonNumber(int lessonNumber) {
        this.lessonNumber = lessonNumber;
    }

    public int getStepNumber() {
        return stepNumber;
    }

    public void setStepNumber(int stepNumber) {
        this.stepNumber = stepNumber;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Language getLang() {
        return language;
    }

    public void setLang(Language lang) {
        this.language = lang;
    }

    public int getNoOfCompletedLessons() {
        return noOfCompletedLessons;
    }

    public int getNoOfCompletedSteps() {
        return noOfCompletedSteps;
    }

    public void setNoOfCompletedLessons(int noOfCompletedLessons) {
        this.noOfCompletedLessons = noOfCompletedLessons;
    }

    public void setNoOfCompletedSteps(int noOfCompletedSteps) {
        this.noOfCompletedSteps = noOfCompletedSteps;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public MyMonth getBirthdayMonth() {
        return birthdayMonth;
    }

    public void setBirthdayMonth(MyMonth birthdayMonth) {
        this.birthdayMonth = birthdayMonth;
    }

    public String getBirthdayDate() {
        return birthdayDate;
    }

    public void setBirthdayDate(String birthdayDate) {
        this.birthdayDate = birthdayDate;
    }

    public String getBirthDayYear() {
        return birthDayYear;
    }

    public void setBirthDayYear(String birthDayYear) {
        this.birthDayYear = birthDayYear;
    }

    public String getCurrentPassword() {
        return currentPassword;
    }

    public void setCurrentPassword(String currentPassword) {
        this.currentPassword = currentPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }


    public String getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(String totalTime) {
        this.totalTime = totalTime;
    }

    public String getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(String totalScore) {
        this.totalScore = totalScore;
    }

    public boolean isLessonCompleted() {
        return lessonCompleted;
    }

    public void setLessonCompleted(boolean lessonCompleted) {
        this.lessonCompleted = lessonCompleted;
    }


    @Override
    public String toString() {
        return "SchoolStudentBean{" +
                "userEmail='" + userEmail + '\'' +
                ", user_id='" + user_id + '\'' +
                ", country='" + country + '\'' +
                ", language=" + language +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthdayMonth=" + birthdayMonth +
                ", birthdayDate='" + birthdayDate + '\'' +
                ", birthDayYear='" + birthDayYear + '\'' +
                ", currentPassword='" + currentPassword + '\'' +
                ", newPassword='" + newPassword + '\'' +
                ", verifyPassword='" + verifyPassword + '\'' +
                ", gender=" + gender +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", homePhone='" + homePhone + '\'' +
                ", billingAddress='" + billingAddress + '\'' +
                ", city='" + city + '\'' +
                ", postCode='" + postCode + '\'' +
                ", levelName='" + levelName + '\'' +
                ", levelNumber=" + levelNumber +
                ", unitNumber=" + unitNumber +
                ", lessonNumber=" + lessonNumber +
                ", step1Status='" + step1Status + '\'' +
                ", step2Status='" + step2Status + '\'' +
                ", step3Status='" + step3Status + '\'' +
                ", step4Status='" + step3Status + '\'' +
                ", noOfCompletedLessons=" + noOfCompletedLessons +
                ", noOfCompletedSteps=" + noOfCompletedSteps +
                ", stepNumber=" + stepNumber +
                '}';
    }


}