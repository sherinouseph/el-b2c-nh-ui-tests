//package com.englishlive.tests.landing.sa.oe;
//
//import com.englishtown.helpers.AssertHelper;
//import com.englishtown.helpers.JavaScriptHelper;
//import com.englishtown.helpers.utils.TestUtil;
//import com.englishtown.pages.core.BasePage;
//import com.englishtown.tests.core.BaseTestHelper;
//import com.englishtown.tests.core.EfConstants;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.*;
//
//import static org.hamcrest.CoreMatchers.containsString;
//
///**
// * Created by nikol.marku on 03/06/2016.
// * url archived
// */
//public class SAwwsLpChangeCountryTest extends BaseTestHelper {
//    private static final Logger logger = LoggerFactory.getLogger(SAwwsLpChangeCountryTest.class);
//    @Value("#{applicationPropertiesList['sa.lp.os']}")
//    private String testUrl;
//
//    protected String urlContains = "crm-business-english";
//    // add this on the page then change country then wait for this to disappear to make sure new page is loaded
//    protected final String addJSfirstPage =  "window.firstPage" ;
//
//
//    @BeforeClass
//    public void setUpOpenUrl() {
//        logger.info("setUpOpenUrl openUrl {"+testUrl+"}");
//        openUrl(getWebDriver(), testUrl);
//    }
//
//    @Test
//    protected void changeCountryShouldNotRedirectToHomePage(){
//        JavaScriptHelper.executeJavaScript(addJSfirstPage+"=true", getWebDriver());
//        enterFormData(EfConstants.SA_WWS_LP);
//        sleep(2000);
//        boolean isJSvariableOnThePage = JavaScriptHelper.waitJSvariableNotPresent(addJSfirstPage, getWebDriver(), 15);
//        logger.info("is JS variable on the page ? is page reloaded/refreshed :"+isJSvariableOnThePage);
//        if(!isJSvariableOnThePage){
//            failTest("Page is not reloaded/refreshed after change country; So test stop here ...!"+TestUtil.getCurrentUrl(getWebDriver()));
//        }
//        BasePage.waitForUrlContains(getWebDriver(), urlContains, 5);
//        String currentUrl = TestUtil.getCurrentUrl(getWebDriver());
//        AssertHelper.assertThat("Url does not contain expected String ....!", currentUrl, containsString(urlContains));
//    }
//}
