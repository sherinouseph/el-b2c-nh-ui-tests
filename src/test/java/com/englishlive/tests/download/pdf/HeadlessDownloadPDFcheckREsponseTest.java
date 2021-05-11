package com.englishlive.tests.download.pdf;
/**
 * open url click to
 * Download pdf file directly and check  page and response = 200;
 *
 */

import com.englishlive.tests.basetest.htmlunit.BaseResponseCodeTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.BeforeClass;

// ff only test
public class HeadlessDownloadPDFcheckREsponseTest extends BaseResponseCodeTest {
    private static final Logger logger = LoggerFactory.getLogger(HeadlessDownloadPDFcheckREsponseTest.class);
    @Value("#{applicationPropertiesList['gb.pdf.url']}")
    private String testUrl;


    @BeforeClass
    private void setup() {
        setUpHtmlUnitDriver(); //runTestOnHtmlUnitAndFailIfNotChrome();
        if(getENVIRONMENT().contains("qa")){
            testUrl = testUrl.replace("et2.ef", "qa-et.ef");
        }//else {           BasePage.failTest("Test is set to fail if not QA or live environment ...! Current URL :"+testUrl);    }
        htmlUnitTestUrl = testUrl;

    }


}