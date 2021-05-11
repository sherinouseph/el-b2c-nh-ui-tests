package com.englishlive.tests.redirect.htmlunit;
/**
 * Setup header and check you are redirected to the correct country
 */

import com.englishlive.tests.basetest.htmlunit.BaseHtmlUnitDriverTest;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.pages.core.BasePage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.englishtown.helpers.AssertHelper.myAssertThat;
import static org.hamcrest.CoreMatchers.containsString;

//NOTE: HTMLUNIT only test  com.englishtown.tests.redirect.htmlunit.ArRedirectTest
public class BRRedirectTest extends BaseHtmlUnitDriverTest {
    private static final Logger logger = LoggerFactory.getLogger(BRRedirectTest.class);
    @Value("#{applicationPropertiesList['redirect.pt.br.home.url']}")
    protected String pageUrl;


    @BeforeClass
    public void setup(){
        HEADER_VALUE = "br";
        URL_CONTAINS = "pt-br";
        setUpHtmlUnitDriverWithHeader();
        logger.info("Open URL :"+pageUrl);
        try {
            getHtmlUnitDriver().get(pageUrl);
            Thread.sleep(2000);
        }catch (Exception e){
            logger.error(TestUtil.getException(e, getHtmlUnitDriver()));
        }
    }

    /**
     * USE : htmlUnitDriver
     */
    @Test
    public void openUrlAndCheckRedirectTest(){
        boolean urlContains = BasePage.waitForUrlContains(getHtmlUnitDriver(), URL_CONTAINS, 15);
        logger.info("Current URL :" + getHtmlUnitDriver().getCurrentUrl());
        if(logPageSource) logger.info( getHtmlUnitDriver().getPageSource());
        myAssertThat(getHtmlUnitDriver(), " Failed ...!; URL does not contain : "+URL_CONTAINS, getHtmlUnitDriver().getCurrentUrl(), containsString(URL_CONTAINS), true);
    }

}
