package com.englishlive.tests.redemption;
/**
 *
 * Note: Nov 2017 autosubmit=false param is not working anymore
 */

import com.englishtown.enumpack.CheckoutFlowType;
import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.UrlMapper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.WebElementHelper;
import com.englishtown.tests.flow.redemption.BaseRedemptionFlow;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class BrRedemptionFullTest extends BaseRedemptionFlow {
    private static final Logger logger = LoggerFactory.getLogger(BrRedemptionFullTest.class);

    @Value("#{applicationPropertiesList['redeem.br']}")
    protected String url ;


    @BeforeClass
    public void setup(){
        setThreadSafeDriver();
        failTestIfIsNotBrowser(CHROME_BROWSER_LIST, "Chrome Only Test ....!");
        isTestCheckoutFlowType = true;
        checkoutFlowType = CheckoutFlowType.REDEMPTION;
        //if(StringUtils.contains(getENVIRONMENT(), "live") ){  url = url.replace("=grd", "="+getRedemptionCodePerEnv() );  }
        redemptionCode =getRedemptionCodePerEnv(); // "TEST1DSS35095CC912FE"; //getRedemptionCodeFromUrl(url);
        logger.info("redemptionCode is : "+redemptionCode);
        this.openUrl(getWebDriver(), this.url, -1 ) ;
        //FirstName
        WaitTool.waitForElementVisibleAndClickable(By.id(redemptionTxtWeId), getWebDriver(), WaitTool.DEFAULT_WAIT_4_ELEMENT);
    }

    @Test
    public void enterRedemptionCode(){
        WebElementHelper.sendKeys(getWebDriver(), findElement(By.id(redemptionTxtWeId)), redemptionCode, true);
        sleep(1000);
    }
    @Test
    public void submitRedemptionCode(){
        click(getWebDriver(), By.id("submit"));
        sleep(1000);
        waitForElementCondition( ExpectedConditions.visibilityOfElementLocated(By.id("FirstName")), getWebDriver(), 20);
    }
    @Test
    public void validateMemberPageShown(){
        AssertHelper.assertWebElementDisplayed(getWebDriver(),By.id("FirstName") );
    }

    @AfterClass
    protected void destroyDriverAfterClass(){
        destroyDriver();
    }


}
