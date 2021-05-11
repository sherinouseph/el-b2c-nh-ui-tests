package com.englishlive.tests.newhouse.school.upsell;
/**
 *
 * User: nikol.marku
 * Date: 05/02/18
 *
 *  Upsell redirect test when user has no credits for PLs/GLs
 */

//TODO create user in oldhouse uk
import com.englishtown.helpers.WaitTool;
import com.englishtown.newhouse.school.pages.home.SchoolHomePage;
import com.englishtown.tests.core.school.upsell.BaseUpsellRedirectTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class UKUpsellRedirectTest extends BaseUpsellRedirectTest {
    private static final Logger logger = LoggerFactory.getLogger(UKUpsellRedirectTest.class);
    @Value("#{applicationPropertiesList['uk.uk.login.url']}")
    protected String testUrl;
    @Value("#{applicationPropertiesList['uk.upsell.redirect']}")
    protected String testUsername;


    @BeforeClass
    protected void setup(){
        setThreadSafeDriver();
        password = "passpass";
        setLanguageAndMarket("en", "gb");
        testStartUrl = testUrl;
        username = testUsername;
        setUserEmail(testUsername);

        upsellUrl ="englishlive.ef.com/"+getLanguage()+"-"+getMarket()+"/buy/upsell/upsell";

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
