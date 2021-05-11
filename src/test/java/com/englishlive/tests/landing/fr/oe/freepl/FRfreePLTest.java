//package com.englishlive.tests.landing.fr.oe.freepl;
///**
// * * Created by nikol.marku on 29/03/2017.
// * https://jira-bos.englishtown.com/browse/SAND-3771
// * Free PL test
// *
// *
// */
//
//import com.englishtown.tests.core.BaseTestHelper;
//
//import org.openqa.selenium.By;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.testng.annotations.Test;
//
//
//public abstract class FRfreePLTest extends BaseTestHelper {
//    private static final Logger logger = LoggerFactory.getLogger(FRfreePLTest.class);
//
//
//    protected String tyTextWeToCheckCss = ".constraint h1";
//    protected String tyTextWeToCheck = "Merci ";
//
//
//    @Test
//    public void enterFreePlFormData(){
//        enterFormDataCss(formDataMap);
//        sleep(1000);
//    }
//
//    @Test(dependsOnMethods = {"enterFreePlFormData"})
//    public void submitForm(){
//        click(getWebDriver(), By.cssSelector(submitBtn));
//        sleep(5000);
//    }
//
//    @Test(dependsOnMethods = {"submitForm"})
//    public void checkFreePlTyPage(){
//        assertIsUrlContaining(urlContainsThankyou);
//        //assertWebElementText(tyTextWeToCheckCss,tyTextWeToCheck);
//        sleep(1000);
//    }
//
//    @Test(dependsOnMethods = { "submitForm" })
//    protected void verifyThankyouPageStateObjectEvents(){
//        assertThankyouPageStateObjectLpOeTrackingEvents();
//    }
//
//    @Test(dependsOnMethods = { "submitForm" })
//    protected void verifyStateObjectLeadId(){
//        assertThankyouPageStateObjectLpOeLeadId() ;
//    }
//
//    @Test (dependsOnMethods = { "submitForm" })
//    void isLeadType(){
//        logger.info("Check lead type is ["+formLeadTypeValue+"]");
//        assertStateObjectElementValue(formLeadTypeKey,formLeadTypeValue, true);
//    }
//
//
//
//
//
//
//}
