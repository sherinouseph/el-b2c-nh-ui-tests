package com.englishlive.tests.checkout.newcheckout.uk;
/**
 * New checkout uk
 * 
 */

import com.englishtown.tests.checkout.common.core.ReloginAfterEnrollTest;
import com.englishtown.tests.core.EfConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class CcUKCheckoutGoToSchoolCampusTest extends ReloginAfterEnrollTest { //CheckCampusPageTest {
    private static final Logger logger = LoggerFactory.getLogger(CcUKCheckoutGoToSchoolCampusTest.class);
    @Value("#{applicationPropertiesList['checkout.member.en.en.url']}")
    protected String currMemberPageUrl;

    @BeforeClass
    public void setup(){
        setThreadSafeDriver();
        //isUseCustommEmail = true; userEmail = "auto_gb_markforcancel1x@qp1.org";
        cancelSubscription = false;
        isEnrolStudent = true;        //cancelSubscription = false;
        isRunTestPhoneTextCheckPhoneTxtOnTy = true;   // phone number mast enter on TY
        isPhoneTextInputShownOnTYpage       = true;
        isTypePhoneNumberOnTyPage           = true;
        phoneNubmer = "0875869";

        //isNewHouseEnroll = true;
        checkStateObject=true;
        isNewhouseTyPage = true;
        isNewhouseCheckout = true;
        //isNewhousePayment  = true;

        /*isNewHouseEnroll = true;
        checkStateObject=true;
        isNewhouseTyPage = true;
        isNewhouseCheckout = true;
        isNewhousePayment  = true;*/

        //currMemberPageUrl = "https://englishlive.ef.com/en-gb/buy/test-default-2/member/?offerid=30582";
        /*currMemberPageUrl = "https://englishlive.ef.com/en-gb/buy/default/member/?offerid=9500&ctr=es";
        "https://englishlive.ef.com/en-gb/buy/test-default-2/member/?offerid=30999"
        "https://englishlive.ef.com/en-gb/buy/test-default-2/member/?offerid=30582"        29183 -    2044  */
        password = "passpass";
        //if(StringUtils.equalsIgnoreCase(getENVIRONMENT(), "qa")) {            isNewHouseEnroll = true;            isRunTestPhoneTextCheckPhoneTxtOnTy = false;        }
        isStoreData = true;
        //isNewhouseCheckout = true;
        //isNewhousePayment=true;
        //isNewHouseEnroll=true;

        paymentSubmitBtnCss = ".btn.btn-primary";
        setLanguageAndMarket("en", "gb");
        //cancelSubscription = false;
        phase1OfferPrice ="49";
        isEnrolStudent = true;
        this.memberPageUrl = currMemberPageUrl;
        this.formDataMap   = EfConstants.ukMembersFormMap_new;
        isClickTabId=false;
        creditCardLinkText="";
        //logger.info("setup url: "+memberPageUrl);
        //
        openUrl(getWebDriver(), getBASEURL()+"englishlive.ef.com/en-gb/study-plans-and-prices/?ctr=gb" );
        String offerWeCss = ".package .btn.btn-primary";
        //waitForElementVisibleAndClick(offerWeCss, 25);
        waitForElementCondition(ExpectedConditions.elementToBeClickable(By.cssSelector(offerWeCss)), getWebDriver(), 25);
        WebElement offerWe = findElement(By.cssSelector(offerWeCss), 15);
        click(offerWe);
        //   this.openUrl(getWebDriver(), this.memberPageUrl, -1) ;
    }

    @Override
    protected String getMemberPageUrl() {
        memberPageUrl = currMemberPageUrl;
        return memberPageUrl;
    }

    @AfterClass
    protected void testAfterClass(){
        destroyDriver();
    }

}