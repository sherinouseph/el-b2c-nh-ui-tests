package com.englishlive.tests.newhouse.apitest.amdmodule;
/**
 *
 * Nikol Dec 2018
 *
 */

import com.englishtown.newhouse.apicore.amdmodule.BaseAmdModuleSpecSuite;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class AmdModuleTest extends BaseAmdModuleSpecSuite {
    public static final Logger logger = LoggerFactory.getLogger(AmdModuleTest.class);


    @BeforeClass
    protected void setupBeforeClass(){
        if(StringUtils.contains(getENVIRONMENT(), "qa")){
            failTest("Live only test ...!");
        }
    }

    @Test
    public void getModuleCommitTextSpec() {
        getSpecCommitTextHashTag();
    }

    @Test(dependsOnMethods = "getModuleCommitTextSpec")
    public void getBundleCodeTest() {
        getSpecBundleCode();
    }

    @Override
    public void setupTestBeanDataAndSpec() {    }

}


/**
 //AssertHelper.assertThat("Not the expected response ...!", response.asString(), containsIgnoringCase("1|test|est|test"));
 //AssertHelper.assertThat("Not the expected response ...!", response.asString(), containsIgnoringCase("0|"));
 **/