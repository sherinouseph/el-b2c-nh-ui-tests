package com.englishlive.tests.efenglishtown.flows.checkout;
/**
 *
 * Add test to check PTN and etag in TY page
 */
import com.englishlive.tests.checkout.newcheckout.core.simple.BaseFreeStyleCheckout;
import com.englishtown.helpers.WebDriverWindowHelper;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.tests.core.EfConstants;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class JaCcOStoCheckoutTest extends BaseFreeStyleCheckout {
    private static final Logger logger = LoggerFactory.getLogger(JaCcOStoCheckoutTest.class);
    @Value("#{applicationPropertiesList['ja.os.ptn2.url']}")
    protected String testUrl;

    final String BUY_BTN = ".primary .cta button"; //"ctaNavbar_linkbutton-5717";//"stage_linkbutton"; //
    final String  PTN  = "aeig" ;
    final String  ETAG = "GOJP_SB_OS_ETB_JPN_NTV";

     @BeforeClass
     public void setup(){
         setThreadSafeDriver();
         phase1OfferPrice="8690";//8532
         paymentSubmitBtnCss = ".btn.btn-primary";//".bs3 .btn";
         failTestIfIsNotBrowser(CHROME_BROWSER_LIST, "Chrome Only Test ....!");
         TestUtil.printMethodName(logger);
         setLanguageAndMarket("ja","jp");
         isClickTabId = false;
         submitMemberBtnSelector = ".btn.btn-primary";
         isNewhouseTyPage = true;
         memberFormMap = EfConstants.ukMembersFormMap_new;
         logger.info("setup url: "+testUrl);
         if(StringUtils.contains(getENVIRONMENT(), "qa")){
             testUrl = StringUtils.replace(testUrl, "qa-", "qa.");
         }
         openUrl(getWebDriver(), testUrl, -1 ) ;
         click(getWebDriver(), By.cssSelector(BUY_BTN));
         sleep(3000);
         WebDriverWindowHelper.switchToWindow(getWebDriver(), 1);

     }


     @Test (priority = 20)
     public void checkPtnOnThankyouPage(){
         assertStateObjectValue("session.partner_code", PTN);
     }

//    @Test (priority = 20)
//    public void checkEtagOnThankyouPage(){
//        assertStateObjectValue("session.etag", ETAG);
//    }

    @AfterClass
    protected void testAfterClass(){
        destroyDriver();
    }

}

