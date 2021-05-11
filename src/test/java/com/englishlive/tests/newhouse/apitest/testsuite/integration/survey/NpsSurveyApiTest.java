package com.englishlive.tests.newhouse.apitest.testsuite.integration.survey;//package com.englishlive.tests.newhouse.apitest;
/***
 * Nikol Nov 2018
 * Enroll users ... use api calls to create account, user and enroll
 */

import com.englishlive.tests.newhouse.apitest.testsuite.integration.commerceapi.CommerceApiAllTest;
import com.englishtown.dataprovider.bin.StudentBean;
import com.englishtown.enumpack.Channel;
import com.englishtown.enumpack.TestCard;
import com.englishtown.newhouse.apicore.survey.BaseSurveyApiTest;
import com.englishtown.newhouse.school.beanandenum.enums.Enroll;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class NpsSurveyApiTest extends BaseSurveyApiTest {
    public static final Logger logger = LoggerFactory.getLogger(CommerceApiAllTest.class);
    protected String loginUrl = "https://qa-englishlive.ef.com/tr-tr/login";


    @BeforeClass
    protected void setupBeforeClass(){
        logger.info("@ Before Class ...!");
        studentBean = new StudentBean();
        studentBean.setCountry("tr");
        studentBean.setLang("tr");
        studentBean.setEnroll(Enroll.INTERMEDIATE);
        studentBean.setOffer_id("2006"); //("32282");
        studentBean.setChannel(Channel.ONLINE.getChannel());
        logger.info(" Sudent Bean [{}]", studentBean.toString());
        testCard = TestCard.VISA_QA;
    }


    @AfterClass
    protected void teardownAfterClass(){
        logger.info("@ After Class ...!");
    }


    @Override
    public void setupTestBeanDataAndSpec() {

    }

   //nikol.qa.12345@qp1.org

}


    /*@Test
    void enroll(){
        if(! StringUtils.containsIgnoreCase(getBASE_PROFILE_URL(), "qa"))
            BaseTest.failTest("This test should run only QA ...!");

        StudentBean studentBean = new StudentBean();
        studentBean.setCountry("tr");
        studentBean.setLang("tr");
        studentBean.setEnroll(Enroll.INTERMEDIATE);
        BaseApiSpec.createUserWithEnroll("qa", studentBean, loginUrl);
        BaseApiSpec.getAllUserDataResponse(studentBean.getUserEmail(), 200, "qa");
    }

    // https://qa-englishlive.ef.com/1/api/student-settings/v1/student/settings/notifications
    @Test
    void getUserNotification(){

    }*/
