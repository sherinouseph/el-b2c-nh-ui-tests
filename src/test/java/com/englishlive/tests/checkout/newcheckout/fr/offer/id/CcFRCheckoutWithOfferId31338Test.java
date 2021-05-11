//package com.englishlive.tests.checkout.newcheckout.fr.offer.id;
///**
// *
// *
// */
//import com.englishtown.helpers.UrlMapper;
//import com.englishtown.helpers.utils.TestUtil;
//import com.englishtown.tests.checkout.common.core.NewCcBaseCheckoutFlowTest;
//import com.englishtown.tests.core.EfConstants;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//
//
//public class CcFRCheckoutWithOfferId31338Test extends NewCcBaseCheckoutFlowTest {
//    private static final Logger logger = LoggerFactory.getLogger(CcFRCheckoutWithOfferId31338Test.class);
//    @Value("#{applicationPropertiesList['member.fr.fr.offerid31338.url']}")
//    protected String currMemberPageUrl;
//    protected String payButtonSelector = "form_tabctrl_tab-0_button"; //id
//
//
//    @BeforeClass
//    public void setup(){
//        TestUtil.printMethodName(logger);
//       //currMemberPageUrl = UrlMapper.mapUrlToELive(currMemberPageUrl, getBASEURL());
//        this.memberPageUrl = currMemberPageUrl;
//        creditCardLinkText="Carte";
//        tabId = 0;
//        formDataMap = EfConstants.ukMembersFormMap_new;
//        logger.info("setup url: "+memberPageUrl);
//        this.openUrl(getWebDriver(), this.memberPageUrl, -1 ) ;
//    }
//
//    @Override
//    protected String getMemberPageUrl() {
//        memberPageUrl = currMemberPageUrl;
//        return memberPageUrl;
//    }
//
//}
//
