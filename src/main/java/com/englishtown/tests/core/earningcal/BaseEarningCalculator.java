package com.englishtown.tests.core.earningcal;

import com.englishtown.driver.BaseRemoteWebDriver;
import com.englishtown.driver.IWebDriverSetting;
import com.englishtown.helpers.*;
import com.englishtown.pages.core.BasePage;
import com.englishtown.tests.core.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

import static com.englishtown.helpers.AssertHelper.assertWebElementDisplayed;
import static com.englishtown.helpers.AssertHelper.myAssertThat;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.Matchers.*;

/**
 * Created by nikol.marku on 06/05/2015.
 */

public abstract class BaseEarningCalculator extends BaseLandingPageTest implements IEarningsCalculator {
    private static final Logger logger = LoggerFactory.getLogger(BaseEarningCalculator.class);

    protected String tryMeId = "par_contentfragment-4_fragment_spacer_spacercontent_button";
    protected Map formDataMapEarnings;
    protected int selectIndex   = 1;
    protected int experienceId   = 0; // 0 -3
    protected int englishLevelId = 0; // 4-7
    protected String isMemberPageUrl = "buy/default/member";
    protected String selectListCss = ".control select";
    protected String emailenglishId = "emailenglish";
    // numbers on last step
    protected String topHeaderSelectorList   = "div h2"; // css  for advanced use second element
    protected String earnUpToCssList         = ".column2 div h3"; // list use 0 1 2  4 and 5 for advanced
    //protected String withAdvancedCssList     = "div h3"; // advanced numbers list - use 4th and 5th
      //set this up on the test
    protected String headerValue;
    protected String earnUpToValue;
    protected String advancedHeaderValue;
    protected int advancedHeaderValueId = 1; // this is 2 for MX
    protected String withAdvanceValue;
    protected String withAdvanceValueAdvanced;
    protected String lifeTimeValue;
    protected String advancedLifeTimeValue;
    private  List <WebElement> we;
    protected boolean isAdvanced = false;
    protected String imageCss = ".col-md-4.col-sm-4.col-xs-4 .parsys.column1 img"; // bag image //1 and 2 adv
    protected String advImage    = "1448545471305"; //"1430300944846";
    protected String normalImage = "1461344257871";//1461344258678 1461344257871 "1430301102889";

    protected String submitBtnFirstStepUk = "contentPar_spacer_spacercontent_slider_slide-2-s_columnscontrol_column1_spacer_spacercontent_button";
    protected boolean isDifSubmitFirstStep = false;// use did submit first step for each test
    protected String submitEarningsBtnCss = "button[id*=spacer--spacercontent--button"; // "-rsrc--content--englishtown--gb--en--resources--english-tools--earning-calculator--jcr__content--contentPar--spacer--spacercontent--slider--slide-2-s--columnscontrol--column1--columnscontrol--column0--spacer--spacercontent--button";
    protected String calculateEarningStep1BtnCss = ".calculateEarningStep1";

    protected String startLearningNowBtnId =".bs3 .btn.btn-primary"; // "contentPar_spacer_spacercontent_slider_slide-1-s_columnscontrol-0_column1_columnscontrol-0_column0_spacer-0_spacercontent_button"; // replace with .btn.btn-primary  submit btn removed

    protected static String LAUNCH_CALCULATOR =  ".section button";


