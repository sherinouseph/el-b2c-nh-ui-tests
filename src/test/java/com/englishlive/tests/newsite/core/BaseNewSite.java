package com.englishlive.tests.newsite.core;
/**
 * Created by nikol.marku on 8/5/2016.
 * New website base test
 *
 *
 *
 */

import com.englishtown.helpers.WaitTool;
import com.englishtown.pages.common.HowItWorkPage;
import com.englishtown.pages.common.NewHomePage;
import com.englishtown.pages.common.core.PriceAndPackagekPage;
import com.englishtown.tests.core.BaseTestHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


public abstract class BaseNewSite extends BaseTestHelper {
    private static final Logger logger = LoggerFactory.getLogger(BaseNewSite.class);

    protected NewHomePage newHomePage;
    protected HowItWorkPage howItWorkPage;
    protected PriceAndPackagekPage priceAndPackagekPage;
    protected int mobileMenuItemSize;
    protected boolean runTestCheckTryUs = true;
    protected boolean runTestGotoPPpage = true;
    protected boolean  isHomePagePhoneNumberPresent = true;


    public void clickMobilePageMenuItem(int menuItemId){
        WebElement mainMenu = findElement(By.className("icon-burger"));
        mainMenu.click();sleep(1000);
        WaitTool.waitForListElementsDisplayed(getWebDriver(),By.cssSelector(".menu a"), 15);
        List<WebElement> menuList = getWebDriver().findElements(By.cssSelector(".menu a"));
        mobileMenuItemSize = menuList.size();
        logger.info("mobileMenuItemSize :"+mobileMenuItemSize+"; Clicking on item No :"+menuItemId);
        menuList.get(menuItemId).click(); sleep(1000);
        WaitTool.waitForListElementsDisplayed(getWebDriver(),By.className("scroll-indicator"), 15);
        //TODO add assertion
    }

    public void navigateTopMenu(NewHomePage newHomePage, int index){
        click(newHomePage.topMenuList.get(index));
    }
    public void clickLogsOnHomePage(NewHomePage newHomePage, int index){
        click(newHomePage.logoList.get(index));
    }

}
