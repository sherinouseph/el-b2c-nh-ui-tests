package com.englishtown.newhouse.apicore.amdmodule;
/**
 * Created by nikol.marku on Dec-2018.
 *
 *  * access https://englishlive.ef.com/etc/designs/b2c/amdmodules/commit.txt to get the release hash tag
 *  * access https://englishlive.ef.com/1/amd-dynamic-bundler/code?$&pages/englishlive2016/blockerEvents&pages/englishlive2016/modeDetector&pages/englishlive2016/scrollTo&pages/englishlive2016/svgInline&pages/englishlive2016/viewport&shared/initializer/die&shared/initializer/etctxtsess&c=[hash tag goes here]
 *  * make sure the request returns with string "define(", and also within limited timeout
 *  *
 */

import com.englishtown.newhouse.apicore.BaseSpecSuite;
import io.restassured.RestAssured;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.text.IsEmptyString.isEmptyOrNullString;


public abstract class BaseAmdModuleSpecSuite extends BaseSpecSuite {
    public static final Logger logger = LoggerFactory.getLogger(BaseAmdModuleSpecSuite.class);

    protected String hashtag;                // get this from the first url response
    protected String BODY_CONTAINS = "define(";
    protected String AMD_MODULES_URL    = "https://englishlive.ef.com/etc/designs/b2c/amdmodules/commit.txt";
    protected String AMD_BUNDLECODE_URL = "https://englishlive.ef.com/1/amd-dynamic-bundler/code"; //*?$&pages/englishlive2016/" +
    protected String BUNDLECODE_PARAM_URL = "pages/englishlive2016/blockerEvents&pages/englishlive2016/modeDetector&pages/englishlive2016/scrollTo&pages/englishlive2016/" +
            "svgInline&pages/englishlive2016/viewport&shared/initializer/die&shared/initializer/etctxtsess&c=";


    public void getSpecCommitTextHashTag( ){
        cleanUp();
        initSpecGetCommitText();
        initResponseGetCommitText();

        response = defaultGetResponseGetSpec();

        try {
            hashtag = response.body().asString();
            logger.info("hashtag [" + hashtag + "] ");
        } catch (Exception e) {
            logger.error("Cant get hashtag ...!" + e.getMessage());
        }
    }

    public void initSpecGetCommitText(){
        testBaseUrl = AMD_MODULES_URL;
        setBaseURI(testBaseUrl);
        setSpecUrl(testBaseUrl);
        requestSpecification = setDefaultFilterRequestSpecBuilder();
    }

    public void initResponseGetCommitText( ){
        logger.info("Check Response ");
        expectedResponseCode = 200;
        responseSpecBuilder.expectStatusCode( expectedResponseCode);
        responseSpecBuilder.expectBody(not(isEmptyOrNullString()));
        responseSpecification = responseSpecBuilder.build();
    }

    public void getSpecBundleCode( ){
        cleanUp();
        initSpecBundleCode();
        initResponseBundleCode();
        response = defaultGetResponseGetSpec();
    }

    public void initSpecBundleCode(){
        RestAssured.urlEncodingEnabled = false;
        testBaseUrl = AMD_BUNDLECODE_URL;//+hashtag;
        setBaseURI(testBaseUrl);
        setSpecUrl(testBaseUrl);

        requestSpecBuilder.addQueryParam("pages/englishlive2016/blockerEvents");
        requestSpecBuilder.addQueryParam("pages/englishlive2016/modeDetector");
        requestSpecBuilder.addQueryParam("pages/englishlive2016/scrollTo");
        requestSpecBuilder.addQueryParam("pages/englishlive2016/svgInline");
        requestSpecBuilder.addQueryParam("pages/englishlive2016/viewport");
        requestSpecBuilder.addQueryParam("shared/initializer/die");
        requestSpecBuilder.addQueryParam("shared/initializer/etctxtsess");
        requestSpecBuilder.addQueryParam("c="+hashtag);

        requestSpecification = setDefaultFilterRequestSpecBuilder();
    }

    public void initResponseBundleCode(){
        logger.info("Check Response ");
        expectedResponseCode = 200;
        responseSpecBuilder.expectStatusCode( expectedResponseCode);
        responseSpecBuilder.expectBody(not(isEmptyOrNullString()));
        responseSpecBuilder.expectBody(containsString(BODY_CONTAINS));
        responseSpecification = responseSpecBuilder.build();
    }

}


/**
 *
 String DECODED_BUNDLECODE_URL = "";
 try{
 DECODED_BUNDLECODE_URL =  java.net.URLDecoder.decode(AMD_BUNDLECODE_URL, "UTF-8");
 logger.info(AMD_BUNDLECODE_URL);
 logger.info(DECODED_BUNDLECODE_URL);
 }catch (UnsupportedEncodingException e){
 logger.error(e.getMessage());
 failTest("Cant decode url ...! "+e.getMessage());
 }
 */
