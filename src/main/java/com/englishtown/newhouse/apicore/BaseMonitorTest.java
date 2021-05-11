package com.englishtown.newhouse.apicore;
/**
 *
 * Open Health APIs for all projects [main once .. see dataProvider]
 *
 * Check
 responseSpecBuilder.expectStatusCode( expectedResponseCode);
 responseSpecBuilder.expectBody("status",    equalTo("ok"));
 responseSpecBuilder.expectBody("date",      not(isEmptyOrNullString()));
 responseSpecBuilder.expectBody("host_name", not(isEmptyOrNullString()));
 *
 * sample Response
 *
  status": "ok",
 "date": "2018-03-14T15:00:53.8311986+00:00",
 "host_name": "commerce-api-521625426-vgbpv",
 "details": []
 *
 */
import com.englishtown.newhouse.apicore.dataprovider.ApiDataProvider;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;


public abstract class BaseMonitorTest extends BaseSpecSuite {
    public static final Logger logger = LoggerFactory.getLogger(BaseMonitorTest.class);



    @Test(dataProvider = "apiHealthMonitorUrls", dataProviderClass = ApiDataProvider.class)//, threadPoolSize = 5, invocationCount = 1, timeOut = 120000 )
    void MonitorAllApisHealth(int id, String testUrl){
        logger.info("\n\n\t\tMonitor APIs health ...!-> ["+id+"] -URL :"+testUrl+"] <-!\n\n" );
        initSpecMonitorApi(getBASE_TEST_URL()+testUrl);

    }


    @Override
    public void setupTestBeanDataAndSpec() {
    }

}

