package com.englishtown.tests.core.earningcal;

import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.WebElementHelper;
import com.englishtown.pages.core.BasePage;
import com.englishtown.tests.core.BaseLandingPageTest;
import com.englishtown.tests.core.IEarningsCalculator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.Matchers.is;

/**
 * Created by nikol.marku on 06/05/2015.
 */

public abstract class BaseLeadEarningCalculator extends BaseEarningCalculator {
    private static final Logger logger = LoggerFactory.getLogger(BaseLeadEarningCalculator.class);

//    protected static String LAUNCH_CALCULATOR =  ".section button";


//    @Test( priority = 1 )
//    public void launchCalculator(){
//        logger.info(" Click Launch Calculator ...!");
//        currWebElement = WaitTool.waitForElementVisible( getWebDriver(), By.cssSelector(LAUNCH_CALCULATOR),
//                                                         WaitTool.DEFAULT_WAIT_4_ELEMENT, WaitTool.DEFAULT_POLL_SLEEP);
//        scrollToWeAndClick(getWebDriver(), currWebElement, 0, 30);
//        try{Thread.sleep(2000);}catch (Exception e){}
//    }


}
