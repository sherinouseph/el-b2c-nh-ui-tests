package com.englishlive.tests.redirect.all;
/**
 * Open eTown sitemap xml should open elive xml page
 *
 */

import com.englishlive.tests.basetest.htmlunit.BaseHtmlUnitDriverTest;
import com.englishtown.dataprovider.UrlDataProvider;
import com.englishtown.dataprovider.bin.UrlRedirectBean;
import com.englishtown.driver.MyBrowserType;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class SiteMapXmlRedirectTest extends BaseHtmlUnitDriverTest {
    private static final Logger logger = LoggerFactory.getLogger(SiteMapXmlRedirectTest.class);
    private static int waitTime = 15 ;


    @Test(dataProvider = "siteMapXmlUrls", dataProviderClass = UrlDataProvider.class, threadPoolSize = 5, invocationCount = 1, timeOut = 60000 )
    public void opentSiteMapXmlUrlCheckRedirectTest(UrlRedirectBean urlRedirectBean) throws Exception{
        try {
            createLocalThreadDriver(MyBrowserType.HTMLUNIT, 35);
            openUrlCheckIsRedirected(getLocalThreadDriver(), urlRedirectBean, 20, true);
            increaseTestEndCount();
        }catch (Exception e){
            logger.error("Exception : "+e.getMessage());
            throw new Exception(e);
        }
        finally {
            increaseTestCount();
            destroyLocalThreadDriver();
        }
    }

    @AfterTest
    void printTotalErrors(){
        if(TEST_COUNT.get() > 0 && TEST_COUNT.get() - TEST_ENDCOUNT.get() == 0){
            logger.info("\n\n\t\tAll test passed ...!\n\n");
        }else {
            logger.error("\n\n\t\tNOT all test passed ...!\n");
            logger.error("printTotalErrors ...!   Test Run No:"+TEST_COUNT.get()+" - Test Failure :" +
                    (TEST_COUNT.get() - TEST_ENDCOUNT.get())+"\n\n");
        }
    }

}