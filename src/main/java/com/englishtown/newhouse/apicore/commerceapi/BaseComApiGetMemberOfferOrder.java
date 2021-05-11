//package com.englishtown.newhouse.apicore.commerceapi;
///**
// *
// * Get tests for http://commerce.vagrant.f8/swagger/#/
// * Test will:
// * 1. create commerce member and buy/purchase
// * 2. call api to get member info
// * 3. call api to get offer info
// * 4. call api to get order info
// *
// * check response data
// */
//
//import com.englishtown.newhouse.apicore.commerce.BaseCommercePurchaseSpec;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.testng.annotations.Test;
//// need a new one to use commerceapi
//
//public abstract  class BaseComApiGetMemberOfferOrder extends BaseCommercePurchaseSpec {
//    public static final Logger logger = LoggerFactory.getLogger(BaseComApiGetMemberOfferOrder.class);
//
//
//    @Test(dependsOnMethods = "commercePurchaseTest")
//    public void getCommerceMemberTest() {
//        resultHasCancellationReason = false;
//        commerceGetMember();
//    }
//
//    @Test(dependsOnMethods = "getCommerceMemberTest")
//    public void getOfferTest() {
//        commerceGetOffer();
//    }
//
//    @Test(dependsOnMethods = "commercePurchaseTest")
//    public void getOrderTest() {
//        commerceGetOrder(commerceGetOrderUrl);
//    }
//
//
//}
//
