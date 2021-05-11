package com.englishtown.tests.core.school.support;
/**
 * Login an  test support page
 *
 * User: testuser.support=auto_support@qp1.org
 *
 * Date: 30/07/18
 *
 *
 */
import com.englishtown.tests.core.school.BaseSimpleLogin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;


public abstract class BaseTRSupportPageTest extends BaseSimpleLogin {
    private static final Logger logger = LoggerFactory.getLogger(BaseTRSupportPageTest.class);


    @Test(dependsOnMethods = "checkUserIsAtSchoolHomePage")
    public void goToNewHouseSupportPageTest(){
        initSchoolHeaderAndFooter();
        schoolHeaderAndFooterPage.schoolHeaderPage.goToNewHouseSupport();
        //TODO
        //initNewHouseSupportPage();
        //supportPage.checkAllPageComponentsDisplayed();
    }
//     New support page is live - need to add new test
//    @Test(dependsOnMethods = "goToNewHouseSupportPageTest")
//    public void noSearchResultFound(){
//        supportPage.helpPage.enterSearchText("nothing");
//        supportPage.helpPage.clickSearchBtn();
//        sleep(1000);
//        initNewHouseSupportPage();
//        supportPage.helpPage.assertNoSearchResults();
//    }
//
//    @Test(dependsOnMethods = "noSearchResultFound")
//    public void searchResultFound(){
//        supportPage.helpPage.cleanSearchText();
//        supportPage.helpPage.enterSearchText("course");
//        supportPage.helpPage.clickSearchBtn();
//        sleep(1000);
//        initNewHouseSupportPage();
//        supportPage.helpPage.assertThereAreSearchResults(3);
//    }
//
//
//    // Cant get the selectors
//    @Test(dependsOnMethods = "searchResultFound")
//    public void checkEmailFormTypeEmailAndMessage(){ //sendEmailQAonly(){
//        logger.info("send email only QA  .. todo .. not able to find the css for the drop down ");
//        supportPage.emailPage.typeEmail("niko.test@nikol.tes");
//        supportPage.emailPage.typeMessage("This is a test .. Nikol B2");
//        supportPage.emailPage.checkAllPageComponentsDisplayed();
//        /*if(StringUtils.containsIgnoreCase(getENVIRONMENT(), "live")){
//            logger.warn("Live ENV don't run the test to send email ...!");   //failTest("WE send help emails on QA ENV ....!");
//        }else
//            supportPage.emailPage.enterEmailUsDataAndSend("nikol_test@niko.nik", "Other", "Other","test only nikol b2c london");*/
//    }

    /*@Test(dependsOnMethods = "sendEmailQAonly")
    public void checkEmailSentMsgTest(){
        logger.info("checkEmailSentMsgTest");
        sleep(3000);
        supportPage.initHelpAndEmailPages();
        supportPage.emailPage.checkEmailSent();
    }*/

}
