package com.englishtown.helpers;
/*****************************************************************************
 *
 * Responsible for check content
 *  for responses not available on WebDriver . e.g response code
 *  and headless browser tests
 *
 *  Note: there is a java web request helper here as well : HttpURLConnection
 *
 *  REF ... http://ardesco.lazerycode.com/index.php/2012/07/how-to-download-files-with-selenium-and-why-you-shouldnt/
 ****************************************************************************/
import com.englishtown.dataprovider.bin.TestResponseBean;
import com.englishtown.helpers.bean.MyHttpResponse;
import com.englishtown.helpers.utils.TestUtil;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebClientOptions;
import com.gargoylesoftware.htmlunit.WebResponse;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

//import static net.sourceforge.htmlunit.corejs.javascript.Kit.readStream;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.core.IsNot.not;

// TODO clean up
public class WebClientResponseHelper {
    protected static final Logger logger = LoggerFactory.getLogger(WebClientResponseHelper.class);

    protected static final int headlessRequestTimeout = 25000 ; // milliseconds

    public boolean isThrowExceptionOnFailingStatusCode = true;
    public boolean isPrintContentOnFailingStatusCode = true;
    public boolean isJavaScriptEnabled = true;
    public boolean isRedirectEnabled = true;
    public boolean isUseInsecureSSL = true;
    public String response = "-1";
    public String currentUrl;   /// current request/response url

    public boolean isGetResponseAsString = true;


    public WebClientResponseHelper(){}

    public WebClientResponseHelper(boolean isJavaScriptEnabled, boolean isThrowExceptionOnFailingStatusCode,
                                   boolean isPrintContentOnFailingStatusCode, boolean isRedirectEnabled){
        this.isJavaScriptEnabled                 = isJavaScriptEnabled;
        this.isThrowExceptionOnFailingStatusCode = isThrowExceptionOnFailingStatusCode;
        this.isPrintContentOnFailingStatusCode   = isPrintContentOnFailingStatusCode;
        this.isRedirectEnabled                   = isRedirectEnabled; // as we need to get the first response code
    }

    public WebClientResponseHelper(boolean isThrowExceptionOnFailingStatusCode, boolean isPrintContentOnFailingStatusCode,
                                   boolean isJavaScriptEnabled, boolean isRedirectEnabled, boolean isUseInsecureSSL,
                                   String response, String currentUrl) {
        this.isThrowExceptionOnFailingStatusCode = isThrowExceptionOnFailingStatusCode;
        this.isPrintContentOnFailingStatusCode = isPrintContentOnFailingStatusCode;
        this.isJavaScriptEnabled = isJavaScriptEnabled;
        this.isRedirectEnabled = isRedirectEnabled;
        this.isUseInsecureSSL = isUseInsecureSSL;
        this.response = response;
        this.currentUrl = currentUrl;
    }

    public void setOptions(boolean option) {
        logger.info("set web clent options ...! to :"+option);
        isThrowExceptionOnFailingStatusCode = option;
        isPrintContentOnFailingStatusCode = option;
        isJavaScriptEnabled = option;
        isRedirectEnabled = option;
        isUseInsecureSSL = option;
    }
    /************************************************************
     * Open URL and get response code
     * @return response code or -1
     */
    public int getWebClientResponseCode(String url) {
        logger.info("getWebClientResponseCode for URL ["+url+"]");
        int responseCode = -1;
        WebClient client = new WebClient(BrowserVersion.CHROME);
        setWebClientOptions(client);
        responseCode = getResponseCode(client, url);
        logger.info("getWebClientResponseCode as string .....!");
        response = getResponseAsString(client, url);
        client.close();
        return responseCode;
    }
    //MyHttpResponse
    public MyHttpResponse geMyHttpResponse(String url) {
        logger.info("geMyHttpResponse for URL ["+url+"]");
        MyHttpResponse responseObj = null;
        WebClient client = new WebClient();
        setWebClientOptions(client);
        responseObj = new MyHttpResponse(getResponseCode(client, url),getResponseAsString(client, url) );
        client.close();
        return responseObj;
    }
    /************************************************************
     * Open URL and get response code
     * @return response source code or -1
     */
    public String getWebClientResponseContent(String url) {
        logger.info("getWebClientResponseContent ...!");
        WebClient client = new WebClient();
        setWebClientOptions(client);
        response = getResponseAsString(client, url);
        client.close();
        logger.info("Response is : \n"+response);
        return response;
    }

