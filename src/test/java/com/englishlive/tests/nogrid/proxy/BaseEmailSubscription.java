package com.englishlive.tests.nogrid.proxy;

/**
 *  https://jira-bos.englishtown.com/browse/SAND-3295
 *  1. Open URL: http://qa-englishlive.ef.com/en-gb/lp/ee/nikol-test/
 *  2. Enter name and email
 *  3. Select checkbox and submit
 *  4. Check Request submitted [url contains 'landinghandler'] params is "emaillist:4. 5. 17    ///,8"  // note: param id is 26
 *  5. Repeat Step 1 and 2
 *  6. Do not select the checkbox and submit   2018 Karim updated and now should have nothink
 *  7. Check Request submitted [url contains 'landinghandler'] params is "emaillist:"  // note: param id is 25
 *
 *  checked: 4 5 17
 *  unChecked: nothing now 2018 Karim
 *
 * NOte:
 * On new house we changed this now
 * Request URL: https://englishlive.ef.com/1/api/commerce-gateway/lead
 * Request Method: POST
 * {"Country":"gb","Language":"en","Partner":"None","LeadType":"ee","Email":"sdjsd@qp1.org","FirstName":"Niko","LastName":"yrdy","SourcePageName":"LandingPages:ee:nikol-test","SourceSystemName":"AEM","GAClientId":"169991297.1549536752","AdobeVisitorId":"69695120499382995852106950547488936611","ReferrerUrl":"https://englishlive.ef.com/en-gb/lp/ee/nikol-test/"}
 * +++ mail subscription
 *
 * TODO : add this to Paperier
 *
 */
import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.WebElementHelper;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.pages.core.BasePage;
import com.englishtown.tests.core.BaseTest;
import net.lightbody.bmp.core.har.HarPostDataParam;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import java.util.List;
import java.util.Map;
import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.equalTo;


public abstract class BaseEmailSubscription extends BaseProxyFactory {
    private static final Logger logger = LoggerFactory.getLogger(BaseEmailSubscription.class);
    protected String testURL ;
    protected Map formDataMap;
    protected boolean isSelect = true;
    protected HarPostDataParam harResultPostDataParam;
    protected int nameValueId = 26; // this is the parameter of interest id on the request list of params
    protected List<String> EMAIL_SUBSCRIPTION_LIST = asList("SubscribeToEmailEnglish", "SubscribeToPartnerPromo",
                          "SubscribeToDailyLesson", "SubscribeToETPromo", "SubscribedToEmailEnglish","SubscribeToSMS" );

    protected String expectedValueWhenSelected    = "4,5,17";
    protected String expectedValueWhenNotSelected = "17";
    protected String waitForUrlContains = "NOT-init";


    @Test
    public void enterFormdataSelectSubscribeAndSubmit() {
        TestUtil.enterFormData(driver, formDataMap );
        selectDeselectCheckbox(driver, By.name("dynamicsubscribe"), isSelect );
        //TestUtil.takeScreenshot("nikolEmail", driver, false);
        WebElementHelper.safeFindAndClick(driver, By.cssSelector("button"));
        sleep(5000);
        //TestUtil.takeScreenshot("nikolEmail", driver, false);
        BaseTest.waitForUrlContains(driver, waitForUrlContains, WaitTool.DEFAULT_IMPLICIT_WAIT );
        //TestUtil.takeScreenshot("nikolEmail", driver, false);
        AssertHelper.assertUrlContains(TestUtil.getCurrentUrl(driver), waitForUrlContains, "Current url is not the expeced one ...! Form not submited");
        try {
            harResultPostDataParam = new HarPostDataParam();
            harResultPostDataParam = getHarPostDataParam( proxyServer, harFilter, parameterName);
            logger.info("[ Name :"+harResultPostDataParam.getName()+"; Value :"+harResultPostDataParam.getValue()+"]");
            //TestUtil.takeScreenshot("nikolEmail", driver, false);
        }catch (NullPointerException npe){
            BasePage.failTest("Can't get basic post data values ...! "+npe.getMessage());
        }finally {
            try {
                //if (driver != null) driver.close();
                if (proxyServer != null){
                    proxyServer.endHar();
                    //proxyServer.stop();
                }
            }catch (Exception e){e.printStackTrace();logger.info("Could dont close driver as there are exceptions ...!");}
        }
    }

    @Test (dependsOnMethods = { "enterFormdataSelectSubscribeAndSubmit" })
    public void validateRequestParamsLandingHandlerSubscribeToMailList(){
        logger.info("Check : "+harResultPostDataParam.getValue()+" -should be equalTo "+expectedValueWhenSelected );
        AssertHelper.assertThat("landinghandler posted Data is not the expected one ...!",
                harResultPostDataParam.getValue(), equalTo(expectedValueWhenSelected) );
    }

    @Test (dependsOnMethods = { "validateRequestParamsLandingHandlerSubscribeToMailList" })
    public void setUpEnterFormdataDeSelectSubscribeAndSubmit() {
        //setupChromeWithProxyDriver(testURL);   //setUpProxy(); setupJBorwserProxyDriver
        proxyServer.newHar(); //setupJBorwserProxyDriver(testURL);
        isSelect = false;
        TestUtil.openUrl(driver, testURL);
        TestUtil.enterFormData(driver, formDataMap );
        selectDeselectCheckbox(driver, By.name("dynamicsubscribe"), isSelect );
        WebElementHelper.safeFindAndClick(driver, By.cssSelector("button"));
        BaseTest.waitForUrlContains(driver,waitForUrlContains, WaitTool.DEFAULT_IMPLICIT_WAIT );
        try {
            harResultPostDataParam = getHarPostDataParam( proxyServer, harFilter, parameterName);
            logger.info("[ Name :"+harResultPostDataParam.getName()+"; Value :"+harResultPostDataParam.getValue()+"]");
        }catch (NullPointerException npe){
            BasePage.failTest("Can't get basic post data values ...! "+npe.getMessage());
        }
        finally {
            try {
            if (driver != null) driver.close();
            if (proxyServer != null){
                proxyServer.endHar();
                //proxyServer.stop();
            }
        }catch (Exception e){e.printStackTrace();logger.info("Could not close driver as there are exceptions ...!");}
    }
    }

//   not the case any ore as is only one checbox for agree and promo email
//    @Test (dependsOnMethods = { "setUpEnterFormdataDeSelectSubscribeAndSubmit" })
//    public void validateRequestParamsLandingHandlerSubscribeToMailListUnChecked(){
//        logger.info("Check : "+harResultPostDataParam.getValue()+" -should be equalTo "+expectedValueWhenNotSelected );
//        AssertHelper.assertThat("landinghandler posted Data is not the expected one when subscribe not selected should be empty 2018...!",
//                harResultPostDataParam.getValue(), equalTo(expectedValueWhenNotSelected));//expectedValueWhenNotSelected) );
//    }



}
