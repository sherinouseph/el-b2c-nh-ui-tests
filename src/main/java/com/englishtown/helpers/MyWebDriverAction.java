package com.englishtown.helpers;

import com.englishtown.helpers.utils.TestUtil;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by nikol.marku on 09/03/2015.
 */
public class MyWebDriverAction {
    private static final Logger logger = LoggerFactory.getLogger(MyWebDriverAction.class);

    public static void moveToElementAndClick(WebDriver driver, WebElement element){
        logger.info("moveToElementAndClick ....! using Action click");
        try {
            Actions actions = new Actions(driver);
            actions.moveToElement(element).click().perform();
        }catch (Exception e){
            logger.error("moveToElementAndClick() Exception : "+TestUtil.getException(e, driver));
        }
    }

    public static void moveToElement(WebDriver driver, WebElement element){
        logger.info("moveToElementAndClick ....! using Action click");
        try {
            Actions actions = new Actions(driver);
            actions.moveToElement(element, 5, 5).build().perform();
        }catch (Exception e){
            logger.error("moveToElementAndClick() Exception : "+TestUtil.getException(e, driver));
        }
    }

    public static void actionClick(WebDriver driver, WebElement element){
        try {
            Actions actions = new Actions(driver);
            actions.click(element).build().perform();
        }catch (Exception e){
            logger.error("actionClick() Exception : "+ TestUtil.getException(e, driver));
        }
    }

    public static void doubleClick(WebDriver driver, WebElement element) {
        try {
            Actions action = new Actions(driver).doubleClick(element);
            action.build().perform();
            logger.info("Double clicked the element");
        } catch (Exception e) {
            logger.error("Element " + element + " was not clickable " + e.getCause());
        }
    }

    public static void mouseOver(WebDriver driver, WebElement mouseOverMeWe){
        WaitTool.waitForCondition(ExpectedConditions.visibilityOf(mouseOverMeWe), driver, WaitTool.MED_WAIT_4_ELEMENT25);
        AssertHelper.assertWebElementDisplayed(mouseOverMeWe);

        try {
            Actions action = new Actions(driver);
            action.moveToElement(mouseOverMeWe).build().perform();                                                      /*Actions builder = new Actions(driver);     Action mouseOverHome = builder.moveToElement(mouseOverMeWe).build();     mouseOverHome.perform();*/
            TestUtil.mySleep(500);
            logger.info("Done Mouse over WE ...!");
        }catch (WebDriverException we){
            logger.error("actionMouseOver is not performed as there are exceptions ...! > ", we);
        }
    }

    public static void clearAndSetText(WebDriver driver, WebElement webElement, String text)    {
        logger.info("clearAndSetText [{}] ...!", text);
        Actions navigator = new Actions(driver);
        navigator.click(webElement)
                .sendKeys(Keys.END)
                .keyDown(Keys.SHIFT)
                .sendKeys(Keys.HOME)
                .keyUp(Keys.SHIFT)
                .sendKeys(Keys.BACK_SPACE)
                .sendKeys(text)
                .perform();
    }


}