    /**
     * setup Options or a web client
     */
    public void setWebClientOptions(WebClient client){
        WebClientOptions options = client.getOptions();
        options.setTimeout(headlessRequestTimeout);
        options.setThrowExceptionOnFailingStatusCode(isThrowExceptionOnFailingStatusCode);
        options.setThrowExceptionOnScriptError(false);
        /*
        options.setCssEnabled(true);
        options.setDownloadImages(false);
        options.setScreenWidth(1600);
        options.setScreenHeight(1100);
        */
        options.setPrintContentOnFailingStatusCode(isPrintContentOnFailingStatusCode);
        options.setJavaScriptEnabled(isJavaScriptEnabled);
        options.setRedirectEnabled(isRedirectEnabled);
        options.setUseInsecureSSL(isUseInsecureSSL);
    }

    public void setWebClientOptions(WebClient client, int timeOutMlSec, boolean isThrowExceptionOnFailure,
                                           boolean isPrintContentOnFailure, boolean isJSenabled,
                                           boolean isRedirectEnabled, boolean isUseInsecure){
        WebClientOptions options = client.getOptions();
        options.setTimeout(timeOutMlSec);
        options.setThrowExceptionOnFailingStatusCode(isThrowExceptionOnFailure);     //    false
        options.setPrintContentOnFailingStatusCode(isPrintContentOnFailure); //false
        options.setJavaScriptEnabled(isJSenabled); //false
        options.setRedirectEnabled(isRedirectEnabled);//true
        options.setUseInsecureSSL(isUseInsecure);//true
    }

    /**
     * Get Response as String using WebClient
     * @param client
     * @param url
     * @return response or -1
     */
    public String getResponseAsString(WebClient client, String url){
        logger.info("getResponseAsString ...!");
        String response = "-1";
        try {
            if(isGetResponseAsString) {
                response = client.getPage(url).getWebResponse().getContentAsString();
            }else {logger.info("isGetResponseAsString is false so not get this ... as string .....!");}
            //logger.info("response content :"+response);
        } catch (IOException e) {
            //e.printStackTrace();
            logger.error("Can't get response content ... Exception ...!"+e.getMessage());
        }
        return response;
    }

    /**
     * Get response code Using WebClient
     * @param client
     * @param url
     * @return response code or -1
     */
    public int getResponseCode(WebClient client, String url){
        int requestResponseCode = -1;
        WebResponse webResponse = null;
        try {
            webResponse  = client.getPage(url).getWebResponse();
            if(webResponse == null){
                logger.info("Web response is NULL ...! will try again");
                webResponse = client.getPage(url).getWebResponse();
            }
            requestResponseCode = webResponse.getStatusCode();
            logger.info("["+url+"] Response Code  is :["+requestResponseCode+"]");
            // set current url
            try {
                currentUrl = webResponse.getWebRequest().getUrl().toString();
            }catch (Exception e){logger.error("Can't get current url from web client response ...!"+e.getMessage());}
        } catch (IOException e) {
             //e.printStackTrace();
            logger.error("IOException   Can't get response content ... IOException ...!"+e.getMessage());
        }
        catch (Exception e) {
            // e.printStackTrace();
            logger.error("Exception    Can't get response content ... Exception ...!"+e.getMessage());
        }
        return requestResponseCode;
    }


