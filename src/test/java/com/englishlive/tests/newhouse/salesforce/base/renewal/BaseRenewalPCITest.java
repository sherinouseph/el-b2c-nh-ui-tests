package com.englishlive.tests.newhouse.salesforce.base.renewal;
/**
 * sherin- 10/11/2017
 * renewal test - click on account,add new oppo-enter details-take payment-verify actuals created and check the sales type
 */

import com.englishlive.tests.newhouse.salesforce.base.BaseMapStudentTest;
import com.englishtown.helpers.JavaScriptHelper;
import com.englishtown.helpers.WebDriverWindowHelper;
import com.englishtown.helpers.WebElementHelper;
import com.englishtown.newhouse.salesforce.pages.AccountPage;
import com.englishtown.newhouse.salesforce.pages.OppoSalesForcePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public abstract class BaseRenewalPCITest extends BaseMapStudentTest {
    private static final Logger logger = LoggerFactory.getLogger(BaseRenewalPCITest.class);


    @Test(dependsOnMethods = "verifyActivationStatusTest")
    public void goToAccountAndClickAddNewOpportunity(){
        loginAndOpenUrl(salesForceAgentName,accountUrl);
        accountPage = new AccountPage(getWebDriver(),40);
        accountPage.simpleTest();
        accountPage.clickNewOppoBtn();
    }

    @Test(dependsOnMethods = "goToAccountAndClickAddNewOpportunity")
    public void enterNewOpportunityDetailsTestAndSave(){
        selectNewOpportunityRecordType();
        enterNewOppoDetails();
        JavaScriptHelper.scrollToXY(getWebDriver(),0,-500);
        click(oppoSalesForcePage.oppoSaveBtnWe.get(0));
        logger.info("New oppo detaisl saved successfully");
    }

    @Test(dependsOnMethods = "enterNewOpportunityDetailsTestAndSave")
    public void addNewProduct1(){
        logger.info("addNewProduct");
        clickAddProductPCIBtn();
        selectProductPCI();
        if(salesForceUserName == ADMIN_QA)
            approveProductAsSupperAdmin();
        else
            approveProductAsSupervisor();
        opportunityStageCheck(opportunityStageApproved);


    }


    @Test(dependsOnMethods = "addNewProduct1")
    public void addEmailAndClickTakePayment(){
        logger.info("addEmailAndClickTakePayment");
        clickeditOppo();
        WebElementHelper.sendKeys(getWebDriver(),oppoSalesForcePage.emailWe,userEmail,true);
        click(oppoSalesForcePage.oppoSaveBtnWe.get(0));
        clickOnTakePayment();
        logger.info("selectPaymentProviderAndContinueTest");
        WebDriverWindowHelper.switchToWindow(getWebDriver(),1);
        logger.info("Successfully switched to payment window");
        selectPaymentProviderAndContinue(paymentProviderName.getPayProviderName());

    }

    @Test(dependsOnMethods = "addEmailAndClickTakePayment")
    public void addCardInfoForRenewal(){
        logger.info("addCardInfo");
        enterRenewalPaymentDetails();

    }

    @Test(dependsOnMethods = "addCardInfoForRenewal")
    public void verifyRenewal(){
        logger.info("verifyRenewal");
//        logger.info("Switch back to payment window");
//        WebDriverWindowHelper.switchToWindow(getWebDriver(),0);
//        logger.info("successfully Switched back to parent window");
        //WaitTool.waitForTextPresent(getWebDriver(), By.id("00N40000001dWe3_ileinner") , "Renewal",
               // SALESFORCE_WAIT_LONG, false);
        opportunityStageCheck(opportunityStageWon);
        oppoUrl = getWebDriver().getCurrentUrl();

    }
    @Test(dependsOnMethods = "verifyRenewal")
    public void verifyNewActuals(){
        loginAndOpenUrl(salesForceUserName,oppoUrl);
        logger.info("verifyNewActuals");
        getUrlsAndcheckActuals();
        checkFinanceDetails();

    }



    public void enterNewOppoDetails(){
        logger.info("enterNewOppoDetails");
        oppoSalesForcePage=new OppoSalesForcePage(getWebDriver(),30);
        JavaScriptHelper.scrollToXY(getWebDriver(),0,-500);
        oppoSalesForcePage.addNewOppoDetails();
        WebElement newDate=findElement(By.id("opp9"));
        WebElementHelper.sendKeys(getWebDriver(),newDate,getTodaysDate(),true);
        newDate.sendKeys(Keys.TAB);
        if(isPCI)
            WebElementHelper.sendKeys(getWebDriver(),getWebDriver().findElement(By.id("opp6")),"Renewal",true);
        else
            WebElementHelper.sendKeys(getWebDriver(),getWebDriver().findElement(By.id("00N300000017T8g")),userEmail,true);


    }
    public void enterRenewalPaymentDetails(){
        logger.info("enterRenewalPaymentDetails");
        click(findElement(By.name("j_id0:Form:j_id30:j_id31:0:j_id33")));
        click(findElement(By.name("j_id0:Form:j_id30:j_id50:j_id51")));//use selected card to charge
        click(findElement(By.name("j_id0:Form:j_id30:j_id53:j_id54")));//click next button


    }
}
