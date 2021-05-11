package com.englishtown.pages.common.school.enrolmentui;
/**
 * On welcome after login click go button this page is shown
 * B2C flow is a bit different
 *
 * User: nikol.marku
 * Date: 06/12/17
 *
 */
import com.englishtown.helpers.AssertHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


public class MotivationPage extends BaseEnrollmentPage {

    public static final Logger logger = LoggerFactory.getLogger(MotivationPage.class);
    public static final String enrolmentPageUrl = "";

    protected final String MOTIVATION_OTHERREASON_CSS = ".MotivationStep-another-reason input";
    protected final String MOTIVATION_LIST_CSS        = "[class^='motivation-list_'] div"; //[class^='motivation-list_'] [class^='item_'];// pre 2019 "[class^='motivation-list_'] div"; // ".MotivationStep-motivation-list .MotivationStep-item";
    //protected final String anotherReasonCss     = "[name=anotherReason]";    protected final String stepBackCss          = ".step-back a";   // protected final String levelListCss         = ".level-list li";    //public final String startLearningCss     = ".btn.btn-primary button:nth-child(1)";    //public final String levelListSelectThisLevelCss = levelListCss + ":nth-child(2) .button.bordered"; //.level-list li description label span


    @FindBy(css = MOTIVATION_OTHERREASON_CSS)
    public WebElement otherReasonWe ;   // this has been removed for new house

    @FindBy(css = MOTIVATION_LIST_CSS)
    public List<WebElement> motivationListWe ;


    public MotivationPage(WebDriver webDriver){
        super(webDriver);
    }

    public MotivationPage(WebDriver webDriver, int waitTimeSec) {
        super(webDriver, waitTimeSec);
    }

    public MotivationPage(WebDriver webDriver, String url) {
        super(webDriver, url);
    }

    public MotivationPage() {
        this(null, null);
    }

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public boolean simpleTest() {
        logger.info("element displayed ...!");
        //AssertHelper.assertWebElementDisplayed(otherReasonWe);
        AssertHelper.assertWebElementDisplayed(motivationListWe.get(1));
        return true;
    }

    public boolean checkAllPageComponentsDisplayed() {
        logger.info("checkAllPageComponentsDisplayed ...!");
        checkAllPageComponentsDisplayed(motivationListWe.get(3));
        return true;
    }

    public ExpectedCondition getPageLoadedCondition() {
        return ExpectedConditions.visibilityOf(otherReasonWe);
    }

    public String getPageUrl() {
        return enrolmentPageUrl;
    }

    public void clickToSelectMotivation(int motivationIndex){
        logger.info("Clicking to select Motivation ..Select ["+motivationIndex+"]  - 0=carrer, 1=travel, 2=english exam, 3=personal development-");
        click(motivationListWe.get(motivationIndex));
        sleep(500);
    }




}



// https://qa-englishlive.ef.com/1/enrollment/  not needednew house
    /*public void checkUrlEnrolmentPageUrlStepNo(String stepId){
        logger.info("Is isUrlEnrolmentPage Step No ["+stepId+"]");
        AssertHelper.assertUrlContains(TestUtil.getCurrentUrl(getWebDriver()), getPageUrl()+stepId, "Is not the expected Step ...!" );
    }*/

    /*public void waitStepLoaded(By bySelector){
        WaitTool.waitForCondition(ExpectedConditions.visibilityOfElementLocated(bySelector), getWebDriver(), 25);
    }*/
