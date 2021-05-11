package com.englishtown.dataprovider.bin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by nikol.marku on 04/08/2015.
 */
public class UrlBean {
    private static final Logger logger = LoggerFactory.getLogger(UrlBean.class);

    private int id;
    protected String url;    // request URL
    private String description;

    public UrlBean(){

    }

    public UrlBean(String url){
        this.url = url;
    }

    public UrlBean(int id, String url, String description){
        this.id             = id;
        this.url            = url;
        this.description    = description;
    }

    public void print(){
        if(this != null){
            logger.info("******************s************************");
            logger.info("id            :"+this.getId());
            logger.info("url           :"+this.getUrl());
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

    public String getDescription() {
        return description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
