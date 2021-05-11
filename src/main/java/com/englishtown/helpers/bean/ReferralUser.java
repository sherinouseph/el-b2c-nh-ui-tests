package com.englishtown.helpers.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Bean
 * Clarification
 * Inviter : One who, or that which, invites.
 * Invitee : A person who is invited
 *
 * Store data for inviter/ee next pay date and user credentials
 *
 */

public class ReferralUser {
    private static final Logger log = LoggerFactory.getLogger(ReferralUser.class);
    protected String userName;
    protected String pass;
    protected String nextPay;


    public ReferralUser(String userName, String pass, String nextPay) {
        this.userName = userName;
        this.pass = pass;
        this.nextPay = nextPay;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getNextPay() {
        return nextPay;
    }

    public void setNextPay(String nextPay) {
        this.nextPay = nextPay;
    }

    public void print(){
        log.info("ReferralUser UserName :"+this.getUserName());
        log.info("ReferralUser Pass     :"+this.getPass());
        log.info("ReferralUser NextPay  :"+this.getNextPay());
    }

}
