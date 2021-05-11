package com.englishtown.pages.cq.modules;

import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.WebElementHelper;
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

import static org.hamcrest.Matchers.containsString;

/**
 * Click on new page opens a popup whre user can select templates and page name/title
 *
 * http://usb-etcqqa2.englishtown.com:4502/siteadmin#/content/englishtown/gb/UK_NikolTestCQ/en
 *
 *
 *
 */
public class CreateNewPageModule extends CqCoreModule {
    public static final Logger logger = LoggerFactory.getLogger(CreateNewPageModule.class);
    private final String templateEnglishLive2016Css = ".template-thumbnail[src*='templates/englishlive2016/thumbnail.png']";
    //todo http://stackoverflow.com/questions/3235013/how-to-use-jquery-in-selenium
    private final String CREATE_PAGE_CSS = "div[id*='cq-createdialog-']"; //"jquery=.x-window:visible:last"; //"div[id*='cq-createdialog-']"; // MAIN DIALOG POPUP
    public static int lastWeId; // size -1
    /**
     * Main components
     */
    //cq-gen277 :fist div not useful...second div all components in it :  cq-createdialog-0  create page
    @FindBy(id = CREATE_PAGE_CSS)
    public List<WebElement> createPageDialogWe; // all popup with we in it

    /**
     * Every time a new box opens it adds new elements and they are not cleard from dom html
     * $('.x-window-body .x-form-element input[name="title"]').eq(2).css('visibility')
     * = "visible"
     */
    @FindBy(css = CREATE_PAGE_CSS+" input[name='title']") //.x-window:visible:last input[name="title"]
    public List<WebElement> pageTitleWe;

    @FindBy(css = CREATE_PAGE_CSS+" input[name='label']")
    public List<WebElement> pageNameWe;

    @FindBy(css = templateEnglishLive2016Css)
    public List<WebElement> eLive2016TemplateWe;

//    @FindBy(id = CREATE_PAGE_ID)
//    public WebElement createWe;

//    @FindBy(id = "cq-gen268")   //+2 than create
//    public WebElement cancelWe;

    @FindBy(css = CREATE_PAGE_CSS+" .x-btn-mc")
    public List<WebElement> createAndCancelBtnWe;  //0 CREATE 1 CANCEL

    public CreateNewPageModule(WebDriver webDriver){
        super(webDriver);
    }
    public CreateNewPageModule(WebDriver webDriver, String url) {
        super(webDriver, url);
    }
    public CreateNewPageModule() {
        this(null, null);
    }

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public boolean simpleTest() {
        logger.info(" simpleTest() assertWebElementDisplayed ->websiteAppsMenuList and workflows ...! ");
        int weSize = getLastWebElementId(pageTitleWe);
        try{
            if(pageTitleWe != null || !pageTitleWe.isEmpty()){
                weSize = pageTitleWe.size();
                AssertHelper.assertWebElementDisplayed(pageTitleWe.get(weSize-1));
            }else {
                logger.error("WebElement is null or empty ...!");
            }
        }catch (Exception e){
            //logger.error("WebElement is null or empty ...! "+e.getCause());
            failTest("Page title element not found ...!; WebElement is null or empty ...!  "+e.getCause());
        }

        return true;
    }

    public ExpectedCondition getPageLoadedCondition() {
        //TODO
        return ExpectedConditions.visibilityOf(createAndCancelBtnWe.get(0));
    }

    /**
     * Use same str for title and name
     * @param pageTitleAndName
     */
    public void enterTitleAndName(String pageTitleAndName){
        logger.info("Enter page name and title ...! > "+pageTitleAndName);
        lastWeId = getLastWebElementId(pageTitleWe);
        WebElementHelper.sendKeys(getWebDriver(), pageTitleWe.get(lastWeId), pageTitleAndName, false);
        WebElementHelper.sendKeys(getWebDriver(), pageNameWe.get(lastWeId), pageTitleAndName, false);
    }

    public void clickCreate(){
        logger.info("clickCreate page ...!");
        lastWeId = getLastWebElementId(createAndCancelBtnWe);
        click(createAndCancelBtnWe.get(lastWeId -1));
    }

    public void clickCancel(){
        logger.info("clickCancel page ...!");
        lastWeId = getLastWebElementId(createAndCancelBtnWe);
        click(createAndCancelBtnWe.get(lastWeId));
    }

    public void selectTemplate(List<WebElement> templateWe){
        click(templateWe.get(lastWeId));
    }

    public void waitForCreatePageDisplayed(){
        getPageLoadedCondition();
    }

    public void waitForCreatePagePopupClosed(){
        WaitTool.waitForCondition(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(CREATE_PAGE_CSS)), getWebDriver(), 7);
    }

    public int getLastWebElementId(List<WebElement> webElements){
        try{
            if(webElements != null || !webElements.isEmpty()){
                lastWeId = webElements.size() - 1;
            }else {
                logger.error("WebElement is null or empty ...!");
                failTest("Page title element not found ...!; WebElement is null or empty ...!  ");
            }
        }catch (Exception e){
            //logger.error("WebElement is null or empty ...! "+e.getCause());
            failTest("Page element not found ...!; WebElement is null or empty ...!  "+e.getCause());
        }
        return lastWeId;
    }

}
