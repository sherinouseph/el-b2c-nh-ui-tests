package com.englishlive.tests.newhouse.salesforce.base;
/**
 * sherin- 10/11/2017
 * Map the student
 * Click on Map Student button, enter password,click on create,click on close button
 */

import com.englishlive.tests.newhouse.salesforce.base.paymentflow.BaseCyberSourcePCITest;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.WebDriverWindowHelper;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
//
public abstract class BaseMapStudentTest extends BaseCyberSourcePCITest {
    private static final Logger logger = LoggerFactory.getLogger(BaseMapStudentTest.class);

    @Test(dependsOnMethods ="verifyActuals")
    public void loginAsSupervisorAndGoToActuals(){
        actualUrl=getWebDriver().getCurrentUrl();
        openCurrentActualPageUrl(salesForceSupervisorName);
    }


    @Test(dependsOnMethods = "loginAsSupervisorAndGoToActuals")
    public void mapStudentTest(){
        clickmapStudentBtn();
        WaitTool.waitForCondition(ExpectedConditions.numberOfWindowsToBe(2), getWebDriver(), 120);
        sleep(1000);
        WebDriverWindowHelper.switchToWindow(getWebDriver(),1);
        mapStudent();
    }

    @Test(dependsOnMethods = "mapStudentTest")
    public void verifymappingStatusTest() {
        WebDriverWindowHelper.switchToWindow(getWebDriver(),0);
        refresh(getWebDriver());
        checkMappingstatus();
        logger.info("Member id :"+getMemberId());        //checkActivationstatus();        //getEtownOrderId();
        setUserMemberId(getMemberId());
    }

    @Test(dependsOnMethods="verifymappingStatusTest")
    protected void submitApprovalInActualsTest() {
         submitApprovalInActulas();
     }

    @Test(dependsOnMethods = "submitApprovalInActualsTest")
    public void activateCourseTest(){
        clickActivateCourseBtn();
        WebDriverWindowHelper.switchToWindow(getWebDriver(),1);
        activateCourse();
    }

    @Test(dependsOnMethods = "activateCourseTest")
    public void verifyActivationStatusTest(){
        logger.info("verifyActivationStatusTest");
        WebDriverWindowHelper.switchToWindow(getWebDriver(),0);
        refresh(getWebDriver());
        checkActivationstatus();
        getEtownOrderId();

    }

}
