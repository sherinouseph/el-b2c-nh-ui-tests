package com.englishtown.tests.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;

/**
 * Created by nikol.marku on 11/05/2016.
 * all test needing htmlUnit
 */
public abstract class SimpleHtmlUnitBaseTest extends SimpleBaseTest{
    private static final Logger logger = LoggerFactory.getLogger(SimpleHtmlUnitBaseTest.class);


    @AfterTest
    public void htmlUnitTearDown(){
        logger.info("tearDown AfterTest ...!");
        destroyDriver(htmlUnitDriver);
    }
}
