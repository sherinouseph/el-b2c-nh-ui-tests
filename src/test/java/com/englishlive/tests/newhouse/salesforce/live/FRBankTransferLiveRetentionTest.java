//package com.englishlive.tests.newhouse.salesforce.live;
///**
// * Sherin - 14/12/2017
// * Login to sales force
// * Create the actuals through Bank Transfer
// */
//
//import com.englishlive.tests.newhouse.salesforce.base.paymentflow.BaseBankTransferTest;
//import com.englishtown.helpers.JavaScriptHelper;
//import com.englishtown.helpers.WebDriverWindowHelper;
//import com.englishtown.newhouse.salesforce.pages.ActualSalesForcePage;
//import com.englishtown.newhouse.salesforce.pages.LeadsHomePage;
//import com.englishtown.newhouse.salesforce.pages.NewLeadSalesForcePage;
//import com.englishtown.newhouse.salesforce.pages.SelectLeadRecordType;
//import com.englishtown.newhouse.salesforce.pages.core.SalesForceConstants;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;
//
//public class FRBankTransferLiveRetentionTest extends BaseBankTransferTest {
//    private static final Logger logger = LoggerFactory.getLogger(FRBankTransferLiveRetentionTest.class);
//
//
//    @BeforeTest
//    public void setup(){
//        leadRecordType = "Turkey";
//        SALESFORCE_ENV = "Live";
//        productName       = "EU PT 52 12m";
//        paymentMethod     = "Bank Transfer";
//        leadMapData       = SalesForceConstants.LEAD_MAP;
//        setThreadSafeDriver();
//        salesForceAgentName = "evan.sun@ef.com";
//        salesForceSupervisorName=salesForceAgentName;//"evan.sun@ef.com";
//        salesForceUserName = salesForceAgentName;
//    }
//
//
//  @Override//Live test use admin profile to create the lead until stefano creates the users.Hence overriding the method.
//  public void createLead()    {
//      click(homeSalesForcePage.leadTabWe);
//      // Lead
//      leadsHomePage = new LeadsHomePage(getWebDriver(), SALESFORCE_WAIT_MED);
//      leadsHomePage.simpleTest();
//      click(leadsHomePage.newBtn);
//
//          selectLeadRecordType = new SelectLeadRecordType(getWebDriver(), SALESFORCE_WAIT_MED);
//          selectLeadRecordType.selectRecordTypeAndClickContinue(leadRecordType);
//
//      // new lead
//      newLeadSalesForcePage = new NewLeadSalesForcePage(getWebDriver(), SALESFORCE_WAIT_MED);
//      enterFormData(leadMapData);
//      enterEmail(getWebDriver(),leadRecordType);
//      newLeadSalesForcePage.selectCountry(leadCountry);
//      click(newLeadSalesForcePage.aptdateWe);
//      // selectDate(newLeadSalesForcePage.aptdateWe);
//      newLeadSalesForcePage.saveLead();
//  }
//
//  @Override //Test users to be added on live.until then we will be overriding this method
//   protected void activateCourseTest(){
//      getUrlsAndcheckActuals();
//      actualSalesForcePage=new ActualSalesForcePage(getWebDriver(),SALESFORCE_WAIT_MED);
//      JavaScriptHelper.scrollToXY(getWebDriver(),0,3000);
//      actualSalesForcePage.approveInActuals();
//      clickActivateCourseBtn();
//      WebDriverWindowHelper.switchToWindow(getWebDriver(),1);
//      activateCourse();
//      WebDriverWindowHelper.switchToWindow(getWebDriver(),0);
//      sleep(2000);
//  }
//
//    @AfterTest   //Deleting the actual and opportunity after teh creation to cleanup live env
//    protected void testAfterClass(){
//       /*openUrl(getWebDriver(),actualUrl);
//       deleteObject("Actual");
//       verifyObjectDeletion("Actual","/a00/o",".headerRow",0,"No records to display",actualUrl);
//       openUrl(getWebDriver(),oppoUrl);
//       deleteObject("Opportunity");
//       verifyObjectDeletion("Opportunity","/006/o","#bodyCell table td",0,"Record deleted",oppoUrl);
//       */
//       destroyDriver();
//    }
//
//
//}
