package com.englishtown.driver;
/**
 * This will get the information of the NODE where the tes tist is running ...
 *
 */

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHttpEntityEnclosingRequest;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

/**
 * Created by nikol.marku on 8/3/2016.
 */


public class GetTestGridNodeInfo {
    private static final Logger logger = LoggerFactory.getLogger(GetTestGridNodeInfo.class);

    public static String getHostName(String hubIpAddress, SessionId session) {
        String hostDetail = null;        //String hostName = hubIpAddress; //"10.43.40.103"; //"localhost"; // HUB IP
        int port = 4444;
        String errorMsg = "Failed to acquire remote webdriver node and port info. Root cause: ";

        try {
            HttpHost host = new HttpHost(hubIpAddress, port);
            DefaultHttpClient client = new DefaultHttpClient();
            URL sessionURL = new URL("http://" + hubIpAddress + ":" + port + "/grid/api/testsession?session=" + session);
            logger.info("URL is : "+sessionURL);
            BasicHttpEntityEnclosingRequest r = new BasicHttpEntityEnclosingRequest("POST", sessionURL.toExternalForm());
            HttpResponse response = client.execute(host, r);
            //logger.info("response all to string : "+response.toString());
            //JSONObject object = extractObject(response);
            //URL myURL = new URL(object.getString("proxyId"));
            JsonObject myjsonobject =extractObject(response);
            JsonElement url = myjsonobject.get("proxyId"); //{"msg":"slot found !","success":true,"session":"fedafd74-4ac7-4719-b3f2-2d7c8ad2a97a","internalKey":"0a74901e-abcd-4494-b210-09a52cf12c89","inactivityTime":281,"proxyId":"http://10.24.209.11:5560"
            logger.info("JsonElement url : "+url.getAsString());
            URL myURL = new URL(url.getAsString());
            if ((myURL.getHost() != null) && (myURL.getPort() != -1)) {
                hostDetail = myURL.getHost();
            }
        } catch (Exception e) {
            logger.info(e.getMessage());
            //throw new RuntimeException(errorMsg, e);
        }
        return hostDetail;
    }

    private static JsonObject extractObject(HttpResponse resp)  {
        JsonObject objToReturn = null;
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(resp.getEntity().getContent()));
            StringBuffer s = new StringBuffer();
            String line;
            while ((line = rd.readLine()) != null) {
                s.append(line);
            }

            rd.close();
            JsonParser parser = new JsonParser();
            objToReturn = (JsonObject) parser.parse(s.toString());
            logger.info(objToReturn.toString());
            logger.info(objToReturn.get("proxyId").toString());
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
        return objToReturn;
    }


    @Test
    void testFindNodeIP() throws MalformedURLException, UnknownHostException {
        DesiredCapabilities dc = new DesiredCapabilities();
        RemoteWebDriver driver = new RemoteWebDriver(new URL("http://10.43.40.103:4444/wd/hub"),dc.chrome());
        //driver.get("http://www.google.com");      //System.out.println(driver.getTitle());  //System.out.println("sessionID :"+driver.getSessionId());
        String hostname = getHostName(IWebDriverSetting.TEAMCITY_HUB_HOSTNAME, driver.getSessionId());
        logger.info("HostName : [" +hostname+"]");
        driver.quit();
    }

}
