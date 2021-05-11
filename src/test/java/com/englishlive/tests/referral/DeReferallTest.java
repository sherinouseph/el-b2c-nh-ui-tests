//package com.englishlive.tests.referral;
///**
// * Login an existing user [de] and go to referral page and sent a referral
// * User: nikol.marku
// * Date: 09/09/14
// *
// *
// */
//import com.englishtown.driver.BaseRemoteWebDriver;
//import com.englishtown.helpers.*;
//import com.englishtown.helpers.bean.ReferralUser;
//import com.englishtown.helpers.utils.CompareDateUtils;
//import com.englishtown.helpers.utils.TestUtil;
//import com.englishtown.pages.checkout.newcheckout.PaymentThankyouPage;
//import com.englishtown.pages.core.BasePage;
//import com.englishtown.tests.checkout.common.core.NewBaseCheckoutFlow;
//import com.englishtown.tests.core.BaseTest;
//import com.englishtown.tests.core.BaseTestHelper;
//import com.englishtown.tests.core.EfConstants;
//import org.apache.commons.lang.StringUtils;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//import java.util.Date;
//
//import static com.englishtown.helpers.AssertHelper.myAssertThat;
//
//    /// this is going to be removed for the new house so removing test
//
//public class DeReferallTest extends BaseTestHelper {
//    private static final Logger logger = LoggerFactory.getLogger(DeReferallTest.class);
//    @Value("#{applicationPropertiesList['de.de.login.url']}")
//    protected String loginUrl;
//    @Value("#{applicationPropertiesList['de.de.referral.url']}")
//    protected String referralUrl;
//    @Value("#{applicationPropertiesList['de.member.withOffer.url']}")// over 5 months
//    protected String memberUrlwithOffer;
//    @Value("#{applicationPropertiesList['user.all']}") // uk live user test12345et1446135828397@qp1.org
//    protected String testUsername;
//    @Value("#{applicationPropertiesList['de.de.dashboard.url']}")
//    protected String dashboardUrl;
//
//    protected static final String nextPayDateCss = ".panel-body .clearfix:nth-child(2) p";  //49(EUR) angesetzt für den 2016-05-02
//
//
//    protected static String userInvited="";
//    protected static final String referalSubmitBtnCss = "form .sumbit";
//    protected static final String referralTableCell = "tbody.the-referrals-tbody tr:last-child  td:nth-child(2)";//"table.list tbody tr:last-child td:nth-child(2)";     // "$('table.list tbody tr td:nth-child(2)')"; //"table.list tbody td:nth-child(2)";//table.list tbody td $('table.list tbody tr td:nth-child(2)')    //[<td>​teesmoke-aasnikol-nikol@qp1.org​</td>​, <td>​tesetNIkol2@qp1.org​</td>​, <td>​dereferral_os1445343829594@qp1.org​</td>​, <td>​dereferral_os1445343880422@qp1.org​</td>​, <td>​dereferral_os1445343997361@qp1.org​</td>​]
//    protected static final String lastUserStatus    = "tbody.the-referrals-tbody tr:last-child  td:nth-child(3)";//"table.list tbody tr:last-child td:nth-child(3)";
//    protected static ReferralUser inviter;                       //inviter invites invitee
//    protected static ReferralUser inviterAfterInviteePaid;
//    protected static String inviterDateAfterInvityPays;
//    protected static ReferralUser invitee;
//    protected static final String PASS = "password";
//    protected static final int offerPeriod = 210; //180+30
//    protected static final int inviterExtensionPeriod = 30; // current + 30 days
//
//    @BeforeClass
//    protected void setup(){
//        setThreadSafeDriver();
//        openUrl(getWebDriver(), loginUrl);
//        this.username = testUsername;
//        inviter = new ReferralUser(testUsername, PASS, "");
//        inviterAfterInviteePaid = new ReferralUser(testUsername, PASS, "");
//        inviter.print();
//    }
//
//    @Test
//    public void enterUserCredentialsAndLoginTest(){
//        JavaScriptHelper.waitForPageLoaded(getWebDriver(), WaitTool.DEFAULT_WAIT_4_ELEMENT);
//        enterCredentialsReferAFriend(getWebDriver(), testUsername, PASS, "UserName", "Password",".button-submit");
//        //enterCredentialsReferAFriend(getWebDriver(), testUsername, "password", emailId, passwordId);
//    }
//
//    @Test ( dependsOnMethods = { "enterUserCredentialsAndLoginTest" })
//    public void openReferralPage(){
//        openUrl(getWebDriver(), referralUrl, WaitTool.MED_WAIT_4_ELEMENT25);       // WaitTool.waitForCondition(ExpectedConditions.elementToBeClickable(By.name("yourname")), getWebDriver(),WaitTool.MED_WAIT_4_ELEMENT25);
//    }
//
//    @Test ( dependsOnMethods = { "openReferralPage" })
//    public void enterReferralDetails(){
//        enterFormDataCss(EfConstants.DE_REFERRAL_MAP);
//        userInvited = EfConstants.DE_REFERRAL_MAP.get(".message");
//        invitee = new ReferralUser(userInvited, PASS, "");
//        logger.info("New Referral user is : "+userInvited);
//        invitee.print();
//    }
//    @Test ( dependsOnMethods = { "enterReferralDetails" })
//    public void submitReferralWaitForDetailsToShow(){
//        clickListWebElement(getWebDriver(),By.cssSelector("button[class='submit btn btn-primary']"),0);
//        WebDriverWindowHelper.closeAlertAndGetItsText(getWebDriver(),true);
//        //WebElementHelper.safeFindAndClick(getWebDriver(), By.cssSelector("button[class='submit btn btn-primary']"));        //waitForElementCondition(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(referralTableCell)), getWebDriver(), 15);
//    }
//
//    @Test ( dependsOnMethods = { "submitReferralWaitForDetailsToShow" })
//    public void checkRefListContainNewReferral(){
//        WebElement referralWE= WaitTool.findElement(getWebDriver(), By.cssSelector(referralTableCell));//List<WebElement> referralWE= WaitTool.findElements( getWebDriver(), By.cssSelector(referralTableCell) );
//        AssertHelper.assertThat("Failed to find the Referral email on the list after referral send ...!",
//                TestUtil.getWebElementText(referralWE).trim().equals(userInvited));
//    }
//
//    @Test ( dependsOnMethods = { "checkRefListContainNewReferral" })
//    public void checkNewReferralStatusIsPending(){
//        WebElement statusWE= WaitTool.findElement( getWebDriver(), By.cssSelector(lastUserStatus) );
//        AssertHelper.assertThat("User status is not in Pending state ...!",
//                TestUtil.getWebElementText(statusWE).trim().equals("Pending" ) );
//    }
//
//    @Test ( dependsOnMethods = { "checkNewReferralStatusIsPending" })
//    public void setInviterNextPayBeforeInviteePays(){
//        setNextPay(inviter);
//    }
//
//    // new referral pays for an offer and both get 30 days extension
//    @Test ( dependsOnMethods = { "setInviterNextPayBeforeInviteePays" })
//    public void openMemberPage(){
//        CookieHandler.deleteCookies(getWebDriver());
//        creditCardLinkText="Kreditkarte";
//        tabId = 1;
//        if(! "htmlunit".equals(BaseRemoteWebDriver.getCurrentBrowserName())){
//            CookieHandler.deleteCookies(getWebDriver());
//        }
//        openUrl(getWebDriver(), memberUrlwithOffer);
//        this.username = userInvited;
//    }
//
//    @Test ( dependsOnMethods = { "openMemberPage" })
//    public void enterMemberDetails(){
//        logger.info("start enterMemberDetails ....!");
//        WaitTool.waitForCondition( ExpectedConditions.invisibilityOfElementLocated(
//                By.cssSelector(NewBaseCheckoutFlow.memberSpinnerCss)),getWebDriver(),20);
//        EfConstants.membersFormNoEmail.put( "email",invitee.getUserName());
//        enterFormData(EfConstants.membersFormNoEmail);
//        submit(findElement(By.name("firstname")));
//        //WebElementHelper.safeFindAndClick(getWebDriver(),By.cssSelector(".bs3 button") );//id=form_button
//    }
//    @Test ( dependsOnMethods = { "enterMemberDetails" })
//    public void selectTabAndRemoveValidation(){
//        WaitTool.waitForCondition( ExpectedConditions.invisibilityOfElementLocated(
//                By.cssSelector(NewBaseCheckoutFlow.memberSpinnerCss)),getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
//        if (isClickTabId) {                                                                                             // WebElementHelper.clickOnTabId(getWebDriver(), By.cssSelector(tabsListWe), tabId);// nexus issue and ff
//            WebElementHelper.clickOnTabByLinkText(getWebDriver(), creditCardLinkText) ;                                 // clickOnTabId(getWebDriver(), By.linkText(creditCardLinkText), tabId);// nexus issue and ff
//            logger.info(" Tab clicked ...!");
//        }else logger.info(" Did NOT clicked on Tab id : ", tabId);
//        //
//        remove_PaymentValidation();
//        JavaScriptHelper.waitForPageLoaded(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
//    }
//
//    @Test(dependsOnMethods = { "selectTabAndRemoveValidation" })
//    public void enterPayFormData_and_submit() {
//        enter_PayFormDataAndSubmit();
//        try{Thread.sleep(1000);  }catch(Exception e){}
//    }
//
//    @Test(dependsOnMethods = { "enterPayFormData_and_submit" })
//    public void click_StartLearning(){        //JavaScriptHelper.waitForPageLoaded(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);        //try{Thread.sleep(3000);  }catch(Exception e){}
//        thankyouPage = new PaymentThankyouPage(getWebDriver()) ;
//        thankyouPage.getPageLoadedCondition();
//        sleep(3000);
//        thankyouPage.startLearning.click();        //try{Thread.sleep(3000);  }catch(Exception e){}
//        JavaScriptHelper.waitForPageLoaded(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);        //openUrl(getWebDriver(),"http://www.englishtown.de/campus/enrollment/b2c/entrance#1");
//    }
//
//    @Test ( dependsOnMethods = { "click_StartLearning" })
//    public void enrolStudent(){
//        enrolStudentCheckAtSchool();
////        String [] steps = {"[data-blurb-id='627082']", "[data-blurb-id='627094']", "[data-blurb-id='632678']"};// steps id to enrol // data-blurb-id="627082"    //.circle-content
////        for(String css : steps){
////            WebElementHelper.safeFindAndClick(getWebDriver(),  By.cssSelector(css));
////            sleep(100);
////        }
//    }
//
//    @Test ( dependsOnMethods = { "enrolStudent" })
//    public void setInviteeNextPay(){
//        openUrl(getWebDriver(),dashboardUrl );
//        setNextPay(invitee);  // A:2017-07-26   B:2016-05-19
//    }
//    /**
//     *  Date should be today +180Days+30Days Extension -- note: offer is 180 Days
//     */
//    @Test ( dependsOnMethods = { "setInviteeNextPay" })
//    public void validate_Invitee_Got_30_Days_extensions(){
//        String inviterExpectedDate = CompareDateUtils.getExpectedDate(null, offerPeriod); // new SimpleDateFormat("yyyy-MM-dd").format(CompareDateUtils.getCalendar(210).getTime()) ;
//        logger.info("expectedDate         : "+inviterExpectedDate);
//        logger.info("invitee.getNextPay() : "+invitee.getNextPay());
//        logger.info("Compare date is : " + CompareDateUtils.compareDate(invitee.getNextPay(), inviterExpectedDate) );
//        AssertHelper.assertThat("User did not get 30 days extension ...! \n\t\texpectedDate : "+inviterExpectedDate+
//                                "\n\t\tinvitee Next Pay :"+invitee.getNextPay(),
//                                CompareDateUtils.compareDate(invitee.getNextPay(), inviterExpectedDate) == 0);
//    }
//
//    /**
//     * Check Inviter date is updated with +30days extension
//     */
//    @Test ( dependsOnMethods = { "setInviteeNextPay" })
//    public void inviterLoginAndGoesToDashboardPageAndSetNextPay(){
//        CookieHandler.deleteCookies(getWebDriver());
//        // login user
//        openUrl(getWebDriver(), loginUrl);
//        enterCredentialsReferAFriend(getWebDriver(), testUsername, PASS, "UserName", "Password",".button-submit");
//        //enterUserLoginCredentials(getWebDriver(), testUsername, PASS, emailId, passwordId);
//    }
//    @Test ( dependsOnMethods = { "inviterLoginAndGoesToDashboardPageAndSetNextPay" })
//    public void setNewInviterNextPay(){
//        setNextPay(inviterAfterInviteePaid);
//    }
//    @Test ( dependsOnMethods = { "setNewInviterNextPay" })
//    public void validate_Inviter_Got_30_Days_extensions(){
//        Date expectedDate = CompareDateUtils.getDate(inviter.getNextPay(), inviterExtensionPeriod);
//        Date currentDate  = CompareDateUtils.getDate(inviterAfterInviteePaid.getNextPay(), 0);
//        logger.info("expectedDate  : "+expectedDate.toString());
//        logger.info("currentDate   : "+currentDate.toString());
//        logger.info("Compare date  : " + CompareDateUtils.compareDate(expectedDate, currentDate));
//        AssertHelper.assertThat("User did not get 30 days extension ...! \n\t\texpectedDate : "+expectedDate+
//                        "\n\t\tinvitee Next Pay :"+currentDate,
//                        CompareDateUtils.compareDate(expectedDate, currentDate) == 0);
//    }
//
//    @Test ( dependsOnMethods = { "validate_Inviter_Got_30_Days_extensions" })
//    public void validateInviteeStatusSuccessful(){
//        openUrl(getWebDriver(), referralUrl);
//        sleep(600);
//        WebElement statusWE= WaitTool.findElement( getWebDriver(), By.cssSelector(lastUserStatus) );
//        logger.info(" Invitee [{}] Status :"+TestUtil.getWebElementText(statusWE), invitee.getUserName());
//        AssertHelper.myAssertThat(getWebDriver(), "User status is not in Successful state...!",
//                TestUtil.getWebElementText(statusWE).trim().equals("Successful"), false);
//    }
//    @AfterClass
//    public void cancelSubscription(){
//        destroyDriver();
//        if(StringUtils.containsIgnoreCase(getENVIRONMENT(), "live") ) {
//                cancelUserSubscription(getUserEmail());
//        } else{
//                logger.info("Subscription for user {{}} is not canceled as this is not live ENV ...!", getUserEmail());
//        }
//
//    }
//
//    //---------------------------------------------------------------------------------------------------------------
//    /**
//     * Open dashboard page and setup user with the next pay date
//     * @param referralUser
//     */
//    public void setNextPay(ReferralUser referralUser){
//        openUrl(getWebDriver(), dashboardUrl);
//        WebElement nextPay = findElement(By.cssSelector(nextPayDateCss));
//        String nextPayStr="";
//        if(nextPay != null && nextPay.getText()!=null) {
//            try {
//                nextPayStr = nextPay.getText().trim();
//                int startIndex = nextPayStr.length() - 11;
//                logger.info("startIndex : "+startIndex);
//                nextPayStr =nextPayStr.substring(startIndex);
//                referralUser.setNextPay(nextPayStr);
//                referralUser.print();
//            }catch (IndexOutOfBoundsException ie){
//                ie.printStackTrace();
//                BasePage.failTest(" IndexOutOfBoundsException : Can't get nex payment date ...! "+ TestUtil.getException(ie));
//            }
//        } else {
//            BasePage.failTest(" Can't get nex payment date ...! nextPay is null or .getText() is null");
//        }
//    }
//
//
//
//}