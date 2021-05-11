package com.englishlive.tests.crm.monitor;
/**
 * Created by nikol.marku on 10-Jul-17.
 *
 *https://jira.eflabs.io/browse/SAND-4167
 * Test steps:
 OE Form test :
 1. open url
 2. enter data and submit
 3. check TY page shown ..[ URL]
 OS form test
 1. Open URL and submit new member [store username/pass]
 2. Check pay page URL and close page
 3. Open the same url with ?crmmb=1
 4. Login the new user created
 5. check welcome back page [URL... offer] and close page
 6. Repeat step [3]
 7. click forgotten pass link
 8. enter username created above
 9. submit
 10. check TY message shown and Login page shown as well
 "https://englishlive.ef.com/en-gb/lp/oe/crm-halloween/";
 "https://englishlive.ef.com/de-de/lp/os/crm-acq-3mnth/";
 "https://englishlive.ef.com/it-it/lp/os/crm-acq-summer-ipad-17/";
 "https://englishlive.ef.com/zh-tw/lp/oe/crm-acq-summer-ipad-17/";
 */
import com.englishlive.tests.crm.monitor.core.BaseCrmDinamycTest;
import com.englishlive.tests.crm.monitor.core.BaseCrmOSMonitorTest;
import com.englishtown.dataprovider.CrmOSOEMonitorDatatProvider;
import com.englishtown.dataprovider.TelephoneNoDataProvider;
import com.englishtown.dataprovider.bin.CountryBean;
import com.englishtown.dataprovider.bin.CrmMonitOSOEUrlBean;
import com.englishtown.driver.local.DriverManager;
import com.englishtown.helpers.CookieHandler;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.tests.core.EfConstants;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

import java.util.Map;


public class CrmOSMonitorTest extends BaseCrmOSMonitorTest {

    private static final Logger logger = LoggerFactory.getLogger(CrmOSMonitorTest.class);

    protected String waitForUrlContains = "lp/ty";


//    @Factory(dataProvider = "getCrmMonitOSurls", dataProviderClass = CrmOSOEMonitorDatatProvider.class)
//    public CrmOSMonitorTest(CrmMonitOSOEUrlBean crmBean) {
//        logger.info("Running constructor set up bean and driver ...!");
//        this.crmBean = crmBean;
//        waitForFormElementCss = "input[name=firstname]";
//        submitWeCss = waitForFormElementCss;
//    }


    @BeforeClass
    protected void setupDriver() {
        logger.info("BeforeClass ££££££$$$$$$$$$$$$$$$$$$$£££   setupDriver -> setThreadSafeDriver()     ££££££££");

        waitForFormElementCss = "input[name=firstname]";
        submitWeCss = waitForFormElementCss;
    }

    @AfterClass
    protected void destroyTestDriver() {
        logger.info("AfterClass ££££££$$$$$$$$$$$$$$$$$$$£££   destroyTestDriver -> destroyDriver()     ££££££££");
        destroyDriver();
    }


}
