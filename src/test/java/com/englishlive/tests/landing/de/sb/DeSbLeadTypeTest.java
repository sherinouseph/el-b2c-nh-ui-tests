package com.englishlive.tests.landing.de.sb;
/**
 *
 *
 */
import com.englishtown.tests.core.EfConstants;
import com.englishtown.tests.core.landingpages.BaseSbLeadTypeTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class DeSbLeadTypeTest extends BaseSbLeadTypeTest {
    private static final Logger logger = LoggerFactory.getLogger(DeSbLeadTypeTest.class);

    @Value("#{applicationPropertiesList['de.sb.url']}")
    private String testURL;


    @BeforeClass
    protected void setup(){
        setThreadSafeDriver();
        formDataMap = EfConstants.DE_SB_MAP;
        urlContainsThankyou = "thankyou-sb";
        //submitBtn = ".formFooter .btn";
        openUrl(getWebDriver(), testURL);
    }

    @AfterClass
    protected void testAfterClass(){
        destroyDriver();
    }


}
