package com.englishtown.pages.cq;
/**
 * Created by nikol.marku on 12/29/2016.
 * After login and selected uk test site site this page is shown
 * This is a composite page with modules :
 * ActionToolBarModule
 * CqLeftSideMenuModule
 * CqMainStageContentModule
 * UserModule
 *
 *
 *
 */
import com.englishtown.helpers.WaitTool;
import com.englishtown.pages.cq.modules.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


public class CqWebSiteHomePage extends CqCorePage {
    public static final Logger logger = LoggerFactory.getLogger(CqWebSiteHomePage.class);

    /**
     * Main components [ composition ]
     */
    public ActionToolBarModule actionToolBarModule;
    public CqLeftSideMenuModule cqLeftSideMenuModule;
    public CqMainStageContentModule cqMainStageContentModule;
    public SearchTabModule searchTabModule;
    public UserModule userModule;
    public CreateNewPageModule createNewPageModule;
    public DeletePagePopupModule deletePagePopupModule;

    public CqWebSiteHomePage(WebDriver webDriver){
        super(webDriver);
        loadAllModules();
    }
    public CqWebSiteHomePage(WebDriver webDriver, String url) {
        super(webDriver, url);
    }
    public CqWebSiteHomePage() {
        this(null, null);
    }
    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public boolean simpleTest() {
        logger.info(" simpleTest() for all modules uses ...! ");
        actionToolBarModule.simpleTest();
        cqLeftSideMenuModule.simpleTest();
        cqMainStageContentModule.simpleTest();
        searchTabModule.simpleTest();
        userModule.simpleTest();

        return true;
    }

    public void loadAllModules(){
        logger.info("Load/init all modules ....!");
        actionToolBarModule         = new ActionToolBarModule(getWebDriver());
        //cqLeftSideMenuModule        = new CqLeftSideMenuModule(getWebDriver());
        cqMainStageContentModule    = new CqMainStageContentModule(getWebDriver());
        //searchTabModule             = new SearchTabModule(getWebDriver());
        //userModule                  = new UserModule(getWebDriver());
    }

    /**
     * Click refresh button on main CQ content and check tooltip refreshed
     */
    public void refresh_MainContent(){
        logger.info("Start refresh ....!");
        actionToolBarModule.safeActionOperator(CqAction.REFRESH);
        WaitTool.waitForCondition(ExpectedConditions.visibilityOf(actionToolBarModule.refreshToolTipWe),
                getWebDriver(), 10);
        sleep(500);
        logger.info("CQ refreshed ....!");
    }

    /**
     * Create new page based on template  2016  eLive2016TemplateWe
     */
    public void create_NewPageTemplate2016(String pageNameAndTitle){
        logger.info("Start createNewCqPageTemp2016 ....!");
        actionToolBarModule.safeActionOperator(CqAction.NEW);
        createNewPageModule = new CreateNewPageModule(getWebDriver());
        createNewPageModule.getPageLoadedCondition();
        logger.info("CQ create page popup should be shown  ....!");
        createNewPageModule.enterTitleAndName(pageNameAndTitle);           //createNewPageModule.PAGE_TITLE);
        createNewPageModule.selectTemplate(createNewPageModule.eLive2016TemplateWe);        //createNewPageModule.eLive2016TemplateWe);
        sleep(500);
        createNewPageModule.clickCreate();
        createNewPageModule.waitForCreatePagePopupClosed();
        logger.info("New page should be created, shown on tree menu and main content list ....!");
    }

    /**
     * Activate page
     * go to page main folder and use top menu .. click page item an click activate .. confirm it
     * @param pageNameAndTitle
     */
    public void activate_Page(String pageNameAndTitle){
        logger.info("Start activate_Page ....! ["+pageNameAndTitle+"]");
        actionToolBarModule.safeActionOperator(CqAction.ACTIVATE);
        logger.info("Page should be activated ...!");
    }

    /**
     * Deactivate page
     * go to page main folder and use top menu .. click page item an click deactivate .. confirm it
     * @param pageNameAndTitle
     */
    public void deActivate_Page(String pageNameAndTitle){
        logger.info("Start activate_Page ....! ["+pageNameAndTitle+"]");
        String deActivaPageMainCss= ".x-window";
        String deActivaYesNoBtnCss= deActivaPageMainCss+" .x-toolbar-left-row .x-btn-text";
        List<WebElement> yesNoBtnListWe = null;

        actionToolBarModule.safeActionOperator(CqAction.DEACTIVATE);
        sleep(1000);

        try{
            WaitTool.waitForElementVisible(getWebDriver(), By.cssSelector(deActivaPageMainCss), 15);
            yesNoBtnListWe = WaitTool.findElements(getWebDriver(), By.cssSelector(deActivaYesNoBtnCss));
            click(yesNoBtnListWe.get(1)); // 1 is the yes btn
        }catch (Exception e){
            failTest("Page not DeActivated ....! Popup window, yes no Buttons not found ...! "+e.getMessage());
        }
        logger.info("Page should be activated ...!");
    }

    /**
     * delete files or folders on temtest folder if exist
     */
    public void delete(){
        logger.info("Start delete ....!");
        actionToolBarModule.safeActionOperator(CqAction.DELETE);
        deletePagePopupModule = new DeletePagePopupModule(getWebDriver());
        deletePagePopupModule.click("yes");
        sleep(2000);
        logger.info("Page should be Deleted ...!");
    }


}
