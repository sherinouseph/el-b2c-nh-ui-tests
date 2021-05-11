package com.englishtown.pages.common.school.enrolmentui;
/**
 * User click start Enroll on this page and  Enrolment page shown with few steps user has to select
 * User: nikol.marku
 * Date: 16/01/19
 *
 *
 */
import com.englishtown.helpers.AssertHelper;
import com.englishtown.newhouse.school.pages.core.BaseSchoolPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class NewHouseStartEnrolmentPage extends BaseSchoolPage {

    public static final Logger logger = LoggerFactory.getLogger(NewHouseStartEnrolmentPage.class);
    public static final String enrolmentPageUrl = "/1/enrollment/";

    public final String teacherImageCss        = "[class^='welcome-step_'] [class^='img_']";
    public final String headerCss              = "[class^='welcome-step_'] .header"; //
    public final String subHeaderCss           = "div [class^='body_']";
    public final String startEnrollmentBtnCss  = "[class^='welcome-step_'] button"; //By.tagName("button")

    @FindBy(css = teacherImageCss)
    public WebElement teacherImageWe ;

    @FindBy(css = headerCss)
    public WebElement headerWe ;

    @FindBy(css = subHeaderCss)
    public WebElement subHeaderWe ;

    @FindBy(css = startEnrollmentBtnCss)
    public WebElement startEnrollmentBtnWe ;


    public NewHouseStartEnrolmentPage(WebDriver webDriver){
        super(webDriver);
    }

    public NewHouseStartEnrolmentPage(WebDriver webDriver, String url) {
        super(webDriver, url);
    }

    public NewHouseStartEnrolmentPage(WebDriver webDriver, int waitTimeSec) {
        super(webDriver, waitTimeSec);
    }

    public NewHouseStartEnrolmentPage() {
        this(null, null);
    }

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public ExpectedCondition getPageLoadedCondition() {
        return ExpectedConditions.visibilityOf(startEnrollmentBtnWe);
    }

    public String getPageUrl() {
        return enrolmentPageUrl;
    }


    public boolean simpleTest() {
        logger.info(" simpleTest() ....!");
        AssertHelper.assertWebElementDisplayed(startEnrollmentBtnWe);
        return true;
    }

    @Override
    public boolean checkAllPageComponentsDisplayed() {
        logger.info("checkAllPageComponentsDisplayed ...!");
        checkAllPageComponentsDisplayed(headerWe, subHeaderWe, startEnrollmentBtnWe, teacherImageWe);
        return true;
    }

    public void startEnrolment(){
        /*WaitTool.waitForCondition(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(startEnrollmentBtnCss)),
                getWebDriver(), WaitToolConfig.MED_WAIT_4_ELEMENT25);
        WaitTool.waitForCondition(ExpectedConditions.elementToBeClickable(By.cssSelector(startEnrollmentBtnCss)),
                getWebDriver(), WaitToolConfig.DEFAULT_WAIT_4_ELEMENT);*/
        click(startEnrollmentBtnWe);
        sleep(500);
    }


}
