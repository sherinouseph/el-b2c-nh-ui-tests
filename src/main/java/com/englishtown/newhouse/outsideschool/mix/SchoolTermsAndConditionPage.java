package com.englishtown.newhouse.outsideschool.mix;
/**
 * Nikol - 20/12/2018
 *
 * when a sales force user logs in for the first time
 * he should see https://qa-englishlive.ef.com/tr-tr/accept-terms-and-conditions/
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

import static org.hamcrest.Matchers.containsString;


public class SchoolTermsAndConditionPage extends BaseSchoolPage {
    public static final Logger logger = LoggerFactory.getLogger(SchoolTermsAndConditionPage.class);
    public static final String pageUrl = "/accept-terms-and-conditions/"; // https://qa-englishlive.ef.com/tr-tr/accept-terms-and-conditions/

    @FindBy(className = "terms-and-conditions--title")
    public WebElement tncTitleWe;

    @FindBy(name = "toc")
    public WebElement acceptCheckboxWe;

    @FindBy(css = ".bs3 .btn-primary")
    public WebElement acceptButtonWe;


    @FindBy(className = "tooltip-inner")
    public WebElement validationMsgWe;

    public SchoolTermsAndConditionPage(WebDriver webDriver) {
        super(webDriver);
    }

    public SchoolTermsAndConditionPage(WebDriver webDriver, String url) {
        super(webDriver, url);
    }

    public SchoolTermsAndConditionPage(WebDriver webDriver, int waitTimeSec) {
        super(webDriver, waitTimeSec);
    }

    public SchoolTermsAndConditionPage() {
        this(null, null);
    }

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Override
    public boolean checkAllPageComponentsDisplayed() {
        return checkAllPageComponentsDisplayed(tncTitleWe, acceptCheckboxWe, acceptButtonWe);
    }

    public boolean simpleTest() {
        logger.info("check is Displayed messageWe ...!");
        AssertHelper.assertWebElementDisplayed(acceptButtonWe);
        return true;
    }

    public void submit(){
        click(acceptButtonWe);
    }

    public void acceptChecboxClick(){
        click(acceptCheckboxWe);
    }

    public String getValidationMessage(){
        return TestUtil.getWebElementText(validationMsgWe);
    }

    public void assertValidationMessage(String validationMsg){
        AssertHelper.myAssertThat(getWebDriver(), "Is not the expected Validation message ....!",
                getValidationMessage(), containsString(validationMsg), true);
    }


    @Override
    public ExpectedCondition getPageLoadedCondition() {
        return ExpectedConditions.visibilityOf(acceptButtonWe);
    }

    @Override
    public String getPageUrl(){
        return pageUrl;
    }

}
