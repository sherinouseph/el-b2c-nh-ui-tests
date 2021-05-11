package com.englishtown.helpers.reader;
/**
 * Created by nikol.marku on 03/05/2016.
 *
 * Read Json from URL
 *
 *
 */
import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

import com.englishtown.helpers.bean.handler.BasicPostDataHandler;
import com.englishtown.helpers.bean.handler.CreateMemberBean;
import com.englishtown.helpers.bean.handler.EfFullDataBean;
import com.englishtown.newhouse.apicore.bean.ExtraInfoReqBean;
import org.apache.commons.lang.ArrayUtils;

import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;




public class MyJsonReader {
    private static final Logger logger = LoggerFactory.getLogger(MyJsonReader.class);
    private static final String BASE_TESTDATA_PATH  = System.getProperty("user.dir")+"\\src\\testdata\\";  //C:\work\project\nikol\qa
    private static final String JASON_TESTDATA_PATH = BASE_TESTDATA_PATH+"json\\";
    private static String efBeanJsonFilename              = "EfFullDataBeanJson.json";
    public static String efBeanCreateMemberJsonFilename   = "EfDeCreateMemberBean.json";
    public String testFilename ;   //test should set this up

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    /**
     * Read Json from URL and remove "["  + "]"
     * @param url
     * @return
     * @throws IOException
     * @throws JSONException
     */
    public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        BufferedReader rd = null;
        try {
            rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            // have to replace some chars to make it work
            jsonText = jsonText.replace("[", "");
            jsonText = jsonText.replace("]", "");
            JSONObject json = new JSONObject(jsonText);

            return json;
        } finally {
            rd.close();
            is.close();
        }
    }

    public static JSONObject readJsonFromUrl(String url, String[] removeChars) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        BufferedReader rd = null;

        try {
            rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);

            if(!ArrayUtils.isEmpty(removeChars)) {
                for (int i = 0; i < removeChars.length; i++) {
                    jsonText = jsonText.replace(removeChars[i], "");
                }
            }

            JSONObject json = new JSONObject(jsonText);

            return json;
        } finally {
            rd.close();
            is.close();
        }
    }


    /**
     * Read Json from URL and remove "["  + "]"
     * @param url
     * @return
     * @throws IOException
     * @throws JSONException
     */
    public static String readJsonStringFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        BufferedReader rd = null;
        try {
            rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            // have to replace some chars to make it work
            jsonText = jsonText.replace("[", "");
            jsonText = jsonText.replace("]", "");
            //System.out.println(jsonText);
            return jsonText;
        } finally {
            rd.close();
            is.close();
        }
    }
    public static String readJsonStringFromDBUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        BufferedReader rd = null;
        try {
            rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            System.out.println(jsonText);
            return jsonText;
        } finally {
            rd.close();
            is.close();
        }
    }


    /**
     * Read json from url and return BasicPostDataHandler
     *
     * @param url  that return a json
     * @return BasicPostDataHandler
     * @throws IOException
     * @throws JSONException
     */
    public static BasicPostDataHandler getBasicPostDataHandlerFromUrl(String url) throws IOException, JSONException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper.readValue(readJsonStringFromUrl(url), BasicPostDataHandler.class);
    }

    public static EfFullDataBean getFullPostDataHandlerFromUrl(String url) throws IOException, JSONException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false   );
        mapper.readValue(readJsonStringFromUrl(url), CreateMemberBean.class);
        String jsonStr = readJsonStringFromUrl(url);
        return  mapper.readValue(jsonStr, EfFullDataBean.class);
    }

    public static CreateMemberBean getCreateMemberBean(String url) throws IOException, JSONException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false   );
        String jsonStr = readJsonStringFromUrl(url);
        logger.info("REsponse from DB request is :"+jsonStr + " need to remove start of string ");
        jsonStr = jsonStr.replace("{\"Result\":","");
        return  mapper.readValue(jsonStr, CreateMemberBean.class);
    }

    /**
     * Read json data from file
     * and return a java object
     * Otherwise return null
     */
    public static EfFullDataBean getEfFullDataBeanFromJsonFile(String filePathAndName) throws NullPointerException{
        ObjectMapper mapper = new ObjectMapper();
        logger.info("getEfFullDataBeanFromJsonFile filePathAndName is :"+filePathAndName);
        EfFullDataBean efFullDataBean = new EfFullDataBean();
        mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false   );

        try {                                                                                                           // not work  InputStream is = EfFullDataBean.class.getResourceAsStream(filePathAndName);            //  efFullDataBean = mapper.readValue(is, EfFullDataBean.class);
            efFullDataBean = mapper.readValue(Files.readAllBytes(Paths.get(filePathAndName)), EfFullDataBean.class);
            logger.info("Bean Data is : \n"+efFullDataBean.toString());
        }catch (Exception ie){
            ie.printStackTrace();
            mapper = null;
            logger.error("Could not read from file ["+filePathAndName+"] ...!\n"+ie.getMessage());
        }
        mapper = null;
        return efFullDataBean;
    }

    public static String getBaseTestdataPath() {
        return BASE_TESTDATA_PATH;
    }

    public static String getJasonTestdataPath() {
        return JASON_TESTDATA_PATH;
    }

    public String getEfBeanJsonFilename() {
        return efBeanJsonFilename;
    }

    /**
     *
     * @param fileName with file extension
     * @return full file path
     */
    public static String getJasonTestFilePath(String fileName){
        return getJasonTestdataPath()+fileName;
    }

    public static String getEfBeanJasonFilePath(){
        return getJasonTestdataPath()+efBeanJsonFilename;
    }

    public static void setEfBeanJsonFilename(String efBeanJsonFilename) {
        MyJsonReader.efBeanJsonFilename = efBeanJsonFilename;
    }

    public void setTestFilename(String testFilename) {
        this.testFilename = testFilename;
    }

}



 /*

 import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
protected void setupBeforeClass(){
    logger.info("@ Before Class ...!");
    reqBean = MyJsonReader.getExtraInfoReqBeanFromJsonFile(getTestDataFile(WORLDPAY_JSON));
    //http://www.websparrow.org/java/how-to-parse-nested-json-object-in-java
    JSONParser jsonParser = new JSONParser();
    Object object;

    try {
        object = jsonParser.parse(new FileReader(getTestDataFile(WORLDPAY_JSON)));
        org.json.simple.JSONObject jsonObject       = (org.json.simple.JSONObject) object;
        org.json.simple.JSONObject extraInfoJsonObj = (org.json.simple.JSONObject) jsonObject.get("ExtraInfo");
        Map extraInfo = new HashMap<String, String>();
        extraInfo = (HashMap)jsonObject.get("ExtraInfo");
        logger.info(""+jsonObject.get("Email"));
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    } catch (org.json.simple.parser.ParseException e) {
        e.printStackTrace();
    }

}*/