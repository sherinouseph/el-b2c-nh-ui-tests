package com.englishtown.tests.core.school;
/**
 * Login an existing user and check my page content
 * User: nikol.marku
 * Date: 30/01/18
 *
 *
 */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;


public abstract class BaseSchoolHomePageTest extends BaseSimpleLogin {
    private static final Logger logger = LoggerFactory.getLogger(BaseSchoolHomePageTest.class);

    @Test(dependsOnMethods = "checkUserIsAtSchoolHomePage")
    protected void checkMyPage() {
        logger.info("checkMyPage .. not checking as checked on BaseSimpleLogin");
        // not needed as is checked in previous test
        //schoolHomePage.simpleTest();
    }



}
