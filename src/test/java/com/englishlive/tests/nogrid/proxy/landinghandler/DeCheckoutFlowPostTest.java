package com.englishlive.tests.nogrid.proxy.landinghandler;
/**
 *
 */
import com.englishlive.tests.nogrid.proxy.BaseCreateMemberPostDataTest;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.bean.handler.BuyWithCreditCardPostBean;
import com.englishtown.helpers.bean.handler.EfFullDataBean;
import com.englishtown.helpers.reader.MyJsonReader;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.tests.core.EfConstants;
import com.englishtown.tests.core.SharedSelectors;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

// Member form Form is not submitting on jbrowser
public class DeCheckoutFlowPostTest extends BaseCreateMemberPostDataTest {
    private static final Logger logger = LoggerFactory.getLogger(DeCheckoutFlowPostTest.class);
    @Value("#{applicationPropertiesList['new.checkout.member.de.de.url']}")
    protected String currTestUrl;


    @BeforeClass
    public void setupTestDataOpenUrl(){
        testURL = currTestUrl;
        isShowBrowserGui = false;
        isDebug = false;
        setupProxyAndDriver();   //setupChromeWithProxyDriver(testURL); //setupJBorwserProxyDriver(testURL); setUpProxy();
        //driver = ThreadSafeProxy.getWebDriver(); // driver = ThreadSafeProxy.getWebDriver();
        //proxyServer.newHar();

        creditCardLinkText="Kreditkarte";
        testDataMap =  EfConstants.ukMembersFormMap_new;
        userName = getEmail(); //testDataMap.get("email");
        expectedPostData = new EfFullDataBean();
        expectedPostData = MyJsonReader.getEfFullDataBeanFromJsonFile( MyJsonReader.getJasonTestFilePath(
                                                                         MyJsonReader.efBeanCreateMemberJsonFilename));
        expectedPostData.setEmail(userName);
        buyWithCreditExpectedPostBean = new BuyWithCreditCardPostBean("4222222222222222","4", "2021", "1234", "de","dynamic");


        harFilter = "membermanager/create";
        logger.info("expectedPostData : "+expectedPostData.toString());

        isCreateMemberHandler = true;
        isWaitForTyUrl = true;
        isInlineTyMsg = false;
        isEnterPhoneNumber = false;
        submitBtnCss = "#form_button";
        waitForUrlContains = "default/payment";

        TestUtil.openUrl(driver, currTestUrl);
        WaitTool.waitForElementClickable(driver, By.cssSelector(SharedSelectors.MEMBERPAGE_SUBMIT_BTN_CSS), 5);
        sleep(3000);
        setCountryAndLanguage("de","ge");
    }

    @AfterClass
    public void destroyDriverAndProxy(){
        //destroyDriverAndProxyServer();
        stopProxy();
        stopDriver();
    }

}