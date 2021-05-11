package com.englishlive.tests.cqinterface.authoring.core;
/**
 * Created by nikol.marku on 1/3/2017.
 *    1.open page,
 *    2. add text component,
 *    2.a add  unique txt on this component,
 *    3.Activate page
 *    4. check live url [check txt is present and no 404];
 *    5 . deactivate page
 *    6. check live url shows 404 error and response then delete page/folder
 */
import com.englishlive.tests.cqinterface.core.BaseCqTest;
import com.englishtown.helpers.*;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.pages.cq.CqEditAuthoringPage;
import com.englishtown.pages.cq.CqWebSiteHomePage;
import com.englishtown.pages.cq.modules.CqMainStageContentModule;
import com.englishtown.pages.cq.modules.EditPageModule;
import com.englishtown.pages.cq.modules.InsertNewComponentModule;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static com.englishtown.helpers.CaseInsensitiveSubstringMatcher.containsIgnoringCase;
import static org.hamcrest.Matchers.greaterThan;


public abstract class BaseAuthoringCqTest extends BaseCqTest {
    private static final Logger logger = LoggerFactory.getLogger(BaseAuthoringCqTest.class);
    protected String testUrl;
    protected CqWebSiteHomePage cqWebSiteHomePage;
    protected CqEditAuthoringPage cqEditAuthoringPage;
    protected EditPageModule editPageModule;
    protected InsertNewComponentModule insertNewComponentModule;
    public static String uniqueTextOnPage="autotest_cq_";

    private int inlineId = 11;
    /**
     * All test are done in the test site getCQ_QATEST_MAINSITE_URL()
     */
    @BeforeClass
    protected void setUpLoginToCqAndGoToTestSiteAndCleanup(){
        setThreadSafeDriver();
        cqHomePage = openUrlAndLoginToCQ();
        openUrl(getWebDriver(),getCQ_LOGIN_URL() );
        sleep(3000);
        try {
            assertIsUrlContaining(getCQ_QATEST_MAINSITE_URL());
        }catch (AssertionError ae){
            failTest(" The test Folder is not found ...! [/content/englishtown/gb/en/lp/oe/auto-tests] ...!");
        }
        initCqWebSiteHomePage();
        try {
            setupCleanupTestFilesFolder();
            sleep(3000);
            initCqWebSiteHomePage();
        }catch (Exception e){
            failTest("Failed to clean up test folder ....! "+e.getMessage());
        }
    }

    @Test
    protected void refreshCqMainContent(){
        refresh_CqMainContent();
    }

    @Test (dependsOnMethods = "refreshCqMainContent")
    protected void create_TestFolder(){
        cqWebSiteHomePage.loadAllModules();
        assertIsUrlContaining(getCQ_QATEST_MAINSITE_URL());
        cqWebSiteHomePage.create_NewPageTemplate2016(FOLDER_NAME);
        sleep(3000);
        //ASSERT folder created or fail test here
        assertMainTestFileFolderCreated();
    }

    @Test (dependsOnMethods = "create_TestFolder")
    protected void create_NewPageOnTestFolder(){
        cqWebSiteHomePage.refresh_MainContent();
        cqWebSiteHomePage.actionToolBarModule.waitForRefreshTooltipDisappear();
        sleep(1000);
        openUrl(getWebDriver(),getCQ_QATEST_MAINSITE_URL()+"/"+FOLDER_NAME );
        sleep(3000);
        assertIsUrlContaining(getCQ_QATEST_MAINSITE_URL()+"/"+FOLDER_NAME);
        initCqWebSiteHomePage();
        cqWebSiteHomePage.create_NewPageTemplate2016(PAGE_TITLE);
        sleep(3000);
        //ASSERT file created or fail test here
        assertMainTestFileFolderCreated();
    }

    @Test(dependsOnMethods = "create_NewPageOnTestFolder")
    protected void openTestPage_add_inlineText_Component(){
        int componentAddId = 29; //
        openTestPageAddComponent(componentAddId);
    }

    @Test(dependsOnMethods = "openTestPage_add_inlineText_Component")
    protected void add_richText_Component(){
        editComponentAddText();
    }

    @Test(dependsOnMethods = "add_richText_Component")
    protected void activatePageAndOpenLivePage(){
        openUrl(getWebDriver(),getCQ_QATEST_MAINSITE_URL()+"/"+FOLDER_NAME );
        sleep(3000);
        initCqWebSiteHomePage();
        click(cqWebSiteHomePage.cqMainStageContentModule.firstCellTitleListWe.get(0));
        sleep(3000);
        cqWebSiteHomePage.activate_Page(PAGE_TITLE);
        sleep(5000);
    }

