package com.englishtown.dataprovider.bin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by nikol.marku on 04/08/2015.
 */
public class PhoneUrlBean extends CountryPhoneUrlBean {
    private static final Logger logger = LoggerFactory.getLogger(PhoneUrlBean.class);

    private String secondPhone;

    public PhoneUrlBean(String cssSelector, String phone, String secondPhone, String url){
        super(cssSelector, phone, url);
        this.secondPhone        = secondPhone;


    }

    public void print(){
        super.print();
        if(this != null){
            logger.info("Second Phone :"+this.getSecondPhone());
            logger.info("*******************n***********************");
        }
    }


    public String getSecondPhone() {
        return secondPhone;
    }
    public void setPhone(String secondPhone) {
        this.secondPhone = secondPhone;
    }

}
