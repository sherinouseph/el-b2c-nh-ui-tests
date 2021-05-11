package com.englishlive.tests.experience.core;
/**
 * Created by nikol.marku on 9/1/2016.
 * https://jira-bos.englishtown.com/browse/SAND-3711
 *
 * If page contains content targeting .. then
 *
 * Content target based on segmentation list below :
 1. ctr
 2. ipctr = cookie value ... need to be set on the header
 3. ptn
 4. etag
 5. exp
 6. offerid

 Requirements
 1. test default
 2. test all params set [] each of parma alone [ on segmentation list]
 3. cl|co test more that one value for segment
 4. test for none as value ...ptn= .... test ptn .. not set .. on ulr anb set to none
 5. check if default set with other params default is the one considered
 6. exp parameter [only] can override same session itself [other params can not]
 7. all parameters are persisted on same session .. if open
 url1 with exp = 1 and then navigate to a new page same session ... exp 1 param persisted ...
 !!!!start on page without exp set to make it easy
 8. More than one param set should show the correct section
 configs:
 Req 1. default only : no group or other param set https://qa-englishlive.ef.com/es-mx/lp/oe/es-experience-autotest/
 Req 2. ctr=ar only experience https://qa-englishlive.ef.com/es-mx/lp/oe/es-experience-autotest/?ctr=ar
 Req 2. ptn=mkge only experience https://qa-englishlive.ef.com/es-mx/lp/oe/es-experience-autotest/?ptn=mkge
 Req 4. ptn= empty none only experience https://qa-englishlive.ef.com/es-mx/lp/oe/es-experience-autotest/?ptn=
 Req 2. etag=etag2 only experience https://qa-englishlive.ef.com/es-mx/lp/oe/es-experience-autotest/?etag=etag2
 Req 2. exp=v035 only experience https://qa-englishlive.ef.com/es-mx/lp/oe/es-experience-autotest/?exp=v035
 Req 2. offerid=365745 only experience https://qa-englishlive.ef.com/es-mx/lp/oe/es-experience-autotest/?offerid=365745
 Req 2. ipctr=mx only experience https://qa-englishlive.ef.com/es-mx/lp/oe/es-experience-autotest/?ipctr=mx
 // mix match
 Req 3. ctr=ar|pe|cl experience https://qa-englishlive.ef.com/es-mx/lp/oe/es-experience-autotest/?ctr=pe
 Req 3. exp=v001|v035|v887 experience https://qa-englishlive.ef.com/es-mx/lp/oe/es-experience-autotest/?exp=v035
 Req 5. default=true, exp=v001|v035|v887 experience https://qa-englishlive.ef.com/es-mx/lp/oe/es-experience-autotest/
 Req 6. exp=v001|v035|v887 experience[open homepage exp=v001] then go to https://qa-englishlive.ef.com/es-mx/lp/oe/es-experience-autotest/?exp=v035
 Req 7. exp=v001|v035|v887 experience[open homepage exp=v001] then go to https://qa-englishlive.ef.com/es-mx/lp/oe/es-experience-autotest/
 shows exp v001
 Req 8. exp=v001|v035|v887 ptn=mkge|gogg ctr=pe|de https://qa-englishlive.ef.com/es-mx/lp/oe/es-experience-autotest/?exp=v035&ptn=mkge&ctr=pe
 *
 *
 */
