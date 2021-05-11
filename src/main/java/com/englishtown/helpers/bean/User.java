package com.englishtown.helpers.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by nikol.marku on 16/02/2015.
 */
public class User {
    private static final Logger log = LoggerFactory.getLogger(User.class);
    protected static final String pass = "pass";
    protected String email;
    protected String memberId;
    protected String environment;
    protected String market;

    public User(){};

    public User(String email, String memberId, String environment, String market) {
        this.email = email;
        this.memberId = memberId;
        this.environment = environment;
        this.market = market;
    }

    public User(String comaSeparatedLine){
        String[] item = comaSeparatedLine.split(",");
        if(!item.equals(null)) {
            try {
                email = item[0].trim();
                memberId = item[1].trim();
                environment = item[2].trim();
                market = item[3].trim();
            } catch (ArrayIndexOutOfBoundsException e) {
                log.error(" Create User Exception :" + e);
            }
        } else {
            log.error("Can not Create User line item is null :"+item  );
        }
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public String getMarket() {
        return market;
    }
    public void setMarket(String market) {
        this.market = market;
    }

    public void printUser(){
        log.info(" Pass    : " + pass);
        log.info(" Email   : " + this.getEmail());
        log.info(" MemberID: "+this.getMemberId());
        log.info(" ENV     : "+this.getEnvironment());
        log.info(" Market  : "+this.getMarket());
    }


}
