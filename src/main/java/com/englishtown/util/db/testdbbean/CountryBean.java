package com.englishtown.util.db.testdbbean;
/**
 *
 */


public class CountryBean {

    protected int id;
    protected String countryCode;
    protected String currencyCode;
    protected String countryName;

    public CountryBean(int id, String countryName, String currencyCode, String countryCode) {
        this.id = id;
        this.countryName = countryName;
        this.currencyCode = currencyCode;
        this.countryCode = countryCode;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @Override
    public String toString(){
        return " c_id: "+this.id+" countryName: "+this.countryName+" countryCode: "+this.countryCode+" currencyCode: "+this.currencyCode;
    }






}
