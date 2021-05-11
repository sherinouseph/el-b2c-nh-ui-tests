package com.englishtown.pages.common.school.enrolmentui;
/**
 *  after level selection ... start learning button shown and confirmation of enroll page
 *
 * User: nikol.marku
 * Date: 17/01/19 remake NH
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


public class StartLearningPage extends BaseEnrollmentPage {
    public static final Logger logger = LoggerFactory.getLogger(StartLearningPage.class);

    public static final String pageUrl = "englishlive.ef.com/1/enrollment/";                        // same for all 3 steps

    protected final String GREEN_TICK_ICON_SELECTOR = "[class^='final-step_'] [class^='icon_']";

    protected final String START_LEARN_CSS = "[class^='final-step_'] button";                       // ".FinalStep .FinalStep-cta";

    protected final String HEADER_1        = "[class^='final-step_'] h2 ";                          // "very good" msg; // Very good! Based on your answers, we can choose the best level and learning speed for you.
                                                                                                    //protected final String HEADER_2        = "[class^='final-step_'] div[class^='body_']";
                                                                                                    // "With the answers you have given, we can determine the optimal level and learning speed for you" msg;
    protected final String LEVEL_BOX_SELECTOR = "[class^='final-step_'] [class^='level-desc_']";    // test is Your level:07Intermediate"

    protected final String STUDY_GOAL_BOX_SELECTOR = "[class^='final-step_'] [class^='study-goal_']";   // Your study goal:Complete Unit 1By Tem 9




    @FindBy(css = GREEN_TICK_ICON_SELECTOR)
    public WebElement greenTickWe ;

    @FindBy(css = START_LEARN_CSS)
    public WebElement startLearningWe ;

    @FindBy(css = HEADER_1)
    public WebElement header1We ;

    @FindBy(css = LEVEL_BOX_SELECTOR)
    public WebElement levelBoxWe ;

    @FindBy(css = STUDY_GOAL_BOX_SELECTOR)
    public WebElement studyBoxWe ;

    public StartLearningPage(WebDriver webDriver){
        super(webDriver);
    }

    public StartLearningPage(WebDriver webDriver, int waitTimeSec) {
        super(webDriver, waitTimeSec);
    }

    public StartLearningPage(WebDriver webDriver, String url) {
        super(webDriver, url);
    }

    public StartLearningPage() {
        this(null, null);
    }

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public boolean simpleTest() {
        logger.info("element displayed ...!");
        AssertHelper.assertWebElementDisplayed(startLearningWe);
        return true;
    }

    public boolean checkAllPageComponentsDisplayed() {
        logger.info("checkAllPageComponentsDisplayed ...!");
        checkAllPageComponentsDisplayed(startLearningWe, header1We, levelBoxWe, studyBoxWe, greenTickWe);
        return true;
    }

    public ExpectedCondition getPageLoadedCondition() {
        return ExpectedConditions.visibilityOf(startLearningWe);
    }

    public String getPageUrl() {
        return pageUrl;
    }

    //step 3
    public void clickStartLearning(){
        /*WaitTool.waitForCondition(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(START_LEARN_CSS)), getWebDriver(), 25);        WaitTool.waitForCondition(ExpectedConditions.elementToBeClickable(By.cssSelector(START_LEARN_CSS)), getWebDriver(), 10);        click(WaitTool.findElement(getWebDriver(), By.cssSelector(START_LEARN_CSS)));        sleep(3000);*/
        click(startLearningWe);
    }


}
