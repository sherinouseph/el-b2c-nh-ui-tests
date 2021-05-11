//package com.englishlive.tests.newhouse.apitest.testsuite.unit.archive.campusenrollment;
///**
// *
// *
// *
// */
//
//import com.englishtown.dataprovider.bin.StudentBean;
//import com.englishtown.enumpack.Channel;
//import com.englishtown.enumpack.TestCard;
//import com.englishtown.newhouse.apicore.BaseSchoolEnrollmentSpec;
//import com.englishtown.newhouse.apicore.BaseSchoolPatchAccount;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.testng.annotations.BeforeClass;
//
//
//public class CampusEnrollmentSpec extends BaseSchoolEnrollmentSpec { //} BaseSchoolPatchAccount {
//    public static final Logger logger = LoggerFactory.getLogger(CampusEnrollmentSpec.class);
//
//
//    @BeforeClass
//    protected void setupBeforeClass(){
//        logger.info("@ Before Class ...!");
//        isSchoolEnrolment = false;
//        isRunGetMemberAndHasEnrol = true;
//        studentBean = new StudentBean();
//        studentBean.setCountry("FR");
//        studentBean.setLang("FR");
//        studentBean.setOffer_id("32282");
//        studentBean.setChannel(Channel.ONLINE.getChannel());
//        studentBean.toString();
//        testCard = TestCard.VISA_QA;
//        //studentBean.print();
//        setupTestBeanDataAndSpec();
//    }
//
//
//}
//
