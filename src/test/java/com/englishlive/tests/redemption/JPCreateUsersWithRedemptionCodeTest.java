//package com.englishlive.tests.redemption;
///**
// *  JP
// *  Create users with redemption code
// *  
// */
//
//        import com.englishtown.dataprovider.HomePageDataProvider;
//        import com.englishtown.helpers.*;
//        import com.englishtown.pages.checkout.newcheckout.PaymentThankyouPage;
//        import com.englishtown.pages.common.school.EnrolmentPage;
//        import com.englishtown.pages.core.BasePage;
//        import com.englishtown.tests.core.BaseTest;
//        import com.englishtown.tests.core.EfConstants;
//        import com.englishtown.tests.flow.redemption.BaseRedemptionFlow;
//        import com.englishtown.tests.flow.redemption.RedemptionAutoSubmitFlow;
//        import org.apache.commons.lang.StringUtils;
//        import org.openqa.selenium.By;
//        import org.openqa.selenium.WebElement;
//        import org.openqa.selenium.support.ui.ExpectedConditions;
//        import org.slf4j.Logger;
//        import org.slf4j.LoggerFactory;
//        import org.springframework.beans.factory.annotation.Value;
//        import org.testng.annotations.AfterClass;
//        import org.testng.annotations.BeforeClass;
//        import org.testng.annotations.DataProvider;
//        import org.testng.annotations.Test;
//
//        import java.util.List;
//
//
//public class JPCreateUsersWithRedemptionCodeTest extends BaseRedemptionFlow {
//    private static final Logger logger = LoggerFactory.getLogger(JPCreateUsersWithRedemptionCodeTest.class);
//
//    protected String url = "https://englishlive.ef.com/ja-jp/buy/redemption/index/?rcode=rcodereplace&autosubmit=true";
//
//
//    @BeforeClass
//    public void setup(){
//
//    }
//
//
//    @Test(dataProvider = "emailCode")// threadPoolSize = 4, invocationCount = 1, timeOut = 60000 )
//    public void createUsers(String email, String code){
//        try {
//            setThreadSafeDriver();
//            redemptionCode = code;
//            logger.info("redemptionCode is : "+redemptionCode);
//            url = url.replace("rcodereplace", redemptionCode);
//            this.openUrl(getWebDriver(), this.url, -1 ) ;
//            WaitTool.waitForElementVisibleAndClickable(By.id("firstname"), getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
//
//            // member
//            createMember(email);
//            logger.info("Member created...!\n"+email+"\n ---------------\n");
//            // ty page and enroll
//            enroll();
//
//            logger.info("Member enrolled...!\n"+email+"\n ---------------\n");
//        }catch (Exception e){
//            logger.error("Failed to create/enroll user:"+email+" \n "+e.getMessage());
//        } finally {
//            destroyDriver();
//        }
//    }
//
//    @AfterClass
//    protected void destroyDriverAfterClass(){
//
//    }
//
//    public void createMember(String email){
//        enterFormData(EfConstants.ukMembersFormMap_new);
//        enterEmail(getWebDriver(), email, true);
//
//        WebElementHelper.safeFindAndClick(getWebDriver(), By.cssSelector(submitMemberFormCss));
//        sleep(3000);
//    }
//
//    public void enroll(){
//        WaitTool.waitForCondition( ExpectedConditions.invisibilityOfElementLocated(
//                By.cssSelector(memberSpinnerCss)),getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
//        enrolStudentCheckAtSchool();
//
//
//    }
//
//
//
//    public void enrolStudentCheckAtSchool() {
//        //ty
//        PaymentThankyouPage paymentThankyouPage = new PaymentThankyouPage(getWebDriver(), 35) ;
//        paymentThankyouPage.getPageLoadedCondition(false);
//        WaitTool.waitForElementVisibleAndClickable(By.className("btn-lg"), getWebDriver(), WaitToolConfig.MED_WAIT_4_ELEMENT25);
//        click(paymentThankyouPage.startLearning);
//        BaseTest.sleep(2000);
//
//        EnrolmentPage enrolmentPage = new EnrolmentPage(getWebDriver());
//        enrolmentPage.startEnrolment();
//        // Step 1
//        enrolmentPage.simpleTest();
//        enrolmentPage.selectImproveEnglishFor(1);
//        // Step 2
//        BaseTest.sleep(2000);
//        enrolmentPage = new EnrolmentPage(getWebDriver());
//        enrolmentPage.waitStepLoaded(By.cssSelector(enrolmentPage.stepBackCss));
//        // select level   .levels-selector li  mouse over  [3]   levels-selector li label span
//
//        WaitTool.waitForCondition(ExpectedConditions.elementToBeClickable(By.cssSelector(".levels-selector li")), getWebDriver(), 25);
//        List<WebElement> levelWe = findElements(By.cssSelector(".levels-selector li"));
//
//        MyWebDriverAction.mouseOver(getWebDriver(), levelWe.get(3));
//        sleep(3000);
//        //WaitTool.waitForCondition(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".levels-selector li label span")), getWebDriver(), 25);
//
//        WebElement we = levelWe.get(3).findElement(By.cssSelector("label span"));
//        click(we); //WaitTool.findElement(getWebDriver(), By.cssSelector(levelListSelectThisLevelCss)));
//        sleep(3000);
//        //enrolmentPage.selectEnglishLevel(1);
//        // Step 3
//        //BaseTest.sleep(2000);
//        enrolmentPage.checkUrlEnrolmentPageUrlStepNo("3");
//        enrolmentPage.clickStartLearning();
//        BaseTest.sleep(3000);
//    }
//
//
//    @DataProvider(name = "emailCode")//, parallel = true)
//    public static Object[][] allMarketHomePageUrlsData() {
//        return new Object[][] {
//                //{   "nikolaki+11@qp1.org", "JP1M8PL30GL9F5306D29" } ,
//                //{   "nikolaki+9@qp1.org", "TEST1DSS35095CC912FE" }
//        };
//    }
//
//
//
//}
