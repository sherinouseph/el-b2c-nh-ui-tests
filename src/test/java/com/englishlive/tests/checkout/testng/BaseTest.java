package com.englishlive.tests.checkout.testng;
/**
 * test order simple test
 */

import com.englishtown.tests.core.BaseTestHelper;
import org.testng.annotations.Test;

public abstract class BaseTest extends BaseTestHelper{

    @Test
    protected void baseTest(){
        System.out.println("baseTest 1 ........");
    }

    @Test(dependsOnMethods = {"baseTest"})
    protected void baseTest2(){
        System.out.println("baseTest 2 ........");
    }
}
