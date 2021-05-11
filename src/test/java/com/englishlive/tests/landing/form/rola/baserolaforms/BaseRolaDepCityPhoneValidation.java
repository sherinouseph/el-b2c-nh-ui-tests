package com.englishlive.tests.landing.form.rola.baserolaforms;
/**
 1. when I open CL URL :http://englishlive.ef.com/es-cl/lp/oe/englishtown/
 2. City filed is Not shown
 3. when I Select Dept E.G 'ohiggins'
 4. Then City filed is shown, And the list shows ["cachapoal", "cardenal-caro", "colchagua", "rancagua"]  //location-city
 5. When I select the city 'rancagua'
 6. Then Movil and Fijo radio buttons are shown
 7. When I select Movil and click on the telephone field
 8. Then field prepopulated with e.g "(56)-9-    -    "        [JS : document.getElementById('telephone').value]
 9.  When I select Fijo and click on the telephone field
 10. Then field prepopulated with e.g  "(56)-72-2   -   "
 *
 */
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;


public abstract class BaseRolaDepCityPhoneValidation extends BaseRolaFormValidation {
    private static final Logger logger = LoggerFactory.getLogger(BaseRolaDepCityPhoneValidation.class);

    @Test
    protected void checkCityFieldNotShown() {
        if(clickToCloseDamPopup){
            clickAtWindow(getWebDriver(), 7, 7);
            sleep(500);
        }
        validateWebElementNotShown(By.cssSelector(CITY_CSS), FAIL_MSG_CITY_SHOULD_NOT_SHOW, 5);
    }

    @Test(dependsOnMethods = "checkCityFieldNotShown")
    protected void selectDept() {
        PRESS_NO = PRESS_NO_DEPT;
        select(By.cssSelector(DEPT_SELECT),DEPARTMENT_TO_SELECT, null );
        sleep(3000);
    }

    @Test(dependsOnMethods = "selectDept")
    protected void checkCityFieldShownAndContains_N_Elements() {
        checkCityFieldShownContains_N_Elements(CITY_CSS, cityWeSize);
    }

    @Test(dependsOnMethods = "checkCityFieldShownAndContains_N_Elements")
    protected void selectCityAndCheckPhoneTypesDisplayed() {
        PRESS_NO = PRESS_NO_CITY;
        selectCityCheckPhoneTypesDisplayed(CITY_CSS, CITY_LIST,  cityId) ;
        sleep(1500);
    }

     @Test(dependsOnMethods = "selectCityAndCheckPhoneTypesDisplayed")
     protected void selectMobilePhoneType() {
         selectPhoneType(PHONE_TYPE_MOBILE_INDEX);
     }

    @Test(dependsOnMethods = "selectMobilePhoneType")
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
