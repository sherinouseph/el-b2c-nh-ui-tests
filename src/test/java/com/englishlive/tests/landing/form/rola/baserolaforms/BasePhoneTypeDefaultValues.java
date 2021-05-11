package com.englishlive.tests.landing.form.rola.baserolaforms;
/**
 1. when I open E.G Co URL :http://englishlive.ef.com/es-cr/lp/oe/englishtown/  dept is not shown
 2. Select Mobile Type[movil or fijo]
 3. click text filed for the phone
 4. default value shown
 *
 */
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;


public abstract class BasePhoneTypeDefaultValues extends BaseRolaFormValidation {
    private static final Logger logger = LoggerFactory.getLogger(BasePhoneTypeDefaultValues.class);


    @Test
    protected void checkDepartmentFieldNotShown() {
        if(clickToCloseDamPopup){
            clickAtWindow(getWebDriver(), 5, 5);
        }
        validateWebElementNotShown(By.name(DEPT_SELECT), FAIL_MSG_CITY_SHOULD_NOT_SHOW, 3);
    }

    @Test(dependsOnMethods = "checkDepartmentFieldNotShown")
    protected void selectMobilePhoneTypeRadioBtn() {
        selectPhoneType(PHONE_TYPE_MOBILE_INDEX);
    }

    @Test(dependsOnMethods = "selectMobilePhoneTypeRadioBtn")
    protected void clickOnPhoneFieldAndValidateDefaultPhoneValue() {
        clickOnPhoneTextFieldAndValidateDefaultValue(DEFAULT_MOBILE_VALUE);
    }

    @Test(dependsOnMethods = "clickOnPhoneFieldAndValidateDefaultPhoneValue")
    protected void selectHomePhoneType() {
        selectPhoneType(PHONE_TYPE_HOMW_INDEX);
    }

    @Test(dependsOnMethods = "selectHomePhoneType")
    protected void clickOnHomePhoneFieldAndValidateDefaultPhoneValue() {
        clickOnPhoneTextFieldAndValidateDefaultValue(DEFAULT_HOMEPHONE_VALUE);
    }

}
