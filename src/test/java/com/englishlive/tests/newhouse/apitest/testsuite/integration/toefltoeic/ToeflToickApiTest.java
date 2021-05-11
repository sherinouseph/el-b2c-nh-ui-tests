package com.englishlive.tests.newhouse.apitest.testsuite.integration.toefltoeic;
/**
 *
 * Nikol Nov 2018
 *
 * Positive and negative test
 * 
 * Run only QA
 *
 * Call validate API for old house user and new house user
 *
 */

import com.englishtown.newhouse.apicore.toefltoeic.BaseToeflToeicSpecSuite;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class ToeflToickApiTest extends BaseToeflToeicSpecSuite {
    public static final Logger logger = LoggerFactory.getLogger(ToeflToickApiTest.class);

    String QA_TR_USER = "api_newhouse_toeiftoeic@qp1.org";  // passpass
    String QA_TR_USER_EFID = "7fc382da-6476-4326-b85e-75d6e459e473";  // passpass

    @BeforeClass
    protected void setupBeforeClass(){
        if(StringUtils.contains(getENVIRONMENT(), "live")){
            failTest("Only QA test ...!");
        }

    }

    @Test
    public void getExistingUserOldHousePositiveTest() {
        toefltoeicValidate("test", false, "1|test|est|test");
    }

    @Test
    public void getNonExistingUserOldHousePositiveTest() {
        toefltoeicValidate("nonexistinguser", false, "0|");
    }

    @Test
    public void getExistingUserNewHousePositiveTest() {
        toefltoeicValidate(QA_TR_USER_EFID+"@efid", false, "1|"+QA_TR_USER_EFID+ "|AutoLastName|testing");
    }

    @Test
    public void getNonExistingUserNewHousePositiveTest() {
        toefltoeicValidate("7fc382da-6476-4326-b85e-75dnonexit" + "@efid", false, "0|");
    }

    @Override
    public void setupTestBeanDataAndSpec() {

    }

}


/**
 //AssertHelper.assertThat("Not the expected response ...!", response.asString(), containsIgnoringCase("1|test|est|test"));
 //AssertHelper.assertThat("Not the expected response ...!", response.asString(), containsIgnoringCase("0|"));
 **/