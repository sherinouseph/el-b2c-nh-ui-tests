package com.englishlive.tests.checkout.newcheckout.upsell.core;
/**
 * Upsell
 * Open Login page; go to upsell page; add premium product[random]; conform buy; check ty page
 * test12345et1458665623019@qp1.org
 * login
 * go to book a test //https://qa-englishlive.ef.com/checkout/offer/upsell?flow=up&ticks=635942495446317735
 * add first offer  ".et_third a"  [0]  7 elements
 */
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.WebElementHelper;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.pages.core.BasePage;
import com.englishtown.tests.core.login.BaseLoginHelper;
import com.englishtown.tests.core.BaseTestHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.util.List;


public abstract class BaseUpsellScoolTest extends BaseTestHelper {
    private static final Logger logger = LoggerFactory.getLogger(BaseUpsellScoolTest.class);
    protected String upsellPage;
    protected String productListCss = ".et_third a";
    protected List<WebElement> productsList;
    protected String buyProductBtnId = "et_submit";
    protected String agreeToBuyId = "et_btn_agree";
    protected String continueBuyId = "et_btn_continue";
    protected int productId = 0;
    protected String tyPageUrlContains = "upsell-thankyou";
    protected String upsellExtraUrlParams = ""; // test set this up if needed
    protected static int productMaxId = 6;
    private boolean runUpsellTests = false;


    @Test
    public void loginToSchool(){
        BasePage.failTest("Fail all upsell test .. not needed to run all the time ....! Run specially for Raina ..!");
        WaitTool.safeFindDisplayedAndEnabled(getWebDriver(), By.id(emailId), WaitTool.DEFAULT_WAIT_4_ELEMENT);
        BaseLoginHelper.enterUserCredentials(getWebDriver(), username, userPass, emailId, passwordId);
        clickLogin(getWebDriver(), By.cssSelector(submitBtn));
        try{Thread.sleep(3000);}catch (Exception e){}
    }

    @Test(dependsOnMethods = {"loginToSchool"})
    public void goToUpsellPage(){
        upsellPage = getBASEURL()+"englishlive.ef.com/checkout/offer/upsell?flow=up&ticks=635942495446317735j"+upsellExtraUrlParams;
        openUrl(getWebDriver(), upsellPage);
        productsList = WaitTool.findElements(getWebDriver(),By.cssSelector(productListCss) );
    }

    @Test (dependsOnMethods = {"goToUpsellPage"})
    public void buyPremiumProduct(){
        productId = TestUtil.getRandomNumberInRange(0, productMaxId);
        logger.info("Select product Id ["+productId+"]");
        click(productsList.get(productId));
        try{Thread.sleep(200);}catch (Exception e){}
        waitForElementCondition( ExpectedConditions.elementToBeClickable(By.id(buyProductBtnId)), getWebDriver(), 15 );
        click(getWebDriver(), By.id(buyProductBtnId));
        try{Thread.sleep(5000);}catch (Exception e){}
    }

    @Test (dependsOnMethods = {"buyPremiumProduct"})
    public void confirmOrder(){
        waitForElementCondition( ExpectedConditions.elementToBeClickable(By.id(agreeToBuyId)), getWebDriver(), 15 );
        click(getWebDriver(), By.id(agreeToBuyId));
        try{Thread.sleep(200);}catch (Exception e){}
        WebElementHelper.safeFindAndClick(getWebDriver(), By.id(continueBuyId));
        try{Thread.sleep(1000);}catch (Exception e){}
    }

    @Test (dependsOnMethods = {"confirmOrder"})
    public void checkUpsellThankyouPage(){
        waitForUrlContains(getWebDriver(), tyPageUrlContains, 15);
        waitForElementCondition( ExpectedConditions.presenceOfElementLocated(By.id(continueBuyId)), getWebDriver(), 15 );
    }



}