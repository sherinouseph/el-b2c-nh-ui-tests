package com.englishtown.tests.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;

/**
 * Created by nikol.marku on 11/05/2016.
 * all test needing chrome
 */
public class SimpleChromeBaseTest extends SimpleBaseTest{
    private static final Logger logger = LoggerFactory.getLogger(SimpleChromeBaseTest.class);

    @AfterTest
    public void chromeBaseTearDown(){
        logger.info("tearDown AfterTest ...!");
        destroyDriver(chrome);
    }

}