    /**
     * Get http url connection to make a request
     *
     * @param urlString
     * @param isFollowRedirect
     * @param requestMethod   ["GET", "SET"]
     * @param isSetDoOutput
     * @param isSetDoInput
     * @return http url connection or null
     * getHttpUrlConnection(urlString, isFollowRedirect, requestMethod, isSetDoOutput, isSetDoInput);
     *
     * Use null for Output default setting
     */
    public HttpURLConnection getHttpUrlConnection(String urlString, boolean isFollowRedirect, String requestMethod,
                                                  Boolean isSetDoOutput, Boolean isSetDoInput) throws NullPointerException{
        HttpURLConnection huc = null;
        logger.info("Sending GET request to URL {}",urlString);

        try {
            URL url = new URL(urlString);
            huc = (HttpURLConnection) url.openConnection();
            huc.setInstanceFollowRedirects(isFollowRedirect);
            huc.setRequestMethod(requestMethod);

            if(null != isSetDoOutput )
                huc.setDoOutput(isSetDoOutput);     // The default is false.
            if(null != isSetDoOutput )
                huc.setDoInput(isSetDoInput);       // The default is true.

            huc.connect();

        }catch ( IOException e){
            logger.error("IOException  Can't get Response Code for URL ["+urlString+"]  ...! "+e.getMessage());
        }catch ( Exception e){
            logger.error("Exception Can't get Response Code for URL ["+urlString+"]  ...! "+e.getMessage());
        }/*finally {   huc.disconnect();  }*/

        return huc;
    }

    /**
     * Use java to get response code
     *
     * Get Response code using HttpURLConnection and URL
     * @param urlString
     * @return responseCode or -1
     */
    public int getHttpURLConnectionResponseCode(String urlString) {
        HttpURLConnection huc = null;
        int responseCode = -1;

        try {
            /*
            URL url = new URL(urlString);
            huc = (HttpURLConnection) url.openConnection();
            huc.setInstanceFollowRedirects(false);
            huc.setRequestMethod("GET");
            huc.connect();
            */

            huc = getHttpUrlConnection(urlString, false, "GET", null, null);
            responseCode = huc.getResponseCode();
            logger.info("Response code ["+responseCode+"]");
            // set current url            logger.info("huc.getURL().getQuery() url.getQuery() "+huc.getURL().getQuery());
            setCurrentUrl(huc);
            /*
            try {
                currentUrl = huc.getURL().toString();
            }catch (Exception e){logger.error("Can't get current url from web client response ...!"+e.getMessage());}
            */
        }catch ( IOException e){
            logger.error("Can't get Response Code for URL ["+urlString+"]  ...! "+e.getMessage());
        }finally {
            huc.disconnect();
        }
        logger.info("Response Code is ["+responseCode+"] for URL ["+urlString+"]");
        return responseCode;
    }

    /**
     *
     * @param urlString
     * @param isFollowRedirect
     * @return
     */
    public int getHttpURLConnectionResponseCode(String urlString, boolean isFollowRedirect) {
        HttpURLConnection huc = null;
        int responseCode = -1;

        try {
            huc = getHttpUrlConnection(urlString, isFollowRedirect, "GET", true, null);

            readInputStreamToString(huc);

            responseCode = huc.getResponseCode();
            logger.info("Response code ["+responseCode+"]");

            setCurrentUrl(huc);

        }catch ( Exception e){
            logger.error("Can't get Response Code for URL ["+urlString+"]  ...! "+e.getMessage());
        }finally {
            huc.disconnect();
        }
        logger.info("Response Code is ["+responseCode+"] for URL ["+urlString+"]");

        return responseCode;
    }

    /**
     * Get response code and fail if content conatins : "Error:500:["
     * @param urlString
     * @param isFollowRedirect
     * @return
     */
    public int getHttpURLConnectionResponseCodeFailIfContentError500(String urlString, boolean isFollowRedirect,
                                                                     String errorString) {
        HttpURLConnection huc = null;
        int responseCode = -1;

        try {/*
            URL url = new URL(urlString);
            huc = (HttpURLConnection) url.openConnection();
            huc.setInstanceFollowRedirects(isFollowRedirect);
            huc.setRequestMethod("GET");
            huc.setDoOutput(true);
            huc.connect();
            */

            huc = getHttpUrlConnection(urlString, isFollowRedirect, "GET", true, null);

            String errorSubString = TestUtil.getMatchContentExtraChars(readInputStreamToString(huc), errorString,50,50);    //readInputStreamToString(huc)  pageErrorContent

            AssertHelper.assertThat("Page Content contains 500 error text ...!", errorSubString,
                    not(containsString(errorString.toLowerCase())));

            responseCode = huc.getResponseCode();
            logger.info("Response code ["+responseCode+"]");

            setCurrentUrl(huc);
            /*
            try {
                currentUrl = huc.getURL().toString();
            }catch (Exception e){logger.error("Can't get current url from web client response ...!"+e.getMessage());}
            */
        }catch ( IOException e){
            logger.error("Can't get Response Code for URL ["+urlString+"]  ...! "+e.getMessage());
        }finally {
            huc.disconnect();
        }

        logger.info("Response Code is ["+responseCode+"] for URL ["+urlString+"]");
        return responseCode;
    }

