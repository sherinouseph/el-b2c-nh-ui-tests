package com.englishtown.dataprovider.bin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by nikol.marku on 04/08/2015.
 */
public class UrlRedirectBean {
    private static final Logger logger = LoggerFactory.getLogger(UrlRedirectBean.class);

    private int id;
    private String url;            // open this url
    private String expectedUrl;    // should redirect to this
    private String description;


    public UrlRedirectBean( int id, String url, String expectedUrl, String description){
        this.id             = id;
        this.url            = url;
        this.expectedUrl    = expectedUrl;
        this.description    = description;
    }

    public void print(){
        if(this != null){
            logger.info("******************s************************");
            logger.info("id            :"+this.getId());
            logger.info("url           :"+this.getUrl());
            logger.info("expectedUrl   :"+this.getExpectedUrl());
            logger.info("description   :"+this.getDescription());
            logger.info("*******************n***********************");
        }
    }

    public int getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public String getExpectedUrl() {
        return expectedUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setExpectedUrl(String expectedUrl) {
        this.expectedUrl = expectedUrl;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isSameDomain(UrlRedirectBean urlRedirectBean){
        boolean isSameDomain=false;
        if(urlRedirectBean.getUrl().contains(urlRedirectBean.getExpectedUrl().substring(0, 15))){
            isSameDomain = true;
        }
        return isSameDomain;
    }

    //experimental
    public UrlRedirectBean(String name,
                          String description) {
        this.expectedUrl = name;
        this.description = description;
    }

    public String getTestName() {
        return description;
    }
    public String getTestDescription() {
        return description;
    }
}
