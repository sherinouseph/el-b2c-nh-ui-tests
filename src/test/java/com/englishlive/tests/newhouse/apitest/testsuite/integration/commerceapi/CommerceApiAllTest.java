package com.englishlive.tests.newhouse.apitest.testsuite.integration.commerceapi;
/**
 *
 *
 *
 */

import com.englishtown.dataprovider.bin.StudentBean;
import com.englishtown.enumpack.Channel;
import com.englishtown.enumpack.TestCard;
import com.englishtown.newhouse.apicore.commerceapi.BaseCommerceApiAllTest;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class CommerceApiAllTest extends BaseCommerceApiAllTest {
    public static final Logger logger = LoggerFactory.getLogger(CommerceApiAllTest.class);


    @BeforeClass
    protected void setupBeforeClass(){
        logger.info("@ Before Class ...!");
        studentBean = new StudentBean();
        studentBean.setCountry("TR");
        studentBean.setLang("TR");
        studentBean.setOffer_id(BUY_CC_OFFER_ID); //("2006"); //("32282");
        studentBean.setChannel(Channel.ONLINE.getChannel());
        logger.info(" Sudent Bean [{}]", studentBean.toString());
        logger.info(" Sudent Bean [{}]", studentBean.toString());

        testCard = TestCard.VISA_QA;
        //
        if(StringUtils.equals("live", getENVIRONMENT())) {
            REDEMPTION_CODE = "20ca1e25ed8f4d33876eb6439f7e74a6"; //Live : SYSONLY-FROS47F08B45
        }
        setupTestBeanDataAndSpec();
    }


    @AfterClass
    protected void teardownAfterClass(){
        logger.info("@ After Class ...!");
    }


}

