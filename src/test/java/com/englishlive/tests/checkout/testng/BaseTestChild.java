package com.englishlive.tests.checkout.testng;


import org.testng.annotations.Test;

public abstract class BaseTestChild extends BaseTest {

    @Test(dependsOnMethods = {"baseTest2"})
    protected void baseTestOne(){
        System.out.println("BaseTestChild  3 ........");
    }

    @Test(dependsOnMethods = {"baseTestOne"})
    protected void baseTestOneA(){
        System.out.println("BaseTestChild  4 ........");
    }
}
