package com.englishtown.newhouse.apicore.commerceapi;
/**
 * Created by nikol.marku on 26-Nov-18.
 *
 * 0. Create User
 * 1. Create commerce member
 * 2. Buy with CC
 * 3. Enroll
 */

import com.englishtown.enumpack.SalesOrderStatus;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.newhouse.apicore.BaseCreateUser;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

/***
 * NOTE :>>> This test is not run in live
 */

public abstract class BaseCreateBuyEnrollStudentTest extends BaseCreateUser {
    public static final Logger logger = LoggerFactory.getLogger(BaseCreateBuyEnrollStudentTest.class);

    protected String loginUrl = "https://qa-englishlive.ef.com/en-gb/login";


    @Test(dependsOnMethods = "createUserIdTest")
    public void createCommerceApiMemberTest() {
        createCommerceApiMember();
    }

    @Test(dependsOnMethods = "createCommerceApiMemberTest")
    public void buyWithCreditCardCommerceApiTest() {
        if(StringUtils.equals("live", getENVIRONMENT())) {
            logger.warn("This is live no CC test run ... ONLY QA we run this ...!");
        }
        else {
            commerceApiBuyWithCreditCard(studentBean, testCard, SalesOrderStatus.ORDERED, true);
            TestUtil.mySleep(5000);
        }
    }

    @Test(dependsOnMethods = "buyWithCreditCardCommerceApiTest")
    public void enrollStudentToSchool(){
        logger.info(" enroll ...!");
        enrollStudent(getENVIRONMENT(), studentBean, loginUrl);
    }


}