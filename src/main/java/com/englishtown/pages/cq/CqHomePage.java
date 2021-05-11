package com.englishtown.pages.cq;

import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WebElementHelper;
import com.englishtown.helpers.utils.TestUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.hamcrest.Matchers.containsString;

/**
 * Created by nikol.marku on 12/29/2016.
 * After login this page is shown
 * http://aem.englishtown.com/libs/cq/core/content/welcome.html
 *
 *
 *
 */
public class CqHomePage extends CqCorePage {
    public static final Logger logger = LoggerFactory.getLogger(CqHomePage.class);
    public String pageUrl = "libs/cq/core/content/welcome.html";  //base url + pageUrl
    public String weclomeAndPermissionNikolMsg = "Welcome, CN=Nikol Marku,OU=Staff,OU=Users,OU=RC,OU=WorkSpace,OU=GBLCM,OU=EMEA,DC=ef,DC=com";


    /**
     * Main components
     */
    @FindBy(css = "#apps .box")
    public List<WebElement> websiteAppsMenuList;

    @FindBy(id = "welcome-message")
    public WebElement welcomeMsgWe;

    @FindBy(className = "signout")
    public WebElement signout;

    @FindBy(css = "a[title='Workflows']")
    public WebElement workflows;  // right side of page



    public CqHomePage(WebDriver webDriver){
        super(webDriver);
    }
    public CqHomePage(WebDriver webDriver, String url) {
        super(webDriver, url);
    }
    public CqHomePage() {
        this(null, null);
    }

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public boolean simpleTest() {
        logger.info(" simpleTest() assertWebElementDisplayed ->websiteAppsMenuList and workflows ...! ");
        AssertHelper.assertWebElementDisplayed(websiteAppsMenuList.get(1));
        AssertHelper.assertWebElementDisplayed(workflows);

        return true;
    }

    public ExpectedCondition getPageLoadedCondition() {
        return ExpectedConditions.visibilityOf(websiteAppsMenuList.get(1));
    }

    public void assertUsersPermission(String userPermission){
        AssertHelper.myAssertThat(getWebDriver(), "Is not the expected User permissions ....!",
                TestUtil.getWebElementText(welcomeMsgWe), containsString(userPermission), true);
    }

    public void signout() {
        WebElementHelper.click(signout);
    }

}
