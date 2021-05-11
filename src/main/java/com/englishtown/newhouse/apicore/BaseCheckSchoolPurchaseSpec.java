package com.englishtown.newhouse.apicore;
/**
 * Created by nikol.marku on 02-Oct-17.
 * Commerce api
 * Base School services API tests
 * http://school-services.vagrant.f8/swagger/
 *
 *  * Test will :
 *  1. login to school with real browser
 *  2. check LevelName and current Units
 *  3. Check student course plan page
 *  using :
 *  "schoolId": "b2c.englishlive",
 *  "businessUnit": "b2c"
 *
 *  Note : need to validate the path is working even though we get true on response body
 *      and probably login with the user and check it has the right setting
 *
 *      TODO : Need to Create Student with different set of account feature grants ? ask Vahid
 */

import com.englishtown.helpers.AssertHelper;
import com.englishtown.newhouse.apicore.commerce.BaseCommercePurchaseSpec;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;


public abstract class BaseCheckSchoolPurchaseSpec extends BaseCommercePurchaseSpec { // { BaseSchoolPatchAccount {
    public static final Logger logger = LoggerFactory.getLogger(BaseCheckSchoolPurchaseSpec.class);


    /**
     * Real browser test
     *
     */
    @Test(dependsOnMethods = "commercePurchaseTest") //"commercePurchaseTest")      // "patchAccountTest")
    public void loginUserTest() {
        setGridEnvironmentFromDargs();
        createThreadSafeDriver();
        openUrl(baseUrl);
        loginUser(null, null);
    }

    @Test(dependsOnMethods = "loginUserTest")
    public void checkStudentLevelNameNumberTest() {
       //TODO
        AssertHelper.assertThat("This part not ready so far ... fred is working on commerce create account and Erden on school ui... waiting for them ", 1==2);
        checkStudentLevelNameNumber(student_level_name, student_level);
    }

    @Test(dependsOnMethods = "checkStudentLevelNameNumberTest")
    public void checkStudentCurrentUnitTest() {
        checkStudentCurrentUnit(student_current_unit);
    }


    @Test(dependsOnMethods = "checkStudentCurrentUnitTest")
    public void checkStudentCoursePlanTestTest() {
        checkStudentCoursePlan(studentLessonNumber);
    }


    @AfterClass
    protected void testAfterClass() {
        destroyDriver();
    }


}