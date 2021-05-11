package com.englishlive.tests.newhouse.salesforce.base.BaseCommerceSFSync;
/**
 *
 * For creating CS Lead from member page - we create it Through API - create member,
 * ifLeadFromOSLP =true, then we submit the OS LP form
 * Finish payment and add phone number
 *  * open salesforce
 * Check for the lead "Current students "in salesforce
 *
 */

import com.englishlive.tests.newhouse.salesforce.base.BaseSalesforceTest;
import com.englishtown.dataprovider.bin.StudentBean;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.WaitToolConfig;
import com.englishtown.helpers.WebElementHelper;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.newhouse.apicore.StaticBaseApiSpec;
import com.englishtown.pages.common.LoginPage;
import com.englishtown.tests.core.EfConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import static com.englishtown.tests.core.EfConstants.TEST_MAIL_END_TOKEN;
import static com.englishtown.tests.core.EfConstants.currTime;

public abstract class BaseCSLeadToSalesforceTest extends BaseSalesforceTest {
    private static final Logger logger = LoggerFactory.getLogger(BaseCSLeadToSalesforceTest.class);
    protected LoginPage loginPage;
    protected boolean ifLeadFromOSLP=false;


    @Test
     protected void createStudentNoEnrollAndGetEmail() {
        if(!ifLeadFromOSLP) {
            StudentBean studentBean = StaticBaseApiSpec.createUserNoEnrol("qa", true, "0905685865", market, language);
            leadEmail = studentBean.getUserEmail();
            logger.info("lead email is " + leadEmail);
        }else{
            logger.info("Fill the form Submit OS Landing Page");
            setThreadSafeDriver();
            openUrl(getWebDriver(), testStartUrl);
            this.enterFormData(formDataMap);
            enterEmailAndSubmit();
            sleep(1000);
            WaitTool.waitForCondition( ExpectedConditions.invisibilityOfElementLocated(
                    By.cssSelector(memberSpinnerCss)),getWebDriver(), WaitToolConfig.MED_WAIT_4_ELEMENT);
            enterPaymentDetailsAndsubmit();
            checkPaymentThankyouPage();
        }


    }


    @Test(dependsOnMethods = { "createStudentNoEnrollAndGetEmail"})
    protected void loginToSalesForceAndSearchLead() {
        if(getWebDriver() == null)
            setThreadSafeDriver();

        openSalesForceAndlogin(salesForceAgentName, SALESFORCE_PASS);
        sleep(5000);
        logger.info("Searching for lead "+leadEmail+" in salesforce");

        int maxOpenUrl = 50;
        WebElement tableRowWe = null;
        /**
         * Open url and try to find the row
         * if not Repeat
         */
        try {
            while (maxOpenUrl > 0) {
                logger.info("Remaining trys [{}]", maxOpenUrl );
                maxOpenUrl --;
                openUrl(getWebDriver(), getSearchByEmailurl(leadEmail));
                sleep(3000);
                tableRowWe = WaitTool.findElementDontFailTest(getWebDriver(), By.cssSelector("#Lead_body table tr td:nth-child(6)"));  // WaitTool.waitForCondition(ExpectedConditions.elementToBeClickable(By.cssSelector("#Lead_body table tr td:nth-child(6)")), getWebDriver(), WaitTool.WAIT_VERYLONG_160SEC);

                if(null != tableRowWe)
                    break;
            }
        }catch (WebDriverException e){

        }

    }

    @Test(dependsOnMethods = {"loginToSalesForceAndSearchLead"})
    protected void verifyLead() {
        logger.info("verify Lead type is "+leadType);
        verifyLeadType(leadType);
    }

    protected void enterEmailAndSubmit(){
        leadEmail = "auto_" + currTime + "_" +leadRecordType+ TestUtil.generateRandomString("", 5) + "_" + TEST_MAIL_END_TOKEN + "@qp1.org";
        logger.info("lead email is " + leadEmail);
        findElement(By.name("email")).sendKeys(leadEmail);
        findElement(By.name("email")).submit();
    }

    protected void enterPaymentDetailsAndsubmit(){
        setTestCardNumber(getENVIRONMENT(), getTestCardType());//by default test will run with visa card type
        sleep(8000);
        TestUtil.setMapKeyValue(EfConstants.ukMembersPayMap_new, "CreditCardNumber", getTestCardNumber());
        enterFormData(EfConstants.ukMembersPayMap_new);
        WebElement submitElement = WebElementHelper.safeFindElement(getWebDriver(), By.cssSelector(paymentSubmitBtnCss));
        click(submitElement);
        try{Thread.sleep(3000);}catch (Exception e){}
    }

}
