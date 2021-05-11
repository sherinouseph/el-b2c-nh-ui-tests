//package com.englishtown.commerceclient;//package com.englishtown.tests.misc;
//
//import com.englishtown.commerceclient.generated.MemberInfo;
//import com.englishtown.commerceclient.generated.SubscriptionInfo;
//import junit.framework.Test;
//import junit.framework.TestCase;
//import junit.framework.TestSuite;
//import org.codehaus.jackson.map.ObjectMapper;
//import org.codehaus.jackson.map.ObjectWriter;
//import org.junit.Assert;
//
//import java.io.IOException;
//import java.util.List;
//
//public class WrapperTest extends TestCase {
//    /**
//     * Create the test case
//     *
//     * @param testName name of the test case
//     */
//    public WrapperTest(String testName) {
//        super(testName);
//    }
//
//    /**
//     * @return the suite of tests being tested
//     */
//    public static Test suite() {
//        return new TestSuite(WrapperTest.class);
//    }
//
////    public void test_getTestUsersInfo() throws IOException {
////        Wrapper client = new Wrapper(Environment.QA);
////        ActionResult<MemberInfo> result = client.getMemberByEmail("test12345et1423841121667@qp1.org"); //getAllSubscriptions(30230286);
////        Assert.assertTrue(result.getSucceed());
////        System.out.println(" getCountryCode :" +result.getResult().getCountryCode().getValue() );
////        System.out.println(" getEmail :" +result.getResult().getEmail().getValue() );
////        System.out.println(" getMemberId :" +result.getResult().getMemberId().getValue() );
////        System.out.println(" getUserName :" +result.getResult().getUserName().getValue());
////    }
//
//
//    public void test_getMemberInfo() throws IOException {
//        Wrapper client = new Wrapper(Environment.Live);
//        ActionResult<MemberInfo> getMemberInfoResult = client.getMemberInfo(30230286);
//        Assert.assertTrue(getMemberInfoResult.getSucceed());
//
//        MemberInfo memberInfo = getMemberInfoResult.getResult();
//        Assert.assertNotNull(memberInfo);
//
//        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
//        String json = ow.writeValueAsString(memberInfo);
//        System.out.println(json);
//    }
//
//    public void test_getAllSubscriptions() throws IOException {
//        Wrapper client = new Wrapper(Environment.Live);
//        ActionResult<List<SubscriptionInfo>> result = client.getAllSubscriptions(30230286);
//        Assert.assertTrue(result.getSucceed());
//
//        List<SubscriptionInfo> subscriptionInfos = result.getResult();
//        Assert.assertNotNull(subscriptionInfos);
//
//        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
//        String json = ow.writeValueAsString(subscriptionInfos);
//        System.out.println(json);
//    }
//
//    public void test_cancelSubscriptionForMember() throws IOException {
//        Wrapper client = new Wrapper(Environment.Live);
//        ActionResult result = client.cancelSubscriptionForMember(30230286);
//        Assert.assertTrue(result.getSucceed());
//    }
//
//    public void test_cancelSubscriptionByEmail_non_test_account() throws IOException {
//        Wrapper client = new Wrapper(Environment.Live);
//        ActionResult result = client.cancelSubscriptionByEmail("studyplan001@gmail.com");
//        Assert.assertFalse(result.getSucceed());
//        Assert.assertTrue(result.getErrorMessage().contains("@qp1.org"));
//    }
//
//    public void test_cancelSubscriptionForMember_non_test_account() throws IOException{
//        Wrapper client = new Wrapper(Environment.Live);
//        ActionResult result = client.cancelSubscriptionForMember(28055875); //studyplan001@gmail.com
//        Assert.assertFalse(result.getSucceed());
//        Assert.assertTrue(result.getErrorMessage().contains("@qp1.org"));
//    }
//}
