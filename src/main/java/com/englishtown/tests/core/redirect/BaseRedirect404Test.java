package com.englishtown.tests.core.redirect;
/**
 * Base class for redirection tests
 * 404 page shown
 *
 * Created by nikol.marku on 16/03/2015.
 * //https://jira-bos.englishtown.com/browse/SAND-2185
 */
import com.englishtown.helpers.WaitTool;
import com.englishtown.tests.core.BaseTest;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import static com.englishtown.helpers.AssertHelper.myAssertThat;
import static org.hamcrest.Matchers.containsString;


public class BaseRedirect404Test extends BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(BaseRedirect404Test.class);

    protected static final String DE_ERROR_404 = "404: SEITE NICHT GEFUNDEN";
    protected static final String NO_RESOURCE_FOUND = "404"; //"Sorry, that page does not seem to exist."; //
    protected static final String TITLE_404 = "404";
    protected By byLocator = By.cssSelector("div h1");
    protected String ERROR_404    = "404: PAGE NOT FOUND";
    protected By byLocatorContent404 = By.className("title-component");


    @Test
    public void isDoesNotExistTextOn404Page(){
        logger.info(" Checking page contains :'"+NO_RESOURCE_FOUND+"'");
        WaitTool.waitForTextPresent(getWebDriver(), byLocator, NO_RESOURCE_FOUND, WaitTool.SHORT_WAIT_4_ELEMENT, false);        //assertThat("SAND-2185 - Text ["+NO_RESOURCE_FOUND+"] is not present", isNoResourceFound, is(true));
    }
    @Test
    public void isRedirectTitle404ErrPage(){
        String title = getWebDriver().getTitle();
        logger.info(" Page title is :'" + title + "' should be :'"+TITLE_404+"'");
        myAssertThat(getWebDriver(), "Failed ! Title [" + title + "] does not match [" + TITLE_404 + "]", title, containsString(TITLE_404), true);
    }

}
