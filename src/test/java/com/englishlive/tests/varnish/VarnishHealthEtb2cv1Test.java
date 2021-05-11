package com.englishlive.tests.varnish;
/**
 *
 */


import com.englishlive.tests.varnish.core.BaseVarnishTest;
import com.englishlive.tests.varnish.core.IVarnishHelth;
import com.englishtown.driver.BaseRemoteWebDriver;
import com.englishtown.pages.varnish.VarnishHelthCheckPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;


public class VarnishHealthEtb2cv1Test extends BaseVarnishTest{
    private static final Logger logger = LoggerFactory.getLogger(VarnishHealthEtb2cv1Test.class);


    @BeforeClass
    void setupOpenUrl(){
        runTestOnThisEnvironmentOnly("live", "This test is only for live environment ...!");
        scriptServer = "10.162.82.103"; //"usb-etb2cv1";
        htmlUnitTestUrl = etb2cv1Url;
        setUpHtmlUnitDriver();
        failTestIfIsNotBrowser(getBrowserName(), CHROME_HTMLUNIT_BROWSER_LIST, "Chrome Only Test ....!");
        openUrl(getLocalThreadDriver(), htmlUnitTestUrl);
        sleep(3000);
        varnishHelthCheckPage = new VarnishHelthCheckPage(getLocalThreadDriver());
    }


}