    /**
     * Use HttpURLConnection to get TestResponse bean
     * need to setup cookies
     * @param isFollowRedirect
     * @param testResponseBean [urlbean setup]
     * @return testResponseBean
     */
    public TestResponseBean getTestResponseBean(TestResponseBean testResponseBean, String country,
                                                       boolean isFollowRedirect, String errorString) {
        HttpURLConnection urlConn = null;
        currentUrl = null;

        try {
            URL url = new URL(testResponseBean.getUrl());
            urlConn = (HttpURLConnection) url.openConnection();
            urlConn.setInstanceFollowRedirects(isFollowRedirect);
            urlConn.setRequestMethod("GET");
            urlConn.setDoInput(true);
            urlConn.setDoOutput(true);

            setHttpRequestCookie( url,  country,  urlConn);
            // only for /online/XXXXX  and  /community/XXXXXXXXX      no others
            /*
            if(StringUtils.contains(url.toString(), "/online/") || StringUtils.contains(url.toString(), "/community/")){
                String ctrCookieValue = "ctr=" + country;                                                                 // Domain=englishlive.ef.com"; //+country; //+"; Domain=.englishlive.ef.com";
                logger.info("Need to set Cookie  [" + ctrCookieValue + "]");
                urlConn.setRequestProperty("Cookie", ctrCookieValue);                                                       // urlConn.addRequestProperty("Cookie", ctrCookieValue);
            }
            */

            logger.info("Sending GET request to URL {}",testResponseBean.getUrl());
            urlConn.connect();
                                                                                                                        /*String headerName=null;  for (int i=1; (headerName = urlConn.getHeaderFieldKey(i))!=null; i++) {                                                                                                                            if (headerName.equals("Set-Cookie")) {   String cookie = urlConn.getHeaderField(i); logger.info(cookie.toString()); }    }*/
            testResponseBean.setResponseCode(urlConn.getResponseCode()); //huc.getResponseMessage()
            String errorSubstring=TestUtil.getMatchContentExtraChars(readInputStreamToString(urlConn),errorString,50,50);
            testResponseBean.setErrorSubString(errorSubstring);

            if(errorSubstring == null || StringUtils.equals(errorSubstring, "-1")) {
                // no 500 error on response body
            }else {
                testResponseBean.setIs500ErrorOnResponseBody(true);
            }

            setTestResponseCurrentUrl(urlConn, testResponseBean);
            /*try {
                currentUrl = urlConn.getResponseMessage();
                //NOTE this is dirty TODO refactor or remove tests
                if(currentUrl == null ) {
                    currentUrl = urlConn.getHeaderField("Location");
                }
                if( "OK".equals(currentUrl) ){
                    currentUrl = urlConn.getURL().toString();
                }
                if("Moved Permanently".equals(currentUrl)){
                    currentUrl = urlConn.getHeaderField("Location");
                }
                testResponseBean.setCurrentUrl(currentUrl);
            }catch (Exception e){
                logger.error("Can't get current url from web client response ...!"+e.getMessage());
                testResponseBean.setCurrentUrl("cant get url Fail");
            }*/
        }catch ( IOException e){
            logger.error("Can't get Response Code for URL ["+testResponseBean.getUrl()+"]  ...! "+e.getMessage());
        }

        testResponseBean.print();

        return testResponseBean;
    }


