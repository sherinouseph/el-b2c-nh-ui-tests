package com.englishtown.pages.cq.modules;

import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.JavaScriptHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.WebElementHelper;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.pages.cq.CqAction;
import com.englishtown.pages.cq.CqCorePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static com.englishtown.helpers.CaseInsensitiveSubstringMatcher.containsIgnoringCase;

/**
 * Action tool   bar above main stage content
 *
 * http://usb-etcqqa2.englishtown.com:4502/siteadmin#/content/englishtown/gb/UK_NikolTestCQ/en
 *
 *
 *
 */
public class ActionToolBarModule extends CqCoreModule {
    protected static final Logger logger = LoggerFactory.getLogger(ActionToolBarModule.class);
    protected int expectedNoOfAction = 8;
    protected String refreshPageTooltip = "Refresh Page List";
    protected String contentRefreshCss = "#cq-gen114";
    protected final String refreshToolTipCss = ".x-tip .x-tip-header"; //"#cq-siteadmin-grid-refresh #cq-gen114";
    protected final String loadingPopupCss = ".x-panel-bwrap .x-mask-loading";

    /**
     * Main components
     *
     */
    @FindBy(css = ".cq-siteadmin-grid .x-panel-tbar-noheader")
    public WebElement toolBarStageAllWe;

    //Refresh new copy paste delete move activate deactivate workflow tools help from 0 to 10
    @FindBy(css = "#cq-siteadmin-grid #cq-gen91 button")
    public List<WebElement> actionMenuList;  // actionList o to 10

    @FindBy(css = refreshToolTipCss) //"#cq-siteadmin-grid-refresh #cq-gen243")
    public WebElement refreshToolTipWe;

    @FindBy(css = loadingPopupCss) // div txt Loading ... pop up shown for few seconds
    public WebElement loadingPopupWe;



    public ActionToolBarModule(WebDriver webDriver){
        super(webDriver);
    }
    public ActionToolBarModule(WebDriver webDriver, String url) {
        super(webDriver, url);
    }
    public ActionToolBarModule() {
        this(null, null);
    }

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public boolean simpleTest() {
        logger.info(" simpleTest() assertWebElementDisplayed ->websiteAppsMenuList and workflows ...! ");
        AssertHelper.assertWebElementDisplayed(toolBarStageAllWe);
        AssertHelper.assertElementSizeMoreThanOrEqual(getWebDriver(), actionMenuList, expectedNoOfAction );
        return true;
    }

    public ExpectedCondition getPageLoadedCondition() {
        return ExpectedConditions.visibilityOf(toolBarStageAllWe);
    }

    public void waitForRefreshTooltipDisappear() {
        WaitTool.waitForCondition(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(loadingPopupCss)), getWebDriver(), 15);
        WaitTool.waitForCondition(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(refreshToolTipCss)), getWebDriver(), 15);
    }

    /**
     * Fail test if action name does not match the WebElement text
     * @param actionId
     * @param cqAction
     */
    private void validateWebElementTextMatchActionName(int actionId, CqAction cqAction){
        logger.info("Validate WebElement match the action by checking the text of webElement id["+ actionId+
                "] actionMenuList WebElement ["+actionMenuList.get(actionId)+"]"+" CqAction ["+cqAction.toString()+"]");
        if(actionId != 0) {
            AssertHelper.myAssertThat(getWebDriver(), "Is not the expected WebElement Text " + cqAction.toString() +
                            " message ....!", TestUtil.getWebElementText(actionMenuList.get(actionId)),
                    containsIgnoringCase(cqAction.toString()), true);
        }else {
            logger.info("is Refresh action and it has only the icon so no txt check done ...!");
        }
    }

    public void safeActionOperator(CqAction cqAction){
        int actionId = 0; // first action is refresh
        switch (cqAction) {
            case REFRESH    : logger.info("Perform Action ["+cqAction.REFRESH.toString()+"] ...!");
                actionId = 0;
                validateWebElementTextMatchActionName(actionId, cqAction);
                sleep(500);
                click(actionMenuList.get(actionId));                                                                                  // getWebDriver().findElement(By.cssSelector(refreshToolTipCss)).click();                                  //JavaScriptHelper.clickAtWebElementXY(getWebDriver(), actionMenuList.get(0));  //javaScriptClick(getWebDriver(), contentRefreshCss);//time issue click(actionMenuList.get(0));
                break;
            case NEW        : logger.info("Perform Action ["+cqAction.NEW.toString()+"] ...!");
                actionId = 1;
                validateWebElementTextMatchActionName(actionId, cqAction);
                click(actionMenuList.get(actionId));
                sleep(3000);
                break;
            case COPY       : logger.info("Perform Action ["+cqAction.values()+"] ...!");
                break;
            case PASTE      : logger.info("Perform Action ["+cqAction.values()+"] ...!");
                break;
            case DELETE     : logger.info("Perform Action ["+cqAction.values()+"] ...!");
                actionId = 4;
                validateWebElementTextMatchActionName(actionId, cqAction);
                click(actionMenuList.get(actionId));
                sleep(2000);
                break;
            case MOVE       : logger.info("Perform Action ["+cqAction.values()+"] ...!");
                break;
            case ACTIVATE   : logger.info("Perform Action ["+cqAction.values()+"] ...!");
                actionId = 6;
                validateWebElementTextMatchActionName(actionId, cqAction);
                click(actionMenuList.get(actionId));
                sleep(2000);
                break;
            case DEACTIVATE : logger.info("Perform Action ["+cqAction.values()+"] ...!");
                actionId = 7;
                validateWebElementTextMatchActionName(actionId, cqAction);
                click(actionMenuList.get(actionId));
                sleep(2000);
                break;
            case WORKFLOW   : logger.info("Perform Action ["+cqAction.values()+"] ...!");
                break;
            case TOOLS      : logger.info("Perform Action ["+cqAction.values()+"] ...!");
                break;
            case HELP       : logger.info("Perform Action ["+cqAction.values()+"] ...!");
                break;

            default         : logger.error("Invalid Action ["+cqAction+"] ...!");
                break;
        }

    }

    public void assertToolTipMessage(WebElement webElement, String tooltipMsg){
        AssertHelper.myAssertThat(getWebDriver(), "Is not the expected Tooltip message ....!",
                TestUtil.getWebElementText(webElement), containsIgnoringCase(tooltipMsg), true);
    }


}