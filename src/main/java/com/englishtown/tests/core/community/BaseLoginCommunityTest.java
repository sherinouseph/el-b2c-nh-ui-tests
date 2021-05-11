package com.englishtown.tests.core.community;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

/**
 * Created by nikol.marku on 06/05/2015.
 * All community Login test use this
 *  live active a4sdf3583asd@qp1.org pass: a
 *  when it expire you need to login and buy another offer
 *
 *  2018 community will retire welcome friends
 */

public abstract class BaseLoginCommunityTest extends BaseCommunityTest {
    private static final Logger logger = LoggerFactory.getLogger(BaseLoginCommunityTest.class);

    protected String qaTeacher   = "Eshanghai2"; // 1
    protected String liveTeacher = "Rzhang4917";

    protected final String COMMUNITY_CSS = "deprecation-notice-header";
    protected final String COMMUNITY_GOODBYE_MSG = "Goodbye community";

    @Test
    public void loginCommunityUser(){
        communityHomePage = communityLoginPage.login(testCommunityUsername, testCommunityUserPass);
        communityHomePage.getPageLoadedCondition();
    }

    @Test(dependsOnMethods = { "loginCommunityUser" })
    public void isGoodbyeCommunity(){
        // retire banner shown
        waitForElementCondition(ExpectedConditions.visibilityOfElementLocated(By.className(COMMUNITY_CSS)),
                getWebDriver(), 25 );
        //containsIgnoringCase
        assertWebElementText("."+COMMUNITY_CSS, COMMUNITY_GOODBYE_MSG);
    }


}
