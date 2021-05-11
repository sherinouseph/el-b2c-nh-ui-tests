package com.englishlive.tests.landing.base;
/**
 * Negative testing
 * User: nikol.marku
 * Date: 27/08/14
 *
 */

import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.WebElementHelper;
import com.englishtown.pages.core.BasePage;
import com.englishtown.tests.core.BaseLandingPageTest;
import com.englishtown.tests.core.EfConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import java.util.Map;

import static com.englishtown.helpers.AssertHelper.myAssertThat;

public abstract class BaseOSPageNegativeTest extends BaseLandingPageTest {
    private static final Logger logger = LoggerFactory.getLogger(BaseOSPageNegativeTest.class);
    protected int noOfWebFormElements;     //=7;
    protected String formElementSelector;  // = ".et-sp-form-realtime input";
    protected WebElement webElement;
    protected Map userMap;                       // init this wit dynamic email address
    protected Map emptyMap;
    protected String telNo="notInit";
    protected String validationMsgWeCss = "notInit"; // = "et-cnt"; //eu
    protected String userName = "noInit";
    protected String validationMsgText = "please enter"; //please enter

    //@BeforeClass BaseOSPageNegativeTest
    protected void setup(String userNameIn, String telNoIn, Map emptyMapIn, int noOfWebFormElementsIn,
               String formWeSelectorIn, String validationMsCcc, String validationText){                        //getWebDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
         this.telNo = telNoIn;
         this.emptyMap = emptyMapIn;
         this.formElementSelector = formWeSelectorIn;
         this.noOfWebFormElements = noOfWebFormElementsIn;
         this.validationMsgWeCss  = validationMsCcc;
         this.validationMsgText   = validationText;
         this.userMap  = EfConstants.createMap(this.userName, this.telNo)  ;
         this.userName =  userNameIn+System.currentTimeMillis()+"@qp1.org"; //"noInit";
         logger.info("Setup map with username : "+userName+" and tel :"+telNo);
         EfConstants.dumpMap(userMap);           //this.getPage().isUrlValidForThisPage();
    }

    @Test
    void enter_emptyData(){
         enterFormData(this.emptyMap);
    }

//    @Test(dependsOnMethods = { "enter_emptyData" })
//    void validateTheNumberOfFormElements(){
//        assertNoOfFormElements(getWebDriver(),By.cssSelector(formElementSelector), noOfWebFormElements);
//    }
    @Test (dependsOnMethods = { "enter_emptyData" })
    void click_submit(){
        submitOsForm();
    }

    @Test (dependsOnMethods = { "click_submit" })
    void validateFormValidationMsgAndElement(){
        WebElement we = WaitTool.findElementDontFailTest(getWebDriver(), By.cssSelector(validationMsgWeCss)); //WebElementHelper.safeFindElement(getWebDriver(), By.cssSelector(validationMsgWeCss));
        if(we !=null) {
            myAssertThat(getWebDriver(), " Failed we is not Displayed ...!", we.isDisplayed(), true);
        } else {
            BasePage.failTest("WebElement not displayed; is null ....! "+validationMsgWeCss);
        }
        logger.info(validationMsgText+"");
        myAssertThat(getWebDriver(), " Validation message '"+ we.getText()+"' does not contains("+validationMsgText+")",
                we.getText().toLowerCase().contains(validationMsgText), true );
    }

//    @Override
//    public  void verifyLanguage(){}
//    @Override
//    public  void verifyMarket(){}

}
