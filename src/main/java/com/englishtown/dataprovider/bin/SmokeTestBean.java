package com.englishtown.dataprovider.bin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by nikol.marku on 20/04/2015.
 */
public class SmokeTestBean {
    private static final Logger logger = LoggerFactory.getLogger(SmokeTestBean.class);

    private int id;
    private String country;
    private String url;
    private String selector;


    public SmokeTestBean( int id, String country, String url, String selector){
        this.id       = id;
        this.url      = url;
        this.country  = country;
        this.selector = selector;
    }


    public String getSelector() {
        return selector;
    }

    public void setSelector(String selector) {
        this.selector = selector;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void print(){
        if(this != null){
            logger.info("******************s************************");
            logger.info("id         :"+this.getId());
            logger.info("country    :"+this.getCountry());
            logger.info("url        :"+this.getUrl());
            logger.info("selector   :"+this.getSelector());
            logger.info("*******************n***********************");
        }
    }


}
