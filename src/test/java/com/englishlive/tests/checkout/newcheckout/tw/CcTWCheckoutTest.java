//package com.englishlive.tests.checkout.newcheckout.tw;
///**
// *
// * OS only
// */
//import com.englishtown.helpers.utils.TestUtil;
//import com.englishtown.tests.checkout.common.core.NewCcBaseCheckoutFlowTest;
//import com.englishtown.tests.core.EfConstants;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//
//    // TODO Karim to provide and offer that works  - new offers reversed back to the old one
//
///**
// *
// * Update links, 666 offer:
// * https://englishlive.ef.com/zh-tw/study-plans-and-prices/?at_preview_token=BJZUYhQ7P%2FtS78LXJ9zNbDoRpzFwzm8KDC3s3QXdB2Y%3D&at_preview_index=1_1&at_preview_listed_activities_only=true
// *
// *
// * 3,500 offer:
// * https://englishlive.ef.com/zh-tw/study-plans-and-prices/?at_preview_token=BJZUYhQ7P%2FtS78LXJ9zNbDoRpzFwzm8KDC3s3QXdB2Y%3D&at_preview_index=1_2&at_preview_listed_activities_only=true
// */
//public class CcTWCheckoutTest extends NewCcBaseCheckoutFlowTest {
//    private static final Logger logger = LoggerFactory.getLogger(CcTWCheckoutTest.class);
//    @Value("#{applicationPropertiesList['new.checkout.member.zh.tw.url']}")
//    protected String currMemberPageUrl;
//
//    @BeforeClass
//    public void setup(){
//        setThreadSafeDriver();
//        isNewhouseTyPage = true;
//        paymentSubmitBtnCss = ".btn.btn-primary";
//        String offerId = "34219";  // karim adviced 34056 was 34054 but both not working
//        phase0OfferPrice="3500";        //3500paymentSubmitBtnCss = ".bs3 .btn";
//        TestUtil.printMethodName(logger);
//        isClickTabId = false;
//        setLanguageAndMarket("zh","tw");
////        currMemberPageUrl = "https://englishlive.ef.com/zh-tw/study-plans-and-prices/?at_preview_token=" +
////                "BJZUYhQ7P%2FtS78LXJ9zNbDoRpzFwzm8KDC3s3QXdB2Y%3D&at_preview_index=1_1&at_preview_listed_activities_only=true";
//        currMemberPageUrl = "https://englishlive.ef.com/zh-tw/study-plans-and-prices/?at_preview_token=BJZUYhQ7P%2FtS78LXJ9zNbDoRpzFwzm8KDC3s3QXdB2Y%3D&at_preview_index=1_2&at_preview_listed_activities_only=true";
//       // memberPageUrl = currMemberPageUrl + "?offerid="+offerId;
//        formDataMap = EfConstants.ukMembersFormMap_new_withPhone;
//        logger.info("setup url: "+currMemberPageUrl);
//        openUrl(getWebDriver(), currMemberPageUrl, -1 ) ;
//        waitForElementVisibleAndClick(getWebDriver(), ".final-cta button", 35);
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
//
//}
//
