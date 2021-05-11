package com.englishtown.newhouse.outsideschool.mix;
/**
 * Nikol - 08/11/2018
 *
 * https://jira.eflabs.io/browse/SAND-6083
 */


import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.newhouse.school.pages.core.BaseSchoolPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class NewHouseUnsubscribePage extends BaseSchoolPage {
    public static final Logger logger = LoggerFactory.getLogger(NewHouseUnsubscribePage.class);
    public static final String pageUrl = "/customerservice/contactpreferences/yes?email=";

    public static final String MESSAGE_CLASSNAME = "container";

    @FindBy(className = "eliveLogo")
    public WebElement logoWe;

    @FindBy(className = "container")
    public WebElement messageWe;

    @FindBy(className = "ue-language-button")
    public WebElement languageButtonWe;

    @FindBy(className = "ue-copyright")
    public WebElement copyrightWe;


    public NewHouseUnsubscribePage(WebDriver webDriver) {
        super(webDriver);
    }

    public NewHouseUnsubscribePage(WebDriver webDriver, String url) {
        super(webDriver, url);
    }

    public NewHouseUnsubscribePage(WebDriver webDriver, int waitTimeSec) {
        super(webDriver, waitTimeSec);
    }

    public NewHouseUnsubscribePage() {
        this(null, null);
    }

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Override
    public boolean checkAllPageComponentsDisplayed() {
        return checkAllPageComponentsDisplayed(logoWe, messageWe, languageButtonWe, copyrightWe);
    }

    public boolean simpleTest() {
        logger.info("check is Displayed messageWe ...!");
        AssertHelper.assertWebElementDisplayed(messageWe);
        return true;
    }

    /**
     * Get Error and confirmation message
     * @return
     */
    public String getMessage(){
        return TestUtil.getWebElementText(messageWe);
    }


    @Override
    public ExpectedCondition getPageLoadedCondition() {
        return ExpectedConditions.visibilityOf(messageWe);
    }

    @Override
    public String getPageUrl(){
        return pageUrl;
    }

}
