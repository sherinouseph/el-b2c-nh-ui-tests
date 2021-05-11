package com.englishlive.tests.redemption;
/**
 *  US
 */

import com.englishtown.helpers.WaitTool;
import com.englishtown.tests.flow.redemption.RedemptionAutoSubmitFlow;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class GBRedemptionAutoSubmitTest extends RedemptionAutoSubmitFlow {
    private static final Logger logger = LoggerFactory.getLogger(GBRedemptionAutoSubmitTest.class);

    @Value("#{applicationPropertiesList['redeem.gb.autosubmit.url']}")
    protected String url ;


    @BeforeClass
    public void setup(){
        setThreadSafeDriver();
        setLanguageAndMarket("en", "gb");
        //url = "https://englishlive.ef.com/en-gb/buy/redemption/index/?rcode=TEST1DSS35095CC912FE&autosubmit=true";

        if(StringUtils.contains(getENVIRONMENT(), "qa") ){
            url = url.replace("=grd", "=SYSONLY-DE12MPT52109"); //getRedemptionCodePerEnv() );
        } else if(StringUtils.contains(getENVIRONMENT(), "live") ){
            url = url.replace("=grd", "=R15SCHOOLM1D");
        } else {
            destroyDriver();
            failTest("No redempiton code set for this environment ["+getENVIRONMENT()+"] ...!");
        }


        redemptionCode = getRedemptionCodeFromUrl(url);
        logger.info("redemptionCode is : "+redemptionCode);
        this.openUrl(getWebDriver(), this.url, -1 ) ;
        try {
            WaitTool.waitForElementVisibleAndClickable(By.name("firstname"), getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        }catch (WebDriverException e){
            destroyDriver();
            failTest("Cant see member form name element: firstname ...! "+e.getMessage());
        }
    }

    @AfterClass
    protected void destroyDriverAfterClass(){
        destroyDriver();
    }


}
