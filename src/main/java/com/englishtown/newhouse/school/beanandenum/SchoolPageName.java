package com.englishtown.newhouse.school.beanandenum;
/**
 * nikol 2018 Jan
 * All page names in the school
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum SchoolPageName {

    MYPAGE("mypage"),  // HOMEPAGE
    MY_ACCOUNT_PAGE("Account setting page"),
    PERSONAL_DETAILS("Personal Details");
    //todo

    private static final Logger logger = LoggerFactory.getLogger(SchoolPageName.class);
    private final String pageName ;

    SchoolPageName(String pageName) {
        this.pageName = pageName;
    }


    public String getPageName() {
        return pageName;
    }



}
