package com.englishtown.tests.core;

import com.englishtown.driver.MyBrowserType;
import com.englishtown.tests.core.selectors.ISharedSelectors;

/**
 * Created by nikol.marku on 4/4/2017.
 */
public interface IBaseTest extends ISharedConfiguration, ISharedSelectors {

    int TEST_TIMEOUT_SHORT_MLS   =  60000;    // 1 min
    int TEST_DEFAULT_TIMEOUT_MLS = 120000;    // 2 mins
    int TEST_TIMEOUT_LONG_MLS    =  300000;   // 5 mins
    String PASSWORD8             = "passpass"; //8character password


    void setThreadSafeDriver(); // use default chrome browser
    void setThreadSafeDriver(MyBrowserType browserType, int waitTimeSec);
}
