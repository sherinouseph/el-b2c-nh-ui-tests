package com.englishlive.tests.redemption;
/**
 *  US
 */

import com.englishtown.driver.MyBrowserType;
import com.englishtown.enumpack.CheckoutFlowType;
import com.englishtown.helpers.WaitTool;
import com.englishtown.tests.flow.redemption.RedemptionFullFlow;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class GbRedemptionFullTest extends RedemptionFullFlow {
    private static final Logger logger = LoggerFactory.getLogger(GbRedemptionFullTest.class);

    @Value("#{applicationPropertiesList['redeem.gb.url']}")
    protected String url ;


    @BeforeClass
    public void setup(){
        setThreadSafeDriver();
        isTestCheckoutFlowType = true;
        checkoutFlowType = CheckoutFlowType.REDEMPTION;
        setLanguageAndMarket("en", "gb");
        if(StringUtils.contains(getENVIRONMENT(), "qa") ){
            url = url.replace("=grd", "=SYSONLY-DE12MPT52109"); //getRedemptionCodePerEnv() );
        } else if(StringUtils.contains(getENVIRONMENT(), "live") ){
            url = url.replace("=grd", "=R15SCHOOLM1D");
        } else {
            destroyDriver();
            failTest("No redempiton code set for this environment [" + getENVIRONMENT() + "] ...!");
        }

        redemptionCode = getRedemptionCodeFromUrl(url);
        logger.info("redemptionCode is : "+redemptionCode);
        this.openUrl(getWebDriver(), this.url, -1 ) ;
        if(isBrowser(MyBrowserType.EDGE)) sleep(5000);
        try{
            WaitTool.waitForElementVisibleAndClickable(By.cssSelector(redemptionCodeTxtFieldId), getWebDriver(), WaitTool.DEFAULT_WAIT_4_ELEMENT);
        }catch ( WebDriverException e){
            destroyDriver();
            failTest("Cant see member element:  ...! "+e.getMessage());
        }
    }

    @AfterClass
    protected void destroyDriverAfterClass(){
        destroyDriver();
    }

}
