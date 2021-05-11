package com.englishlive.tests.crm.monitor.core;
/**
 * Created by nikol.marku on 10-Jul-17.
 *
 *
 */
import com.englishtown.dataprovider.bin.CrmMonitOSOEUrlBean;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.utils.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.util.Map;


public abstract class BaseCrmOEMonitorTest extends BaseCrmDinamycTest{

    private static final Logger logger = LoggerFactory.getLogger(BaseCrmDinamycTest.class);
    protected CrmMonitOSOEUrlBean crmBean;
    protected Map formDataMap;


    @Test
    void openCrmUrl_submitForm_checkTYpageURL(){
        sleep(1000);
        try {
            testStartUrl = getBASEURL() + crmBean.getUrl();

            openUrl(getWebDriver(), testStartUrl);

            formDataMap = getOEFormDataMap(crmBean.getCountryTwoLetterCode());

            TestUtil.enterFormData(getWebDriver(), formDataMap);                                                            //Optional optional = formDataMap.entrySet().stream().findFirst();
            enterEmail(getWebDriver(), true);

            WebElement we = WaitTool.waitForElementVisible(getWebDriver(),
                    By.name(formDataMap.entrySet().stream().findFirst().get().toString().split("=")[0]),
                    WaitTool.DEFAULT_WAIT_4_ELEMENT, 1000);
            submit(we);

            waitForUrlContains(getWebDriver(), crmBean.getCountryTwoLetterCode(), 15);
            assertIsUrlContaining(crmBean.getCountryTwoLetterCode());
            sleep(3000);
        }finally {
            destroyDriver();
        }

    }


}
