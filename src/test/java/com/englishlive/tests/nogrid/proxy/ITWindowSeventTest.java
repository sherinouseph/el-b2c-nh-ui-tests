package com.englishlive.tests.nogrid.proxy;
/**
 * Created by nikol.marku on 3/17/2017.
 * Filter .... [https://efeducationfirst.d1.sc.omtrdc.net/b/ss]
 .enterFormDataSubmitAndGetRequestText
 0 mspassedBaseWindowSeventTest.checkExpectedEvents
 0 mspassedBaseWindowSeventTest.check_C11_PartnerCode
 0 mspassedBaseWindowSeventTest.check_C12_Market
 0 mspassedBaseWindowSeventTest.check_C14_LeadIdCreated
 1 mspassedBaseWindowSeventTest.check_PageName

 *
 * Note: this uses a  local driver ... no grid so when run from TC run on usb5 agent
 *
 */

import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.tests.core.BaseTest;
import com.englishtown.tests.core.EfConstants;
import net.lightbody.bmp.core.har.HarNameValuePair;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static com.englishtown.helpers.CaseInsensitiveSubstringMatcher.containsIgnoringCase;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.text.IsEmptyString.isEmptyOrNullString;


public class ITWindowSeventTest extends BaseProxyFactory {
    public static final Logger logger = LoggerFactory.getLogger(ITWindowSeventTest.class);

    @Value("#{applicationPropertiesList['it.oe']}")
    protected String testUrl;

    public static String osFormSubmitId = "osformsubmit";
    protected String TY_WAITFOR         = ".column3.parsys";

    protected static final String WINDOW_S_EVENTS    = "event4,event5,event46";
    protected final String C11_PARTNER = "goes";
    protected final String C12_MARKET  = "it";
    protected final String C14_LEAD_ID = "43988696"; //12 chars THIS IS A DYNAMIC NUMBER
    protected String leadId;
    protected final String PAGE_NAME   = "LandingPages:ty:lezioni-private";
    protected List<HarNameValuePair> harNameValuePairList;


    @BeforeClass
    protected void setupProxyOpenUrl() {
        isShowBrowserGui = false;
        isDebug = false;
        testDataMap = EfConstants.itFCoeFormMap;
        postRequestTextContais = "events=event4,event5,event46";
        testURL = testUrl; //  "https://englishlive.ef.com/it-it/lp/oe/lezioni-private-1/?ptn=goes";   //

        setupProxyAndDriver();
        TestUtil.openUrl(driver, testURL);
    }

    @Test
    public void enterFormDataSubmitAndGetRequestText() {
        sleep(1000);
        //String agentName = JavaScriptHelper.executeAsyncScript("navigator.userAgent", driver, 10);        logger.info("Agent Name :"+agentName);
        enterFormData(driver, testDataMap);            //TestUtil.takeScreenshot("nikolBeforeSubmit", driver, false);   //WebElementHelper.typeOneCharAtATime("323212312", findElement(driver, By.name("telephone")));        //findElement(driver, By.name("telephone")).sendKeys(Keys.TAB);        //findElement(driver, By.name("telephone")).sendKeys(Keys.ENTER);
        sleep(1000);
        TestUtil testUtil = new TestUtil();
        new TestUtil().takeScreenshot("nikolBeforeSubmit", driver, false);
        driver.findElement( By.name("last_name")).submit();
        // start har capturing ...
        //proxyServer.newHar();
        sleep(5000);
        WaitTool.waitForElementVisible(driver, By.cssSelector(TY_WAITFOR), WaitTool.DEFAULT_IMPLICIT_WAIT);
        AssertHelper.assertWebElementDisplayed(findElement(driver, By.cssSelector(TY_WAITFOR)));
        sleep(1000);
        testUtil.takeScreenshot("nikolAfterSubmit", driver, false);
        harNameValuePairList = getHarRequestPostDataOrQueryString( proxyServer, eventsFilter, searchPostRequestTextContains); //List<HarNameValuePair> harPostQueryString = getHarPostDataQueryStringList( proxyServer, eventsFilter);        //List<HarPostDataParam> postDataParamsList = getHarPostDataParamList( proxyServer, eventsFilter)

        if(harNameValuePairList.isEmpty())
            BaseTest.failTest(" Could not get har Name value pair from post or query string request...!");
    }

    @Test(dependsOnMethods = "enterFormDataSubmitAndGetRequestText")
    void check_PageName(){
        AssertHelper.assertThat("PageName is not the expected one ...!", getHarNameValuePair(harNameValuePairList, "pageName").getValue(), containsIgnoringCase(PAGE_NAME) ); // decodedPostDataText, containsIgnoringCase(PAGE_NAME));
    }

