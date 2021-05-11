package com.englishtown.tests.checkout.common.core;
/**
 * New checkout
 * Base
 */

import com.englishtown.tests.core.EfConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.util.Map;

public abstract class NewCcBaseCheckoutChangePcodeOnPayPage extends NewBaseCheckoutFlow{ //StandardCheckoutFlowTest {
    private static final Logger logger = LoggerFactory.getLogger(NewCcBaseCheckoutChangePcodeOnPayPage.class);
   // Map newOffer = EfConstants.OFFER_30345;

    @Override
    public Map getOffer() {
        return offer = EfConstants.OFFER_30582;
    }
    public void setOffer(Map offer) {
        this.offer =offer;
    }

//    @Test
//    public void openMembers_page_enterDetailsTest(){
//        init_MembersPageAndEnterDetails(this.formDataMap);
//         try{Thread.sleep(1000);  }catch(Exception e){e.printStackTrace();}
//    }
//
//    @Test(dependsOnMethods = { "openMembers_page_enterDetailsTest"})
//    public void submit_members_formTest(){
//        submit_MembersForm();
//        try{Thread.sleep(3000);  }catch(Exception e){e.printStackTrace();}
//    }

    @Test(dependsOnMethods ={"clickTab"}) // { "submit_members_formTest"})
    public void openPaymentPageWithNewPcode(){
        this.getWebDriver().get(getPaymentPageUrl());
        try{Thread.sleep(3000);  }catch(Exception e){};
    }

    @Test(dependsOnMethods = { "openPaymentPageWithNewPcode"})
    public void remove_pay_validationTest(){
        remove_PaymentValidation();
    }

    @Test(dependsOnMethods = { "remove_pay_validationTest" })
    public void testNameOnCardValueMatchesPrevStepEnteredDataTest() {
        setOffer(EfConstants.OFFER_30345);
        check_NameOnCardValueMatchesPrevStepEnteredData();
    }

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
        return this.offer.get("price").toString();
    }
    @Override
    protected String getOfferCurrency(){
        return this.offer.get("currency").toString();
    }
    @Override
    protected String getOfferPcode(){
        return this.offer.get("pcode").toString();
    }
    @Override
    protected String getOfferId(){
        return this.offer.get("offerId").toString();
    }




}
