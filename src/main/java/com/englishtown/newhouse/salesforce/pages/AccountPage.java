package com.englishtown.newhouse.salesforce.pages;
/**
 * Sherin - 10/11/2017
 * MAp Student Page
 */
import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.JavaScriptHelper;
import com.englishtown.helpers.MyWebDriverAction;
import com.englishtown.helpers.WebElementHelper;
import com.englishtown.newhouse.salesforce.pages.core.SalesForceBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class AccountPage extends SalesForceBasePage {

    public static final Logger logger = LoggerFactory.getLogger(AccountPage.class);
    public static final String pageUrl = "001O00000";


    @FindBy(name = "newOpp")
    public WebElement newOppoWe;

    @FindBy(name = "edit")
    public WebElement editBtnWe;

    @FindBy(css = "#topButtonRowpage_j_id28 [name='inlineEditSave']")
    public WebElement saveWe;

    @FindBy(css = "#topButtonRowpage_j_id28 [name='clone']")
    public WebElement cloneWe;




    public AccountPage(WebDriver webDriver, int waitTimeSec) {

        super(webDriver, waitTimeSec);
    }


    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public boolean simpleTest() {
        logger.info(" simpleTest() ....!");
        AssertHelper.assertWebElementDisplayed(editBtnWe);
        return true;
    }


    public String getPageUrl() {
        return pageUrl;
    }




    public void clickNewOppoBtn(){
        JavaScriptHelper.scrollToXY(getWebDriver(),0,1000);
        click(newOppoWe);
        logger.info("Successfully clicked on new oppo button");

    }

    

}