    @Test(dependsOnMethods = "enterFormDataSubmitAndGetRequestText")
    void checkExpectedEvents(){
        AssertHelper.assertThat("Event list is not the expected one ...!", getHarNameValuePair(harNameValuePairList, "events").getValue(), containsIgnoringCase(eventsFired) ); // decodedPostDataText, containsIgnoringCase(postRequestTextContais));
    }

    // c11=Root   partner
    @Test(dependsOnMethods = "enterFormDataSubmitAndGetRequestText")
    void check_C11_PartnerCode(){
        AssertHelper.assertThat("C11 Partner code is not the expected one ...!", getHarNameValuePair(harNameValuePairList, "c11").getValue(), containsIgnoringCase(C11_PARTNER) ); // decodedPostDataText, containsIgnoringCase(C11_PARTNER));
    }

    //c12=it      Market
    @Test(dependsOnMethods = "enterFormDataSubmitAndGetRequestText")
    void check_C12_Market(){
        AssertHelper.assertThat("C12 Market is not the expected one ...!", getHarNameValuePair(harNameValuePairList, "c12").getValue(), containsIgnoringCase(C12_MARKET) );
    }

    //c14=43974466    LeadId
    @Test(dependsOnMethods = "enterFormDataSubmitAndGetRequestText")
    void check_C14_LeadIdCreated(){
        AssertHelper.assertThat("C14 Lead ID is empty or null ...!", getHarNameValuePair(harNameValuePairList, "c14").getValue(), is(not(isEmptyOrNullString())) );
    }

    @AfterClass
    public void destroyDriverAndProxy(){
        //destroyDriverAndProxyServer();
        stopProxy();
        stopDriver();
    }
}





