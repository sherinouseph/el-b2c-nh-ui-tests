package com.englishtown.tests.core.common;
/**
 * Enter phone number and check validation shown or not
 * Used for homepage forms
 *
 */
import com.englishtown.dataprovider.TelephoneNoDataProvider;
import com.englishtown.helpers.WebElementHelper;
import com.englishtown.pages.common.HomePage;
import com.englishtown.pages.core.BasePage;
import com.englishtown.tests.core.HomePageTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.Test;

import static com.englishtown.helpers.AssertHelper.myAssertThat;

public abstract class BaseHomePhoneValidation extends HomePageTest{
    private static final Logger logger = LoggerFactory.getLogger(BaseHomePhoneValidation.class);
    @Value("#{applicationPropertiesList['home.page.mx']}")
    private String homePageUrl;

    private static int RUN_COUNT = 0;
    public String validationMsgWe = ".tooltip-inner";  //.phoneNumberField-wrapper


    @Test (dataProvider = "MxTelNoAllTestData", dataProviderClass = TelephoneNoDataProvider.class )
    public void enterPhoneNumberCheckValidationShownOrNot(String msg, String phoneNO)throws Exception{
        logger.info(" msg : "+msg+"\t\tPhoneNo :"+phoneNO);
        RUN_COUNT++;
        clickAtWindow(getWebDriver(), 11, 11);
        if(phoneNO.equals("9999990000")) {
            currWebElement = findElement(By.name("telephone"));
            currWebElement.clear();
            WebElementHelper.sendKeyWithWait(currWebElement, phoneNO, 50);
        }else {
            enterPhoneNumber(phoneNO);
        }
        //currWebElement.sendKeys(Keys.TAB);
        executeJSscript("document.getElementsByName('telephone')[0].blur()", getWebDriver(), 2);
        sleep(600);
        if(msg.startsWith("valid")){
            checkValidationMessageNotDisplayed();
        } else {
            checkValidationMessageDisplayed();
        }
        if(RUN_COUNT > 1) {
            this.clickAtWindow(getWebDriver(), 5, 5);
        }
        sleep(500);

    }


    @Override
    protected HomePage createPage() {
        return new HomePage(getWebDriver(), this.homePageUrl);
    }

    public void enterPhoneNumber(String phoneNumber){
        currWebElement = findElement(By.name("telephone"));
        WebElementHelper.clearAndsendKeys(getWebDriver(), currWebElement, phoneNumber, false);
    }

    public void checkValidationMessageDisplayed(){
        logger.info("checkValidationMessageDisplayed ...!");
        if(getValidationMessageWe() != null) {
            myAssertThat(getWebDriver(), "Failed Is Validation message NOT displayed/shown ...!", getValidationMessageWe().isDisplayed(), true);
            logger.info("Validation message is Shown {as expected }...!");
        } else {
            failTestIfNullWebElement(getValidationMessageWe());
        }
    }
    public void checkValidationMessageNotDisplayed(){
        logger.info("checkValidationMessageNotDisplayed ...!");
        if(getValidationMessageWe() == null) {
            logger.info("Validation message is NOT shown {as expected }...!");
        } else {
            BasePage.failTest("Failed; Validation message WebElement is Displayed/shown ...! : Locator selector -> ["+WebElementHelper.getElementLocator(currWebElement)+"]");
        }
    }

    public WebElement getValidationMessageWe(){
        logger.info("getValidationMessageWe ...!");
        sleep(1000);

        currWebElement =  findElement(By.cssSelector(validationMsgWe), 3);
        if(currWebElement !=null){
            logger.info(" webElement text : " + currWebElement.getText());
        }
        return currWebElement;
    }


}