    @Test  //( priority = 1 )
    public void launchCalculator(){
        logger.info(" Click Launch Calculator ...! This is on develop-parallel branch test");
        currWebElement = WaitTool.waitForElementVisible( getWebDriver(), By.cssSelector(LAUNCH_CALCULATOR), WaitTool.DEFAULT_WAIT_4_ELEMENT, WaitTool.DEFAULT_POLL_SLEEP);
        scrollToWeAndClick(getWebDriver(), currWebElement, 0, 30);
        try{Thread.sleep(2000);}catch (Exception e){}
    }

//    // this step has removed
//    @Test( priority = 2 )
//    public void enterDetailsStep1(){
//        enterFormData(formDataMap);
//        ensureChecked(By.id(emailenglishId));
//    }
//    @Test(dependsOnMethods={"enterDetailsStep1"})
//    public void submitYourDetailsEC(){
//        if(isDifSubmitFirstStep){ // special to UK
//            WebElementHelper.safeFindAndClick(getWebDriver(), By.id(submitBtnFirstStepUk));
//        }else {
//            submitOsForm();
//        }   try{Thread.sleep(3000);}catch (Exception e){}
//
//    }
    //NOTE: form is without id and names - nothing is unique
    @Test (dependsOnMethods="launchCalculator") //( priority = 2 ) //(dependsOnMethods={"submitYourDetailsEC"})
    public void enterEarningsStep2(){
        String experienceWe = ".count-5.buttons span";
        WaitTool.waitForListElementsDisplayed(getWebDriver(), By.cssSelector(experienceWe), WaitTool.MED_WAIT_4_ELEMENT25);
        WaitTool.waitForListElementsPresent(getWebDriver(), By.cssSelector(selectListCss), WaitTool.DEFAULT_WAIT_4_ELEMENT);
        List<WebElement> weSelectList = WaitTool.waitForListElementsPresent(getWebDriver(), By.cssSelector(selectListCss), WaitTool.DEFAULT_WAIT_4_ELEMENT);//getWebDriver().findElements(By.cssSelector(selectListCss));
        if(BaseRemoteWebDriver.isBrowser("explore") && !BaseRemoteWebDriver.browserVersion.isEmpty()&& "10"==BaseRemoteWebDriver.getCapability().getVersion()){
            WebElementHelper.selectOptinUsingDownArrowKey( weSelectList.get(0),selectIndex, Keys.ARROW_DOWN );
            try{ Thread.sleep(500);}catch (Exception e){};
            WebElementHelper.selectOptinUsingDownArrowKey(weSelectList.get(1), selectIndex, Keys.ARROW_DOWN);
        }else {
            WebElementHelper.selectByIndex(getWebDriver(), weSelectList.get(0), selectIndex);
            WebElementHelper.selectByIndex(getWebDriver(), weSelectList.get(1), selectIndex);
        }


        List<WebElement> weList = WaitTool.waitForListElementsPresent(getWebDriver(), By.cssSelector(experienceWe), WaitTool.SHORT_WAIT_4_ELEMENT);  //getWebDriver().findElements(By.cssSelector(".count-5.buttons span"));                 //experience and english
        weList.get(experienceId).click();
        try{ Thread.sleep(1000);}catch (Exception e){};
        weList.get(englishLevelId).click();
        try{ Thread.sleep(500);}catch (Exception e){};
        enterFormData(formDataMapEarnings);
        try{ Thread.sleep(500);}catch (Exception e){};
    }

    @Test(dependsOnMethods={"enterEarningsStep2"})
    public void submitEarning(){
         List<WebElement> currWebElement = getWebDriver().findElements(By.cssSelector(startLearningNowBtnId));
          currWebElement.get(1).click();
        try{ Thread.sleep(3000);}catch (Exception e){};
    }

