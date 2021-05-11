package com.englishtown.newhouse.apicore;
/**
 * Created by nikol.marku on 02-Oct-17.
 * https://jira.eflabs.io/browse/SAND-5016
 * Campus Enroll
 * http://campus-enrollment.vagrant.f8/swagger/#/
 *
 *  * Test will :
 *  1. create user using /efid.vagrant.f8/
 *
 *
 */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;


public abstract class BaseCreateUser extends BaseSpecSuite{//} BaseApiSpec {
    public static final Logger logger = LoggerFactory.getLogger(BaseCreateUser.class);

    @Test
    public void createUserIdTest() {
        createUserId();
    }


    @Override
    public void setupTestBeanDataAndSpec() {
        //initSpecCreateUserApi();
        // initResponseSpecCreateUserApi();
    }

//    @AfterClass
//    protected void teardownAfterClass(){
//        logger.info("@ After Class ...!");
//        cancelSubscription(studentBean.getUserEmail());
//    }

}
