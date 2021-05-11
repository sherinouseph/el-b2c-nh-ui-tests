package com.englishtown.newhouse.apicore.commerceapi;
/**
 *
 * Get tests for http://commerce-api.vagrant.f8/swagger/#/
 *  id=32282
 *  1. Create User
 *  2. Create Member
 *  3. BuyWithCC
 *  4. GetPayInfo
 *  5. GetOrder
 *  6. GetOrderRecur  TODO
 *  7. BuyWithExistingCC  user offer id 195
 *  8. BuyWithDrirectDebit TODO
 */

import com.englishtown.enumpack.CardType;
import com.englishtown.enumpack.GatewayType;
import com.englishtown.enumpack.SalesOrderStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;


public abstract class BaseCommerceApi extends BaseCreateCommerceApiMember {
    public static final Logger logger = LoggerFactory.getLogger(BaseCommerceApi.class);

    @Test(dependsOnMethods = "createCommerceApiMemberTest")
    public void buyWithCreditCardTest() {
        //TODO refactor buy with any card or DirectDebit use same response check with params
        commerceApiBuyWithCreditCard(studentBean, testCard, SalesOrderStatus.ORDERED, true);
    }
    @Test(dependsOnMethods = "buyWithCreditCardTest")
    public void getOrderTest() {
        commerceApiGetOrder(studentBean);//, GatewayType.CYBERSOURCE, CardType.VISA, "411111******1111");
    }

    /// ????????????????????????????????????????????
    @Test(dependsOnMethods = "buyWithCreditCardTest")
    public void getSubscriptionTest() {
        //TODO get subscription
        //commerceApiGetMemberPayInfo(studentBean, GatewayType.CYBERSOURCE, CardType.VISA, "411111******1111");
    }

    @Test(dependsOnMethods = "buyWithCreditCardTest")
    public void getMemberPaymentInfoTest() {
        commerceApiGetMemberPayInfo(studentBean, GatewayType.CYBERSOURCE, CardType.VISA, "411111******1111");
    }

    @Test(dependsOnMethods = "getMemberPaymentInfoTest")
    public void buyWithExistingCreditCardTest() {
        studentBean.setOffer_id("195");
        commerceApiBuyWithExistingPayInfo(studentBean, SalesOrderStatus.ORDERED);
    }

    @Test(dependsOnMethods = "buyWithExistingCreditCardTest")
    public void buyWithDirectDebit() {
        //TODO
        commerceApiBuyWithDirectDebit(studentBean, SalesOrderStatus.ORDERED);
    }

    @Test(dependsOnMethods = "buyWithExistingCreditCardTest")
    public void cancelMemberTest() {
        commerceApiCancelSubscription(studentBean, 200, true);
    }

//    @Test(dependsOnMethods = "cancelSubscriptionTest")
//    public void getMemberValidateIsCanceledTest() {
//        //TODO
//        //getSubscription(studentBean, SalesOrderStatus.ORDERED);
//    }




}

