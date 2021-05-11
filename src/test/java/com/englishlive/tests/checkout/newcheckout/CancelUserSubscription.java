//package com.englishlive.tests.checkout.newcheckout;
///**
// * Nikol 2018
// *
// * Use this to cancel user subscription
// */
//
//import com.englishtown.tests.core.BaseTestHelper;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
//
//public final class CancelUserSubscription extends BaseTestHelper{
//    private String userEmail;
//
//    @Test(dataProvider = "cancelEmailsDp")
//    private void cancelUserSubscriptionTest(int id, String userEmail){
//        cancelUserSubscription_OldHouse(userEmail);
//    }
//
//
//    @DataProvider(name = "cancelEmailsDp")//, parallel = true)
//    public static Object[][] cancelEmailsDp() {
//        return new Object[][]{
//                {1, "auto_260379362986832_SVZAJLP261440452_xdelx@qp1.org"},
//                //{2, ""},
//        };
//    }
//
//}
