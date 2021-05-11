package com.englishlive.tests.newhouse.salesforce.base.paymentflow;
/**
 * Click on Take Payment button
 * Enter the bank transfer details
 * check the Oppo stage value
 */

import com.englishlive.tests.newhouse.salesforce.base.BaseAddProductTest;
import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.JavaScriptHelper;
import com.englishtown.helpers.WebDriverWindowHelper;
import com.englishtown.newhouse.salesforce.pages.ActualSalesForcePage;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalToIgnoringCase;

public abstract class BaseBankTransferTest extends BaseAddProductTest {
    private static final Logger logger = LoggerFactory.getLogger(BaseBankTransferTest.class);


    @Test(dependsOnMethods = "verifyProductTest")
    protected void clickOnTakePaymentTest() {
        clickOnTakePayment();
    }

    @Test(dependsOnMethods = "clickOnTakePaymentTest")
    protected void enterPaymentDetailsAndPay(){
        enterBankTransferDetails();
    }

    @Test(dependsOnMethods = "enterPaymentDetailsAndPay")
    protected void checkStageValue(){
        opportunityStageCheck(opportunityStageWon);
    }

    @Test(dependsOnMethods = "checkStageValue")
    protected void activateCourseTest(){
        getUrlsAndcheckActuals();
        loginAndOpenUrl(ADMIN_QA,actualUrl);
        actualSalesForcePage=new ActualSalesForcePage(getWebDriver(),SALESFORCE_WAIT_MED);
        actualSalesForcePage.approveInActuals();
//        clickActivateCourseBtn();
//        WebDriverWindowHelper.switchToWindow(getWebDriver(),1);
//        sleep(1000);
//        activateCourse();
//        sleep(1000);
//        WebDriverWindowHelper.switchToWindow(getWebDriver(),0);
    }



    @Test(dependsOnMethods = "activateCourseTest")
    protected void checkActuals(){getMemberId();
        JavaScriptHelper.scrollToXY(getWebDriver(),0,-5000);
        //checkPaymenStatus("In Progress");
        sleep(10000);
        checkMappingstatus();
        sleep(10000);
        refresh(getWebDriver());
        checkActivationstatus();
        getEtownOrderId();
        if(isNewhousePayment)
            getEfId();
        else
        getMemberId();
        detailCheckActualFields_Vtp();
        AssertHelper.myAssertThat(getWebDriver(), "Date not matching", getText(findElements(By.cssSelector(".dataCol")).get(3)).split(" ")[0], equalToIgnoringCase(collectedDate.split(" ")[0]), true);

    }
    protected void verifyPaymentRecord() {
        logger.info("verifyPaymentRecord, check  collected date ");
        clickOnPaymentRecord(0);//click on index 0 as you are actually selecting the first payment record
        AssertHelper.myAssertThat(getWebDriver(), "Date not matching", getText(findElements(By.cssSelector(".dataCol")).get(3)), equalToIgnoringCase(collectedDate), true);


    }

}
