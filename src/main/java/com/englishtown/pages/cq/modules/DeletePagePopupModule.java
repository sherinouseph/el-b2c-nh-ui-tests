package com.englishtown.pages.cq.modules;

import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.WebElementHelper;
import com.englishtown.helpers.utils.TestUtil;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Top Right .. shows name of user ... if user click on it submenu shown .. signout
 *
 * http://usb-etcqqa2.englishtown.com:4502/siteadmin#/content/englishtown/gb/UK_NikolTestCQ/en
 *
 *
 *
 */
public class DeletePagePopupModule extends CqCoreModule {
    protected static final Logger logger = LoggerFactory.getLogger(DeletePagePopupModule.class);
    protected final String popupMainWindowCss = ".x-window.x-window-dlg";
    protected final String popupHeaderWeCss = popupMainWindowCss+" .x-window-header-text";
    protected final String popupBtnsWeCss = popupMainWindowCss+" .x-btn-mc button"; //$('.x-window.x-window-dlg .x-btn-mc button').text()   gets "OKYesNoCancel"
    /**.x-window.x-window-dlg
     * Main components
     *
     */
    @FindBy(css = popupMainWindowCss)
    public WebElement popupMainWindowWe;


    @FindBy(css = popupBtnsWeCss )
    public List<WebElement> popuButtonListWe; // 1=yes 2=no

    @FindBy(css = popupHeaderWeCss )
    public WebElement popupHeaderWe;

    public DeletePagePopupModule(WebDriver webDriver){
        super(webDriver);
    }
    public DeletePagePopupModule(WebDriver webDriver, String url) {
        super(webDriver, url);
    }
    public DeletePagePopupModule() {
        this(null, null);
    }

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public boolean simpleTest() {
        logger.info(" simpleTest() assertWebElementDisplayed ->websiteAppsMenuList and workflows ...! ");
        AssertHelper.assertWebElementDisplayed(popupHeaderWe);
        return true;
    }

    public ExpectedCondition getPageLoadedCondition() {
        return ExpectedConditions.visibilityOf(popupHeaderWe);
    }

    public void waitForPopupDisappear(){
        WaitTool.waitForCondition(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(popupMainWindowCss)), getWebDriver(), 7);
    }
    /**
     * Click on buttons based on the text
     * //$('.x-window.x-window-dlg .x-btn-mc button').text()   gets "OKYesNoCancel"
     * @param buttonText
     */
    public void click(String buttonText){
        logger.info("Click on pop up button with text :"+buttonText);
        //TODO some errors when this run on tear down ....
        buttonText = buttonText.toLowerCase();
        for(WebElement we : popuButtonListWe){
            String weText = TestUtil.getWebElementText(we);
            if(weText != null && StringUtils.equals(buttonText,weText.toLowerCase())){
                click(we);
                logger.warn("Button clicked on popup ["+weText+"]");
                break;
            }else {
                logger.error("Cant get WEB element text or btn text is not valid ....! so not deleting the file this time around ...!");
            }
        }
    }


}