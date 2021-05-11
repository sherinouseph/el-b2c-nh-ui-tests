package com.englishtown.newhouse.apicore.commerceapi;
/**
 * Created by nikol.marku on 06-Dec-17.
 *
 * 0. Create commerce member

 */

import com.englishtown.dataprovider.bin.StudentBean;
import com.englishtown.enumpack.CardType;
import com.englishtown.enumpack.GatewayType;
import com.englishtown.newhouse.apicore.BaseCreateUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;


public abstract class BaseCreateCommerceApiMember extends BaseCreateUser {
    public static final Logger logger = LoggerFactory.getLogger(BaseCreateCommerceApiMember.class);


    @Test(dependsOnMethods = "createUserIdTest")
    public void createCommerceApiMemberTest() {
        createCommerceApiMember();
    }



}