    @Test(dependsOnMethods = "activatePageAndOpenLivePage")
    protected void openActivatedPageCheckText(){
        openUrl(getWebDriver(),TEST_PAGE_LIVE_URL );
        String richTextAddedCss = "#main-parsys_richtext p";
        waitForElementVisibleAndClick(richTextAddedCss, 25);
        WebElement richTextAddedWe = findElement(By.cssSelector(".richtext [id*='main-parsys_richtext'] p"));
        AssertHelper.assertThat("New Component Text is not the expected one on live page ...!",getText(richTextAddedWe),
                containsIgnoringCase(uniqueTextOnPage) );
        sleep(1000);
    }

    @Test(dependsOnMethods = "openActivatedPageCheckText")
    protected void deActivatePage(){
        openUrl(getWebDriver(),getCQ_QATEST_MAINSITE_URL()+"/"+FOLDER_NAME );
        sleep(3000);
        initCqWebSiteHomePage();
        click(cqWebSiteHomePage.cqMainStageContentModule.firstCellTitleListWe.get(0));
        sleep(3000);
        cqWebSiteHomePage.deActivate_Page(PAGE_TITLE);
        sleep(5000);
    }

    @Test(dependsOnMethods = "deActivatePage")
    protected void openDeActivatedPageCheck404Shown(){
        openUrl(getWebDriver(),TEST_PAGE_LIVE_URL );
        String h1_404Css = ".stage h1";  //".primary .logo"   visibility of element located by By.cssSelector: .stage h1 - Wait time : 25'
        WaitTool.waitForElementVisible(getWebDriver(), By.cssSelector(h1_404Css), 25);
        WebElement h1Text404We = findElement( By.cssSelector(h1_404Css));
        AssertHelper.assertThat("New Component Text is not the expected one on live page ...!",getText(h1Text404We),
                containsIgnoringCase("404: PAGE NOT FOUND")  );
        sleep(1000);
    }

    @AfterClass
    protected void afterClassCleanup(){
        logger.warn("After Class is deleting main test folder");
        openUrl(getWebDriver(),getCQ_QATEST_MAINSITE_URL() );
        sleep(3000);
        assertIsUrlContaining(getCQ_QATEST_MAINSITE_URL());
        initCqWebSiteHomePage();
        try {
            setupCleanupTestFilesFolder();
            sleep(3000);
        }catch (Exception e){
            logger.error("Tear down Failed to clean up test folder ....! "+e.getMessage());
        }
        destroyDriver();
    }

    /*
     *
     ******************************************************************************************************************
     *
     *                                    Helpers
     *
     ******************************************************************************************************************
     *
     */
    protected void initCqWebSiteHomePage(){
        cqWebSiteHomePage = new CqWebSiteHomePage(getWebDriver());
    }

    /**
     * check there are files/folder on main conted and if yes delete it, all of them , then proceed wit the test
     *
     */
    protected void setupCleanupTestFilesFolder(){
        logger.info("Delete test folders ["+FOLDER_NAME+"] if exits...!");
        cqWebSiteHomePage.cqMainStageContentModule = new CqMainStageContentModule(getWebDriver());

        if(cqWebSiteHomePage.cqMainStageContentModule.isFilesPresentOnMainContent()){
            int titleListSize = cqWebSiteHomePage.cqMainStageContentModule.firstCellTitleListWe.size();
            logger.info("Number of files/folders before delete ["+titleListSize+"]");
            //Delete files/folders *
            for(WebElement we : cqWebSiteHomePage.cqMainStageContentModule.firstCellTitleListWe) {
                click(we);  // select the element on grid to delete
                sleep(1000);
                cqWebSiteHomePage.delete();
                cqWebSiteHomePage.deletePagePopupModule.waitForPopupDisappear();
                sleep(2000);
            }
            cqWebSiteHomePage.cqMainStageContentModule = new CqMainStageContentModule(getWebDriver());
            titleListSize = cqWebSiteHomePage.cqMainStageContentModule.firstCellTitleListWe.size();
            logger.info("Number of files/folders After delete actions ["+titleListSize+"]");
        }else {
            logger.info("CQ Main stage does not have and files shown on [\n\t\t\t"+getCQ_QATEST_MAINSITE_URL()+"]");
        }
    }

    /**
     *
     */
    protected void assertMainTestFileFolderCreated(){
        logger.info("assertMainTestFileFolderCreated ["+FOLDER_NAME+"] ...!");
        cqWebSiteHomePage.cqMainStageContentModule = new CqMainStageContentModule(getWebDriver());
        if(cqWebSiteHomePage.cqMainStageContentModule.isFilesPresentOnMainContent()){
            int titleListSize = cqWebSiteHomePage.cqMainStageContentModule.firstCellTitleListWe.size();
            logger.info("Main test folder ["+FOLDER_NAME+"] exist ...! -> Number of files/folders ["+titleListSize+"]");
        }else {
            failTest("Main Test File/Folder does not exist ...! Name ["+FOLDER_NAME+"]");
        }
        cqWebSiteHomePage.cqMainStageContentModule.checkFileIsCreatedAndShownOnMainContent(PAGE_TITLE);
    }


