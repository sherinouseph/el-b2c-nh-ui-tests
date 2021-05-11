package com.englishtown.dataprovider.bin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by nikol.marku on 04/08/2015.
 */
public class UrlBeanWithCountry extends UrlBean{
    private static final Logger logger = LoggerFactory.getLogger(UrlBeanWithCountry.class);

    private String countryTwoLetterCode;
    private String countryThreeLetterCode;
    private String languageCode;    // e.g BR and lang is PT
    private int responseCode;

    public UrlBeanWithCountry(){

    }

    public UrlBeanWithCountry(int id, String url, String description, String countryTwoLetterCode, String countryThreeLetterCode,
                              String languageCode, int responseCode){
        super(id, url, description);
        this.countryTwoLetterCode = countryTwoLetterCode;
        this.countryThreeLetterCode = countryThreeLetterCode;
        this.languageCode = languageCode;
        this.responseCode = responseCode;
    }

    public UrlBeanWithCountry(String countryTwoLetterCode, String url){
        super(url);
        this.countryTwoLetterCode = countryTwoLetterCode;

    }

    @Override
    public void print(){
        if(this != null){
            super.print();
            logger.info("CountryData  ----");
            logger.info("countryTwoLetterCode     :"+this.getCountryTwoLetterCode());
            logger.info("countryThreeLetterCode   :"+this.getCountryThreeLetterCode());
            logger.info("languageCode             :"+this.getLanguageCode());
            logger.info("Response Code            :"+this.getResponseCode());
            logger.info("*******************n***********************");
        }
    }

    public String getCountryTwoLetterCode() {
        return countryTwoLetterCode;
    }

    public void setCountryTwoLetterCode(String countryTwoLetterCode) {
        this.countryTwoLetterCode = countryTwoLetterCode;
    }

    public String getCountryThreeLetterCode() {
        return countryThreeLetterCode;
    }

    public void setCountryThreeLetterCode(String countryThreeLetterCode) {
        this.countryThreeLetterCode = countryThreeLetterCode;
    }

    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

}
