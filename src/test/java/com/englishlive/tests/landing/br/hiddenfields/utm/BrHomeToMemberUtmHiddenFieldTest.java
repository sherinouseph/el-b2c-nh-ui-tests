//package com.englishlive.tests.landing.br.hiddenfields.utm;
///**
// *  Open homepage URL with params then oppen member page and check hidden fields  see $oldHiddenFieldIds
// */
//import com.englishtown.tests.core.hiddenfields.BaseUtmHiddenField;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//
// // not available for BR
//public class BrHomeToMemberUtmHiddenFieldTest extends BaseUtmHiddenField {
//    private static final Logger logger = LoggerFactory.getLogger(BrHomeToMemberUtmHiddenFieldTest.class);
//
//    @Value("#{applicationPropertiesList['br.home.utm.url']}")
//    private String homepage;
//    @Value("#{applicationPropertiesList['checkout.member.br.br.url']}")
//    private String memberPage;
//
//
//    @BeforeClass
//    public void setup(){
//        oldHiddenFieldIds = new String[]{"member.AdGroup", "member.UtmCampaign", "member.UtmContent", "member.UtmMedium", "member.UtmSource", "member.UtmTerm"};
//        this.openUrl(getWebDriver(), this.homepage, -1 ) ;
//        sleep(2000);//!!!!!
//        this.openUrl(getWebDriver(), this.memberPage, -1 ) ;
//        waitForHidenField(oldHiddenFieldIds[0], 25);
//    }
//
//
//}
//
//
//
//