    @Test(dependsOnMethods={"submitEarning"})
    public void checkEarningCalculator(){
        String listSalaryCss = ".salary";
        WaitTool.waitForListElementsPresent(getWebDriver(), By.cssSelector(listSalaryCss), WaitTool.DEFAULT_WAIT_4_ELEMENT);
        List<WebElement> weSalaryList = getWebDriver().findElements(By.cssSelector(listSalaryCss));
        logger.info(" weSalaryList size is : "+weSalaryList.size() );
        AssertHelper.myAssertThat(getWebDriver(), " Failed weSalaryList size is not more than 3", weSalaryList.size() > 3, is(true), true);
        logger.info(" weSalaryList : " + weSalaryList.toString());
        try{ Thread.sleep(100);}catch (Exception e){};
    }
//    @Test(dependsOnMethods={"checkEarningCalculator"})
//    public void checkNumberOnHeader(){
//        we = getWebDriver().findElements(By.cssSelector(topHeaderSelectorList));                 //logger.info("1" +we.get(0).getAttribute("value"));        logger.info("2" +we.get(1).getAttribute("value"));        logger.info("text" +we.get(0).getText());        logger.info("text2" +we.get(1).getText());
//        if(isAdvanced) {
//            AssertHelper.myAssertThat(getWebDriver(), "topHeaderSelectorList Failed ...! ", we.get(advancedHeaderValueId).getText(), containsString(advancedHeaderValue), true);
//        }else {
//            AssertHelper.myAssertThat(getWebDriver(), "topHeaderSelectorList Failed ...! ", getText(we.get(2)), containsString(headerValue), true);
//        }
//    }
    @Test(dependsOnMethods={"checkEarningCalculator"})
    public void checkEarnUpToValue(){
        we = getWebDriver().findElements(By.cssSelector(earnUpToCssList));
        logger.info("0 :" +we.get(0).getText());
        logger.info("1 :" +we.get(1).getText());
        logger.info("2 :" +we.get(2).getText());//        logger.info("a :" +we.get(0).getAttribute("value"));        logger.info(" :" +we.get(1).getAttribute("value"));        logger.info(" :" +we.get(2).getAttribute("value"));
        if(isAdvanced) {
            // dont test - no value
        } else {
            AssertHelper.myAssertThat(getWebDriver(), "checkEarnUpToValue Failed ...! ", we.get(0).getText(), containsString(earnUpToValue), true);
        }
    }
    @Test(dependsOnMethods={"checkEarningCalculator"})
    public void checkLifeTimeValue(){
        if(isAdvanced) {
            AssertHelper.myAssertThat(getWebDriver(), "checkLifeTimeValue Failed ...! ", we.get(2).getText(), containsString(advancedLifeTimeValue), true);
        } else {
            AssertHelper.myAssertThat(getWebDriver(), "checkEarnUpToValue Failed ...! ", we.get(1).getText(), containsString(lifeTimeValue), true);
        }
    }
    @Test(dependsOnMethods={"checkEarningCalculator"})
    public void checkAdvancedValue(){
        we = getWebDriver().findElements(By.cssSelector(earnUpToCssList));
        logger.info("0 :" +we.get(0).getText());
        logger.info("1 :" +we.get(1).getText());
        logger.info("2 :" +we.get(2).getText());
        if(isAdvanced) {
            logger.info("4 :" +we.get(4).getText());
            logger.info(" Is advanced ...!");
            AssertHelper.myAssertThat(getWebDriver(), "checkAdvancedValue Failed ...! ", we.get(4).getText(), containsString(withAdvanceValueAdvanced), true);
        } else {
            AssertHelper.myAssertThat(getWebDriver(), "checkEarnUpToValue Failed ...! ", we.get(2).getText(), containsString(withAdvanceValue), true);
        }
    }

