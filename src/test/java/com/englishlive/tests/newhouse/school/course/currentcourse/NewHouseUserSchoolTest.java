//package com.englishlive.tests.newhouse.school.course.currentcourse;
///**
// *
// * User: Sherin
// * Date: 12/03/2018
// *This user checks the school page for a new user
// * more details in baseschoolnewusertest
// *
// *
// */
//
//import com.englishtown.newhouse.school.beanandenum.CourseCodeNumber;
//import com.englishtown.newhouse.school.beanandenum.SchoolStudentBean;
//import com.englishtown.tests.core.EfConstants;
//import com.englishtown.tests.core.school.BaseSchoolNewUserTest;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//Removing the test as we dont have any more website creating new users
//
//public class NewHouseUserSchoolTest extends BaseSchoolNewUserTest {
//    private static final Logger logger = LoggerFactory.getLogger(NewHouseUserSchoolTest.class);
//    @Value("#{applicationPropertiesList['checkout.member.tr.tr.url']}")
//    protected String currMemberPageUrl;
//
//    @BeforeClass
//    public void setup(){
//        setThreadSafeDriver();
//        isStoreData = true;
//        //isNewhousePayment=true;
//       // isNewHouseEnroll=true;
//        isNewhousePayment=true;
//        isNewHouseEnroll=true;
//        isNewhouseCheckout = true;
//        isNewhouseTyPage = true;
//        setLanguageAndMarket("tr", "tr");
//        cancelSubscription = false;
//        phase1OfferPrice ="99";
//        phase1OfferPrice ="49";

//        isEnrolStudent = true;
//        paymentSubmitBtnCss=".btn.btn-primary";
//        this.memberPageUrl = currMemberPageUrl;
//        this.formDataMap   = EfConstants.ukMembersFormMap_new;
//        isClickTabId=false;
//        creditCardLinkText="";
//
//        schoolStudentBean = new SchoolStudentBean();
//        schoolStudentBean.setUnitNumber(1);
//        schoolStudentBean.setLessonNumber(1);
//        schoolStudentBean.setStepNumber(1);
//        schoolStudentBean.setLevelNumber(1);
//        schoolStudentBean.setNoOfCompletedLessons(0);
//        schoolStudentBean.setNoOfCompletedSteps(0);
//        schoolStudentBean.setStep1Status("start");
//        schoolStudentBean.setStep2Status("start");
//        schoolStudentBean.setStep3Status("start");
//        courseCodeNumber = CourseCodeNumber.GENERAL_ENGLISH;
//
//        //this.openUrl(getWebDriver(), this.memberPageUrl, -1) ;
//        openUrl(getWebDriver(), getBASEURL()+"englishlive.ef.com/tr-tr/study-plans-and-prices/" );
//        String offerWeCss = ".package .btn.btn-primary";
//        //waitForElementVisibleAndClick(offerWeCss, 25);
//        waitForElementCondition(ExpectedConditions.elementToBeClickable(By.cssSelector(offerWeCss)), getWebDriver(), 25);
//        WebElement offerWe = findElement(By.cssSelector(offerWeCss), 15);
//        click(offerWe);
//    }
//
//    @Override
//    protected String getMemberPageUrl() {
//        memberPageUrl = currMemberPageUrl;
//        return memberPageUrl;
//    }
//
//
//    @Override
//
//    public void enrolStudentToSchool(){
//        assertIsUrlContaining("enrollment");    //assertIsUrlContaining("enrollment/b2c/entrance#1");
//        if(isEnrolStudent)
//            enrolStudentCheckAtSchool(isNewHouseEnroll, 1,1);
//    }
//
//
//
//    @AfterClass
//    protected void testAfterClass(){
//        destroyDriver();
//    }
//
//}
