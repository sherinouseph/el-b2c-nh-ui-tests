package com.englishtown.dataprovider.bin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by nikol.marku on 04/08/2015.
 */
public class UrlHostContryRedirectBean extends UrlRedirectBean {
    private static final Logger logger = LoggerFactory.getLogger(UrlHostContryRedirectBean.class);


    private String host;            // hosted need to be set on the header to fake the request for GEOIP test

    public UrlHostContryRedirectBean(int id, String url, String expectedUrl, String description, String host, String market){
        super(id, url, expectedUrl, description);
        this.host = host;
        this.market = market;
    }

    private String market;          // country code e.g br

    public String getHost() {
        return host;
    }
    public void setHost(String host) {
        this.host = host;
    }
    public String getMarket() {
        return market;
    }
    public void setMarket(String market) {
        this.market = market;
    }
    public void print(){
        super.print();
        if(this != null){
            logger.info("                                ");
            logger.info("host            :"+this.getHost());
            logger.info("market          :"+this.getMarket());
            logger.info("*******************n***********************");
        }
    }

}
