package com.englishlive.tests.cq.component;
/**
 *
 * https://jira-bos.englishtown.com/browse/SAND-3259
 * if mobile or tablet only one card is shown and user can scroll
 *
 */
import com.englishlive.tests.cq.component.core.BaseComponent;
import com.englishlive.tests.galen.core.TestDevice;
import com.englishtown.helpers.*;
import com.englishtown.pages.component.core.modules.TabModuleItem;
import org.openqa.selenium.Dimension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static java.util.Arrays.asList;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;


public class TabsComponentTest extends BaseComponent {
    private static final Logger logger = LoggerFactory.getLogger(TabsComponentTest.class);
    @Value("#{applicationPropertiesList['it.howitworks.page']}")
    protected String testUrl;

    protected TabModuleItem tabModuleItem;
    protected String tabName;
    protected String tabContent;
    protected String tempTabName ;
    protected String tempTabContent ;
    protected int clickTabIndex = 2 ;

    @BeforeClass
    public void setupOpenUrlInitItemScrollToTabs(){
        setThreadSafeDriver();
        this.openUrl(getWebDriver(), this.testUrl, -1 ) ;
        tabModuleItem = new TabModuleItem(getWebDriver());
        JavaScriptHelper.scrollWebElementToView(getWebDriver(), tabModuleItem.activeTabName, ElementScreenPosition.MIDDLE, 0);
        sleep(1000);
    }

    @Test
    public void checkTabActiveItemShownOnDesktop(){
        tabModuleItem.simpleTest();
    }

    @Test(priority = 2)
    public void check_active_ContentAndTabNameChanges_AfterClickingOtherTab(){
        tabName = tabModuleItem.getActiveTabName();
        tabContent = tabModuleItem.getActiveTabContent();

        click(tabModuleItem.tabItemList.get(clickTabIndex));
        sleep(2000);

        tabModuleItem = new TabModuleItem(getWebDriver());
        tempTabName    = tabModuleItem.getActiveTabName();
        tempTabContent = tabModuleItem.getActiveTabContent();

        AssertHelper.assertThat("Active Tab name is NOT different after click ...!", tempTabName, not(tabName));
        AssertHelper.assertThat("Active Tab content is NOT different after click ...!", tempTabContent, not(tabContent));
    }

    @Test(priority = 3)
    public void resizeWindowToTabletSize_w1024h768(){
        TestDevice device = new TestDevice("tablet",  new Dimension(1024, 768), asList("tablet"));
        WebDriverWindowHelper.resizeBrowserWindow(getWebDriver(), device.getScreenSize().width, device.getScreenSize().height);
        sleep(1000);
    }

    @Test(priority = 4)
    public void tabViewCheck_active_ContentAndTabNameChanges_AfterClickingOtherTab(){
        tabModuleItem = new TabModuleItem(getWebDriver());
        JavaScriptHelper.scrollWebElementToView(getWebDriver(), tabModuleItem.activeTabName, ElementScreenPosition.MIDDLE, 0);
        sleep(800);
        tabModuleItem = new TabModuleItem(getWebDriver());

        click(tabModuleItem.tabItemList.get(1));
        sleep(1000);

        tabModuleItem = new TabModuleItem(getWebDriver());
        String tabviewTempName    = tabModuleItem.getActiveTabName();
        String tabviewTempContent = tabModuleItem.getActiveTabContent();

        AssertHelper.assertThat("Active Tab name is Not first tab Name ...!",    tabviewTempName, is(tabName));
        AssertHelper.assertThat("Active Tab content is NOT first tab content...!", tabviewTempContent, is(tabContent));
    }


    @AfterClass
    protected void testAfterClass(){
        destroyDriver();
    }


}
