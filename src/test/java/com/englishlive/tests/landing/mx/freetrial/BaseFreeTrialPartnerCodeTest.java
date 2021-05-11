package com.englishlive.tests.landing.mx.freetrial;
//
///**
// * Created by sherin 08/11/2017-SAND-4809
// * Branded search for ?ctr=CO- This has a partner code and the user should go to lead form->Password form->Enrollment
// * Non Branded Search-This has a different partner code and the user should go to lead form->Thank you Page
//   gbmx|gomx|ggmx|gdmx|ggus|ggco|godm|ggcl|ggpe|ggro|ggrl|godm
// */

import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.CookieHandler;
import com.englishtown.tests.core.BaseTestHelper;
import com.englishtown.tests.core.EfConstants;
import com.englishtown.tests.core.UniqueDataObject;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public abstract class BaseFreeTrialPartnerCodeTest extends BaseTestHelper {
    public static final Logger logger = LoggerFactory.getLogger(BaseFreeTrialPartnerCodeTest.class);

    protected String testUrl ;
    protected String nonBrandedSearchUrl;
    protected String submitFormBtnCss = ".btn.btn-primary";
    public String emailToken = new UniqueDataObject().getEmail();



    @Test()
    public void openUrlForBrandedSearch(){
        openUrl(getWebDriver(), testStartUrl);

    }
    @Test(dependsOnMethods = "openUrlForBrandedSearch")
    public void enterDetailsAndSubmitBrandedSearch(){
        logger.info("enterDetailsAndSubmitBrandedSearch");
        enterFormData(formDataMap);
        findElement(By.name("email"),10).sendKeys(emailToken);
        click(getWebDriver(), By.cssSelector(submitFormBtnCss));
        logger.info("Form Submitted");
   }
    @Test(dependsOnMethods = "enterDetailsAndSubmitBrandedSearch")
    public void verifyPasswordPage(){
        logger.info("verifyPasswordPage URL");
        AssertHelper.assertUrlContains(getWebDriver().getCurrentUrl(),"welcome","URL incorrect");
        CookieHandler.deleteCookies(getWebDriver());
        getWebDriver().close();
        logger.info("Password Page successfully verified.....URL is correct");
    }

    @Test(dependsOnMethods ="verifyPasswordPage" )
    public void openUrlForNonBrandedSearch(){
        logger.info("openUrlForNonBrandedSearch");
        testStartUrl = nonBrandedSearchUrl;
        setThreadSafeDriver();
        openUrl(getWebDriver(), testStartUrl);
    }

    @Test(dependsOnMethods = "openUrlForNonBrandedSearch")
    public void enterDetailsAndSubmitNonBrandedSearch1(){
        logger.info("enterDetailsAndSubmitNonBrandedSearch1");
        enterFormData(formDataMap);
        getWebDriver().findElement(By.name("email")).sendKeys(emailToken);
        click(getWebDriver(), By.cssSelector(submitFormBtnCss));
        logger.info("Form successfully submitted for non branded search");
    }
    @Test(dependsOnMethods = "enterDetailsAndSubmitNonBrandedSearch1")
    public void verifythankyouPage(){
        logger.info("verifythankyouPage");
        AssertHelper.assertUrlContains(getWebDriver().getCurrentUrl(),"thank-you","URL incorrect");
        logger.info("Thank you page URL successfully verified");

    }

}
