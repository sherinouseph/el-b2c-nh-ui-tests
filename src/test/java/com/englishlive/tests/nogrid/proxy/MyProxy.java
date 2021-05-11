//package com.englishlive.tests.nogrid.proxy;
//
///**
// * Singleton proxy server
// *
// */
//
//import com.englishtown.driver.BaseRemoteWebDriver;
//import com.englishtown.driver.IWebDriverSetting;
//import com.englishtown.driver.MyBrowserType;
//import com.englishtown.driver.MyRemoteWebDriver;
//import com.englishtown.driver.local.DriverManager;
//import com.englishtown.helpers.AssertHelper;
//import com.englishtown.helpers.WaitTool;
//import com.englishtown.helpers.WebElementHelper;
//import com.englishtown.helpers.bean.handler.*;
//import com.englishtown.helpers.utils.TestUtil;
//import com.englishtown.pages.core.BasePage;
//import com.englishtown.tests.core.IBaseTest;
//import com.englishtown.tests.core.TestngListener;
//import com.google.gson.JsonObject;
//import com.machinepublishers.jbrowserdriver.*;
//import net.lightbody.bmp.BrowserMobProxy;
//import net.lightbody.bmp.BrowserMobProxyServer;
//import net.lightbody.bmp.client.ClientUtil;
//import net.lightbody.bmp.core.har.*;
//import net.lightbody.bmp.proxy.CaptureType;
//import org.apache.commons.lang.StringUtils;
//import org.testng.Assert;
//import org.openqa.selenium.By;
//import org.openqa.selenium.Proxy;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.remote.CapabilityType;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.Listeners;
//
//import java.io.FileOutputStream;
//import java.net.InetAddress;
//import java.net.UnknownHostException;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//import java.util.Map;
//import java.util.concurrent.TimeUnit;


