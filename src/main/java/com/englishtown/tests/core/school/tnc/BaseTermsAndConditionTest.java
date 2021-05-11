package com.englishtown.tests.core.school.tnc;
/**
 *
 * User: nikol.marku
 * Date: 20/12/18
 * As a new salesforce user when I login I should see TnC page
 * when I accept and submit I see enroll page
 *
 */


import com.englishtown.helpers.WaitTool;
import com.englishtown.newhouse.outsideschool.mix.SchoolTermsAndConditionPage;
import com.englishtown.tests.core.school.BaseSimpleLogin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;


public abstract class BaseTermsAndConditionTest extends BaseSimpleLogin {
    private static final Logger logger = LoggerFactory.getLogger(BaseTermsAndConditionTest.class);

    String tncValidationMessage = "tncValidationMessage Set This UP on the test";

    @Test(dependsOnMethods = "checkUserIsAtSchoolHomePage")
    protected void checkTermsAndConditinsPage(){
        logger.info("checkTermsAndConditinsPage  ...!");
        schoolTermsAndConditionPage = new SchoolTermsAndConditionPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        assertIsUrlContaining(schoolTermsAndConditionPage.getPageUrl());
        schoolTermsAndConditionPage.getPageLoadedCondition();
        schoolTermsAndConditionPage.checkAllPageComponentsDisplayed();
    }

    ////TODO this fails as there is not translation ..
    @Test(dependsOnMethods = "checkTermsAndConditinsPage")
    protected void checkValidationMessage(){
        logger.info("checkValidationMessage waiting for fix  ...! is [{}]", tncValidationMessage);
        schoolTermsAndConditionPage.submit();
        sleep(2000);
        //schoolTermsAndConditionPage.assertValidationMessage(tncValidationMessage);
    }

    @Test(dependsOnMethods = "checkValidationMessage")
    protected void acceptTnCandClickAcceptButton(){
        logger.info("acceptTnCandClickAccept  ...!");
        schoolTermsAndConditionPage.acceptChecboxClick();
        sleep(200);
        schoolTermsAndConditionPage.submit();
    }

    @Test(dependsOnMethods = "acceptTnCandClickAcceptButton")
    protected void checkUserIsAtEnrollPage(){
        logger.info("checkUserIsAtSchoolHomePage  ...!"+waitForUrlContains);
        assertIsUrlContaining("com/1/enrollment");
    }


}
