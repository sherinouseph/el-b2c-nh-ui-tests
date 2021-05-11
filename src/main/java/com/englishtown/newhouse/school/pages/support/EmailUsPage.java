package com.englishtown.newhouse.school.pages.support;

//sherin - 30/01/2018
//
// Email Uspage object - old house

import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.newhouse.school.pages.core.BaseSchoolPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;

public class EmailUsPage extends BaseSchoolPage {
    public static final Logger logger = LoggerFactory.getLogger(EmailUsPage.class);
    public static final String pageUrl = "/customerservice/contactus/inschool";//?icid=School.ContactUs.2012";


    @FindBy(id = "email")//(css = "input[name='email']")
    public WebElement emailWe;

    @FindBy(css = "input[name='category']")
    public WebElement reasonWe;

    @FindBy(css = ".open .dropdown-menu li")    // 21 reason to contact
    public List<WebElement> reasonListWe;

    @FindBy(id = "message")
    public WebElement messageWe;

    @FindBy(css = "input[name='attachment']")
    public WebElement attachementWe;

    @FindBy(css = ".submit button") //"button[class='btn btn-lg btn-primary']")
    public WebElement submitBtnWe;

//    @FindBy(css = "textarea[name='message']")
//    public WebElement messageWe;


    public EmailUsPage(WebDriver webDriver, int waitSec){
        super(webDriver, waitSec);
    }
    public EmailUsPage(WebDriver webDriver){
        super(webDriver);
    }
    public EmailUsPage(WebDriver webDriver, String url) {
        super(webDriver, url);
    }
    public EmailUsPage() {
        this(null, null);
    }
    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Override
    public boolean checkAllPageComponentsDisplayed() {
        checkAllPageComponentsDisplayed(emailWe,messageWe,attachementWe,reasonWe,submitBtnWe);
        return false;
    }

    public void selectAReason(int index){
        logger.info("selectAReason ...! [{}]", index);
        click(reasonWe);
        sleep(1000);
        click(reasonListWe, index);
    }

    public boolean simpleTest() {
        logger.info("check firstname is displayed...!");
        AssertHelper.assertWebElementDisplayed(emailWe);
        AssertHelper.assertWebElementDisplayed(submitBtnWe);

        return true;
    }

   public void clickSubmitBtn(){
        click(submitBtnWe);
   }


    @Override
    public String getPageUrl() {
        return pageUrl;
    }

}
