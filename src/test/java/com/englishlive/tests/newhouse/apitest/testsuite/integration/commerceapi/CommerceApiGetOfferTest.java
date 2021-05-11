package com.englishlive.tests.newhouse.apitest.testsuite.integration.commerceapi;
/**
 *
 * Get tests for http://commerce-api.vagrant.f8/swagger/#/
 *  id=32282
 */

import com.englishtown.dataprovider.bin.StudentBean;
import com.englishtown.enumpack.Channel;
import com.englishtown.newhouse.apicore.commerceapi.BaseGetOfferTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;

//work on 10 Apr new urls
public class CommerceApiGetOfferTest extends BaseGetOfferTest {
    public static final Logger logger = LoggerFactory.getLogger(CommerceApiGetOfferTest.class);


    @BeforeClass
    protected void setupBeforeClass(){
        logger.info("@ Before Class ...!");
        cancelSubscription = false;
        studentBean = new StudentBean();
        studentBean.setCountry("GB");
        studentBean.setChannel(Channel.ONLINE.getChannel());
        studentBean.toString();
        setBaseURI(commerceApiGetOfferUrl);
        //setSpecUrl(commerceApiGetOfferUrl);

    }


}

