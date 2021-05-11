package com.englishtown.pages.cq.modules;

import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WebElementHelper;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.pages.cq.CqCorePage;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.hamcrest.Matchers.containsString;

/**
 * Left side menu shows a tree structure
 *
 * http://usb-etcqqa2.englishtown.com:4502/siteadmin#/content/englishtown/gb/UK_NikolTestCQ/en
 *
 *  #extdd-213  auto-test folder id to get the text
 *
 */
public class CqLeftSideMenuModule extends CqCoreModule {
    public static final Logger logger = LoggerFactory.getLogger(CqLeftSideMenuModule.class);
    private final String filesFoldersNikolTestCqCss = "#cq-gen341 #cq-gen404 a span";  // list the folders and files under UK_NikolTestCQ  one file is called test2016

    /**
     * Main components
     */
    @FindBy(className = "cq-siteadmin-tree")
    public WebElement siteAdminBaseTree;   // include all nodes and refresh button in the top

    @FindBy(id = "cq-siteadmin-tree-refresh")
    public WebElement menuTreeRefreshBtn;   //Top left refresh btn

    /**
     * All test done on this folder
     */
    @FindBy(id = "extdd-667")
    public WebElement autoTestMainFolder;   //Top tree element  #/content/englishtown/gb/en/lp/oe/auto-tests
                                            //    @FindBy(id = "extdd-108")
                                            //    public WebElement ukNikolTestCqSite;
    @FindBy(css = "a[title='Workflows']")
    public WebElement workflows;  // right side of page

    @FindBy(css = filesFoldersNikolTestCqCss)
    public List<WebElement> filesFoldersNikolTestCqFolderWe;   // list of files/lolders under nikol qa test


    public CqLeftSideMenuModule(WebDriver webDriver){
        super(webDriver);
    }
    public CqLeftSideMenuModule(WebDriver webDriver, String url) {
        super(webDriver, url);
    }
    public CqLeftSideMenuModule() {
        this(null, null);
    }

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public boolean simpleTest() {
        logger.info(" simpleTest() assertWebElementDisplayed ->websiteAppsMenuList and workflows ...! ");
        AssertHelper.assertWebElementDisplayed(autoTestMainFolder);
        AssertHelper.assertWebElementDisplayed(menuTreeRefreshBtn);

        return true;
    }

    public ExpectedCondition getPageLoadedCondition() {
        return ExpectedConditions.visibilityOf(autoTestMainFolder);
    }

    public void checkFileNodeIsCreatedAndShownOnTree(String fileFolderNameCreated) throws Exception{
        logger.info("checkFileNodeIsCreatedAndShownOnTree Name ["+fileFolderNameCreated+"]");
        boolean foundFileCreated = false;
        int weId = -1;

        for(WebElement we : filesFoldersNikolTestCqFolderWe){
            foundFileCreated = false;
            weId++;
            String tempFileFolderName = TestUtil.getWebElementText(we);
            logger.info("current node(file or folder) Name ["+tempFileFolderName+"]");
            if(StringUtils.equals(fileFolderNameCreated, tempFileFolderName)){
                logger.info("Match found ...! File created ["+fileFolderNameCreated+"] WE id is ["+weId+"]");
                foundFileCreated = true;
                break;
            }
        }
        if(!foundFileCreated)
            failTest(fileFolderNameCreated+" File or Folder Name is not created ....!");
    }
}