    //test
    /**
     * @param connection object; note: before calling this function,
     *   ensure that the connection is already be open, and any writes to
     *   the connection's output stream should have already been completed.
     * @return String containing the body of the connection response or
     *   null if the input stream could not be read correctly
     */
    public String readInputStreamToString(HttpURLConnection connection) {
        String result = null;
        StringBuffer sb = new StringBuffer();
        InputStream is = null;

        try{
            is = new BufferedInputStream(connection.getInputStream());
        }catch (Exception e){
            logger.error("con getInputStream failed ...! will try to get getErrorStream"+e.getMessage());
        }
        try {
            if(null == is){
                is = new BufferedInputStream(connection.getErrorStream());
            }
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String inputLine = "";
            while ((inputLine = br.readLine()) != null) {
                sb.append(inputLine);
            }
            result = sb.toString();
            //logger.info("/n page response :"+result);
        }
        catch (Exception e) {
            logger.error("Error reading InputStream");
            result = null;
        }
        finally {
            if (is != null) {
                try {
                    is.close();
                }
                catch (IOException e) {
                    logger.error( "Error closing InputStream");
                }
            }
        }

        return result;
    }

    static String pageErrorContent = "<!DOCTYPE html><!--[if lt IE 7]>  html lang=\\\"de-de\\\" class=\\\"no-js lt-ie9 lt-ie8 lt-ie7  et.state.push(\\\"page.name\\\", \\\"Error:500:[\\\" + window.location.pathname + \\\"]\\\",\\\"page.environment\\\", \\\"live\\\",\\\"tracking.etvt_enabled\\\", true ";

    //------------------------------------------------------------------------------------------------------------------
    //
    public static int getHeadlessRequestTimeout() {
        return headlessRequestTimeout;
    }

    public boolean isThrowExceptionOnFailingStatusCode() {
        return isThrowExceptionOnFailingStatusCode;
    }

    public void setThrowExceptionOnFailingStatusCode(boolean throwExceptionOnFailingStatusCode) {
        isThrowExceptionOnFailingStatusCode = throwExceptionOnFailingStatusCode;
    }

    public boolean isPrintContentOnFailingStatusCode() {
        return isPrintContentOnFailingStatusCode;
    }

    public void setPrintContentOnFailingStatusCode(boolean printContentOnFailingStatusCode) {
        isPrintContentOnFailingStatusCode = printContentOnFailingStatusCode;
    }

    public boolean isJavaScriptEnabled() {
        return isJavaScriptEnabled;
    }

    public void setJavaScriptEnabled(boolean javaScriptEnabled) {
        isJavaScriptEnabled = javaScriptEnabled;
    }

    public boolean isRedirectEnabled() {
        return isRedirectEnabled;
    }

    public void setRedirectEnabled(boolean redirectEnabled) {
        isRedirectEnabled = redirectEnabled;
    }

    public boolean isUseInsecureSSL() {
        return isUseInsecureSSL;
    }

