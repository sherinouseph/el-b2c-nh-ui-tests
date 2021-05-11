package com.englishlive.tests.newhouse.apitest.testsuite.integration.commerceapi;
/**
 *
 * Get tests for http://commerce.vagrant.f8/swagger/#/
 *
 */

import com.englishtown.dataprovider.bin.StudentBean;
import com.englishtown.newhouse.apicore.BaseSpecSuite;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CommerceApiCreateLeadTest extends BaseSpecSuite {
    public static final Logger logger = LoggerFactory.getLogger(CommerceApiCreateLeadTest.class);


    @BeforeClass
    protected void setupBeforeClass(){
        logger.info("@ Before Class ...!");
        studentBean = new StudentBean();
        studentBean.setCountry("GB");
        studentBean.setLang("EN");
        studentBean.setPtn("MKGE");
        studentBean.setEtag("goes");
        studentBean.toString();
        setupTestBeanDataAndSpec();
    }

    @Test
    void createLeadTestOE(){
        studentBean.setLeadType("oe");
        commerceApiCreateLead(studentBean);
    }

    @Test
    void createLeadTestOS(){
        studentBean.setLeadType("os");
        commerceApiCreateLead(studentBean);
    }

    @Test
    void createLeadTestCS(){
        studentBean.setLeadType("CS");
        commerceApiCreateLead(studentBean);
    }


    @Override
    public void setupTestBeanDataAndSpec() {
        // setup in test
    }

//    @AfterClass
//    protected void teardownAfterClass(){
//        logger.info("@ After Class ...!");
//        cancelSubscription(studentBean.getUserEmail());
//    }
}

