//package com.englishlive.tests.home.it;
///**
// *
// */
//import com.englishtown.helpers.UrlMapper;
//import com.englishtown.helpers.WaitTool;
//import com.englishtown.tests.core.common.ProactiveChatBaseTest;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//
//
//public class ItProactiveChatTest extends ProactiveChatBaseTest {
//    @Value("#{applicationPropertiesList['home.it.it.url']}")
//    public String pageUrl;
//
//    @BeforeClass
//    protected void setup() {
//        this.chatIdBtn = "liveagent_button_online_573900000004QIE";
//        //pageUrl = UrlMapper.mapUrlToELive(pageUrl, getBASEURL());
//        this.openUrl(getWebDriver(),pageUrl, WaitTool.MED_WAIT_4_ELEMENT);
//    }
//
//}
