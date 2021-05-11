package com.englishlive.tests.jserror.core;

import com.englishtown.dataprovider.HomePageDataProvider;
import com.englishtown.driver.MyBrowserType;
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
public class BaseTestCheckJSerrorAllMarket extends BaseTestHelper {
    private static final Logger logger = LoggerFactory.getLogger(BaseTestCheckJSerrorAllMarket.class);

    protected static final int FIND_JSERROR_TIME_SEC = 7;


    @Test(dataProvider = "allMarketHomePageUrls", dataProviderClass = HomePageDataProvider.class, threadPoolSize = 4, invocationCount = 1, timeOut = 60000 )
    public void opentUrlCheckRedirectUrlTest(int id, String url) throws Exception{
        try {
            DriverManager.createDriver(MyBrowserType.FIREFOX, 15);
            openUrl(DriverManager.getDriver(), url);
            sleep(1000);
            AssertHelper.assertHasNoJavaScriptErrors(DriverManager.getDriver(), FIND_JSERROR_TIME_SEC);
        }catch (Exception e ){
           logger.error(" URL : "+url+" \n"+e.getMessage());

        }finally {
            DriverManager.destroyLocalDriver();
        }
    }

//    @AfterTest
//    void killFFDriver(){
//        DriverManager.destroyLocalDriver();
//    }


}
