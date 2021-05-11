//package com.englishlive.tests.landing.uk.os;
///**
// * On 2018 the page https://qa-englishlive.ef.com/en-gb/lp/os/learn-english-online-ef/?ctr=gb&pcode=AFFTRA2M
// * has a hard coded offer id so this test is not valid anymore ... Karim to check with paran if we still need this usage
// * http://jira-bos.englishtown.com/browse/SAND-2033
// *  1 – OS landing page flow.
// a. Go to http://www.englishtown.com/en-gb/lp/os/learn-english-online-02/?pcode=AFFTRA2M
// b. Fill up the form and go to checkout payment page.
// c. Check whether offer_id in et.state maps to the pcode in URL or not.
// d. Finish payment, check the first month payment amount matches to pcode in url or not.
// e. Check Price, and cookie et_s is only one and only one
// oupon Code Relates to Offer Id First Month Payment Amount
// EMEAGB19MTHLY 30582 GBP 19
// AFFTRA2M 30345 GBP 125
// */
//import com.englishlive.tests.checkout.newcheckout.core.simple.BaseFreeStyleCheckout;
//import com.englishtown.helpers.AssertHelper;
//import com.englishtown.helpers.WaitTool;
//import com.englishtown.pages.checkout.newcheckout.DynamicPaymentMemberPage;
//import com.englishtown.pages.checkout.newcheckout.PaymentThankyouPage;
//import com.englishtown.pages.landing.OSLandingPage;
//import com.englishtown.tests.checkout.common.core.NewCcBaseCheckoutFlowTest;
//import com.englishtown.tests.core.BaseTestHelper;
//import com.englishtown.tests.core.EfConstants;
//import org.apache.commons.lang.StringUtils;
//import org.openqa.selenium.By;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//import java.util.Map;
//import static org.hamcrest.Matchers.is;
//
//// todo Major refactoring
//// TODO form as changed .. test need to be moved out of BaseOSPageTEST to make it work
//
//public class Uk2OSPagePcodeGoesToCheckoutAndPayTest extends NewCcBaseCheckoutFlowTest { //BaseFreeStyleCheckout { //BaseOSPageTest {
//    private static final Logger logger = LoggerFactory.getLogger(Uk2OSPagePcodeGoesToCheckoutAndPayTest.class);
//
//    @Value("#{applicationPropertiesList['uk2.os.url.pcode']}")
//    private String osPageUrl;
//
//    @Value("#{applicationPropertiesList['checkout.member.en.en.url']}")
//    protected String currMemberPageUrl;
//
//    private String localizedTestPhoneNumber="0789546321";
//
//    protected DynamicPaymentMemberPage paymentPage;
//    protected PaymentThankyouPage thankyouPage;
//
//    private static final String LOCAL_OFFERID ="30345";
//    // DEPEND ON PCODE EMEAGB19MTHLY 30582 GBP 19   AFFTRA2M 30345 GBP 125
//    protected Map offer;
//
//    public Map getOffer() {
//        return offer = EfConstants.OFFER_30345;
//    }
//
//
//    @BeforeClass
//    protected void setupBeforeClass(){
//        setThreadSafeDriver();
//        formDataMap = EfConstants.defaultDataMapNoConfirmPassnewhouse;
//        submitBtn = ".formset-button .btn.btn-primary";
//
//        openUrl(getWebDriver(), osPageUrl);
//        enterFormData(formDataMap);
//        click(By.cssSelector(submitBtn));
//        //isSpecialCssSubmitButton = submitBtn;
//
//        password = "passpass";
//        //if(StringUtils.equalsIgnoreCase(getENVIRONMENT(), "qa")) {            isNewHouseEnroll = true;            isRunTestPhoneTextCheckPhoneTxtOnTy = false;        }
//        isStoreData = true;
//        isNewhouseCheckout = true;
//        isNewhousePayment=true;
//        isNewHouseEnroll=true;
//        paymentSubmitBtnCss = ".btn.btn-primary";
//        setLanguageAndMarket("en", "gb");
//        cancelSubscription = false;
//        phase1OfferPrice ="49";
//        //memberPageUrl = currMemberPageUrl;
//        //this.formDataMap   = EfConstants.ukMembersFormMap_new;
//        isClickTabId=false;
//        creditCardLinkText="";
//        //logger.info("setup url: "+memberPageUrl);
//        //this.openUrl(getWebDriver(), this.memberPageUrl, -1) ;
//    }
//
//    @Override
//    protected String getMemberPageUrl() {
//        memberPageUrl = currMemberPageUrl;
//        return memberPageUrl;
//    }
//    @Override
//    public void  enterMemberDetails(){
//        logger.info("Not needed to run for this test" );
//    }
//    @Override
//    public void  isCheckoutFlowTypeDefaultAtMemberPage(){
//        logger.info("Not needed to run for this test" );
//    }
//    @Override
//    public void  submitMemberForm(){
//        logger.info("Not needed to run for this test" );
//    }
//
//    @AfterClass
//    protected void teardownAfterClass(){
//        destroyDriver();
//    }
//
///*
//    @Test(priority = 5)
//    void validate_is_FirstLastNamePersisted(){
//        isFirstLastNamePersisted( getWebDriver(), scriptGetCCName, FULL_NAME);
//    }
//
//   //  Check weather order.offer_id in et.state maps to the pcode in URL or not. Note: each pcode has a maping offer id
//   //  EfConstant.OFFER_30345
//    @Test(dependsOnMethods = { "validate_is_FirstLastNamePersisted" })
//    void isOfferIdRelatedToPcode(){
//        logger.info(" Offer id should be :"+getOfferId()+ "- for pcode :"+getPcodeFromUrl());
//        isOfferIdRelatedToPcode("order.offer_id", getOfferId() ,true);
//    }
//    @Test(dependsOnMethods = { "validate_is_FirstLastNamePersisted" })
//    void isExpectedPcodeOnStateObjectTest(){
//        logger.info(" Expected PCode on order.couponCode :"+getPcodeFromUrl());
//        //sleep(35000);
//        isExpectedPcodeOnStateObject("order.couponCode", getPcodeFromUrl() ,true);
//    }
//    /***
//     *  Finish payment, check the first month payment amount matches to pcode in url or not.
//     */
//                            //TODO All the test below should be placed on a new Abstact class NewCheckoutBaseTest
//                            //     and the actual method implementation should be on BaseTest
///*    @Test(dependsOnMethods = { "isExpectedPcodeOnStateObjectTest" })
//    public void remove_pay_validation() {
//        remove_PaymentValidation();
//    }
//
//    @Test(dependsOnMethods = { "remove_pay_validation" })
//    public void enterPayFormData_and_submit() {
//        enter_PayFormDataAndSubmit();
//    }
//
//    @Test(dependsOnMethods = { "enterPayFormData_and_submit" })
//    public void check_ThankyouPage(){
//        sleep(5000);        //NewBaseCheckoutFlow.checkThankyouPage(thankyouPage, getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
//        BaseTestHelper.checkPaymentThankyouPage(thankyouPage, getWebDriver(),"thankyou", WaitTool.MED_WAIT_4_ELEMENT25);
//    }
//
//    @Test(dependsOnMethods = { "check_ThankyouPage" })
//       void isOfferCurrencyPersistedTest(){
//        logger.info(" isOfferCurrencyPersistedTest.... getOfferCurrency() :"+getOfferCurrency());
//        isOrderCurrencyRelatedToPcodeOnTY("order.phase0.currency",getOfferCurrency(), true);
//    }
//    @Test(dependsOnMethods = { "check_ThankyouPage" })
//    void isOfferPricePersistedTest(){
//        logger.info(" isOfferCurrencyPersistedTest....getOfferPrice() :"+getOfferPrice());
//        isOrderPriceRelatedToPcodeOnTY("order.phase0.price",getOfferPrice(), true);
//    }
//
//    // this test is redundand as the below test does the same
//    // SAND-2706  TestLInk ET-72:Only one Cookie named 'et_s' exist on Thank you page
////    @Test(dependsOnMethods = { "isOfferPricePersistedTest" })
////    void is_et_s_Cookie(){
////        logger.info("check isETsCookie....et_s ...!");
////        AssertHelper.assertThat("Cookie et_s is not there, null ....!", getCookie(getWebDriver(), "et_s") , is(notNullValue()));
////    }
//    //SAND-2706
//    @Test(dependsOnMethods = { "isOfferPricePersistedTest" })
//    void is_OnlyOne_et_s_Cookie(){
//        String allCookies = executeJSscript("var cookies=document.cookie; return cookies;", getWebDriver(), 25);
//        logger.info("check is_OnlyOne_et_s_Cookie ....et_s ...! allCookies "+allCookies);
//        AssertHelper.assertThat("Cookie et_s is not there or Cookie Name appears more than once ....!",splitStringAndFindHowManyMatches(allCookies, "et_s",";","=") , is(1));
//    }
//
//    //TODO remove as I have added to BAseTest helper
//    /**
//     * Split a string on splitChar, then split on '=' and see how many matches could you find for each first part split
//     * @param str
//     * @param match
//     *
//    public static int splitStringAndFindHowManyMatches(String str, String match, String firstSplitChar, String secondSplitChar){
//        boolean isDebug=true;
//        int matchCount=0;
//        String[] firstSplitList  = null;
//        String tmpStr = null;
//        if(str !=null ) {
//            if(str.contains(firstSplitChar)) {
//                firstSplitList = str.split(firstSplitChar);  // split on ';'
//                try {
//                    for(String part : firstSplitList){  //
//                        if(isDebug) logger.info(". First split part is : ["+part+"]");
//                        // split on = get first part, trim it , check it match 'match string'
//                        tmpStr = part.split(secondSplitChar)[0].trim();
//                        if(isDebug) logger.info(". Second Split tmpStr : ["+tmpStr+"] .. Check if is equal to ["+match+"]");
//                        if(StringUtils.equals(tmpStr, match)){
//                            matchCount++;
//                            if(isDebug) logger.info("Match found; matchCount is now : "+matchCount);
//                        }
//                        tmpStr = null;
//                        part   = null;
//                    }
//                }catch (Exception e) {
//                    e.printStackTrace();
//                    logger.error("splitStringAndFindHowManyMatches erros : " + e.getCause());
//                }
//            }
//        }else {
//            logger.error(" Cant split null string ...!");
//        }
//        return matchCount;
//    }
//
//
//    //**************************************
//    @Override
//    protected String getLocalizedTestPhoneNumber(){
//        return localizedTestPhoneNumber;
//    }
//
//    @Override
//    protected String getOfferPrice(){
//        return getOffer().get("price").toString();
//    }
//    @Override
//    protected String getOfferCurrency(){
//        return getOffer().get("currency").toString();
//    }
//    @Override
//    protected String getOfferPcode(){
//        return getOffer().get("pcode").toString();
//    }
//    @Override
//    protected String getOfferId(){
//        this.offerId=LOCAL_OFFERID;
//        return offerId;
//    }
//
//    @Override
//    public String getPcodeFromUrl(){
//        this.pcode = this.osPageUrl.split("=")[1];
//        return pcode;
//    }
//    @Override
//    protected OSLandingPage createPage() {
//        isMyPasswordSelector = false;
//        formLeadTypeValue = "os";
//        return new OSLandingPage(getWebDriver(), this.osPageUrl);
//    }*/
//
//}
//
//
