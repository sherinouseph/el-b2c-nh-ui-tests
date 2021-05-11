//package com.englishlive.tests.checkout.newcheckout.es;
///**
// *Sherin - 24/04/2019 - spain newhouse checkout
// * spain checkout not linked any where in teh website.Hence removing it for now
// *
// */
//import com.englishtown.helpers.utils.TestUtil;
//import com.englishtown.tests.checkout.common.core.NewCcBaseCheckoutFlowTest;
//import com.englishtown.tests.checkout.common.core.ReloginAfterEnrollTest;
//import com.englishtown.tests.core.EfConstants;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//
//
//public class CcESCheckoutTest extends ReloginAfterEnrollTest {
//    private static final Logger logger = LoggerFactory.getLogger(CcESCheckoutTest.class);
//    @Value("#{applicationPropertiesList['checkout.member.es.es.url']}")
//    protected String currMemberPageUrl;
//
//    @BeforeClass
//    public void setup(){
//        setThreadSafeDriver();
//        //isUseCustommEmail = true; userEmail = "send-testspain3@qp1.org";
//        cancelSubscription = true;
//        isEnrolStudent = true;
//        checkStateObject=true;
//        isNewhouseTyPage = true;
//        isNewhouseCheckout = true;
//        //isNewhousePayment  = true;
//       // isNewHouseEnroll=true;
//        password = "passpass";
//        isStoreData = true;
//        paymentSubmitBtnCss = ".btn.btn-primary";
//        setLanguageAndMarket("es", "es");
//        phase1OfferPrice ="9";
//        isEnrolStudent = true;
//        this.memberPageUrl = currMemberPageUrl;
//        this.formDataMap   = EfConstants.esMembersFormMap_new;
//        isClickTabId=false;
//        creditCardLinkText="";
//        openUrl(getWebDriver(), getBASEURL()+"englishlive.ef.com/es-es/study-plans-and-prices/?ctr=es" );
//        String offerWeCss = ".package .btn.btn-primary";
//        waitForElementCondition(ExpectedConditions.elementToBeClickable(By.cssSelector(offerWeCss)), getWebDriver(), 25);
//        WebElement offerWe = findElement(By.cssSelector(offerWeCss), 15);
//        click(offerWe);
//    }
//
//    @Override
//    protected String getMemberPageUrl() {
//        memberPageUrl = currMemberPageUrl;
//        return memberPageUrl;
//    }
//
//    @AfterClass
//    protected void testAfterClass(){
//        destroyDriver();
//    }
//}