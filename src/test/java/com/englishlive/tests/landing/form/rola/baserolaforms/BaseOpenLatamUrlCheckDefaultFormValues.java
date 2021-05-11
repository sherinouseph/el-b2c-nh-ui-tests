//package com.englishlive.tests.landing.form.rola.baserolaforms;
///**
// * Open form and change country
// * URL updated to the country selected and country text field updated accordingly
// * if ctr is not in the list nor valid show select country
// *
// *
// // Latam Req 1 Country populated based on ctr value passed on url if ctr not found/exist then show select ctr
// // Latam Req 2 Dept shown accordingly with the first one selected by default
// // Latam Req 3 phone type preselected by default as mobile
// // Latam Req 4 input data above is retained [this might need new test .. think about it] [another test]
// // Latam Req 5 If crt=ar and dept selected then Ciudad-city field is shown
// // Latam Req 6 pink label displayed for all fields
// // Latam Req 7 Input mask for phone No. default values
// *
// */
//import com.englishtown.dataprovider.RolaDataProvider;
//import com.englishtown.dataprovider.bin.CountryBean;
//import org.apache.commons.lang.StringUtils;
//import org.openqa.selenium.By;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.testng.annotations.Test;
//
//import java.util.ArrayList;
//import java.util.List;
//
////TODO this test should be better using factory instead of data provider and split it in many small tests not all checks in one test
//
//public abstract class BaseOpenLatamUrlCheckDefaultFormValues extends BaseRolaFormValidation implements IRolaForm {
//    private static final Logger logger = LoggerFactory.getLogger(BaseOpenLatamUrlCheckDefaultFormValues.class);
//    protected String urlContains = "notInit";
//    private String currentTestUrl;
//
//    @Test(dataProvider = "rolaTopCountrieBean", dataProviderClass = RolaDataProvider.class)
//    protected void openUrlCheck_Country_DeptDefaultPoneAndPhoneMaskAndStateObjPageMarket(CountryBean countryBean) {
//        List<Error> errorList = new ArrayList();
//
//        try {
//            setThreadSafeDriver();
//            logger.info("Test Country Bean : " + countryBean.toString());
//            currentTestUrl = testStartUrl + "?ctr=" + countryBean.getTwoLetterCode(); //"http://qa-englishlive.ef.com/es-"+cCode+"/"; //
//
//            openUrl(getWebDriver(), currentTestUrl, -1);
//            sleep(1000);
//            //Latam Req 1 Counry populated based on ctr value passed on url
//            try {
//                checkSelectedCountry(countryBean.getName(), countryBean.getTwoLetterCode(), By.cssSelector(COUNTRY_CSS));
//            } catch (AssertionError ae) {
//                errorList.add(ae);
//            }
//            // check top phone number
//            try {
//                logger.info("Top Telephone No should be ["+countryBean.getPhoneNumber()+"]");
//                assertWebElementText( topPhoneNumberCss, countryBean.getPhoneNumber());
//            } catch (AssertionError ae) {
//                errorList.add(ae);
//            }
//            // Latam Req 2 Dept shown accordingly with the first one selected by default
//            try {
//                if (countryBean.isHasDept()) {
//                    logger.info("Check department field present with value...!");
//                    checkSelectElementValue(countryBean.getCapital(), By.cssSelector(DEPT_SELECT));
//                } else {
//                    logger.info("Check department field not there ...!");
//                    validateWebElementNotShown(By.cssSelector(DEPT_SELECT), FAIL_MSG_DEPT_SHOULD_NOT_SHOW, 7);
//                }
//            } catch (AssertionError ae) {
//                errorList.add(ae);
//            }
//            // Latam Req 3 phone type preselected by default as mobile
//            logger.info("Check Default phone Mobile selected ...!");
//            try {
//                checkSelectElementValue(DEFAULT_PHONE_TYPE_VALUE, By.cssSelector(PHONE_TYPE_SELECT_CSS));
//            } catch (AssertionError ae) {
//                errorList.add(ae);
//            }
//
//            // Latam Req 7 Input mask for phone No. default values
//            logger.info("Check Default Mobile mask is the expected one [{}]...!", countryBean.getDefaultMobilePhoneMask());
//            try {
//                if (!StringUtils.equals("na", countryBean.getDefaultMobilePhoneMask())) {
//                    clickOnPhoneTextFieldAndValidateDefaultValue(countryBean.getDefaultMobilePhoneMask());
//                } else logger.info("default mobile value is [{}] ", countryBean.getDefaultMobilePhoneMask(),
//                        " So default phone mask is not checked ...!");
//            } catch (AssertionError ae) {
//                errorList.add(ae);
//            }
//
//            logger.info("Check stateObject page.market is the expected one [{}]...!", countryBean.getTwoLetterCode());
//            try {
//                String ctr = countryBean.getTwoLetterCode();
//                if(StringUtils.equals(ctr, "xx") || StringUtils.equals(ctr, "anything")){
//                    logger.warn(" CTR is xx or anything so state object is not checked .... ");
//                }else {
//                    assertStateObjectElementValue("page.market", countryBean.getTwoLetterCode(), true);
//                }
//            } catch (AssertionError ae) {
//                errorList.add(ae);
//            }
//        } finally {
//            String longline  = "\n------------------------------------------------------------------";
//            String shortline = "\n-------------------------------------";
//            destroyDriver();
//            String errorMessageList = longline ;
//            if (errorList.isEmpty()) {
//                logger.info("NO errors on error list ...!");
//            } else {
//                for (Error err : errorList) {
//                    errorMessageList = errorMessageList+"\n\n"+err.getMessage()+shortline;         //logger.error(err.getMessage());
//                }
//                throw new AssertionError("There are errors on this run ; Number of errors >["+errorList.size()+"]\n"+errorMessageList);
//            }
//        }
//
//    }
//
//
//}
