package com.englishtown.newhouse.apicore;
/**
 * Created by nikol.marku on 02-Oct-17.
 * https://jira.eflabs.io/browse/SAND-5016
 * Campus Enroll
 * http://campus-enrollment.vagrant.f8/swagger/#/
 *
 *  * Test will :
 *  1. create user
 *  2. create student
 *  3. create account
 *  4. enroll student
 *  5. get member
 *  6. get member has enrolment
 *  7. login
 *  8. check student level and Name
 *  9. check student current unit and plan
 *
 */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;


public abstract class BaseCampusEnrollmentApiPurchaseSpec extends BaseCheckSchoolPurchaseSpec {//} BaseCreateUserStudentAccount{
    public static final Logger logger = LoggerFactory.getLogger(BaseCampusEnrollmentApiPurchaseSpec.class);

    //@Override
    @Test(dependsOnMethods = "createAccountTest")
    public void enrollStudentCampusTest() {
        isPatchAccount = false;
        isRunGetMemberAndHasEnrol = true;
        enrollStudentUsingCampusServices();
    }

    /**
     * GET /enrollment/member/{userId}/has-enrollment
     * GET /enrollment/member/{userId}
     */
    @Test(dependsOnMethods = "enrollStudentTest")
    public void getCampusEnrollmentMemberTest() {
        getCampusEnrollmentMember();
    }

    @Test(dependsOnMethods = "enrollStudentTest")
    public void getCampusEnrollmentMemberHasEnrollmentTest() {
        getCampusEnrollmentMemberHasEnrollment();
    }


}
