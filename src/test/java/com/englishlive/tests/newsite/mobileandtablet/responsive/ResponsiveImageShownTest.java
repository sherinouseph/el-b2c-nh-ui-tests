package com.englishlive.tests.newsite.mobileandtablet.responsive;
/**
 * Created by nikol.marku on 24/03/2016.
 *
 * OPen test page
 *
 * https://jira-bos.englishtown.com/browse/SAND-2876
 *
 *
 * Mobile only
 *
 */
import com.englishlive.tests.responsive.image.core.BaseResponsiveImageShownTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class ResponsiveImageShownTest extends BaseResponsiveImageShownTest {
    private static final Logger logger = LoggerFactory.getLogger(ResponsiveImageShownTest.class);

    protected static String testImgCss = ".adaptiveimage img.img-responsive";


    @BeforeClass
    public void setup() {
        setThreadSafeDriver();
        testUrl = getBASEURL()+testUrl;
        this.openUrl(getWebDriver(), testUrl, -1);
        sleep(3000);
    }

    @AfterClass
    protected void destroyDriverAfterClass(){
        destroyDriver();
    }

}
