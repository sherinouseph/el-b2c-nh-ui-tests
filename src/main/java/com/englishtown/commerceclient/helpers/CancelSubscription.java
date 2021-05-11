//package com.englishtown.commerceclient.helpers;
//
//import com.englishtown.commerceclient.ActionResult;
//import com.englishtown.commerceclient.Environment;
//import com.englishtown.commerceclient.Wrapper;
//import com.englishtown.tests.core.BaseTestHelper;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
//
//import static com.englishtown.helpers.AssertHelper.myAssertThat;
//
///**
// * Created by nikol.marku on 9/30/2016.
// */
//public class CancelSubscription extends BaseTestHelper {
//
//    @Test(dataProvider = "usersToCancel")
//    public void cancelSubscription(int id, String user) {
//        Wrapper client = new Wrapper(Environment.getCurrentEnvironment("live"));
//        ActionResult result = client.cancelSubscriptionByEmail(user);
//        myAssertThat(getWebDriver(), "Failed to cancel subscription ...", result.getSucceed(), true);
//    }
//
//    @DataProvider(name = "usersToCancel")
//    public Object[][] createusersToCancel() { //qa
//        return new Object[][]{
//                //live
//                { 1, "auto_1475222966735_xdelx@qp1.org"},
//                { 2, "auto_1475223012261_xdelx@qp1.org"},
//                { 3, "auto_1475223057275_xdelx@qp1.org"},
//                { 4, "auto_1475223103158_xdelx@qp1.org"},
//                { 5, "auto_1475223147526_xdelx@qp1.org"},
//                { 6, "auto_1475223191636_xdelx@qp1.org"},
//                { 7, "auto_1475223235727_xdelx@qp1.org"}
//                /*qa
//                {1, "auto_1475165517352_xdelx@qp1.org"},
//                {2, "auto_1475165806133_xdelx@qp1.org"},
//                {3, "auto_1475165961692_xdelx@qp1.org"},
//                {4, "auto_1475166184156_xdelx@qp1.org"},
//                {5, "auto_1475166298972_xdelx@qp1.org"},
//                {6, "auto_1475166499537_xdelx@qp1.org"},
//                {7, "auto_1475222640385_xdelx@qp1.org"},
//                {8, "auto_1475222688026_xdelx@qp1.org"},
//                {9, "auto_1475222735642_xdelx@qp1.org"},
//                {10, "auto_1475222782003_xdelx@qp1.org"},
//                */
//        };
//    }
//
//}
