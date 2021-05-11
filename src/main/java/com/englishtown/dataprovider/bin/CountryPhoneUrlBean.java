package com.englishtown.dataprovider.bin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by nikol.marku on 04/08/2015.
 */
public class CountryPhoneUrlBean extends UrlBean {
    private static final Logger logger = LoggerFactory.getLogger(CountryPhoneUrlBean.class);

    private String phone;
    private String cssSelector;


    public CountryPhoneUrlBean(String cssSelector, String phone, String url){
        super(url);
        this.phone        = phone;
        this.cssSelector  = cssSelector;

    }

    public CountryPhoneUrlBean(int id, String url, String description, String phone, String cssSelector){
        super(id, url, description);
        this.phone             = phone;
        this.cssSelector            = cssSelector;

    }

    public void print(){
        super.print();
        if(this != null){
            logger.info("Phone Number  :"+this.getPhone());
            logger.info("CssSelector   :"+this.getCssSelector());
            logger.info("*******************n***********************");
        }
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCssSelector() {
        return cssSelector;
    }

    public void setCssSelector(String cssSelector) {
        this.cssSelector = cssSelector;
    }

}
