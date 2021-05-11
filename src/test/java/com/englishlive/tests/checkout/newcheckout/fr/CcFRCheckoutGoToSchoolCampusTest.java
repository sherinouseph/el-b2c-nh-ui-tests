//package com.englishlive.tests.checkout.newcheckout.fr;
///**
// *
// *
// */
//
//import com.englishtown.helpers.utils.TestUtil;
//import com.englishtown.tests.checkout.common.core.CheckEnrolmentTest;
//import com.englishtown.tests.core.EfConstants;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//
//
//public class CcFRCheckoutGoToSchoolCampusTest extends CheckEnrolmentTest{ //CheckCampusPageTest {
//    private static final Logger logger = LoggerFactory.getLogger(CcFRCheckoutGoToSchoolCampusTest.class);
//    @Value("#{applicationPropertiesList['new.checkout.member.fr.fr.url']}")
//    protected String currMemberPageUrl;
//    protected String payButtonSelector = "form_tabctrl_tab-0_button"; //id
//    // .nav-tabs a fr pay page 2 tabs card pay and pay pal
//
//    @BeforeClass
//    public void setup(){
//        setThreadSafeDriver();
//        phase0OfferPrice ="89";
//        TestUtil.printMethodName(logger);
//        this.memberPageUrl = currMemberPageUrl;
//        creditCardLinkText="Carte";
//        tabId = 0;
//        formDataMap = EfConstants.ukMembersFormMap_new;
//        logger.info("setup url: "+memberPageUrl);
//        this.openUrl(getWebDriver(), this.memberPageUrl, 35 ) ;
//    }
//
//    @Override
//    protected String getMemberPageUrl() {
//        memberPageUrl = currMemberPageUrl;
//        return memberPageUrl;
//    }
//
//    @Override
//    public void check_EnrolmentPage() {
//        /* FR only */
//        assertIsUrlContaining("enrollment/b2c/entrance");
//       // waitForElementCondition(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ue-logo")), getWebDriver(), 30);
//    }
//
//    @AfterClass
//    protected void testAfterClass(){
//        destroyDriver();
//    }
//
//}
//
