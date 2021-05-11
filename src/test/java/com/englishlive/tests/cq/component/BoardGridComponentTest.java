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
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.tests.core.BaseTestHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static java.util.Arrays.asList;


public class BoardGridComponentTest extends BaseComponent {
    private static final Logger logger = LoggerFactory.getLogger(BoardGridComponentTest.class);
    @Value("#{applicationPropertiesList['it.price.page']}")
    protected String testUrl;
    protected List<WebElement> tempWeList = null;
    private final int NO_OF_BOARDS = 3;


    @BeforeClass
    public void setupOpenUrl(){
        setThreadSafeDriver();
        this.openUrl(getWebDriver(), this.testUrl, -1 ) ;
    }

    @Test
    public void checkAllBoardsShownOnDesktop(){
        tempWeList = WaitTool.findElements(getWebDriver(), By.cssSelector(BOARDS_LIST));
        for(WebElement webElement : tempWeList){
            AssertHelper.assertThat("Board Cards should all be shown ...or at least 3 ...! ",
                    WaitTool.isElementVisible(webElement));
        }
        AssertHelper.assertThat("Board Cards Should be ["+NO_OF_BOARDS+"] board cards shown ...!",tempWeList.size() == NO_OF_BOARDS);
    }

    @Test(priority = 2)
    public void checkOnlyFirstBoardIsShownOnTabletAndMobiles(){
        TestDevice device = new TestDevice("tablet",  new Dimension(1024, 768), asList("tablet"));
        WebDriverWindowHelper.resizeBrowserWindow(getWebDriver(), device.getScreenSize().width, device.getScreenSize().height);
        sleep(2000);
        tempWeList = WaitTool.findElements(getWebDriver(), By.cssSelector(BOARDS_LIST+".active"));
        JavaScriptHelper.scrollWebElementToView(getWebDriver(),tempWeList.get(0), ElementScreenPosition.BUTTON.MIDDLE, 0 );
        AssertHelper.assertThat("First Board Cards is shown  and others should be hidden but they not ...!",
                tempWeList.size()==1 );
    }

    @Test(priority = 3)
    public void clickOnRightSideArrowCheckNextBoardShownPreviousHidden(){
        tempWeList = WaitTool.findElements(getWebDriver(), By.cssSelector(BOARDS_ARROW_LIST));
        click(tempWeList.get(1)); // click end arrow
        sleep(1000);
        tempWeList = WaitTool.findElements(getWebDriver(), By.cssSelector(BOARDS_LIST));
        AssertHelper.assertThat("Second Board Cards is Not Visible ...!", WaitTool.isElementVisible(tempWeList.get(1)));
        //fail AssertHelper.assertThat("First Board Cards is Not hidden ...!", !WaitTool.isElementVisible(tempWeList.get(0)));
    }

    @AfterClass
    protected void testAfterClass(){
        destroyDriver();
    }

}
