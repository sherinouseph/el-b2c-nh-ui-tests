package com.englishlive.tests.community;

/**
 * Nikol Apr 2018
 * Login in and check Goodbye community. Hello ‘Friends'. Web element shown and text content is the expected one
 *
 */

import com.englishtown.pages.community.CommunityLoginPage;
import com.englishtown.tests.core.community.BaseLoginCommunityTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class RetireCommunityBannerTest extends BaseLoginCommunityTest {
    private static final Logger logger = LoggerFactory.getLogger(RetireCommunityBannerTest.class);
    @Value("#{applicationPropertiesList['community.login.url']}")
    protected String pageUrl;


    @BeforeClass
    protected void setup(){
        setThreadSafeDriver();
        testCommunityUsername = getActiveUserPerEnv();
        testCommunityUserPass = "a";
        openUrl(getWebDriver(), pageUrl);
        communityLoginPage = new CommunityLoginPage(getWebDriver());
    }

    @AfterClass
    protected void testAfterClass(){
        destroyDriver();
    }

}
