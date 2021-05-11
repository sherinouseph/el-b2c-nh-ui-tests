package com.englishtown.tests.core.community;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

/**
 * for non active community student test
 */

public abstract class BaseLoginCommunityNonActiveStudentTest extends BaseLoginCommunityTest {
    private static final Logger logger = LoggerFactory.getLogger(BaseLoginCommunityNonActiveStudentTest.class);


    @Test (dependsOnMethods = { "loginCommunityUser" })
    public void isNonAcativeStudent(){
        communityHomePage.isNotActiveStudent();
    }
}
