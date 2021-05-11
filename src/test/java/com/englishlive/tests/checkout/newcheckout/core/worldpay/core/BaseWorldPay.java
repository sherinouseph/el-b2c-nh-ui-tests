package com.englishlive.tests.checkout.newcheckout.core.worldpay.core;
/**
 *
 *
 */
import com.englishtown.enumpack.CheckoutFlowType;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.WebDriverWindowHelper;
import com.englishtown.helpers.WebElementHelper;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.tests.core.BaseTestHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Map;
import static com.englishtown.enumpack.CheckoutFlowType.*;
import static com.englishtown.helpers.AssertHelper.myAssertThat;
import static org.hamcrest.CoreMatchers.containsString;


public abstract class BaseWorldPay extends BaseTestHelper {
    private static final Logger logger = LoggerFactory.getLogger(BaseWorldPay.class);

    protected String currMemberPageUrl;
    protected Map paymentCardDetails;
    protected String SUBMMIT_PAYMENNT_ID = "submitButton";
    protected String payFrameId          = "wp-cl-worldpay-instance-0-iframe";
    protected String iFrameSelector      = "#wp-cl";     //"iframe#payFrameId"; need to switch first to make this work

    protected CheckoutFlowType checkoutFlowType = DEFAULT;
    boolean isTestCheckoutFlowType = true;


    public void clickPayTabAndSwitchFrame(String creditCardLinkText, String iFrameToSwitchToId, By iFrameSelector, int waitSpinnerGoesTimeSec){
        WaitTool.waitForCondition( ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(memberSpinnerCss) ),getWebDriver(), waitSpinnerGoesTimeSec);
        WebElementHelper.clickOnTabByLinkText(getWebDriver(), creditCardLinkText) ;
        logger.info(" Tab clicked ...!");
        WaitTool.waitForElementVisible(getWebDriver(),iFrameSelector , 15, 1000);
        WebDriverWindowHelper.switchToFrameByFrameWebElement(getWebDriver(),By.id(payFrameId));        //WebDriverWindowHelper.switchToFrameByFrameId(getWebDriver(), iFrameToSwitchToId, 5);//        logger.info("\ttime before switch to find element :"+ System.currentTimeMillis());//        WebElement iframeElement = getWebDriver().findElement(By.id(payFrameId));//        logger.info("\tframe element found time :"+ System.currentTimeMillis());//        getWebDriver().switchTo().frame(iframeElement);   logger.info("\ttime after switch to :"+ System.currentTimeMillis());
        waitForElementVisibleAndClick("#cardNumber", 5);
    }
    public void switchToPayFrame(String creditCardLinkText, String iFrameToSwitchToId, By iFrameSelector, int waitSpinnerGoesTimeSec){
        WaitTool.waitForCondition( ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(memberSpinnerCss) ),getWebDriver(), waitSpinnerGoesTimeSec);
        WaitTool.waitForElementVisible(getWebDriver(),iFrameSelector , 15, 1000);
        WebDriverWindowHelper.switchToFrameByFrameWebElement(getWebDriver(),By.id(payFrameId));        //WebDriverWindowHelper.switchToFrameByFrameId(getWebDriver(), iFrameToSwitchToId, 5);//        logger.info("\ttime before switch to find element :"+ System.currentTimeMillis());//        WebElement iframeElement = getWebDriver().findElement(By.id(payFrameId));//        logger.info("\tframe element found time :"+ System.currentTimeMillis());//        getWebDriver().switchTo().frame(iframeElement);   logger.info("\ttime after switch to :"+ System.currentTimeMillis());
        waitForElementVisibleAndClick("#cardNumber", 5);
    }

    public void checkThankyouPageMemberId(){
        checkFlowType(checkoutFlowType, isTestCheckoutFlowType);
        setMarketFromStateObj();
        setMemberIdFromStateObj();
        myAssertThat(getWebDriver(), " FAILED Member key'" + MEMBERID_KEY + "' Value is Empty/Null ..! :'" + memberId +
                "'", isNotEmpty_And_isNotBlank(memberId), true);
    }

    public void clickStartLearning(){
        currWebElement = findElement(By.className("btn-lg"));
        click(currWebElement);
    }

    public void userIsAtSchool(){
        String enrolmentPageUrl = "/campus/enrollment/b2c/entrance#1";
        waitForUrlContains(getWebDriver(), enrolmentPageUrl, 35);
        String currentUrl = TestUtil.getCurrentUrl(getWebDriver());
        myAssertThat(getWebDriver(), "Failed, URL does not contains enrollment : url is : " +currentUrl ,
                currentUrl, containsString(enrolmentPageUrl) , true) ;
    }


}

