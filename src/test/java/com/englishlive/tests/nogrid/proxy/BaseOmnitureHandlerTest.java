package com.englishlive.tests.nogrid.proxy;
/**
 * Created by nikol.marku on 05/04/2016.
 *
 *
 20.17 senglishtown-tests
 20.17 sOmnitureHandlerTest
 8.27 spassedOmnitureHandlerTest.enterFormdataAndSubmit
 5 mspassedOmnitureHandlerTest.isEtagV0
 1 mspassedOmnitureHandlerTest.isLanguageAndMarketC15
 1 mspassedOmnitureHandlerTest.isOmnitureResponseStatusCode200
 0 mspassedOmnitureHandlerTest.isPageNameTest
 0 mspassedOmnitureHandlerTest.isPartnerC11
 *
 */
import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.bean.handler.BasicOmnitureData;
import com.englishtown.helpers.bean.handler.BasicPostDataHandler;
import com.englishtown.pages.core.BasePage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.containsString;


public abstract class BaseOmnitureHandlerTest extends BaseProxyFactory {
    private static final Logger logger = LoggerFactory.getLogger(BaseOmnitureHandlerTest.class);

    protected String omnitureDataHandlerStr;
    protected BasicOmnitureData omniDataObj;

    @Test
    public void enterFormdataAndSubmit() {
        basicPostDataHandlerExpectedData = new BasicPostDataHandler("testDBstore","db1_" + System.currentTimeMillis() + "@qp1.org","ee","fr" );
        enterFormDataAndSubmit(basicPostDataHandlerExpectedData);

        try {
            omnitureDataHandlerStr = getOmnitureDataHandler(proxyServer);
        }catch (Exception npe){
            logger.error(" Null Object ...! "+npe.getMessage());
            BasePage.failTest("Can't get getOmnitureDataHandler data text handler ...!");
        }
    }

    @Test (dependsOnMethods = { "enterFormdataAndSubmit" })
    public void isPageNameTest(){
        logger.info("isPageNameOmniDataTest");
        String testName = "IsPageName";
        AssertHelper.assertThat(testName+" posted is not the expected one ...!",
                omnitureDataHandlerStr, containsString("pageName="+omniDataObj.getPageName()) );
    }

    @Test (dependsOnMethods = { "enterFormdataAndSubmit" })
    public void isOmnitureResponseStatusCode200(){
        logger.info("isOmnitureResponseStatusCode200");
        String testName = "isOmnitureResponseStatusCode200";
        AssertHelper.assertThat(testName+" posted is not the expected one ...!",
                omnitureDataHandlerStr, containsString("ResponseStatus="+omniDataObj.getStatusCode()) );
    }

    @Test (dependsOnMethods = { "enterFormdataAndSubmit" })
    public void isPartnerC11(){
        logger.info("isPartnerC11");
        String testName = "isPartner";
        AssertHelper.assertThat(testName+" posted is not the expected one ...!",
                omnitureDataHandlerStr, containsString("c11="+omniDataObj.getC11()) );
    }

    @Test (dependsOnMethods = { "enterFormdataAndSubmit" })
    public void isEtagV0(){
        logger.info("isEtagV0");
        String testName = "isEtagV0";
        AssertHelper.assertThat(testName+" posted is not the expected one ...!",
                omnitureDataHandlerStr, containsString("v0="+omniDataObj.getV0()) );
    }

    @Test (dependsOnMethods = { "enterFormdataAndSubmit" })
    public void isLanguageAndMarketC15(){
        logger.info("isLanguageAndMarketC15");
        String testName = "isLanguageAndMarketC15";
        AssertHelper.assertThat(testName+" posted is not the expected one ...!",
                omnitureDataHandlerStr, containsString("c15="+omniDataObj.getC15()) );
    }


}




//    @Test (dependsOnMethods = { "enterFormdataAndSubmit" })
//    public void isLanguageC12(){
//        logger.info("isLanguage");
//        String testName = "isLanguageOrMarket";
//        AssertHelper.assertThat(testName+" posted is not the expected one ...!",
//                omnitureDataHandlerStr, containsString("c=failme"+omniDataObj.getPageName()) );
//    }
//    @Test (dependsOnMethods = { "enterFormdataAndSubmit" })
//    public void isMarketC25(){
//        logger.info("isMarketOrLanguage");
//        String testName = "isMarketC25";
//        AssertHelper.assertThat(testName+" posted is not the expected one ...!",
//                omnitureDataHandlerStr, containsString("c=failme"+omniDataObj.getPageName()) );
//    }