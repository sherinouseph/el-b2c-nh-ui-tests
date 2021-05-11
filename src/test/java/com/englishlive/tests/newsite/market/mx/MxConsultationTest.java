package com.englishlive.tests.newsite.market.mx;

/**
 * Created by nikol.marku on 8/24/2016.
 *
 * 1. open mx honme page
 * 2. Enter form data and submit
 * 3.
 *
 */
import com.englishlive.tests.newsite.core.EnterFormDataSubmitCheckTyMsgTest;
import com.englishtown.tests.core.EfConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;



public class MxConsultationTest extends EnterFormDataSubmitCheckTyMsgTest {
    public static final Logger logger = LoggerFactory.getLogger(MxConsultationTest.class);
    @Value("#{applicationPropertiesList['home.page.mx']}")
    protected String testUrl;


    @BeforeClass
    protected void setup(){
        setThreadSafeDriver();
        formDataMap = EfConstants.mxOEFormMapWithPhoneType;
        submitFormBtnCss = ".formset-button .btn.btn-primary";
        isInlineTyMsg = false;
        urlContainsThankyou = "thank-you";//"thank-you";
        telNo = "4492270000";
        openUrl(getWebDriver(), testUrl);
        //findElement(By.cssSelector(".popup-offer-and-form-content"));
        clickAtWindow(getWebDriver(), 7, 7);
        thankYouMsgContains = "Bienvenid";//"Muchas gracias por";

    }
/*
    @Test
    void enterConsultationFormDetails(){
        enterFormData(formDataMap);
    }

    @Test(dependsOnMethods = "enterConsultationFormDetails")
    void submitForm(){
        click(getWebDriver(), By.cssSelector(submitFormBtnCss));
        sleep(2000);
    }

    @Test(dependsOnMethods = "submitForm")
    void checkThankyouMsgShown(){
       // getWebDriver().switchTo().defaultContent();
        AssertHelper.assertWebElementDisplayed(findElement(By.cssSelector(".the.message")));
        String thankyouMsg = getText( findElement(By.cssSelector(thankYouMsgTxtCss)));
        AssertHelper.myAssertThat(getWebDriver(), "",thankyouMsg, containsString(thankYouMsgContains), true );
        logger.info("Thank you message shown ....! "+thankyouMsg);
    }
*/

    @AfterClass
    protected void teardownAfterClass(){
        destroyDriver();
    }

}
