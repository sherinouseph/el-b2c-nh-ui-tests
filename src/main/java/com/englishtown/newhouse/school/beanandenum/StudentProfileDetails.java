package com.englishtown.newhouse.school.beanandenum;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StudentProfileDetails {
    private static final Logger logger = LoggerFactory.getLogger(StudentProfileDetails.class);

    protected String englishLevel;
    protected String gender;
    protected String age ;
    protected String livingIn ;
    protected String nativeLanguage ;
    protected String industry ;
    protected String chatAccessibility ;

    public StudentProfileDetails(){};

    public StudentProfileDetails(String englishLevel, String gender, String age, String livingIn, String nativeLanguage, String industry, String chatAccessibility) {
        this.englishLevel = englishLevel;
        this.gender = gender;
        this.age = age;
        this.livingIn = livingIn;
        this.nativeLanguage = nativeLanguage;
        this.industry = industry;
        this.chatAccessibility = chatAccessibility;
    }

    public String getEnglishLevel() {
        return englishLevel;
    }

    public void setEnglishLevel(String englishLevel) {
        this.englishLevel = englishLevel;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getLivingIn() {
        return livingIn;
    }

    public void setLivingIn(String livingIn) {
        this.livingIn = livingIn;
    }

    public String getNativeLanguage() {
        return nativeLanguage;
    }

    public void setNativeLanguage(String nativeLanguage) {
        this.nativeLanguage = nativeLanguage;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getChatAccessibility() {
        return chatAccessibility;
    }

    public void setChatAccessibility(String chatAccessibility) {
        this.chatAccessibility = chatAccessibility;
    }



    @Override
    public String toString() {
        return "StudentProfileDetails{" +
                "englishLevel='" + englishLevel + '\'' +
                ", gender='" + gender + '\'' +
                ", age='" + age + '\'' +
                ", livingIn='" + livingIn + '\'' +
                ", nativeLanguage='" + nativeLanguage + '\'' +
                ", industry='" + industry + '\'' +
                ", chatAccessibility='" + chatAccessibility + '\'' +
                '}';
    }

}