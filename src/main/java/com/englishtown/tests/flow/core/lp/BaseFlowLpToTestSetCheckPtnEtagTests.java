package com.englishtown.tests.flow.core.lp;
/**
 * Test ptn and etag
 *
 */



import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;


public abstract class BaseFlowLpToTestSetCheckPtnEtagTests extends BaseFlowOeToTakeATest {
    private static final Logger logger = LoggerFactory.getLogger(BaseFlowLpToTestSetCheckPtnEtagTests.class);


    @Test
    public void enterFormTestData(){
        enterFormData(lpFormData);
    }

    @Test(dependsOnMethods = "enterFormTestData")
    public void submitForm(){
        click(getWebDriver(), By.cssSelector(submitBtnCss));
        sleep(2000);
    }

    @Test(dependsOnMethods = "submitForm")
    public void check_ThankyouPage(){
        assertIsUrlContaining(urlContains);
    }

    @Test(dependsOnMethods = "check_ThankyouPage")
    public void isPtnOnSessionStateObject(){
        assertStateObjectParnterCode(stoPtnKey, stoPtnValue);
        sleep(500);
    }

    @Test(dependsOnMethods = "check_ThankyouPage")
    public void isEtagOnSessionStateObject(){
        assertStateObjectEtag(stoEtagKey, stoEtagValue);
        sleep(500);
    }



}
