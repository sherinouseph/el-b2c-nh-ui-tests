package com.englishlive.tests.newhouse.school.classroom;
/**
 *
 *
 *  User: sherin ouseph
 * Date: 21/10/2020
 *
 *
 */

import com.englishtown.tests.core.school.classroom.BaseBookPLAndCancelEFTVTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class BookCancelEFTVTest extends BaseBookPLAndCancelEFTVTest {
    private static final Logger logger = LoggerFactory.getLogger(BookCancelEFTVTest.class);

    @Value("#{applicationPropertiesList['user.bookcanceleftv']}")
    protected String testUsername;


    @BeforeClass
    protected void setup(){
        setThreadSafeDriver();
        testStartUrl = getBASEURL();
        username = testUsername;
        isPLWithin24hrs=false;
        openUrl(getWebDriver(), testStartUrl);
    }


    @AfterClass
    protected void testAfterClass(){
        destroyDriver();
    }

}