    public void refresh_CqMainContent(){
        cqWebSiteHomePage.refresh_MainContent();
        cqWebSiteHomePage.actionToolBarModule.waitForRefreshTooltipDisappear();
        sleep(3000);
        assertIsUrlContaining(getCQ_QATEST_MAINSITE_URL());  // make sure you still on QA
    }

    //page object used
    /**
     * For future use the component text or id ..
     * Currently uses static
     * @param componentAddId
     */
    protected void openTestPageAddComponent(int componentAddId){
        openUrl(getWebDriver(),getCQ_QATEST_PAGE_URL());
        sleep(3000);
        assertIsUrlContaining(getCQ_QATEST_PAGE_URL());
                    //wait and switch to main content frame
        WaitTool.waitForCondition( ExpectedConditions.frameToBeAvailableAndSwitchToIt(
                                                               CqEditAuthoringPage.getFrameName()), getWebDriver(), 15);
        cqEditAuthoringPage = new CqEditAuthoringPage(getWebDriver());
        cqEditAuthoringPage.simpleTest();

        int numberOfAddedComponentsBeforeInsert = cqEditAuthoringPage.getNoOfAddedComponents();
                    //double click to show insert popup
        cqEditAuthoringPage.doubleClickOnWeToShowInsertPopup(0);
                    // wait for we displayed first
        List<WebElement> componentListWe = WaitTool.waitForListElementsDisplayed(getWebDriver(),
                By.cssSelector(".cq-insertdialog .x-panel-body button"), 15);
                    // init insertPopup ...
        insertNewComponentModule = new InsertNewComponentModule(getWebDriver());
        insertNewComponentModule.simpleTest();
        insertNewComponentModule.scrollAddComponentToView(componentAddId);
        AssertHelper.assertWebElementDisplayed(insertNewComponentModule.getInsertComponent(componentAddId));
        click(insertNewComponentModule.getInsertComponent(componentAddId));
        sleep(500);

        click(getWebElementFromList(getWebDriver(),insertNewComponentModule.okCancelBtnListWe, "OK" ));
        sleep(2000);
                    // element should be added now
        cqEditAuthoringPage = new CqEditAuthoringPage(getWebDriver());        //List<WebElement> addedComponentAfterWe = WaitTool.waitForListElementsDisplayed(getWebDriver(), By.cssSelector(componentAddedCss), 20, 0  );
        int noOfComponentsAfterAdd = 0;
                    // assert element added
        AssertHelper.assertThat("New Component is NOT added on stage ...!",cqEditAuthoringPage.getNoOfAddedComponents(),
                                                                    greaterThan(numberOfAddedComponentsBeforeInsert) );
    }

    /**
     *
     */
    protected void editComponentAddText(){
        cqEditAuthoringPage = new CqEditAuthoringPage(getWebDriver());
        cqEditAuthoringPage.simpleTest();
        //right click
        WebElementHelper.rightClick(getWebDriver(), cqEditAuthoringPage.getInsertedComponent(0) );
        sleep(2000);
        List<WebElement> popupMenuItemListWe = WaitTool.waitForListElementsDisplayed(getWebDriver(),
                By.cssSelector(".x-menu .x-menu-item-text"), 15); // 0-7 id10=Edit .. cat ...
        logger.info("14th Element text is :"+popupMenuItemListWe.get(0).getText());
        WebElementHelper.arrowAndEnter(getWebDriver(), 1);
        sleep(2000);
        // this is in an iFrame .... somehow driver is on it ... no need to go to it
        getWebDriver().getPageSource();
        try {
            getWebDriver().switchTo().frame(findElement(By.tagName("iframe"), 7));
        }catch (Exception e){
            e.printStackTrace();
        }
        WebElement txtComponentWe = findElement(By.id("CQrte"), 7);
        uniqueTextOnPage = uniqueTextOnPage+TestUtil.getSysTime();
        logger.info(" uniqueTextOnPage -["+uniqueTextOnPage+"]-");
        WebElementHelper.sendKeys(getWebDriver(), txtComponentWe, uniqueTextOnPage, false);
        sleep(3000);
        // need to go one frame up .. ok btn = .x-window-footer
        getWebDriver().switchTo().parentFrame();
        sleep(3000);
        //WaitTool.waitForCondition( ExpectedConditions.frameToBeAvailableAndSwitchToIt(
                //CqEditAuthoringPage.getFrameName()), getWebDriver(), 15);
        //sleep(5000);
        List<WebElement> helpOkCancelBtnListWe = WaitTool.findElements(getWebDriver(),
                By.cssSelector(".x-window-footer .x-btn-mc"));
        click(helpOkCancelBtnListWe.get(3));//ok
        sleep(3000);
        //todo test fail here
        WebElement richTextAddedWe = findElement(By.cssSelector(".richtext [id*='main-parsys_richtext'] p"));
        AssertHelper.assertThat("New Component Text is not the expected one ...!",getText(richTextAddedWe),
                containsIgnoringCase(uniqueTextOnPage) );
    }

