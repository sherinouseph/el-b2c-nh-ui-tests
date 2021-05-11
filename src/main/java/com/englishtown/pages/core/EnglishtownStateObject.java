package com.englishtown.pages.core;

import com.englishtown.driver.local.DriverManager;
import com.englishtown.driver.local.WebDriverFactory;
import com.englishtown.helpers.utils.TestUtil;
import com.galenframework.browser.BrowserFactory;
import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.testng.Assert.fail;

public class EnglishtownStateObject {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(EnglishtownStateObject.class);

    private static final String script = "et.state.get(\"\", function(e) { window._temp_et_st_data = e} ); return JSON.stringify(window._temp_et_st_data);";
    public static final String STATE_OBJ_SCRIPT_FIRSTPART = "var callback = arguments[arguments.length - 1];" +
            "window.et = window.et || {}; window.et.state = window.et.state || []; et.state.push(null, function(){et.state.get('";
    public static final String STATE_OBJ_SCRIPT_SECONDPART = "',function( v ){if (v) { callback(JSON.stringify(v)) } else { callback('error'); } })});";

    private WebDriver webDriver;
    private Map<String, Object> stateObjectMap;


    public EnglishtownStateObject(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void load(WebDriver driver) {
        logger.info("call load() state object ...!");
        try{
            JavascriptExecutor javascriptExecutor = ((JavascriptExecutor) driver); //this.webDriver;
            if (javascriptExecutor != null) {
                Object ret = javascriptExecutor.executeAsyncScript(
                        "var callback = arguments[arguments.length - 1];" +
                             "window.et = window.et || {}; window.et.state = window.et.state || [];" +
                             "et.state.push(null, function(){" +
                             "et.state.get('',function( v ){if (v) { callback(JSON.stringify(v)) } else { callback('error'); } })" +
                             "});"
                );
                String etStateObjectJson = ret.toString();
                logger.info("etStateObjectJson : "+etStateObjectJson);
                if ( etStateObjectJson.equals("error") ) {
                    logger.info("etStateObjectJson ERROR .... returned");
                    BasePage.failTest("load() etStateObjectJson is equals to error! : "+etStateObjectJson, true);          //fail("load() etStateObjectJson is equals to error! : "+etStateObjectJson);
                }

                try {
                    JsonFactory factory = new JsonFactory();
                    ObjectMapper mapper = new ObjectMapper(factory);
                    TypeReference<HashMap<String, Object>> typeRef
                            = new TypeReference<HashMap<String, Object>>() {
                    };

                    stateObjectMap = mapper.readValue(etStateObjectJson, typeRef);    //EfConstants.dumpMap(this.stateObjectMap) ;
                } catch (IOException ioException) {
                    logger.error("Load state object FAILED...IOException! :" + TestUtil.getException(ioException, driver));
                }
            }
        }catch (WebDriverException e) {
            logger.error("Load state object FAILED...!WebDriverException :"+TestUtil.getException(e, driver));
            logger.error("Cause : " + TestUtil.getException(e));
            BasePage.failTest(e, "WebDriverException Load state object FAILED  ...!", true);
        }catch (Exception e){
            BasePage.failTest(e, "Exception Load state object FAILED  ...!", true);
        }
    }

    /**
     * Execute async JS script to get state object key [keyValue]
     * @param driver
     * @param key
     * @return key value or fail is emty or not found
     */
    public String getStateObjectKeyValue(WebDriver driver, String key) {
        logger.info("getStateObjectKeyValue ["+key+"]");
        String keyValue = "";

        try{
            JavascriptExecutor javascriptExecutor = ((JavascriptExecutor) driver);

            if (javascriptExecutor != null) {
                Object ret = javascriptExecutor.executeAsyncScript(  STATE_OBJ_SCRIPT_FIRSTPART+key+STATE_OBJ_SCRIPT_SECONDPART);
                        /*"var callback = arguments[arguments.length - 1];" +
                                "window.et = window.et || {}; window.et.state = window.et.state || [];" +
                                "et.state.push(null, function(){" +
                                "et.state.get('"+key+"',function( v ){if (v) { callback(JSON.stringify(v)) } else { callback('error'); } })" +
                                "});"
                );*/

                if(null != ret) {
                    keyValue = ret.toString().trim();
                    logger.info(key +"-> keyValue: " + keyValue);
                    if(!StringUtils.isBlank(keyValue)){
                        try {
                            keyValue = keyValue.replace("\"", "");
                        }catch (Exception e){
                            logger.info("Clean up funy chars form value ... failed ... "+e.getMessage());
                        }
                    }else {
                        BasePage.failTest("Can't get ["+key+"] value is blank on null...!");
                    }
                }else {
                    BasePage.failTest("Can't get ["+key+"] value ; execute script returnned null...!");
                }
            }
        }catch (WebDriverException e) {
            BasePage.failTest(e, "WebDriverException get state object key ["+key+"] ...!");
        }catch (Exception e){
            BasePage.failTest(e, "Exception Get state object key ["+key+"] ...!");
        }
        return keyValue;
    }


    public Map<String, Object> getStateObjectMap() {
        if (this.stateObjectMap == null) {
            this.load(getWebDriver());
        }
        return this.stateObjectMap;
    }

    public String getStateObjectValueFromMap(Map<String, Object> map, String key) {
        try{
            if (StringUtils.isNotEmpty(key)) {
                String[] keyParts = StringUtils.split(key, ".", 2);
                String keyPart = keyParts[0];

                if (map != null) {
                    Object value = null;
                    if (map.containsKey(keyPart)) {
                        value = map.get(keyPart);
                    } else if (map.containsKey(key)) {
                        value = map.get(key);
                        return value.toString();
                    } else {
                        return null;
                    }
                    //if(value !=null){   && StringUtils.isNotBlank(value.toString()) && StringUtils.isNotEmpty(value.toString())
                    if (value != null ) {
                        if (value instanceof List) {
                            logger.info(" Value is : "+value);
                            List rawValues = (List) value;

                            if(rawValues.size() == 0){
                                logger.warn("rawValues is zero(0) ");
                                return null;
                            }
                            Object firstObject = rawValues.get(0);  //IndexOutOfBoundsException

                            if (firstObject instanceof String) {
                                List<String> values = (List<String>) value;
                                StringBuilder result = new StringBuilder(values.get(0).toString());
                                for (String oneValue : values.subList(1, values.size())) {
                                    result.append(",");
                                    result.append(oneValue);
                                }
                                return result.toString();
                            } else if (firstObject instanceof Map) {
                                List<Map<String, Object>> values = (List<Map<String, Object>>) value;
                                StringBuilder result = new StringBuilder(getStateObjectValueFromMap(values.get(0), keyParts[1]));
                                for (Map<String, Object> oneValue : values.subList(1, values.size())) {
                                    result.append(",");
                                    result.append(getStateObjectValueFromMap(oneValue, keyParts[1]));
                                }
                                return result.toString();
                            }

                        } else if (value instanceof Map) {
                            return getStateObjectValueFromMap((Map<String, Object>) value, keyParts[1]);
                        } else {
                            return value.toString();
                        }
                    }
                } else {
                    return null;
                }
            }
        }catch (IndexOutOfBoundsException ioe){
            logger.info("Index out of Bound Exception ...!" );
            ioe.printStackTrace();
        } catch (NullPointerException npe){
            logger.info("NullPointerException ...!" );
            npe.printStackTrace();
        }
        return null;
    }

    /**
     * Try to find the value of the key - return null if not found
     * @param map
     * @param key
     * @return
     */
    public boolean isStateObjectKey(Map<String, Object> map, String key) {
        String keyVaue =   getStateObjectValueFromMap(map, key);
        if(keyVaue == null){
            return false;
        } else
            return true;
    }

    private void rangeCheck(Object obj,int index, int size) {
        if (index >= size)
        throw new IndexOutOfBoundsException(" IndexOutOfBoundsException ");

    }

    private WebDriver getWebDriver(){
        return webDriver;
    }


}




//    public String getStateObjectValue(String key) {
//        String value = null;
//        if (StringUtils.isNotEmpty(key)) {
//            Map<String, Object> map = this.getStateObjectMap();
//            String[] keyParts = StringUtils.split(key, ".");
//            Object keyValue = null;
//            for (String keyPart : keyParts) {
//                if (map != null && map.containsKey(keyPart)) {
//                    keyValue = map.get(keyPart);
//                    if (keyValue == null) {
//                        break;
//                    } else {
//                        if (keyValue instanceof Map) {
//                            map = (Map<String, Object>) keyValue;
//                        }
//                    }
//                } else {
//                    keyValue = null;
//                    break;
//                }
//            }
//            if (keyValue != null) {
//                value = keyValue.toString();
//            }
//        }
//        return value;
//    }
// getStateObjectValueFromMap refactore replace the above method
// getStateObjectValueFromMap
//
//
//    public boolean isStateObjectKey(Map<String, Object> map, String key) {
//        String[] keyParts = StringUtils.split(key, ".");
//        boolean isKey = false;
//        int countTrue=0;
//        int keyPartsSize = keyParts.length;
//        StringBuilder result = new StringBuilder();
//
//
//        for (String keyPart : keyParts) {
//            if (map != null && map.containsKey(keyPart)) {
//                countTrue++;
//                isKey=true;
//                result.append(isKey+",") ;
//            }
//        }
//        return keyPartsSize == countTrue;
//    }