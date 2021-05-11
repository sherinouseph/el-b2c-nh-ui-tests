//package com.englishtown.helpers.utils.urlstatuschecker;
//
///**
// * Created by nikol.marku on 28/04/2016.
// *
// *
// * http://ardesco.lazerycode.com/index.php/2012/07/how-to-download-files-with-selenium-and-why-you-shouldnt/
// */
//
//import org.apache.http.client.HttpClient;
//import org.apache.http.client.methods.HttpRequestBase;
//import org.apache.http.client.params.ClientPNames;
//import org.apache.http.client.protocol.ClientContext;
//import org.apache.http.impl.client.BasicCookieStore;
//import org.apache.http.impl.client.DefaultHttpClient;
//import org.apache.http.impl.cookie.BasicClientCookie;
//import org.apache.http.params.HttpParams;
//import org.apache.http.protocol.BasicHttpContext;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.openqa.selenium.Cookie;
//import org.openqa.selenium.WebDriver;
//import org.apache.http.HttpResponse;
//import java.io.IOException;
//import java.net.MalformedURLException;
//import java.net.URI;
//import java.net.URISyntaxException;
//import java.net.URL;
//import java.util.Set;
//
//public class URLStatusChecker {
//
//    private static final Logger LOG = LoggerFactory.getLogger(URLStatusChecker.class);
//    private URI linkToCheck;
//    private WebDriver driver;
//    private boolean mimicWebDriverCookieState = false;
//    private boolean followRedirects = false;
//    private RequestMethod httpRequestMethod = RequestMethod.GET;
//
//
//    public URLStatusChecker() {
//
//    }
//
//    public URLStatusChecker(WebDriver driverObject) throws MalformedURLException, URISyntaxException {
//        this.driver = driverObject;
//    }
//
//
//    /**
//     * Specify a URL that you want to perform an HTTP Status Check upon
//     *
//     * @param linkToCheck
//     * @throws MalformedURLException
//     * @throws URISyntaxException
//     */
//    public void setURIToCheck(String linkToCheck) throws MalformedURLException, URISyntaxException {
//        this.linkToCheck = new URI(linkToCheck);
//    }
//
//    /**
//     * Specify a URL that you want to perform an HTTP Status Check upon
//     *
//     * @param linkToCheck
//     * @throws MalformedURLException
//     */
//    public void setURIToCheck(URI linkToCheck) throws MalformedURLException {
//        this.linkToCheck = linkToCheck;
//    }
//
//    /**
//     * Specify a URL that you want to perform an HTTP Status Check upon
//     *
//     * @param linkToCheck
//     */
//    public void setURIToCheck(URL linkToCheck) throws URISyntaxException {
//        this.linkToCheck = linkToCheck.toURI();
//    }
//
//    /**
//     * Set the HTTP Request Method (Defaults to 'GET')
//     *
//     * @param requestMethod
//     */
//    public void setHTTPRequestMethod(RequestMethod requestMethod) {
//        this.httpRequestMethod = requestMethod;
//    }
//
//    /**
//     * Should redirects be followed before returning status code?
//     * If set to true a 302 will not be returned, instead you will get the status code after the redirect has been followed
//     * DEFAULT: false
//     *
//     * @param value
//     */
//    public void followRedirects(Boolean value) {
//        this.followRedirects = value;
//    }
//
//    /**
//     * Perform an HTTP Status check and return the response code
//     *
//     * @return
//     * @throws IOException
//     */
//    public int getHTTPStatusCode() throws IOException {
//
//        HttpClient client = new DefaultHttpClient();
//        BasicHttpContext localContext = new BasicHttpContext();
//
//        LOG.info("Mimic WebDriver cookie state: " + this.mimicWebDriverCookieState);
//        if (this.mimicWebDriverCookieState) {
//            localContext.setAttribute(ClientContext.COOKIE_STORE, mimicCookieState(this.driver.manage().getCookies()));
//        }
//        HttpRequestBase requestMethod = this.httpRequestMethod.getRequestMethod();
//        requestMethod.setURI(this.linkToCheck);
//        HttpParams httpRequestParameters = requestMethod.getParams();
//        httpRequestParameters.setParameter(ClientPNames.HANDLE_REDIRECTS, this.followRedirects);
//        requestMethod.setParams(httpRequestParameters);
//
//        LOG.info("Sending " + requestMethod.getMethod() + " request for: " + requestMethod.getURI());
//        HttpResponse response = client.execute(requestMethod, localContext);
//        LOG.info("HTTP " + requestMethod.getMethod() + " request status: " + response.getStatusLine().getStatusCode());
//
//        return response.getStatusLine().getStatusCode();
//    }
//
//    /**
//     * Mimic the cookie state of WebDriver (Defaults to true)
//     * This will enable you to access files that are only available when logged in.
//     * If set to false the connection will be made as an anonymouse user
//     *
//     * @param value
//     */
//    public void mimicWebDriverCookieState(boolean value) {
//        this.mimicWebDriverCookieState = value;
//    }
//
//    /**
//     * Load in all the cookies WebDriver currently knows about so that we can mimic the browser cookie state
//     *
//     * @param seleniumCookieSet
//     * @return
//     */
//    private BasicCookieStore mimicCookieState(Set<Cookie> seleniumCookieSet) {
//        BasicCookieStore mimicWebDriverCookieStore = new BasicCookieStore();
//        for (Cookie seleniumCookie : seleniumCookieSet) {
//            BasicClientCookie duplicateCookie = new BasicClientCookie(seleniumCookie.getName(), seleniumCookie.getValue());
//            duplicateCookie.setDomain(seleniumCookie.getDomain());
//            duplicateCookie.setSecure(seleniumCookie.isSecure());
//            duplicateCookie.setExpiryDate(seleniumCookie.getExpiry());
//            duplicateCookie.setPath(seleniumCookie.getPath());
//            mimicWebDriverCookieStore.addCookie(duplicateCookie);
//        }
//
//        return mimicWebDriverCookieStore;
//    }
//
////    @Test
////    public void statusCode404FromString() throws Exception {
////        WebDriver driver = new FirefoxDriver();
////        String webServerURL = "englishlive.ef.com/de-de/";
////        URLStatusChecker urlChecker = new URLStatusChecker(driver);
////        // urlChecker.setURIToCheck(webServerURL + ":" + webServerPort + "/doesNotExist.html");
////        urlChecker.setURIToCheck(webServerURL + "/doesNotExist.html");
////        urlChecker.setHTTPRequestMethod(RequestMethod.GET);
////        Assert.assertEquals(urlChecker.getHTTPStatusCode(), 404, " Not 404 response ...!");
////    }
//}