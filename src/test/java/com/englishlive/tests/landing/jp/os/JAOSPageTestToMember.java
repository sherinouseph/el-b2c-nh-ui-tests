package com.englishlive.tests.landing.jp.os;

import com.englishlive.tests.landing.base.BaseOSPageTest;
import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.pages.landing.OSLandingPage;
import com.englishtown.tests.core.BaseTestHelper;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class JAOSPageTestToMember extends BaseTestHelper {
    private static final Logger logger = LoggerFactory.getLogger(JAOSPageTestToMember.class);
    @Value("#{applicationPropertiesList['ja.lp.os']}")
    private String osPageUrl;

    protected String buyProductCss = "#stage_spacer_spacercontent_spacer-0_spacercontent_spacer_spacercontent_spacer_spacercontent_linkbutton";
    protected String waitForUrl = "ja-jp/buy/default/member/";

    @BeforeClass
    protected void setupBeforeClass(){
        setThreadSafeDriver();
        openUrl(getWebDriver(), osPageUrl);
    }

    @Test
    void osGoesToMemberPage(){
        click(findElement(By.cssSelector(buyProductCss)));
        waitForUrlContains(getWebDriver(), waitForUrl, 25);
        AssertHelper.assertUrlContains(TestUtil.getCurrentUrl(getWebDriver()), waitForUrl, " Url is not the expected one ....!");
    }

    @AfterClass
    protected void testAfterClass(){
        destroyDriver();
    }
}




