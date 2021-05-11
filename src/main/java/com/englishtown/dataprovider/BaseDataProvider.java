package com.englishtown.dataprovider;

import com.englishtown.dataprovider.bin.CrmMonitOSOEUrlBean;
import com.englishtown.enumpack.CrmTestType;
import com.englishtown.helpers.reader.MyJsonReader;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.tests.core.BaseTest;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by nikol.marku on 11-Jul-17.
 *
 * Main helpers for data providers
 *
 */
public abstract class BaseDataProvider {

    private static final Logger logger = LoggerFactory.getLogger(BaseDataProvider.class);

    private static AtomicInteger urlId = new AtomicInteger(0);

    public static List<CrmMonitOSOEUrlBean> readCrmMonitOSOEUrlBean(String jasonUrl, String urlFilter){
        MyJsonReader myJsonReader = new MyJsonReader();
        List<CrmMonitOSOEUrlBean> crmMonitUrlList = new ArrayList<>();

        try{
            JSONObject jsonObject = MyJsonReader.readJsonFromUrl(jasonUrl);
            logger.info("jsonObject ["+jsonObject.toString()+"]");
            String valueData = jsonObject.getString("value");
            if(!StringUtils.isBlank(valueData)){
                CrmMonitOSOEUrlBean bean ;
                String [] urls = valueData.split("\n");
                if(ArrayUtils.isEmpty(urls)){
                    logger.error("No data read from CQ file on [{}]", jasonUrl);
                }else {
                    for (String testUrl : urls) {
                        if(!StringUtils.isBlank(testUrl)) {
                            testUrl = testUrl.trim();
                            String ctr = TestUtil.getCountryFromUrl(testUrl);
                            String testTypeStr = "other";

                            if (StringUtils.contains(testUrl, "lp/os/"))
                                testTypeStr = "os";
                            if (StringUtils.contains(testUrl, "lp/oe/"))
                                testTypeStr = "oe";

                            logger.info("testTypeStr is now [{}]", testTypeStr);

                            if(null != urlFilter){
                                logger.info("Create object with URLs that contain [{}]", urlFilter);
                                if (StringUtils.contains(testUrl, urlFilter)) {
                                    bean = new CrmMonitOSOEUrlBean(urlId.getAndIncrement(), testUrl, ctr, CrmTestType.getCrmTestTypeFromString(testTypeStr));
                                    crmMonitUrlList.add(bean);
                                }else {
                                    logger.info(testUrl+ " -> does not contains filter [{}]", urlFilter);
                                }
                            }else {
                                logger.info("Read All urls from file");
                                bean = new CrmMonitOSOEUrlBean(urlId.getAndIncrement(), testUrl.trim(), ctr, CrmTestType.getCrmTestTypeFromString(testTypeStr));
                                crmMonitUrlList.add(bean);
                            }
                        }else
                            logger.warn("Url is blank ...!");

                    }
                }
                logger.info("urls ["+ Arrays.toString(urls)+"]");
            }
        }catch (IOException e){
            e.printStackTrace();
            logger.error(e.getMessage());
        }
        catch (Exception e){
            e.printStackTrace();
            logger.error(e.getMessage());
            BaseTest.failTest("Can not get urls from CQ page [{"+jasonUrl+"}]...."+e.getMessage());
        }

        return crmMonitUrlList;
    }


    public static Object[][] getObject2dArrayFromList(List<CrmMonitOSOEUrlBean> crmMonitUrlList){
        Object[][] objArray = null;

        if(null != crmMonitUrlList && !crmMonitUrlList.isEmpty()) {
            objArray = new Object[crmMonitUrlList.size()][1];

            for (int i = 0; i < crmMonitUrlList.size(); i++) {
                objArray[i][0] = crmMonitUrlList.get(i);
            }
        }else {
            BaseTest.failTest("Data provider [getCrmMonitOSurls] Did not get any Test objects as " +
                    "crmMonitUrlList List is null or empty... !");
        }
        return objArray;
    }

}
