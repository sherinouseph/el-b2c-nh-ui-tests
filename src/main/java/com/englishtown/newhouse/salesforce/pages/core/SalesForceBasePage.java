package com.englishtown.newhouse.salesforce.pages.core;

import com.englishtown.helpers.JavaScriptHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.WebElementHelper;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.pages.core.BasePage;
import com.englishtown.tests.core.BaseTestHelper;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class SalesForceBasePage extends BasePage implements ISalesForce {
    public static final Logger logger = LoggerFactory.getLogger(SalesForceBasePage.class);
    public String salesForceStartUrl="https://cs5.salesforce.com/";
    public String contactUrl;

    protected  String actualCss = "[id^='massActionForm'] th a";  //id=massActionForm_006O000000A45pa_00N300000017V18

    protected SalesForceBasePage(WebDriver webDriver) {
        super(webDriver);
    }

    protected SalesForceBasePage(WebDriver webDriver, int waitTimeSec) {
        super(webDriver, waitTimeSec);
        JavaScriptHelper.waitForPageLoaded(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
    }


    /**
     * Select option using sendKey value
     * @param driver
     * @param dropdownWe
     * @param value
     */
    public static void selectDropdownValue(WebDriver driver, WebElement dropdownWe, String value) {
        logger.info("selectDropdownValue : " + value);
        try {
            dropdownWe.sendKeys(value);
            logger.info("dropdown selected ...!");
        }catch(Exception e){
            logger.error("Could not select value ...! "+ TestUtil.getException(e, driver));
            BasePage.failTest(e, "Select selectDropdownValue Failed ...!", true);
        }
    }

//    public void alertAccept() {
//        Alert alert=getWebDriver().switchTo().alert();
//        System.out.println(alert.getText());
//        alert.accept();
//        logger.info("Alert Accepted");
//    }

    public void selectDate(WebElement dateWe) {
        DateFormat dateFormat2 = new SimpleDateFormat("dd");
        Date date2 = new Date();
        String today = dateFormat2.format(date2);
        logger.info(today);
        click(dateWe);
        //find the calendar
        WebElement dateWidget = getWebDriver().findElement(By.id("datePicker"));
        List<WebElement> columns=dateWidget.findElements(By.tagName("td"));

        //comparing the text of cell with today's date and clicking it.
        for (WebElement cell : columns)
        {
            if (cell.getText().equals(today))
            {
                cell.click();
                break;
            }
        }
    }

    /**
     * Salesforce
     * #userNavLabel this store the user logged in username
     * @param usernameId
     * @return username
     */
    public String getLoggedinUserName(String usernameId){
        String username = "";
        if(null == usernameId)
            usernameId = "userNavLabel";

        WebElement usernameWe = WaitTool.findElement(getWebDriver(), By.id(usernameId));

        username =TestUtil.getWebElementText(usernameWe);;

        return username;
    }

}
