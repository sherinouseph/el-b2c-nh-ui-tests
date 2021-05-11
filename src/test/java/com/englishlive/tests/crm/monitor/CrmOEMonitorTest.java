package com.englishlive.tests.crm.monitor;
/**
 * Created by nikol.marku on 10-Jul-17.
 *
 *
 */
import com.englishlive.tests.crm.monitor.core.BaseCrmDinamycTest;
import com.englishlive.tests.crm.monitor.core.BaseCrmOEMonitorTest;
import com.englishtown.dataprovider.CrmOSOEMonitorDatatProvider;
import com.englishtown.dataprovider.bin.CrmMonitOSOEUrlBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Factory;


public class CrmOEMonitorTest extends BaseCrmOEMonitorTest{

    private static final Logger logger = LoggerFactory.getLogger(BaseCrmDinamycTest.class);

    //@Factory(dataProvider = "getCrmMonitOEurlsObj", dataProviderClass = CrmOSOEMonitorDatatProvider.class)
    @Factory(dataProvider = "getCrmMonitOEurls", dataProviderClass = CrmOSOEMonitorDatatProvider.class)
    public CrmOEMonitorTest(CrmMonitOSOEUrlBean crmBean) {
        logger.info("Running constructor set up bean and driver ...!");
        this.crmBean = crmBean;
    }


    @BeforeClass
    protected void setupDriver() {
        logger.info("BeforeClass ££££££$$$$$$$$$$$$$$$$$$$£££   setupDriver -> setThreadSafeDriver()     ££££££££");
        setThreadSafeDriver();
    }

    @AfterClass
    protected void destroyTestDriver() {
        logger.info("AfterClass ££££££$$$$$$$$$$$$$$$$$$$£££   destroyTestDriver -> destroyDriver()     ££££££££");
        destroyDriver();
    }


}
