package com.englishtown.helpers.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by nikol.marku on 05/11/2015.
 */
public class UrlMonitoringStatistics {
    private static final Logger log = LoggerFactory.getLogger(UrlMonitoringStatistics.class);

    protected String country;
    protected String url;
    protected String loadTime;

    public UrlMonitoringStatistics(String country, String url, String loadTime) {
        this.country = country;
        this.url = url;
        this.loadTime = loadTime;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLoadTime() {
        return loadTime;
    }

    public void setLoadTime(String loadTime) {
        this.loadTime = loadTime;
    }


    @Override
    public String toString(){
        return "UrlMonitoringStatistics [country="+country+", url="+url+", LoadTime="+loadTime+"]";
    }



}
