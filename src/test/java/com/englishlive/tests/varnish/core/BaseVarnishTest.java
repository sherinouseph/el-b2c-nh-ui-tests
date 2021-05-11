package com.englishlive.tests.varnish.core;
/**
 * Created by nikol.marku on 16/06/2016.
 * https://jira-bos.englishtown.com/browse/SAND-3018
 *  checks strings and response code 200
 */

import com.englishlive.tests.basetest.htmlunit.BaseResponseCodeTest;
import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.pages.varnish.VarnishHelthCheckPage;
import com.englishtown.tests.core.BaseTestHelper;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.containsString;


public abstract class BaseVarnishTest extends BaseResponseCodeTest implements IVarnishHelth {
    private static final Logger logger = LoggerFactory.getLogger(BaseVarnishTest.class);

    @Value("#{applicationPropertiesList['varnish.helth.etb2cv1']}")
    public String etb2cv1Url;
    @Value("#{applicationPropertiesList['varnish.helth.etb2cv2']}")
    public String etb2cv2Url;         // test script = "file:///C:/Temp/varnishTest.html";
    protected VarnishHelthCheckPage varnishHelthCheckPage;
    protected String scriptServer; // = "usb-etb2cv1"; // test init this


    @Test (dependsOnMethods = "openUrl_CheckResponse200")
    public void isVarnishHealthPage() {
        varnishHelthCheckPage.simpleTest();
        varnishHelthCheckPage.setHelthCheckPageSource(getLocalThreadDriver().getPageSource());
        logger.info("Page Source code :\n"+varnishHelthCheckPage.getHelthCheckPageSource());
                                                                                                                        // AssertHelper.assertThat("Can't get Page source code to perform the tests ...!", varnishHelthCheckPage.getHelthCheckPageSource(), isEmptyOrNullString());
        if(StringUtils.isEmpty(varnishHelthCheckPage.getHelthCheckPageSource()) ){
            BaseTestHelper.failTest("Can't get Page source code [nul or empty] to perform the tests ...!");
        }
    }

    @Test (dependsOnMethods = "isVarnishHealthPage")
    public void isOverallHealthOk() {
        AssertHelper.assertThat("isOverallHealthOk Varnish Overall Check is NOT OK ...!",
                TestUtil.getWebElementText(varnishHelthCheckPage.varnishCheckValuesList.get(0)), containsString(OVERALL_HELTH));                //varnishHelthCheckPage.getHelthCheckPageSource(), containsString(OVERALL_HELTH));
        logger.info("Overall Health:Ok ...!");
    }

    @Test (dependsOnMethods = "isVarnishHealthPage")
    public void isActiveNodeOk() {
         AssertHelper.assertThat("isActiveNodeOk is NOT OK ...!",
                 TestUtil.getWebElementText(varnishHelthCheckPage.varnishCheckValuesList.get(1)), containsString(ACTIVE_NODE));
        logger.info("Active Node:Ok ...!");
    }

    @Test (dependsOnMethods = "isVarnishHealthPage")
    public void isPassiveNodeOk() {
        AssertHelper.assertThat("isPassiveNode IS NOT OK ...!",
                TestUtil.getWebElementText(varnishHelthCheckPage.varnishCheckValuesList.get(2)), containsString(PASSIVE_NODE));
        logger.info("Passive Node:Ok ...!");
    }

    @Test (dependsOnMethods = "isVarnishHealthPage")
    public void isVarnishClusterPeerOk() {
        AssertHelper.assertThat("isVarnishClusterPeer is NOT OK ...!",
                TestUtil.getWebElementText(varnishHelthCheckPage.varnishCheckValuesList.get(3)), containsString(VARNISH_CLASTER));
        logger.info("Varnish Cluster Peer:Ok ...!");
    }

    @Test (dependsOnMethods = "isVarnishHealthPage")
    public void isCachingOk() {
        AssertHelper.assertThat(" isCachinG is NOT OK ...!",
                TestUtil.getWebElementText(varnishHelthCheckPage.varnishCheckValuesList.get(4)), containsString(CASHING));
        logger.info("Caching:Ok ...!");
    }

//  moved to AWS and url has ip now
//    @Test (dependsOnMethods = "isVarnishHealthPage")
//    public void isScriptServerTheSameAsTheOneOnURL() {
//        AssertHelper.assertThat("isScriptServerTheSameAsTheOneOnURL is NOT OK ...!",
//                TestUtil.getWebElementText(varnishHelthCheckPage.varnishCheckValuesList.get(6)), containsString("Script: "+scriptServer));
//        logger.info("Script:["+scriptServer+"] same as the one on the URL open OK...!");
//    }


//    @Test (dependsOnMethods = "isVarnishHealthPage", priority = 20)
//    public void isScriptVersionTheSameOnBothVarnishServers() {
//        String currentScriptVersion = TestUtil.getWebElementText(varnishHelthCheckPage.varnishCheckValuesList.get(7));
//        logger.info("currentScriptVersion :"+currentScriptVersion);
//        openUrl(getLocalThreadDriver(),getOtherVarnishServerUrl(htmlUnitTestUrl) );
//        sleep(3000);
//        VarnishHelthCheckPage otherVarnishHelthCheckPage = new VarnishHelthCheckPage(getLocalThreadDriver());
//        String otherScriptServer =TestUtil.getWebElementText(varnishHelthCheckPage.varnishCheckValuesList.get(7));
//        logger.info("otherScriptServer :"+otherScriptServer);
//
//        AssertHelper.assertThat("Varnish Servers are not running same Script Version ...!",
//                otherScriptServer, containsString(currentScriptVersion));
//        logger.info("Scripts are the same Version ...! currentScriptVersion ["+currentScriptVersion+"] and otherScriptServer ["+otherScriptServer+"] ...!");
//    }


    //
    //HELPER
    //
    protected String getOtherVarnishServerUrl(String url){
        if(StringUtils.contains(url, "etb2cv1")) {
            return etb2cv2Url;
        }else {
            return etb2cv1Url;
        }
    }


}




//***************************
//    String currentScriptServer = varnishHelthCheckPage.scriptServer.getText();
//AssertHelper.assertThat("Varnish Server is not the same as the one stated on URL  ...!",
//        varnishTestUrl, containsString(currentScriptServer));