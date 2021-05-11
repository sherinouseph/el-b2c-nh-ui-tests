package com.englishtown.newhouse.apicore.commerce;
/**
 *
 *
 *  id=32282
 */

import com.englishtown.dataprovider.bin.StudentBean;
import com.englishtown.enumpack.OfferType;
import com.englishtown.newhouse.apicore.BaseCreateUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public abstract class BaseCommerceGetOfferAndValidate extends BaseCreateUser{
    public static final Logger logger = LoggerFactory.getLogger(BaseCommerceGetOfferAndValidate.class);



    @Test(dependsOnMethods = "createUserIdTest" )
    public void getOfferTest(){
        commerceGetOffer();
    }

    @Test(dependsOnMethods ="getOfferTest" )
    public void validateOfferCommerceServices(){
        commerceValidateOfferUrl = commerceBaseUrl+"offer/"+studentBean.getOffer_id()+"/validate?EFId="+studentBean.getUser_id()+"&offerType="+OfferType.SUBSCRIPTION;
        validateOfferCommerceServices(commerceValidateOfferUrl, studentBean.getUser_id(), studentBean.getOffer_id(), OfferType.SUBSCRIPTION );
    }

    @Override
    public void setupTestBeanDataAndSpec() {
    }


}