    @Test(dependsOnMethods={"checkEarningCalculator"})
    public void checkImage(){
        int id = 0;
        String currentImage = normalImage;
        if(isAdvanced) {
            id = 1;
            currentImage = advImage;
        }
        try{
            //TODO monitor this .... TO use find visible element
            List <WebElement> imageElement = getWebDriver().findElements(By.cssSelector(imageCss));
            String srcValue = getAttributeValue(imageElement.get(id), "src");
            logger.info("  srcValue :"+srcValue); //            srcValue = getAttributeValue(imageElement.get(1), "src");            logger.info("  srcValue 1 :"+srcValue);            srcValue = getAttributeValue(imageElement.get(2), "src");            logger.info("  srcValue 2:"+srcValue);
            checkImageIsDisplayed(imageElement.get(id));
            AssertHelper.myAssertThat(getWebDriver(), "checkImage Failed ...!", srcValue, containsString(currentImage), true);
        }catch (Exception e){
            BasePage.failTest("checkImage displayed Failed ...!. Image is NOT : "+currentImage);
        }

    }
//console.log(we.top, we.right, we.bottom, we.left);
    @Test(dependsOnMethods={"checkImage"})
    public void CheckClickScrollAnd_enterFormData_SubmitForm(){
        // click on start learning will scroll down on page

        WebElement startLearningWe = WaitTool.findElements(getWebDriver(), By.cssSelector(".bs3 .btn.btn-primary")).get(2); // third element in the list
        String weTopBeforeClick = executeJSscript("return document.querySelectorAll('.bs3 .btn.btn-primary')[2].getBoundingClientRect().top", getWebDriver(), 5); // executeJSscript("return document.querySelectorAll('.bs3 .btn.btn-primary')[2].getBoundingClientRect().top", getWebDriver(), 5) {executeJSscript("return document.querySelectorAll('.bs3 .btn.btn-primary')[2].getBoundingClientRect()", getWebDriver(), 5) top=0, left=821.640625, bottom=40, width=197.71875, right=1019.359375, height=40}
        int topBeforeClick = BaseTestHelper.getIntFromString(weTopBeforeClick);                                   //Point startLearningPoint = startLearningWe.getLocation();
        logger.info("Start learning point top : "+startLearningWe +" - "); //+startLearningWe.getRect().getY());
        click(startLearningWe); sleep(3000);

        WebElement startLearningAfterClickWe = WaitTool.findElements(getWebDriver(), By.cssSelector(".bs3 .btn.btn-primary")).get(2);
        String weTopAfterClick = executeJSscript("return document.querySelectorAll('.bs3 .btn.btn-primary')[2].getBoundingClientRect().top", getWebDriver(), 5); //Point startLearningPointAfterClick = startLearningAfterClickWe.getLocation();
        logger.info("Start learning point : "+weTopAfterClick.toString()) ; //+startLearningAfterClickWe.getRect().getY());
        int topAfterClick = BaseTestHelper.getIntFromString(weTopAfterClick);
        // check page scrolled
        myAssertThat(getWebDriver(), "FAILED, WebElement is not scrolled; top before ["+topBeforeClick+"] ; " +
                "after ["+topAfterClick+"]",topAfterClick, allOf(greaterThan(-505),lessThan(400)), true) ;//changed from -500 to -505 because of tc checkbox
        enterFormData(EfConstants.atOeFormMap);
        WebElement submitOs = findElement(By.name("first_name"));
        submit(submitOs);
    }

    @Test(dependsOnMethods = "CheckClickScrollAnd_enterFormData_SubmitForm")
    void checkURLisThankyouPage(){
        assertIsUrlContaining("lp/ty");
        AssertHelper.myAssertThat(getWebDriver(), "404: PAGE NOT FOUND Shown .... on page ...",
                getText(findElement(By.tagName("h1"))), is(not(containsString("PAGE NOT FOUND"))), true ) ;
    }
    /*
    @Test(dependsOnMethods={"checkURLisThankyouPage"})
    public void isTrackingEfEducationFirst(){
        logger.info(" running TEST : PageTest.isTrackingEfEducationFirst() time :"+System.currentTimeMillis());
        myAssertThat(getWebDriver(), "FAILED, result does not contains :"+CONTAINS_TRACKING_SERVER,
                isTrackingEfEducationFirst(JS_TRACKING_EF, getWebDriver(), CONTAINS_TRACKING_SERVER,
                        WaitTool.JS_SCRIPT_DEFAULT_TIMEOUT),true) ;
    }*/


//    @Test(dependsOnMethods={"checkImage"})
//    public void clickTryMe(){
//        WebElementHelper.safeFindAndClick(getWebDriver(), By.id(tryMeId));
//        try{ Thread.sleep(5000);}catch (Exception e){};
//        // TODO this step opens new tabs pages so until they fix it will comment it out - and it goes to new/old checkout or home for mx
////        AssertHelper.myAssertThat(getWebDriver()," Failed ...! Url does not contain : "+isMemberPageUrl,
////                BasePage.waitForUrlContains(getWebDriver(), isMemberPageUrl, WaitTool.DEFAULT_WAIT_4_ELEMENT), is(true), true);
//    }
//    @Override
//    void setupTestValues(){    }

//    @Override
//    public void verifyLanguage() {logger.warn("Test ingnored");}
//    @Override
//    public void verifyMarket()   {logger.warn("Test ingnored");}

}