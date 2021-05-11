package com.englishlive.tests.newhouse.school.upsell.tr;
/**
 *
 * User: nikol.marku
 * Date: 05/02/18
 *
 *  Upsell redirect test when user has no credits for PLs/GLs
 */


import com.englishtown.helpers.WaitTool;
import com.englishtown.newhouse.school.pages.home.SchoolHomePage;
import com.englishtown.tests.core.school.upsell.BaseUpsellRedirectTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class TRUpsellRedirectTest extends BaseUpsellRedirectTest {
    private static final Logger logger = LoggerFactory.getLogger(TRUpsellRedirectTest.class);
    @Value("#{applicationPropertiesList['tr.tr.login.url']}")
    protected String testUrl;
    @Value("#{applicationPropertiesList['tr.upsell.redirect']}")
    protected String testUsername;


    @BeforeClass
    protected void setup(){
        setThreadSafeDriver();
        password = "passpass";
        setLanguageAndMarket("tr", "tr");
        testStartUrl = testUrl;
        username = testUsername;
        setUserEmail(testUsername);

        upsellUrl ="englishlive.ef.com/"+getLanguage()+"-"+getMarket()+"/buy/upsell-nh/upsell";

        openUrl(getWebDriver(), testStartUrl);
    }

    @Override
    protected void checkUserIsAtSchoolHomePage(){
        logger.info("Override checkUserIsAtSchoolHomePage  check URL not contains login .... as user might not be in this page ...!");
        waitForUrlNotContaining(getWebDriver(), "login", WaitTool.MED_WAIT_4_ELEMENT);
        sleep(1000);
        schoolHomePage = new SchoolHomePage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        schoolHomePage.getPageLoadedCondition();
        schoolHomePage.simpleTest();
    }

    @AfterClass
    protected void testAfterClass(){
        destroyDriver();
    }

}