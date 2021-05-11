package com.englishtown.newhouse.apicore.commerceapi;
/**
 *
 * Commerce.API
 *
 */
import com.englishtown.enumpack.OfferType;
import com.englishtown.newhouse.apicore.BaseCreateUser;
import com.englishtown.newhouse.apicore.BaseSpecSuite;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;


public abstract class BaseGetOfferTest extends BaseCreateUser {//} BaseSpecSuite {
    public static final Logger logger = LoggerFactory.getLogger(BaseGetOfferTest.class);


    @Test (dependsOnMethods = "createUserIdTest" )
    public void testGetOfferResponseContent(){
        getOfferCommerceApi(commerceApiGetOfferUrl);
    }

    /* this need a student
    @Test(dependsOnMethods ="createUserIdTest" )
    public void testValidateOffer(){
        // 404 error
        validateOfferCommerceApi(studentBean.getUser_id(), studentBean.getOffer_id(), OfferType.SUBSCRIPTION);
    }*/

    @Override
    public void setupTestBeanDataAndSpec() {
    }

}

