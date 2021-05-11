package com.englishtown.newhouse.apicore.toefltoeic;
/**
 * Created by nikol.marku on Nov-2018.
 *
 * To conclude what we have in this service:
 *
 * /validate for validate if user exists
 * /error for showing correspondig error message
 * /tracking for tracking, what it does is simply output the log to standard out, which will be collected by kibana
 * For detailed information regarding to how English Live is supposed to communicate with Testden, please read here: Letter from Radames
 *
 * https://bitbucket.eflabs.io/projects/B2C/repos/toefl-and-toeic-service/browse?at=master
 *
 */

import com.englishtown.newhouse.apicore.BaseSpecSuite;
import io.restassured.http.ContentType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.hamcrest.core.Is.is;


public abstract class BaseToeflToeicSpecSuite extends BaseSpecSuite {
    public static final Logger logger = LoggerFactory.getLogger(BaseToeflToeicSpecSuite.class);

    protected static final String BASE_TOEFL_TOEIC = "toefl-and-toeic-service/";
    protected static final String [] ACTION_TOEFL_TOEIC = {"validate", "error", "tracking"};


    public void toefltoeicValidate(String userName, boolean isNewHouseUser, String expectedResult ){
        cleanUp();
        initSpecValidate(userName, isNewHouseUser);
        initResponseValidate(expectedResult );

        response = defaultGetResponseGetSpec();
        /*try {
            studentBean.setOrder_id(response.jsonPath().getString("Order_id"));
            logger.info("OrderID [" + studentBean.getOrder_id() + "] ");
        } catch (Exception e) {
            logger.error("Cant get Order ID [" +  studentBean.getOrder_id()+ "] " + e.getMessage());
        }*/

    }

    public void initSpecValidate(String userName, boolean isNewHouseUser ){
        testBaseUrl = getBASE_TEST_URL()+BASE_TOEFL_TOEIC + ACTION_TOEFL_TOEIC[0]+"/"+userName ;
        setBaseURI(testBaseUrl);
        setSpecUrl(testBaseUrl);
        requestSpecBuilder.setContentType(ContentType.TEXT);
        //requestSpecBuilder.addHeader("Authorization", "Bearer uuid:"+studentBean.getUuid());
        requestSpecification = setDefaultFilterRequestSpecBuilder();
    }

    /**
     * use for member and order
     *
     */
    public void initResponseValidate(String expectedResult ){
        logger.info("Check Response ");
        expectedResponseCode = 200;
        responseSpecBuilder.expectStatusCode( expectedResponseCode);
        //responseSpecBuilder.expectBody("$", is(expectedResult));
        responseSpecBuilder.expectBody(is(expectedResult));
       //AssertHelper.assertThat("Not the expected response ...!", response.asString(), containsIgnoringCase(expectedResult));

        responseSpecification = responseSpecBuilder.build();
    }




}