import com.englishtown.dataprovider.ExperienceTestDataProvider;
import com.englishtown.driver.local.DriverManager;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.tests.core.BaseTestHelper;
import com.machinepublishers.jbrowserdriver.JBrowserDriver;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class MXCheckExperienceTest extends BaseTestHelper {
    private static final Logger logger = LoggerFactory.getLogger(MXCheckExperienceTest.class);
    protected String epx001 = "exp=v001";
    protected String epx035 = "exp=v035";
    protected String expPageUrl           = "englishlive.ef.com/es-mx/lp/oe/es-experience-autotest/";
    protected String expPageUrlWithExp001 = "englishlive.ef.com/es-mx/lp/oe/es-experience-autotest/"+"?"+epx001;
    protected String expPageUrlWithExp035 = "englishlive.ef.com/es-mx/lp/oe/es-experience-autotest/"+"?"+epx035;
    protected String homePageUrlWitExp001 = "englishlive.ef.com/es-mx/"+"?"+epx001;
    private JBrowserDriver driver;

    @BeforeClass
    public void setup(){
        //failTestIfIsNotBrowser(CHROME_BROWSER_LIST, "Chrome Only Test ....!");
    }

    @Test(dataProvider = "experienceTest", dataProviderClass = ExperienceTestDataProvider.class, timeOut = 460000)//, threadPoolSize = 3, invocationCount = 1,  )
    public void opentUrlCheckExperienceTest(String srcContainsList, String url) throws Exception{

        try {
            setThreadSafeDriver(); //DriverManager.createDriver(MyBrowserType.CHROME, 15);
            openUrl(DriverManager.getDriver(), getBASEURL()+url);
            sleep(1000);
            String src = DriverManager.getDriver().getPageSource();

            if(StringUtils.isNotBlank(src)){
                if(srcContainsList.split("/").length > 1) {                                                             //Set<String > setSrc = new HashSet<String>(Arrays.asList(src)); AssertHelper.assertThat("Expected text is not present on the page source code ...!", setSrc,  containsInAnyOrder(Arrays.asList(srcContainsList)));
                    for (String part : srcContainsList.split("/")) {
                        logger.info("Check source contains [" + part + "]");
                        if(StringUtils.containsIgnoreCase(src, part.trim())) {
                            logger.info("Page Source contains {{}}", part);
                        }else
                            failTest("Expected text {"+part+"} is not present on the source code ...!");                //AssertHelper.assertThat("Expected text is not present on the source code ...!", src, containsIgnoringCase(part.trim()));
                    }
                } else {                                                                                                //AssertHelper.assertThat("Expected text is not present on the source code ...!", src, containsIgnoringCase(srcContainsList));
                    if(StringUtils.containsIgnoreCase(src, srcContainsList)) {
                        logger.info("Page Source contains {{}}", srcContainsList);
                    }else
                        failTest("Expected text {"+srcContainsList+"} is not present on the source code ...!");
                }
            } else {
                failTest("Can not get the source code for this page ....!");
            }
        }catch (Exception e ){
           logger.error(" URL : "+url+" \n"+e.getMessage());

        }finally {
            logger.info("Finally destroy driver ...!");
            //DriverManager.destroyLocalDriver();
            destroyDriver();
        }
    }

    /**
     * Req 6. override exp param exp=v001|v035|v887 experience[open homepage exp=v001]
     *        then go to https://qa-englishlive.ef.com/es-mx/lp/oe/es-experience-autotest/?exp=v035
     */

    @Test(timeOut = TEST_TIMEOUT_SHORT_MLS)
    void testOverrideExpParam(){
        try{
            setThreadSafeDriver(); //DriverManager.createDriver(MyBrowserType.CHROME, 15);
            openUrl(DriverManager.getDriver(), getBASEURL()+expPageUrlWithExp001); //homePageUrlWitExp001);

            String src = DriverManager.getDriver().getPageSource();

            if(StringUtils.isNotBlank(src)){
                //AssertHelper.assertThat("Expected text is not present on the source code ...!", src, containsIgnoringCase(epx001.split("=")[1]));
                if(StringUtils.containsIgnoreCase(src, epx001.split("=")[1])) {
                    logger.info("Page Source contains {{}}", epx001.split("=")[1]);
                }else
                    failTest("Expected text {"+epx001.split("=")[1]+"} is not present on the source code ...!");
            } else {
                failTest("Can not get the source code for this page ....!");
            }
            openUrl(DriverManager.getDriver(), getBASEURL()+expPageUrlWithExp035);

            src = DriverManager.getDriver().getPageSource();
            if(StringUtils.isNotBlank(src)){
                //AssertHelper.assertThat("Expected text is not present on the page source code ...!", src, containsIgnoringCase(epx035.split("=")[1]));
                if(StringUtils.containsIgnoreCase(src, epx035.split("=")[1])) {
                    logger.info("Page Source contains {{}}", epx035.split("=")[1]);
                }else
                    failTest("Expected text {"+epx035.split("=")[1]+"} is not present on the source code ...!");
            } else {
                failTest("Can not get the page source code for this page ....!");
            }
        }catch (Exception e ){
            logger.error("  !!! " +e.getMessage());
        }finally {
            logger.info("Finally destroy driver ...!");
            destroyDriver();  //DriverManager.destroyLocalDriver();
        }
    }

    /**
     * Req 7. exp=v001|v035|v887 experience[open homepage exp=v001]
     *        then go to https://qa-englishlive.ef.com/es-mx/lp/oe/es-experience-autotest/
     */
    @Test(timeOut = TEST_TIMEOUT_SHORT_MLS)
    void testExpPersistedWhenNewUrlOpen(){
        try{
            setThreadSafeDriver(); //DriverManager.createDriver(MyBrowserType.CHROME, 15);
            openUrl(DriverManager.getDriver(), getBASEURL()+expPageUrlWithExp001);     //homePageUrlWitExp001);
            String src = DriverManager.getDriver().getPageSource();
            //TestUtil.getScreenShotUsingAShot(DriverManager.getDriver(), ".\\target\\"+TestUtil.generateRandomFilename("exp0_") + ".png");
            if(StringUtils.isNotBlank(src)){
                //AssertHelper.assertThat("Expected text is not present on the source code ...!", src, containsIgnoringCase(epx001.split("=")[1]));
                if(StringUtils.containsIgnoreCase(src, epx001.split("=")[1])) {
                    logger.info("Page Source contains {{}}", epx001.split("=")[1]);
                }else
                    failTest("Expected text {"+epx001.split("=")[1]+"} is not present on the source code ...!");
            } else {
                failTest("Can not get the source code for this page ....!");
            }

            openUrl(DriverManager.getDriver(), getBASEURL()+expPageUrl);
            src = DriverManager.getDriver().getPageSource();
            TestUtil.getScreenShotUsingAShot(DriverManager.getDriver(), ".\\target\\"+TestUtil.generateRandomFilename("exp_") + ".png");
            if(StringUtils.isNotBlank(src)){
                //AssertHelper.assertThat("Expected text is not present on the page source code ...!", src, containsIgnoringCase(epx001.split("=")[1]));
                if(StringUtils.containsIgnoreCase(src, epx001.split("=")[1])) {
                    logger.info("Page Source contains {{}}", epx001.split("=")[1]);
                }else
                    failTest("Expected text {"+epx001.split("=")[1]+"} is not present on the source code ...!");
            } else {
                failTest("Can not get the page source code for this page ....!");
            }
        }catch (Exception e ){
            logger.error("  !!! " +e.getMessage());
        }finally {
            logger.info("Finally destroy driver ...!");
            destroyDriver(); //DriverManager.destroyLocalDriver();
        }
    }


}





