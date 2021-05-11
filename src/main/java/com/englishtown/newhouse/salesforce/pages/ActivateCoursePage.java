package com.englishtown.newhouse.salesforce.pages;
/**
 * Sherin - 10/11/2017
 * MAp Student Page
 */
import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WebElementHelper;
import com.englishtown.newhouse.salesforce.pages.core.SalesForceBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ActivateCoursePage extends SalesForceBasePage {

    public static final Logger logger = LoggerFactory.getLogger(ActivateCoursePage.class);
    public static final String pageUrl = "MapStudentFromActual?id=a00O00";
    protected String passwordTxt = "password";


    @FindBy(css = "input[name='j_id0:form:j_id29:j_id30:j_id31']")
    public WebElement activateBtnWe;



    public ActivateCoursePage(WebDriver webDriver, int waitTimeSec) {

        super(webDriver, waitTimeSec);
    }


    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public boolean simpleTest() {
        logger.info(" simpleTest() ....!");
        AssertHelper.assertWebElementDisplayed(activateBtnWe);
        return true;
    }


    public String getPageUrl() {
        return pageUrl;
    }


    public void clickActivateBtn() {
        click(activateBtnWe);
    }

    

}