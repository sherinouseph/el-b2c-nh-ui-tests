package com.englishtown.newhouse.apicore.survey;
/**
 * Created by nikol.marku on 26-Nov-18.
 *
 * 0. update notification and get notification to confirm update
 */

import com.englishtown.newhouse.apicore.commerceapi.BaseCreateBuyEnrollStudentTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;


public abstract class BaseSurveyApiTest extends BaseCreateBuyEnrollStudentTest {
    public static final Logger logger = LoggerFactory.getLogger(BaseSurveyApiTest.class);


    @Test(dependsOnMethods = "enrollStudentToSchool")
    public void getStudentNotificationTest() {
        getStudentNotification(studentBean, 3, 3);
    }

    @Test(dependsOnMethods = "getStudentNotificationTest")
    public void updateStudentNotificationTest() {
        updateStudentNotification(studentBean);
    }

    @Test(dependsOnMethods = "updateStudentNotificationTest")
    public void verifyStudentNotificationUpdatedTest() {
        getStudentNotification(studentBean, 1, 2);
    }

}