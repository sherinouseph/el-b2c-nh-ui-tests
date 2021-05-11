package com.englishtown.tests.core;

/**
 * Created by nikol.marku on 4/4/2017.
 *
 * Define all shared data between TEST, PAGEs, Tools, simpletest etc
 *
 */
public interface ISharedConfiguration {

    /*********************
     *JS Scripts
     ********************/
    String CLEAR_LOCAL_STOREAGE = "localStorage.clear()";

    /**********************************
     * Config Final settings vars
     **********************************/
    String[] CHROME_BROWSER_LIST = {"chrome"};
    String[] CHROME_FF_BROWSER_LIST = {"chrome", "firefox"};
    String[] CHROME_FF_IE_SAFARY_BROWSER_LIST = {"chrome", "firefox", "ie", "safari"};

    /*********************
     * Screen Size
     ********************/

    /****************************
     *  Timeout settings
     */
    int TIMEOUT_SEC_SHORT = 5;
    int TIMEOUT_SEC_MED = 15;
    int TIMEOUT_SEC_LONG = 25;
    int TIMEOUT_SEC_VERYLONG = 35;
    int TIMEOUT_SEC_DEFAULT = 20;
    int SPOCK_FEATURE_TIMEOUT = 120; // DEFALUT .....


    /**
     * USERS
     */
    String USER = "test1410280946594@qp1.org"; //user.de=
    String PASS = "password";

}
