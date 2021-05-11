//package com.englishtown.tests.core.stateobject;
///**
// * Open URL
// * check partner_code on session and page object as well as
// * tracking.qubit_enabled
// * https://jira-bos.englishtown.com/browse/SAND-2488
// */
//
//import com.englishlive.tests.redirect.core.BaseHtmlUnitDriverConfig;
//import com.englishtown.dataprovider.UrlDataProvider;
//import com.englishtown.helpers.CookieHandler;
//import com.englishtown.helpers.utils.TestUtil;
//import com.englishtown.pages.core.BasePage;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.Test;
//
//
//public abstract class BaseCheckPartnerAndCubitTrackin extends BaseHtmlUnitDriverConfig {
//    private static final Logger logger = LoggerFactory.getLogger(BaseCheckPartnerAndCubitTrackin.class);
//   // test set this up
//    protected static String testUrl;
//    protected String stateObjKeySessionPartner  = "session.partner_code";
//    protected String stateObjKeyPagePartner     = "page.partner_code";
//    protected String stateObjKeyTrackEventCubit = "tracking.qubit_enabled";//true  qubit_enabled
//
//    protected String url = null;
//    protected static String ptn = null;
//    protected static String failureMsg="";
//    private int failCount=0;
//
//
//    @Test(dataProvider = "rolaPartnerTestData", dataProviderClass = UrlDataProvider.class )
//    public void openUrl_Test_Page_Session_Partners_Cubit_Rola(String id, String ptn) throws Exception{
//        try {
//            url = testUrl+"?ptn="+ptn;
//            logger.info("Page URL is : " + url);
//            openUrl(getWebDriver(), url);
//            sleep(3000);
//            try {
//                assertStateObjectValue(stateObjKeySessionPartner, ptn);
//                assertStateObjectValue(stateObjKeyPagePartner, ptn);
//                assertStateObjectValue(stateObjKeyTrackEventCubit, "true");
//            }catch (Exception ae){
//                failCount++;                //failureMsg = failureMsg+"\nFailt count is : "+failCount+"; url is :"+url+" ; Exception "+TestUtil.getException(ae) ;
//                logger.error(" Failed ...!"+ae.getMessage()+"\nfailureMsg :");
//            }
//        } catch ( Exception we) {
//            logger.error("Failed to open URL ....! WebDriverException  assertStateObjectValue : ptn :"+ptn+" \n " +
//                    TestUtil.getException(we)+"\n\t ...! FAIL count is : "+failCount);
//        }
//        finally {
//                if(failCount > 0){
//                    BasePage.failTest(" There are failures on this test : Fail count ["+failCount+"] ...!;");
//                }
//        }
//    }
//
//    @AfterMethod
//    protected void deleteCookies() throws Exception {
//        logger.info("AfterMethod Deleting cookies ....!");
//        CookieHandler.deleteCookies(getWebDriver());
//    }
//}
