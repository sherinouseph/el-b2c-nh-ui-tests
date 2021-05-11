package com.englishtown.tests.core.landingpages;
/**
 * https://jira-bos.englishtown.com/browse/SAND-2879
 *
 */
import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WebElementHelper;
import com.englishtown.tests.core.BaseTestHelper;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;


public abstract class BaseSbLeadTypeTest extends BaseTestHelper {
    private static final Logger logger = LoggerFactory.getLogger(BaseSbLeadTypeTest.class);

    protected String submitBtn = ".btn.btn-primary-blue.btn-block";
    protected String noOfStafKey    = "form.NumberOfStaff";
    protected String leadtypeKey    = "form.leadtype";
    protected String leadTypeValue  = "sb";
    protected String noOfStaffValue = "100";


    @Test
    void enterSBformData(){
        enterFormData(formDataMap);
        enterEmail(getWebDriver(), true);
    }

    // this changed and go to payment now with the new forms
    @Test(dependsOnMethods = {"enterSBformData"})
    void submitFormAndCheckTYpage(){
        WebElementHelper.safeFindAndClick(getWebDriver(),By.cssSelector(submitBtn) );
        sleep(1000);
        waitForUrlContains(getWebDriver(), urlContainsThankyou, 20);
        AssertHelper.assertThat("Url does not contain ["+urlContainsThankyou+"] ...!", getWebDriver().getCurrentUrl().contains(urlContainsThankyou));
    }
    // black listed  https://jira-bos.englishtown.com/browse/SAND-3276
    /*@Test(dependsOnMethods = {"submitFormAndCheckTYpage"})
    void checkStateObjectFormNoOfStaf(){
         assertStateObjectElementValue(noOfStafKey, noOfStaffValue, true);
    }*/

    /** no more leadtype after Jun 2017 new forms
    @Test(dependsOnMethods = {"submitFormAndCheckTYpage"})
    void checkStateObjectFormLeadType(){
        assertStateObjectElementValue(leadtypeKey, leadTypeValue, true);
    }*/


}
