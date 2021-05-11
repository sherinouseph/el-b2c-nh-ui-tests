package com.englishtown.newhouse.apicore.commerceapi;
/**
 * Created by nikol.marku on 08-Fev-18
 * move to CommerceApiAllTest as user need to have paid
 * 0. getAccountDetails commerce api
 *
 */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;


public abstract class BaseGetAccountDetailsTest extends BaseCreateCommerceApiMember {
    public static final Logger logger = LoggerFactory.getLogger(BaseGetAccountDetailsTest.class);


    @Test(dependsOnMethods = "createUserIdTest")
    public void createCommerceApiMemberTest() {
        createCommerceApiMember();
    }

    // move to CommerceApiAllTest as user need to have paid
    /*@Test(dependsOnMethods = "createCommerceApiMemberTest")
    public void getAccountDetails() {
        //TODO Waiting fred to implement it        logger.warn("Waiting Erden logic ... student need to be an active student that has paid or  to implement it");
        getCommerceApiAccountDetails();
    }*/


}