package com.englishlive.tests.emailenglishdotnet.robot;

/**
 * Created by nikol.marku on 16/02/2016.
 *
 * Open robot.txt .. 200 response received
 */
import com.englishlive.tests.basetest.htmlunit.BaseResponseCodeTest;
import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.UrlMapper;
import com.englishtown.helpers.WebClientResponseHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.containsString;


public class EeRobotTxtTest extends BaseResponseCodeTest {
    private static final Logger logger = LoggerFactory.getLogger(EeRobotTxtTest.class);
    @Value("#{applicationPropertiesList['ee.robot.txt.url']}")
    private String testUrl;
    protected String checkContent = "NOT_INIT";

    @BeforeClass
    private void setup(){
        //runTestOnHtmlUnitAndFailIfNotChrome();
        checkContent = "Allow";
        htmlUnitTestUrl = UrlMapper.mapBaseUrlToEtown(testUrl, getBASE_URL());
    }

    @Test(dependsOnMethods = "openUrl_CheckResponse200" )
    void openUrl_CheckContent() {
        WebClientResponseHelper webClientResponseHelper = new WebClientResponseHelper();
        String source = webClientResponseHelper.getWebClientResponseContent(htmlUnitTestUrl) ;     //WebClientResponseHelper.getWebClientResponseContent(htmlUnitTestUrl);
        AssertHelper.assertThat("Disallow is not present in the content ...! :"+source, source, containsString(checkContent));
    }


}
