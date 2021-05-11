package com.englishtown.services;

/***
 * Send a request to handlers to create leads without using real browser but post the request
 *
 */

import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WebClientResponseHelper;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MyHttpClient {
    protected static final Logger logger = LoggerFactory.getLogger(WebClientResponseHelper.class);

    protected static String url = "https://qa-englishlive.ef.com/online/landinghandler.ashx?lp=true&responsemode=json" ;
    public static String status;
    public static boolean isCancelMarked;

    //@Test
    void testCreateLead(){

    }

    public static void post(String local, String lang, String leadtype, String first_name, String last_name, String email,
                            String telephone, String partner, String requestUrl){
        try {
            HttpClient client = HttpClientBuilder.create().build();
            HttpPost httpPost = new HttpPost(requestUrl);

            /**
             * Setup Header
             */
            httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");

            /**
             * Setup Body params
             * TODO use a map with key values to add body params
             */
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("local",       local));
            params.add(new BasicNameValuePair("lang",        lang));
            params.add(new BasicNameValuePair("leadtype",    leadtype));
            params.add(new BasicNameValuePair("first_name",  first_name));
            params.add(new BasicNameValuePair("last_name",   last_name));
            params.add(new BasicNameValuePair("email",       email));
            params.add(new BasicNameValuePair("telephone",   telephone));
            params.add(new BasicNameValuePair("partner",     partner));

            httpPost.setEntity(new UrlEncodedFormEntity(params));

            /**
             * execute post
             */
            HttpResponse httpResponse = client.execute(httpPost);
            HttpEntity entity = httpResponse.getEntity();

            // Read the contents of an entity and return it as a String.
            String content = EntityUtils.toString(entity);
            logger.info(content);

        }catch (IOException ioe) {
            logger.error("IOException Create Lead error : "+ioe.getMessage());
        }catch (Exception e) {
            logger.error("Exception Create Lead error : "+e.getMessage());
        }
    }
    public static void post( String memberId, String requestUrl){

        logger.info("Member id is "+memberId +" Request url is "+requestUrl);
        try {
            HttpClient client = HttpClientBuilder.create().build();
            HttpPost httpPost = new HttpPost(requestUrl);

            /**
             * Setup Header
             */
            httpPost.addHeader("Content-Type", "application/json-patch+json");

            /**
             * Setup Body params
             * TODO use a map with key values to add body params
             */

            HttpEntity entity = new ByteArrayEntity(memberId.getBytes("UTF-8"));
            httpPost.setEntity(entity);

            /**
             * execute post
             */
            HttpResponse httpResponse = client.execute(httpPost);
            int responseCode = httpResponse.getStatusLine().getStatusCode();
            logger.info("Reponse code "+responseCode + httpResponse.getStatusLine() );
            AssertHelper.assertThat("Response code is not 200",200==responseCode);

            // Read the contents of an entity and return it as a String.
            String content = EntityUtils.toString(httpResponse.getEntity());
            logger.info("--------- "+content);

        }catch (IOException ioe) {
            logger.error("IOException Create Lead error : "+ioe.getMessage());
        }catch (Exception e) {
            logger.error("Exception Create Lead error : "+e.getMessage());
        }
    }

    /**
     * New House Cancel user subscription
     *
     * @param environment
     * @param efId
     * @param isCancel  - if true cancel otherwise suspend   only new house
     *                  Note: for suspend req not sure if we need  -d '{   "ExecutionDate": "2018-07-25T08:50:05.921Z" }
     */
    public static void cancelOrSuspendSubscriptionNewHouse(String environment, String efId, boolean isCancel){
        logger.info("cancelOrSuspendSubscriptionNewHouse efid [{}] ...!", efId);
        // QA url
        String cancelSubscriptionUrl = "https://qa-englishlive.ef.com/1/api/salesforce-gateway/subscription/replaceEfId/cancel?reason=test-reason";

        //if suspend
        if(!isCancel)
            cancelSubscriptionUrl = "https://qa-englishlive.ef.com/1/api/salesforce-gateway/subscription/replaceEfId/suspend";

        // add efid to url
        cancelSubscriptionUrl = cancelSubscriptionUrl.replace("replaceEfId", efId);


        // set creds per environment and url
        if(StringUtils.containsIgnoreCase(environment, "live") )  {
            cancelSubscriptionUrl = cancelSubscriptionUrl.replace("qa-", "");
        }
        else if(StringUtils.containsIgnoreCase(environment, "stg") ) {
            cancelSubscriptionUrl = cancelSubscriptionUrl.replace("qa-", "stg-");
        }

        logger.info("Suspend or cancelSubscriptionUrl [{}] ", cancelSubscriptionUrl);

        try {
            HttpClient client = HttpClientBuilder.create().build();
            HttpPost httpPost = new HttpPost(cancelSubscriptionUrl);

            /** Setup Header             */
            if(StringUtils.containsIgnoreCase(environment, "live") ){
                httpPost.addHeader("Authorization", "Basic c2FsZXNmb3JjZS1nYXRld2F5OnNmZzFsMiY4YzFtMnIzYw==");//old Basic c2FsZXNmb3JjZS1nYXRld2F5OnNmZzFsMiRwJjhjMW0ycjNj
            } else //use QA and see ....? erden nnnnnn
                httpPost.addHeader("Authorization", "Basic dGVzdDpwYXNzLXFhLXRlc3Q=");

            // if suspend
            if(!isCancel) {
                httpPost.setHeader("Content-type", "application/json");
                httpPost.setEntity(new StringEntity("{ \"ExecutionDate\":\"2020-08-30T03:50:05.921Z\" }",
                        ContentType.APPLICATION_JSON));
            }

            /** execute post             */
            HttpResponse httpResponse = client.execute(httpPost);
            int responseCode = httpResponse.getStatusLine().getStatusCode();
            logger.info("Response code: "+responseCode + ", getStatusLine: "+httpResponse.getStatusLine() );
            AssertHelper.assertThat("Student subscription not Cancelled/suspended : Response code is not 200 ",200 == responseCode);
            logger.info("Student Subscription Cancelled/suspended [{}]",efId);
        }catch (IOException ioe) {
            logger.error("IOException cancel Subscription error : "+ioe.getMessage());
        }catch (Exception e) {
            logger.error("Exception cancel Subscription error : "+e.getMessage());
        }
    }

    public synchronized static void postCancelSubscription( String efId, String requestUrl){

        logger.info("ef id is "+efId +" Request url is "+requestUrl);
        CredentialsProvider provider = new BasicCredentialsProvider();
        UsernamePasswordCredentials credentials
                = new UsernamePasswordCredentials("test", "pass-qa-test");
        provider.setCredentials(AuthScope.ANY, credentials);
        try {
            HttpClient client = HttpClientBuilder.create().setDefaultCredentialsProvider(provider).build();
            HttpPost httpPost = new HttpPost(requestUrl);


            /**
             * Setup Header
             */
            httpPost.addHeader("Authorization", "Basic dGVzdDpwYXNzLXFhLXRlc3Q=");
            // httpPost.addHeader("Content-Type", "application/json");
            /**

             * execute post
             */
            HttpResponse httpResponse = client.execute(httpPost);
            int responseCode = httpResponse.getStatusLine().getStatusCode();
            logger.info("Response code "+responseCode + httpResponse.getStatusLine() );
            AssertHelper.assertThat("Response code is not 200",200==responseCode);

        }catch (IOException ioe) {
            logger.error("IOException cancel Subscription error : "+ioe.getMessage());
        }catch (Exception e) {
            logger.error("Exception cancel Subscription error : "+e.getMessage());
        }
    }
    /**
     * New House Get user subscription details
     *
     * @param environment
     * @param efId
     */
    public static void getSubscriptionUserStatusNewHouse(String environment, String efId,boolean isMarkForCancelOrUndoCancel){
        logger.info("cancelOrSuspendSubscriptionNewHouse efid [{}] ...!", efId);
        // QA url
        String subscriptionUrl = "https://qa-englishlive.ef.com/1/api/salesforce-gateway/subscription/replaceEfId";
        subscriptionUrl = subscriptionUrl.replace("replaceEfId", efId);


        // set creds per environment and url
        if(StringUtils.containsIgnoreCase(environment, "live") )  {
            subscriptionUrl = subscriptionUrl.replace("qa-", "");
        }
        else if(StringUtils.containsIgnoreCase(environment, "stg") ) {
            subscriptionUrl = subscriptionUrl.replace("qa-", "stg-");
        }

        logger.info(" subscriptionUrl [{}] ", subscriptionUrl);

        try {
            HttpClient client = HttpClientBuilder.create().build();
            HttpGet httpGet = new HttpGet(subscriptionUrl);

            /** Setup Header             */
            if(StringUtils.containsIgnoreCase(environment, "live") ){
                httpGet.addHeader("Authorization", "Basic c2FsZXNmb3JjZS1nYXRld2F5OnNmZzFsMiY4YzFtMnIzYw==");//c2FsZXNmb3JjZS1nYXRld2F5OnNmZzFsMiRwJjhjMW0ycjNj
            } else //use QA and see ....? erden nnnnnn
                httpGet.addHeader("Authorization", "Basic dGVzdDpwYXNzLXFhLXRlc3Q=");

            /** execute Get             */
            HttpResponse httpResponse = client.execute(httpGet);
            int responseCode = httpResponse.getStatusLine().getStatusCode();
            logger.info("Response code: "+responseCode + ", getStatusLine: "+httpResponse.getStatusLine() );
            AssertHelper.assertThat("Response code is not 200 ",200 == responseCode);
            String content = EntityUtils.toString(httpResponse.getEntity(),"UTF-8");
            status= getStatusFromResponseBody(content);
            if(isMarkForCancelOrUndoCancel)
                isCancelMarked =Boolean.parseBoolean(getIsCancelMarked(content));



        }catch (IOException ioe) {
            logger.error("IOException cancel Subscription error : "+ioe.getMessage());
        }catch (Exception e) {
            logger.error("Exception cancel Subscription error : "+e.getMessage());
        }
    }



    public static String getStatusFromResponseBody(String response){
        String s1 = response.split("Status")[1].split(",")[0];
        String status=s1.replace(":","").replace("\"", "");
        return status;
    }

    public  static String getIsCancelMarked(String response){
        String s1 = response.split("IsCancelMarked")[1].split(",")[0];
        String IsCancelMarked=s1.replace(":","").replace("\"", "");
        logger.info("Value of IsCancelMarked is "+IsCancelMarked);
        return IsCancelMarked;
    }
}