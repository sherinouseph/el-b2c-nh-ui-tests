package com.englishtown.pages.cq.modules;

import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.JavaScriptHelper;
import com.englishtown.helpers.ScrollDirection;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * On Edit page if you double click on a stage components a popup "Insert new .." is shown;
 * Showing all the allowed components for the template used ... 2016 templ *
 * http://usb-etcqqa2.englishtown.com:4502/cf#/content/englishtown/gb/en/lp/oe/auto-tests/autotest-newpage.html
 *
 *
 *
 */
public class InsertNewComponentModule extends CqCoreModule {
    protected static final Logger logger = LoggerFactory.getLogger(InsertNewComponentModule.class);
    public final String cqInsertdialogMainCss   = ".cq-insertdialog";                                                   //  popup main  .. all content
    public final String allowedComponentListCss = cqInsertdialogMainCss+" .x-panel-body button";                        // contains list of components in insert popup
    public final String viewPortWeListCss       = cqInsertdialogMainCss+" .x-window-bwrap .x-panel-body";               // popup scroll section; used for scrolling
    private final String okCancelBtnListCss     = cqInsertdialogMainCss+" .x-toolbar-right-row .x-btn-mc button";       // OK Cancel
    //
    private int textBoxComponentId = 29; //allowedComponentListCss[29]

    /**
     * Main components
     *
     */
    @FindBy(css = cqInsertdialogMainCss)
    public WebElement cqInsertdialogMainWe;

    @FindBy(css = allowedComponentListCss)
    public List<WebElement> allowedComponentListWe;

    @FindBy(css = viewPortWeListCss)
    public List<WebElement> viewPortWeListWe;

    @FindBy(css = okCancelBtnListCss)
    public List<WebElement> okCancelBtnListWe;


    public InsertNewComponentModule(WebDriver webDriver){
        super(webDriver);
    }
    public InsertNewComponentModule(WebDriver webDriver, String url) {
        super(webDriver, url);
    }
    public InsertNewComponentModule() {
        this(null, null);
    }

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public boolean simpleTest() {
        logger.info(" simpleTest() assertWebElementDisplayed ->author popup  ...! ");
        AssertHelper.assertWebElementDisplayed(cqInsertdialogMainWe);
        //AssertHelper.assertElementSizeMoreThanOrEqual(getWebDriver(), allowedComponentListWe, 10 );
        return true;
    }

    public ExpectedCondition getPageLoadedCondition() {
        return ExpectedConditions.visibilityOf(cqInsertdialogMainWe);
    }

    public int getTextBoxComponentId() {
        return textBoxComponentId;
    }

    /**
     *
     * @param componentId
     * @return
     */
    public Point getInsertComponentPoint(int componentId) {
        try {
            return getInsertComponent(componentId).getLocation();
        }catch (Exception e){
            failTest("getInsertComponentPoint Can Not Get the component X and Y coordinates ...! id>"+componentId+"; "+e.getMessage());
        }
         return null;
    }

    /**
     *
     * @param componentId
     * @return
     */
    public WebElement getInsertComponent(int componentId){
         try {
             return allowedComponentListWe.get(componentId);
         }catch (Exception e){
             failTest("getInsertComponent Can Not Get the component to insert from the list ...! >"+allowedComponentListWe+" id>"+componentId+"; "+e.getMessage());
         }
         return null;
    }

    /**
     *
      * @return
     */
    public int getViewPortHeight(){
        try {
            int height = viewPortWeListWe.get(1).getSize().getHeight();
            if (height == 0) {
                failTest("getViewPortHeight size/Height is zero ... INVISIBLE ...! >id-1 "+viewPortWeListWe+"; "); //throw new IllegalArgumentException("Argument 'divisor' is 0");
            }
        }catch (Exception e){
            failTest("getViewPortHeight Can Not Get the component  size/Height ...! >id-1 "+viewPortWeListWe+"; "+e.getMessage());
        }
        return -1;
    }

    /**
     *
     * @return
     */
    public Point getViewPortPoint(){
        try {
            return  viewPortWeListWe.get(1).getLocation();
        }catch (Exception e){
            failTest("getViewPortPoint Can Not Get the component  location ...! >id-1 "+viewPortWeListWe+"; "+e.getMessage());
        }
        return null;
    }

    /**
     *
     * @return
     */
    public int getViewPortCentre(){
        try {
            if (getViewPortHeight() == 0) {
                throw new IllegalArgumentException("Argument 'divisor' is 0");
            }
            return getViewPortHeight()/2;
        }catch (ArithmeticException e){
            failTest("getViewPortCentre Can Not Get the component/2 ...! >"+viewPortWeListWe+"; "+e.getMessage());
        }
        return -1;
    }

    /**
     *
     * @param addComponentId
     * @return
     */
    public int getAddComponentScrollPixels(int addComponentId){
        int scrollPixels = 0;
        try {
            scrollPixels = (getInsertComponentPoint(addComponentId).getY() - getViewPortPoint().getY())- getViewPortCentre();
            if (scrollPixels > -2 || scrollPixels < 2) {
                logger.info("getAddComponentScrollPixels ... No need to scroll  ... scrollPixels  1 to -1");
                scrollPixels = 0;
            }
        }catch (ArithmeticException e){
            failTest("getViewPortCentre Can Not Get the component/2 ...! >"+viewPortWeListWe+"; "+e.getMessage());
        }
        return scrollPixels;
    }


    /**
     *
     * @param addComponentId
     */
    public void scrollAddComponentToView(int addComponentId) {
        JavaScriptHelper.scrollInsidePopupWindow(getWebDriver(), viewPortWeListWe.get(1),
                getAddComponentScrollPixels(addComponentId), ScrollDirection.VERTICALLY);

    }



}