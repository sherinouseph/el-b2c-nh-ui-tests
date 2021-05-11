//package com.englishlive.tests.nogrid.proxy;
///**
// * Created by sherin.ouseph on 3/17/2017.
// * Filter .... [https://efeducationfirst.d1.sc.omtrdc.net/b/ss]
// * checking for purchase,event2,event50 and event 51 after the submit from password page
// *
// * Note: this uses a  local driver ... no grid so when run from TC run on hub
// *
// */
//
//// form does not go to password page any more
//import com.englishtown.helpers.AssertHelper;
//import com.englishtown.helpers.JavaScriptHelper;
//import com.englishtown.helpers.WaitTool;
//import com.englishtown.helpers.utils.TestUtil;
//import com.englishtown.tests.core.BaseTest;
//import com.englishtown.tests.core.BaseTestHelper;
//import com.englishtown.tests.core.EfConstants;
//import com.englishtown.tests.core.UniqueDataObject;
//import net.lightbody.bmp.core.har.HarNameValuePair;
//import org.openqa.selenium.By;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//import java.util.List;
//import java.util.Map;
//
//import static com.englishtown.helpers.CaseInsensitiveSubstringMatcher.containsIgnoringCase;
//import static org.hamcrest.CoreMatchers.is;
//import static org.hamcrest.core.IsNot.not;
//
//
//public class CoPasswordEventTest extends BaseProxyFactory {
//    public static final Logger logger = LoggerFactory.getLogger(CoPasswordEventTest.class);
//
//    @Value("#{applicationPropertiesList['page.home.es.co.url']}")
//    protected String testUrl;
//    protected Map  passwordmap= EfConstants.passwordform;
//    protected String[] eventsFired = {"purchase","event2","event50","event51"};
//    protected List<HarNameValuePair> harNameValuePairList;
//    public String emailToken = new UniqueDataObject().getEmail();
//    protected String submitFormBtnCss      = ".btn.btn-primary";
//
//
//    @BeforeClass
//    protected void setupProxyOpenUrl() {
//        searchPostRequestTextContains = "purchase,event2,event50,event51";
//        isShowBrowserGui = false;
//        isDebug = false;
//        waitForUrlContains = "thank";
//        testDataMap = EfConstants.coFormMap;
//        postRequestTextContais = "events=purchase,event2,event50,event51";
//        testURL = testUrl;
//        submitFormBtnCss = "#-rsrc--content--englishtown--mx--es--jcr__content--main-parsys--stage_stretchable--form-panel--form-button";
//        setupProxyAndDriver(); //setupChromeWithProxyDriver(testUrl);
//        //driver = ThreadSafeProxy.getWebDriver();
//        TestUtil.openUrl(driver, testURL);
//        sleep(2000);
//        // close popup
//        findElement(driver, By.cssSelector(".close.close--common"));
//        JavaScriptHelper.clickAtWindowXY(driver, 3, 3);
//    }
//
//    @Test
//    public void enterFormDataSubmitAndGetRequestText() {
//        enterFormData(driver, testDataMap);
//        driver.findElement(By.name("email")).clear();
//        driver.findElement(By.name("email")).sendKeys(emailToken);
//        driver.findElement( By.cssSelector(submitFormBtnCss)).click();
//        sleep(1000);        //enterFormData(driver, passwordmap);
//
//        //driver.findElement( By.cssSelector(submitFormBtnCss)).click();
//        sleep(2000);
//
//        BaseTestHelper.waitForUrlContains(driver, waitForUrlContains, WaitTool.MED_WAIT_4_ELEMENT25);
//
//        TestUtil testUtil = new TestUtil();
//        new TestUtil().takeScreenshot("SubmittingForm ", driver, false);
//
//        harNameValuePairList = getHarRequestPostDataOrQueryString(proxyServer, eventsFilter, searchPostRequestTextContains); //;proxyServer List<HarNameValuePair> harPostQueryString = getHarPostDataQueryStringList( proxyServer, eventsFilter);        //List<HarPostDataParam> postDataParamsList = getHarPostDataParamList( proxyServer, eventsFilter)
//        if(harNameValuePairList.isEmpty())
//            BaseTest.failTest(" Could not get har Name value pair from post or query string request...!");
//        String actEventname=getHarNameValuePair(harNameValuePairList, "events").getValue();
//    }
//
//
//    @Test(dependsOnMethods = "enterFormDataSubmitAndGetRequestText")
//    void checkExpectedEvents_purchase() {
//        String actEventname = getHarNameValuePair(harNameValuePairList, "events").getValue();
//        logger.info("searching for " + eventsFired[0] + " in " + actEventname);
//        AssertHelper.assertThat("Event is not in the Event List...!", actEventname, containsIgnoringCase(eventsFired[0]));
//    }
//    @Test(dependsOnMethods = "enterFormDataSubmitAndGetRequestText")
//    void checkExpectedEvents_event2() {
//        String actEventname = getHarNameValuePair(harNameValuePairList, "events").getValue();
//        logger.info("searching for " + eventsFired[1] + " in " + actEventname);
//        AssertHelper.assertThat("Event is not in the Event List...!", actEventname, containsIgnoringCase(eventsFired[1]));
//    }
//
//    @Test(dependsOnMethods = "enterFormDataSubmitAndGetRequestText")
//    void checkExpectedEvents_event50() {
//        String actEventname = getHarNameValuePair(harNameValuePairList, "events").getValue();
//        logger.info("searching for " + eventsFired[2] + " in " + actEventname);
//        AssertHelper.assertThat("Event is not in the Event List...!", actEventname, containsIgnoringCase(eventsFired[2]));
//    }
//
//    @Test(dependsOnMethods = "enterFormDataSubmitAndGetRequestText")
//    void checkExpectedEvents_event51() {
//        String actEventname = getHarNameValuePair(harNameValuePairList, "events").getValue();
//        logger.info("searching for " + eventsFired[2] + " in " + actEventname);
//        AssertHelper.assertThat("Event is not in the Event List...!", actEventname, containsIgnoringCase(eventsFired[3]));
//    }
//
//    @AfterClass
//    public void destroyDriverAndProxy(){
//        //destroyDriverAndProxyServer();
//        stopProxy();
//        stopDriver();
//    }
//
//   }
//
//
//
//
