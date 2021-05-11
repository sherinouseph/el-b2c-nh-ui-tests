package com.englishtown.tests.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;

/**
 * Created by nikol.marku on 11/05/2016.
 * all test needing myDriver ... local driver used statically
 */
public class SimpleLocalMyDriverBaseTest extends SimpleBaseTest{
    private static final Logger logger = LoggerFactory.getLogger(SimpleLocalMyDriverBaseTest.class);

    @AfterTest
    public void myWebDriverTearDown(){
        logger.info("tearDown AfterTest ...!");
        destroyDriver(myWebDriver);
    }

}
