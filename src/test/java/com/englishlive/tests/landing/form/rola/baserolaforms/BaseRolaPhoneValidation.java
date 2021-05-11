package com.englishlive.tests.landing.form.rola.baserolaforms;
/**
 * Open URL :http://englishlive.ef.com/es-cr/   // where user can select phone type and enter phone number
 * select Mobile
 * Enter valid No check no validation
 * Enter in-valid No check validation shown
 * repeat for Home NO
 *
 */
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.testng.annotations.Test;

/**
 * Created by nikol.marku on 16/11/2015.
 */
public abstract class BaseRolaPhoneValidation extends BaseRolaFormValidation {
    private static final Logger logger = LoggerFactory.getLogger(BasePhoneTypeDefaultValues.class);


    @Test
    protected void selectMobileType() {
        selectPhoneType(PHONE_TYPE_INDEX);
    }
    @Test(dependsOnMethods = "selectMobileType")
    public void enterInValidMobilePhoneCheckValidationShown(){
        enterPhoneNoCheckValidation(invalidPhoneNo, phoneValidationPopupCss, true, false);
    }

    @Test(dependsOnMethods = "enterInValidMobilePhoneCheckValidationShown")
    public void enterValidMobilePhoneCheckNoValidationShown(){
        currWebElement = findElement(By.id(phoneCss));
        for(int i=0; i<9;i++){
            currWebElement.sendKeys(Keys.BACK_SPACE);
        }
        clickAtWindow(getWebDriver(), 5, 5);
        sleep(200);
        enterPhoneNoCheckValidation(validPhoneNo, phoneValidationPopupCss, false, false);
    }


}


