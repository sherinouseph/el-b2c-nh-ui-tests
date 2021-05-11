package com.englishlive.tests.download.pdf.br;
/**
 * open url click to
 * Download pdf file directly and check  page and response = 200;
 *
 */

import com.englishlive.tests.basetest.htmlunit.BaseResponseCodeTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

// ff only test
public class BrELiveHeadlessDownloadPDFcheckREsponseTest extends BaseResponseCodeTest {
    private static final Logger logger = LoggerFactory.getLogger(BrELiveHeadlessDownloadPDFcheckREsponseTest.class);
    @Value("#{applicationPropertiesList['br.elive.fc.pdf.url']}")
    private String testUrl;
    //http://et.ef-cdn.com/pt-br/lp/fc/pdf-oct16-p058
    // "http://www.englishtown.com.br/dam/englishtown/master/salespages/pdf-downloads/br/freecontent/br-guia-ef-englishtown-partes-do-corpo.pdf"

    @BeforeClass
    private void setup() {
        logger.warn("This will work once Brazil moves to ELive ...!");
        //setUpHtmlUnitDriver();
        if(getENVIRONMENT().contains("qa")){
            testUrl = testUrl.replace("et2.ef", "qa-et.ef");
        }//else {           BasePage.failTest("Test is set to fail if not QA or live environment ...! Current URL :"+testUrl);    }
        htmlUnitTestUrl = testUrl;

    }


}