package com.englishlive.tests.redemption;
/**
 *  US
 */

import com.englishtown.helpers.WaitTool;
import com.englishtown.tests.flow.redemption.RedemptionAutoSubmitFlow;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class UsRedemptionAutoSubmitTest extends RedemptionAutoSubmitFlow {
    private static final Logger logger = LoggerFactory.getLogger(UsRedemptionAutoSubmitTest.class);

    @Value("#{applicationPropertiesList['redeem.us.autosubmit.url']}")
    protected String url ;


    @BeforeClass
    public void setup(){
        setThreadSafeDriver();
        //url = "https://englishlive.ef.com/en-gb/buy/redemption/index/?rcode=TEST1DSS35095CC912FE&autosubmit=true";
        if(!StringUtils.contains(getENVIRONMENT(), "qa") ){
            url = url.replace("=grd", "="+getRedemptionCodePerEnv() );
        }
        redemptionCode = getRedemptionCodeFromUrl(url);
        logger.info("redemptionCode is : "+redemptionCode);
        this.openUrl(getWebDriver(), this.url, -1 ) ;
        WaitTool.waitForElementVisibleAndClickable(By.id("firstname"), getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
    }

    @AfterClass
    protected void destroyDriverAfterClass(){
        destroyDriver();
    }


}
