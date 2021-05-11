package com.englishlive.tests.checkout.newcheckout.tr;
/**
 *
 *  3 months offer https://qa-englishlive.ef.com/tr-tr/buy/default/member/?offerid=31361
 *  // 31575    https://qa-englishlive.ef.com/tr-tr/buy/default/member/?offerid=31476 - no PLs
 */

import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.tests.checkout.common.core.ReloginAfterEnrollTest;
import com.englishtown.tests.core.EfConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class CcTRNewHouseCheckoutGoToCampusTest extends ReloginAfterEnrollTest {
    private static final Logger logger = LoggerFactory.getLogger(CcTRNewHouseCheckoutGoToCampusTest.class);
    @Value("#{applicationPropertiesList['new.checkout.member.tr.tr.url']}")
    protected String currMemberPageUrl;

    @Value("#{applicationPropertiesList['page.home.tr.tr.url']}")
    protected String homePageUrl;


    @BeforeClass
    public void setup(){
        setThreadSafeDriver();
      // isUseCustommEmail = true; userEmail = "auto_tr_oldhousehouse_alumni@qp1.org";
        cancelSubscription = false;
        isLogDebug = false; // to log extra info
        isStoreData=true;
        setLanguageAndMarket("tr", "tr");
        password = "passpass";
        //end relogin
        isEnrolStudent = true;        //cancelSubscription = false;
        isRunTestPhoneTextCheckPhoneTxtOnTy = true;   // phone number mast enter on TY
        isPhoneTextInputShownOnTYpage       = true;
        isTypePhoneNumberOnTyPage           = true;
        phoneNubmer = "0875869";
       // isNewHouseEnroll = true;
        checkStateObject=true;
        //isNewhouse =true;//turkey has actually moved to salesforce
        
        //if(StringUtils.equalsIgnoreCase(getENVIRONMENT(), "qa")) {
          // isNewHouseEnroll = true;
           // isRunTestPhoneTextCheckPhoneTxtOnTy = false;
           // currMemberPageUrl = currMemberPageUrl+"?offerid=50014";  //32044";
        //}
        isNewhouseTyPage = true;
        isNewhouseCheckout = true;
        //isNewhousePayment  = true;
        phase1OfferPrice ="99";
        paymentSubmitBtnCss=".btn.btn-primary";
        TestUtil.printMethodName(logger);
        isClickTabId = false;

        formDataMap = EfConstants.ukMembersFormMap_new;

        if(isLogDebug) {
            this.openUrl(getWebDriver(), homePageUrl, -1);
            sleep(2000);
            printUserDateDebug("TR home page");
        }

        logger.info("setup url: "+memberPageUrl);
        //currMemberPageUrl = currMemberPageUrl+"?offerid=50015- NM creted this offer on QA ";
        memberPageUrl = currMemberPageUrl; //.replace("default", "test-only-old-house");
        this.openUrl(getWebDriver(), this.memberPageUrl, -1 ) ;
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