    public void setUseInsecureSSL(boolean useInsecureSSL) {
        isUseInsecureSSL = useInsecureSSL;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getCurrentUrl() {
        return currentUrl;
    }

    public void setCurrentUrl(String currentUrl) {
        this.currentUrl = currentUrl;
    }

    /**
     * Set url from HUC
     * @param huc
     */
    public void setCurrentUrl(HttpURLConnection huc){
        try {
            currentUrl = huc.getURL().toString();
        }catch (Exception e){logger.error("Can't get current url from web client response ...!"+e.getMessage());}
    }

    /**
     * Set test response current url
     * @param huc
     * @param testResponseBean
     */
    public void setTestResponseCurrentUrl(HttpURLConnection huc, TestResponseBean testResponseBean){
        try {
            currentUrl = huc.getResponseMessage();
            //NOTE this is dirty TODO refactor or remove tests
            if(currentUrl == null ) {
                currentUrl = huc.getHeaderField("Location");
            }
            if( "OK".equals(currentUrl) ){
                currentUrl = huc.getURL().toString();
            }
            if("Moved Permanently".equals(currentUrl)){
                currentUrl = huc.getHeaderField("Location");
            }
            testResponseBean.setCurrentUrl(currentUrl);
        }catch (Exception e){
            logger.error("Can't get current url from web client response ...!"+e.getMessage());
            testResponseBean.setCurrentUrl("cant get url Fail");
        }
    }


    public boolean isGetResponseAsString() {
        return isGetResponseAsString;
    }

    public void setIsGetResponseAsString(boolean isGetResponseAsString) {
        this.isGetResponseAsString = isGetResponseAsString;
    }

    public String getPageErrorContent() {
        return pageErrorContent;
    }

    public void setPageErrorContent(String pageErrorContent) {
        this.pageErrorContent = pageErrorContent;
    }

    public void setHttpRequestCookie(URL url, String country, HttpURLConnection huc){
        if(StringUtils.contains(url.toString(), "/online/") || StringUtils.contains(url.toString(), "/community/")){
            String ctrCookieValue = "ctr=" + country;                                                                 // Domain=englishlive.ef.com"; //+country; //+"; Domain=.englishlive.ef.com";
            logger.info("Need to set Cookie  [" + ctrCookieValue + "]");
            huc.setRequestProperty("Cookie", ctrCookieValue);                                                       // urlConn.addRequestProperty("Cookie", ctrCookieValue);
        }
    }


}




/*


/**
     * Use HttpURLConnection to get TestResponse bean
     * @param isFollowRedirect
     * @param testResponseBean [urlbean setup]
     * @return testResponseBean
     *
public TestResponseBean getTestResponseBean(TestResponseBean testResponseBean, boolean isFollowRedirect,
                                            String errorString) {
    HttpURLConnection huc = null;
    currentUrl = null;

    try {
        huc = getHttpUrlConnection(testResponseBean.getUrl(), isFollowRedirect, "GET", true, null);

        testResponseBean.setResponseCode(huc.getResponseCode()); //huc.getResponseMessage()

        String errorSubstring =TestUtil.getMatchContentExtraChars(readInputStreamToString(huc), errorString, 50,50);
        testResponseBean.setErrorSubString(errorSubstring);

        if(errorSubstring == null || StringUtils.equals(errorSubstring, "-1")) {

        }else {
            testResponseBean.setIs500ErrorOnResponseBody(true);
        }

        setTestResponseCurrentUrl(huc, testResponseBean);
    }catch ( IOException e){
        logger.error("Can't get Response Code for URL ["+testResponseBean.getUrl()+"]  ...! "+e.getMessage());
    }

    testResponseBean.print();

    return testResponseBean;
}



    // HTTP GET request
    public static void sendGet(String urlIn) throws Exception {

        String url = urlIn ; //"http://www.google.com/search?q=mkyong";

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");
        String USER_AGENT = "Java/1.8.0_31";
        //add request header
        con.setRequestProperty("User-Agent",   USER_AGENT);

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine+"\n");
        }
        in.close();

        //print result
        System.out.println(response.toString());

    }


        private static void sendGET(String GET_URL) {
        try {
            URL obj = new URL(GET_URL);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", USER_AGENT);
            int responseCode = con.getResponseCode();
            System.out.println("GET Response Code :: " + responseCode);
            if (responseCode == HttpURLConnection.HTTP_OK) { // success
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        con.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // print result
                System.out.println(response.toString());
            } else {
                System.out.println("GET request not worked");
            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    private static void sendPOST(String POST_URL, String host, String market) {
        try {
            URL obj = new URL(POST_URL);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("User-Agent", USER_AGENT);
            con.addRequestProperty("Host", host);
            con.addRequestProperty("X-IPCountryCode", market);
            // For POST only - START
            con.setDoOutput(true);
            OutputStream os = con.getOutputStream();
            //os.write(POST_PARAMS.getBytes());
            os.flush();
            os.close();
            // For POST only - END

            int responseCode = con.getResponseCode();
            System.out.println("POST Response Code :: " + responseCode);

            if (responseCode == HttpURLConnection.HTTP_OK) { //success
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        con.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // print result
                System.out.println(response.toString());
            } else {
                System.out.println("POST request not worked");
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

*/
