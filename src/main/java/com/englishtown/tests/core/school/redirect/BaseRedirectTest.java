package com.englishtown.tests.core.school.redirect;
/**
 * Nikol 2018
 * Open URL check redirect url
 *
 *
 */

import com.englishtown.dataprovider.bin.UrlRedirectBean;
import com.englishtown.tests.core.BaseTestHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public abstract class BaseRedirectTest extends BaseTestHelper {
    private static final Logger logger = LoggerFactory.getLogger(BaseRedirectTest.class);


    protected UrlRedirectBean urlRedirectBean;


    @Test
    public void openUrlCheckRedirectTest() throws Exception{
        try {
            openUrlCheckIsRedirected(getWebDriver(), getBASEURL(), urlRedirectBean, 25);
        }catch (Exception e){
            failTest("Exception : "+e.getMessage());
        }

    }

}