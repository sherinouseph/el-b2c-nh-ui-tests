package com.englishtown.pages.cq.modules;

import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WebElementHelper;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.pages.cq.CqCorePage;
import com.englishtown.tests.core.BaseTestHelper;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static com.englishtown.helpers.CaseInsensitiveSubstringMatcher.containsIgnoringCase;
import static org.hamcrest.Matchers.containsString;

/**
 * main stage content
 *
 * http://usb-etcqqa2.englishtown.com:4502/siteadmin#/content/englishtown/gb/UK_NikolTestCQ/en
 *
 *
 *
 */
public class CqMainStageContentModule extends CqCoreModule {
    public static final Logger logger = LoggerFactory.getLogger(CqMainStageContentModule.class);


    private static String mainSiteName = "auto-tests";

    /**
     * Main components
     */
    @FindBy(css = "#cq-gen92 .x-grid3-cell-inner.x-grid3-col-title")
    public List<WebElement> firstCellTitleListWe;   // = "English Master (en)"  for QA

    public CqMainStageContentModule(WebDriver webDriver){
        super(webDriver);
    }
    public CqMainStageContentModule(WebDriver webDriver, String url) {
        super(webDriver, url);
    }
    public CqMainStageContentModule() {
        this(null, null);
    }

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public boolean simpleTest() {
        logger.info(" simpleTest() assertWebElementDisplayed ->websiteAppsMenuList and workflows ...! ");
        AssertHelper.assertWebElementDisplayed(firstCellTitleListWe.get(0));
        return true;
    }

    public ExpectedCondition getPageLoadedCondition() {
        return ExpectedConditions.visibilityOf(firstCellTitleListWe.get(0));
    }

    /**
     * On main content module a list of pages is shown if they exits
     * on : http://usb-etcqqa2.englishtown.com:4502/siteadmin#/content/englishtown/gb/en/lp/oe/auto-tests
     * check firstCellTitleListWe is null
     */
    public boolean isFilesPresentOnMainContent(){
        try {
            if (firstCellTitleListWe == null || firstCellTitleListWe.isEmpty()) {
                logger.info("firstCellTitleListWe is null or empty ...! CQ main content is empty, no pages shown ...!");
                return false;
            } else {
                logger.info("firstCellTitleListWe is NOT null or empty ...! There are pages/folders on main content seciton ...!");

            }
        }catch (Exception e){
            logger.error("isTempTestFilePresent exceptions, Cant decide if file exist ... "+e.getCause());
        }
        return true;
    }

    public boolean checkFileIsCreatedAndShownOnMainContent(String fileFolderNameCreated){
        logger.info("checkFileNodeIsCreatedAndShownOnTree Name ["+fileFolderNameCreated+"]");
        boolean foundFileCreated = false;
        int weId = -1;
        try {
            for (WebElement we : firstCellTitleListWe) {
                foundFileCreated = false;
                weId++;
                String tempFileFolderName = TestUtil.getWebElementText(we);
                logger.info("current node(file or folder) Name [" + tempFileFolderName + "]");
                if (StringUtils.equals(fileFolderNameCreated, tempFileFolderName)) {
                    logger.info("Match found ...! File created [" + fileFolderNameCreated + "] WE id is [" + weId + "]");
                    foundFileCreated = true;
                    return true;
                }
            }
        }catch (Exception e){
            if(!foundFileCreated) {
                failTest(fileFolderNameCreated + " > this File or Folder Name could not be checked if exist  ....! "+e.getCause());
            }
        }
        logger.warn("File not created ....!");
        return false;

    }

}
