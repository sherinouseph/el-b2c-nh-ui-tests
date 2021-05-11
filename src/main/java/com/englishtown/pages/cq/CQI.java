package com.englishtown.pages.cq;

/**
 * Created by nikol.marku on 1/3/2017.
 * CQ interface
 */
public interface CQI {
    String FOLDER_NAME            = "temptest";
    String PAGE_TITLE             = "autotest-newpage";  // created under test FOLDER_NAME CQ_QATEST_MAINSITE_URL
    String CQ_PROTOCOL            = "https://";
    String CQ_MAIN_URL            = "aem.eflabs.io/";
    String CQ_LOGIN_URL           = "libs/granite/core/content/login.html";
    String CQ_BASE_URL            = CQ_PROTOCOL+"aem.eflabs.io/"+CQ_LOGIN_URL;
    String CQ_LIVE_BASE_URL       = CQ_PROTOCOL+CQ_MAIN_URL + CQ_LOGIN_URL; //:4502/";
    String CQ_QA_BASE_URL         = CQ_PROTOCOL+"qa-"+CQ_MAIN_URL+CQ_LOGIN_URL; //:4502/"; aem.eflabs.io
    String CQ_QATEST_MAINSITE_URL = CQ_QA_BASE_URL+"siteadmin#/content/englishtown/gb/en/lp/oe/auto-tests";
    String CODI                   = "Kozare70";
    String CQ_QATEST_FOLDER_URL   = CQ_QA_BASE_URL+"siteadmin#/content/englishtown/gb/en/lp/oe/auto-tests/";
    String CQ_QATEST_PAGE_URL     = CQ_QA_BASE_URL+"cf#/content/englishtown/gb/en/lp/oe/auto-tests/temptest/autotest-newpage.html"; //EDIT
    String CQ_USER                = "nikol.marku";

    String TEST_QA_BASE_URL   = "http://qa-";
    String TEST_PAGE_LIVE_URL = TEST_QA_BASE_URL + "englishlive.ef.com/en-gb/lp/oe/auto-tests/temptest/autotest-newpage/" ;

    public final String[] actionList = {"Refresh", "New", "Copy", "Paste", "Delete", "Move", "Activate", "Deactivate",
            "Workflow", "Tools", "Help" };

}


//public static final String CQ_QATEST_MAINSITE_URL = "http://usb-etcqqa2.englishtown.com:4502/siteadmin#/content/englishtown/gb/en/lp/oe/auto-tests";
//public static final String CQ_QATEST_MAINSITE_BASE_URL = "http://usb-etcqqa2.englishtown.com:4502/siteadmin#";
//public static final String CQ_QATEST_MAINSITE_RELATIVE_URL = "/content/englishtown/gb/en/lp/oe/auto-tests";
//public String pageUrl = CQ_QATEST_MAINSITE_URL;
