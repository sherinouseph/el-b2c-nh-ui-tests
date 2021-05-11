package com.englishtown.newhouse.salesforce.pages;
/**
 * Sherin - 10/11/2017
 * MAp Student Page
 */
import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.WebElementHelper;
import com.englishtown.newhouse.salesforce.pages.core.SalesForceBasePage;
import com.englishtown.newhouse.salesforce.pages.core.SalesForceConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.hamcrest.Matchers.equalToIgnoringCase;


public class MapStudentPage extends SalesForceBasePage {

    public static final Logger logger = LoggerFactory.getLogger(MapStudentPage.class);
    public static final String pageUrl = "MapStudentFromActual?id=a00O00";
    protected String passwordTxt = "password";

    protected final String createNewBtnCssName = "page:form:j_id28:j_id41:j_id42";  //try to use this .pbBottomButtons input[value='Create New']

    @FindBy(name = createNewBtnCssName) //"page:form:j_id28:j_id41:j_id42")
    public WebElement createNewBtnWe;

    @FindBy(name="page:form:j_id63:j_id64:j_id72:j_id77")
    public WebElement passwordWe;

    @FindBy(name="page:form:j_id63:j_id64:j_id79:j_id84")
    public WebElement reTypePasswordWe;

    @FindBy(name="page:form:j_id63:j_id86:j_id87")
    public WebElement createBtnWe;

    @FindBy(name="page:form:j_id63:j_id86:j_id88")
    public WebElement cancelBtnWe;

    @FindBy(css=".pbButton input")
    public WebElement closeBtnWe;



    public MapStudentPage(WebDriver webDriver, int waitTimeSec) {
        super(webDriver, waitTimeSec);
    }


    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public boolean simpleTest() {
        logger.info(" simpleTest() ....!");
        //WaitTool.waitForElementVisible(getWebDriver(), By.name(createNewBtnCssName), 100, 1000);
        WaitTool.waitForCondition(ExpectedConditions.elementToBeClickable(By.name(createNewBtnCssName)), getWebDriver(), 100);
        AssertHelper.assertWebElementDisplayed(createNewBtnWe);
        return true;
    }


    public String getPageUrl() {
        return pageUrl;
    }

    public void enterPasswordFieldsAndClickCreate() {
        logger.info("enterPasswordFieldsAndClickCreate");
        WebElementHelper.sendKeys(getWebDriver(), passwordWe, passwordTxt, false );
        WebElementHelper.sendKeys(getWebDriver(), reTypePasswordWe, passwordTxt, false );
        click(createBtnWe);

    }

    public void clickCreateNewBtn() {
        logger.info("clickCreateNewBtn");
        click(createNewBtnWe);
    }

    public void clickCloseBtn() {
        logger.info("clickCloseBtn");
        click(closeBtnWe);
    }


}