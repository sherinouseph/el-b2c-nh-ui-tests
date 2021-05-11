package com.englishlive.tests.referral;
/**
 * Created by nikol.marku on 19/02/2016.
 * Check the text area characters left after typing [should show + & - .. latest update]
 * Click share btn and check twiter window opens and txt area contain text
 * Enter special characters and click share and check popup show and txt area contain text
 *
 */
import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.JavaScriptHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.WebElementHelper;
import com.englishtown.pages.core.BasePage;
import com.englishtown.tests.core.BaseTestConfig;
import com.englishtown.tests.core.BaseTestHelper;
import com.sun.imageio.plugins.wbmp.WBMPImageReader;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

//TODO major refactoring
public abstract class BaseTwiterReferral extends BaseTestHelper{
    private static final Logger logger = LoggerFactory.getLogger(BaseTwiterReferral.class);


    protected String testUsername ;
    protected String currentTestUsername = "enus@qp1.org";
    protected static String PASS = BaseTestConfig.getPassword8();
    protected String referralUrl;
    protected String loginUrl;
    protected final static String TWITTER_TAB_CSS         = ".twitter.tab"; // .icon";
    protected final static String TWITTER_TXT_AREA_CSS    = ".twitter .message";
    protected final static String REMAIN_COUNT_CHARS_CCS = ".twitter .remaining .count";
    protected final static String SHARE_BTN_CCS = "#twitter-page .btn-primary";
    protected final static String TWITTER_PASS_CCS = "#password";       //".submit .submit"; // ON NEW WINDOW   #password
    protected final static String TWITTER_TXTAREA_CCS = "#status";
    protected static int remainingChars = -1; // fail if -1
    protected static String jsGetTextAreaTXT = "(.twitter.page textarea').val()"; //todo
    protected static final String CURR_TXT = "; Learn English for free for 30 days @EnglishLive with a learning platform and live teachers available 24/7. http://goo.gl/cjQsuO";
    private static final String TXT = ";`a!$%; #'[]-09+/*";
    protected static final String FUNY_CHARS = "dfhdfsdfgsd sfdgsfdgs !\"£$%^&*()_++++++/*-+adsf a  a a     #'@~~````¬``````````34 34";
    protected static String TXT_AREA_CONTAINS = "nglish";
    protected String twitterShareBtnCss = "#twitter-page .submit";
    protected String classStartAletPopUpCloseIconCss = ".pepper-alert-close"; //

    @Test
    public void enterUserCredentialsAndLoginTest(){
        JavaScriptHelper.waitForPageLoaded(getWebDriver(), WaitTool.DEFAULT_WAIT_4_ELEMENT);
        enterCredentialsReferAFriend(getWebDriver(), testUsername, PASS, "UserName", "Password",".bs3 button");
    }

    @Test ( dependsOnMethods = { "enterUserCredentialsAndLoginTest" })
    public void openReferralPage(){
        openUrl(getWebDriver(), referralUrl, WaitTool.MED_WAIT_4_ELEMENT25);
    }