    /*******************************************************************************************************************
     *
     */
    protected void openTestPageAddComponentNoPageObject(){
        openUrl(getWebDriver(),getCQ_QATEST_PAGE_URL());
        sleep(13000);
        assertIsUrlContaining(getCQ_QATEST_PAGE_URL());

        WaitTool.waitForCondition( ExpectedConditions.frameToBeAvailableAndSwitchToIt(
                                                            CqEditAuthoringPage.getFrameName()), getWebDriver(), 15);
        // check how many components exits
        String componentAddedCss = ".cq-wcm-edit [id*='main-parsys_']"; // latest add is id =0
        List<WebElement> componentsWe = WaitTool.findElements(getWebDriver(),By.cssSelector(componentAddedCss) );
        int noOfComponentsBeforeAdd = 0;
        if(null != componentsWe || !componentsWe.isEmpty()){
            noOfComponentsBeforeAdd = componentsWe.size();
            logger.info(" There are added components on the stage before test adds 1...! size :"+noOfComponentsBeforeAdd);
        }

        List<WebElement> toWeList = WaitTool.findElements(getWebDriver(), By.cssSelector( ".cq-editrollover-insert-container"));
        WebElement toWe = toWeList.get(0);
        WebElementHelper.doubleClick(getWebDriver(), toWe);
        sleep(5000);

        int componentId = 29; // Text Box
        List<WebElement> componentListWe = WaitTool.waitForListElementsDisplayed(getWebDriver(),
                By.cssSelector(".cq-insertdialog .x-panel-body button"), 15);

        WebElement componentWe = componentListWe.get(componentId);
        Point insertComponentPoint = componentWe.getLocation(); //top left hand corner

        List<WebElement> vewPortWebElement = WaitTool.findElements(getWebDriver(), By.cssSelector(".cq-insertdialog .x-window-bwrap .x-panel-body") ); // scroll popup
        int vewPortHeight  = vewPortWebElement.get(1).getSize().getHeight();
        Point vewPortPoint = vewPortWebElement.get(1).getLocation();

        logger.info("vewPortPoint ....... ["+vewPortPoint.toString()+"]");
        logger.info("insertComponentPoint ["+insertComponentPoint.toString()+"]");
        int centerRegulator = vewPortHeight/2; // half of popup view
        int scrollingPixels = (insertComponentPoint.getY() - vewPortPoint.getY())-centerRegulator;
        logger.info("scrollingPixels ["+scrollingPixels+"]");

        JavaScriptHelper.scrollInsidePopupWindow(getWebDriver(),vewPortWebElement.get(1), scrollingPixels, ScrollDirection.VERTICALLY);
        AssertHelper.assertWebElementDisplayed(componentWe);
        click(componentWe);
        sleep(1000);

        List<WebElement> okCancelBtnList = WaitTool.waitForListElementsDisplayed(getWebDriver(),
                By.cssSelector(".cq-insertdialog .x-toolbar-right-row .x-btn-mc button"), 20);
        WebElement okBtnWe = getWebElementFromList(getWebDriver(), okCancelBtnList, "OK");//okCancelBtnList.get(1); // image
        click(okBtnWe);
        sleep(5000);

        //check added
        List<WebElement> addedComponentAfterWe = WaitTool.waitForListElementsDisplayed(getWebDriver(),
                By.cssSelector(componentAddedCss), 20 );
        int noOfComponentsAfterAdd = 0;
        if(null != addedComponentAfterWe || !addedComponentAfterWe.isEmpty()){
            noOfComponentsAfterAdd = addedComponentAfterWe.size();
            logger.info(" There are components on the stage ...! no :"+noOfComponentsAfterAdd);
        }
        AssertHelper.assertThat("No new component added on stage ....!",noOfComponentsAfterAdd , greaterThan(noOfComponentsBeforeAdd) );
    }


}



//getWebDriver().switchTo().frame(driver.findElement(By.tagName("iframe")));
//getWebDriver().switchTo().frame(1);
//driver.switchTo().parentFrame();
//driver.switchTo().defaultContent();
//WebElement txtComponentWe = findElement( By.id("CQrte"), 7);
//WaitTool.waitForCondition(ExpectedConditions.frameToBeAvailableAndSwitchToIt(txtComponentWe),getWebDriver(),15);
//document.querySelector('iframe').contentDocument.body.querySelector('#some-element').style.background-color = 'red';
// //iframe//div[@id = 'abcdef']