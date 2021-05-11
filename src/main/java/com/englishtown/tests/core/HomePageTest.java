package com.englishtown.tests.core;
/**
 *
 */
import com.englishtown.pages.common.HomePage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import static com.englishtown.helpers.AssertHelper.myAssertThat;


public abstract class HomePageTest extends PageTest<HomePage> {
    private static final Logger logger = LoggerFactory.getLogger(HomePageTest.class);


    @Test
    public void ensurePageIsValidForTheUrl() {
        myAssertThat(getWebDriver(), "ensurePageIsValidForTheUrl(). Page is not at expected location.", this.getPage().isAtExpectedPage(), true);
    }

    @Test(dependsOnMethods = "ensurePageIsValidForTheUrl")
    public void checkMarketTest(){
        assertStateObjectElementValue("page.market",getMarket(),true);
    }

    @Test(dependsOnMethods = "checkMarketTest")
    public void checkLanguageTest(){
        assertStateObjectElementValue("page.language",getLanguage(),false);
    }



}
