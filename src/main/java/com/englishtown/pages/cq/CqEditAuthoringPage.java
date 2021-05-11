package com.englishtown.pages.cq;
/**
 * Jan 2017
 * Clicking on a page will open it for authoring
 * left side shows all pictures
 * middle shows page content
 * and there is a popup menu with tabs and options to select CQ components .. e.g txt ... images .... fag
 *
 * http://usb-etcqqa2.englishtown.com:4502/cf#/content/englishtown/gb/en/lp/oe/auto-tests/autotest-newpage.html
 *
 * Note: middle main content uses iframe so need to switch first
 * wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector(".demo-frame")));
 */


import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WebElementHelper;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.pages.cq.modules.EditPageModule;
import com.englishtown.pages.cq.modules.InsertNewComponentModule;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.greaterThan;


public class CqEditAuthoringPage extends CqCorePage {
    public static final Logger logger = LoggerFactory.getLogger(CqEditAuthoringPage.class);
    public String pageUrl = CQ_QATEST_PAGE_URL ;
    //public EditPageModule editPageModule ;

    // can be a module
    public final String imagesQueryCss          = "#cfTab-Images-QueryBox";
    public final String imagesQueryTxtCss       = imagesQueryCss+" input";
    public final String imageSearchIconBtnCss   = imagesQueryCss+" img";
    // can be a module
    private static final String mainContentIframeName  = "cq-cf-frame";                         // id and name
    private final String dropContainerListCss   = ".cq-editrollover-insert-container";   // cq-cf-frame drop content here  id 0 or 1.. 2 is on the top
    //
    public final String componentAddedListCss                   = ".cq-wcm-edit [id*='main-parsys_']";     // latest added component is added on top ;its id =0
    public final String stageContainerToInsertComponentsListCss = ".cq-editrollover-insert-container";   // double click on this to add

    private int weUsedToDoubleClickId = 0;

    private InsertNewComponentModule insertNewComponentModule; //?
    /**
     * Main components
     *
     */
    @FindBy(css = imagesQueryTxtCss)
    public WebElement imagesQueryTxtWe;

    @FindBy(css = imageSearchIconBtnCss)
    public WebElement imageSearchIconBtnWe;

    @FindBy(css = dropContainerListCss)
    public List<WebElement>  dropContainerListWe;

    @FindBy(css = componentAddedListCss)
    public List<WebElement>  componentAddedListWe;


    @FindBy(css = stageContainerToInsertComponentsListCss)
    public List<WebElement>  containerToInsertComponentsListWE;

    public CqEditAuthoringPage(WebDriver webDriver){
        super(webDriver);
    }
    public CqEditAuthoringPage(WebDriver webDriver, String url) {
        super(webDriver, url);
    }
    public CqEditAuthoringPage() {
        this(null, null);
    }

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public boolean simpleTest() {
        logger.info(" simpleTest() ...! ");
        AssertHelper.assertWebElementDisplayed(dropContainerListWe.get(0) );
        //editPageModule.simpleTest();
        return true;
    }

    public ExpectedCondition getPageLoadedCondition() {
        return ExpectedConditions.visibilityOf(dropContainerListWe.get(0));
    }


    /**
     * Content of this page is in iFrame
     * @return
     */
    public static String getFrameName(){
        return mainContentIframeName;
    }

    /**
     * Element to be double clicked
     * @return
     */
    public WebElement getWeToInsertTo(int weToDoubleClickId){
        try{
            return containerToInsertComponentsListWE.get(weToDoubleClickId);
        }catch (Exception e){
            failTest("getWeToInsertTo  Can't get Web Element id ["+weToDoubleClickId+"] from list ...! >"+containerToInsertComponentsListWE+"; "+e.getMessage());
        }
        return null;
    }

    public void doubleClickOnWeToShowInsertPopup(int weToDoubleClickId){
        WebElementHelper.doubleClick(getWebDriver(), getWeToInsertTo(weToDoubleClickId));
        sleep(3000);
    }

    public int getNoOfAddedComponents(){
        int noOfComponents = 0;
        if(null != componentAddedListWe || !componentAddedListWe.isEmpty()){
            noOfComponents = componentAddedListWe.size();
            logger.info(" There are added components on the stage ...! size :"+noOfComponents);
            return noOfComponents;
        } else {
            logger.info(" There are NO added components ...! =0 or null we");
        }
        return noOfComponents;
    }

    /**
     * check component added ... reload page before
      * @param noOfElementsBefore
     */
    public void assertComponentAdded(int noOfElementsBefore) {
        AssertHelper.assertThat("No new component added on stage ....!", getNoOfAddedComponents(), greaterThan(noOfElementsBefore));

    }

    public WebElement getInsertedComponent(int componentId) {
        try {
            if (null != componentAddedListWe || !componentAddedListWe.isEmpty()) {
                return componentAddedListWe.get(componentId);
            } else {
                failTest("getInsertedComponent  Can't get Web Element id [" + componentId + "] from list ...! >" + componentAddedListWe + "; IS NULL or empty ...!");
            }
        } catch (Exception e) {
            failTest("getInsertedComponent  Can't get Web Element id [" + componentId + "] from list ...! >" + componentAddedListWe + "; " + e.getMessage());
        }
        return null;
    }
}
