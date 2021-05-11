//package com.englishlive.tests.landing.form.rola.baserolaforms;
///**
// *
// * Open URL :http://englishlive.ef.com/es-wws/?ctr=ar
// * ennter F-L/name and email
// * change country
// * Check form values entered not changed ..
// *
// * Latam Req 4 input data above is retained
// *
// */
//
//import com.englishtown.helpers.AssertHelper;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.testng.annotations.Test;
//import static org.hamcrest.core.Is.is;
//import static org.hamcrest.core.IsEqual.equalTo;
//import static org.hamcrest.core.IsNot.not;
//
//
//
//public abstract class BaseRolaChangeCountry extends BaseRolaFormValidation {
//    private static final Logger logger = LoggerFactory.getLogger(BasePhoneTypeDefaultValues.class);
//
//    protected String countrySelected;
//    protected String selectCountryId = "9"; // change country to this on select opt the 5th element
//    protected String testStartSelectedCountry;
//
//
//    @Test
//    protected void changeCountryCheckFormDataRetained() {
//        select(By.cssSelector(COUNTRY_CSS), null, selectCountryId);
//        sleep(3000);
//        waitForElementCondition(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(COUNTRY_CSS)), getWebDriver(), 7);
//        countrySelected =  getSelectedOption(findElement(By.cssSelector(COUNTRY_CSS)));
//        AssertHelper.assertThat("Start test selected country has not changed ....!", testStartSelectedCountry, is(not(equalTo(countrySelected))) );
//        String firstNameValue = getText(findElement(By.name("first_name")));
//        AssertHelper.assertThat("First name value should not change After changing country ....!", firstNameValue, equalTo(formDataMap.get("first_name")) );
//    }
//
//    @Test(dependsOnMethods = "changeCountryCheckFormDataRetained")
//    protected void checkCityShownForDeptBuenosAires() {
//        select(By.cssSelector(COUNTRY_CSS), getMarket(), null );
//        sleep(2000);
//        select(By.cssSelector(DEPT_SELECT), "buenos-aires", null );
//        sleep(2000);
//        WebElement cityWe = findElement(By.cssSelector(CITY_CSS));
//        AssertHelper.assertWebElementDisplayed(cityWe);
//    }
//
//    @Test(dependsOnMethods = "checkCityShownForDeptBuenosAires")
//    protected void selectCityAbbott() {
//        select(By.cssSelector(CITY_CSS), "abbott", null );
//        sleep(3000);
//        WebElement cityWe = findElement(By.cssSelector(CITY_CSS));
//        AssertHelper.assertThat("City value is not the expected one [Abbott] ....!", getSelectedOption(cityWe), equalTo("Abbott") );
//    }
//
//    @Test (dependsOnMethods = "selectCityAbbott")
//    protected void checkStateObjectPageMarketAR() {
//       assertStateObjectElementValue("page.market", getMarket(), true);
//    }
//
//
//}
//
//
