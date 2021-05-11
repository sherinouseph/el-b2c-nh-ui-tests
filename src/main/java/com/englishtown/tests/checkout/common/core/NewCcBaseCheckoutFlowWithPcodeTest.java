package com.englishtown.tests.checkout.common.core;
/**
 * New checkout
 * Base
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

//TODO refactor new checkout  design
public abstract class NewCcBaseCheckoutFlowWithPcodeTest extends NewBaseCheckoutFlow { //StandardCheckoutFlowTest {
    private static final Logger logger = LoggerFactory.getLogger(NewCcBaseCheckoutFlowWithPcodeTest.class);

//    @Override override on the class extending htis
//    public Map getOffer() {
//        return offer = EfConstants.OFFER_30582;
//    }

    @Test(dependsOnMethods = {"clickTab"})
    public void remove_pay_validationTest(){
        remove_PaymentValidation();
    }

    @Test(dependsOnMethods = { "remove_pay_validationTest" })
    public void testNameOnCardValueMatchesPrevStepEnteredDataTest() {
        check_NameOnCardValueMatchesPrevStepEnteredData();
    }
    //---------------------------------------  remove above refactor

    @Test(dependsOnMethods = { "testNameOnCardValueMatchesPrevStepEnteredDataTest" })
    void isOfferIdRelatedToPcodeTest(){
        logger.info(" Offer id should be :"+getOfferId()+ "- for pcode :"+getOfferPcode());
        isOfferIdRelatedToPcode("order.offer_id", getOfferId() ,true);
    }
    @Test(dependsOnMethods = { "testNameOnCardValueMatchesPrevStepEnteredDataTest" })
    void isExpectedPcodeOnStateObjectTest(){
        logger.info(" Expected PCode on order.couponCode :"+getOfferPcode());
        isExpectedPcodeOnStateObject("order.couponCode", getOfferPcode() ,true);
    }

    @Test(dependsOnMethods = { "isExpectedPcodeOnStateObjectTest" })
    public void enterPayFormData_and_submit() {
        enter_PayFormDataAndSubmit();
        try{Thread.sleep(2000);  }catch(Exception e){e.printStackTrace();}
    }

    @Test(dependsOnMethods = { "enterPayFormData_and_submit" })
    public void check_ThankyouPage(){
        checkPaymentThankyouPage();
    }

    //TODO activate this when   order.items.item_id is added to the new check out
    @Test(dependsOnMethods = { "check_ThankyouPage" })
    public void testThankyouPageStateObject(){
        assertThankyouPageStateObjectElementsNewCheckout();
    }
    @Test(dependsOnMethods = { "testThankyouPageStateObject" })
    void isOfferCurrencyPersistedTest(){
        logger.info(" isOfferCurrencyPersistedTest.... getOfferCurrency() :"+getOfferCurrency());
        isOrderCurrencyRelatedToPcodeOnTY("order.phase0.currency",getOfferCurrency(), true);
    }
    @Test(dependsOnMethods = { "testThankyouPageStateObject" })
    void isOfferPricePersistedTest(){
        logger.info(" isOfferCurrencyPersistedTest....getOfferPrice() :"+getOfferPrice());
        isOrderPriceRelatedToPcodeOnTY("order.phase0.price",getOfferPrice(), true);
    }

    @Override
    protected String getOfferPrice(){
        return this.getOffer().get("price").toString();
    }
    @Override
    protected String getOfferCurrency(){
        return this.getOffer().get("currency").toString();
    }
    @Override
    protected String getOfferPcode(){
        return this.getOffer().get("pcode").toString();
    }
    @Override
    protected String getOfferId(){
        return this.getOffer().get("offerId").toString();
    }
}
