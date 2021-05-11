package com.englishlive.tests.newhouse.apitest.testsuite.integration.enroll;//package com.englishlive.tests.newhouse.apitest;
/***
 * Nikol Nov 2018
 * Enroll users ... use api calls to create account, user and enroll
 *
 * TS SF no, try [order.channel = 'Telesales']
 * no, try [order.channel = 'Telesales']
 */

import com.englishlive.tests.newhouse.apitest.testsuite.integration.commerceapi.CommerceApiAllTest;
import com.englishtown.dataprovider.bin.StudentBean;
import com.englishtown.newhouse.apicore.BaseApiSpec;
import com.englishtown.newhouse.apicore.StaticBaseApiSpec;
import com.englishtown.newhouse.school.beanandenum.enums.Enroll;
import com.englishtown.tests.core.BaseTest;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class TrEnrollApiTest extends BaseApiSpec{
    public static final Logger logger = LoggerFactory.getLogger(CommerceApiAllTest.class);
    protected String loginUrl = "https://qa-englishlive.ef.com/tr-tr/login";


    @BeforeClass
    protected void setupBeforeClass(){
        logger.info("@ Before Class ...!");
    }


    @AfterClass
    protected void teardownAfterClass(){
        logger.info("@ After Class ...!");
    }

    @Test
    void enroll(){
        if(! StringUtils.containsIgnoreCase(getBASE_PROFILE_URL(), "qa"))
            BaseTest.failTest("This test should run only QA ...!");

        StudentBean studentBean = new StudentBean();
        studentBean.setCountry("tr");
        studentBean.setLang("tr");
        studentBean.setEnroll(Enroll.INTERMEDIATE);
        StaticBaseApiSpec.createUserWithEnroll("qa", studentBean, loginUrl);
        StaticBaseApiSpec.getAllUserDataResponse(studentBean.getUserEmail(), 200, "qa");
    }

    @Override
    public void setupTestBeanDataAndSpec() {

    }

//nikol.qa.12345@qp1.org

}


