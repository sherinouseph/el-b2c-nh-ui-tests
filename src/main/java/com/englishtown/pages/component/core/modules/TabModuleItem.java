package com.englishtown.pages.component.core.modules;
/**
 * Model active tab
 * Created by nikol.marku on 11/23/2016.
 * ON:  http://englishlive.ef.com/it-it/imparare-l-inglese/
 * see tabs : https://jira-bos.englishtown.com/browse/SAND-3272
 *
 */
import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.pages.component.core.BaseComponentPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.hamcrest.Matchers.is;


public class TabModuleItem extends BaseComponentPage implements ITab{
    private static final Logger logger = LoggerFactory.getLogger(TabModuleItem.class);

    @FindBy(css = TAB_CSS)
    public WebElement tab;

    @FindBy(css = TAB_ITEMS_CSS)
    public List <WebElement> tabItemList;

    @FindBy(css = ACTIVE_TAB_ITEM_CSS)
    public WebElement activeTabItem;

    @FindBy(css = ACTIVE_TAB_NAME_CSS)
    public WebElement activeTabName;

    @FindBy(css = ACTIVE_TAB_CONTENT_CSS)
    public WebElement activeTabContent;


    public TabModuleItem(WebDriver webDriver){
        super(webDriver);
    }

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public boolean simpleTest() {
        super.simpleTest();
        logger.info(" simpleTest() check active tab shown ...!");
        AssertHelper.assertThat("activeTabItem should be dislplayed ...!", activeTabItem.isDisplayed(), is(true));
        return true;
    }
    public ExpectedCondition getPageLoadedCondition() {
        return ExpectedConditions.visibilityOf(activeTabItem);
    }

    public String getActiveTabName(){
        return TestUtil.getWebElementText(activeTabName);
    }
    public String getActiveTabContent(){
        return TestUtil.getWebElementText(activeTabContent);
    }

}
