package com.englishtown.newhouse.apicore;
/**
 * Created by nikol.marku on 02-Oct-17.
 * Commerce api
 * Base School services API tests
 * http://school-services.vagrant.f8/swagger/
 *
 *  * Test will :
 *  5. patch account
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;


public abstract class BaseSchoolPatchAccount extends BaseSchoolEnrollmentSpec {
    public static final Logger logger = LoggerFactory.getLogger(BaseSchoolPatchAccount.class);

    @Test(dependsOnMethods = "enrollStudentTest")
    public void patchAccountTest() {
        patchAccount();
    }

    // TODO
    // The below test do not really belong here
    // think of moving them ... but at the moment there are 2 create student/member/enrol using school services or commerce
    /**
     * Real browser test
     *
     */
    @Test(dependsOnMethods = "patchAccountTest") //"commercePurchaseTest")      // "patchAccountTest")
    public void loginUserTest() {
        setGridEnvironmentFromDargs();
        createThreadSafeDriver();
        openUrl(baseUrl);
        loginUser(null, null);
    }

    @Test(dependsOnMethods = "loginUserTest")
    public void checkStudentLevelNameNumberTest() {
        //TODO AssertHelper.assertThat("This part not ready so far ... fred is working on commerce create account and Erden on school ui... waiting for them ", 1==2);
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