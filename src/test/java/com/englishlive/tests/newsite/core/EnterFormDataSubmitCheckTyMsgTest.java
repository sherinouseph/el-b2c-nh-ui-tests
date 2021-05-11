package com.englishlive.tests.newsite.core;

/**
 * Created by nikol.marku on 8/24/2016.
 *
 * 1. open  page
 * 2. Enter form data and submit
 * 3. Check TY msg and url  [inline or not]
 * 4. check lead type and lead id
 *
 */

import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.WebElementHelper;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.tests.core.BaseTestHelper;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.containsString;


public abstract class EnterFormDataSubmitCheckTyMsgTest extends BaseTestHelper {
    public static final Logger logger = LoggerFactory.getLogger(EnterFormDataSubmitCheckTyMsgTest.class);


    protected String thankYouMsgContains ;
       protected String thankYouMsgTxtCss = ".message b";
    protected String questTxtCss=".question-form .heading .inline-text";
    protected String submitFormBtnCss  = ".btn.btn-primary"; //".btn-primary.btn-block";
    protected String telNo = "1111111111111";
    protected boolean isInlineTyMsg = true;

    @Test
    void enterFormDetails(){
        if(StringUtils.contains(TestUtil.getCurrentUrl(getWebDriver()), "es-mx")){
            if(!isEnterFormDataUsingCssMap) {
                waitForElementCondition(ExpectedConditions.elementToBeClickable(By.name("telephone")), getWebDriver(), 20); //waitForElementVisibleAndClick("#telephone", 20);
                WebElement phoneWe = findElement(By.name("telephone"));
                WebElementHelper.sendKeyWithWait(phoneWe, telNo, 200);
            }
        }
        if(isEnterFormDataUsingCssMap){
            logger.info("Using css map keys ...!");
            enterFormDataCss(formDataMap);
        }else
            enterFormData(formDataMap);
    }

    @Test(dependsOnMethods = "enterFormDetails")
    void submitForm(){
        //clickListWebElement(getWebDriver(), By.cssSelector(submitFormBtnCss), 0);
        //click(WaitTool.findElements(getWebDriver(), By.cssSelector(".formset .btn.btn-primary")).get(0));
        click(getWebDriver(), By.cssSelector(submitFormBtnCss) );
        sleep(2000);
    }

    @Test(dependsOnMethods = "submitForm")
    void checkThankyouMsg(){
        if(!isInlineTyMsg){
            assertIsUrlContaining(urlContainsThankyou); //"free-consultation/thank-you/"
        }else {
            AssertHelper.assertWebElementDisplayed(findElement(By.cssSelector(thankYouMsgTxtCss)));
            String msg = getText(findElement(By.cssSelector(thankYouMsgTxtCss)));
            AssertHelper.myAssertThat(getWebDriver(), "Not the expected TY msg ...!", msg, containsString(thankYouMsgContains), true);
            logger.info("Correct heading shown on Questionnaire Page ....! " +msg );
        }
    }


    @Test(dependsOnMethods = "checkThankyouMsg")
    void checkLeadIdCreated(){
        assertStateObjectValueNotBlankNorEmpty(formLeadIdKey, true);
    }

    @Test(dependsOnMethods = "checkThankyouMsg")
    void checkLeadType(){
        assertStateObjectElementValue(formLeadTypeKey, formLeadTypeValue, true);
    }


}
