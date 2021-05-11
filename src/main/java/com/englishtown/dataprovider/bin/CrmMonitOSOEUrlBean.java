package com.englishtown.dataprovider.bin;

import com.englishtown.dataprovider.CrmOSOEMonitorDatatProvider;
import com.englishtown.enumpack.CrmTestType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by nikol.marku on 04/08/2015.
 */
public class CrmMonitOSOEUrlBean extends UrlBean{
    private static final Logger logger = LoggerFactory.getLogger(CrmMonitOSOEUrlBean.class);

    private String countryTwoLetterCode;

    private CrmTestType crmTestType;

    public CrmMonitOSOEUrlBean(){

    }

    public CrmMonitOSOEUrlBean(int id, String url, String countryTwoLetterCode, CrmTestType crmTestType ){
        super(id, url, null);
        this.countryTwoLetterCode = countryTwoLetterCode;
        this.crmTestType = crmTestType;

    }

    public CrmMonitOSOEUrlBean(String countryTwoLetterCode, String url){
        super(url);
        this.countryTwoLetterCode = countryTwoLetterCode;

    }

    @Override
    public void print(){
        if(this != null){
            super.print();
            logger.info("CountryData  ----");
            logger.info("countryTwoLetterCode  :"+this.getCountryTwoLetterCode());
            logger.info("CrmTestType           :"+this.getCrmTestType().getCrmTestType());
            logger.info("*******************n***********************");
        }
    }

    public String getCountryTwoLetterCode() {
        return countryTwoLetterCode;
    }

    public void setCountryTwoLetterCode(String countryTwoLetterCode) {
        this.countryTwoLetterCode = countryTwoLetterCode;
    }

    public CrmTestType getCrmTestType() {
        return crmTestType;
    }

    public void setCrmTestType(CrmTestType crmTestType) {
        this.crmTestType = crmTestType;
    }

}
