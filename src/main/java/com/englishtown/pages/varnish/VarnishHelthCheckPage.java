package com.englishtown.pages.varnish;
/**
 * payment page
 *
 */
import com.englishtown.pages.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


public class VarnishHelthCheckPage extends BasePage {

    public static final Logger logger = LoggerFactory.getLogger(VarnishHelthCheckPage.class);
    public static final String HELTH_CHECK_URL = "/varnish/status"; //http://usb-etb2cv1.englishtown.com/varnish/status
    protected String healthCheckPageSource;
    //body>p:nth-child(2)   div:nth-of-type(5) instead of div.form_row:nth-child(6):

    @FindBy(css = "body>h1")
    public WebElement serverName;          // get text usb-etb2cv1

    @FindBy(tagName = "p")
    public List<WebElement> varnishCheckValuesList;

/* [htmlunit no css support]
    @FindBy(css = "body>p:nth-child(2)")
    public WebElement overallHealth;

    @FindBy(css = "body>p:nth-child(3)")
    public WebElement activeNode;

    @FindBy(css = "body>p:nth-child(4)")
    public WebElement passiveNode;

    @FindBy(css = "body>p:nth-child(5)")
    public WebElement varnishClusterPeer;

    @FindBy(css = "body>p:nth-child(6)")
    public WebElement caching;

    @FindBy(css = "body>p:nth-child(8)")
    public WebElement scriptServer;       // server name

    @FindBy(css = "body>p:nth-child(9)")
    public WebElement version;
*/




    public VarnishHelthCheckPage(WebDriver webDriver){
        super(webDriver);
    }

    public VarnishHelthCheckPage(WebDriver webDriver, String url) {
        super(webDriver, url);
    }
    public VarnishHelthCheckPage() {
        this(null, null);
    }
    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    public boolean simpleTest() {
        logger.info(" simpleTest()");
        return serverName.isDisplayed() ;
    }
    public ExpectedCondition getPageLoadedCondition() {
        return ExpectedConditions.visibilityOf(serverName);
    }
    public String getPageUrl() {
        return HELTH_CHECK_URL;
    }


    public String getHelthCheckPageSource() {
        return healthCheckPageSource;
    }

    public void setHelthCheckPageSource(String healthCheckPageSource) {
        this.healthCheckPageSource = healthCheckPageSource;
    }


}


/*

//    for(WebElement we : webElementList){
//        count++;
//        logger.info("No : "+count+" WE text : "+we.getText());
//    }
[main] INFO com.englishlive.tests.varnish.core.BaseVarnishTest - No : 1 WE text : Overall Health:Ok
[main] INFO com.englishlive.tests.varnish.core.BaseVarnishTest - No : 2 WE text : Active Node:Ok
[main] INFO com.englishlive.tests.varnish.core.BaseVarnishTest - No : 3 WE text : Passive Node:Ok
[main] INFO com.englishlive.tests.varnish.core.BaseVarnishTest - No : 4 WE text : Varnish Cluster Peer:Ok
[main] INFO com.englishlive.tests.varnish.core.BaseVarnishTest - No : 5 WE text : Caching:Ok
[main] INFO com.englishlive.tests.varnish.core.BaseVarnishTest - No : 6 WE text : Current Backend: cq_active_fallback
[main] INFO com.englishlive.tests.varnish.core.BaseVarnishTest - No : 7 WE text : Script: usb-etb2cv1
[main] INFO com.englishlive.tests.varnish.core.BaseVarnishTest - No : 8 WE text : Version: 1.0.33
[main] INFO com.englishlive.tests.varnish.core.BaseVarnishTest - No : 9 WE text : Disable VarnishDisable ActiveDisable PassiveDisable ClusterDisable Caching

 */