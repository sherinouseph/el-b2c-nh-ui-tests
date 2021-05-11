package com.englishtown.pages.cq.modules;

import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.pages.cq.CqAction;
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
 * On Edit page there is a pop up menu with all the content and page actions [del .. edit ... etc]
 *
 * http://usb-etcqqa2.englishtown.com:4502/cf#/content/englishtown/gb/en/lp/oe/auto-tests/autotest-newpage.html
 *
 *
 *
 */
public class EditPageModule extends CqCoreModule {
    protected static final Logger logger = LoggerFactory.getLogger(EditPageModule.class);
    //#cq-sk .x-window-bwrap
    private final String popupMenuMainCss       = "#cq-sk";                                          // top popup main menu bar .. all content
    private final String popupMenuSubMainCss    = popupMenuMainCss+" .x-window-bwrap";               // contains tabs and all components
    private final String bottomToolbarListCss   = popupMenuSubMainCss+" .x-toolbar-left .x-btn-mc";  // [0]edit [1]preview [2]design [4]scafolding [7]site [8]refresh
    private final String allTabsAndContentCss   = popupMenuMainCss+"-tabpanel";                      // all tabs and cq components
                                                                                                    // All tab list first selected by default ... 5 items [components page info versioning workflow]   $('#cq-sk-tabpanel .x-tab-panel-header .x-tab-with-icon')
    private final String allTabsListCss         = allTabsAndContentCss+" .x-tab-panel-header .x-tab-with-icon";
    private final String tabContentListCss      = allTabsAndContentCss+" .x-panel-body button";                         // all tabs component action  $('#cq-sk-tabpanel .x-panel-body button')               $('#cq-sk-tabpanel .x-tab-panel-body .x-btn-noicon button.x-btn-text')   41


    /**
     * Main components
     *
     */
    @FindBy(css = popupMenuMainCss)
    public WebElement popupMenuMainWe;

    @FindBy(css = popupMenuSubMainCss)
    public WebElement popupMenuSubMainWe;

    @FindBy(css = bottomToolbarListCss)
    public List<WebElement> bottomToolbarListWe;

    @FindBy(css = allTabsListCss)
    public List<WebElement> allTabsListWe;

    // EF component list
    @FindBy(css = tabContentListCss)
    public List<WebElement> tabContentListWe;  //inline text id=11 ; reach text id=26

    public EditPageModule(WebDriver webDriver){
        super(webDriver);
    }
    public EditPageModule(WebDriver webDriver, String url) {
        super(webDriver, url);
    }
    public EditPageModule() {
        this(null, null);
    }

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public boolean simpleTest() {
        logger.info(" simpleTest() assertWebElementDisplayed ->author popup  ...! ");
        AssertHelper.assertWebElementDisplayed(popupMenuMainWe);
        AssertHelper.assertElementSizeMoreThanOrEqual(getWebDriver(), tabContentListWe, 30 );
        return true;
    }

    public ExpectedCondition getPageLoadedCondition() {
        return ExpectedConditions.visibilityOf(popupMenuMainWe);
    }


    /**
     *
     */


}