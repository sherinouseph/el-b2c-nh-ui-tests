package com.englishlive.tests.landing.form.rola.baserolaforms;
/**
 1. when I open E.G Co URL :http://englishlive.ef.com/es-co/lp/oe/englishtown/
 2. when I Select Dept 'xxxx'
 3. Then Movil and Fijo radio buttons are shown
 4. When I select Movil and click on the telephone field
 5. Then field prepopulated with xxxx-x-x-x     [JS : document.getElementById('telephone').value]
 6.  When I select Fijo and click on the telephone field
 7. Then field prepopulated with e.g "(56)-72-2   -   "
 *
 */
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;


public abstract class BaseRolaDepPhoneValidation extends BaseRolaFormValidation {
    private static final Logger logger = LoggerFactory.getLogger(BaseRolaDepPhoneValidation.class);


    @Test
    protected void selectDept() {
        if(clickToCloseDamPopup){
            clickAtWindow(getWebDriver(), 5, 5);
        }
        PRESS_NO = PRESS_NO_DEPT;
        select(By.id(DEPT_SELECT),DEPARTMENT_TO_SELECT, null );
    }

    @Test(dependsOnMethods = "selectDept")
    protected void checkCityFieldNotShown() {
        validateWebElementNotShown(By.cssSelector(CITY_CSS), FAIL_MSG_CITY_SHOULD_NOT_SHOW, 3);
    }

    @Test(dependsOnMethods = "checkCityFieldNotShown")
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
