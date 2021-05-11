package com.englishtown.newhouse.school.beanandenum.bean.chat;
/**
 * Chat search result returns Hits and hits go source ..
 * represent source
 *
 * used by ChatFriendsSearchResultBean as this might have many of this items
 *
 * Nikol Apr 2018
 */

import com.englishtown.enumpack.Gender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HitSourceBean{
    private static final Logger logger = LoggerFactory.getLogger(ChatFriendsSearchResultBean.class);

    protected String given_name;
    protected String family_name;
    protected String identifier;         // 29768318 same as   "_id": "member:29768318",
    protected String identifier_type;    // "": "member",
    protected Gender gender;  // U
    protected String country_code; //us
    protected String email; //62894be13443a96d8b3ab1f3d5b9a1d6fd58320dbac4eeb66d1e923960e7c6ac hashed
    protected String profile_privacy;
    protected String chat_privacy;
    protected String english_level;
    protected String english_level_code;

    public HitSourceBean(){}

    public HitSourceBean(String given_name, String family_name, String identifier, String identifier_type,
                         Gender gender, String country_code, String email, String profile_privacy, String chat_privacy,
                         String english_level, String english_level_code) {
        this.given_name = given_name;
        this.family_name = family_name;
        this.identifier = identifier;
        this.identifier_type = identifier_type;
        this.gender = gender;
        this.country_code = country_code;
        this.email = email;
        this.profile_privacy = profile_privacy;
        this.chat_privacy = chat_privacy;
        this.english_level = english_level;
        this.english_level_code = english_level_code;
    }


    public String getGiven_name() {
        return given_name;
    }

    public void setGiven_name(String given_name) {
        this.given_name = given_name;
    }

    public String getFamily_name() {
        return family_name;
    }

    public void setFamily_name(String family_name) {
        this.family_name = family_name;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getIdentifier_type() {
        return identifier_type;
    }

    public void setIdentifier_type(String identifier_type) {
        this.identifier_type = identifier_type;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getCountry_code() {
        return country_code;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfile_privacy() {
        return profile_privacy;
    }

    public void setProfile_privacy(String profile_privacy) {
        this.profile_privacy = profile_privacy;
    }

    public String getChat_privacy() {
        return chat_privacy;
    }

    public void setChat_privacy(String chat_privacy) {
        this.chat_privacy = chat_privacy;
    }

    public String getEnglish_level() {
        return english_level;
    }

    public void setEnglish_level(String english_level) {
        this.english_level = english_level;
    }

    public String getEnglish_level_code() {
        return english_level_code;
    }

    public void setEnglish_level_code(String english_level_code) {
        this.english_level_code = english_level_code;
    }

    @Override
    public String toString() {
        return "HitSourceBean{" +
                "given_name='" + given_name + '\'' +
                ", family_name='" + family_name + '\'' +
                ", identifier='" + identifier + '\'' +
                ", identifier_type='" + identifier_type + '\'' +
                ", gender=" + gender +
                ", country_code='" + country_code + '\'' +
                ", email='" + email + '\'' +
                ", profile_privacy='" + profile_privacy + '\'' +
                ", chat_privacy='" + chat_privacy + '\'' +
                ", english_level='" + english_level + '\'' +
                ", english_level_code='" + english_level_code + '\'' +
                '}';
    }

    public void print(){
        logger.info(this.toString());
    }

}
