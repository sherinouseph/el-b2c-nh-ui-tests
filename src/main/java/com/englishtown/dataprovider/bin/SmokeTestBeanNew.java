package com.englishtown.dataprovider.bin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by sherin Ouseph on 15/09/2017.
 */
public class SmokeTestBeanNew {
    private static final Logger logger = LoggerFactory.getLogger(SmokeTestBeanNew.class);



    private String country;
    private String url;
    private String Price_selector;
    private String Login_Selector;
    private String header_selector;
    private String bodyText;
    private boolean isPopupShown;


    public SmokeTestBeanNew(String country, String url, String Price_selector, String Login_Selector,
                            String header_selector, String bodyText, boolean isPopupShown ){

        this.country  = country;
        this.url      = url;
        this.Price_selector = Price_selector;
        this.Login_Selector = Login_Selector;
        this.header_selector = header_selector;
        this.bodyText = bodyText;
        this.isPopupShown=isPopupShown;

    }



    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }

    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }


    public String getPrice_selector() {
        return Price_selector;
    }
    public void setPrice_selector(String Price_selector) {
        this.Price_selector = Price_selector;
    }




    public String getLogin_Selector() {
        return Login_Selector;
    }

    public void setLogin_Selector(String Login_Selector) {
        this.Login_Selector = Login_Selector;
    }

    public String getheader_selector() {
        return header_selector;
    }

    public void setheader_selector(String header_selector) {
        this.header_selector = header_selector;
    }


    public String getBodyText() {
        return bodyText;
    }

    public void setheader_text(String header_text) {
        this.bodyText = header_text;
    }

    public boolean getisPopupShown() {
        return isPopupShown;
    }

    public void setisPopupShown(boolean isPopupShown) {
        this.isPopupShown = isPopupShown;}


    public void print(){
        if(this != null){
            logger.info("******************s************************");
            logger.info("country    :"+this.getCountry());
            logger.info("url        :"+this.getUrl());
            logger.info("Price_selector        :"+this.getPrice_selector());
            logger.info("Login_Selector        :"+this.getLogin_Selector());
            logger.info("header_selector        :"+this.getheader_selector());
            logger.info("Header text             :"+this.getBodyText());
            logger.info("IsPopupShown            :"+this.getisPopupShown());
            logger.info("*******************n***********************");
        }
    }


}
