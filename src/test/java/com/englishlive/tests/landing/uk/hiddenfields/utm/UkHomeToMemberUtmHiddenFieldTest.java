//package com.englishlive.tests.landing.uk.hiddenfields.utm;
///**
// *  Open homepage URL with params then oppen member page and check hidden fields  see $oldHiddenFieldIds
// */
//import com.englishtown.tests.core.hiddenfields.BaseUtmHiddenField;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//
//
//public class UkHomeToMemberUtmHiddenFieldTest extends BaseUtmHiddenField {
//    private static final Logger logger = LoggerFactory.getLogger(UkHomeToMemberUtmHiddenFieldTest.class);
//
//    @Value("#{applicationPropertiesList['uk.home.utm.url']}")
//    private String homepage;
//    @Value("#{applicationPropertiesList['new.checkout.base.en.en.url']}")
//    private String memberPage;
//
//
//    @BeforeClass
//    public void setup(){
//        oldHiddenFieldIds = new String[]{"member.AdGroup", "member.UtmCampaign", "member.UtmContent", "member.UtmMedium", "member.UtmSource", "member.UtmTerm"};
//        this.openUrl(getWebDriver(), this.homepage, -1 ) ;
//        sleep(3000);//!!!!!
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
