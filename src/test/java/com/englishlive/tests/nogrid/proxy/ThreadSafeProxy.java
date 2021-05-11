package com.englishlive.tests.nogrid.proxy;
/**
 * Proxy
 */
import com.englishtown.driver.BaseRemoteWebDriver;
import com.englishtown.driver.local.WebDriverFactory;
import com.englishtown.helpers.utils.TestUtil;
import com.machinepublishers.jbrowserdriver.ProxyConfig;
import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.proxy.CaptureType;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class ThreadSafeProxy {
    private static final Logger logger = LoggerFactory.getLogger(ThreadSafeProxy.class);

    private static ThreadSafeProxy threadSafeProxyInstace = null;

    private static BrowserMobProxy proxyServer;
    private static ProxyConfig proxyConfig ;
    private static Integer proxyPort = 4986; // 80; //4986;
    private static Proxy seleniumProxy;
    private static DesiredCapabilities capabilities;
    private static WebDriver webDriver;



    private ThreadSafeProxy(){}

    /**
     * Get a proxy instance and start it if needed
     * create selenium proxy and driver
     * @return
     */
    public static synchronized ThreadSafeProxy getInstance(){
        System.setProperty("bmp.allowNativeDnsFallback", "true");
        System.setProperty("jsse.enableSNIExtension", "false");
        if(threadSafeProxyInstace == null){
            threadSafeProxyInstace = new ThreadSafeProxy();
            if(proxyServer == null){
                proxyServer = new BrowserMobProxyServer();
                setProxyConfiguration( true, 60);                startProxy();
                //createWebDriver();
            }
        }
        return threadSafeProxyInstace;
    }

    public static void setProxyConfiguration(boolean isTrastAllServers, int reqTimeoutSec){ //},List<String> blacklistUrls){
        proxyServer.setTrustAllServers(isTrastAllServers); //true);
        proxyServer.setRequestTimeout(reqTimeoutSec, TimeUnit.SECONDS);
        proxyServer.enableHarCaptureTypes(CaptureType.getHeaderCaptureTypes());
        proxyServer.setHarCaptureTypes(CaptureType.getAllContentCaptureTypes());
        proxyServer.blacklistRequests("trck.spoteffects.net", 200);
        proxyServer.blacklistRequests("https://trck.spoteffects.net/analytics/piwik", 200);
        if(blacklistUrls != null && !blacklistUrls.isEmpty()) {
            for (String url : blacklistUrls) {
                proxyServer.blacklistRequests(url, 200); }
        }

    }

    public static synchronized void startProxy(){
        logger.info("Starting proxy ...!");
        try {
            proxyServer.start(proxyPort, InetAddress.getLocalHost());            //
            proxyConfig = new ProxyConfig(ProxyConfig.Type.HTTP, InetAddress.getLocalHost().getHostAddress(), proxyPort);
        } catch (RuntimeException re) {
            logger.error("RuntimeException starting proxy ..." + re.getMessage());
        } catch (UnknownHostException e) {
            logger.error("UnknownHostException > Can not start Proxy ....! " + e.getMessage());
        } catch (Exception e) {
            logger.error("Exception > Can not start Proxy ....! " + e.getMessage());
        }
    }

    /**
     * Get the Selenium proxy object
     */
    public static void createSeleniumProxy(){
        seleniumProxy = ClientUtil.createSeleniumProxy(proxyServer);
        try{
            String proxyIp = InetAddress.getLocalHost().getHostAddress();
            logger.info("proxy address will be set to : "+proxyIp + " :> on Port :"+proxyPort);
            seleniumProxy.setHttpProxy(proxyIp + ":" + proxyPort);
            seleniumProxy.setSslProxy(proxyIp + ":" + proxyPort);            /*proxy.setHttpProxy(InetAddress.getLocalHost().getHostAddress() + ":" + proxyPort);            proxy.setSslProxy(InetAddress.getLocalHost().getHostAddress() + ":" + proxyPort);*/
        } catch(Exception ex){
            logger.error("Setup proxy with chrome error ...!"+ ex.getMessage());
        }
        setSeleniumDriverProxyCapability();
    }

    public static void setSeleniumDriverProxyCapability(){
        capabilities = DesiredCapabilities.chrome() ;
        capabilities.setCapability(CapabilityType.PROXY, getSeleniumProxy());
    }

    public static WebDriver createWebDriver(){
        logger.info("create driver ...!");
        String chromeFile = TestUtil.getAbsolutPathToDriverExe("chromedriver.exe") ;
        System.setProperty("webdriver.chrome.driver", chromeFile);
        createSeleniumProxy();
        WebDriver driver = new ChromeDriver(capabilities); // WebDriverFactory.createProtectDriver(null, getCapabilities()); //new ChromeDriver(capabilities);
        driver.manage().window().maximize();
        //legacy
        BaseRemoteWebDriver.setCurrentBrowserName("chrome");

        return driver;
    }

    public static synchronized void stopProxy(){
        logger.info("Start to STOP proxy ...!");
        try{
            if(null != proxyServer) {
                proxyServer.stop();
            } else
                logger.info("Proxy is null so can not stop it ..!");
        }catch (RuntimeException re ){
            re.printStackTrace();
            logger.error("Can not stop Proxy : "+re.getMessage());
        }catch (Exception e ){
            e.printStackTrace();
            logger.error("Can not stop Proxy : "+e.getMessage());
        }
    }
    //---------------
    //***************
    public static BrowserMobProxy getProxyServer() {
        return proxyServer;
    }

    public static ProxyConfig getProxyConfig() {
        return proxyConfig;
    }

    public static Integer getProxyPort() {
        return proxyPort;
    }

    public static Proxy getSeleniumProxy() {
        return seleniumProxy;
    }

    public static DesiredCapabilities getCapabilities() {
        return capabilities;
    }

    public static WebDriver getWebDriver() {
        return webDriver;
    }


    public static final List<String> blacklistUrls = new ArrayList<String>();
    static {
        blacklistUrls.add("");
        // gem
        blacklistUrls.add("http(s)?://.*trackfestival\\.com/.*");
        blacklistUrls.add("http(s)?://facebook\\.com/.*");
        // FR member page ...
        blacklistUrls.add("http(s)?://s\\.ytimg\\.com/.*");
        blacklistUrls.add("http(s)?://etvt\\.englishtown\\.com/.*");
        blacklistUrls.add("http(s)?://dpm\\.demdex\\.net/.*");
        blacklistUrls.add("http(s)?://rum-collector\\.pingdom\\.net/.*");
        //de
        blacklistUrls.add("http(s)?://aax-eu\\.amazon-adsystem.com/.*");
        blacklistUrls.add("http(s)?://d\\.ligatus\\.com/.*");
        blacklistUrls.add("http(s)?://us-west-2\\.dc\\.ads\\.linkedin\\.com/.*");
        blacklistUrls.add("http(s)?://static\\.atgsvcs\\.com/.*");
        blacklistUrls.add("http(s)?://stats\\.g\\.doubleclick\\.net/.*");
        blacklistUrls.add("http(s)?://cms\\.analytics\\.yahook\\.com/.*");
        //br
        blacklistUrls.add("http(s)?://etvt\\.englishtown\\.com/.*");
        blacklistUrls.add("http(s)?://comet\\.englishtown\\.com/.*");
        blacklistUrls.add("http(s)?://cms\\.analytics\\.yahoo\\.com/.*");
        blacklistUrls.add("http(s)?://.*yahoo\\.com/.*");
        blacklistUrls.add("http(s)?://b92\\.yahoo\\.co\\.jp/.*");
        blacklistUrls.add("http(s)?://yjtag\\.yahoo\\.co\\.jp/.*");
        blacklistUrls.add("http(s)?://pong\\..*");
        blacklistUrls.add("http(s)?://aus4.mozilla.*");
        blacklistUrls.add("http(s)?://.*yimg\\.jp.*");
        blacklistUrls.add("http(s)?://.*youtube\\.*");
        //JP
        blacklistUrls.add("http(s)?://dc\\.ads\\.linkedin\\.com/.*");
        blacklistUrls.add("http(s)?://bat\\.bing\\.com/.*");
        //
        blacklistUrls.add("http(s)?://script\\.hotjar\\.com/.*");
        blacklistUrls.add("http(s)?://vars\\.hotjar\\.com/.*");
        blacklistUrls.add("http(s)?://.*google-analyticsr\\.com/.*");
        blacklistUrls.add("http(s)?://tracking\\.adnexio.\\.com/.*");
    }

}


    /*
    public static synchronized void stopDriver(){
        logger.info("Start to STOP webDriver  ...!");
        try{
            if (null != webDriver) {
                webDriver.quit();
            }else
                logger.info("Driver is null ...! ");
        }catch (RuntimeException re ){
            logger.error("Can not stop Browser : "+re.getMessage());
        }catch (Exception e ){
            logger.error("Can not stop Browser : "+e.getMessage());
        }
    }*/