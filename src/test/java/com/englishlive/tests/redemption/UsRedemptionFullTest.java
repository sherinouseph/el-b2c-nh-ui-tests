package com.englishlive.tests.redemption;
/**
 *  US
 */
import com.englishtown.driver.MyBrowserType;
import com.englishtown.enumpack.CheckoutFlowType;
import com.englishtown.helpers.*;
import com.englishtown.tests.flow.redemption.RedemptionFullFlow;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class UsRedemptionFullTest extends RedemptionFullFlow {
    private static final Logger logger = LoggerFactory.getLogger(UsRedemptionFullTest.class);

    @Value("#{applicationPropertiesList['redeem.us.url']}")
    protected String url ;


    @BeforeClass
    public void setup(){
        setThreadSafeDriver();
        isTestCheckoutFlowType = true;
        checkoutFlowType = CheckoutFlowType.REDEMPTION;
        if(StringUtils.contains(getENVIRONMENT(), "live") ){
            //url = url.replace("=grd", "=eric1mss");
            url = url.replace("=grd", "="+getRedemptionCodePerEnv() );
        }
        redemptionCode = getRedemptionCodeFromUrl(url);
        logger.info("redemptionCode is : "+redemptionCode);
        this.openUrl(getWebDriver(), this.url, -1 ) ;
        if(isBrowser(MyBrowserType.EDGE)) sleep(5000);
        WaitTool.waitForElementVisibleAndClickable(By.cssSelector(redemptionCodeTxtFieldId), getWebDriver(), WaitTool.DEFAULT_WAIT_4_ELEMENT);
    }

    @AfterClass
    protected void destroyDriverAfterClass(){
        destroyDriver();
    }

}
