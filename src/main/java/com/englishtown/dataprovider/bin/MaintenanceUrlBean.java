package com.englishtown.dataprovider.bin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by nikol.marku on 04/08/2015.
 * Maintenance pages [sales pages should have login button ]
 */
public class MaintenanceUrlBean extends UrlBeanWithCountry{
    private static final Logger logger = LoggerFactory.getLogger(MaintenanceUrlBean.class);

    protected String pageType; //[lp, sp] landing page, sales page [sales pages have login]


    public MaintenanceUrlBean(){

    }

    public MaintenanceUrlBean(String pageType, int id, String url, String description, String countryTwoLetterCode,
                              String countryThreeLetterCode, String languageCode, int responseCode){
        super(id, url, description, countryTwoLetterCode,  countryThreeLetterCode, languageCode, responseCode);
        this.pageType = pageType;
    }

    public MaintenanceUrlBean(String url, String pageType){
        this.url = url;
        this.pageType = pageType;
    }

    @Override
    public void print(){
        if(this != null){
            super.print();
            logger.info("Page Type             :"+this.getPageType());
            logger.info("*******************n***********************");
        }
    }

    public String getPageType() {
        return pageType;
    }

    public void setPageType(String pageType) {
        this.pageType = pageType;
    }



}
