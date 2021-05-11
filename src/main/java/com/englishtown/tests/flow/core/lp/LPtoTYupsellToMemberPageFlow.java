package com.englishtown.tests.flow.core.lp;
/**
 * Created by nikol.marku on 05/04/2016.
 * 1. open form ; enter details and submit
 * 2. click upsell button and check you are at member page
 *
 *
 */
import com.englishtown.helpers.WebElementHelper;
import com.englishtown.tests.core.BaseTestHelper;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;



public abstract class LPtoTYupsellToMemberPageFlow extends BaseTestHelper{
    private static final Logger logger = LoggerFactory.getLogger(LPtoTYupsellToMemberPageFlow.class);

    @Test
    public void enterFormDataTest(){
        this.enterFormData(formDataMap);
    }

    @Test (dependsOnMethods = { "enterFormDataTest" })
    public void submitForm(){
        WebElementHelper.safeFindAndClick(getWebDriver(), By.id(osFormSubmitId));
    }

    @Test (dependsOnMethods = { "submitForm" })
    public void verifyStateObjectEvents(){
        assertThankyouPageStateObjectLpOeTrackingEvents();
    }

    @Test (dependsOnMethods = { "verifyStateObjectEvents" })
    public void isLeadTypeTest(){
        isLeadType(formLeadTypeKey, formLeadTypeValue, false);
    }

    @Test (dependsOnMethods = { "isLeadTypeTest" })
    public void verifyStateObjectLeadIdTest(){
        assertThankyouPageStateObjectLpOeLeadId() ;
    }

    @Test (dependsOnMethods = { "verifyStateObjectLeadIdTest" })
    public void submitUpsellPage(){
        WebElementHelper.safeFindAndClick(getWebDriver(), By.cssSelector(upsellSubmitBtnCss));
    }

    @Test (dependsOnMethods = { "submitUpsellPage" })
    public void isMemberPage(){
        waitForUrlContains(getWebDriver(), "member", 35 );
    }

    @Test(dependsOnMethods = { "submitUpsellPage" })
    public void isCheckoutFlowTypeDefaultAtHomeToPPthenMemberPagePage() {
        checkFlowType(checkoutFlowType, isTestCheckoutFlowType);
    }


}
