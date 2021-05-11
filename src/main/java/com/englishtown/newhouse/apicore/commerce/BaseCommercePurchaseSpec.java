package com.englishtown.newhouse.apicore.commerce;
/**
 * Created by nikol.marku on 06-Dec-17.
 *
 * 1. Purchase offer
 */

import com.englishtown.newhouse.apicore.BaseCreateUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;


public abstract class BaseCommercePurchaseSpec extends BaseCreateCommerceMember {
    public static final Logger logger = LoggerFactory.getLogger(BaseCommercePurchaseSpec.class);

    @Test(dependsOnMethods = "createCommerceMemberTest")
    public void commercePurchaseTest() {
        commercePurchase();
    }



}