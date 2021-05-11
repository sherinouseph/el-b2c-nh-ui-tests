package com.englishtown.newhouse.apicore.commerce;
/**
 * Created by nikol.marku on 06-Dec-17.
 *
 * 0. Create commerce member

 */

import com.englishtown.newhouse.apicore.BaseCreateUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;


public abstract class BaseCreateCommerceMember extends BaseCreateUser {
    public static final Logger logger = LoggerFactory.getLogger(BaseCreateCommerceMember.class);


    @Test(dependsOnMethods = "createUserIdTest")
    public void createCommerceMemberTest() {
        createCommerceMember();
    }


}