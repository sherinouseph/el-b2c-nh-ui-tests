//package com.englishlive.tests.landing.sa;
///***
// * https://jira.eflabs.io/browse/SAND-4055
// *
// */
//import com.englishlive.tests.landing.form.BasePhoneMaskValidationTest;
//import com.englishtown.dataprovider.TelephoneNoDataProvider;
//import com.englishtown.dataprovider.bin.CountryBean;
//import com.englishtown.helpers.utils.TestUtil;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Factory;
//
//
//public class SaArabsPhoneValidationTest extends BasePhoneMaskValidationTest {
//    private static final Logger logger = LoggerFactory.getLogger(SaArabsPhoneValidationTest.class);
//    @Value("#{applicationPropertiesList['sa.oe.crm.sa2']}")
//    private String testUrl;
//
//
//    @Factory(dataProvider = "saTopCountrieBean", dataProviderClass = TelephoneNoDataProvider.class)
//    public SaArabsPhoneValidationTest(CountryBean countryBean) {
//        this.countryBean = countryBean;
//        this.countryBean.toString();
//    }
//
//    @BeforeClass
//    protected void setup() {
//        setThreadSafeDriver();
//        TestUtil.printMethodName(logger, 2);
//        testStartUrl = testUrl; // + "?ctr=" + countryBean.getTwoLetterCode();
//        logger.info("Test Country Bean : " + countryBean.toString());
//    }
//
//
//    @AfterClass
//    protected void testAfterClass(){
//        destroyDriver();
//    }
//
//
//}