//>>>>>>> feature/new/SAND-3711-exp
// old
//package com.englishlive.tests.experience.core;
//
//import com.englishtown.dataprovider.ExperienceTestDataProvider;
//import com.englishtown.dataprovider.HomePageDataProvider;
//import com.englishtown.driver.MyBrowserType;
//import com.englishtown.driver.local.DriverManager;
//import com.englishtown.helpers.AssertHelper;
//import com.englishtown.helpers.utils.TestUtil;
//import com.englishtown.tests.core.BaseTestHelper;
//import org.apache.commons.lang.StringUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.testng.annotations.Test;
//
//import static com.englishtown.helpers.CaseInsensitiveSubstringMatcher.containsIgnoringCase;
//
///**
// * Created by nikol.marku on 9/1/2016.
// * https://jira-bos.englishtown.com/browse/SAND-3711
// *
// *
// */
//public class BaseCheckExperienceTest extends BaseTestHelper {
//    private static final Logger logger = LoggerFactory.getLogger(BaseCheckExperienceTest.class);
//
//
//    @Test(dataProvider = "experienceTest", dataProviderClass = ExperienceTestDataProvider.class)//, threadPoolSize = 1, invocationCount = 1, timeOut = 65000 )
//    public void opentUrlCheckRedirectUrlTest(String srcContainsList, String url) throws Exception{
//        try {
//            DriverManager.createDriver(MyBrowserType.HTMLUNIT, 15);
//            openUrl(DriverManager.getDriver(), getBASEURL()+url);
//            //$('.richtext p')
//            sleep(3000);
//            String src = DriverManager.getDriver().getPageSource();
//            if(StringUtils.isNotBlank(src)){
//                if(srcContainsList.split("/").length > 1) {
//                    for (String part : srcContainsList.split("/")) {
//                        logger.info("Check source contains [" + part + "]");
//                        AssertHelper.assertThat("Expected text is not present on the source code ...!", src, containsIgnoringCase(part.trim()));
//                    }
//                } else {
//                    AssertHelper.assertThat("Expected text is not present on the source code ...!", src, containsIgnoringCase(srcContainsList));
//                }
//            }
//        }catch (Exception e ){
//           logger.error(" URL : "+url+" \n"+e.getMessage());
//
//        }finally {
//            logger.info("Finally destroy driver ...!");
//            DriverManager.destroyLocalDriver();
//        }
//    }
//
//
//}