    @Test ( dependsOnMethods = { "openReferralPage" })
    public void ClickTwiterTabAndcheckRemainingCharsNotNegative(){
        JavaScriptHelper.waitForPageLoaded(getWebDriver(), WaitTool.DEFAULT_WAIT_4_ELEMENT);
        WaitTool.waitForCondition( ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(memberSpinnerCss)),getWebDriver(), 10);
        //popup shows sometime when there is something happening a lesson or ...
        WebElement popupCloseWe = WaitTool.safeFindDisplayedAndEnabled(getWebDriver(), By.cssSelector(classStartAletPopUpCloseIconCss), 5);
        clickAtWindow(getWebDriver(), 20, 20);
        waitForElementCondition(ExpectedConditions.elementToBeClickable(By.cssSelector(TWITTER_TAB_CSS)),getWebDriver(), 15);
        WebElement twiterTabWe = findElement(By.cssSelector(TWITTER_TAB_CSS));
        click(twiterTabWe);
        WebElement twitterShareButton = WaitTool.waitForElementVisible(getWebDriver(), By.cssSelector(twitterShareBtnCss), 15, 1000); //submit btn btn-primary
        if(twitterShareButton == null){
            failTest("Share on twitter button is not shown ...! : WebElement Selector ["+twitterShareBtnCss+"]");
        }
        checkRemainingChars(false);
    }

    @Test ( dependsOnMethods = { "ClickTwiterTabAndcheckRemainingCharsNotNegative" })
    public void checkRemainingCharsNegative(){
        WebElement we = findElement(By.cssSelector(TWITTER_TXT_AREA_CSS));
        we.sendKeys(" here is what we are typing to number .....");
        sleep(2000);
        checkRemainingChars(true);
    }

    @Test ( dependsOnMethods = { "checkRemainingCharsNegative" })
    public void shareTwitCheckPopUPwindoGotTheText(){
        sleep(1000);
        checkTwitterWindow( SHARE_BTN_CCS,  TWITTER_TXTAREA_CCS,  TXT_AREA_CONTAINS);
    }


    @Test ( dependsOnMethods = { "shareTwitCheckPopUPwindoGotTheText" })
    public void typeSpecialCharsAndCheckTwiterPopup(){
        WebElement we = findElement(By.cssSelector(TWITTER_TXT_AREA_CSS));
        logger.info(" get text : "+we.getText());
        we.clear();
        WebElementHelper.sendKeyWithWait(we, TXT, 500);
        we.sendKeys(CURR_TXT);
        sleep(2000);
    }

    @Test ( dependsOnMethods = { "typeSpecialCharsAndCheckTwiterPopup" })
    public void shareTwitCheckPopUPwindoGotTheSpecialText(){
        checkTwitterWindow( SHARE_BTN_CCS,  TWITTER_TXTAREA_CCS,  TXT_AREA_CONTAINS);
    }

    /**
     * Check Negative or possitive
     * @param isNegative
     */
    protected void checkRemainingChars( boolean isNegative ){
        int currRemainingChars = getRemainingChars();
        logger.info("checkRemainingChars ["+currRemainingChars+"] .. should be negative true/false :"+isNegative);
        if(isNegative){
            AssertHelper.assertThat("currRemainingChars ["+currRemainingChars+"] .. should be negative ...! ", currRemainingChars < 0);
        } else {
            AssertHelper.assertThat("currRemainingChars ["+currRemainingChars+"] .. should be 0 zero or Positive number ...! ", currRemainingChars > -1);
        }                 //        if( remainingChars > -1 ){ logger.info("Remaining Chars > -1 ...!  OK ; remainingChars :"+remainingChars); } else {  BasePage.failTest("Remaining Chars should be > -1 ...! but is Not;  it is : "+remainingChars); }
    }
    protected void checkRemainingChars( int remainingChars ){
        int currRemainingChars = getRemainingChars();
        logger.info("currRemainingChars ["+currRemainingChars+"] .. should be 0 zero or Positive number ...! ");
        AssertHelper.assertThat("currRemainingChars ["+currRemainingChars+"] .. should be equal ["+remainingChars+"] ...!",
                currRemainingChars == remainingChars);

    }

    protected int getRemainingChars(){
        WebElement we = findElement(By.cssSelector(REMAIN_COUNT_CHARS_CCS));
        int count = -1;
        String value = "-1";
        
        try{
            failTestIfNullWebElement(we);
            value = we.getText();
            count = Integer.valueOf(value);
        }catch (NumberFormatException nfe){
            logger.error("Can't convert to int ...["+value+"] Error : "+nfe.getMessage());
            nfe.printStackTrace();
        }catch (Exception e){
            logger.error("Can't convert to int ...["+value+"] Error : "+e.getMessage());
            e.printStackTrace();
        }
        logger.info("Remaining Charactrers ["+count+"]");
        return count;
    }


    /**
     * all twitter widow test
     */
    void checkTwitterWindow(String twitterShareBtnCss, String twitterTxtAreaCss, String checkThisTextOnTwitterPopUpTxtArea){
        WebElement shareWe = findElement(By.cssSelector(twitterShareBtnCss));
        String parentHandle = getWebDriver().getWindowHandle(); // get the current window handle
        click(shareWe);
        sleep(3000);
        //check pop up - Get new window handler
        for (String winHandle : getWebDriver().getWindowHandles()) {
            getWebDriver().switchTo().window(winHandle);        // switch focus of WebDriver to the next found window handle (that's your newly opened window)
        }
        //code to do something on new window
        WebElement twitterTxtWe = findElement(By.cssSelector(twitterTxtAreaCss));
        AssertHelper.assertThat("Webelement twitter textarea should not be NULL ...!", twitterTxtWe != null );
        String twitterTxt = twitterTxtWe.getText();
        logger.info("Txt shown on twitter window is : "+twitterTxt);
        AssertHelper.assertThat("Text should contain ["+checkThisTextOnTwitterPopUpTxtArea+"] ", StringUtils.contains(twitterTxt, checkThisTextOnTwitterPopUpTxtArea ));
        getWebDriver().close();                             // close newly opened window when done with it
        getWebDriver().switchTo().window(parentHandle);     // switch back to the original window
    }


}