/**************************************************************************
 *
 *
 0 = {HarNameValuePair@5113} "AQB=1"
 1 = {HarNameValuePair@5114} "ndh=1"
 2 = {HarNameValuePair@5115} "pf=1"
 3 = {HarNameValuePair@5116} "t=25/3/2017 8:47:23 2 -60"
 4 = {HarNameValuePair@5117} "sdid=090A2C4A8F57C10B-0771527C2AF78DDE"
 5 = {HarNameValuePair@5118} "D=D="
 6 = {HarNameValuePair@5119} "mid=85516978910398043052298397685046052941"
 7 = {HarNameValuePair@5120} "aamlh=6"
 8 = {HarNameValuePair@5121} "ce=UTF-8"
 9 = {HarNameValuePair@5122} "cdp=2"
 10 = {HarNameValuePair@5123} "pageName=LandingPages:ty:lezioni-private"
 11 = {HarNameValuePair@5124} "g=https://qa-englishlive.ef.com/it-it/lp/ty/lezioni-private/"
 12 = {HarNameValuePair@5125} "r=https://qa-englishlive.ef.com/it-it/lp/oe/ef-lezioni-private/"
 13 = {HarNameValuePair@5126} "cc=USD"
 14 = {HarNameValuePair@5127} "ch=LandingPages"
 15 = {HarNameValuePair@5128} "events=event4,event5,event46,event36=20,event39=24,event38"
 16 = {HarNameValuePair@5129} "aamb=cIBAx_aQzFEHcPoEv0GwcQ"
 17 = {HarNameValuePair@5130} "c1=goes:LandingPages:ty:lezioni-private"
 18 = {HarNameValuePair@5131} "h1=goes,LandingPages,ty:lezioni-private"
 19 = {HarNameValuePair@5132} "h3=LandingPages,ty:lezioni-private"
 20 = {HarNameValuePair@5133} "c4=it:LandingPages:ty:lezioni-private"
 21 = {HarNameValuePair@5134} "c5=none:[LandingPages:ty:lezioni-private]"
 22 = {HarNameValuePair@5135} "v5=none:[LandingPages:ty:lezioni-private]"
 23 = {HarNameValuePair@5136} "v6=LandingPages:ty:lezioni-private"
 24 = {HarNameValuePair@5137} "c8=f956c2e8-2b56-4b00-888a-9c1db3dd3948"
 25 = {HarNameValuePair@5138} "c9=https://qa-englishlive.ef.com/it-it/lp/ty/lezioni-private/"
 26 = {HarNameValuePair@5139} "c11=goes"
 27 = {HarNameValuePair@5140} "v11=goes"
 28 = {HarNameValuePair@5141} "c12=it"
 29 = {HarNameValuePair@5142} "v12=it"
 30 = {HarNameValuePair@5143} "c13=goes:it"
 31 = {HarNameValuePair@5144} "v13=goes:it"
 32 = {HarNameValuePair@5145} "c14=299226"
 33 = {HarNameValuePair@5146} "v14=f956c2e8-2b56-4b00-888a-9c1db3dd3948"
 34 = {HarNameValuePair@5147} "c15=it-it"
 35 = {HarNameValuePair@5148} "v15=it-it"
 36 = {HarNameValuePair@5149} "c16=qa-englishlive.ef.com"
 37 = {HarNameValuePair@5150} "v16=qa-englishlive.ef.com"
 38 = {HarNameValuePair@5151} "c17=LandingPages"
 39 = {HarNameValuePair@5152} "v17=LandingPages"
 40 = {HarNameValuePair@5153} "c18=LandingPages:ty"
 41 = {HarNameValuePair@5154} "v18=LandingPages:ty"
 42 = {HarNameValuePair@5155} "c19=goes:LandingPages"
 43 = {HarNameValuePair@5156} "v19=goes:LandingPages"
 44 = {HarNameValuePair@5157} "c20=goes:LandingPages:ty"
 45 = {HarNameValuePair@5158} "v20=goes:LandingPages:ty"
 46 = {HarNameValuePair@5159} "c21=Visitor"
 47 = {HarNameValuePair@5160} "v21=Visitor"
 48 = {HarNameValuePair@5161} "c23=85516978910398043052298397685046052941"
 49 = {HarNameValuePair@5162} "v23=85516978910398043052298397685046052941"
 50 = {HarNameValuePair@5163} "c24=gb"
 51 = {HarNameValuePair@5164} "v24=gb"
 52 = {HarNameValuePair@5165} "v39=goes:LandingPages:ty:lezioni-private"
 53 = {HarNameValuePair@5166} "v41=LandingPages:ty:lezioni-private"
 54 = {HarNameValuePair@5167} "c45=https://qa-englishlive.ef.com/it-it/lp/oe/ef-lezioni-private/"
 55 = {HarNameValuePair@5168} "v45=LandingPages"
 56 = {HarNameValuePair@5169} "c46=LandingPages:oe:ef-lezioni-private"
 57 = {HarNameValuePair@5170} "v47=LandingPages:ty"
 58 = {HarNameValuePair@5171} "c48=36"
 59 = {HarNameValuePair@5172} "v48=goes:LandingPages"
 60 = {HarNameValuePair@5173} "v49=goes:LandingPages:ty"
 61 = {HarNameValuePair@5174} "v51=goes"
 62 = {HarNameValuePair@5175} "v52=LandingPages"
 63 = {HarNameValuePair@5176} "v53=LandingPages:ty:lezioni-private"
 64 = {HarNameValuePair@5177} "v70=LandingPages:oe:ef-lezioni-private"
 65 = {HarNameValuePair@5178} "v95=299226"
 66 = {HarNameValuePair@5179} "s=1920x1080"
 67 = {HarNameValuePair@5180} "c=24"
 68 = {HarNameValuePair@5181} "j=1.6"
 69 = {HarNameValuePair@5182} "v=N"
 70 = {HarNameValuePair@5183} "k=Y"
 71 = {HarNameValuePair@5184} "bw=1848"
 72 = {HarNameValuePair@5185} "bh=975"
 73 = {HarNameValuePair@5186} "AQE=1"


 if(harNameValuePairList.isEmpty()) {                                            //(!StringUtils.isBlank(postDataText)){
 logger.info(" Test data retrieved need to be decoded ...!");
 //decodedPostDataText = TestUtil.decode(postDataText, "utf-8");            //logger.info(" Decoded [decodedPostDataText] text is :"+decodedPostDataText);
 }else {
 logger.info("postDataText is empty .....!");
 }


 void check_C14_LeadIdCreated(){
 String[] tmpParams = null;
 try{
 tmpParams = decodedPostDataText.split("&");
 for(String keyValue : tmpParams){
 if(StringUtils.containsIgnoreCase(keyValue, "c14=")){
 logger.info("Found 'c14=' Key ...!");
 leadId = keyValue.split("=")[1];
 logger.info("leadId {{}}", leadId);
 }
 }
 if (null == leadId)
 BaseTest.failTest("Could not find LeadId, is NULL 'c14=' key ...!");
 }catch (Exception e){
 logger.error("Cant get Lead ID part ....!"+e.getMessage());
 BaseTest.failTest("Could not find LeadId 'c14=' key ...!");
 }
 AssertHelper.assertThat("Lead ID is not the expected one ...!", leadId.length(), greaterThan(5));
 }


 */
