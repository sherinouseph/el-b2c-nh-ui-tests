package com.englishtown.newhouse.apicore.commerceapi;
/**
 * Created by nikol.marku on 06-Dec-17.
 *
 * 0. Create User
 * 1. Create commerce member
 * 2. Buy with CC
 * 3. Buy with DD
 * 4. check is users old login ... new school user
 * 5. check user old login user noon existent email
 * 6. update member details ... first name
 * 7. get account details
 * 8. get member
 */

import com.englishtown.enumpack.GatewayType;
import com.englishtown.enumpack.OfferType;
import com.englishtown.enumpack.SalesOrderStatus;
import com.englishtown.enumpack.TestCard;
import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.newhouse.apicore.BaseCreateUser;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.core.IsEqual.equalTo;

/***
 * NOTE :>>> This test is not run in live
 */

public abstract class BaseCommerceApiAllTest extends BaseCreateUser {
    public static final Logger logger = LoggerFactory.getLogger(BaseCommerceApiAllTest.class);


    @Test(dependsOnMethods = "createUserIdTest")
    public void createCommerceApiMemberTest() {
        createCommerceApiMember();
    }

    //TODO error
    @Test(dependsOnMethods = "createCommerceApiMemberTest")
    public void buyWithDirectDebitCommerceApiTest() {
        //        //TestUtil.mySleep(61000); // to make this last token, Fred adviced        //studentBean.setOffer_id("1001");//BUY_DD_OFFER_ID); //33230 "33350");
        //TODO remove comment
        commerceApiBuyWithDirectDebit(studentBean, SalesOrderStatus.ORDERED);
        String sleepMsg = "Going to Sleep for 61 seconds to make this payment token the last one...!";
        logger.info(sleepMsg);
        TestUtil.mySleep(61000);
    }

    @Test(dependsOnMethods = "buyWithDirectDebitCommerceApiTest")
    public void buyWithCreditCardCommerceApiTest() {
        if(StringUtils.equals("live", getENVIRONMENT())) {
            logger.warn("This is live no CC test run ... ONLY QA we run this ...!");
            //studentBean.setOffer_id(BUY_DD_OFFER_ID);
            testCard    = TestCard.DD_CardType;
            gatewayType = GatewayType.PAYMENTTECH;
        }
        else {
            studentBean.setOffer_id(BUY_CC_OFFER_ID);
            //TestUtil.mySleep(61000); // to make this last token, Fred advised
            commerceApiBuyWithCreditCard(studentBean, testCard, SalesOrderStatus.ORDERED, true);
        }
    }

    @Test(dependsOnMethods = "buyWithCreditCardCommerceApiTest")
    public void getMemberPaymentTokeAccountCommerceApiTest() {
        commerceApiGetMemberPaymentToken(gatewayType); //GatewayType.CYBERSOURCE);
    }
    // TODO check with fred as thould be payment tec last payment token DD
    // update offers for this test to new offers : 33368 for CC and 33358 -> eur

    @Test(dependsOnMethods = "buyWithCreditCardCommerceApiTest")
    public void postOrderPaymentTokeCaptureCommerceApiTest() {
        //todo  "Code": "Error_Validate",        "Message": "Invalid id."
        //studentBean.setOffer_id(BUY_DD_OFFER_ID); //33230 "33350");
        commerceApiGetOrderPaymentToken(studentBean, SalesOrderStatus.ORDERED, false);
    }


    @Test(dependsOnMethods = "buyWithCreditCardCommerceApiTest")
    public void getOrderCommerceApiTest() {
        //studentBean.setOffer_id(BUY_CC_OFFER_ID);
        commerceApiGetOrder(studentBean);
    }


    @Test(dependsOnMethods = "buyWithCreditCardCommerceApiTest") //"createCommerceApiMemberTest")
    public void getCommerceApiMemberTest() {
        getCommerceApiMember();
    }

    @Test(dependsOnMethods = "createCommerceApiMemberTest")
    public void updateMemberTest() {
        updateMemberCommerceApi();
    }

    /**
     * GET /_api/commerce/member/use-old-login-handler
     * if user is a new user at new school returns true otherwise false even if user does not exist
     */
    @Test(dependsOnMethods = "createCommerceApiMemberTest")
    public void isUserOldLogin_useNonExistentEmailForOldSchoolUser() {
        getIsUseOldLoginCommerceApi(true);
        //response = defaultGetResponseGetSpec();//response.getBody().asString()
        AssertHelper.assertThat("Note the expected response ...!", response.asString().trim(),
                equalTo("true"));
    }

    @Test(dependsOnMethods = "createCommerceApiMemberTest")
    public void isUserOldLogin_newSchoolUser() {
        getIsUseOldLoginCommerceApi(false);
        AssertHelper.assertThat("Note the expected response ...!", response.asString().trim(),
                equalTo("false")); //String.valueOf(false)));
    }

//    @Test(dependsOnMethods = "isUserOldLogin_useNonExistentEmailForOldSchoolUser")
//    public void isUserOldLogin_newSchoolUserEFID_ONLY_notamember() {
//        //this user is efid only not a member 02/08 fails in live and qa method need to be changed to check on efid on member
//        userEmail = studentBean.getUserEmail();
//        try {
//            studentBean.setUserEmail("nikol.tr.efidonly@qp1.org");
//            getIsUseOldLoginCommerceApi(false);
//            AssertHelper.assertThat("Note the expected response - To Be Implemented soon to use efid not member ...!", response.asString().trim(),
//                    equalTo("false")); //String.valueOf(false)));
//        }finally {
//            studentBean.setUserEmail(userEmail);
//        }
//    }

    @Test(dependsOnMethods = "buyWithCreditCardCommerceApiTest")
    public void getAccountDetails() {        //TODO Waiting fred to implement it  logger.warn("Waiting Erden logic ... student need to be an active student that has paid or  to implement it");
        getCommerceApiAccountDetails();
    }

    @Test(dependsOnMethods = "buyWithCreditCardCommerceApiTest")
    public void testValidateOffer() {
        validateOfferCommerceApi(studentBean.getUser_id(), studentBean.getOffer_id(), OfferType.SUBSCRIPTION);
    }

    /**
     * TODO test this
     */
    @Test(dependsOnMethods = "buyWithCreditCardCommerceApiTest")
    public void testSubscription() {
        commerceApiGetSubscription(studentBean, "Active", false);
    }

    @Test(dependsOnMethods = "buyWithCreditCardCommerceApiTest")
    public void testStudentType() {
        commerceApiGetStudentType(studentBean, 200, "CurrentStudent");
        AssertHelper.assertThat("Note the expected Student type ...!",
                response.asString(), containsString("CurrentStudent"));
    }

    @Test(dependsOnMethods = "buyWithCreditCardCommerceApiTest")
    public void testOrderRedeem() {
        //studentBean.setOffer_id("2351");       studentBean.setCountry("DE");
        commerceApiGetOrderRedeem(studentBean);
    }

    @Test(dependsOnMethods = "buyWithCreditCardCommerceApiTest")
    public void testValidateRedemptionCode() {
        commerceApiValidateRedempionCode(studentBean, REDEMPTION_CODE);
    }


//    @AfterClass
//    public void teardown() {
//        cancelSubscription(studentBean.getUserEmail());
//    }
}