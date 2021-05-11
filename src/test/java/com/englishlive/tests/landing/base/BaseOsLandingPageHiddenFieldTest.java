package com.englishlive.tests.landing.base;
/**
 * Hidden field test
 * Date: 01/09/14 .
 */
import com.englishtown.helpers.WebElementHelper;
import com.englishtown.tests.core.BaseLandingPageTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.englishtown.helpers.AssertHelper.myAssertThat;
import static org.hamcrest.CoreMatchers.is;


public abstract class BaseOsLandingPageHiddenFieldTest extends BaseLandingPageTest {
    private static final Logger logger = LoggerFactory.getLogger(BaseOsLandingPageHiddenFieldTest.class);
    public String osformsubmitId = "osformsubmit";
    public WebElement webElement;
    public String ctrId     ="ctr";
    public String langId    ="lang";
    public String leadId    ="leadtype";
    public String itagId      ="etag";
    public String partnerId   ="partner";
    public final String  defaultItagValue   ="";
    public final String  defaultPtnValue    ="None";


    public void checkOsHiddenFildTest(String id, String value, int waitTime){
        String hidenFieldId = getHidenFieldById(id, waitTime);
        logger.info("checkOsHiddenFildTest : assert hidden field :"+hidenFieldId+" is equal to :"+value+" wait time is "+waitTime+" seconds; URL is :"+getWebDriver().getCurrentUrl());
        //assertThat(" Failed - Hidden field is not equal to expected value ..!  ", hidenFieldId, is(value) );
        myAssertThat(getWebDriver(), " Failed - Hidden field is not equal to expected value ..!  ", hidenFieldId, is(value), true);
    }

   public void openPageAndValidate(String elementId){
       this.getPage().loadPage();
       try{Thread.sleep(1000);}catch (Exception e){}
        WebElementHelper.safeFindElement(getWebDriver(), By.id(elementId));
    }

    protected void testItagDefalultValueTest(){
        checkOsHiddenFildTest(itagId, defaultItagValue, 7);
    }

    protected void testPartnerDefalultValueTest(){
        checkOsHiddenFildTest(partnerId, defaultPtnValue, 10);
    }

//    @Override
//    public  void verifyLanguage(){}
//    @Override
//    public  void verifyMarket(){}
}














/**
 String script = "$('form')\n" +
 ".on('submit', function(){\n" +
 "  if ( document.getElementById('ctr').value == 'de' ){\n" +
 "    callback(true);\n" +
 "  }\n" +
 "  else {\n" +
 "    callback(false);\n" +
 "  }\n" +
 "})\n" +
 "$('#osformsubmit').trigger('click');"
 */


//    public static String getText(WebDriver driver, WebElement element){
//        return (String) ((JavascriptExecutor) driver).executeScript(
//                "return jQuery(arguments[0]).text();", element);
//    }
