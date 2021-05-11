package com.englishlive.tests.varnish;
/**
 *
 */


import com.englishlive.tests.varnish.core.BaseVarnishTest;
import com.englishlive.tests.varnish.core.IVarnishHelth;
import com.englishtown.driver.BaseRemoteWebDriver;
import com.englishtown.pages.varnish.VarnishHelthCheckPage;
import com.englishtown.tests.core.BaseTestHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;


public class VarnishHealthEtb2cv2Test extends BaseVarnishTest{
    private static final Logger logger = LoggerFactory.getLogger(VarnishHealthEtb2cv2Test.class);


    @BeforeClass
    void setupOpenUrl(){
        runTestOnThisEnvironmentOnly("live", "This test is only for live environment ...!");
        scriptServer = "10.162.66.103";
        htmlUnitTestUrl = etb2cv2Url;
        setUpHtmlUnitDriver();
        failTestIfIsNotBrowser(getBrowserName(), CHROME_HTMLUNIT_BROWSER_LIST, "Chrome Only Test ....!");
        openUrl(getLocalThreadDriver(), htmlUnitTestUrl);
        sleep(3000);
        varnishHelthCheckPage = new VarnishHelthCheckPage(getLocalThreadDriver());
    }


}