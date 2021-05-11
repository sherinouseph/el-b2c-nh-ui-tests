package com.englishlive.tests.newsite.market.fr;
/**Created by sherin 19/09/2017
 * *Check Onecard price and package page
 * Check two buttons leads to correct destination Pagea
 */

import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WebElementHelper;
import com.englishtown.tests.core.BaseTest;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public  class FRSinglePNP extends BaseTest {
    public static final Logger logger = LoggerFactory.getLogger(FRSinglePNP.class);
    public String urlContainsPayment ="/buy/default/member/"  ;
    public String offerbuttoncss = ".package .offer-inner";
    public String Buybtn = ".package .btn.btn-hollow";
    public  String Testtbtn = ".final-cta .btn.btn-primary";
    boolean isofferbuttonpresent=false;
    public String price = "Prix";
    public String urlcontains = "reservation-cours";


    @Value("#{applicationPropertiesList['home.page.fr']}")
    private String testUrl;


    @BeforeClass
    protected void setup(){
        setThreadSafeDriver();
        openUrl(getWebDriver(), testUrl);
        click(findElement(By.linkText(price)));

    }

    @AfterClass
    protected void teardownAfterClass(){
        destroyDriver();
    }


    @Test()
        public void isofferbuttonshown() {
        if (isofferbuttonpresent) {
        AssertHelper.assertWebElementDisplayed(getWebDriver(), By.cssSelector(offerbuttoncss));
        logger.info("offerbutton shown");}

         }

    @Test(dependsOnMethods = "isofferbuttonshown")
     public void clickPrimaryButton() {
        logger.info("Checking the onecard Price and Packaging - 1st button leads to payment page");
        getWebDriver().findElement(By.cssSelector(Buybtn)).click();

     }
    @Test(dependsOnMethods = "clickPrimaryButton")
     void checkpayment_urlShown(){
        isPaymentUrlWithWait(urlContainsPayment,5);
        logger.info("Url contains payment"+urlContainsPayment);
        gotoPricePageAgain();
        logger.info("I am in Price Page Again");
        }

    @Test(dependsOnMethods = "checkpayment_urlShown")
    public void clicksecondButton() {
        logger.info("Checking the onecard Price and Packaging - 2nd button ");
        getWebDriver().findElement(By.cssSelector(Testtbtn)).click();
    }
    @Test(dependsOnMethods = "clicksecondButton")
    void checkUrl_Shown(){
         waitForUrlContains(getWebDriver(),urlcontains,5);
         logger.info("Form Present");
        AssertHelper.assertUrlContains(getWebDriver().getCurrentUrl(),urlcontains,"Url is not the expected one");

        }

    public void gotoPricePageAgain() {
        getWebDriver().get(testUrl);
        click(findElement(By.linkText(price)));

    }
}

