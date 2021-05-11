package com.englishlive.tests.jserror.core;

import com.englishtown.driver.local.DriverManager;
import com.englishtown.helpers.AssertHelper;
import com.englishtown.tests.core.BaseTestHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

/**
 * Created by nikol.marku on 9/1/2016.
 *
 * Check no javascript error shown on browser console
 * Run only on firefox browser
 *
 *
 */
public abstract class BaseTestCheckJSerror extends BaseTestHelper {
    private static final Logger logger = LoggerFactory.getLogger(BaseTestCheckJSerror.class);

    protected static final int FIND_JSERROR_TIME_SEC = 7;

    @Test
    protected void checkNoJavaScriptErrorsShownOnConsole(){
        AssertHelper.assertHasNoJavaScriptErrors(DriverManager.getDriver(), FIND_JSERROR_TIME_SEC);
    }


}
