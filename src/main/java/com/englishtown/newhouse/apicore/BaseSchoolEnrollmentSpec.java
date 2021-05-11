package com.englishtown.newhouse.apicore;
/**
 * Created by nikol.marku on 02-Oct-17.
 * https://jira.eflabs.io/browse/SAND-5016
 * Campus Enroll
 * http://campus-enrollment.vagrant.f8/swagger/#/
 *
 *  * Test will :
 *  1. enroll student
 *
 */
import com.englishtown.enumpack.SalesOrderStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;


public abstract class BaseSchoolEnrollmentSpec extends BaseCreateStudentAccount {
    public static final Logger logger = LoggerFactory.getLogger(BaseSchoolEnrollmentSpec.class);


    @Test(dependsOnMethods = "createUserIdTest") //"createAccountTest")
    public void buyWithCreditCardCommerceApiTest() {
        commerceApiBuyWithCreditCard(studentBean, testCard, SalesOrderStatus.ORDERED, true);
    }

    @Test(dependsOnMethods = "buyWithCreditCardCommerceApiTest")
    public void enrollStudentTest() {
        //TODO Oneal need to update api and need to use POST school services POST /admin/account/{EFId}/enroll to enrol student
        if(isSchoolEnrolment) {
            logger.info("enroll using school services ...!");
            enrollStudentUsingSchoolServices();
        } else {
            logger.info("enroll using Campus services ...!");
            //
            enrollStudentUsingCampusServices();

        }
    }

    /**
     * GET /enrollment/member/{userId}/has-enrollment
     * GET /enrollment/member/{userId}
     */
    @Test(dependsOnMethods = "enrollStudentTest")
    public void getCampusEnrollmentMemberTest() {
        if(isRunGetMemberAndHasEnrol) {
            getCampusEnrollmentMember();
        }else
            logger.warn("getCampusEnrollmentMember test is set to NOT run ...!");
    }

    @Test(dependsOnMethods = "enrollStudentTest")
    public void getCampusEnrollmentMemberHasEnrollmentTest() {
        if(isRunGetMemberAndHasEnrol) {
            getCampusEnrollmentMemberHasEnrollment();
        } else
            logger.warn("getCampusEnrollmentMemberHasEnrollment test is set to NOT run ...!");
    }


}