// // TODO  need refactoring and time
//
//public class MyProxy {
//    private static final Logger logger = LoggerFactory.getLogger(MyProxy.class);
//
//    private static final MyProxy myProxyInstance = new MyProxy();
//
//    private static BrowserMobProxy proxyServer;
//    private static ProxyConfig proxyConfig ;
//    private static int proxyPort = 46234;
//    private static boolean isProxyRunning = false;
//    private static boolean isDebug = true;
//    private static boolean isShowBrowserGui = false;
//
//
//    private MyProxy(){
//        // Exists only to defeat instantiation.
//    }
//
//    public static final MyProxy getMyProxyInstance() {
//        return myProxyInstance;
//    }
//
//
//    public void setupChromeWithProxyDriver(String testUrl){
//        setupAndStartProxy(proxyPort);
//
//        String chromeFile = TestUtil.getAbsolutPathToDriverExe("chromedriver.exe") ;
//        System.setProperty("webdriver.chrome.driver", chromeFile);
//
//        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
//
//        //        ChromeOptions options = new ChromeOptions();
//        //        options.addArguments("window-size=1920,1080");
//        //        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
//
//        // SET chrome proxy
//        Proxy proxy = new Proxy();
//        try{
//            proxy.setHttpProxy(InetAddress.getLocalHost().getHostAddress() + ":" + proxyPort);
//            proxy.setSslProxy(InetAddress.getLocalHost().getHostAddress() + ":" + proxyPort);
//        } catch(Exception ex){
//            logger.error("Setup proxy with chrome error ...!"+ ex.getMessage());
//        }
//        capabilities.setCapability("proxy", proxy);
//
//        //driver = WebDriverFactory.createProtectDriver(null, capabilities); //new ChromeDriver(capabilities);
//        driver = new ChromeDriver(capabilities); //WebDriverFactory.createProtectDriver(null, capabilities); //new ChromeDriver(capabilities);
//        driver.manage().window().maximize();
//
//        BaseRemoteWebDriver.setCurrentBrowserName("chrome");
//    }
//
//    public void setupAndStartProxy(int proxyPort){
//        if(proxyServer != null && proxyServer.isStarted()){
//            logger.warn("Proxy server is running so no need to stat it ");
//        } else {
//            if(!isProxyRunning) {
//                logger.info("setup proxyServer ...!");
//                //if(proxyServer != null) proxyServer.stop();
//                proxyServer = new BrowserMobProxyServer();
//                proxyServer.setTrustAllServers(true);
//                proxyServer.setRequestTimeout(55, TimeUnit.SECONDS);
//                proxyServer.setHarCaptureTypes(CaptureType.getAllContentCaptureTypes());
//                proxyServer.setHarCaptureTypes(CaptureType.REQUEST_CONTENT);
//                proxyServer.setHarCaptureTypes(CaptureType.REQUEST_BINARY_CONTENT);
//                proxyServer.blacklistRequests("trck.spoteffects.net", 200);
//                proxyServer.blacklistRequests("https://trck.spoteffects.net/analytics/piwik", 200);
//                proxyServer.enableHarCaptureTypes(CaptureType.getAllContentCaptureTypes());
//                proxyServer.enableHarCaptureTypes(CaptureType.RESPONSE_HEADERS);
//                proxyServer.enableHarCaptureTypes(CaptureType.RESPONSE_CONTENT);
//                proxyServer.enableHarCaptureTypes(CaptureType.REQUEST_CONTENT);
//                proxyServer.enableHarCaptureTypes(CaptureType.REQUEST_HEADERS);
//                proxyServer.enableHarCaptureTypes(CaptureType.REQUEST_BINARY_CONTENT);
//
//                try {
//                    proxyServer.start(proxyPort, InetAddress.getLocalHost());
//                    proxyConfig = new ProxyConfig(ProxyConfig.Type.HTTP, InetAddress.getLocalHost().getHostAddress(), proxyPort);
//                    isProxyRunning = true;
//                } catch (UnknownHostException e) {
//                    e.printStackTrace();
//                    logger.error(e.getMessage());
//                } catch (Exception e) {
//                    e.printStackTrace();
//                    logger.error(e.getMessage());
//                }
//            }
//        }
//    }
//
//
//    public void setUpProxy(){
//        try {
//            logger.info("setUp proxy ...!");
//            MyRemoteWebDriver.setupSystemProperties(GECKO_DRIVER_KEY, GECKO_DRIVER_FILENAME );
//
//            if(proxyServer != null){
//                proxyServer.stop();
//            }
//            proxyServer = null;
//            proxyServer = new BrowserMobProxyServer();
//            proxyServer.enableHarCaptureTypes(CaptureType.REQUEST_CONTENT, CaptureType.RESPONSE_CONTENT);
//            proxyServer.newHar(); //("eLive.com");
//            proxyServer.setHarCaptureTypes(CaptureType.getAllContentCaptureTypes());
//            proxyServer.enableHarCaptureTypes(CaptureType.getAllContentCaptureTypes());
//            proxyServer.enableHarCaptureTypes(CaptureType.RESPONSE_HEADERS);
//            proxyServer.setTrustAllServers(true);
//            proxyServer.setRequestTimeout(55, TimeUnit.SECONDS);
//            //proxyServer.enableHarCaptureTypes(CaptureType.REQUEST_CONTENT);       proxyServer.enableHarCaptureTypes(CaptureType.RESPONSE_CONTENT);
//            proxyPort = 46234; //PortProber.findFreePort();
//            proxyServer.start(proxyPort, InetAddress.getLocalHost());
//
//
//            // get the Selenium proxy object
//            Proxy proxy = ClientUtil.createSeleniumProxy(proxyServer);
//
//            //log(proxy.getHttpProxy());
//
//            // selenium 3   : Your connection is not secure
//            //main] INFO org.littleshoot.proxy.impl.DefaultHttpProxyServer - Proxy started at address: /10.24.208.189:13445
//            //1488811935415	geckodriver	INFO	Listening on 127.0.0.1:44998
//            DesiredCapabilities capabilities = new DesiredCapabilities();
//            capabilities.setCapability(CapabilityType.PROXY, proxy);
//            String proxyAddress = InetAddress.getLocalHost().getHostAddress(); //"127.0.0.1"; // InetAddress.getLocalHost().toString(); //"10.24.208.189";
//            JsonObject json = new JsonObject();
//            json.addProperty("proxyType", "MANUAL");
//            json.addProperty("httpProxy", proxyAddress);
//            json.addProperty("httpProxyPort", proxyPort);
//            json.addProperty("sslProxy", proxyAddress);
//            json.addProperty("sslProxyPort", proxyPort);
//            capabilities.setCapability(CapabilityType.PROXY, json);
//
//            //
//            capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
//            capabilities.setCapability("marionette", true);
//
//            // PROFILE
//            /*
//            FirefoxProfile profile = new FirefoxProfile();
//            profile.setPreference("network.proxy.http", proxyAddress);
//            profile.setPreference("network.proxy.http_port", proxyServer.getPort());
//            profile.setPreference("network.proxy.ssl", proxyAddress);
//            profile.setPreference("network.proxy.ssl_port", proxyServer.getPort());
//            profile.setPreference("network.proxy.type", 1);
//            capabilities.setCapability(FirefoxDriver.PROFILE, profile);
//            */
//            driver = new FirefoxDriver(capabilities);
//
//
//            BaseRemoteWebDriver.setCurrentBrowserName("firefox"); // needed when used on action On input element on enterFormData
//            driver.manage().window().maximize();
//        }catch (Exception e){
//            logger.error(e.getMessage());
//            BasePage.failTest("Failed to setup proxy server ...!");
//        }
//
//    }
//
//
//    protected BasicPostDataHandler getBasicPostDataHandlerAndSetResponseObj(BrowserMobProxy myProxyServer, String harFilter) throws NullPointerException{
//        logger.info("getBasicPostDataHandler harFilter used is :"+harFilter);
//        BasicPostDataHandler basicPostDataHandler = null;
//        String tempKey  = null;
//        String tempValue = null;
//
//        if(myProxyServer != null && harFilter != null) {
//            //validate har
//            Har har = proxyServer.getHar();
//            if(har== null){
//                logger.error("Can't create/get har from proxy ...!");
//                return null;
//            }
//            //validate har
//            List<HarEntry> harEntries = null;
//            try {
//                harEntries = har.getLog().getEntries();
//                if(harEntries.isEmpty()== true || harEntries.size() == 0){
//                    logger.error("harEntries empty ...!");
//                    return null;
//                }
//            }catch (Exception e){
//                logger.error("Can't get harEntries ...!");
//                return null;
//            }
//            //process data
//            try {
//                basicPostDataHandler = new BasicPostDataHandler();
//                for (HarEntry entry : harEntries) {
//                    tempKey  = null;
//                    tempValue = null;
//                    //Test response
//                    if (entry.getRequest().getUrl().contains(harFilter)) {
//                        logger.info(" HAR  url :" + entry.getRequest().getUrl());
//                        if (entry.getRequest().getPostData() != null) {
//                            List<HarPostDataParam> harPostDataParamsList = entry.getRequest().getPostData().getParams();
//                            //{"Success":true,"RedirectUrl":"http://www.englishtown.com/online/pt-thankyou.aspx?omnievents=event5,event34,event4,event33&omniproducts=;EmailEnglish_LeadOE;1;0;event34=0|event33=0&csf=eyJmaXJzdF9uYW1lIjoidGVzdERCc3RvcmUiLCJlbWFpbCI6ImRiMV8xNDYwMTA5MjY2ODA0QHFwMS5vcmciLCJsZWFkX2lkIjozODUxNDY1NX0%3d","LeadId":38514655}
//                            HarResponse harResponse = entry.getResponse();
//                            logger.warn("Response code sometime does not work ...! issue with post and proxy implementation ...!");
//                            int responseStatus = harResponse.getStatus();
//                            HarContent harContentResponse = harResponse.getContent();
//                            logger.info("Response : "+harContentResponse.getText());
//                            basicResponseDataHandler = BasicResponseDataHandler.setBasicResponseObject(harContentResponse.getText(),responseStatus);
//
//                            for (HarPostDataParam hpdp : harPostDataParamsList) {
//                                tempKey = hpdp.getName();
//                                tempValue = hpdp.getValue();                                //logger.info(" Har  [Key :" + tempKey + "; value :" + tempValue + "]");
//                                if(basicDataHandlerKeyList.contains(tempKey)) {
//                                    basicPostDataHandler.setBasicObjectValue(tempKey, tempValue);
//                                }
//                            }
//                        }
//                                //                        List<HarNameValuePair> harNameValuePairList = entry.getRequest().getQueryString();
//                                //                        for (HarNameValuePair hnvp : harNameValuePairList) {
//                                //                            System.out.println("getQueryString  name [" + hnvp.getName() + "]");
//                                //                            System.out.println("getQueryString value [" + hnvp.getValue() + "]");
//                                //                        }
//                    }
//                }
//            }catch (Exception e){
//                logger.error("Can't get har entry data ...! ; "+e.getMessage());
//            }
//        }else {
//            logger.error("ProxyServer OR harFilter is NULL ....!");
//            return null;
//        }
//        return basicPostDataHandler;
//    }
//
//    protected BasicResponseDataHandler getBasicResponseDataHandler(BrowserMobProxy myProxyServer, String harFilter) {
//        logger.info("getBasicResponseDataHandler harFilter used is :"+harFilter);
//        BasicPostDataHandler basicPostDataHandler;
//        BasicResponseDataHandler responseDataHandler = new BasicResponseDataHandler();
//        String tempKey  = null;
//        String tempValue = null;
//
//        if(myProxyServer != null && harFilter != null) {
//            Har har = proxyServer.getHar();
//            if(har== null){
//                logger.error("Can't create/get har from proxy ...!");
//                return responseDataHandler;
//            }
//            List<HarEntry> harEntries = null;
//            try {
//                harEntries = har.getLog().getEntries();
//                if(harEntries.isEmpty()== true || harEntries.size() == 0){
//                    logger.error("harEntries empty ...!");
//                    return responseDataHandler;
//                }
//            }catch (Exception e){
//                logger.error("Can't get harEntries ...!");
//                return responseDataHandler;
//            }
//            //process data
//            try {
//                basicPostDataHandler = new BasicPostDataHandler();
//                for (HarEntry entry : harEntries) {
//                    tempKey  = null;
//                    tempValue = null;
//                    //Test response
//                    if (entry.getRequest().getUrl().contains(harFilter)) {
//                        logger.info("Found har filter ... HAR  url :" + entry.getRequest().getUrl());
//                        HarResponse harResponse = entry.getResponse();
//                        if(null != harResponse) {
//                            logger.warn("Response code sometime does not work ...! issue with post and proxy implementation ...!");
//                            int responseStatus = harResponse.getStatus();
//                            // note this need to be edited for different responses
//                            responseDataHandler = new BasicResponseDataHandler(harResponse.getContent().toString(),
//                                    harResponse.getStatusText(), harResponse.getRedirectURL(), "", responseStatus);
//                        }else
//                            return responseDataHandler;
//                    }
//                }
//            }catch (Exception e){
//                logger.error("Can't get har entry data ...! ; "+e.getMessage());
//            }
//        }else {
//            logger.error("ProxyServer OR harFilter is NULL ....!");
//            return responseDataHandler;
//        }
//        return responseDataHandler;
//    }
//
//    /**
//     * Get data from har ... filter on url
//     * @param myProxyServer
//     * @param harFilter
//     * @return
//     * @throws NullPointerException
//     */
//    protected EfFullDataBean getFullDataBeamAndSetResponseObj(BrowserMobProxy myProxyServer, String harFilter) throws NullPointerException{
//        logger.info("getBasicPostDataHandler harFilter used is :"+harFilter);
//        EfFullDataBean dataBean = null;
//        String tempKey  = null;
//        String tempValue = null;
//
//        if(myProxyServer != null && harFilter != null) {
//            //validate har
//            Har har = proxyServer.getHar();
//            if(har== null){
//                logger.error("Can't create/get har from proxy ...!");
//                return null;
//            }
//            //validate har
//            List<HarEntry> harEntries = null;
//            try {
//                harEntries = har.getLog().getEntries();
//                har = null;//release resource
//                if(harEntries.isEmpty()== true || harEntries.size() == 0){
//                    logger.error("harEntries empty ...!");
//                    return null;
//                }
//            }catch (Exception e){
//                logger.error("Can't get harEntries ...!");
//                return null;
//            }
//            //process data
//            try {
//                dataBean = new EfFullDataBean();
//                for (HarEntry entry : harEntries) {
//                    tempKey  = null;
//                    tempValue = null;
//                    //Test response
//                    if (entry.getRequest().getUrl().contains(harFilter)) {
//                        logger.info(" HAR  url :" + entry.getRequest().getUrl());
//                        if (entry.getRequest().getPostData() != null) {
//                            HarResponse harResponse = entry.getResponse();
//                            logger.warn("Response code sometime does not work ...! issue with post and proxy implementation ...!");
//                            int responseStatus = harResponse.getStatus();
//                            HarContent harContentResponse = harResponse.getContent();
//                            logger.info("Response : "+harContentResponse.getText());
//                            if(isCreateMemberHandler) {
//                                basicResponseDataHandler = BasicResponseDataHandler.setCreateMemberResponseObject(harContentResponse.getText(), responseStatus);
//                            }else if(isSubmitOeFormHandler){
//                                basicResponseDataHandler = BasicResponseDataHandler.setBasicResponseObject(harContentResponse.getText(), responseStatus);
//                            }
//
//                            List<HarPostDataParam> harPostDataParamsList = entry.getRequest().getPostData().getParams();
//
//                            for (HarPostDataParam hpdp : harPostDataParamsList) {
//                                tempKey = hpdp.getName();
//                                tempValue = hpdp.getValue();                                //logger.info(" Har  [Key :" + tempKey + "; value :" + tempValue + "]");
//                                //if(efFullKeyList.contains(tempKey)) {
//                                    dataBean.setEfFullBeanObjectValue(tempKey, tempValue);
//                                //}
//                            }
//                        }
//                    }
//                }
//            }catch (Exception e){
//                logger.error("Can't get har entry data ...! ; "+e.getMessage());
//                harEntries = null;
//            }
//            harEntries = null;
//        }else {
//            logger.error("ProxyServer OR harFilter is NULL ....!");
//            return null;
//        }
//        return dataBean;
//    }
//
//    /**
//     * Get getHarPostDataParamList
//     * @param myProxyServer
//     * @param harFilter
//     * @return List<HarPostDataParam>
//     *
//     */
//    protected  List<HarPostDataParam> getHarPostDataParamList(BrowserMobProxy myProxyServer, String harFilter){
//        logger.info("getBasicPostDataHandler harFilter used is :"+harFilter);
//        int count = -1;
//        List<HarPostDataParam>  harPostDataParamsList;
//        List<HarEntry> harEntries;
//
//        if(myProxyServer != null && harFilter != null) {
//            harEntries = getHarEntries(proxyServer);
//            if(harEntries.isEmpty()){
//                logger.info("Get Har entries [har.getLog().getEntries()] returned empty collection ....! So returning empty result ...! ");
//                return Collections.emptyList();
//            }
//            /*** process data        */
//            logger.info("Filter is ["+harFilter+"]");
//            harPostDataParamsList = getPostDataParametersList(harEntries, harFilter);
//
//            if(harPostDataParamsList == null || harPostDataParamsList.isEmpty()) {
//                logger.warn("Returning empty collection ....!");
//                return Collections.emptyList();
//            }
//        }else {
//            logger.error("ProxyServer OR harFilter is NULL ....!");
//            return Collections.emptyList();
//        }
//        return harPostDataParamsList;
//    }
//
//    protected  String getHarRequestPostDataText(BrowserMobProxy myProxyServer, String harFilter, String postDataTextContains){
//        logger.info("getBasicPostDataHandler harFilter used is :"+harFilter);
//        int count = -1;
//        String requestPostDataText = "";
//        List<HarEntry> harEntries ;
//
//        if(myProxyServer != null && harFilter != null && postDataTextContains !=null) {
//            harEntries = getHarEntries(proxyServer);
//            if(harEntries.isEmpty()){
//                logger.info("Get Har entries [har.getLog().getEntries()] returned empty collection ....! So returning empty result ...! ");
//                return requestPostDataText;
//            }
//            /*** process data        */
//            logger.info("Filter is ["+harFilter+"]");
//            requestPostDataText = getRequestPostDataText(harEntries, harFilter, postDataTextContains);
//
//            if(StringUtils.isBlank(requestPostDataText)) {
//                logger.warn("Returning empty/null String ....!");
//                requestPostDataText = "";
//            }
//        }else {
//            logger.error("ProxyServer OR harFilter/searchStr is NULL ....!");
//        }
//        return requestPostDataText;
//    }
//
//    /**
//     * Get list of HarNaemValuePair
//     *
//     * @param myProxyServer
//     * @param harFilter
//     * @param postDataTextContains
//     *
//     * @return : list or empty collection
//     */
//    protected  List<HarNameValuePair> getHarRequestPostDataOrQueryString(BrowserMobProxy myProxyServer, String harFilter, String postDataTextContains){
//        logger.info("getBasicPostDataHandler harFilter used is :"+harFilter);
//        List<HarEntry> harEntries ;
//        List<HarNameValuePair> harNameValuePairList ;
//
//        if(myProxyServer != null && harFilter != null && postDataTextContains !=null) {
//            harEntries = getHarEntries(proxyServer);
//            if(harEntries.isEmpty()){
//                logger.info("Get Har entries [har.getLog().getEntries()] returned empty collection ....!" +
//                        " So returning empty HarNameValuePair result ...! ");
//                return Collections.emptyList();
//            }
//            /*** process data        */
//            logger.info("Filter is ["+harFilter+"]");
//            harNameValuePairList = getRequestPostDataOrQueryString(harEntries, harFilter);
//            /*if(harNameValuePairList.isEmpty()) {     logger.warn("Returning empty/null List harNameValuePairList ....!");       harNameValuePairList = Collections.emptyList();           }*/
//        }else {
//            logger.error("ProxyServer OR harFilter/searchStr is NULL ....!");
//            harNameValuePairList = Collections.emptyList();
//        }
//        return harNameValuePairList;
//    }
//
//    /**
//     * Get getHarPostDataQueryStringList
//     * @param proxyServer
//     * @param harFilter
//     * @return List<HarNameValuePair>
//     *
//     */
//    protected  List<HarNameValuePair> getHarPostDataQueryStringList(BrowserMobProxy proxyServer, String harFilter){
//        logger.info("Filter used is ["+harFilter+"]");
//        int count = -1;
//        List<HarNameValuePair>  queryNameValueList ;
//        List<HarEntry> harEntries  ;
//
//        if(proxyServer != null && harFilter != null) {
//            harEntries = getHarEntries(proxyServer);
//            if(harEntries.isEmpty()){
//                logger.info("Get Har entries [har.getLog().getEntries()] returned empty collection ....! So returning empty result ...! ");
//                return Collections.emptyList();
//            }
//            /*** process data        */
//            queryNameValueList = getPostDataQueryStringValuePairList(harEntries, harFilter);
//            if(queryNameValueList.isEmpty()) {
//                logger.warn("Returning empty collection ....!");
//                return Collections.emptyList();
//            }
//        }else {
//            if(isDebug)logger.error("ProxyServer OR harFilter is NULL ....!");
//            return Collections.emptyList();
//        }
//        return queryNameValueList;
//    }
//
//    /**
//     * Get A list of HarEntries using > har.getLog().getEntries()
//     * @param proxyServer
//     * @return   Return a list of an empty collection
//     */
//    private List<HarEntry> getHarEntries(BrowserMobProxy proxyServer){
//        List<HarEntry> harEntries ;
//        try{
//            Har har = proxyServer.getHar();
//            if(har== null){
//                logger.error("Can't create/get har from proxy ...!");
//                return Collections.emptyList();
//            }
//            harEntries = har.getLog().getEntries();
//
//            if(null == harEntries || harEntries.isEmpty() ){
//                logger.error("harEntries Null / Empty return empty list ...!");
//                return Collections.emptyList();
//            }
//        }catch (Exception e){
//            logger.error("Can't get harEntries ...! "+e.getMessage());
//            return Collections.emptyList();
//        }
//        return harEntries;
//    }
//
//    /**
//     * Get Request post data using getRequest().getPostData()
//     * @param harEntries
//     * @return List<HarPostDataParam>
//     *
//     */
//    private List<HarPostDataParam> getPostDataParametersList(List<HarEntry> harEntries, String harFilter){
//        List<HarPostDataParam>  harPostDataParamsList = new ArrayList<HarPostDataParam>() ;
//        int count = -1;
//
//        try {
//            for (HarEntry entry : harEntries) {
//                count++;
//                if(isDebug)logger.info("Count No ["+count+"] Request URL is :>"+entry.getRequest().getUrl());
//
//                if (entry.getRequest().getUrl().contains(harFilter)) {
//                    logger.info(" filter match url ...!");
//
//                    if(entry.getRequest().getPostData() != null) {
//                        if(isDebug)logger.info("entry.getRequest().getPostData().getParams() ....!");
//                        try {
//                            harPostDataParamsList = entry.getRequest().getPostData().getParams();
//                        }catch (Exception e){
//                            e.printStackTrace();
//                            logger.info(" Exception ... entry.getRequest().getPostData().getParams() "+e.getMessage());
//                            return Collections.emptyList();
//                        }
//                        if(harPostDataParamsList == null || harPostDataParamsList.isEmpty()) {
//                            logger.info("Could not get PostDataParameters, returning empty collection ....!");
//                            return Collections.emptyList();
//                        }
//                    } else {
//                        if(isDebug)logger.warn("entry.getRequest().getPostData() is null , so returning empty collection ....!");
//                        return Collections.emptyList();
//                    }
//                }
//            }
//        }catch (Exception e){
//            logger.error("Can't get posted data parameters, returning empty collection ...! ; "+e.getMessage());
//            return Collections.emptyList();
//        }
//
//        return harPostDataParamsList;
//    }
//
//    /**
//     * Get the text of post data that match str - entry.getRequest().getPostData().getText()
//     * @param harEntries
//     * @param harFilter
//     * @param postDataTextContains
//     * @return
//     */
//    private String getRequestPostDataText(List<HarEntry> harEntries, String harFilter, String postDataTextContains){
//        String   postDataText = "";
//        int count = -1;
//
//        try {
//            for (HarEntry entry : harEntries) {
//                count++;
//                if(isDebug)logger.info("Count No ["+count+"] Request URL is :>"+entry.getRequest().getUrl());
//
//                if (entry.getRequest().getUrl().contains(harFilter)) {
//                    logger.info(" filter match url ...!");
//
//                    if(entry.getRequest().getPostData() != null) {
//                        if(isDebug)logger.info("entry.getRequest().getPostData().getParams() ....!");
//                        try {
//                            postDataText = entry.getRequest().getPostData().getText();
//                            if(StringUtils.containsIgnoreCase(postDataText, postDataTextContains)){
//                                logger.info(" Found matching string ["+postDataTextContains+"] ; "+postDataText);
//                                return postDataText;
//                            }
//                        }catch (Exception e){
//                            e.printStackTrace();
//                            logger.info(" Excepiton ... entry.getRequest().getPostData().getText() "+e.getMessage());
//                        }
//                    } else {
//                        if(isDebug)logger.warn("entry.getRequest().getPostData() is null , so returning empty String  ....!");
//                    }
//                }
//            }
//        }catch (Exception e){
//            logger.error("Can't get posted data parameters, returning empty collection ...! ; "+e.getMessage());
//            return postDataText;
//        }
//        if(StringUtils.isBlank(postDataText))
//            logger.info("Could not get PostData text is empty or NULL ....!");
//
//        return postDataText;
//    }
//
//    /**
//     * Get Request Post Data Or Query String parameters if post data is null based on the filter
//     *
//     * Returns: a list of  Name Value pair or Collections.emptyList();
//     *
//     *
//     */
//    private List<HarNameValuePair> getRequestPostDataOrQueryString(List<HarEntry> harEntries, String harFilter){
//        HarPostData  harPostDataList            = null;  // list of HarPostDataParam
//        List<HarNameValuePair> harNameValuePair = null;
//
//        int count = -1;
//
//        try {
//            for (HarEntry entry : harEntries) {
//                count++;
//                if(isDebug)logger.info("Count No ["+count+"] Request URL is :>"+entry.getRequest().getUrl());
//
//                if (entry.getRequest().getUrl().contains(harFilter)) {
//                    logger.info(" filter match url ...!");
//
//                    if(entry.getRequest().getPostData() != null) {
//                        if(isDebug)logger.info("entry.getRequest().getPostData().getParams() ....!");
//                        try {
//                            harPostDataList = entry.getRequest().getPostData();
//
//                            for(HarPostDataParam dataParam: harPostDataList.getParams()){
//                                harNameValuePair.add(new HarNameValuePair(dataParam.getName(), dataParam.getValue()) );
//                            }
//                        }catch (Exception e){
//                            logger.error(" Exception ... entry.getRequest().getPostData().getParams() "+e.getMessage());
//                            harNameValuePair = Collections.emptyList();
//                        }
//                    } else {
//                        try {
//                            if(entry.getRequest() != null && entry.getRequest().getQueryString() != null) {
//                                harNameValuePair = entry.getRequest().getQueryString();
//                            } else {
//                                harNameValuePair = Collections.emptyList();
//                            }
//                        }catch (Exception e){
//                            logger.error(" Exception ... entry.getRequest().getPostData().getText() "+e.getMessage());
//                            harNameValuePair  = Collections.emptyList();
//                        }
//                    }
//                }
//            }
//        }catch (Exception e){
//            logger.error("Can't get posted data parameters, returning empty collection ...! ; "+e.getMessage());
//            return Collections.emptyList();
//        }
//        if(harNameValuePair.isEmpty()) logger.warn("Returning empty collection ..! ");
//        return harNameValuePair;
//    }
//
//    public HarNameValuePair getHarNameValuePair(List<HarNameValuePair> nameValuePairList, String keyName) {
//        for(HarNameValuePair nameValuePair : nameValuePairList){
//            if(StringUtils.containsIgnoreCase(nameValuePair.getName(), keyName)){
//                logger.info(" Found matching keyName ["+keyName+"] ; Pair ["+nameValuePair.toString()+"]");
//                return nameValuePair;
//            }
//        }
//        logger.info("Did Not Find matching key Name ["+keyName+"] ....! Returning empty HarNameValuePair");
//        return new HarNameValuePair("","");
//    }
//
//    /**
//     * Get Request query string parameters using getRequest.getQueryString()
//     * @param harEntries
//     * @return List<HarNameValuePair>
//     *
//     */
//    private List<HarNameValuePair> getPostDataQueryStringValuePairList(List<HarEntry> harEntries, String harFilter){
//        List<HarNameValuePair>  harPostDataQueryStringParams = new ArrayList<HarNameValuePair>();
//        int count = -1;
//        try {
//            for (HarEntry entry : harEntries) {
//                count++;
//                if(isDebug)logger.info("Count No ["+count+"] Request URL is :>"+entry.getRequest().getUrl());
//
//                if (entry.getRequest().getUrl().contains(harFilter)) {
//                    logger.info(" filter match url ...!");
//
//                    if(entry.getRequest() != null && entry.getRequest().getQueryString() != null) {
//                        if(isDebug)logger.info("entry.getRequest().getQueryString() ....!");
//                        harPostDataQueryStringParams = entry.getRequest().getQueryString();
//                    } else {
//                        if(isDebug)logger.warn("entry.getRequest().getQueryString(); , so returning empty collection ....!");
//                        return Collections.emptyList();
//                    }
//                }
//            }
//        }catch (Exception e){
//            logger.error("Can't get posted data Query String params, returning empty collection ...! ; "+e.getMessage());
//            return Collections.emptyList();
//        }
//        if(harPostDataQueryStringParams == null || harPostDataQueryStringParams.isEmpty()) {
//            logger.info("Could not get PostDataParameters, returning empty collection ....!");
//            return Collections.emptyList();
//        }
//        return harPostDataQueryStringParams;
//    }
//
//    /**
//     * Get data from har ... filter on url
//     * @param myProxyServer
//     * @param harFilter
//     * @return
//     * @throws NullPointerException
//     */
//    protected BuyWithCreditCardPostBean getPayPostDataBeanSetResponseObj(BrowserMobProxy myProxyServer, String harFilter) throws NullPointerException{
//        logger.info("getBasicPostDataHandler harFilter used is :"+harFilter);
//        BuyWithCreditCardPostBean dataBean = null;
//        String tempKey  = null;
//        String tempValue = null;
//
//        if(myProxyServer != null && harFilter != null) {
//            //validate har
//            Har har = proxyServer.getHar();
//            if(har== null){
//                logger.error("Can't create/get har from proxy ...!");
//                return null;
//            }
//            //validate har
//            List<HarEntry> harEntries = null;
//            try {
//                harEntries = har.getLog().getEntries();
//                har=null;
//                if(harEntries.isEmpty()== true || harEntries.size() == 0){
//                    logger.error("harEntries empty ...!");
//                    return null;
//                }
//            }catch (Exception e){
//                logger.error("Can't get harEntries ...!");
//                return null;
//            }
//            //process data
//            try {
//                dataBean = new BuyWithCreditCardPostBean();
//                for (HarEntry entry : harEntries) {
//                    tempKey  = null;
//                    tempValue = null;
//                    //Test response
//                    if (entry.getRequest().getUrl().contains(harFilter)) {
//                        logger.info(" HAR  url :" + entry.getRequest().getUrl());
//                        if (entry.getRequest().getPostData() != null) {
//                            HarResponse harResponse = entry.getResponse();
//                            logger.warn("Response code sometime does not work ...! issue with post and proxy implementation ...!");
//                            int responseStatus = harResponse.getStatus();
//                            HarContent harContentResponse = harResponse.getContent();
//                            logger.info("Response : "+harContentResponse.getText()); //for pay {"Result":14522603,"Success":true}
//                            logger.info("isPaymentHandler ....!");
//                            basicResponseDataHandler = BasicResponseDataHandler.setPayPostResponseObject(harContentResponse.getText(), responseStatus);
//
//                            List<HarPostDataParam> harPostDataParamsList = entry.getRequest().getPostData().getParams();
//
//                            for (HarPostDataParam hpdp : harPostDataParamsList) {
//                                tempKey = hpdp.getName();
//                                tempValue = hpdp.getValue();
//                                dataBean.setBenValue(tempKey, tempValue);
//                            }
//                        }
//                    }
//                }
//            }catch (Exception e){
//                logger.error("Can't get har entry data ...! ; "+e.getMessage());
//                harEntries = null;
//            }
//            harEntries = null;
//        }else {
//            logger.error("ProxyServer OR harFilter is NULL ....!");
//            return null;
//        }
//        return dataBean;
//    }
//
//    protected String getOmnitureDataHandler(BrowserMobProxy myProxyServer) throws NullPointerException{
//        String omnitureDataPostedAndResponseStatus = null;
//        harFilter = omnitureHarFilter;
//        logger.info("getBasicPostDataHandler harFilter used is :"+harFilter);
//        BasicPostDataHandler basicPostDataHandler = null;
//        String tempKey  = null;
//        String tempValue = null;
//
//        if(myProxyServer != null && harFilter != null) {
//            //validate har
//            Har har = proxyServer.getHar();
//
//            if(har== null){
//                logger.error("Can't create/get har from proxy ...!");
//            }
//            //validate har
//            List<HarEntry> harEntries = null;
//            try {
//                harEntries = har.getLog().getEntries();
//                if(harEntries.isEmpty()== true || harEntries.size() == 0){
//                    logger.error("harEntries empty ...!");
//                }
//            }catch (Exception e){
//                logger.error("Can't get harEntries ...!");
//            }
//            //process data
//            try {
//                for (HarEntry entry : harEntries) {
//                    if (entry.getRequest().getUrl().contains(harFilter)) {
//
//                        logger.info(" HAR  url :" + entry.getRequest().getUrl());
//                        if (entry.getRequest().getPostData() != null) {
//                            omnitureDataPostedAndResponseStatus = entry.getRequest().getPostData().getText();
//                            HarResponse harResponse = entry.getResponse();
//                            logger.info("*********** Actual harResponse.getStatus() : ["+harResponse.getStatus()+"]");
//                            int responseStatus = -1;
//                            if(StringUtils.equalsIgnoreCase(entry.getRequest().getMethod(), "post")){
//                                logger.warn("Response code faked. So we assume it worked and returned 200 ...! issue with post and proxy implementation ...!");
//                                responseStatus = 200; // when it's post, harResponse is somehow empty, faking it.
//                            } else {
//                                responseStatus = harResponse.getStatus();
//                            }
//
//                            omnitureDataPostedAndResponseStatus = omnitureDataPostedAndResponseStatus+"&ResponseStatus="+responseStatus;
//                            // Response text and status: AQB=1&ndh=1&pf=1&t=11%2F3%2F2016%2012%3A26%3A54%201%20-60&D=D%3D&mid=28851419287931115582181171959228624172&aamlh=6&ce=UTF-8&cdp=2&pageName=LandingPages%3Aee%3Aemailenglish&g=http%3A%2F%2Fenglishlive.ef.com%2Ffr-fr%2Flp%2Fee%2Femailenglish%2F&cc=USD&ch=LandingPages&v0=OmniTestEtagNikol&aamb=cIBAx_aQzFEHcPoEv0GwcQ&c1=omnitestptnnikol%3ALandingPages%3Aee%3Aemailenglish&h1=omnitestptnnikol%2CLandingPages%2Cee%3Aemailenglish&c2=LandingPages%3Aee%3Aemailenglish&h2=omnitestptnnikol%2CLandingPages%2Cee%3Aemailenglish&c3=omnitestptnnikol%3ALandingPages%3Aee%3Aemailenglish&h3=LandingPages%2Cee%3Aemailenglish&c4=fr%3ALandingPages%3Aee%3Aemailenglish&h4=LandingPages%2Cee%3Aemailenglish&c5=OmniTestEtagNikol%3A%5BLandingPages%3Aee%3Aemailenglish%5D&v5=OmniTestEtagNikol%3A%5BLandingPages%3Aee%3Aemailenglish%5D&v6=LandingPages%3Aee%3Aemailenglish&v7=omnitestptnnikol%3ALandingPages%3Aee%3Aemailenglish&c8=071b72ec-2679-4355-b324-8dcbec02ed28&v8=LandingPages%3Aee%3Aemailenglish&c9=http%3A%2F%2Fenglishlive.ef.com%2Ffr-fr%2Flp%2Fee%2Femailenglish%2F&v9=omnitestptnnikol%3ALandingPages%3Aee%3Aemailenglish&c11=omnitestptnnikol&v11=omnitestptnnikol&c12=fr&v12=fr&c13=omnitestptnnikol%3Afr&v13=omnitestptnnikol%3Afr&v14=071b72ec-2679-4355-b324-8dcbec02ed28&c15=fr-fr&v15=fr-fr&c16=englishlive.ef.com&v16=englishlive.ef.com&c17=LandingPages&v17=LandingPages&c18=LandingPages%3Aee&v18=LandingPages%3Aee&c19=omnitestptnnikol%3ALandingPages&v19=omnitestptnnikol%3ALandingPages&c20=omnitestptnnikol%3ALandingPages%3Aee&v20=omnitestptnnikol%3ALandingPages%3Aee&c21=Visitor&v21=Visitor&c23=New&v23=New&c24=omnitestptnnikol&v24=omnitestptnnikol&c25=fr&v25=fr&c26=omnitestptnnikol%3Afr&v26=omnitestptnnikol%3Afr&c27=LandingPages&v27=LandingPages&c28=LandingPages%3Aee&v28=LandingPages%3Aee&c29=omnitestptnnikol%3ALandingPages&v29=omnitestptnnikol%3ALandingPages&c30=omnitestptnnikol%3ALandingPages%3Aee&v30=omnitestptnnikol%3ALandingPages%3Aee&v39=omnitestptnnikol%3ALandingPages%3Aee%3Aemailenglish&v40=omnitestptnnikol%3ALandingPages%3Aee%3Aemailenglish&v41=LandingPages%3Aee%3Aemailenglish&v45=LandingPages&v47=LandingPages%3Aee&c48=49&v48=omnitestptnnikol%3ALandingPages&v49=omnitestptnnikol%3ALandingPages%3Aee&v51=omnitestptnnikol&v52=LandingPages&v53=LandingPages%3Aee%3Aemailenglish&v58=OmniTestEtagNikol&v59=omnitestptnnikol&v60=OmniTestEtagNikol&v61=omnitestptnnikol&s=1920x1080&c=24&j=1.8.5&v=Y&k=Y&bw=1858&bh=1009&AQE=1&ResponseStatus=200
//                            logger.info(" Omniture Response text and status: "+omnitureDataPostedAndResponseStatus);
//                        }
//                    }
//                }
//            }catch (Exception e){
//                logger.error("Can't get har entry data ...! ; "+e.getMessage());
//            }
//        }else {
//            logger.error("ProxyServer OR harFilter is NULL ....!");
//        }
//        return omnitureDataPostedAndResponseStatus;
//    }
//
//    /**
//     *
//     * @param myProxyServer
//     * @param urlHarFilter
//     * @param paramName   e.g emaillist [param has name value etc]
//     * @return
//     * @throws NullPointerException
//     */
//    public HarPostDataParam getHarPostDataParam(BrowserMobProxy myProxyServer, String urlHarFilter, String paramName) throws NullPointerException{
//        logger.info("getSimplleEntryPostData harFilter used is :"+urlHarFilter);
//        HarPostDataParam postDataParam = new HarPostDataParam();
//        Har har = null;
//        int noOfTry = 2;
//        logger.info("noOfTry : "+noOfTry);
//
//        if(myProxyServer != null && urlHarFilter != null) {
//            while (noOfTry > 0) {
//                TestUtil.mySleep(990);
//                har = proxyServer.getHar();
//                if(null != har) break;
//                noOfTry--;
//            }
//            if(har == null)  return null;
//
//            List<HarEntry> harEntries = null;
//            try {
//                harEntries = har.getLog().getEntries();
//                har = null;
//                if(harEntries.isEmpty()== true || harEntries.size() == 0){
//                    logger.error("harEntries empty ...!");
//                    return null;
//                }
//            }catch (Exception e){
//                logger.error("Can't get harEntries ...!"+e.getMessage());
//                return null;
//            }
//            try {
//                for (HarEntry entry : harEntries) {
//                    if (entry.getRequest().getUrl().contains(urlHarFilter)) {
//                        logger.info(" HAR  url :" + entry.getRequest().getUrl());
//                        if (entry.getRequest().getPostData() != null) {
//                            List<HarPostDataParam>  paramList = entry.getRequest().getPostData().getParams();
//                            if(null != paramList && !paramList.isEmpty()){
//                                for(HarPostDataParam harParam : paramList){
//                                    if( paramName.equals(harParam.getName()) ){
//                                        logger.info("Found parameter name ["+paramName+"]");
//                                        postDataParam = harParam;                                             //postDataParam = entry.getRequest().getPostData().getParams().get(nameValueId);
//                                        logger.info("Found HarPostDataParam ["+postDataParam.toString()+"]");
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }
//            }catch (Exception e){
//                logger.error("Can't get har entry data ...! ; "+e.getMessage());
//                harEntries = null;
//            }
//            harEntries = null;
//        }else {
//            logger.error("ProxyServer OR harFilter is NULL ....!");
//            return null;
//        }
//        return postDataParam;
//    }
//
//    //***************************************************************
//    protected void blockTraffic( BrowserMobProxy proxyServer ){
//        // This are the patterns of our sites, in real life there are more...
//        ///////List<String> allowUrlPatterns = new ArrayList<String>();
//        ///////allowUrlPatterns.add("https?://.*(newhomesource.com)+.*");
//        // All the URLs that are not from our sites are blocked and a status code of 403 is returned
//        ////// proxyServer.whitelistRequests(allowUrlPatterns, 404);
//    }
//
//    protected void storeHar(Har har, String fileName){
//        try {
//            FileOutputStream fos = new FileOutputStream(fileName);
//            har.writeTo(fos);
//        }catch (Exception e){e.printStackTrace();}
//    }
//
//
//
//    public static void stopProxy() {
//        try {
//            if(null != proxyServer && proxyServer.isStarted()) {
//                proxyServer.stop();
//            }else
//                logger.warn("Proxy server is not started or is Null...!");
//        }catch (Exception e){
//            logger.error("cleanUpDriverAndProxyServer ... "+e.getMessage());
//            //e.printStackTrace();
//        }
//    }
//
//
//}
//
//
////----------------------------------------------------------------------------------------------------------------------
//
///**
//
// public static WebDriver getJBrowser(){
// WebDriver driver = new JBrowserDriver();
// Settings.Builder builder = Settings.builder();                                                                  // DesiredCapabilities capabilities =  new DesiredCapabilities("jbrowserdriver", "1", Platform.ANY);// builder.headless(false);
// builder.userAgent(UserAgent.CHROME);
// builder.javascript(true);                                                                                       //builder.ssl("trustanything");        //builder.ports(12345);        //Settings.builder().ssl("compatible").javaOptions("-Djsse.enableSNIExtension=false").hostnameVerification(false).build()        //builder.ssl("compatible").javaOptions("-Djsse.enableSNIExtension=false").hostnameVerification(false).build();
// builder.javaOptions("-Duser.language=en", "-Duser.country=GB");                                                 //https://github.com/MachinePublishers/jBrowserDriver/issues/139
// try {
// driver = new JBrowserDriver(builder.build());                                                                 //MyRemoteWebDriver.setupSystemProperties(GECKO_DRIVER_KEY,  GECKO_DRIVER_FILENAME );          //MyRemoteWebDriver.setupSystemProperties(CHROME_DRIVER_KEY, CHROME_DRIVER_FILENAME );`
// }catch (Exception e){
// e.printStackTrace();
// Assert.fail("Can't get JBrowser ...! "+e.getMessage());
// }
// return driver;
// }
//
// /**
// * headles browser with proxy
// * @param testUrl
// * // not working builder.javaOptions("-Duser.language=en", "-Duser.country=US");
// * // @ char is typed as " on gui ... if(isShowBrowserGui) System.setProperty("jbd.browsergui", "true"); // @ is sent as "
// *
//public static void getJBrowserProxyDriver(WebDriver driver, String testUrl){
//    setupAndStartProxy(proxyPort);
//    Settings.Builder builder = Settings.builder();        //builder.userAgent(UserAgent.CHROME);             // Settings.builder();     builder.timezone(Timezone.EUROPE_BERLIN);
//    builder.timezone(Timezone.EUROPE_ROME);               //System.setProperty("jbd.browsergui", "true");        //builder.ajaxWait(5000)  ;        //builder.ssl("C:\\selenium\\crt.crt"); //crt.crt"); fiddler.cer
//    builder.ssl("trustanything");                         //builder.ssl(testUrl); //String ssl = "https://gist.githubusercontent.com/krmahadevan/59b45361fd39e6df125b16b2443a5ce7/raw/213c0fccba5585fc4e3f5caea24ad1b0d1aadbe2/local-certs.crt";
//    builder.proxy(proxyConfig);
//
//    driver = new JBrowserDriver(builder.build());
//    if(isShowBrowserGui)
//        driver.manage().window().maximize();
//    BaseRemoteWebDriver.setCurrentBrowserName("jbrowser");
//}
// */