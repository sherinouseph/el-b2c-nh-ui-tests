package com.englishtown.tests.checkout.common.core;
/**
 * Note:
 * 1. Click Start learning
 * 2. Check Enrolment page (URL should contain 'enrollment') /... test stops here
 *
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;


public abstract class CheckEnrolmentTest extends NewCcBaseCheckoutFlowTest{
    private static final Logger logger = LoggerFactory.getLogger(CheckEnrolmentTest.class);

    protected boolean isEnrolStudent = false; // set this to true to enroll student


    @Test(dependsOnMethods = { "check_EFID_StudentId_StoredInDB" })  // setMemberIdAndMarket_check_memberId_NotNullTest
    void clickStartLearning(){
        click_StartLearning();
    }

    @Test(dependsOnMethods = { "clickStartLearning" })
    public void checkEnrolmentPage() {
        check_EnrolmentPage();
    }

    @Test(dependsOnMethods = { "checkEnrolmentPage" })
    public void enrolStudentToSchool(){
        assertIsUrlContaining("enrollment");    //assertIsUrlContaining("enrollment/b2c/entrance#1");
        if(isEnrolStudent)
            enrolStudentCheckAtSchool(isNewHouseEnroll, 1,1);
    }


}