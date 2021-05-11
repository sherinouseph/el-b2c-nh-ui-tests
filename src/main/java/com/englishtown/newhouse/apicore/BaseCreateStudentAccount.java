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
 *
 */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;


public abstract class BaseCreateStudentAccount extends BaseCreateUser{
    public static final Logger logger = LoggerFactory.getLogger(BaseCreateStudentAccount.class);

//  not needed   old FRED ADVICES to use PATCH /admin/account/{EFId}/grants and that will create student and account
//    @Test(dependsOnMethods = "createUserIdTest")
//    public void createStudentTest() {
//        createStudent();
//    }

//    @Test(dependsOnMethods = "createStudentTest")
//    public void createAccountTest() {
//        createCommerceApiMember();//adminCreateAccount();   // createAccount();
//        studentBean.print();
//    }


}
