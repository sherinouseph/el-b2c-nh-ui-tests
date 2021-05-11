//package com.englishlive.tests.home.de;
///**
// * chat is shown if agent available
// */
//import com.englishtown.helpers.UrlMapper;
//import com.englishtown.helpers.WaitTool;
//import com.englishtown.tests.core.common.ProactiveChatBaseTest;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//
//
//public class DeProactiveChatTest extends ProactiveChatBaseTest {
//    @Value("#{applicationPropertiesList['home.de.de.url']}")
//    public String pageUrl;
//
//    @BeforeClass
//    protected void setup() {
//        chatIdBtn = "liveagent_button_online_573900000004QI4";
//        //pageUrl = UrlMapper.mapUrlToELive(pageUrl, getBASEURL());
//        this.openUrl(getWebDriver(),pageUrl, WaitTool.MED_WAIT_4_ELEMENT);
//    }
//
//}
