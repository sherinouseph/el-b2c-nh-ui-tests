package com.englishlive.tests.newhouse.salesforce.base.renewal;
/**
 * sherin- 10/11/2017
 * renewal test - click on account,add new oppo-enter details-take payment-verify actuals created and check the sales type
 */


import com.englishlive.tests.newhouse.salesforce.base.paymentflow.BaseCreditCardTest;
import com.englishtown.helpers.*;
import com.englishtown.newhouse.salesforce.pages.AccountPage;
import com.englishtown.newhouse.salesforce.pages.OppoSalesForcePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public abstract class BaseRenewalTest extends BaseCreditCardTest {
    private static final Logger logger = LoggerFactory.getLogger(BaseRenewalTest.class);
    protected  String salesType="Renewal";


    @Test(dependsOnMethods = "getUrlsndVerifyActuals")
    public void goToOppoAndClickAddNewOpportunity(){
        loginAndOpenUrl(salesForceAgentName,accountUrl);
        accountPage = new AccountPage(getWebDriver(),40);
        accountPage.simpleTest();
        accountPage.clickNewOppoBtn();
        WaitTool.waitForElementVisible(getWebDriver(), By.id("opp9"), 65, 1000);

    }

    @Test(dependsOnMethods = "goToOppoAndClickAddNewOpportunity")
    public void enterNewOpportunityDetailsTestAndSave(){
        selectNewOpportunityRecordType();
        enterNewOppoDetails();
        if(isAddQuality)
            oppoSalesForcePage.selectQuality("2");
        JavaScriptHelper.scrollToXY(getWebDriver(),0,-500);
        click(oppoSalesForcePage.oppoSaveBtnWe.get(0));
        logger.info("New oppo detaisl saved successfully");
    }

    @Test(dependsOnMethods = "enterNewOpportunityDetailsTestAndSave")
    public void addNewProductAndClickOnTakePayment(){
        logger.info("addNewProduct");
        addProduct();
        clickOnTakePayment();
    }

    @Test(dependsOnMethods = "addNewProductAndClickOnTakePayment")
    public void addCardInfoForRenewal(){
        logger.info("addCardInfoForRenewal");
         addCardInfoForRenewal_Upsell();


    }

    @Test(dependsOnMethods = "addCardInfoForRenewal")
    public void verifyRenewal(){
        logger.info("verifyRenewal/Upsell");
//        WebDriverWindowHelper.switchToWindow(getWebDriver(),0);
//        logger.info("Switched backed to parent window");
        WaitTool.waitForTextPresent(getWebDriver(), By.id("00N40000001dWe3_ileinner") , salesType,
                SALESFORCE_WAIT_LONG, false);
        opportunityStageCheck(opportunityStageWon);

    }
    @Test(dependsOnMethods = "verifyRenewal")
    public void verifyNewActuals(){
        logger.info("verifyNewActuals");
        getUrlsAndcheckActuals();
        sleep(10000);
        checkMappingstatus();
        logger.info("Member id :"+getMemberId());        //checkActivationstatus();        //getEtownOrderId();
        setUserMemberId(getMemberId());
        checkActivationstatus();
//        getEtownOrderId();
//        loginAndOpenUrl(ADMIN_QA,actualUrl);
//        checkFinanceDetails();

    }



    public void enterNewOppoDetails(){
        logger.info("enterNewOppoDetails");
        oppoSalesForcePage=new OppoSalesForcePage(getWebDriver(),30);
        JavaScriptHelper.scrollToXY(getWebDriver(),0,-500);
        oppoSalesForcePage.addNewOppoDetails();
        WebElement newDate=findElement(By.id("opp9"));
        WebElementHelper.sendKeys(getWebDriver(),newDate,getTodaysDate(),true);
        newDate.sendKeys(Keys.TAB);
        WebElementHelper.sendKeys(getWebDriver(),getWebDriver().findElement(By.id("00N300000017T8g")),userEmail,true);


    }

}
