//package com.englishlive.tests.checkout.newcheckout.de;
///**
// * Open price page and click try us
// * Enter phone on member form
// * phone filed is not shown on new TY page
// *
// */
//import com.englishtown.helpers.utils.TestUtil;
//import com.englishtown.tests.checkout.common.core.NewCcBaseCheckoutFlowTest;
//import com.englishtown.tests.core.EfConstants;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//
//
//public class CcDECheckoutWithPhoneTest extends NewCcBaseCheckoutFlowTest {
//    private static final Logger logger = LoggerFactory.getLogger(CcDECheckoutWithPhoneTest.class);
//    @Value("#{applicationPropertiesList['de.price.page']}")   //new.checkout.member.de.de.url
//    protected String currMemberPageUrl;       //protected String payButtonSelector = "form_tabctrl_tab-0_button"; //id   // .nav-tabs a fr pay page 2 tabs card pay and pay pal
//
//
//    @BeforeClass
//    public void setup(){
//        setThreadSafeDriver();
//        phase1OfferPrice ="59";
//        TestUtil.printMethodName(logger);
//        creditCardLinkText="Kreditkarte";
//        isClickTabId = true;
//        tabId = 1;
//        memberPageUrl = currMemberPageUrl;
//        formDataMap = EfConstants.deMembersWithPhoneMap;
//        logger.info("setup url: "+memberPageUrl);
//        openUrl(getWebDriver(), this.memberPageUrl, -1 ) ; //getWebDriver().get(this.memberPageUrl);
//        logger.info("Price page opened ...! ");
//        WebElement tryUs = findElement(By.cssSelector(".package .btn.btn-primary"));
//        click(tryUs);
//    }
//
//    @AfterClass
//    protected void testAfterClass(){
//        destroyDriver();
//    }
//
//
//
//    @Override
//    protected String getMemberPageUrl() {
//        memberPageUrl = currMemberPageUrl;
//        return memberPageUrl;
//    }
//
//
//}
//
