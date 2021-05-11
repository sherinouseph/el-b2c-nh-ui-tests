package com.englishtown.helpers;
/**
 * Helper method to deal with browser windows, and alert windows
 *
 *
 * Created by nikol.marku on 28/05/2015.
 */
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.pages.core.BasePage;
import com.englishtown.tests.core.BaseTest;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;


public class WebDriverWindowHelper {
    private static final Logger log = LoggerFactory.getLogger(WebDriverWindowHelper.class);

    /*********************************************************************
     * Switch to window Safe
     *********************************************************************/
    public static void switchToWindow(WebDriver driver, int windowId)  {
        try {
            ArrayList<String> handlers = new ArrayList(driver.getWindowHandles());
            if(handlers !=null) {
                if (windowId >-1 && windowId <= handlers.size()) {
                    driver.switchTo().window(handlers.get(windowId));
                    log.info(" switched To window ID : "+windowId);
                }else {
                    log.error(" Window id does not exist - OutOfRange, windowID: " + windowId + " current window list size : "+handlers.size());
                }
            } else {
                log.error("Can not Switch windows as window handler is null ");
            }
        }catch ( IndexOutOfBoundsException ioobe){
            log.error(" switchToWindow IndexOutOfBoundsException  : "+ TestUtil.getExceptionFirstLine(ioobe) );
        }
    }

    public static void switchToWindowUrl(WebDriver driver, String urlContains, int waitTimeSec){
        try {
            for (int i = 0; i < waitTimeSec; i++) {
                ArrayList<String> handlers = new ArrayList(driver.getWindowHandles());

                if (handlers.size() > 1) {
                    for (String handler : handlers) {
                        driver.switchTo().window(handler);
                        if (driver.getCurrentUrl().contains(urlContains)) {
                            log.info("Found window that contains url [{}]", urlContains);
                            return;
                        } else
                            log.info("Window Not found for url contains [{}]", urlContains);
                    }
                }
                log.info("No new windows found ...!");
            }
        }catch (Exception e){
            BaseTest.failTest("Cant switch to window with url ["+urlContains+"] .. \n"+e.getMessage());
        }
    }

    public static void switchToWindowTitle(WebDriver driver, String windowTitle, int waitTimeSec){
        try {
            for (int i = 0; i < waitTimeSec; i++) {
                ArrayList<String> handlers = new ArrayList(driver.getWindowHandles());

                if (handlers.size() > 1) {
                    for (String handler : handlers) {
                        driver.switchTo().window(handler);
                        if (StringUtils.equalsIgnoreCase(driver.getTitle(), windowTitle)) {
                            log.info("Found window with title [{}]", windowTitle);
                            return;
                        } else
                            log.info("Window Not found for title [{}]", windowTitle);
                    }
                }
                log.info("No new windows found ...!");
            }
        }catch (Exception e){
            BaseTest.failTest("Cant switch to window title ["+windowTitle+"] .. \n"+e.getMessage());
        }
    }

    public static boolean isAlertPresent(WebDriver driver) {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    /**
     * Switch to frame
     * So, you can actually select an iFrame using the below methods,
     * frame(index)  * frame(Name or Id); frame(WebElement frameElement)  or defaultContent()
     * getWebDriver().switchTo().frame(1);
     * or
     * driver.switchTo().frame(driver.findElement(By.name("iFrameTitle")));
     * driver.switchTo().frame(driver.findElement(By.id("frameId")));
     * and if only one driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
     * name="injectedUl"
     */
    public static void switchToFrameById(WebDriver driver, int id){
        try {
            driver.switchTo().frame(id);
        }catch (WebDriverException e){
            BasePage.failTest(e, "Can't switch to frame ...!; id ["+id+"}");
        }
    }
    public static void switchToFrameByFrameElementId(WebDriver driver, String id){
        try {
            driver.switchTo().frame(id);
        }catch (WebDriverException e){
            BasePage.failTest(e, "Can't switch to frame ...!; id ["+id+"}");
        }
    }

    public static void switchToFrameByFrameId(WebDriver driver, String frameId, int waitSeconds){
        do {
            try{
                log.info("\n\nTry to go to frame ...! "+frameId);
                driver.switchTo().frame(frameId);
                //log.info("\n\n frame source code ...!\n"+driver.getPageSource().toString()+"\n\n");
                log.info("Successful switched frame ...!");
                break;
            }catch (Exception wde){
                waitSeconds--;
                log.error("Frame not found , can't switch to frame ...! Try left ["+waitSeconds+"] ; " +wde.getMessage());
                BaseTest.sleep(1000);
            }
        } while (waitSeconds > 0);
    }

    public static void switchToFrameByFrameId(WebDriver driver, int frameId, int waitSeconds){
        do {
            try{
                log.info("\n\nTry [{}] to go to frameId ...! "+frameId, waitSeconds);
                driver.switchTo().frame(frameId);
                //log.info("\n\n frame source code ...!\n"+driver.getPageSource().toString()+"\n\n");
                log.info("Successful switched frame ...!");
                break;
            }catch (Exception wde){
                waitSeconds--;
                if(waitSeconds == 1)
                    log.error("Frame not found , can't switch to frame ...! Try left ["+waitSeconds+"] ; " +wde.getMessage());
                BaseTest.sleep(1000);
            }
        } while (waitSeconds > 0);
    }


    public static void switchToFrameByName(WebDriver driver, String iFrameTitle){
        try {
            WaitTool.waitForCondition(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iFrameTitle), driver, WaitTool.MED_WAIT_4_ELEMENT25);
            //driver.switchTo().frame(driver.findElement(By.name(iFrameTitle)));
        }catch (WebDriverException e){
            BasePage.failTest(e, "Can't switch to frame ...!; Name ["+iFrameTitle+"}");
        }
    }
    public static void switchToDefaultContent(WebDriver driver){
        try {
            driver.switchTo().defaultContent();
        }catch (WebDriverException e){
            BasePage.failTest(e, "Can't switch to defaultContent ...!");
        }
    }

    public static void switchToFrameByFrameWebElement(WebDriver driver, By iFrameBySelector){
        WebElement iframeElement = WaitTool.findElement(driver, iFrameBySelector);
        if(iframeElement !=null){
            log.info("\tframe element found time :"+ System.currentTimeMillis());
            driver.switchTo().frame(iframeElement);
            log.info("\ttime after switch to :"+ System.currentTimeMillis());
        }else
            BasePage.failTest("Can Not Switch to Frame using frame Element ["+iFrameBySelector+"]");
    }

    public static String closeAlertAndGetItsText(WebDriver driver, boolean acceptNextAlert) {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }

    public static void robotCloseWindow() {
        try{
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_ALT);
            robot.keyPress(KeyEvent.VK_F4);
            robot.keyRelease(KeyEvent.VK_ALT);
            robot.keyRelease(KeyEvent.VK_F4);
            log.info(" Robot sent Alt+f4....!");
        }catch (Exception e){e.printStackTrace();}
    }

    public static void resizeBrowserWindow(WebDriver driver, int width, int height){
        Dimension screenSize = new Dimension(width, height);
        driver.manage().window().setSize(screenSize);
    }

    public static void resizeBrowserWindow(WebDriver driver, Dimension screenDimension){
        log.info("Resize window to ["+screenDimension.toString()+"]");
        driver.manage().window().setSize(screenDimension);
    }



}
