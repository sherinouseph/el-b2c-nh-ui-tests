package com.englishtown.newhouse.apicore;

import com.englishtown.newhouse.apicore.bean.ExtraInfoReqBean;

import com.englishtown.newhouse.apicore.bean.PaymentTechExtraInfoReqBean;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.simple.JSONArray;

/**
 * utility class for Rest Assured Library
 */


public class RestUtil {
    public static final Logger logger = LoggerFactory.getLogger(RestUtil.class);
    //Global Setup Variables
    public static String path; //Rest request path
    static String TESTDATA_FOLDER = "/src/test/java/com/englishlive/tests/newhouse/apitest/testsuite/testdata/json/";
    /*
    ***Sets Base URI***
    Before starting the test, we should set the RestAssured.baseURI
    */
    public static void setBaseURI (String baseURI){
        RestAssured.baseURI = baseURI;
    }

    /*
    ***Sets base path***
    Before starting the test, we should set the RestAssured.basePath
    */
    public static void setBasePath(String basePathTerm){
        RestAssured.basePath = basePathTerm;
    }

    /*
    ***Reset Base URI (after test)***
    After the test, we should reset the RestAssured.baseURI
    */
    public static void resetBaseURI (){
        RestAssured.baseURI = null;
    }

    /*
    ***Reset base path (after test)***
    After the test, we should reset the RestAssured.basePath
    */
    public static void resetBasePath(){
        RestAssured.basePath = null;
    }

    /*
    ***Sets ContentType***
    We should set content type as JSON or XML before starting the test
    */
    public static void setContentType (ContentType Type){
        given().contentType(Type);
    }

    /*
    ***search query path of first example***
    It is  equal to "barack obama/videos.json?num_of_videos=4"
    */
    public static void  createSearchQueryPath(String searchTerm, String jsonPathTerm, String param, String paramValue) {
        path = searchTerm + "/" + jsonPathTerm + "?" + param + "=" + paramValue;
    }

    /*
    ***Returns response***
    We send "path" as a parameter to the Rest Assured'a "get" method
    and "get" method returns response of API
    */
    public static Response getResponse() {
        //System.out.print("path: " + path +"\n");
        return get(path);
    }

    /*
    ***Returns JsonPath object***
    * First convert the API's response to String type with "asString()" method.
    * Then, send this String formatted json response to the JsonPath class and return the JsonPath
    */
    public static JsonPath getJsonPath (Response res) {
        String json = res.asString();
        //System.out.print("returned json: " + json +"\n");
        return new JsonPath(json);
    }

    public static String getTestDataFile( String fileName){
        try{
            String userDir = System.getProperty("user.dir");
            return userDir+TESTDATA_FOLDER+fileName;
        }catch (Exception e){
            logger.error("cant get file path : "+e.getMessage());
        }
        return "notfound";
    }

    /**-------------------------------------------------------------------------------------------
     * REst API
     * Read json data from file
     * and return a java object
     * Otherwise return null
     */
    public static ExtraInfoReqBean getExtraInfoReqBeanFromJsonFile(String filePathAndName) throws NullPointerException{
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false   );
        logger.info("ExtraInfoReqBean filePathAndName is :"+filePathAndName);
        ExtraInfoReqBean extraInfoReqBean = new ExtraInfoReqBean();

        //http://www.websparrow.org/java/how-to-parse-nested-json-object-in-java
        JSONParser jsonParser = new JSONParser();
        Object object;

        try {                                                                                                           // not work  InputStream is = EfFullDataBean.class.getResourceAsStream(filePathAndName);            //  efFullDataBean = mapper.readValue(is, EfFullDataBean.class);
            // Get main json elements
            extraInfoReqBean = mapper.readValue(Files.readAllBytes(Paths.get(filePathAndName)), ExtraInfoReqBean.class);
            object = jsonParser.parse( new FileReader(filePathAndName)); // getTestDataFile(WORLDPAY_JSON)));
            // get main json elements // this is setup by mapper as it setup the bean
            JSONObject jsonMainObject       = (JSONObject ) object;
            // get nested json ExtraInfo
            JSONObject extraInfoJsonObj = (JSONObject ) jsonMainObject.get("ExtraInfo");//
            HashMap extraInfo = new HashMap<String, String>();
            extraInfo = (HashMap)jsonMainObject.get("ExtraInfo");
            extraInfoReqBean.setExtraInfoBeanFromMap(extraInfo);                                                        // TODO use this to setup bean extraInfoReqBean.setExtraInfoFromJsonObj(extraInfoJsonObj);
            //logger.info("\nBase Bean data ... before updated for test : "+extraInfoReqBean.toString());
        }catch (FileNotFoundException e) {
            logger.error("Could not find file ["+filePathAndName+"] ...!\n"+e.getMessage());
        } catch (IOException e) {
            logger.error("IOException file ["+filePathAndName+"] ...!\n"+e.getMessage());
        }
        catch (Exception ie){
            ie.printStackTrace();
            logger.error("Could not create object and Parse file ["+filePathAndName+"] ...!\n"+ie.getMessage());
        }
        return extraInfoReqBean;
    }

    public static PaymentTechExtraInfoReqBean getPayTecExtraInfoReqBeanFromJsonFile(String filePathAndName) throws NullPointerException{
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false   );
        logger.info("ExtraInfoReqBean filePathAndName is :"+filePathAndName);
        PaymentTechExtraInfoReqBean extraInfoReqBean = new PaymentTechExtraInfoReqBean();

        //http://www.websparrow.org/java/how-to-parse-nested-json-object-in-java
        JSONParser jsonParser = new JSONParser();
        Object object;

        try {                                                                                                           // not work  InputStream is = EfFullDataBean.class.getResourceAsStream(filePathAndName);            //  efFullDataBean = mapper.readValue(is, EfFullDataBean.class);
            // Get main json elements
            extraInfoReqBean = mapper.readValue(Files.readAllBytes(Paths.get(filePathAndName)), PaymentTechExtraInfoReqBean.class);
            object = jsonParser.parse( new FileReader(filePathAndName)); // getTestDataFile(WORLDPAY_JSON)));
            // get main json elements // this is setup by mapper as it setup the bean
            JSONObject jsonMainObject       = (JSONObject ) object;
            // get nested json ExtraInfo
            JSONObject extraInfoJsonObj = (JSONObject ) jsonMainObject.get("ExtraInfo");//
            HashMap extraInfo = new HashMap<String, String>();
            extraInfo = (HashMap)jsonMainObject.get("ExtraInfo");
            extraInfoReqBean.setExtraInfoBeanFromMap(extraInfo);                                                        // TODO use this to setup bean extraInfoReqBean.setExtraInfoFromJsonObj(extraInfoJsonObj);
            logger.info("\nBase Bean data ... before updated for test : "+extraInfoReqBean.toString());
        }catch (FileNotFoundException e) {
            logger.error("Could not find file ["+filePathAndName+"] ...!\n"+e.getMessage());
        } catch (IOException e) {
            logger.error("IOException file ["+filePathAndName+"] ...!\n"+e.getMessage());
        }
        catch (Exception ie){
            ie.printStackTrace();
            logger.error("Could not create object and Parse file ["+filePathAndName+"] ...!\n"+ie.getMessage());
        }
        return extraInfoReqBean;
    }




}


