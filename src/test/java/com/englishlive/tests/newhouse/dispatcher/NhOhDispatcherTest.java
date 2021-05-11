package com.englishlive.tests.newhouse.dispatcher;
/**
 *
 * User: nikol.marku
 * Date: 05/08/19
 *
 * Open url
 * check response contains expected result ... e.g "result":"LoginNH" /Reregister/ LoginOH  / NotExist
 *
 *
 * New house active
 * https://qa-englishlive.ef.com/checkout/house-login-dispatcher-v2.ashx?email=auto_143237518577000_zqk792_xdelx@qp1.org
 * {"statusCode":200,"existsInOldHouse":false,"existsInNewHouse":true,"isActiveInOldHouse":false,"isActiveInNewHouse":true,"hint":"NH active sub","result":"LoginNH"}
 *
 * New house inactive
 * https://qa-englishlive.ef.com/checkout/house-login-dispatcher-v2.ashx?email=auto_gb_1682397015430000_pho136_xdelx@qp1.org
 *{"statusCode":200,"existsInOldHouse":false,"existsInNewHouse":true,"isActiveInOldHouse":false,"isActiveInNewHouse":false,"hint":"NH inactive OH not exist","result":"Reregister"}
 *
 * Old house active
 * https://qa-englishlive.ef.com/checkout/house-login-dispatcher-v2.ashx?email=auto_gb_142841845432600_WII348_xdelx@qp1.org
 *{"statusCode":200,"existsInOldHouse":true,"existsInNewHouse":false,"isActiveInOldHouse":true,"isActiveInNewHouse":false,"hint":"OH active sub, Pure OH account","result":"LoginOH"}
 *
 * Old house inactive
 * https://qa-englishlive.ef.com/checkout/house-login-dispatcher-v2.ashx?email=auto_de_6003401649208800_KMD586_xdelx@qp1.org
 *{"statusCode":200,"existsInOldHouse":true,"existsInNewHouse":false,"isActiveInOldHouse":false,"isActiveInNewHouse":false,"hint":"Pure OH account","result":"LoginOH"}
 *
 * Both house, active in old
 * https://qa-englishlive.ef.com/checkout/house-login-dispatcher-v2.ashx?email=molly-olly-bolly@qp1.org
 *{"statusCode":200,"existsInOldHouse":true,"existsInNewHouse":true,"isActiveInOldHouse":true,"isActiveInNewHouse":false,"hint":"OH active sub, NH inactive OH exists","result":"LoginOH"}
 *
 * Both house, active in new
 * https://qa-englishlive.ef.com/checkout/house-login-dispatcher-v2.ashx?email=nzb2c@qp1.org
 * {"statusCode":200,"existsInOldHouse":true,"existsInNewHouse":true,"isActiveInOldHouse":false,"isActiveInNewHouse":true,"hint":"NH active sub","result":"LoginNH"}
 *
 * Edge case, both house, both active
 * https://qa-englishlive.ef.com/checkout/house-login-dispatcher-v2.ashx?email=auto_gb_88064704597600_gtk127_xdelx@qp1.org
 *{"statusCode":200,"existsInOldHouse":true,"existsInNewHouse":true,"isActiveInOldHouse":true,"isActiveInNewHouse":true,"hint":"OH active sub, NH active sub","result":"LoginNH"}
 *
 * For mobile cases, please add "mobile-" prefix to the endpoint like below,
 * https://qa-englishlive.ef.com/checkout/mobile-house-login-dispatcher-v2.ashx?email=ptest1@qp1.org
 * false
 * notExist
 *  https://qa-englishlive.ef.com/checkout/house-login-dispatcher-v2.ashx?email=noexist_negtest_xdelx@niko.org
 * {"statusCode":200,"existsInOldHouse":false,"existsInNewHouse":false,"isActiveInOldHouse":false,"isActiveInNewHouse":false,"hint":"Pure new account","result":"NotExist"}
 *
 */

import com.englishlive.tests.newhouse.dispatcher.dataprovider.DispatcherTestDataProvider;
import com.englishtown.driver.MyBrowserType;
import com.englishtown.driver.local.DriverManager;
import com.englishtown.tests.core.BaseTestHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class NhOhDispatcherTest extends BaseTestHelper {
    private static final Logger logger = LoggerFactory.getLogger(NhOhDispatcherTest.class);
    @Value("#{applicationPropertiesList['dispacher.url']}")
    protected String testUrl;
    //@Value("#{applicationPropertiesList['testuser.tr.accountcontent']}")
    //protected String testUsername;

    protected String weTagName = "pre";


    // TODO is is best suited as api test get Json response and set up bean then check all values

    @BeforeClass
    private void setup() {
        failTestPerEnvironment("live", "QA ONLY test ...! Data provider need users for live to make it work ");
    }

    @Test (dataProvider = "dispacherOhToNh", dataProviderClass = DispatcherTestDataProvider.class, threadPoolSize =10, invocationCount = 1, timeOut = 200000 )
    public void dispacherTestNhToOH(String testUsername, String expectedStrResult){
        logger.info("Test user ["+testUsername+"], Result Should be ["+expectedStrResult+"]");
        try {
            //setThreadSafeDriver();
            DriverManager.createDriver(MyBrowserType.CHROME_HEADLESS, 35);
            sleep(300);
            checkResponse(testUsername, expectedStrResult);
            destroyDriver();
        }catch (WebDriverException e){
            destroyDriver();
        }
    }

    public void checkResponse(String username, String responseStrToCheck) {
        openUrl(getWebDriver(), testUrl + username);
        WebElement resultStrWe = findElement(By.tagName(weTagName));
        assertWebElementText(resultStrWe, responseStrToCheck);
    }


    @AfterTest
    protected void testAfterClass(){
        destroyDriver();
    }

}

