package com.englishtown.tests.core.school.useraccount;
/**
 *
 * User: nikol.marku
 * Date: 07/02/18
 *
 * 1. Change personal details
 *
 *
 */

import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.MyWebDriverAction;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.newhouse.school.pages.account.PersonalDetailsPage;
import com.englishtown.tests.core.school.BaseSchoolHomePageTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

// TODO: this is going to change so leave it there and wait for changes

public abstract class BaseChangePersonalDetailsTest extends BaseSchoolHomePageTest {
    private static final Logger logger = LoggerFactory.getLogger(BaseChangePersonalDetailsTest.class);

    protected int subscriptionFeatureNumber = 3; // default

    private String currentFirstName;
    private String updatedFirstName;


    @Test(dependsOnMethods = "checkMyPage")
    public void goToPersonalDetailsPageAndCheckPageContent() {
        personalDetailsPage = new PersonalDetailsPage(getWebDriver());
        openPageUrl(personalDetailsPage);
        personalDetailsPage = new PersonalDetailsPage(getWebDriver());
        personalDetailsPage.simpleTest();
        personalDetailsPage.checkAllPageComponentsDisplayed();
    }

    @Test(dependsOnMethods = "goToPersonalDetailsPageAndCheckPageContent")
    public void getUserDetails() {
        personalDetailsPage.getCurrentUserDetailsAndSetStudentBean(schoolStudentBean, schoolStudentUpdatedBean);
    }


    @Test(dependsOnMethods = "getUserDetails")
    public void updateOneFieldFirstName() {
        logger.info("updateOneFieldFirstName ....!");
        MyWebDriverAction.clearAndSetText(getWebDriver(), personalDetailsPage.firstNameWe, schoolStudentUpdatedBean.getFirstName());
        click(personalDetailsPage.lastNameWe);
        logger.info("updateOneFieldFirstName ....! Click Save ");
        personalDetailsPage.clickSaveChangesPopup();
        personalDetailsPage.waitForPopupTxtSaved();
        sleep(700);
        logger.info("Saved ...! ");
        refresh(getWebDriver());
        sleep(1000);
    }

    @Test(dependsOnMethods = "updateOneFieldFirstName")
    public void checkFirstNameIsUpdated() {
        logger.info("checkFirstNameIsUpdated ....!");
        personalDetailsPage = new PersonalDetailsPage(getWebDriver(), 15);
        personalDetailsPage.simpleTest();
        updatedFirstName = TestUtil.getWebElementText(personalDetailsPage.firstNameWe);
        logger.info("FirstName [{}]", updatedFirstName);
        AssertHelper.assertStringContains(schoolStudentUpdatedBean.getFirstName(), updatedFirstName, "Firstname is not saved ...!");
    }


}


    //TODO negative Test enter number on first name - create new base test for this
/*
    @Test (dependsOnMethods = "goToPersonalDetailsPageAndCheckPageContent")
    public void updateTwoFields_LastNameAndGender(){
        //TODO
    }

    /**
     * Not Password
     *
    @Test (dependsOnMethods = "goToPersonalDetailsPageAndCheckPageContent")
    public void updateOneFieldPerSection_DOB_Mobile_City(){
        //TODO
    }


    @Test (dependsOnMethods = "checkFirstNameIsUpdated")
    public void logoutAndLogbacInCheckUserDetailsUpdated(){
        //TODO once UI is updated
    }*/








/**

 String firstName     = getText(personalDetailsPage.firstNameWe) ;
 String lastName = getText(personalDetailsPage.lastNameWe) ;
 String gender          = getText(personalDetailsPage.genderWe) ;
 String mobile          = getText(personalDetailsPage.mobilePhoneWe) ;
 String city          = getText(personalDetailsPage.cityWe) ;

 if(StringUtils.isBlank(firstName)) {
 failTest("Cant get Current First Name  ...!");
 }else {
 schoolStudentBean.setFirstName(firstName);
 String newName = new StringBuffer(firstName).reverse().toString();
 schoolStudentUpdatedBean.setFirstName(newName);
 }
 schoolStudentBean.setLastName(lastName);
 schoolStudentBean.setGender(Gender.getGender(gender));
 schoolStudentBean.setMobilePhone(mobile);
 schoolStudentBean.setCity(city);


 // TODO: Discard changes test
 @Test (dependsOnMethods = "checkFirstNameIsUpdated")
 public void checkDiscardChanges(){
 logger.info("Update and discard changes ....!");
 sendKey(getWebDriver(), personalDetailsPage.firstNameWe,  "updated", false);
 click(personalDetailsPage.lastNameWe);
 sleep(1000);
 logger.info("updateOneFieldFirstName ....! Click Save ");
 personalDetailsPage.clickDiscardChangesPopup();
 sleep(2000);
 logger.info("Discarded ...! ");
 personalDetailsPage = new PersonalDetailsPage(getWebDriver());
 personalDetailsPage.simpleTest();
 currentFirstName = TestUtil.getWebElementText(personalDetailsPage.firstNameWe) ;
 logger.info("currentFirstName ["+currentFirstName+" Should be the same as updatedFirstName ["+updatedFirstName+"]");
 AssertHelper.assertStringContains(currentFirstName, updatedFirstName,"Firstname is not saved ...!");
 }



 @Test (dependsOnMethods = "getUserDetails")
 public void checkFirstNameNumberValidationMessage(){
 // send number key to show validation message
 sendKey(getWebDriver(), personalDetailsPage.firstNameWe, "45", false);
 click(personalDetailsPage.lastNameWe);
 //personalDetailsPage.firstNameWe.sendKeys(Keys.TAB );
 sleep(1000);
 personalDetailsPage = new PersonalDetailsPage(getWebDriver());
 waitForElementCondition(ExpectedConditions.visibilityOf(personalDetailsPage.validationMessageListWe.get(0)),
 getWebDriver(), 15);
 personalDetailsPage.checkValidationMessage(0,PersonalDetailsPage.VALIDATION_MSG_FNAME );
 logger.info("...");
 }






 **/