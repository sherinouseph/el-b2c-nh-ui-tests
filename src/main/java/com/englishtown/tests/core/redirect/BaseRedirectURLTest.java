package com.englishtown.tests.core.redirect;
/**
 * NO end slash or .html should rederect to ***end with slash // ***/
/*
 * https://jira-bos.englishtown.com/browse/SAND-2343
 */
import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.pages.core.BasePage;
import com.englishtown.tests.core.BaseTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.endsWith;


public abstract class BaseRedirectURLTest extends BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(BaseRedirectURLTest.class);

    protected String urlEndsWith ="about-us/";

    @Test
    public void checkUrlRedirectedEndsWithBackSlash(){
        AssertHelper.myAssertThat(getWebDriver(), " Failed ...! URL does not end with forward slash : curr url is : " +
                        getWebDriver().getCurrentUrl(),
                BasePage.getUrlWitWaitToEndWith(getWebDriver(), urlEndsWith, WaitTool.SHORT_WAIT_4_ELEMENT), endsWith(urlEndsWith), true);
    }

}
