package com.englishtown.dataprovider.bin;

import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.tests.core.BaseTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by nikol.marku on 11/25/2016.
 */
public class TestResponseBean extends UrlBean{
    private static final Logger logger = LoggerFactory.getLogger(TestResponseBean.class);

    private String  urlRedirectTo;              // URL should redirect to this
    private String  currentUrl;                 // response current url
    private int     responseCode;
    private int     expectedResponseCode;
    private boolean is500ErrorOnResponseBody;   // if response Body contains 'Error:500'
    private String  errorSubString;             // body substring containing the error
    private String  languageAndCountry ;        // pt-br

    public TestResponseBean(){
        super();
    }

    public TestResponseBean(int id, String url, String urlRedirectTo, int expectedResponseCode) {
        super(id, url, "");
        this.urlRedirectTo = urlRedirectTo;
        this.expectedResponseCode = expectedResponseCode;
    }
    public TestResponseBean(int id, String url, String languageAndCountry, String urlRedirectTo, int expectedResponseCode){
        super(id, url, "");
        this.urlRedirectTo = urlRedirectTo;
        this.languageAndCountry = languageAndCountry;
        this.expectedResponseCode = expectedResponseCode;
    }

    public TestResponseBean(int id, String url, String description, String urlRedirectTo, String currentUrl,
                            int responseCode, int expectedResponseCode, boolean is500ErrorOnResponseBody,
                            String languageAndCountry, String errorSubString) {
        super(id, url, description);
        this.urlRedirectTo = urlRedirectTo;
        this.currentUrl = currentUrl;
        this.responseCode = responseCode;
        this.expectedResponseCode = expectedResponseCode;
        this.is500ErrorOnResponseBody = is500ErrorOnResponseBody;
        this.errorSubString = errorSubString;
        this.languageAndCountry = languageAndCountry;
    }


    @Override
    public void print(){
        if(this != null){
            logger.info("******************s********************************************");
            logger.info("id                         :"+this.getId());
            logger.info("url                        :"+this.getUrl());
            logger.info("urlRedirectTo              :"+this.getUrlRedirectTo());
            logger.info("currentUrl                 :"+this.getCurrentUrl());
            logger.info("responseCode               :"+this.getResponseCode());
            logger.info("expectedResponseCode       :"+this.getExpectedResponseCode());
            logger.info("is500ErrorOnResponseBody   :"+this.is500ErrorOnResponseBody());
            logger.info("getErrorSubString          :"+this.getErrorSubString());
            logger.info("LanguageAndCountry         :"+this.getLanguageAndCountry());
            logger.info("description                :"+this.getDescription());
            logger.info("*******************n********************************************");
        }
    }


    public String getUrlRedirectTo() {
        return urlRedirectTo;
    }

    public void setUrlRedirectTo(String urlRedirectTo) {
        this.urlRedirectTo = urlRedirectTo;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public boolean is500ErrorOnResponseBody() {
        return is500ErrorOnResponseBody;
    }

    public void setIs500ErrorOnResponseBody(boolean is500ErrorOnResponseBody) {
        this.is500ErrorOnResponseBody = is500ErrorOnResponseBody;
    }
    public String getErrorSubString() {
        return errorSubString;
    }

    public void setErrorSubString(String errorSubString) {
        this.errorSubString = errorSubString;
    }

    public int getExpectedResponseCode() {
        return expectedResponseCode;
    }

    public void setExpectedResponseCode(int expectedResponseCode) {
        this.expectedResponseCode = expectedResponseCode;
    }

    public String getCurrentUrl() {
        return currentUrl;
    }

    public void setCurrentUrl(String currentUrl) {
        this.currentUrl = currentUrl;
    }

    public String getLanguageAndCountry() {
        return languageAndCountry;
    }

    public void setLanguageAndCountry(String languageAndCountry) {
        this.languageAndCountry = languageAndCountry;
    }

    /**
     * expect a string in a form of e.g "fr-fr"
     * @return
     */
    public String getLanguageFromLangAndCtr() {
        return TestUtil.getSplitPart(languageAndCountry, "-", 0);
    }
    public String getCountryFromLangAndCtr() {
        return TestUtil.getSplitPart(languageAndCountry, "-", 1);
    }



}



/**

 @Override
 public boolean equals(Object object){
 if(object == null ){
 logger.info("Object is NULL or is not same instance ...!");
 return false;
 }
 if( object instanceof TestResponseBean){
 ((TestResponseBean) object).getUrl().equals(this.getUrl());
 ((TestResponseBean) object).getUrlRedirectTo().equals(this.getUrlRedirectTo());

 }
 logger.info("Object is not the same instance ...!");
 return false;
 }

 */