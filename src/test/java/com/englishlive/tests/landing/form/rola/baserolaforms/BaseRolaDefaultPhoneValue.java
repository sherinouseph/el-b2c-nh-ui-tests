package com.englishlive.tests.landing.form.rola.baserolaforms;
/**
 1. when I open E.G Co URL :http://englishlive.ef.com/es-co/lp/oe/englishtown/
 2. when I Select phone text field
 3. Then field prepopulated with e.g "(58)-   -   -"
 *
 */
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;


public abstract class BaseRolaDefaultPhoneValue extends BaseRolaFormValidation {
    private static final Logger logger = LoggerFactory.getLogger(BaseRolaDefaultPhoneValue.class);


    @Test
    protected void clickOnPhoneFieldAndValidateDefaultPhoneValue() {
        if(clickToCloseDamPopup){
            clickAtWindow(getWebDriver(), 5, 5);
        }
        sleep(1000);
        clickOnPhoneTextFieldAndValidateDefaultValue(DEFAULT_PHONE_VALUE);
    }


}
