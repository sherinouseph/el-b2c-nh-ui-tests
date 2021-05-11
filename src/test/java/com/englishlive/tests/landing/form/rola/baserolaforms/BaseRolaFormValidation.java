package com.englishlive.tests.landing.form.rola.baserolaforms;
/**
 * Base helper method/test for rola forms
 *
 */

import com.englishtown.driver.BaseRemoteWebDriver;
import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.pages.core.BasePage;
import com.englishtown.tests.core.BaseTestHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.is;


public abstract class BaseRolaFormValidation extends BaseTestHelper implements IRolaForm {
    private static final Logger logger = LoggerFactory.getLogger(BaseRolaFormValidation.class);

    protected int depId  ;           // dept id no to select
    protected int cityId ;           // city id no to select
    protected int cityWeSize ;       // 4 cities + default city shown
    protected final int PHONE_TYPE_MOBILE_INDEX = 0;
    protected final int PHONE_TYPE_HOMW_INDEX   = 1;
    protected int PHONE_TYPE_INDEX ;
    protected String DEFAULT_PHONE_VALUE     = "notInit";
    protected String DEFAULT_MOBILE_VALUE    = "(54)-911-";
    protected String DEFAULT_HOMEPHONE_VALUE = "notInit";
    protected String DEPARTMENT_TO_SELECT = "NOT INIT";
    protected String[] CITY_LIST ;
    protected boolean clickToCloseDamPopup = false;
    protected List<WebElement> selectPhoneTypes;
    protected String phoneCss = "input[name='telephone']";  //"telephone";
    protected String phoneValidationPopupCss = ".tooltip-inner" ;

    protected String validPhoneNo   = "";
    protected String invalidPhoneNo = "";
    protected String topPhoneNumberCss = ".call span";


    protected void checkCityFieldShownContains_N_Elements(String CITY_SELECTOR, int cityWeSize) {
        validateListWebElementShown(By.cssSelector(CITY_SELECTOR), 0, FAIL_MSG_CITY_SHOULD_SHOW);

        String optSelector = CITY_SELECTOR+" option";
        assertNoOfFormElements(getWebDriver(), By.cssSelector(optSelector), cityWeSize);
    }

    protected void selectCityCheckPhoneTypesDisplayed(String CITY_SELECTOR, String [] CITY_LIST_VALUES,  int selectCityId) {
        select(By.cssSelector(CITY_SELECTOR),CITY_LIST_VALUES[selectCityId], null );
        selectPhoneTypes =getTelTypeList(PHONE_TYPE_SELECT_OPTION_CSS, 7) ;// WaitTool.waitForListElementsDisplayed(getWebDriver(), By.cssSelector(PHONE_TYPE_RADIO_BTNS), 5, 0);
        //assertNoOfFormElements(getWebDriver(), By.cssSelector(PHONE_TYPE_SELECT_OPTION_CSS), 2);
    }

     protected void selectPhoneType(int index) {
         try {
             if(selectPhoneTypes == null){
                 selectPhoneTypes =getTelTypeList(PHONE_TYPE_RADIO_BTNS,5) ;
             }
             if(BaseRemoteWebDriver.isBrowser("firefox")){
                 scrollToWeAndClick(getWebDriver(), selectPhoneTypes.get(index), 0, 200);
             }
             click(selectPhoneTypes.get(index));
         }catch (Exception e){
             e.printStackTrace();
             BasePage.failTest("Can't click on phone type ...! INDEX :"+index+ TestUtil.getException(e));
         }
     }

    protected void clickOnPhoneTextFieldAndValidateDefaultValue(String defaultValue) {
        waitForElementVisibleAndClick(TEL_CSS, 7);
        sleep(1000);
        WebElement webElement = findElement(By.cssSelector(TEL_CSS));
        String currDefaultPhoneValue =  getText(webElement) ; //JavaScriptHelper.getHidenFieldBy(getWebDriver(), "Id", "telephone", 7);
        logger.info("currDefaultPhoneValue ["+currDefaultPhoneValue+"] should match ["+defaultValue+"]");

        if(currDefaultPhoneValue != null){
            AssertHelper.myAssertThat(getWebDriver(), "Default Mobile phone value test failed ...",
                    currDefaultPhoneValue, containsString(defaultValue), false);
        }else {
            BasePage.failTest("Cant't get Default Mobile phone Value OR it is null ...!");
        }
        logger.info("defaultPhoneValue :"+currDefaultPhoneValue);
    }

    protected void validatePhoneValue(String fieldCssToGetTextFrom, String defaultValue) {
        WebElement webElement = findElement(By.cssSelector(fieldCssToGetTextFrom));
        String currPhoneValue =  getText(webElement) ;
        logger.info("curr Phone Mask ["+currPhoneValue+"] should match ["+defaultValue+"]");

        if(currPhoneValue != null){
            AssertHelper.myAssertThat(getWebDriver(), "Default phone Mask test failed ...",
                    currPhoneValue, containsString(defaultValue), false);
        }else {
            BasePage.failTest("Cant't get Phone Value OR it is null ...!");
        }
    }

    protected List<WebElement> getTelTypeList(String PHONE_TYPE_CSS, int waitTimeSec){
        return WaitTool.waitForListElementsPresent(getWebDriver(), By.cssSelector(PHONE_TYPE_CSS), waitTimeSec);
    }


}
