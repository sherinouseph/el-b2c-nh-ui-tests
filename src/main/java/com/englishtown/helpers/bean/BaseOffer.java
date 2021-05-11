package com.englishtown.helpers.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by nikol.marku on 04/08/2015.
 */
public class BaseOffer {
    private static final Logger logger = LoggerFactory.getLogger(BaseOffer.class);

    protected int id;
    protected String description;


    public BaseOffer(int id){
        this.id             = id;
    }

    public BaseOffer(int id, String description){
        this.id             = id;
        this.description    = description;
    }

    public void print(){
        if(this != null){
            logger.info("******************s************************");
            logger.info("id            :"+this.getId());
            logger.info("description   :"+this.getDescription());
            logger.info("*******************n***********************");
        }
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
