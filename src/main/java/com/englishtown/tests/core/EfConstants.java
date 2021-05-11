package com.englishtown.tests.core;
/**
 *
 * Date: 26/08/14
 * Constants values used by the test
 * e.g. Members form and payment form
 *
 */
import com.englishtown.helpers.utils.TestUtil;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;


public class EfConstants {
    private static final Logger logger = LoggerFactory.getLogger(EfConstants.class);
    public static AtomicLong alCurrTime;
    public static Long currTime;
    //public static String randomStrInt;
    public static final String TEST_MAIL_START_TOKEN = "auto_"; //TEST_MAIL_START_TOKEN+currTime+TEST_MAIL_endTOCKEN+"@qp1.org"
    public static final String TEST_MAIL_END_TOKEN   = "_xdelx";
    // urls
    public static String checkoutMemberUrlContains = "/member";

    // maintenace pages
    //br
    public static final Map<String, String> MAINTENANCE_BR = new LinkedHashMap<>();
    static {
        Long currNanoTime = System.nanoTime();
        MAINTENANCE_BR.put( "first_name", "fnMaintenace"+TestUtil.generateRandomString("R", 3));
        MAINTENANCE_BR.put( "email", TEST_MAIL_START_TOKEN+currNanoTime+TestUtil.generateRandomString("", 5)+TEST_MAIL_END_TOKEN+"@qp1.org");
        MAINTENANCE_BR.put( "telephone", "01234567898");
        MAINTENANCE_BR.put( "age", "selectMeSelectOpt&true&25-30");
    }
    public static final Map<String, String> MAINTENANCE_GB = new LinkedHashMap<>();
    static {
        Long currNanoTime = System.nanoTime();
        MAINTENANCE_GB.put( "first_name", "fnMaintenace"+TestUtil.generateRandomString("R", 3));
        MAINTENANCE_GB.put( "last_name", "lnMaintenace"+TestUtil.generateRandomString("R", 3));
        MAINTENANCE_GB.put( "email", TEST_MAIL_START_TOKEN+currNanoTime+TestUtil.generateRandomString("", 5)+TEST_MAIL_END_TOKEN+"@qp1.org");
        MAINTENANCE_GB.put( "telephone", "01234567898");
        MAINTENANCE_GB.put( "age", "selectMeSelectOpt&true&26-30");
    }
    /*******************************************************************************************************************
     *  ~DEFAULT form fName, sName, email, pass, englishemail
     ******************************************************************************************************************/
    public static Map<String, String> defaultDataMap = new LinkedHashMap<>();
    static { String randomStrInt = TestUtil.generateRandomStringNumber();
        Long currTime = System.nanoTime();
        defaultDataMap.put( "firstname", "defalutMichael");
        defaultDataMap.put( "lastname", "Platini");
        defaultDataMap.put( "email", TEST_MAIL_START_TOKEN+currTime+"_"+randomStrInt+"_"+TEST_MAIL_END_TOKEN+"@qp1.org");
        defaultDataMap.put( "telephone", "01234567898");
        defaultDataMap.put( "mypassword", BaseTestConfig.getPassword8());
        defaultDataMap.put( "confirmpassword", BaseTestConfig.getPassword8());
    }

    public static Map<String, String> defaultDataMapNoConfirmPass = new LinkedHashMap<>();
    static { String randomStrInt = TestUtil.generateRandomStringNumber();
        Long currTime = System.nanoTime();
        defaultDataMapNoConfirmPass.put( "firstname", "defalutMichael");
        defaultDataMapNoConfirmPass.put( "lastname", "Platini");
        defaultDataMapNoConfirmPass.put( "email", TEST_MAIL_START_TOKEN+currTime+"_"+randomStrInt+"_"+TEST_MAIL_END_TOKEN+"@qp1.org");
        defaultDataMapNoConfirmPass.put( "telephone", "01234567898");
        defaultDataMapNoConfirmPass.put( "mypassword", BaseTestConfig.getPassword8());
        defaultDataMapNoConfirmPass.put( "toc", "selectMeChk_true");
    }

    public static Map<String, String> defaultDataMapNoConfirmPassnewhouse = new LinkedHashMap<>();
    static { String randomStrInt = TestUtil.generateRandomStringNumber();
        Long currTime = System.nanoTime();
        defaultDataMapNoConfirmPassnewhouse.put( "firstname", "defalutMichael");
        defaultDataMapNoConfirmPassnewhouse.put( "lastname", "Platini");
        defaultDataMapNoConfirmPassnewhouse.put( "email", TEST_MAIL_START_TOKEN+currTime+"_"+randomStrInt+"_"+TEST_MAIL_END_TOKEN+"@qp1.org");
        defaultDataMapNoConfirmPassnewhouse.put( "telephone", "01234567898");
        defaultDataMapNoConfirmPassnewhouse.put( "password", BaseTestConfig.getPassword8());
        defaultDataMapNoConfirmPassnewhouse.put( "dynamicsubscribe", "selectMeChk_true");
    }

    public static Map<String, String> fNameLNameEmailPass = new LinkedHashMap<>();
    static {
        String randomStrInt = TestUtil.generateRandomStringNumber();
        Long currTime = System.nanoTime();
        fNameLNameEmailPass.put( "firstname", "defalutMichael");
        fNameLNameEmailPass.put( "lastname", "Platini");
        fNameLNameEmailPass.put( "email", TEST_MAIL_START_TOKEN+currTime+"_"+randomStrInt+"_"+TEST_MAIL_END_TOKEN+"@qp1.org");
        fNameLNameEmailPass.put( "mypassword", BaseTestConfig.getPassword8());
        fNameLNameEmailPass.put( "dynamicsubscribe", "selectMeChk_true");
    }

    public Map<String, String> meMapParallel = new LinkedHashMap<>();
    /*static {
        String randomStrInt = TestUtil.generateRandomStringNumber();
        Long currTime = System.nanoTime();
        meMapParallel.put( "email", TEST_MAIL_START_TOKEN+currTime+"_"+randomStrInt+"_"+TEST_MAIL_END_TOKEN+"@qp1.org");
    }*/

    /**
     * Update email on the map so is unique for concurrent thread
     *
     * @param updateEmailMap
     * @return
     * String randomStrInt = TestUtil.generateRandomStringNumber();
     * Long currTime = System.nanoTime();
     */
    public static synchronized Map updateMapEmail(Map updateEmailMap, Long currTime, String randomStrInt){
        Map testDataMap ;
        if(MapUtils.isEmpty(updateEmailMap)) {
            logger.error("Map is null or empty ...!");
            return MapUtils.EMPTY_MAP;
        } else {
            testDataMap = updateEmailMap ;

            if(updateEmailMap.containsKey("email")) {
                updateEmailMap.remove("email");
            }

            testDataMap.put("email", TEST_MAIL_START_TOKEN + currTime + "_" + randomStrInt + "_" + TEST_MAIL_END_TOKEN + "@qp1.org");
            logger.info("..testDataMap  (email) :"+ testDataMap.get("email"));
        }
        return testDataMap;
    }





    /*static {
        String randomStrInt = TestUtil.generateRandomStringNumber();
        Long currTime = System.nanoTime();
        meMapParallel.put( "email", TEST_MAIL_START_TOKEN+currTime+"_"+randomStrInt+"_"+TEST_MAIL_END_TOKEN+"@qp1.org");
    }*/


    public static final Map<String, String> form_os_default = new LinkedHashMap<>();
    static { String randomStrInt = TestUtil.generateRandomStringNumber();
        Long currTime = System.nanoTime();
        form_os_default.put( "firstname", "Michael");
        form_os_default.put( "lastname", "Platini");
        form_os_default.put( "email", TEST_MAIL_START_TOKEN+currTime+"_"+randomStrInt+"_"+TEST_MAIL_END_TOKEN+"@qp1.org");
        //
        form_os_default.put( "mypassword", BaseTestConfig.getPassword8());
        form_os_default.put( "englishemail", "selectMeChk_false");
    }
    public static final Map<String, String> form_FL_Name_email = new LinkedHashMap<>();
    static { String randomStrInt = TestUtil.generateRandomStringNumber();
        Long currTime = System.nanoTime();
        form_FL_Name_email.put( "firstname", "Michael");
        form_FL_Name_email.put( "lastname", "Platini");
        form_FL_Name_email.put( "email", TEST_MAIL_START_TOKEN+currTime+"_"+randomStrInt+"_"+TEST_MAIL_END_TOKEN+"@qp1.org");
    }
    public static final Map<String, String> form_mypass = new LinkedHashMap<>();
    static {
        form_mypass.put( "mypassword", BaseTestConfig.getPassword8());
    }
    //checkbox
    public static final Map<String, String> form_englishemail = new LinkedHashMap<>();
    static {
        form_englishemail.put( "englishemail", "selectMeChk_true");
    }
    /*******************************************************************************************************************
     *  uk
     ******************************************************************************************************************/
    public static final Map<String, String> OFFER_30345 = new HashMap<>();
    static {
        // EMEAGB19MTHLY 30582 GBP 19   AFFTRA2M 30345 GBP 125
        OFFER_30345.put("pcode"    ,"AFFTRA2M");
        OFFER_30345.put("offerId"  ,"30345");
        OFFER_30345.put("currency" ,"GBP");
        OFFER_30345.put("price"    ,"125");
    }
    public static final Map<String, String> OFFER_30582 = new HashMap<>();
    static {
        OFFER_30582.put("pcode"    ,"EMEAGB19MTHLY");
        OFFER_30582.put("offerId"  ,"30582");
        OFFER_30582.put("currency" ,"GBP");
        OFFER_30582.put("price"    ,"19");
    }
    // ----------------------------------------------------------------------------------------------------------------
    //Default offers for SalesPages, Landing Pages and CRM :
    // FRANCE
    //    Template
    //    public static final Map<String, String> OFFER_ID_ = new HashMap<>();
    //    static {
    //        OFFER_ID_.put("offerId"  ,"");
    //        OFFER_ID_.put("currency" ,"");
    //        OFFER_ID_.put("price"    ,"");
    //    }
    public static final Map<String, String> OFFER_ID_31330 = new HashMap<>();
    static {
        OFFER_ID_31330.put("offerId"  ,"31330");
        OFFER_ID_31330.put("currency" ,"eur");
        OFFER_ID_31330.put("price"    ,"79");
    }
    public static final Map<String, String> OFFER_ID_31331 = new HashMap<>();
    static {
        OFFER_ID_31331.put("offerId"  ,"31331");
        OFFER_ID_31331.put("currency" ,"eur");
        OFFER_ID_31331.put("price"    ,"109");
    }
    public static final Map<String, String> OFFER_ID_31332 = new HashMap<>();
    static {
        OFFER_ID_31332.put("offerId"  ,"31332");
        OFFER_ID_31332.put("currency" ,"eur");
        OFFER_ID_31332.put("price"    ,"59");
    }
    //crm
    public static final Map<String, String> OFFER_ID_31340 = new HashMap<>();
    static {
        OFFER_ID_31340.put("offerId"  ,"31340");
        OFFER_ID_31340.put("currency" ,"eur");
        OFFER_ID_31340.put("price"    ,"79");
    }
    public static final Map<String, String> OFFER_ID_31338 = new HashMap<>();
    static {
        OFFER_ID_31338.put("offerId"  ,"31338");
        OFFER_ID_31338.put("currency" ,"eur");
        OFFER_ID_31338.put("price"    ,"59");
    }
    public static final Map<String, String> OFFER_ID_31355 = new HashMap<>();
    static {
        OFFER_ID_31355.put("offerId"  ,"31355");
        OFFER_ID_31355.put("currency" ,"eur");
        OFFER_ID_31355.put("price"    ,"99");
    }
    //--------------------------------------------------------------------------------------

    // sa
    public static final Map<String, String> SA_WWS_LP = new LinkedHashMap<>();
    static {
        SA_WWS_LP.put( "country",    "selectMeSelectOpt&true&lb");
    }

    public static final Map<String, String> BR_MEMBER_MAP = new LinkedHashMap<>();
    static {
        setCurrTime(System.currentTimeMillis());
        BR_MEMBER_MAP.put("firstname", "testing");
        BR_MEMBER_MAP.put("lastname", "AutoLastName");
        //BR_MEMBER_MAP.put("email", TEST_MAIL_START_TOKEN + currTime + TEST_MAIL_END_TOKEN + "@qp1.org");
        BR_MEMBER_MAP.put("password",        BaseTestConfig.getPassword8());
        BR_MEMBER_MAP.put("confirmpassword", BaseTestConfig.getPassword8());
        BR_MEMBER_MAP.put("telephone", "00000000000");
    }

    public static final Map<String, String> esMembersFormMap_new = new LinkedHashMap<>();
    static { String randomStrInt = TestUtil.generateRandomStringNumber();
        Long currTime = System.nanoTime();
        esMembersFormMap_new.put( "firstname", "testing");
        esMembersFormMap_new.put( "lastname", "AutoLastName");
        //ukMembersFormMap_new.put( "email", TEST_MAIL_START_TOKEN+currTime+"_"+randomStrInt+"_"+TEST_MAIL_END_TOKEN+"@qp1.org");
        esMembersFormMap_new.put( "password", BaseTestConfig.getPassword8());  //        deMembersFormMap.put( "confirmPassword", "pass"); //        deMembersFormMap.put( "Telephone", "0755654565");  //        deMembersFormMap.put( "MemberCountry", "Germany");
        esMembersFormMap_new.put( "telephone", "0485689476874");
        esMembersFormMap_new.put( "dynamicsubscribe", "selectMeChk_true");  // selected by default

    }

    public static final Map<String, String> ukMembersFormMap_new = new LinkedHashMap<>();
    static { String randomStrInt = TestUtil.generateRandomStringNumber();
        Long currTime = System.nanoTime();
        ukMembersFormMap_new.put( "firstname", "testing");
        ukMembersFormMap_new.put( "lastname", "AutoLastName");
        //ukMembersFormMap_new.put( "email", TEST_MAIL_START_TOKEN+currTime+"_"+randomStrInt+"_"+TEST_MAIL_END_TOKEN+"@qp1.org");
        ukMembersFormMap_new.put( "password", BaseTestConfig.getPassword8());  //        deMembersFormMap.put( "confirmPassword", "pass"); //        deMembersFormMap.put( "Telephone", "0755654565");  //        deMembersFormMap.put( "MemberCountry", "Germany");
        ukMembersFormMap_new.put( "dynamicsubscribe", "selectMeChk_true");  // not selected by default
    }

    public static final Map<String, String> ukMembersFormMap = new LinkedHashMap<>();
    static { String randomStrInt = TestUtil.generateRandomStringNumber();
        Long currTime = System.nanoTime();
        ukMembersFormMap.put( "firstname", "testing");
        ukMembersFormMap.put( "lastname", "AutoLastName");
        ukMembersFormMap.put( "password", "password");
    }

    public static Map<String, String> MEMBER_FORM_FLP = new LinkedHashMap<>();
    static {
        String fName = TestUtil.generateRandomString("BtoC", 7);
        String lName = TestUtil.generateRandomString("BtoC", 6);
        MEMBER_FORM_FLP.put( "firstname", fName);
        MEMBER_FORM_FLP.put( "lastname", lName);
        MEMBER_FORM_FLP.put( "password", "password");
        MEMBER_FORM_FLP.put( "toc", "selectMeChk_true");
    }

    public static final Map<String, String> deMembersMap = new LinkedHashMap<>();
    static {
        String randomStrInt = TestUtil.generateRandomStringNumber();
        Long currTime = System.nanoTime();
        deMembersMap.put( "firstname", "testing");
        deMembersMap.put( "lastname", "AutoLastName");
        deMembersMap.put( "password", BaseTestConfig.getPassword8());
        deMembersMap.put( "SubscribeToEmailEnglish", "selectMeChk_false");
        deMembersMap.put( "toc", "selectMeChk_true");
    }

    public static final Map<String, String> deMembersWithPhoneMap = new LinkedHashMap<>();
    static {
        String randomStrInt = TestUtil.generateRandomStringNumber();
        Long currTime = System.nanoTime();
        deMembersWithPhoneMap.put( "firstname", "testing");
        deMembersWithPhoneMap.put( "lastname", "AutoLastName");
        //deMembersWithPhoneMap.put( "email", TEST_MAIL_START_TOKEN+currTime+randomStrInt+TEST_MAIL_END_TOKEN+"@qp1.org");
        deMembersWithPhoneMap.put( "telephone", "0755654565");
        deMembersWithPhoneMap.put( "password", BaseTestConfig.getPassword8());
        deMembersWithPhoneMap.put( "SubscribeToEmailEnglish", "selectMeChk_false");
        deMembersWithPhoneMap.put( "toc", "selectMeChk_true");
    }

    public static final Map<String, String> membersFormNoEmail = new LinkedHashMap<>();
    static {

        membersFormNoEmail.put( "firstname", "testing");
        membersFormNoEmail.put( "lastname", "AutoLastName");       // ukMembersFormMap_new.put( "email", "test12345et"+currTime+"@qp1.org");
        membersFormNoEmail.put( "password", "password");  //        deMembersFormMap.put( "confirmPassword", "pass"); //        deMembersFormMap.put( "Telephone", "0755654565");  //        deMembersFormMap.put( "MemberCountry", "Germany");
        membersFormNoEmail.put( "SubscribeToEmailEnglish", "selectMeChk_false");
        membersFormNoEmail.put( "toc", "selectMeChk_true");
    }
    public static final Map<String, String> ukMembersFormMap_blank = new LinkedHashMap<>();
    static {
        ukMembersFormMap_blank.put( "firstname", " ");
        ukMembersFormMap_blank.put( "lastname", " ");
        ukMembersFormMap_blank.put( "email", " ");
        ukMembersFormMap_blank.put( "password", " ");
    }

    public static final Map<String, String> ukMembersFormMap_new_withPhone = new LinkedHashMap<>();
    static { String randomStrInt = TestUtil.generateRandomStringNumber();
        Long currTime = System.nanoTime();
        ukMembersFormMap_new_withPhone.put("firstname", "testing");
        ukMembersFormMap_new_withPhone.put( "lastname", "AutoLastName");
        //ukMembersFormMap_new_withPhone.put( "email", TEST_MAIL_START_TOKEN+currTime+"_"+randomStrInt+"_"+TEST_MAIL_END_TOKEN+"@qp1.org");
        ukMembersFormMap_new_withPhone.put( "password", BaseTestConfig.getPassword8());
        ukMembersFormMap_new_withPhone.put( "telephone", "087596321");
        ukMembersFormMap_new_withPhone.put( "toc", "selectMeChk_true");  // selected by default
        ukMembersFormMap_new_withPhone.put( "SubscribeToEmailEnglish", "selectMeChk_false");
    }

    public static final Map<String, String> ukMembersPayMap_new = new LinkedHashMap<>();
    static {
        ukMembersPayMap_new.put( "CreditCardNumber",     "4222222222222222");
        ukMembersPayMap_new.put( "ExpirationMonth",      "selectMeSelectOpt&true&5");
        ukMembersPayMap_new.put( "ExpirationYear",       "selectMeSelectOpt&true&2024"); //TODO get the year dynamically
        ukMembersPayMap_new.put( "CardVerificationCode", "123");
        ukMembersPayMap_new.put( "CCAuthorized",         "selectMeChk_true");
    }

    public static final Map<String, String> CC_FULLNAME_BLANKSPACE = new HashMap<>();
    static {
        CC_FULLNAME_BLANKSPACE.put( "CreditCardName",  " ");
    }
    //E.G "NIKOLMARKU"
    public static final Map<String, String> CC_FULLNAME_NO_SPACE = new HashMap<>();
    static {
        CC_FULLNAME_NO_SPACE.put( "CreditCardName",  "NIKOLMARKU");
    }
    public static final Map<String, String> JA_PAYMAP_JCB = new LinkedHashMap<>();
    static {                // ukMembersPayMap_new.put( "[value=Visa]",         "selectMeRadio_true");
        JA_PAYMAP_JCB.put( "CreditCardNumber",     "3566111111111113");
        JA_PAYMAP_JCB.put("ExpirationMonth", "selectMeSelectOpt&true&5");
        JA_PAYMAP_JCB.put( "ExpirationYear",       "selectMeSelectOpt&true&2018"); //TODO get the year dynamically
        JA_PAYMAP_JCB.put( "CardVerificationCode", "123");
        JA_PAYMAP_JCB.put( "CCAuthorized",         "selectMeChk_true");
    }
    public static final Map<String, String> ukEEFormMap = new LinkedHashMap<>();
    static { String randomStrInt = TestUtil.generateRandomStringNumber();
        Long currTime = System.nanoTime();
        ukEEFormMap.put( "firstname", "AutoTest Pele Ziko");
        ukEEFormMap.put( "email",      TEST_MAIL_START_TOKEN+currTime+"_"+randomStrInt+"_"+TEST_MAIL_END_TOKEN+"@qp1.org");
        ukEEFormMap.put( "telephone",  "0478987456");
//        ukEEFormMap.put( "emailenglish", "selectMeChk_true");
    }

    /// usa pay page with address
    public static final Map<String, String> payPageWithAddressMap = new LinkedHashMap<>();
    static {
        payPageWithAddressMap.put( "CreditCardNumber",     "4222222222222222");
        payPageWithAddressMap.put("ExpirationMonth", "selectMeSelectOpt&true&5");
        payPageWithAddressMap.put( "ExpirationYear",       "selectMeSelectOpt&true&2019"); //TODO get the year dynamically
        payPageWithAddressMap.put( "CardVerificationCode", "123");
        payPageWithAddressMap.put( "CCAuthorized",         "selectMeChk_true");
        payPageWithAddressMap.put( "Address1",   "SMALLSYS");
        payPageWithAddressMap.put( "Address2",   "INC 795 E");
        payPageWithAddressMap.put( "State",      "DRAGRAM");
        payPageWithAddressMap.put( "City",       "TUCSON");
        payPageWithAddressMap.put( "PostalCode", "AZ 85705");
    }

    // worldpay usa pay page    TEST CARDS
    public static final Map<String, String> WORLDPAY_US_AMEX = new LinkedHashMap<>();
    static {
        WORLDPAY_US_AMEX.put("cardNumber",              "343434343434343");
        WORLDPAY_US_AMEX.put("cardholderName",          "Nikol test");
        WORLDPAY_US_AMEX.put("expiryDate.expiryMonth",  "selectMeSelectOpt&true&11");
        WORLDPAY_US_AMEX.put("expiryDate.expiryYear",   "selectMeSelectOpt&true&2021");
        WORLDPAY_US_AMEX.put("securityCode",            "6666");
    }

    /**
     Worldpay payment failed, please contact our service personnel with order reference number:1151259
     */
    public static final Map<String, String> WORLDPAY_US_AMEX_NEGATIVE = new LinkedHashMap<>();
    static {
        WORLDPAY_US_AMEX_NEGATIVE.put("cardNumber",              "4111111111111111");
        WORLDPAY_US_AMEX_NEGATIVE.put("cardholderName",          "REFUSED");
        WORLDPAY_US_AMEX_NEGATIVE.put("expiryDate.expiryMonth",  "selectMeSelectOpt&true&11");
        WORLDPAY_US_AMEX_NEGATIVE.put("expiryDate.expiryYear",   "selectMeSelectOpt&true&2021");
        WORLDPAY_US_AMEX_NEGATIVE.put("securityCode",            "666");
    }

    /*******************************************************************************************************************
     *  Germany
     ******************************************************************************************************************/
    public static final Map<String, String> deMembersFormMap = new LinkedHashMap<>();
    static { String randomStrInt = TestUtil.generateRandomStringNumber();
        Long currTime = System.nanoTime();
        deMembersFormMap.put("firstname", "TAMMY");
        deMembersFormMap.put("lastname", "OCONNOR");
        deMembersFormMap.put( "email", TEST_MAIL_START_TOKEN+currTime+"_"+randomStrInt+"_"+TEST_MAIL_END_TOKEN+"@qp1.org");
        deMembersFormMap.put( "password", BaseTestConfig.getPassword8());
        deMembersFormMap.put( "toc", "selectMeChk_true");  // selected by default
    }

    public static final Map<String, String> DE_MEMBER_FORM = new LinkedHashMap<>();
    static {
        DE_MEMBER_FORM.put("firstname", "TAMMY");
        DE_MEMBER_FORM.put("lastname", "OCONNOR");
        DE_MEMBER_FORM.put( "password", BaseTestConfig.getPassword8());
        DE_MEMBER_FORM.put( "SubscribeToEmailEnglish", "selectMeChk_false");
        DE_MEMBER_FORM.put( "toc", "selectMeChk_true");     }


    public static final Map<String, String> deOsFormMap = new LinkedHashMap<>();
    static { String randomStrInt = TestUtil.generateRandomStringNumber();
        Long currTime = System.nanoTime();
        deOsFormMap.put("firstname", "AutoFirstName");
        deOsFormMap.put( "lastname",     "AutoLastNameTest");
        deOsFormMap.put("email", TEST_MAIL_START_TOKEN+currTime+"_"+randomStrInt+"_"+TEST_MAIL_END_TOKEN+"@qp1.org");
        deOsFormMap.put( "telephone",    "085635435334");    //no validation
        deOsFormMap.put( "mypassword",   BaseTestConfig.getPassword8());
        deOsFormMap.put( "englishemail", "selectMeChk_true");           //submit   //#osformsubmit
    }
    public static final Map<String, String> deEfOsFormMap = new LinkedHashMap<>();
    static { String randomStrInt = TestUtil.generateRandomStringNumber();
        Long currTime = System.nanoTime();
        deEfOsFormMap.put("firstname", "AutoFirstName");
        deEfOsFormMap.put( "lastname",     "AutoLastNameTest");
        deEfOsFormMap.put("email", TEST_MAIL_START_TOKEN+currTime+"_"+randomStrInt+"_"+TEST_MAIL_END_TOKEN+"@qp1.org");
        deEfOsFormMap.put( "telephone",    "085635435334");
        deEfOsFormMap.put( "mypassword",   BaseTestConfig.getPassword8());
        deEfOsFormMap.put( "toc", "selectMeChk_true");
    }
    public static final Map<String, String> deOsFormMap_empty = new LinkedHashMap<>();
    static {
        Long currTime = System.nanoTime();
        deOsFormMap_empty.put( "firstname",    "");
        deOsFormMap_empty.put( "lastname",     "");
        deOsFormMap_empty.put( "email",        "");
        deOsFormMap_empty.put( "telephone",    "");    //no validation
        deOsFormMap_empty.put( "mypassword",   "");       // deOsFormMap_empty.put( "englishemail", "selectMeChk_");
    }
    public static final Map<String, String> deOsFormMap_noPass = new LinkedHashMap<>();
    static { String randomStrInt = TestUtil.generateRandomStringNumber();
        Long currTime = System.nanoTime();
        deOsFormMap_noPass.put( "firstname",    "AutoFirstName");
        deOsFormMap_noPass.put( "lastname",     "AutoLastNameTest");
        deOsFormMap_noPass.put( "email",        TEST_MAIL_START_TOKEN+currTime+"_"+randomStrInt+"_"+TEST_MAIL_END_TOKEN+"@qp1.org");
        deOsFormMap_noPass.put( "telephone",    "085635435334");    //no validation
        deOsFormMap_noPass.put( "mypassword",   "");
        deOsFormMap_noPass.put( "toc", "selectMeChk_true");
    }
    public static final Map<String, String> deOeFormMap = new LinkedHashMap<>();
    static { String randomStrInt = TestUtil.generateRandomStringNumber();
        Long currTime = System.nanoTime();
        deOeFormMap.put("first_name", "AutoTest");
        deOeFormMap.put( "last_name",  "AutoLastNameTest");
        deOeFormMap.put( "email",      TEST_MAIL_START_TOKEN+currTime+"_"+randomStrInt+"_"+TEST_MAIL_END_TOKEN+"@qp1.org");
        deOeFormMap.put( "telephone",  "085635435334");
        deOeFormMap.put( "age",        "selectMeSelectOpt&true&21-25");
        // deOeFormMap.put( "calltime",   "selectMeSelectOpt&true&10am1pm");
        //deOeFormMap.put( "emailenglish", "selectMeChk_true");
    }
    public static final Map<String, String> trOsFormMap = new LinkedHashMap<>();
    static { String randomStrInt = TestUtil.generateRandomStringNumber();
        Long currTime = System.nanoTime();
        trOsFormMap.put( "firstname",    "AutoFirstName");
        trOsFormMap.put( "lastname",     "AutoLastNameTest");
        trOsFormMap.put( "telephone",    "085635435334");    //no validation
        trOsFormMap.put( "password",   "passpass");

    }

    public static final Map<String, String> trOeToSFFormMap = new LinkedHashMap<>();
    static { String randomStrInt = TestUtil.generateRandomStringNumber();
        Long currTime = System.nanoTime();
        trOeToSFFormMap.put("first_name", "AutoTest");
        trOeToSFFormMap.put( "last_name",  "AutoLastNameTest");
        trOeToSFFormMap.put( "telephone",  "085635435334");
        trOeToSFFormMap.put( "age",        "selectMeSelectOpt&true&21-25");

    }

    public static final Map<String, String> CRM_DE_OEMAP = new LinkedHashMap<>();
    static {
        CRM_DE_OEMAP.put("first_name", "AutoTest");
        CRM_DE_OEMAP.put( "last_name",  "AutoLastNameTest");
        CRM_DE_OEMAP.put( "telephone",  "085635435334");
        CRM_DE_OEMAP.put( "mypassword",  "password");
        CRM_DE_OEMAP.put( "age",        "selectMeSelectOpt&true&21-25");
    }

    public static final Map<String, String> esOeFormMap = new LinkedHashMap<>();
    static { String randomStrInt = TestUtil.generateRandomStringNumber();
        Long currTime = System.nanoTime();
        esOeFormMap.put("first_name", "AutoTest");
        esOeFormMap.put( "last_name",  "AutoLastNameTest");
       // esOeFormMap.put( "email",      TEST_MAIL_START_TOKEN+currTime+"_"+randomStrInt+"_"+TEST_MAIL_END_TOKEN+"@qp1.org");
        esOeFormMap.put( "telephone",  "085635435334");
        esOeFormMap.put( "age",        "selectMeSelectOpt&true&18-25");
        esOeFormMap.put( "emailenglish", "selectMeChk_true");
        esOeFormMap.put( "toc", "selectMeChk_true");
    }

    public static final Map<String, String> atOeFormMap = new LinkedHashMap<>();
    static { String randomStrInt = TestUtil.generateRandomStringNumber();
        Long currTime = System.nanoTime();
        atOeFormMap.put("first_name", "AutoTest");
        atOeFormMap.put( "last_name",  "AutoLastNameTest");
        atOeFormMap.put( "email",      TEST_MAIL_START_TOKEN+currTime+"_"+randomStrInt+"_"+TEST_MAIL_END_TOKEN+"@qp1.org");
        atOeFormMap.put( "telephone",  "085635435334");
       // atOeFormMap.put( "age",        "selectMeSelectOpt&true&18-25");
        atOeFormMap.put( "emailenglish", "selectMeChk_true");
        atOeFormMap.put( "toc", "selectMeChk_true");
    }
    public static final Map<String, String> omOeFormMap = new LinkedHashMap<>();
    static { String randomStrInt = TestUtil.generateRandomStringNumber();
        Long currTime = System.nanoTime();
        omOeFormMap.put("first_name", "AutoTest");
        omOeFormMap.put( "last_name",  "AutoLastNameTest");
        omOeFormMap.put( "email",      TEST_MAIL_START_TOKEN+currTime+"_"+randomStrInt+"_"+TEST_MAIL_END_TOKEN+"@qp1.org");
        omOeFormMap.put( "emailenglish", "selectMeChk_true");
    }
    public static final Map<String, String> pfOeFormMap = new LinkedHashMap<>();
    static { String randomStrInt = TestUtil.generateRandomStringNumber();
        Long currTime = System.nanoTime();
        pfOeFormMap.put("first_name", "AutoTest");
        pfOeFormMap.put( "last_name",  "AutoLastNameTest");
        pfOeFormMap.put( "email",      TEST_MAIL_START_TOKEN+currTime+"_"+randomStrInt+"_"+TEST_MAIL_END_TOKEN+"@qp1.org");
        pfOeFormMap.put( "age",        "selectMeSelectOpt&true&21-25");
        pfOeFormMap.put( "telephone",  "085635435334");
        // pfOeFormMap.put( "emailenglish", "selectMeChk_false");
    }
    // content target with surname
    public static final Map<String, String> deEEFormMap = new LinkedHashMap<>();
    static { String randomStrInt = TestUtil.generateRandomStringNumber();
        Long currTime = System.nanoTime();
        deEEFormMap.put( "first_name", "AutoTest Klisman");
        //deEEFormMap.put( "last_name", "lastName Klism");
        deEEFormMap.put( "email",      TEST_MAIL_START_TOKEN+currTime+"_"+randomStrInt+"_"+TEST_MAIL_END_TOKEN+"@qp1.org");
        deEEFormMap.put( "telephone",  "0478987456");
        deEEFormMap.put( "emailenglish", "selectMeChk_true");
        deEEFormMap.put( "toc", "selectMeChk_true");
    }
    public static final Map<String, String> LP_UPSELL = new LinkedHashMap<>();
    static { String randomStrInt = TestUtil.generateRandomStringNumber();
        Long currTime = System.nanoTime();
        LP_UPSELL.put( "first_name",    "lpUpsellAutoFirstName");
        LP_UPSELL.put( "email",        TEST_MAIL_START_TOKEN+currTime+"_"+randomStrInt+"_"+TEST_MAIL_END_TOKEN+"@qp1.org");
        LP_UPSELL.put( "telephone",    "085635435334");
        LP_UPSELL.put( "emailenglish", "selectMeChk_true");//not selected by default
        LP_UPSELL.put( "toc", "selectMeChk_true");
    }
    public static final Map<String, String> deOTFormMap = new LinkedHashMap<>();
    static { String randomStrInt = TestUtil.generateRandomStringNumber();
        Long currTime = System.nanoTime();
        deOTFormMap.put( "first_name", "AutoKlisman");
        deOTFormMap.put( "last_name",  "AutoLastMateus");
        deOTFormMap.put( "email",      TEST_MAIL_START_TOKEN+currTime+"_"+randomStrInt+"_"+TEST_MAIL_END_TOKEN+"@qp1.org");
        deOTFormMap.put( "telephone",  "045675654");
        // select break the form /  use keyboard to enter this ... for chrome and IE NOT safari
        deOTFormMap.put( "age",        "selectMeSelectOpt&true&21-25");
        deOTFormMap.put( "emailenglish", "selectMeChk_true");
        deOTFormMap.put( "toc", "selectMeChk_true");
    }
    // DE DD
    public static final Map<String, String> deDdPayFormMap = new LinkedHashMap<>();
    static {
        // new fields
        deDdPayFormMap.put("dcInfo.AccountName", "AccNameNiko");
        deDdPayFormMap.put("dcInfo.CustomerAddress", "Test AddressDE");
        deDdPayFormMap.put("dcInfo.CustomerCity", "HldesainTestCity");
        deDdPayFormMap.put("dcInfo.CustomerPostCode", "CustPostCode");
        deDdPayFormMap.put("dcInfo.BankCode", "PBNKDEFF100");
        deDdPayFormMap.put( "dcInfo.AccountNumber",  "DE75100100101111111116");
        deDdPayFormMap.put( "toc",      "selectMeChk_true");
        //
        /*deDdPayFormMap.put("dcInfo.BankCode", "PSSTFRPPCNE");
        deDdPayFormMap.put( "dcInfo.AccountNumber",  "FR7610011000200012345678934");
        deDdPayFormMap.put( "toc",      "selectMeChk_true");
        */
        /**
         <efs1:AccountName>TAMMY OCONNOR</efs1:AccountName>
         <efs1:AccountNumber>FR7610011000200012345678934</efs1:AccountNumber>
         <efs1:BankCode>PSSTFRPPCNE</efs1:BankCode>
         * */
    }

    public static final Map<String, String> CRM_MAGICFORM_MAP = new LinkedHashMap<>();
    static { String randomStrInt = TestUtil.generateRandomStringNumber();
        Long currTime = System.nanoTime();
        CRM_MAGICFORM_MAP.put( "firstname", "crmtesting");
        CRM_MAGICFORM_MAP.put( "lastname", "AutoLastName");
        //CRM_MAGICFORM_MAP.put( "email", TEST_MAIL_START_TOKEN+currTime+"_"+randomStrInt+"_"+TEST_MAIL_END_TOKEN+"@qp1.org");
        CRM_MAGICFORM_MAP.put( "telephone", "08756235894");
        //CRM_MAGICFORM_MAP.put( "age", "selectMeSelectOpt&true&21-25");
        CRM_MAGICFORM_MAP.put( "mypassword", "password");
    }

    public static final Map<String, String> TW_CRM_OE_MAP = new LinkedHashMap<>();
    static { String randomStrInt = TestUtil.generateRandomStringNumber();
        Long currTime = System.nanoTime();
        TW_CRM_OE_MAP.put( "first_name", "TWFName");
        TW_CRM_OE_MAP.put( "last_name", "TWLName");
        //TW_CRM_OE_MAP.put( "email", TEST_MAIL_START_TOKEN+currTime+"_"+randomStrInt+"_"+TEST_MAIL_END_TOKEN+"@qp1.org");
        TW_CRM_OE_MAP.put( "city", "selectMeSelectOpt&true&tw_hc");
        TW_CRM_OE_MAP.put( "telephone", "08756235894");
        TW_CRM_OE_MAP.put( "age", "selectMeSelectOpt&true&26-30");
        //CRM_MAGICFORM_MAP.put( "mypassword", "password");
    }

    public static final Map<String, String> CRM_MONIT_OE = new LinkedHashMap<>();
    static { String randomStrInt = TestUtil.generateRandomStringNumber();
        Long currTime = System.nanoTime();
        CRM_MONIT_OE.put( "first_name", "TWFName");
        CRM_MONIT_OE.put( "last_name", "TWLName");

        CRM_MONIT_OE.put( "telephone", "08756235894");
        CRM_MONIT_OE.put( "age", "selectMeSelectOpt&true&26-30");

    }


    public static final Map<String, String> MASTERCARD_TEST = new LinkedHashMap<>();
    static {
        MASTERCARD_TEST.put( "CreditCardNumber",     "2221001234123450");
        MASTERCARD_TEST.put("ExpirationMonth", "selectMeSelectOpt&true&5");
        MASTERCARD_TEST.put( "ExpirationYear",       "selectMeSelectOpt&true&2022");
        MASTERCARD_TEST.put( "CardVerificationCode", "123");
        MASTERCARD_TEST.put( "CCAuthorized",         "selectMeChk_true");
    }


    public static final Map<String, String> DE_REFERRAL_MAP = new LinkedHashMap<>();
    static { String randomStrInt = TestUtil.generateRandomStringNumber();
        Long currTime = System.nanoTime();
       // DE_REFERRAL_MAP.put( "name",    "DEreferral");
        DE_REFERRAL_MAP.put( ".message",       TEST_MAIL_START_TOKEN+currTime+"_"+TEST_MAIL_END_TOKEN+"@qp1.org");
    }
    public static final Map<String, String> REFERRAL_MAP = new LinkedHashMap<>();
    static { String randomStrInt = TestUtil.generateRandomStringNumber();
        Long currTime = System.nanoTime();
        REFERRAL_MAP.put( "name",    "referral");
        REFERRAL_MAP.put( "address",  TEST_MAIL_START_TOKEN+currTime+"_"+randomStrInt+"_"+TEST_MAIL_END_TOKEN+"@qp1.org");
    }

    public static final Map<String, String> DE_SB_MAP = new LinkedHashMap<>();
    static { String randomStrInt = TestUtil.generateRandomStringNumber();
        Long currTime = System.nanoTime();
        DE_SB_MAP.put( "first_name",    "deFNnikolSB");
        DE_SB_MAP.put( "last_name",     "deFNnikolSB");
        //DE_SB_MAP.put( "email",     TEST_MAIL_START_TOKEN+currTime+"_"+randomStrInt+"_"+TEST_MAIL_END_TOKEN+"@qp1.org");
        DE_SB_MAP.put( "telephone", "0789456123");
        DE_SB_MAP.put( "NumberOfStaff",         "selectMeSelectOpt&true&100");
        DE_SB_MAP.put( "emailenglish", "selectMeChk_true");
        DE_SB_MAP.put( "toc", "selectMeChk_true");
    }
    public static final Map<String, String> UK_SB_MAP = new LinkedHashMap<>();
    static { String randomStrInt = TestUtil.generateRandomStringNumber();
        Long currTime = System.nanoTime();
        UK_SB_MAP.put( "firstname",    "ukFNnikolSB");
        UK_SB_MAP.put( "lastname",     "ukFNnikolSB");
       //UK_SB_MAP.put( "email",     TEST_MAIL_START_TOKEN+currTime+"_"+randomStrInt+"_"+TEST_MAIL_END_TOKEN+"@qp1.org");
        UK_SB_MAP.put( "password", BaseTestConfig.getPassword8());
    }
    /*******************************************************************************************************************
     *  Italy
     ******************************************************************************************************************/
    public static final Map<String, String> itOsFormMap = new LinkedHashMap<>();
    static { String randomStrInt = TestUtil.generateRandomStringNumber();
        Long currTime = System.nanoTime();
        itOsFormMap.put( "firstname",    "AutoTestCiro");
        itOsFormMap.put( "lastname",     "AutoLastNameTest");
        itOsFormMap.put( "email",        TEST_MAIL_START_TOKEN+currTime+"_"+randomStrInt+"_"+TEST_MAIL_END_TOKEN+"@qp1.org");
        itOsFormMap.put( "telephone",    "");
        itOsFormMap.put( "mypassword",   BaseTestConfig.getPassword8());
        itOsFormMap.put( "englishemail", "selectMeChk_true");
    }
    public static final Map<String, String> itOsFormMap_noFname = new LinkedHashMap<>();
    static { String randomStrInt = TestUtil.generateRandomStringNumber();
        Long currTime = System.nanoTime();
        itOsFormMap_noFname.put("firstname", "");
        itOsFormMap_noFname.put( "lastname",     "AutoLastNameTest");
        itOsFormMap_noFname.put( "email",        TEST_MAIL_START_TOKEN+currTime+"_"+randomStrInt+"_"+TEST_MAIL_END_TOKEN+"@qp1.org");
        itOsFormMap_noFname.put( "telephone",    "323212312312");
        itOsFormMap_noFname.put( "mypassword",   BaseTestConfig.getPassword8());
        itOsFormMap_noFname.put( "englishemail", "selectMeChk_true");
    }

     public static final Map<String, String> CRM_GB = new LinkedHashMap<>();
     static { String randomStrInt = TestUtil.generateRandomStringNumber();
         Long currTime = System.nanoTime();
        CRM_GB.put( "firstname", "CrmFromGB");
        CRM_GB.put( "lastname",  "AutoLNameTest");
        CRM_GB.put( "telephone", "323212312312");
        CRM_GB.put( "password",  "password");
    }

    public static final Map<String, String> CRM_IT = new LinkedHashMap<>();
    static { String randomStrInt = TestUtil.generateRandomStringNumber();
        Long currTime = System.nanoTime();
        CRM_IT.put( "firstname", "CrmFromIT");
        CRM_IT.put( "lastname",     "AutoLastNameTest");
        CRM_IT.put( "telephone",    "323212312312");
        CRM_IT.put( "mypassword",   "password");
    }
    public static final Map<String, String> CRM_DE = new LinkedHashMap<>();
    static { String randomStrInt = TestUtil.generateRandomStringNumber();
        Long currTime = System.nanoTime();
        CRM_DE.put( "firstname",   "CrmFromIT");
        CRM_DE.put( "lastname",    "AutoLastNameTest");
        CRM_DE.put( "telephone",   "323212312312");
        CRM_DE.put( "mypassword",  "password");
        CRM_DE.put( "toc",         "selectMeChk_true");
    }
    public static final Map<String, String> CRM_SA = new LinkedHashMap<>();
    static { String randomStrInt = TestUtil.generateRandomStringNumber();
        Long currTime = System.nanoTime();
        CRM_SA.put( "firstname", "CrmFromIT");
        CRM_SA.put( "lastname",   "AutoLastNameTest");
        CRM_SA.put( "mypassword", "password");
    }
    public static final Map<String, String> CRM_JP = new LinkedHashMap<>();
    static { String randomStrInt = TestUtil.generateRandomStringNumber();
        Long currTime = System.nanoTime();
        CRM_JP.put( "firstname", "CrmFromIT");
        CRM_JP.put( "lastname",     "AutoLastNameTest");
        //email
        CRM_JP.put( "mypassword",   "password");
    }

    public static final Map<String, String> CRM_TR = new LinkedHashMap<>();
    static { String randomStrInt = TestUtil.generateRandomStringNumber();
        CRM_TR.put( "firstname", "CrmFromIT");
        CRM_TR.put( "lastname",     "AutoLastNameTest");
        //email
        CRM_TR.put( "telephone",   "12345678678");
        CRM_TR.put( "mypassword",   "password");
    }

    // Fluency Calculator OE form
    public static final Map<String, String> itFCoeFormMap = new LinkedHashMap<>();
    static { String randomStrInt = TestUtil.generateRandomStringNumber();
        Long currTime = System.nanoTime();
        itFCoeFormMap.put( "first_name",  "CiroOEfc");
        itFCoeFormMap.put( "last_name",   "Palacio");
        itFCoeFormMap.put( "email",       TEST_MAIL_START_TOKEN+currTime+"_"+randomStrInt+"_"+TEST_MAIL_END_TOKEN+"@qp1.org");
        itFCoeFormMap.put( "telephone",   "323212312");
        itFCoeFormMap.put( "age",         "selectMeSelectOpt&true&21-25");
        itFCoeFormMap.put( "toc",         "selectMeChk_true");
        itFCoeFormMap.put( "dynamicsubscribe","selectMeChk_true");//emailenglish
    }

    public static final Map<String, String> CRM_IT_OEMAP = new LinkedHashMap<>();
    static {
        CRM_IT_OEMAP.put( "first_name",  "CiroOEfc");
        CRM_IT_OEMAP.put( "last_name",   "Palacio");
        CRM_IT_OEMAP.put( "telephone",   "323212312");
        CRM_IT_OEMAP.put( "age",         "selectMeSelectOpt&true&21-25");
    }

    public static final Map<String, String> itOTFormMap = new LinkedHashMap<>();
    static { String randomStrInt = TestUtil.generateRandomStringNumber();
        Long currTime = System.nanoTime();
        itOTFormMap.put( "first_name", "AutoKlisman");
        itOTFormMap.put( "last_name",  "AutoLastMateus");
        itOTFormMap.put( "email",      TEST_MAIL_START_TOKEN+currTime+"_"+randomStrInt+"_"+TEST_MAIL_END_TOKEN+"@qp1.org");
        itOTFormMap.put( "telephone",  "04567856655665654");
        // add age 27 March 23017
        itOTFormMap.put( "age",         "selectMeSelectOpt&true&21-25");
        itOTFormMap.put( "toc","selectMeChk_true");
    }

    //
    public static final Map<String, String> CRM_OE_ES_MAP = new LinkedHashMap<>();
    static { String randomStrInt = TestUtil.generateRandomStringNumber();
        Long currTime = System.nanoTime();
        CRM_OE_ES_MAP.put( "first_name",  "CrmiroOEfc");
        CRM_OE_ES_MAP.put( "last_name",   "Palacio");
       // CRM_OE_ES_MAP.put( "email",       TEST_MAIL_START_TOKEN+currTime+"_"+randomStrInt+"_"+TEST_MAIL_END_TOKEN+"@qp1.org");
        CRM_OE_ES_MAP.put( "telephone",   "323212312");
        CRM_OE_ES_MAP.put( "age",         "selectMeSelectOpt&true&26-40");
        CRM_OE_ES_MAP.put( "Postcode","nIKOL");
    }

    /*******************************************************************************************************************
     *  France
     ******************************************************************************************************************/
    public static final Map<String, String> FR_OFFER_30494 = new HashMap<>();
    static {
        FR_OFFER_30494.put("pcode"    ,"FRTOEFLTOEIC");
        FR_OFFER_30494.put("offerId"  ,"30494");
        FR_OFFER_30494.put("currency" ,"eur");
        FR_OFFER_30494.put("price"    ,"1");
        FR_OFFER_30494.put("copi"    ,"");

    }
    public static final Map<String, String> FR_OFFER_30888 = new HashMap<>();
    static {
        FR_OFFER_30888.put("pcode"    ,"FRTOEIC30DYS");
        FR_OFFER_30888.put("offerId"  ,"30888");
        FR_OFFER_30888.put("currency" ,"eur");
        FR_OFFER_30888.put("price"    ,"1");
        FR_OFFER_30888.put("copi"    ,"");
    }
    public static final Map<String, String> FR_OFFER_29951 = new HashMap<>();
    static {
        FR_OFFER_29951.put("pcode"    ,"FRMTH10GL");
        FR_OFFER_29951.put("offerId"  ,"29951");
        FR_OFFER_29951.put("currency" ,"eur");
        FR_OFFER_29951.put("price"    ,"1");
        FR_OFFER_29951.put("copi"    ,"");
    }
    public static final Map<String, String> frOsFormMap = new LinkedHashMap<>();
    static { String randomStrInt = TestUtil.generateRandomStringNumber();
        Long currTime = System.nanoTime();
        frOsFormMap.put( "firstname", "AutoFristName");
        frOsFormMap.put( "lastname", "AutoLastName");
        frOsFormMap.put( "email", TEST_MAIL_START_TOKEN+currTime+"_"+randomStrInt+"_"+TEST_MAIL_END_TOKEN+"@qp1.org");
        frOsFormMap.put( "password", BaseTestConfig.getPassword8());  //        deMembersFormMap.put( "confirmPassword", "pass"); //        deMembersFormMap.put( "Telephone", "0755654565");  //        deMembersFormMap.put( "MemberCountry", "Germany");        //ukMembersFormMap_new.put( "SubscribeToEmailEnglish", "selectMeChk_false");  // selected by default
    }

    public static final Map<String, String> frEEFormMap = new LinkedHashMap<>();
    static { String randomStrInt = TestUtil.generateRandomStringNumber();
        Long currTime = System.nanoTime();
        frEEFormMap.put( "first_name",  "FautoNik");
        frEEFormMap.put( "email",       TEST_MAIL_START_TOKEN+currTime+"_"+randomStrInt+"_"+TEST_MAIL_END_TOKEN+"@qp1.org");
        frEEFormMap.put( "telephone",   "0722334454");        //        frEEFormMap.put( "country",     "selectMeSelectOpt&true&fr");        //frOEFormMap.put( "emailenglish","selectMeChk_false");//selectMeChk_true
        frEEFormMap.put( "dynamicsubscribe", "selectMeChk_true");
    }
    public static final Map<String, String> frEEFormMap1 = new LinkedHashMap<>();
    static { String randomStrInt = TestUtil.generateRandomStringNumber();
        Long currTime = System.nanoTime();
        frEEFormMap1.put("first_name", "FautoNik");
        frEEFormMap1.put("email", TEST_MAIL_START_TOKEN + currTime + TEST_MAIL_END_TOKEN + "@qp1.org");
    }

    public static final Map<String, String> frEE1FormMap = new LinkedHashMap<>();
    static { String randomStrInt = TestUtil.generateRandomStringNumber();
        Long currTime = System.nanoTime();
        frEE1FormMap.put( "first_name", "AutoFristNamePlatini");
        frEE1FormMap.put("last_name", "LastNameDogba");
        frEE1FormMap.put( "email",       TEST_MAIL_START_TOKEN+currTime+"_"+randomStrInt+"_"+TEST_MAIL_END_TOKEN+"@qp1.org");
        frEE1FormMap.put( "telephone",   "0155662211");
        frEE1FormMap.put( "age",         "selectMeSelectOpt&true&26-30" );
    }
    public static final Map<String, String> frOEFormMap = new LinkedHashMap<>();
    static { String randomStrInt = TestUtil.generateRandomStringNumber();
        Long currTime = System.nanoTime();
        frOEFormMap.put( "first_name",  "AutoFristNamePlatini");
        frOEFormMap.put( "last_name",   "LastNameTest");
        frOEFormMap.put( "email",       TEST_MAIL_START_TOKEN+currTime+"_"+randomStrInt+"_"+TEST_MAIL_END_TOKEN+"@qp1.org");
        frOEFormMap.put( "telephone",   "0155662211");
        //frOEFormMap.put( "age",         "selectMeSelectOpt&true&26-30" );
        // frOEFormMap.put( "calltime",    "selectMeSelectOpt&true&10am1pm");
        // frOEFormMap.put( "country",     "selectMeSelectOpt&true&fr");// 05 Jun 2015 commment out
        //frOEFormMap.put( "emailenglish","selectMeChk_false");//selectMeChk_true
    }

    public static final Map<String, String> CRM_FR_OEMAP = new LinkedHashMap<>();
    static {
        CRM_FR_OEMAP.put( "first_name",  "AutoFristNamePlatini");
        CRM_FR_OEMAP.put( "last_name",   "LastNameTest");
        CRM_FR_OEMAP.put( "telephone",   "0155662211");
        CRM_FR_OEMAP.put( "age",         "selectMeSelectOpt&true&26-30" );
    }

    public static final Map<String, String> frOEToTestFormMap = new LinkedHashMap<>();
    static { String randomStrInt = TestUtil.generateRandomStringNumber();
        Long currTime = System.nanoTime();
        frOEToTestFormMap.put( "first_name",  "AutoFristNamePlatini");
        frOEToTestFormMap.put( "last_name",   "LastNameTest");
        frOEToTestFormMap.put( "email",       TEST_MAIL_START_TOKEN+currTime+"_"+randomStrInt+"_"+TEST_MAIL_END_TOKEN+"@qp1.org");
        frOEToTestFormMap.put( "telephone",   "0155662211");
        frOEToTestFormMap.put( "age",         "selectMeSelectOpt&true&26-30" );
    }
    //# free consultation
    public static final Map<String, String> twOEFormMap = new LinkedHashMap<>();
    static { String randomStrInt = TestUtil.generateRandomStringNumber();
        Long currTime = System.nanoTime();
        twOEFormMap.put( "first_name",  "AutoFristNamePlatini");
        twOEFormMap.put( "last_name",   "LastNameTest");
        twOEFormMap.put( "email",       TEST_MAIL_START_TOKEN+currTime+"_"+randomStrInt+"_"+TEST_MAIL_END_TOKEN+"@qp1.org");
        twOEFormMap.put( "telephone",   "0155662211");
        twOEFormMap.put( "age",         "selectMeSelectOpt&true&26-30" );
        twOEFormMap.put( "emailenglish","selectMeChk_true");
    }
    // BR
    public static final Map<String, String> brFreeConsultation = new LinkedHashMap<>();
    static { String randomStrInt = TestUtil.generateRandomStringNumber();
        Long currTime = System.nanoTime();
        brFreeConsultation.put( "first_name",  "AutoFristNamePlatini");
        brFreeConsultation.put( "email",       TEST_MAIL_START_TOKEN+currTime+"_"+randomStrInt+"_"+TEST_MAIL_END_TOKEN+"@qp1.org");
        brFreeConsultation.put( "telephone",   "1556622112");
        brFreeConsultation.put( "age",         "selectMeSelectOpt&true&25-30" );
        brFreeConsultation.put( "emailenglish","selectMeChk_true");
    }

    public static final Map<String, String> twOE1FormMap = new LinkedHashMap<>();
    static { String randomStrInt = TestUtil.generateRandomStringNumber();
        Long currTime = System.nanoTime();
        twOE1FormMap.put( "first_name",  "AutoFristNamePlatini");
        twOE1FormMap.put( "last_name",   "LastNameTest");
        twOE1FormMap.put( "email",       TEST_MAIL_START_TOKEN+currTime+"_"+randomStrInt+"_"+TEST_MAIL_END_TOKEN+"@qp1.org");
        twOE1FormMap.put( "telephone",   "0255662211");
        twOE1FormMap.put( "age",         "selectMeSelectOpt&true&26-30" );
        twOE1FormMap.put( "city",         "selectMeSelectOpt&true&tw_hc&3" ); //新竹
    }
    //
    public static final Map<String, String> twOE1FormMapMobileCss = new LinkedHashMap<>();
    static { String randomStrInt = TestUtil.generateRandomStringNumber();
        Long currTime = System.nanoTime();
        twOE1FormMapMobileCss.put( "#mobile [name='first_name']",  "AutoFristNamePlatini");
        twOE1FormMapMobileCss.put( "#mobile [name='last_name']",   "LastNameTest");
        twOE1FormMapMobileCss.put( "#mobile [name='email']",       TEST_MAIL_START_TOKEN+currTime+"_"+randomStrInt+"_"+TEST_MAIL_END_TOKEN+"@qp1.org");
        twOE1FormMapMobileCss.put( "#mobile [name='telephone']",   "0255662211");
        twOE1FormMapMobileCss.put( "#mobile [name='age']",         "selectMeSelectOpt&true&26-30" );
        twOE1FormMapMobileCss.put( "#mobile [name='city']",         "selectMeSelectOpt&true&tw_hc&3" ); //新竹
    }

    public static final Map<String, String> twOE1FormMapDesktopCss = new LinkedHashMap<>();
    static { String randomStrInt = TestUtil.generateRandomStringNumber();
        Long currTime = System.nanoTime();
        twOE1FormMapDesktopCss.put( ".tw_zh_lp_oe_cnn-2016-07-01_jcr-content_footerPar_spacer_spacercontent_columnscontrol_column0_spacer_spacercontent_spacer-0 [name='first_name']",  "AutoFristNamePlatini");
        twOE1FormMapDesktopCss.put( ".tw_zh_lp_oe_cnn-2016-07-01_jcr-content_footerPar_spacer_spacercontent_columnscontrol_column0_spacer_spacercontent_spacer-0 [name='last_name']",   "LastNameTest");
        twOE1FormMapDesktopCss.put( ".tw_zh_lp_oe_cnn-2016-07-01_jcr-content_footerPar_spacer_spacercontent_columnscontrol_column0_spacer_spacercontent_spacer-0 [name='email']",       TEST_MAIL_START_TOKEN+currTime+"_"+randomStrInt+"_"+TEST_MAIL_END_TOKEN+"@qp1.org");
        twOE1FormMapDesktopCss.put( ".tw_zh_lp_oe_cnn-2016-07-01_jcr-content_footerPar_spacer_spacercontent_columnscontrol_column0_spacer_spacercontent_spacer-0 [name='telephone']",   "0255662211");
        twOE1FormMapDesktopCss.put( ".tw_zh_lp_oe_cnn-2016-07-01_jcr-content_footerPar_spacer_spacercontent_columnscontrol_column0_spacer_spacercontent_spacer-0 [name='age']",         "selectMeSelectOpt&true&26-30" );
        twOE1FormMapDesktopCss.put( ".tw_zh_lp_oe_cnn-2016-07-01_jcr-content_footerPar_spacer_spacercontent_columnscontrol_column0_spacer_spacercontent_spacer-0 [name='city']",         "selectMeSelectOpt&true&tw_hc&3" ); //新竹
    }

    // 13 to 17 age
    public static final Map<String, String> frOEFormMap13to17 = new LinkedHashMap<>();
    static { String randomStrInt = TestUtil.generateRandomStringNumber();
        Long currTime = System.nanoTime();
        frOEFormMap13to17.put( "first_name",  "AutoFristNamePlatini");
        frOEFormMap13to17.put( "last_name",   "LastNameTest");
        frOEFormMap13to17.put( "email",       TEST_MAIL_START_TOKEN+currTime+"_"+randomStrInt+"_"+TEST_MAIL_END_TOKEN+"@qp1.org");
        frOEFormMap13to17.put( "telephone",   "0155662211");
        frOEFormMap13to17.put( "age",         "selectMeSelectOpt&true&13-17" );
    }
    //<13
    public static final Map<String, String> frOEFormMapUnder13 = new LinkedHashMap<>();
    static { String randomStrInt = TestUtil.generateRandomStringNumber();
        Long currTime = System.nanoTime();
        frOEFormMapUnder13.put( "first_name",  "AutoFristNamePlatini");
        frOEFormMapUnder13.put( "last_name",   "LastNameTest");
        frOEFormMapUnder13.put( "email",       TEST_MAIL_START_TOKEN+currTime+"_"+randomStrInt+"_"+TEST_MAIL_END_TOKEN+"@qp1.org");
        frOEFormMapUnder13.put( "telephone",   "0155662211");
        frOEFormMapUnder13.put( "age",         "selectMeSelectOpt&true&<13" );
    }
    // Pay pal
    public static final Map<String, String> payPalFr = new LinkedHashMap<>();
    static {
       // payPalFr.put( "login_email",          "nikol.marku-buyer@ef.com"); // "cjd0659-buyer@gmail.com");
        payPalFr.put( "login_password",       "Ko12345678mi#!");           //12345678
        payPalFr.put( "rememberMe", "selectMeChk_true");//private_device
    }
    //id login_email    login_password privateDeviceCheckbox   submitLogin
    public static final Map<String, String> payPalJP = new LinkedHashMap<>();
    static {
        payPalJP.put( "login_email",           "cjd0659-buyer@gmail.com");
        payPalJP.put( "login_password",        "12345678");
        payPalJP.put( "privateDeviceCheckbox", "selectMeChk_true");
    }
    public static final Map<String, String> frOTFormMap = new LinkedHashMap<>();
    static { String randomStrInt = TestUtil.generateRandomStringNumber();
        Long currTime = System.nanoTime();
        frOTFormMap.put( "first_name", "AutoKlisman");
        frOTFormMap.put( "last_name",  "AutoLastMateus");
        frOTFormMap.put( "email",      TEST_MAIL_START_TOKEN+currTime+"_"+randomStrInt+"_"+TEST_MAIL_END_TOKEN+"@qp1.org");
        frOTFormMap.put( "telephone",  "04567856655665654");
        //added age 27 March 2017
        frOTFormMap.put( "age",        "selectMeSelectOpt&true&21-25");
        frOTFormMap.put( "toc", "selectMeChk_true");
    }

    public static final Map<String, String> FR_FREE_PL_CSS = new LinkedHashMap<>();
    static { String randomStrInt = TestUtil.generateRandomStringNumber();
        Long currTime = System.nanoTime();
        String firstCssPart = "[name=";
        String lastCssPart = "]";
        //FR_FREE_PL_CSS.put(firstCssPart + "calltime"            +lastCssPart, "selectMeSelectOpt&true&10am1pm");
        FR_FREE_PL_CSS.put("input"+firstCssPart + "first_name"          +lastCssPart, "MichailFN" );
        FR_FREE_PL_CSS.put("input"+firstCssPart + "last_name"           +lastCssPart, "PlatiniLN" );
        FR_FREE_PL_CSS.put("input"+firstCssPart + "email"               +lastCssPart, TEST_MAIL_START_TOKEN+"-FreePl-"+currTime+"_"+randomStrInt+"_"+TEST_MAIL_END_TOKEN+"@qp1.org");
        FR_FREE_PL_CSS.put("input"+firstCssPart + "telephone"           +lastCssPart,  "0988656565");
        //FR_FREE_PL_CSS.put(firstCssPart + "EnglishLevel"        +lastCssPart,  "selectMeSelectOpt&true&Advanced");
        FR_FREE_PL_CSS.put(firstCssPart + "studyMotivation"     +lastCssPart, "selectMeSelectOpt&true&Travel");
        //FR_FREE_PL_CSS.put(firstCssPart + "emailenglish"        +lastCssPart, "selectMeChk_false");
        FR_FREE_PL_CSS.put("input"+firstCssPart + "dynamicsubscribe"          +lastCssPart, "selectMeChk_true" );
    }
    public static final Map<String, String> FR_FREE_PL_CSS_NO_TOC = new LinkedHashMap<>();
    static { String randomStrInt = TestUtil.generateRandomStringNumber();
        Long currTime = System.nanoTime();
        String firstCssPart = "[name=";
        String lastCssPart = "]";
        FR_FREE_PL_CSS_NO_TOC.put("input"+firstCssPart + "first_name"          +lastCssPart, "MichailFN" );
        FR_FREE_PL_CSS_NO_TOC.put("input"+firstCssPart + "last_name"           +lastCssPart, "PlatiniLN" );
        FR_FREE_PL_CSS_NO_TOC.put("input"+firstCssPart + "email"               +lastCssPart, TEST_MAIL_START_TOKEN+"-FreePl-"+currTime+"_"+randomStrInt+"_"+TEST_MAIL_END_TOKEN+"@qp1.org");
        FR_FREE_PL_CSS_NO_TOC.put("input"+firstCssPart + "telephone"           +lastCssPart,  "0988656565");
        FR_FREE_PL_CSS_NO_TOC.put(firstCssPart + "studyMotivation"     +lastCssPart, "selectMeSelectOpt&true&Travel");

    }


    /*******************************************************************************************************************
     *  Mexico
     ******************************************************************************************************************/
    public static final Map<String, String> mxOSFormMap = new LinkedHashMap<>();
    static { String randomStrInt = TestUtil.generateRandomStringNumber();
        Long currTime = System.nanoTime();
        mxOSFormMap.put( "firstname", "AutoTestCiroMx");
        mxOSFormMap.put( "lastname",  "AutoLastNameTest");
        mxOSFormMap.put( "email",      TEST_MAIL_START_TOKEN+currTime+"_"+randomStrInt+"_"+TEST_MAIL_END_TOKEN+"@qp1.org");
        mxOSFormMap.put( "mypassword", BaseTestConfig.getPassword8());
        mxOSFormMap.put( "confirmpassword", BaseTestConfig.getPassword8());
        //mxOSFormMap.put( "telephone",  "4492270000");
        mxOSFormMap.put( "englishemail", "selectMeChk_false");  // selected by default
        mxOSFormMap.put( "toc", "selectMeChk_true");
    }
    public static final Map<String, String> mxOSFormMap_onlyAge = new LinkedHashMap<>();
    static {
        mxOSFormMap_onlyAge.put("age", "selectMeSelectOpt&true&26-30");
    }

    public static final Map<String, String> mxOEFormMap = new LinkedHashMap<>();
    static { String randomStrInt = TestUtil.generateRandomStringNumber();
        Long currTime = System.nanoTime();
        mxOEFormMap.put( "first_name", "AutoTestCiroMx");
        mxOEFormMap.put( "last_name",  "AutoLastNameTest");
        mxOEFormMap.put( "email",      TEST_MAIL_START_TOKEN+currTime+"_"+randomStrInt+"_"+TEST_MAIL_END_TOKEN+"@qp1.org");     //  mxOEFormMap.put( "telephone",  "1234656856");     //        mxOEFormMap.put( "age",        "selectMeSelectOpt&true&21-25"); //"13-17");
        mxOEFormMap.put( "country",    "selectMeSelectOpt&false_mx");    //<option value="mx"> Mexico            // mxOEFormMap.put( "englishemail", "selectMeChk_true");
    } //phoneType
    public static final Map<String, String> mxOEFormMapWithPhoneType = new LinkedHashMap<>();
    static { String randomStrInt = TestUtil.generateRandomStringNumber();
        Long currTime = System.nanoTime();
        mxOEFormMapWithPhoneType.put( "first_name", "AutoTestCiroMx");
        mxOEFormMapWithPhoneType.put( "last_name",  "AutoLastNameTest");
        mxOEFormMapWithPhoneType.put("email", TEST_MAIL_START_TOKEN+currTime+"_"+randomStrInt+"_"+TEST_MAIL_END_TOKEN+"@qp1.org");     //  mxOEFormMap.put( "telephone",  "1234656856");     //        mxOEFormMap.put( "age",        "selectMeSelectOpt&true&21-25"); //"13-17");
        mxOEFormMapWithPhoneType.put("phone-type", "selectMeSelectOpt&true&Mobile"); //Mobile Home Office   <option value="Mobile"> Móvil </option>
//        mxOEFormMapWithPhoneType.put( "telephone",  "4492270000");
        mxOEFormMapWithPhoneType.put( "age",  "selectMeSelectOpt&true&26-30");
        //mxOEFormMapWithPhoneType.put( "country",    "selectMeSelectOpt&false_mx");
        mxOEFormMapWithPhoneType.put( "emailenglish", "selectMeChk_false");
    }

    public static final Map<String, String> MX_POPUP_CSS = new LinkedHashMap<>();
    static { String randomStrInt = TestUtil.generateRandomStringNumber();
        String firstCssPart = ".popup-offer-and-form-content [name=";
        String lastCssPart = "]";
        Long currTime = System.nanoTime();
        MX_POPUP_CSS.put(firstCssPart + "first_name"      +lastCssPart, "AutoTestCiroMx");
        MX_POPUP_CSS.put(firstCssPart + "last_name"       +lastCssPart,  "AutoLastNameTest");
        MX_POPUP_CSS.put(firstCssPart + "email"           +lastCssPart, TEST_MAIL_START_TOKEN+currTime+"_"+randomStrInt+"_"+TEST_MAIL_END_TOKEN+"@qp1.org");     //  mxOEFormMap.put( "telephone",  "1234656856");     //        mxOEFormMap.put( "age",        "selectMeSelectOpt&true&21-25"); //"13-17");
        MX_POPUP_CSS.put(firstCssPart + "telephone-type"  +lastCssPart, "selectMeSelectOpt&true&Mobile"); //Mobile Home Office   <option value="Mobile"> Móvil </option>
        MX_POPUP_CSS.put(firstCssPart + "telephone"       +lastCssPart,  "4492270000");
        MX_POPUP_CSS.put(firstCssPart + "age"             +lastCssPart,  "selectMeSelectOpt&true&26-30");
        MX_POPUP_CSS.put(firstCssPart + "emailenglish"    +lastCssPart, "selectMeChk_false");
    }

    public static final Map<String, String> mxOEFormMapWithPhone = new LinkedHashMap<>();
    static { String randomStrInt = TestUtil.generateRandomStringNumber();
        Long currTime = System.nanoTime();
        mxOEFormMapWithPhone.put( "first_name", "AutoTestCiroMx");
        mxOEFormMapWithPhone.put( "last_name",  "AutoLastNameTest");
        mxOEFormMapWithPhone.put("email", TEST_MAIL_START_TOKEN+currTime+"_"+randomStrInt+"_"+TEST_MAIL_END_TOKEN+"@qp1.org");     //  mxOEFormMap.put( "telephone",  "1234656856");     //        mxOEFormMap.put( "age",        "selectMeSelectOpt&true&21-25"); //"13-17");
        mxOEFormMapWithPhone.put("telephone-type", "selectMeSelectOpt&true&mobile"); //telephone-type Mobile Home Office   <option value="Mobile"> Móvil </option>
        mxOEFormMapWithPhone.put( "telephone",  "4492270000");
        mxOEFormMapWithPhone.put( "age",  "selectMeSelectOpt&true&26-30");
        mxOEFormMapWithPhone.put( "emailenglish", "selectMeChk_false");
    }

    public static final Map<String, String> mxEEFormMap = new LinkedHashMap<>();
    static { String randomStrInt = TestUtil.generateRandomStringNumber();
        Long currTime = System.nanoTime();
        mxEEFormMap.put("first_name", "AutoTestCiroMx");
        mxEEFormMap.put( "last_name",  "AutoLastNameTest");
        mxEEFormMap.put( "email",      TEST_MAIL_START_TOKEN+currTime+"_"+randomStrInt+"_"+TEST_MAIL_END_TOKEN+"@qp1.org");
        mxEEFormMap.put( "phone-type",  "selectMeSelectOpt&true&Mobile"); //Mobile Home Office   <option value="Mobile"> Móvil </option>
        mxEEFormMap.put( "telephone",  "4492270000");
        // mxEEFormMap.put( "country",    "selectMeSelectOpt&false&mx");
        mxEEFormMap.put( "age",  "selectMeSelectOpt&true&26-30");
        mxEEFormMap.put( "emailenglish", "selectMeChk_true");
        //<option value="mx"> Mexico  mxOEFormMap.put( "englishemail", "selectMeChk_true");
    }

    public static final Map<String, String> CRM_MX_EEFormMap = new LinkedHashMap<>();
    static { String randomStrInt = TestUtil.generateRandomStringNumber();
        Long currTime = System.nanoTime();
        CRM_MX_EEFormMap.put( "country",    "selectMeSelectOpt&true&mx");
        CRM_MX_EEFormMap.put("first_name", "AutoTestCiroMx");
        CRM_MX_EEFormMap.put( "last_name",  "AutoLastNameTest");
        //CRM_MX_EEFormMap.put( "email",      TEST_MAIL_START_TOKEN+currTime+"_"+randomStrInt+"_"+TEST_MAIL_END_TOKEN+"@qp1.org");
       // CRM_MX_EEFormMap.put( "phone-type",  "selectMeSelectOpt&true&Mobile");
        CRM_MX_EEFormMap.put( "telephone",  "4492270000");
        CRM_MX_EEFormMap.put( "age",  "selectMeSelectOpt&true&26-30");

    }
    public static final Map<String, String> mxEEFormMap_noPhone = new LinkedHashMap<>();
    static { String randomStrInt = TestUtil.generateRandomStringNumber();
        Long currTime = System.nanoTime();
        mxEEFormMap_noPhone.put("first_name", "AutoTestCiroMx");
        mxEEFormMap_noPhone.put( "last_name",  "AutoLastNameTest");
        mxEEFormMap_noPhone.put( "email",      TEST_MAIL_START_TOKEN+currTime+"_"+randomStrInt+"_"+TEST_MAIL_END_TOKEN+"@qp1.org");
        mxEEFormMap_noPhone.put( "phone-type",  "selectMeSelectOpt&true&Mobile"); //Mobile Home Office   <option value="Mobile"> Móvil </option>
        mxEEFormMap_noPhone.put( "country",    "selectMeSelectOpt&false&mx");
        mxEEFormMap_noPhone.put( "age",  "selectMeSelectOpt&true&26-30");
        mxEEFormMap_noPhone.put( "emailenglish", "selectMeChk_true");
        //<option value="mx"> Mexico  mxOEFormMap.put( "englishemail", "selectMeChk_true");
    }
    public static final Map<String, String> MX_CRM = new LinkedHashMap<>();
    static { String randomStrInt = TestUtil.generateRandomStringNumber();
        Long currTime = System.nanoTime();
        MX_CRM.put("country",    "selectMeSelectOpt&true&mx");
        MX_CRM.put("firstname", "AutoTestCiroMx");
        MX_CRM.put("lastname",  "AutoLastNameTest");
        //MX_CRM.put("email",      TEST_MAIL_START_TOKEN+currTime+"_"+randomStrInt+"_"+TEST_MAIL_END_TOKEN+"@qp1.org");
        MX_CRM.put("telephone", "4492270000");
        MX_CRM.put("mypassword", "password");
        MX_CRM.put("confirmpassword", "password");
    }

    public static final Map<String, String> mxMembersFormMap = new LinkedHashMap<>();
    static { String randomStrInt = TestUtil.generateRandomStringNumber();
        Long currTime = System.nanoTime();
        mxMembersFormMap.put( "firstname", "testing");
        mxMembersFormMap.put( "lastname", "AutoLastName");
        mxMembersFormMap.put( "email", TEST_MAIL_START_TOKEN+currTime+"_"+randomStrInt+"_"+TEST_MAIL_END_TOKEN+"@qp1.org");
        //mxMembersFormMap.put( "telephone", "2222220000");
        mxMembersFormMap.put( "password", BaseTestConfig.getPassword8());
        //mxMembersFormMap.put( "SubscribeToEmailEnglish", "selectMeChk_false");
    }

    /*******************************************************************************************************************
     *  Brazil
     ******************************************************************************************************************/
    public static final Map<String, String> brOEFormMap = new LinkedHashMap<>();
    static {
        String randomStrInt = TestUtil.generateRandomStringNumber();
        Long currTime = System.nanoTime();
        brOEFormMap.put( "first_name", "AutoTest Pele Ziko");
        brOEFormMap.put( "email",      TEST_MAIL_START_TOKEN+currTime+randomStrInt+TEST_MAIL_END_TOKEN+"@qp1.org");
        brOEFormMap.put( "telephone",  "7679878978");
        brOEFormMap.put( "age",        "selectMeSelectOpt&true&25-30");
    }

    public static final Map<String, String> brEEFormMap = new LinkedHashMap<>();
    static {
        String randomStrInt = TestUtil.generateRandomStringNumber();
        Long currTime = System.nanoTime();
        brEEFormMap.put( "first_name", "AutoTest Pele Ziko");
        brEEFormMap.put( "email",      TEST_MAIL_START_TOKEN+currTime+randomStrInt+TEST_MAIL_END_TOKEN+"@qp1.org");
        brEEFormMap.put( "telephone",  "0478987456");
        brEEFormMap.put( "age",        "selectMeSelectOpt&true&25-30");
//        brEEFormMap.put( "emailenglish", "selectMeChk_true");
    }
    /*******************************************************************************************************************
     * CO OE form
     ******************************************************************************************************************/
    public static final Map<String, String> CoOeFormMap = new LinkedHashMap<>();
    static {
        String randomStrInt = TestUtil.generateRandomStringNumber();
        Long currTime = System.nanoTime();
        CoOeFormMap.put("first_name", "AutoTest");
        CoOeFormMap.put( "location-state",  "selectMeSelectOpt&true&cundinamarca");
        CoOeFormMap.put( "last_name",  "AutoLastNameTest");
        CoOeFormMap.put( "email",      TEST_MAIL_START_TOKEN+currTime+randomStrInt+TEST_MAIL_END_TOKEN+"@qp1.org");
        CoOeFormMap.put( "telephone-type",  "selectMeSelectOpt&true&mobile");  //"input[value='landline']"
        CoOeFormMap.put( "age",        "selectMeSelectOpt&true&21-25");
        //CoOeFormMap.put( "emailenglish", "selectMeChk_true");
        CoOeFormMap.put( "telephone",  "085635435334");
    }
    /*******************************************************************************************************************
     *  Argentina
     ******************************************************************************************************************/
    public static final Map<String, String> arOEFormMap = new LinkedHashMap<>();
    static { String randomStrInt = TestUtil.generateRandomStringNumber();
        Long currTime = System.nanoTime();
        arOEFormMap.put( "first_name",      "fMaradonaAR");
        arOEFormMap.put("last_name", "Kanigia");//arOEFormMap.put( "country",         "selectMeSelectOpt&true&Argentina");
        arOEFormMap.put( "email",           TEST_MAIL_START_TOKEN+currTime+"_"+randomStrInt+"_"+TEST_MAIL_END_TOKEN+"@qp1.org");
        arOEFormMap.put( "location-state",  "selectMeSelectOpt&true&buenos-aires");//<option value="buenos-aires">Buenos Aires</option>
        arOEFormMap.put( "location-city",   "selectMeSelectOpt&true&abasto");
        arOEFormMap.put( "telephone-type",  "selectMeChk_true");
        arOEFormMap.put( "telephone",       "4492270000");
        arOEFormMap.put( "age",             "selectMeSelectOpt&true&21-25");
        arOEFormMap.put( "emailenglish",    "selectMeChk_false");
    }
    /*******************************************************************************************************************
     *  Peru pe
     ******************************************************************************************************************/
    public static final Map<String, String> peOEFormMap = new LinkedHashMap<>();
    static { String randomStrInt = TestUtil.generateRandomStringNumber();
        Long currTime = System.nanoTime();
        peOEFormMap.put( "first_name",      "PefMaradonaAR");
        peOEFormMap.put("last_name", "Kanigia");//arOEFormMap.put( "country",         "selectMeSelectOpt&true&Argentina");
        peOEFormMap.put( "email",           TEST_MAIL_START_TOKEN+currTime+"_"+randomStrInt+"_"+TEST_MAIL_END_TOKEN+"@qp1.org");
        peOEFormMap.put( "location-state",  "selectMeSelectOpt&true&ica");//<option value="buenos-aires">Buenos Aires</option>
        peOEFormMap.put( "location-city",   "selectMeSelectOpt&true&abasto");
        peOEFormMap.put( "telephone-type",  "selectMeChk_true");
        peOEFormMap.put( "telephone",       "4492270000");
        peOEFormMap.put( "age",             "selectMeSelectOpt&true&21-25");
        peOEFormMap.put( "emailenglish",    "selectMeChk_false");
    }
    /*******************************************************************************************************************
     *  Peru CostaRica
     ******************************************************************************************************************/
    public static final Map<String, String> crFormMap_testPhone = new LinkedHashMap<>();
    static { String randomStrInt = TestUtil.generateRandomStringNumber();
        Long currTime = System.nanoTime();
        crFormMap_testPhone.put( "first_name",      "PefMaradonaAR");
        crFormMap_testPhone.put("last_name", "Kanigia");//arOEFormMap.put( "country",
        crFormMap_testPhone.put( "email",           TEST_MAIL_START_TOKEN+currTime+"_"+randomStrInt+"_"+TEST_MAIL_END_TOKEN+"@qp1.org");
        crFormMap_testPhone.put( "age",             "selectMeSelectOpt&true&21-25");

    }

    /*******************************************************************************************************************
     *  Peru cl
     ******************************************************************************************************************/
    public static final Map<String, String> clOEFormMap = new LinkedHashMap<>();
    static { String randomStrInt = TestUtil.generateRandomStringNumber();
        Long currTime = System.nanoTime();
        clOEFormMap.put( "first_name",      "PefMaradonaAR");
        clOEFormMap.put("last_name", "Kanigia");//arOEFormMap.put( "country",         "selectMeSelectOpt&true&Argentina");
        clOEFormMap.put( "email",           TEST_MAIL_START_TOKEN+currTime+"_"+randomStrInt+"_"+TEST_MAIL_END_TOKEN+"@qp1.org");
        clOEFormMap.put( "location-state",  "selectMeSelectOpt&true&atacama");//<option value="buenos-aires">Buenos Aires</option>
        clOEFormMap.put( "location-city",   "selectMeSelectOpt&true&huasco");
        clOEFormMap.put( "telephone-type",  "selectMeSelectOpt&true&mobile");
        clOEFormMap.put( "telephone",       "4492270000");
        clOEFormMap.put( "age",             "selectMeSelectOpt&true&21-25");
        clOEFormMap.put( "emailenglish",    "selectMeChk_false");
    }

    public static final Map<String, String> clOEFormNoPhoneMap = new LinkedHashMap<>();
    static { String randomStrInt = TestUtil.generateRandomStringNumber();
        Long currTime = System.nanoTime();
        clOEFormNoPhoneMap.put( "first_name",      "PefMaradonaAR");
        clOEFormNoPhoneMap.put("last_name", "Kanigia");//arOEFormMap.put( "country",         "selectMeSelectOpt&true&Argentina");
        clOEFormNoPhoneMap.put( "email",           TEST_MAIL_START_TOKEN+currTime+"_"+randomStrInt+"_"+TEST_MAIL_END_TOKEN+"@qp1.org");
        clOEFormNoPhoneMap.put( "location-state",  "selectMeSelectOpt&true&atacama");//<option value="buenos-aires">Buenos Aires</option>
        clOEFormNoPhoneMap.put( "location-city",   "selectMeSelectOpt&true&huasco");
        clOEFormNoPhoneMap.put( "age",             "selectMeSelectOpt&true&21-25");
        clOEFormNoPhoneMap.put( "emailenglish",    "selectMeChk_false");
    }
    //------------------------------------------------------------------------------------------------------------------
    //*****************************************  Earning calculator   **************************************************
    public static final Map<String, String> GEN_EARNING_DETAILS = new LinkedHashMap<>();
    static { String randomStrInt = TestUtil.generateRandomStringNumber();
        Long currTime = System.nanoTime();
        GEN_EARNING_DETAILS.put("first_name",   "AUTO_GEN_fName");
        GEN_EARNING_DETAILS.put( "last_name",   "lNameEC");
        GEN_EARNING_DETAILS.put( "email",       TEST_MAIL_START_TOKEN+currTime+"_"+randomStrInt+"_"+TEST_MAIL_END_TOKEN+"@qp1.org");
        GEN_EARNING_DETAILS.put( "telephone",   "0478987456");
        GEN_EARNING_DETAILS.put( "toc", "selectMeChk_true");
        //GEN_EARNING_DETAILS.put( "emailenglish","selectMeChk_false");
    } // fr got another field country
    public static final Map<String, String> MX_EARNING_DETAILS = new LinkedHashMap<>();
    static { String randomStrInt = TestUtil.generateRandomStringNumber();
        Long currTime = System.nanoTime();
        MX_EARNING_DETAILS.put("first_name", "MXAUTO_GEN_fName");
        MX_EARNING_DETAILS.put( "last_name",   "lNameEC");
        MX_EARNING_DETAILS.put( "email",       TEST_MAIL_START_TOKEN+currTime+"_"+randomStrInt+"_"+TEST_MAIL_END_TOKEN+"@qp1.org");
        MX_EARNING_DETAILS.put( "phone-type",   "selectMeSelectOpt&true&Home");
        MX_EARNING_DETAILS.put( "telephone",   "229-213-1231") ; //"47898745687");
        //MX_EARNING_DETAILS.put( "emailenglish","selectMeChk_false");
    }
    // step 2
    public static final Map<String, String> GEN_EARNING_CALCULATE = new LinkedHashMap<>();
    static {
        GEN_EARNING_CALCULATE.put("earning-field-annual-salary-value", "50000"); //(".count-8 .inner.select select",   "selectMeSelectOpt&true&br");
    }

    //----------------------- free consultation
    public static final Map<String, String> ukFreeConsultationFormMap = new LinkedHashMap<>();
    static { String randomStrInt = TestUtil.generateRandomStringNumber();
        Long currTime = System.nanoTime();
        ukFreeConsultationFormMap.put( "first_name",  "ukCiroOEfc");
        ukFreeConsultationFormMap.put( "last_name",   "Palacio");
        ukFreeConsultationFormMap.put( "email",       TEST_MAIL_START_TOKEN+currTime+"_"+randomStrInt+"_"+TEST_MAIL_END_TOKEN+"@qp1.org");
        ukFreeConsultationFormMap.put( "telephone",   "323212312312");
        ukFreeConsultationFormMap.put( "country",     "selectMeSelectOpt&true&al");
        ukFreeConsultationFormMap.put( "age",     "selectMeSelectOpt&true&21-25");
        ukFreeConsultationFormMap.put( "toc", "selectMeChk_true");
        /*ukFreeConsultationFormMap.put( "firstname",  "ukCiroOEfc");
        ukFreeConsultationFormMap.put( "lastname",   "Palacio");
        ukFreeConsultationFormMap.put( "email",       TEST_MAIL_START_TOKEN+currTime+"_"+randomStrInt+"_"+TEST_MAIL_END_TOKEN+"@qp1.org");
        ukFreeConsultationFormMap.put( "telephone",   "323212312312");
        ukFreeConsultationFormMap.put( "mypassword",     "123");*/
    }

    public static final Map<String, String> deFreeConsultationFormMap = new LinkedHashMap<>();
    static { String randomStrInt = TestUtil.generateRandomStringNumber();
        Long currTime = System.nanoTime();
        deFreeConsultationFormMap.put( "first_name",  "deCiroOEfc");
        deFreeConsultationFormMap.put( "last_name",   "Palacio");
        deFreeConsultationFormMap.put( "email",       TEST_MAIL_START_TOKEN+currTime+"_"+randomStrInt+"_"+TEST_MAIL_END_TOKEN+"@qp1.org");
        deFreeConsultationFormMap.put( "telephone",   "07852312312");
        deFreeConsultationFormMap.put( "age",     "selectMeSelectOpt&true&21-25");
        deFreeConsultationFormMap.put( "toc", "selectMeChk_true");

    }

    public static final Map<String, String> ruFreeConsultationFormMap = new LinkedHashMap<>();
    static { String randomStrInt = TestUtil.generateRandomStringNumber();
        Long currTime = System.nanoTime();
        ruFreeConsultationFormMap.put( "first_name",  "RuCiroOEfc");
        ruFreeConsultationFormMap.put( "last_name",   "RuPalacio");
        ruFreeConsultationFormMap.put( "email",       TEST_MAIL_START_TOKEN+currTime+"_"+randomStrInt+"_"+TEST_MAIL_END_TOKEN+"@qp1.org");
        ruFreeConsultationFormMap.put( "telephone",   "07852312312");
        ruFreeConsultationFormMap.put( "city",     "selectMeSelectOpt&true&anapa");
        ruFreeConsultationFormMap.put( "age",     "selectMeSelectOpt&true&18-22");

    }


    public static final Map<String, String> SA_OECMRM_MAP = new LinkedHashMap<>();
    static {
        setCurrTime(System.currentTimeMillis());
        //SA_OECMRM_MAP.put( "country",  "selectMeSelectOpt&true&sa" );
        SA_OECMRM_MAP.put( "first_name",  "AutoFristNamePlatini");
        SA_OECMRM_MAP.put( "last_name",   "LastNameTest");
        SA_OECMRM_MAP.put( "email",       TEST_MAIL_START_TOKEN+currTime+TEST_MAIL_END_TOKEN+"@qp1.org");
        SA_OECMRM_MAP.put( "telephone-type",    "selectMeSelectOpt&false&mobile");
        SA_OECMRM_MAP.put( "telephone",   "37777777");
        SA_OECMRM_MAP.put( "age",         "selectMeSelectOpt&true&26-30" );
        //
        // SA_OECMRM_MAP.put( "country",     "selectMeSelectOpt&true&fr");// 05 Jun 2015 commment out
        //SA_OECMRM_MAP.put( "emailenglish","selectMeChk_false");//selectMeChk_true
    }

    public static final Map<String, String> CRM_SA_OECMRM_MAP = new LinkedHashMap<>();
    static {
        setCurrTime(System.currentTimeMillis());
        CRM_SA_OECMRM_MAP.put( "country",  "selectMeSelectOpt&true&sa" );
        CRM_SA_OECMRM_MAP.put( "first_name",  "AutoFristNamePlatini");        ;
        CRM_SA_OECMRM_MAP.put( "last_name",   "LastNameTest");
       // CRM_SA_OECMRM_MAP.put( "email",       TEST_MAIL_START_TOKEN+currTime+TEST_MAIL_END_TOKEN+"@qp1.org");
        //CRM_SA_OECMRM_MAP.put( "telephone-type",    "selectMeSelectOpt&false&mobile");
        CRM_SA_OECMRM_MAP.put( "telephone",   "44444444");
        CRM_SA_OECMRM_MAP.put( "age",         "selectMeSelectOpt&true&26-30" );

    }

    public static final Map<String, String> saFreeConsultationFormMap = new LinkedHashMap<>();
    static { String randomStrInt = TestUtil.generateRandomStringNumber();
        Long currTime = System.nanoTime();
        saFreeConsultationFormMap.put( "first_name",  "ukCiroOEfc");
        saFreeConsultationFormMap.put( "last_name",   "Palacio");
        saFreeConsultationFormMap.put( "email",       TEST_MAIL_START_TOKEN+currTime+"_"+randomStrInt+"_"+TEST_MAIL_END_TOKEN+"@qp1.org");
        saFreeConsultationFormMap.put( "telephone",   "0225662542");
        saFreeConsultationFormMap.put( "age",     "selectMeSelectOpt&true&21-25");

    }

    public static final Map<String, String> twFreeConsultationFormMap = new LinkedHashMap<>();
    static { String randomStrInt = TestUtil.generateRandomStringNumber();
        Long currTime = System.nanoTime();
        twFreeConsultationFormMap.put( "first_name",  "ukCiroOEfc");
        twFreeConsultationFormMap.put( "last_name",   "Palacio");
        twFreeConsultationFormMap.put( "email",       TEST_MAIL_START_TOKEN+currTime+"_"+randomStrInt+"_"+TEST_MAIL_END_TOKEN+"@qp1.org");
        twFreeConsultationFormMap.put( "city",     "selectMeSelectOpt&true&tw_ks");
        twFreeConsultationFormMap.put( "telephone",   "0225662542");
        twFreeConsultationFormMap.put( "age",     "selectMeSelectOpt&true&21-25");
        twFreeConsultationFormMap.put( "toc", "selectMeChk_true");
    }

    public static final Map<String, String> usFreeConsultationFormMap = new LinkedHashMap<>();
    static { String randomStrInt = TestUtil.generateRandomStringNumber();
        Long currTime = System.nanoTime();
        usFreeConsultationFormMap.put( "first_name",  "USCirofc");
        usFreeConsultationFormMap.put( "last_name",   "Palacio");
        usFreeConsultationFormMap.put( "email",       TEST_MAIL_START_TOKEN+currTime+"_"+randomStrInt+"_"+TEST_MAIL_END_TOKEN+"@qp1.org");
        usFreeConsultationFormMap.put( "telephone",   "07852312312");
        usFreeConsultationFormMap.put( "age",     "selectMeSelectOpt&true&21-25");
        usFreeConsultationFormMap.put( "calltime",     "selectMeSelectOpt&true&1pm4pm");
    }
    public static final Map<String, String> usFreeConsultationUnder13FormMap = new LinkedHashMap<>();
    static { String randomStrInt = TestUtil.generateRandomStringNumber();
        Long currTime = System.nanoTime();
        usFreeConsultationUnder13FormMap.put( "first_name",  "USCirofc");
        usFreeConsultationUnder13FormMap.put( "last_name",   "Palacio");
        usFreeConsultationUnder13FormMap.put( "email",       TEST_MAIL_START_TOKEN+currTime+"_"+randomStrInt+"_"+TEST_MAIL_END_TOKEN+"@qp1.org");
        usFreeConsultationUnder13FormMap.put( "telephone",   "07852312312");
        usFreeConsultationUnder13FormMap.put( "age",     "selectMeSelectOpt&true&<13");
        //usFreeConsultationUnder13FormMap.put( "calltime",     "selectMeSelectOpt&true&1pm4pm");
    }
    /*******************************************************************************************************************
     *  General Forms  Base
     ******************************************************************************************************************/
    // emailEnlish form base
    public static final Map<String, String> baseOsEeFormMap = new LinkedHashMap<>();
    static { String randomStrInt = TestUtil.generateRandomStringNumber();
        Long currTime = System.nanoTime();
        baseOsEeFormMap.put( "first_name", "AutoFristName");
        baseOsEeFormMap.put( "email", TEST_MAIL_START_TOKEN+currTime+"_"+randomStrInt+"_"+TEST_MAIL_END_TOKEN+"@qp1.org");         //opt baseOsEeFormMap.put( "telephone", "0123569874");          //0123569874 country emailenglish
        baseOsEeFormMap.put( "toc", "selectMeChk_true");
    }

    public static final Map<String, String>  BASIC_OE_LEAD = new LinkedHashMap<>();
    static { String randomStrInt = TestUtil.generateRandomStringNumber();
        Long currTime = System.nanoTime();
        BASIC_OE_LEAD.put( "first_name", "AutoFName");
        BASIC_OE_LEAD.put( "last_name", "LName");
        BASIC_OE_LEAD.put( "email", TEST_MAIL_START_TOKEN+"OE_"+currTime+"_"+randomStrInt+"_"+TEST_MAIL_END_TOKEN+"@qp1.org");         //opt baseOsEeFormMap.put( "telephone", "0123569874");          //0123569874 country emailenglish
        BASIC_OE_LEAD.put( "toc", "selectMeChk_true");
    }

    public static final Map<String, String> osEeFormMapLasNameAndPass = new LinkedHashMap<>();
    static {
        osEeFormMapLasNameAndPass.put( "lastname", "AutoLastName");
        osEeFormMapLasNameAndPass.put( "mypassword", BaseTestConfig.getPassword8());
    }
    // select only check box for emailenglish
    public static final Map<String, String> emailEnglishMapCheckboxTue = new LinkedHashMap<>();
    static {
        emailEnglishMapCheckboxTue.put( "emailenglish", "selectMeChk_true");
    }
    public static final Map<String, String> englishEmailMapCheckboxTue = new LinkedHashMap<>();
    static {
        emailEnglishMapCheckboxTue.put( "englishemail", "selectMeChk_true");
    }

    // Rusia payment page
    public static final Map<String, String> address = new LinkedHashMap<>();
    static {
        address.put( "CCAddress1",   "Testing Address");
        address.put( "CCAddress2",   "NikolTest");
        address.put( "CCState",      "Cremlin");
        address.put( "CCCity",       "CorraptPutin");
        address.put( "CCPostalCode", "NIKOL");
        //address.put( "", "");
    }
    // ar
    // latam
    public static Map<String, String> AR_LATAM_MAP = new LinkedHashMap<>();
    static {
        Long currTime = System.nanoTime();
        AR_LATAM_MAP = EfConstants.getDynamicMap("first_name", "last_name", "email");
        AR_LATAM_MAP.put( "telephone",   "22222222");
        AR_LATAM_MAP.put( "age",     "selectMeSelectOpt&true&21-25");
    }
    // map with EfFullDataBeanJson.json
    public static Map<String, String> F_L_NAME_EMAIL_CTR_STATE_TEL_EDGE_MAP = new LinkedHashMap<>();
    static { String randomStrInt = TestUtil.generateRandomStringNumber();
        Long currTime = System.nanoTime();
        //F_L_NAME_EMAIL_CTR_STATE_TEL_EDGE_MAP = EfConstants.getDynamicMap("first_name", "last_name", "email");
        F_L_NAME_EMAIL_CTR_STATE_TEL_EDGE_MAP.put( "first_name",     "FautoNik");
        F_L_NAME_EMAIL_CTR_STATE_TEL_EDGE_MAP.put( "last_name",      "LMak");
        F_L_NAME_EMAIL_CTR_STATE_TEL_EDGE_MAP.put( "email",          TEST_MAIL_START_TOKEN+currTime+"_"+randomStrInt+"_"+TEST_MAIL_END_TOKEN+"@qp1.org");
        F_L_NAME_EMAIL_CTR_STATE_TEL_EDGE_MAP.put( "country",        "selectMeSelectOpt&true&pe");
        F_L_NAME_EMAIL_CTR_STATE_TEL_EDGE_MAP.put( "location-state", "selectMeSelectOpt&true&amazonas");
        //F_L_NAME_EMAIL_CTR_STATE_TEL_EDGE_MAP.put( "telephone",      "22334454");
        F_L_NAME_EMAIL_CTR_STATE_TEL_EDGE_MAP.put( "age",            "selectMeSelectOpt&true&21-25");
    }
    //section [name=first_name]
    public static Map<String, String> F_L_NAME_EMAIL_CTR_STATE_TEL_EDGE_MAP_CSS = new LinkedHashMap<>();
    static { String randomStrInt = TestUtil.generateRandomStringNumber();
        Long currTime = System.nanoTime();
        //F_L_NAME_EMAIL_CTR_STATE_TEL_EDGE_MAP = EfConstants.getDynamicMap("first_name", "last_name", "email");
        F_L_NAME_EMAIL_CTR_STATE_TEL_EDGE_MAP_CSS.put( "first_name",     "FautoNik");
        F_L_NAME_EMAIL_CTR_STATE_TEL_EDGE_MAP_CSS.put( "last_name",      "LMak");
        F_L_NAME_EMAIL_CTR_STATE_TEL_EDGE_MAP_CSS.put( "email",          TEST_MAIL_START_TOKEN+currTime+"_"+randomStrInt+"_"+TEST_MAIL_END_TOKEN+"@qp1.org");
        F_L_NAME_EMAIL_CTR_STATE_TEL_EDGE_MAP_CSS.put( "country",        "selectMeSelectOpt&true&pe");
        F_L_NAME_EMAIL_CTR_STATE_TEL_EDGE_MAP_CSS.put( "location-state", "selectMeSelectOpt&true&amazonas");
        //F_L_NAME_EMAIL_CTR_STATE_TEL_EDGE_MAP.put( "telephone",      "22334454");
        F_L_NAME_EMAIL_CTR_STATE_TEL_EDGE_MAP_CSS.put( "age",            "selectMeSelectOpt&true&21-25");
    }

    // form fields
    public static final Map<String, String> COUNTRY_AR_MAP = new HashMap<>();
    static {
        COUNTRY_AR_MAP.put( "country",   "selectMeSelectOpt&true&ar");
    }

    public static final Map<String, String> FL_NAME_EMAIL_MAP = new LinkedHashMap<>();
    static { String randomStrInt = TestUtil.generateRandomStringNumber();
        Long currTime = System.nanoTime();
        FL_NAME_EMAIL_MAP.put( "first_name",  "NikoFN");
        FL_NAME_EMAIL_MAP.put( "last_name",   "MarkLN");
        FL_NAME_EMAIL_MAP.put( "email",       TEST_MAIL_START_TOKEN+currTime+"_"+randomStrInt+"_"+TEST_MAIL_END_TOKEN+"@qp1.org");
        FL_NAME_EMAIL_MAP.put( "toc", "selectMeChk_true");
    }

    public static Map<String, String> getDynamicMap(String ... mapKey){
        Map<String, String> myMap = new LinkedHashMap<>();
        Long currTime = System.nanoTime();
        int count = 0;
        String tmpKeyValue = "";

        if(mapKey!=null && mapKey.length > 0){

            for(String key : mapKey) {
                if(StringUtils.contains(key, "mail" )) {
                    tmpKeyValue = TEST_MAIL_START_TOKEN + currTime + TEST_MAIL_END_TOKEN + "@qp1.org";
                }else {
                    tmpKeyValue = TestUtil.generateRandomString("Nik", 5);
                }
                myMap.put(key, tmpKeyValue);
                count++;
            }
        }

        return myMap;
    }

    /*******************************************************************************************************************
     *  HELPERS
     ******************************************************************************************************************/
    /**
     *  create a map with the know user email and tel
     */
    public static Map createMap(String userName, String tel){
        Map<String, String> map = new LinkedHashMap<>();
        map.put( "firstname",    "AutoFirstNameReused");
        map.put( "lastname",     "AutoLastNameTest");
        map.put( "email",        userName);      //test12345et_os"+currTime+"_"+randomStrInt+"_"+"@qp1.org
        map.put( "telephone",    tel);           //no validation currTime   085635435334
        map.put( "mypassword",   BaseTestConfig.getPassword8());
        map.put( "toc", "selectMeChk_true");
        map.put( "dynamicsubscribe", "selectMeChk_true");
        return map;
    }

    public Long getCurrTime() {
        return currTime;
    }
    public static synchronized void setCurrTime(Long currTime) {
        setCurrTimeSafe(currTime);
        EfConstants.currTime = currTime;
    }

    public static void setCurrTimeSafe(Long currTime) {
        if (EfConstants.currTime == currTime){
            EfConstants.currTime =System.currentTimeMillis();
        }
    }

    public static void dumpMap(Map mp) {
        Iterator it = mp.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pairs = (Map.Entry)it.next();
            System.out.println(pairs.getKey() + "\t = " + pairs.getValue());
        }
    }


    //
//    no protocoll
    public static final Map<String, String> REDIRECT_ELIVE_ALL_TESTS_URL = new LinkedHashMap<>();
    static {
        //https://jira.eflabs.io/browse/SAND-4005
        REDIRECT_ELIVE_ALL_TESTS_URL.put( "englishlive.ef.com/ar-wws/?ctr=ae",      "englishlive.ef.com/ar-sa/");
        REDIRECT_ELIVE_ALL_TESTS_URL.put( "englishlive.ef.com/ar-wws/?ctr=eg",      "englishlive.ef.com/ar-sa/");
        REDIRECT_ELIVE_ALL_TESTS_URL.put( "englishlive.ef.com/ar-wws/learn-english-online/business-english/?ctr=ae",      "englishlive.ef.com/ar-sa/online-english-courses/business-english/");
        //cn SAND-3952 http://www.englishlive.com/?ctr=cn  ----> http://englishlive.cn/
        //REDIRECT_ELIVE_ALL_TESTS_URL.put( "englishlive.com/?ctr=cn",      "englishlive.cn/");
        REDIRECT_ELIVE_ALL_TESTS_URL.put( "englishlive.com/?ctr=hk",      "https://www.ef.com.hk/ec/");
        //REDIRECT_ELIVE_ALL_TESTS_URL.put( "www.englishlive.com/?ctr=hk",      "englishtown.com.hk/");
        //new BR to elive
        /*REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.de/login/",      "englishlive.ef.com/de-de/login/");
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.it/login/",      "englishlive.ef.com/it-it/login/");
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.fr/login/",      "englishlive.ef.com/fr-fr/login/");
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com.br/login/",      "englishlive.ef.com/pt-br/login/");         // need hostfile change REDIRECT_ELIVE_ALL_TESTS_URL.put( "englishlive.com.br/login/",      "englishlive.ef.com/pt-br/login/");
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.co.jp/login/",      "englishlive.ef.com/ja-jp/login/");
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.de/help/",      "englishlive.ef.com/de-de/help/");
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.it/help/",      "englishlive.ef.com/it-it/help/");
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.fr/help/",      "englishlive.ef.com/fr-fr/help/");
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com.br/help/",      "englishlive.ef.com/pt-br/help/");        // need hostfile change REDIRECT_ELIVE_ALL_TESTS_URL.put( "englishlive.com.br/help/",      "englishlive.ef.com/pt-br/help/");
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.co.jp/help/",      "englishlive.ef.com/ja-jp/help/");
        // url need mapping
        //REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/?ctr=in",                           "englishlive.ef.com/en-wws" );
        //REDIRECT_ELIVE_ALL_TESTS_URL.put( "englishlive.ef.com/?ctr=in",                         "englishlive.ef.com/en-wws/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/es-mx/",                           "englishlive.ef.com/es-mx/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/?ctr=mx",                          "englishlive.ef.com/es-mx/" );
        //issue ... fail REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/online/home.aspx?ctr=mx",          "englishlive.ef.com/es-mx/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/es-mx/buy/default/member/",        "englishlive.ef.com/es-mx/buy/default/member/" );

        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.fr/",		                            "englishlive.ef.com/fr-fr/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.fr/lp/oe/anglais-des-affaires/",		"englishlive.ef.com/fr-fr/lp/oe/anglais-des-affaires/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.fr/buy/default/member/",		        "englishlive.ef.com/fr-fr/buy/default/member/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.fr/online/home.aspx",                  "englishlive.ef.com/fr-fr/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.de/",		                            "englishlive.ef.com/de-de/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.de/online/home.aspx",		            "englishlive.ef.com/de-de/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.de/lp/os/englisch-lernen/",		    "englishlive.ef.com/de-de/lp/os/englisch-lernen/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.de/buy/default/member/",		        "englishlive.ef.com/de-de/buy/default/member/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.it/",		                            "englishlive.ef.com/it-it/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.it/online/home.aspx",                  "englishlive.ef.com/it-it/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.it/buy/default/member/",		        "englishlive.ef.com/it-it/buy/default/member/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/ar-sa/",		                    "englishlive.ef.com/ar-sa/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/online/home.aspx?ctr=sa",		    "englishlive.ef.com/ar-sa/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/ar-sa/buy/default/member/",		"englishlive.ef.com/ar-sa/buy/default/member/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/?ctr=eg",		                    "englishlive.ef.com/ar-sa/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/ar-wws/?ctr=eg",		            "englishlive.ef.com/ar-sa/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/ar-wws/buy/default/member/?ctr=eg","englishlive.ef.com/ar-sa/buy/default/member/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/?ctr=am",		                    "englishlive.ef.com/en-wws/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/en-wws/?ctr=am",		            "englishlive.ef.com/en-wws/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/en-wws/buy/default/member/?ctr=am","englishlive.ef.com/en-wws/buy/default/member/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/?ctr=pf",		                    "englishlive.ef.com/fr-wws/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/fr-wws/?ctr=pf",		            "englishlive.ef.com/fr-wws/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/fr-wws/buy/default/member/?ctr=pf","englishlive.ef.com/fr-wws/buy/default/member/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/?ctr=at",		                    "englishlive.ef.com/de-wws/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/de-wws/?ctr=at",		            "englishlive.ef.com/de-wws/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/de-wws/buy/default/member/?ctr=pf","englishlive.ef.com/de-wws/buy/default/member/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/es-wws/?ctr=ni",                   "englishlive.ef.com/es-mx/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/?ctr=ni",                          "englishlive.ef.com/es-mx/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/es-us/",           "englishlive.ef.com/es-mx/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/en-us/",           "englishlive.ef.com/en-us/" );
        // Fantastic 4  F4  cl|co|ve|pe go to eLive
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/es-cl/",           "englishlive.ef.com/es-mx/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/es-co/",           "englishlive.ef.com/es-mx/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/es-ve/",           "englishlive.ef.com/es-mx/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/es-pe/",           "englishlive.ef.com/es-mx/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/?ctr=cl",           "englishlive.ef.com/es-mx/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/?ctr=co",           "englishlive.ef.com/es-mx/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/?ctr=ve",           "englishlive.ef.com/es-mx/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/?ctr=pe",           "englishlive.ef.com/es-mx/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/online/home.aspx?ctr=cl",           "englishlive.ef.com/es-mx/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/online/home.aspx?ctr=co",           "englishlive.ef.com/es-mx/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/online/home.aspx?ctr=ve",           "englishlive.ef.com/es-mx/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/online/home.aspx?ctr=pe",           "englishlive.ef.com/es-mx/" );
        // these go to etown
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/community/Channels/article.aspx?articleName=102-eatout&ctr=cl",           ".englishtown.com/community/channels/article.aspx?articlename=102-eatout"); //".englishtown.com/blog/7-english-phrases-need-know-eating/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/community/Channels/article.aspx?articleName=102-eatout&ctr=co",           ".englishtown.com/community/channels/article.aspx?articlename=102-eatout"); //".englishtown.com/blog/7-english-phrases-need-know-eating/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/community/Channels/article.aspx?articleName=102-eatout&ctr=ve",           ".englishtown.com/community/channels/article.aspx?articlename=102-eatout"); //".englishtown.com/blog/7-english-phrases-need-know-eating/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/community/Channels/article.aspx?articleName=102-eatout&ctr=pe",           ".englishtown.com/community/channels/article.aspx?articlename=102-eatout"); //".englishtown.com/blog/7-english-phrases-need-know-eating/" );
        //
        // other Rola es Spanish speaking group (ar|bo|cr|cu|do|ec|gt|hn|ni|pa|pr|py|sv|uy) go to eLive
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/?ctr=ar",           "englishlive.ef.com/es-mx/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/es-ar/",            "englishlive.ef.com/es-mx/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/online/home.aspx?ctr=ar",           "englishlive.ef.com/es-mx/" );
        // these go to etown
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/community/Channels/article.aspx?articleName=102-eatout&ctr=ar",           ".englishtown.com/community/channels/article.aspx?articlename=102-eatout"); //".englishtown.com/blog/7-english-phrases-need-know-eating/" );
        //
        //Other Rola English speaking group (ag|ai|aw|bb|bz||ht|kn|ky|lc|tt|vc|vg|vi).  go to eTown
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/?ctr=ag",           "englishlive.ef.com/en-wws/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/?ctr=lc",           "englishlive.ef.com/en-wws/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/?ctr=vc",           "englishlive.ef.com/en-wws/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/en-ag/",            "englishlive.ef.com/en-wws/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/en-lc/",            "englishlive.ef.com/en-wws/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/en-vc/",            "englishlive.ef.com/en-wws/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/es-lc/",            "englishlive.ef.com/es-mx/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/es-wws/?ctr=ag",           "englishlive.ef.com/es-mx/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/es-wws/?ctr=lc",           "englishlive.ef.com/es-mx/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/es-wws/?ctr=vc",           "englishlive.ef.com/es-mx/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/en-vc/contact-us/",        "englishlive.ef.com/en-wws/contact-us/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/online/home.aspx?ctr=ag",           "englishlive.ef.com/en-wws/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/online/home.aspx?ctr=lc",           "englishlive.ef.com/en-wws/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/online/home.aspx?ctr=vc",           "englishlive.ef.com/en-wws/" );
//         REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/online/your-teachers.aspx?ctr=ag",       "englishlive.ef.com/en-wws/teachers-and-students/teachers/"); // ".englishtown.com/en-wws/profesores-y-estudiantes/profesores-de-ingles/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/online/your-teachers.aspx?ctr=lc",       "englishlive.ef.com/en-wws/teachers-and-students/teachers/");
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/online/your-teachers.aspx?ctr=vc",       "englishlive.ef.com/en-wws/teachers-and-students/teachers/");
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/en-ag/como-aprender-ingles/escuela-de-ingles/",           "englishlive.ef.com/en-wws/como-aprender-ingles/escuela-de-ingles/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/en-lc/como-aprender-ingles/escuela-de-ingles/",           "englishlive.ef.com/en-wws/como-aprender-ingles/escuela-de-ingles/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/en-vc/como-aprender-ingles/escuela-de-ingles/",           "englishlive.ef.com/en-wws/como-aprender-ingles/escuela-de-ingles/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/es-ag/como-aprender-ingles/escuela-de-ingles/",           "englishlive.ef.com/es-mx/como-aprender-ingles/escuela-de-ingles/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/es-lc/como-aprender-ingles/escuela-de-ingles/",           "englishlive.ef.com/es-mx/como-aprender-ingles/escuela-de-ingles/" );
        // others
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/?ctr=ae",           "englishlive.ef.com/ar-sa/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/?ctr=kw",           "englishlive.ef.com/ar-sa/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/?ctr=sa",           "englishlive.ef.com/ar-sa/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/?ctr=tj",           "englishlive.ef.com/en-wws/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/?ctr=at",           "englishlive.ef.com/de-wws/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/?ctr=ch",           "englishlive.ef.com/de-wws/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/?ctr=mn",           "englishlive.ef.com/en-wws/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/?ctr=pw",           "englishlive.ef.com/en-wws/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/?ctr=zm",           "englishlive.ef.com/en-wws/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/?ctr=dz",           "englishlive.ef.com/ar-sa/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/?ctr=be",           "englishlive.ef.com/fr-wws/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/?ctr=gf",           "englishlive.ef.com/fr-wws/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/?ctr=tn",           "englishlive.ef.com/ar-sa/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/ar-ae/",           "englishlive.ef.com/ar-sa/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/ar-kw/",           "englishlive.ef.com/ar-sa/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/de-at/",           "englishlive.ef.com/de-wws/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/de-ch/",           "englishlive.ef.com/de-wws/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/en-mn/",           "englishlive.ef.com/en-wws/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/en-pw/",           "englishlive.ef.com/en-wws/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/en-zm/",           "englishlive.ef.com/en-wws/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/fr-dz/",           "englishlive.ef.com/fr-wws/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/fr-be/",           "englishlive.ef.com/fr-wws/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/fr-gf/",           "englishlive.ef.com/fr-wws/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/en-wws/?ctr=gs",           "englishlive.ef.com/en-wws/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/en-wws/?ctr=pl",           "englishlive.ef.com/en-wws/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/en-wws/?ctr=sk",           "englishlive.ef.com/en-wws/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/en-wws/?ctr=gb",           "englishlive.ef.com/en-wws/" );
        //
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/en-mn/contact-us/",           "englishlive.ef.com/en-wws/contact-us/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/en-zm/contact-us/",           "englishlive.ef.com/en-wws/contact-us/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/online/home.aspx?ctr=ae",           "englishlive.ef.com/ar-sa/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/online/home.aspx?ctr=kw",           "englishlive.ef.com/ar-sa/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/online/home.aspx?ctr=sa",           "englishlive.ef.com/ar-sa/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/online/home.aspx?ctr=tj",           "englishlive.ef.com/en-wws/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/online/home.aspx?ctr=at",           "englishlive.ef.com/de-wws/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/online/home.aspx?ctr=ch",           "englishlive.ef.com/de-wws/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/online/home.aspx?ctr=mn",           "englishlive.ef.com/en-wws/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/online/home.aspx?ctr=pw",           "englishlive.ef.com/en-wws/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/online/home.aspx?ctr=zm",           "englishlive.ef.com/en-wws/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/online/home.aspx?ctr=dz",           "englishlive.ef.com/ar-sa/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/online/home.aspx?ctr=be",           "englishlive.ef.com/fr-wws/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/online/home.aspx?ctr=gf",           "englishlive.ef.com/fr-wws/" );
//         // 3.2  TU, UK, RU Spain
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.ru/",                                  "englishlive.ef.com/ru-ru/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.ru/lp/os/toefl-and-toeic-01/",         "englishlive.ef.com/ru-ru/lp/os/toefl-and-toeic-01/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.ru/buy/default/member/",               "englishlive.ef.com/ru-ru/buy/default/member/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.ru/online/home.aspx",                  "englishlive.ef.com/ru-ru/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.es/",                                  "englishlive.ef.com/es-es/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.es/online/home.aspx",                  "englishlive.ef.com/es-es/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.es/lp/os/learn-english-online-01/",    "englishlive.ef.com/es-es/lp/os/learn-english-online-01/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.es/buy/default/member/",               "englishlive.ef.com/es-es/buy/default/member/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/online/home.aspx?ctr=gb",          "englishlive.ef.com/en-gb/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/en-gb/",                           "englishlive.ef.com/en-gb/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/en-gb/buy/default/member/",        "englishlive.ef.com/en-gb/buy/default/member/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/?ctr=tr",                          "englishlive.ef.com/tr-tr/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/online/home.aspx?ctr=tr",          "englishlive.ef.com/tr-tr/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/tr-tr/",                           "englishlive.ef.com/tr-tr/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/tr-tr/buy/default/member/",        "englishlive.ef.com/tr-tr/buy/default/member/" );
        //sand-2565
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/en-qp/",            "englishlive.ef.com/en-wws/") ;
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/en-co/",            "englishlive.ef.com/en-wws/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/en-pe/",            "englishlive.ef.com/en-wws/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/en-fr/",            "englishlive.ef.com/en-wws/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/en-cl/",            "englishlive.ef.com/en-wws/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/en-in/",            "englishlive.ef.com/en-wws/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/en-it/",            "englishlive.ef.com/en-wws/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/en-qm/",            "englishlive.ef.com/en-wws/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.ru/en-ru/",             "englishlive.ef.com/en-wws/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/en-yu/",            "englishlive.ef.com/en-wws/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/en-ve/",            "englishlive.ef.com/en-wws/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/en-de/",            "englishlive.ef.com/en-wws/" );
        // stage 3 . 3      27  jan
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.co.jp/",	                        "englishlive.ef.com/ja-jp/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.co.jp/lp/os/osalu-feb-50yrslp/",	"englishlive.ef.com/ja-jp/lp/os/osalu-feb-50yrslp/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.co.jp/buy/default/member/	",	    "englishlive.ef.com/ja-jp/buy/default/member/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.co.jp/online/home.aspx",	        "englishlive.ef.com/ja-jp/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/online/home.aspx?ctr=kr",	    "englishlive.ef.com/ko-kr/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/ko-kr/",	                    "englishlive.ef.com/ko-kr/");
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/ko-kr/buy/default/member/",	"englishlive.ef.com/ko-kr/buy/default/member/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/?ctr=kr",	                    "englishlive.ef.com/ko-kr/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/online/home.aspx?ctr=tw",	    "englishlive.ef.com/zh-tw/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/zh-tw/",	                    "englishlive.ef.com/zh-tw/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/zh-tw/buy/default/member/",    "englishlive.ef.com/zh-tw/buy/default/member/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/online/home.aspx?ctr=th",	    "englishlive.ef.com/th-th/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/th-th/",	                    "englishlive.ef.com/th-th/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/th-th/buy/default/member/",    "englishlive.ef.com/th-th/buy/default/member/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/online/home.aspx?ctr=id",	    "englishlive.ef.com/id-id/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/id-id/",	                    "englishlive.ef.com/id-id/" );
        REDIRECT_ELIVE_ALL_TESTS_URL.put( ".englishtown.com/id-id/buy/default/member/",	"englishlive.ef.com/id-id/buy/default/member/" );
        */
    }

    /**
     * Golf Countries: kw, qa, bh, ae, om will go to ar-wws
     We will update ar-wws to replicate ar-sa (so, turning it into an OE only “market”)
     Other MEAST countries: eg, iq, jo, lb, ly, ps, sd, sy, tj, ye will go to en-wws

     */
    public static final Map<String, String> REDIRECT_ELIVE_FULL_TEST_URLS = new LinkedHashMap<>();
    static {
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/es-mx/",                           "englishlive.ef.com/es-mx/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/?ctr=mx",                          "englishlive.ef.com/es-mx/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/online/home.aspx?ctr=mx",          "englishlive.ef.com/es-mx/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/es-mx/buy/default/member/",        "englishlive.ef.com/es-mx/buy/default/member/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.fr/",		                            "englishlive.ef.com/fr-fr/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.fr/lp/oe/anglais-des-affaires/",		"englishlive.ef.com/fr-fr/lp/oe/anglais-des-affaires/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.fr/buy/default/member/",		        "englishlive.ef.com/fr-fr/buy/default/member/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.fr/online/home.aspx",                  "englishlive.ef.com/fr-fr/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.de/",		                            "englishlive.ef.com/de-de/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.de/online/home.aspx",		            "englishlive.ef.com/de-de/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.de/lp/os/englisch-lernen/",		    "englishlive.ef.com/de-de/lp/os/englisch-lernen/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.de/buy/default/member/",		        "englishlive.ef.com/de-de/buy/default/member/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.it/",		                            "englishlive.ef.com/it-it/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.it/online/home.aspx",                  "englishlive.ef.com/it-it/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.it/buy/default/member/",		        "englishlive.ef.com/it-it/buy/default/member/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/ar-sa/",		                    "englishlive.ef.com/ar-sa/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/online/home.aspx?ctr=sa",		    "englishlive.ef.com/ar-sa/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/ar-sa/buy/default/member/",		"englishlive.ef.com/ar-sa/buy/default/member/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/?ctr=eg",		                    "englishlive.ef.com/en-wws/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/ar-wws/?ctr=eg",		            "englishlive.ef.com/en-wws/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/ar-wws/buy/default/member/?ctr=eg","englishlive.ef.com/ar-wws/buy/default/member/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/?ctr=am",		                    "englishlive.ef.com/en-wws/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/en-wws/?ctr=am",		            "englishlive.ef.com/en-wws/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/en-wws/buy/default/member/?ctr=am","englishlive.ef.com/en-wws/buy/default/member/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/?ctr=pf",		                    "englishlive.ef.com/fr-wws/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/fr-wws/?ctr=pf",		            "englishlive.ef.com/fr-wws/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/fr-wws/buy/default/member/?ctr=pf","englishlive.ef.com/fr-wws/buy/default/member/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/?ctr=at",		                    "englishlive.ef.com/de-wws/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/de-wws/?ctr=at",		            "englishlive.ef.com/de-wws/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/de-wws/buy/default/member/?ctr=pf","englishlive.ef.com/de-wws/buy/default/member/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/es-wws/?ctr=ni",                   "englishlive.ef.com/es-wws/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/?ctr=ni",                          "englishlive.ef.com/es-wws/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/es-us/",           "englishlive.ef.com/es-us/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/en-us/",           "englishlive.ef.com/en-us/" );
        // Fantastic 4  F4  cl|co|ve|pe go to eLive
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/es-cl/",           "englishlive.ef.com/es-cl/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/es-co/",           "englishlive.ef.com/es-co/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/es-ve/",           "englishlive.ef.com/es-ve/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/es-pe/",           "englishlive.ef.com/es-pe/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/?ctr=cl",           "englishlive.ef.com/es-cl/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/?ctr=co",           "englishlive.ef.com/es-co/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/?ctr=ve",           "englishlive.ef.com/es-ve/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/?ctr=pe",           "englishlive.ef.com/es-pe/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/online/home.aspx?ctr=cl",           "englishlive.ef.com/es-cl/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/online/home.aspx?ctr=co",           "englishlive.ef.com/es-co/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/online/home.aspx?ctr=ve",           "englishlive.ef.com/es-ve/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/online/home.aspx?ctr=pe",           "englishlive.ef.com/es-pe/" );
        // these go to etown
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/community/Channels/article.aspx?articleName=102-eatout&ctr=cl",           ".englishtown.com/community/channels/article.aspx?articlename=102-eatout"); //".englishtown.com/blog/7-english-phrases-need-know-eating/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/community/Channels/article.aspx?articleName=102-eatout&ctr=co",           ".englishtown.com/community/channels/article.aspx?articlename=102-eatout"); //".englishtown.com/blog/7-english-phrases-need-know-eating/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/community/Channels/article.aspx?articleName=102-eatout&ctr=ve",           ".englishtown.com/community/channels/article.aspx?articlename=102-eatout"); //".englishtown.com/blog/7-english-phrases-need-know-eating/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/community/Channels/article.aspx?articleName=102-eatout&ctr=pe",           ".englishtown.com/community/channels/article.aspx?articlename=102-eatout"); //".englishtown.com/blog/7-english-phrases-need-know-eating/" );
        //
        // other Rola es Spanish speaking group (ar|bo|cr|cu|do|ec|gt|hn|ni|pa|pr|py|sv|uy) go to eLive
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/?ctr=ar",           "englishlive.ef.com/es-mx/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/es-ar/",            "englishlive.ef.com/es-mx/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/online/home.aspx?ctr=ar",           "englishlive.ef.com/es-wws/" );
        // these go to etown
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/community/Channels/article.aspx?articleName=102-eatout&ctr=ar",           ".englishtown.com/community/channels/article.aspx?articlename=102-eatout"); //".englishtown.com/blog/7-english-phrases-need-know-eating/" );
        //
        //Other Rola English speaking group (ag|ai|aw|bb|bz||ht|kn|ky|lc|tt|vc|vg|vi).  go to eTown
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/?ctr=ag",           "englishlive.ef.com/en-wws/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/?ctr=lc",           "englishlive.ef.com/en-wws/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/?ctr=vc",           "englishlive.ef.com/en-wws/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/en-ag/",            "englishlive.ef.com/en-wws/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/en-lc/",            "englishlive.ef.com/en-wws/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/en-vc/",            "englishlive.ef.com/en-wws/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/en-vc/contact-us/",        "englishlive.ef.com/en-wws/contact-us/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/online/home.aspx?ctr=ag",           "englishlive.ef.com/en-wws/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/online/home.aspx?ctr=lc",           "englishlive.ef.com/en-wws/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/online/home.aspx?ctr=vc",           "englishlive.ef.com/en-wws/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/online/your-teachers.aspx?ctr=ag",       "englishlive.ef.com/en-wws/teachers-and-students/teachers/"); // ".englishtown.com/en-wws/profesores-y-estudiantes/profesores-de-ingles/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/online/your-teachers.aspx?ctr=lc",       "englishlive.ef.com/en-wws/teachers-and-students/teachers/");
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/online/your-teachers.aspx?ctr=vc",       "englishlive.ef.com/en-wws/teachers-and-students/teachers/");
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/en-ag/como-aprender-ingles/escuela-de-ingles/",           "englishlive.ef.com/en-wws/como-aprender-ingles/escuela-de-ingles/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/en-lc/como-aprender-ingles/escuela-de-ingles/",           "englishlive.ef.com/en-wws/como-aprender-ingles/escuela-de-ingles/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/en-vc/como-aprender-ingles/escuela-de-ingles/",           "englishlive.ef.com/en-wws/como-aprender-ingles/escuela-de-ingles/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/es-lc/como-aprender-ingles/escuela-de-ingles/",           "englishlive.ef.com/es-mx/como-aprender-ingles/escuela-de-ingles/" );
        // others
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/?ctr=ae",           "englishlive.ef.com/ar-wws/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/?ctr=kw",           "englishlive.ef.com/ar-wws/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/?ctr=sa",           "englishlive.ef.com/ar-sa/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/?ctr=tj",           "englishlive.ef.com/en-wws/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/?ctr=at",           "englishlive.ef.com/de-wws/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/?ctr=ch",           "englishlive.ef.com/de-wws/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/?ctr=mn",           "englishlive.ef.com/en-wws/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/?ctr=pw",           "englishlive.ef.com/en-wws/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/?ctr=zm",           "englishlive.ef.com/en-wws/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/?ctr=dz",           "englishlive.ef.com/fr-wws/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/?ctr=be",           "englishlive.ef.com/fr-wws/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/?ctr=gf",           "englishlive.ef.com/fr-wws/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/?ctr=tn",           "englishlive.ef.com/fr-wws/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/ar-ae/",           "englishlive.ef.com/ar-wws/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/ar-kw/",           "englishlive.ef.com/ar-wws/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/ar-tj/",           "englishlive.ef.com/ar-wws/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/de-at/",           "englishlive.ef.com/de-wws/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/de-ch/",           "englishlive.ef.com/de-wws/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/en-mn/",           "englishlive.ef.com/en-wws/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/en-pw/",           "englishlive.ef.com/en-wws/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/en-zm/",           "englishlive.ef.com/en-wws/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/fr-dz/",           "englishlive.ef.com/fr-wws/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/fr-be/",           "englishlive.ef.com/fr-wws/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/fr-gf/",           "englishlive.ef.com/fr-wws/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/fr-tn/",           "englishlive.ef.com/fr-wws/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/es-wws/?ctr=gb",           "englishlive.ef.com/es-wws/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/en-wws/?ctr=gs",           "englishlive.ef.com/en-wws/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/en-wws/?ctr=pl",           "englishlive.ef.com/en-wws/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/en-wws/?ctr=sk",           "englishlive.ef.com/en-wws/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/en-wws/?ctr=gb",           "englishlive.ef.com/en-wws/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/en-mn/contact-us/",           "englishlive.ef.com/en-wws/contact-us/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/en-zm/contact-us/",           "englishlive.ef.com/en-wws/contact-us/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/online/home.aspx?ctr=ae",           "englishlive.ef.com/ar-wws/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/online/home.aspx?ctr=kw",           "englishlive.ef.com/ar-wws/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/online/home.aspx?ctr=sa",           "englishlive.ef.com/ar-sa/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/online/home.aspx?ctr=tj",           "englishlive.ef.com/en-wws/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/online/home.aspx?ctr=at",           "englishlive.ef.com/de-wws/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/online/home.aspx?ctr=ch",           "englishlive.ef.com/de-wws/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/online/home.aspx?ctr=mn",           "englishlive.ef.com/en-wws/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/online/home.aspx?ctr=pw",           "englishlive.ef.com/en-wws/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/online/home.aspx?ctr=zm",           "englishlive.ef.com/en-wws/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/online/home.aspx?ctr=dz",           "englishlive.ef.com/fr-wws/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/online/home.aspx?ctr=be",           "englishlive.ef.com/fr-wws/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/online/home.aspx?ctr=gf",           "englishlive.ef.com/fr-wws/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/online/home.aspx?ctr=tn",           "englishlive.ef.com/fr-wws/" );
//         // 3.2  TU, UK, RU Spain
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.ru/",                                  "englishlive.ef.com/ru-ru/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.ru/lp/os/toefl-and-toeic-01/",         "englishlive.ef.com/ru-ru/lp/os/toefl-and-toeic-01/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.ru/buy/default/member/",               "englishlive.ef.com/ru-ru/buy/default/member/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.ru/online/home.aspx",                  "englishlive.ef.com/ru-ru/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.es/",                                  "englishlive.ef.com/es-es/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.es/online/home.aspx",                  "englishlive.ef.com/es-es/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.es/lp/os/learn-english-online-01/",    "englishlive.ef.com/es-es/lp/os/learn-english-online-01/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.es/buy/default/member/",               "englishlive.ef.com/es-es/buy/default/member/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/online/home.aspx?ctr=gb",          "englishlive.ef.com/en-gb/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/en-gb/",                           "englishlive.ef.com/en-gb/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/en-gb/buy/default/member/",        "englishlive.ef.com/en-gb/buy/default/member/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/?ctr=tr",                          "englishlive.ef.com/tr-tr/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/online/home.aspx?ctr=tr",          "englishlive.ef.com/tr-tr/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/tr-tr/",                           "englishlive.ef.com/tr-tr/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/tr-tr/buy/default/member/",        "englishlive.ef.com/tr-tr/buy/default/member/" );
        //sand-2565
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/en-qp/",            "englishlive.ef.com/en-wws/") ;
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/en-co/",            "englishlive.ef.com/en-wws/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/en-pe/",            "englishlive.ef.com/en-wws/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/en-fr/",            "englishlive.ef.com/en-wws/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/en-sa/",            "englishlive.ef.com/en-wws/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/en-cl/",            "englishlive.ef.com/en-wws/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/en-in/",            "englishlive.ef.com/en-wws/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/en-it/",            "englishlive.ef.com/en-wws/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/en-qm/",            "englishlive.ef.com/en-wws/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.ru/en-ru/",             "englishlive.ef.com/en-wws/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/en-yu/",            "englishlive.ef.com/en-wws/" );

        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/en-ve/",            "englishlive.ef.com/en-wws/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/en-de/",            "englishlive.ef.com/en-wws/" );
        // stage 3 . 3      27  jan
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.co.jp/",	                        "englishlive.ef.com/ja-jp/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.co.jp/lp/os/osalu-feb-50yrslp/",	"englishlive.ef.com/ja-jp/lp/os/osalu-feb-50yrslp/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.co.jp/buy/default/member/	",	    "englishlive.ef.com/ja-jp/buy/default/member/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.co.jp/online/home.aspx",	        "englishlive.ef.com/ja-jp/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/online/home.aspx?ctr=kr",	    "englishlive.ef.com/ko-kr/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/ko-kr/",	                    "englishlive.ef.com/ko-kr/");
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/ko-kr/buy/default/member/",	"englishlive.ef.com/ko-kr/buy/default/member/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/?ctr=kr",	                    "englishlive.ef.com/ko-kr/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/online/home.aspx?ctr=tw",	    "englishlive.ef.com/zh-tw/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/zh-tw/",	                    "englishlive.ef.com/zh-tw/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/zh-tw/buy/default/member/",    "englishlive.ef.com/zh-tw/buy/default/member/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/online/home.aspx?ctr=th",	    "englishlive.ef.com/th-th/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/th-th/",	                    "englishlive.ef.com/th-th/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/th-th/buy/default/member/",    "englishlive.ef.com/th-th/buy/default/member/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/online/home.aspx?ctr=id",	    "englishlive.ef.com/id-id/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/id-id/",	                    "englishlive.ef.com/id-id/" );
        REDIRECT_ELIVE_FULL_TEST_URLS.put( ".englishtown.com/id-id/buy/default/member/",	"englishlive.ef.com/id-id/buy/default/member/" );
    }

    // br   https://jira-bos.englishtown.com/browse/SAND-3149
    public static final Map<String, String> BR_REDIRECT_ELIVE_URL = new LinkedHashMap<>();
    static {
        /*BR_REDIRECT_ELIVE_URL.put(".englishtown.com.br/",		                                    "englishlive.ef.com/pt-br/");
        BR_REDIRECT_ELIVE_URL.put(".englishtown.com.br/robots.txt",		                            ".englishtown.com.br/robots.txt");
        BR_REDIRECT_ELIVE_URL.put(".englishtown.com.br/modulos-dos-cursos-de-ingles-online/",		"englishlive.ef.com/pt-br/modulos-dos-cursos-de-ingles-online/");
        BR_REDIRECT_ELIVE_URL.put(".englishtown.com.br/professores-e-alunos/professores-de-ingles/","englishlive.ef.com/pt-br/professores-e-alunos/professores-de-ingles/");
        BR_REDIRECT_ELIVE_URL.put(".englishtown.com.br/lp/oe/branding/",		                    ".englishtown.com.br/lp/oe/branding/");
        BR_REDIRECT_ELIVE_URL.put(".englishtown.com.br/lp/ee/ee16a/",		            ".englishtown.com.br/lp/ee/ee16a/");
        BR_REDIRECT_ELIVE_URL.put(".englishtown.com.br/abc",		                    "englishlive.ef.com/checkout/redemption/index?dom=");
        BR_REDIRECT_ELIVE_URL.put(".englishtown.com.br/checkout/",		                "englishlive.ef.com/checkout/member/index");*/
        BR_REDIRECT_ELIVE_URL.put("englishlive.ef.com/checkout/?ctr=br",                "englishlive.ef.com/checkout/member/index");
        BR_REDIRECT_ELIVE_URL.put("englishlive.ef.com/pt-br/lp/ee/ee16a/",		        "englishlive.ef.com/pt-br/lp/ee/ee16a/");
        BR_REDIRECT_ELIVE_URL.put("englishlive.ef.com/pt-br/",		                    "englishlive.ef.com/pt-br/");
        BR_REDIRECT_ELIVE_URL.put("englishlive.ef.com/pt-br/aprender-ingles/life-club/","englishlive.ef.com/pt-br/aprender-ingles/life-club/");
       /* BR_REDIRECT_ELIVE_URL.put(".englishtown.com.br/online/home.aspx",		    "englishlive.ef.com/pt-br/");
        BR_REDIRECT_ELIVE_URL.put(".englishtown.com.br/community/Channels/article.aspx?articleName=101-dontsay",   "englishlive.ef.com/pt-br/blog/perguntas-e-respostas-entrevistas-em-ingles/");
        */BR_REDIRECT_ELIVE_URL.put("englishlive.ef.com/?ctr=br",		                    "englishlive.ef.com/pt-br/");
        /* live only test .... need to change host file for qa ... BR_REDIRECT_ELIVE_URL.put("englishlive.com.br", "englishlive.ef.com/pt-br/");
        BR_REDIRECT_ELIVE_URL.put("englishlive.com.br/planos-e-precos-dos-cursos-de-ingles/","englishlive.ef.com/pt-br/planos-e-precos-dos-cursos-de-ingles/"); */
    }

    //eLive
    public static final Map<String, String> REDIRECT_ALL_MOBILE_URL = new HashMap<>();
    static {
        REDIRECT_ALL_MOBILE_URL.put("englishlive.ef.com/it-it/",    "englishlive.ef.com/it-it/home-mobile/") ;
      /*  REDIRECT_ALL_MOBILE_URL.put("englishlive.ef.com/de-de/",    "englishlive.ef.com/de-de/home-mobile/") ;
        REDIRECT_ALL_MOBILE_URL.put("englishlive.ef.com/fr-fr/",    "englishlive.ef.com/fr-fr/home-mobile/") ;
        //englishlive
        REDIRECT_ALL_MOBILE_URL.put("englishlive.ef.com/?ctr=gb",    "englishlive.ef.com/en-gb/home-mobile/") ;
        REDIRECT_ALL_MOBILE_URL.put("englishlive.ef.com/?ctr=tr",    "englishlive.ef.com/tr-tr/home-mobile/") ;
        REDIRECT_ALL_MOBILE_URL.put("englishlive.ef.com/?ctr=sa",    "englishlive.ef.com/ar-sa/home-mobile/") ;
        REDIRECT_ALL_MOBILE_URL.put("englishlive.ef.com/en-us/",    "englishlive.ef.com/en-us/home-mobile/") ;
        REDIRECT_ALL_MOBILE_URL.put("englishlive.ef.com/es-us/",    "englishlive.ef.com/es-us/home-mobile/") ;
        // on the 9th Dec 2015
        REDIRECT_ALL_MOBILE_URL.put("englishlive.ef.com/ru-ru/",    "englishlive.ef.com/ru-ru/home-mobile/") ;
        REDIRECT_ALL_MOBILE_URL.put("englishlive.ef.com/?ctr=at",    "englishlive.ef.com/de-wws/home-mobile/") ;
        // stage 3.3  27 Jan
        REDIRECT_ALL_MOBILE_URL.put("englishlive.ef.com/ja-jp/home-mobile/",     "englishlive.ef.com/ja-jp/home-mobile/");
        REDIRECT_ALL_MOBILE_URL.put("englishlive.ef.com/zh-tw/home-mobile/", "englishlive.ef.com/zh-tw/home-mobile/");
        // englishtown
        REDIRECT_ALL_MOBILE_URL.put(".englishtown.com/?ctr=gb",    "englishlive.ef.com/en-gb/home-mobile/") ;
        REDIRECT_ALL_MOBILE_URL.put(".englishtown.com/ar-sa/",     "englishlive.ef.com/ar-sa/home-mobile/") ;
      /*  REDIRECT_ALL_MOBILE_URL.put("englishlive.ef.com/?ctr=ae",    "englishlive.ef.com/ar-wws/home-mobile/") ;
        REDIRECT_ALL_MOBILE_URL.put("englishlive.ef.com/?ctr=ps",    "englishlive.ef.com/ar-wws/home-mobile/") ;
        REDIRECT_ALL_MOBILE_URL.put("englishlive.ef.com/en-gb/",     "englishlive.ef.com/en-gb/home-mobile/") ;
        REDIRECT_ALL_MOBILE_URL.put("englishlive.ef.com/tr-tr/",     "englishlive.ef.com/tr-tr/home-mobile/") ;
        REDIRECT_ALL_MOBILE_URL.put("englishlive.ef.com/ar-sa/",     "englishlive.ef.com/ar-sa/home-mobile/") ;
        REDIRECT_ALL_MOBILE_URL.put("englishlive.ef.com/ar-ae/",     "englishlive.ef.com/ar-wws/home-mobile/") ;
        REDIRECT_ALL_MOBILE_URL.put("englishlive.ef.com/ar-ps/",     "englishlive.ef.com/ar-wws/home-mobile/") ;
        REDIRECT_ALL_MOBILE_URL.put("englishlive.ef.com/ar-wws/?ctr=ae",    "englishlive.ef.com/ar-wws/home-mobile/") ;
        REDIRECT_ALL_MOBILE_URL.put("englishlive.ef.com/ar-wws/?ctr=ps",    "englishlive.ef.com/ar-wws/home-mobile/") ;
        REDIRECT_ALL_MOBILE_URL.put("englishlive.ef.com/?ctr=us",   "englishlive.ef.com/en-us/home-mobile/") ;
       */
       /* REDIRECT_ALL_MOBILE_URL.put("englishlive.ef.com/es-es/",    "englishlive.ef.com/es-es/home-mobile/") ;
        REDIRECT_ALL_MOBILE_URL.put("englishlive.ef.com/en-vi/",    "englishlive.ef.com/en-wws/home-mobile/") ;
        REDIRECT_ALL_MOBILE_URL.put("englishlive.ef.com/zh-tw/",    "englishlive.ef.com/zh-tw/home-mobile/") ;
        REDIRECT_ALL_MOBILE_URL.put("englishlive.ef.com/?ctr=be",    "englishlive.ef.com/fr-wws/home-mobile/") ;
        */
        // englishtown
       /* REDIRECT_ALL_MOBILE_URL.put(".englishtown.com/?ctr=tr",    "englishlive.ef.com/tr-tr/home-mobile/") ;
        REDIRECT_ALL_MOBILE_URL.put(".englishtown.com/?ctr=sa",    "englishlive.ef.com/ar-sa/home-mobile/") ;
        REDIRECT_ALL_MOBILE_URL.put(".englishtown.com/?ctr=ae",    "englishlive.ef.com/ar-wws/home-mobile/") ;
        REDIRECT_ALL_MOBILE_URL.put(".englishtown.com/?ctr=ps",    "englishlive.ef.com/ar-wws/home-mobile/") ;
        REDIRECT_ALL_MOBILE_URL.put(".englishtown.com/en-gb/",     "englishlive.ef.com/en-gb/home-mobile/") ;
        REDIRECT_ALL_MOBILE_URL.put(".englishtown.com/tr-tr/",     "englishlive.ef.com/tr-tr/home-mobile/") ;*/

       /* REDIRECT_ALL_MOBILE_URL.put(".englishtown.com/ar-ae/",     "englishlive.ef.com/ar-wws/home-mobile/") ;
        REDIRECT_ALL_MOBILE_URL.put(".englishtown.com/ar-ps/",     "englishlive.ef.com/ar-wws/home-mobile/") ;
        REDIRECT_ALL_MOBILE_URL.put(".englishtown.com/ar-wws/?ctr=ae",    "englishlive.ef.com/ar-wws/home-mobile/") ;
        REDIRECT_ALL_MOBILE_URL.put(".englishtown.com/ar-wws/?ctr=ps",    "englishlive.ef.com/ar-wws/home-mobile/") ;
        REDIRECT_ALL_MOBILE_URL.put(".englishtown.com/?ctr=us",   "englishlive.ef.com/en-us/home-mobile/") ;
        REDIRECT_ALL_MOBILE_URL.put(".englishtown.com/en-us/",    "englishlive.ef.com/en-us/home-mobile/") ;
        REDIRECT_ALL_MOBILE_URL.put(".englishtown.com/es-us/",    "englishlive.ef.com/es-us/home-mobile/") ;
        // on the 9th Dec 2015
        REDIRECT_ALL_MOBILE_URL.put(".englishtown.com/ru-ru/",    "englishlive.ef.com/ru-ru/home-mobile/") ;
        REDIRECT_ALL_MOBILE_URL.put(".englishtown.com/es-es/",    "englishlive.ef.com/es-es/home-mobile/") ;
        REDIRECT_ALL_MOBILE_URL.put(".englishtown.com/en-vi/",    "englishlive.ef.com/en-wws/home-mobile/") ;
        REDIRECT_ALL_MOBILE_URL.put(".englishtown.com/zh-tw/",    "englishlive.ef.com/zh-tw/home-mobile/") ;
        REDIRECT_ALL_MOBILE_URL.put(".englishtown.com/?ctr=be",    "englishlive.ef.com/fr-wws/home-mobile/") ;
        REDIRECT_ALL_MOBILE_URL.put(".englishtown.com/?ctr=at",    "englishlive.ef.com/de-wws/home-mobile/") ;
        // stage 3.3  27 Jan
        REDIRECT_ALL_MOBILE_URL.put(".englishtown.co.jp/home-mobile/",     "englishlive.ef.com/ja-jp/home-mobile/");
        REDIRECT_ALL_MOBILE_URL.put(".englishtown.com/zh-tw/home-mobile/", "englishlive.ef.com/zh-tw/home-mobile/");
        //EC SET
        REDIRECT_ALL_MOBILE_URL.put("englishcenters.ef.com/",					"englishcenters.ef.com/home-mobile/");
        REDIRECT_ALL_MOBILE_URL.put("englishcenters.ef.com/nosotros/",			"englishcenters.ef.com/home-mobile/");
        REDIRECT_ALL_MOBILE_URL.put("englishcenters.ef.com/profesores/",		"englishcenters.ef.com/home-mobile/");
        REDIRECT_ALL_MOBILE_URL.put("englishcenters.ef.com/estudiantes/",		"englishcenters.ef.com/home-mobile/");
        REDIRECT_ALL_MOBILE_URL.put("englishcenters.ef.com/metodo/",			"englishcenters.ef.com/home-mobile/");
        REDIRECT_ALL_MOBILE_URL.put("englishcenters.ef.com/madrid/",			"englishcenters.ef.com/home-mobile/");
        // TODO retest not working REDIRECT_ALL_MOBILE_URL.put("englishcenters.ef.com/barccelona/",		"englishcenters.ef.com/home-mobile/");
        REDIRECT_ALL_MOBILE_URL.put("englishcenters.ef.com/promociones/",		"englishcenters.ef.com/home-mobile/");
        REDIRECT_ALL_MOBILE_URL.put("englishcenters.ef.com/centers/",			 "englishcenters.ef.com/home-mobile/");
        */
    }

    // Rola URL list map
    public static final Map<String, String> ROLA_URL_LIST_MAP = new HashMap<>();
    static {
        ROLA_URL_LIST_MAP.put("englishlive.ef.com/es-co/ ",										" home page");
        ROLA_URL_LIST_MAP.put("englishlive.ef.com/es-co/como-aprender-ingles/",                                                   	" HOW IT WORKS Main menu");
        ROLA_URL_LIST_MAP.put("englishlive.ef.com/es-co/como-aprender-ingles/clases-de-ingles/",                                  	" Teachers led Classes");
        ROLA_URL_LIST_MAP.put("englishlive.ef.com/es-co/como-aprender-ingles/escuela-de-ingles/lecciones-y-niveles-de-ingles/",   	" Lessons and levels");
        ROLA_URL_LIST_MAP.put("englishlive.ef.com/es-co/como-aprender-ingles/diploma-de-ingles/",                                 	" Your Results and certificates");
        ROLA_URL_LIST_MAP.put("englishlive.ef.com/es-co/como-aprender-ingles/app-aprender-ingles/",                               	" app EF");
        ROLA_URL_LIST_MAP.put("englishlive.ef.com/es-co/cursos-ingles/",                                                          	" ONLINE ENGLISH COURSES Main menu");
        ROLA_URL_LIST_MAP.put("englishlive.ef.com/es-co/como-aprender-ingles/escuela-de-ingles/",                                 	" General English");
        ROLA_URL_LIST_MAP.put("englishlive.ef.com/es-co/cursos-ingles/examen-toefl/",                                             	" TOEFL Preparation");
        ROLA_URL_LIST_MAP.put("englishlive.ef.com/es-co/cursos-ingles/examen-toeic/",                                             	" TOEIC Preparation");
        ROLA_URL_LIST_MAP.put("englishlive.ef.com/es-co/cursos-ingles/ingles-negocios/",                                          	" Business English");
        ROLA_URL_LIST_MAP.put("englishlive.ef.com/es-co/cursos-ingles/cursos-especializados/",                                    	" Job Specification English courses");
        ROLA_URL_LIST_MAP.put("englishlive.ef.com/es-co/cursos-ingles/ingles-para-viajes/",                                       	" Travel English        ");
        ROLA_URL_LIST_MAP.put("englishlive.ef.com/es-co/profesores-y-estudiantes/",                                               	" OUR TEACHERS AND STUDENTS Main Menu");
        ROLA_URL_LIST_MAP.put("englishlive.ef.com/es-co/profesores-y-estudiantes/profesores-de-ingles/",                          	" Our Teachers");
        ROLA_URL_LIST_MAP.put("englishlive.ef.com/es-co/profesores-y-estudiantes/estudiantes/",                                   	" Our Student");
        ROLA_URL_LIST_MAP.put("englishlive.ef.com/es-co/oe-free-consultation/",                                                   	" 14 Day Trial link, button Free consultation");
        ROLA_URL_LIST_MAP.put("englishlive.ef.com/es-co/lp/ty/latam-ty/",                                                	        " Submit Free consultation form, this is the latam-TY page shown");
        ROLA_URL_LIST_MAP.put("englishlive.ef.com/es-co/nosotros/",                                                               	" FOOTER ABOUT US");
        ROLA_URL_LIST_MAP.put("englishlive.ef.com/es-co/ayuda/",                                                                  	" FOOTER HELP");
        ROLA_URL_LIST_MAP.put("englishlive.ef.com/es-co/contacto/",                                                               	" FOOTER CONTACT US");
        ROLA_URL_LIST_MAP.put("englishlive.ef.com/es-co/terminos-y-condiciones/",                                                 	" FOOTER TERMS & CONDITIONS");
        ROLA_URL_LIST_MAP.put("englishlive.ef.com/es-co/politica-de-privacidad/",                                                 	" FOOTER PRIVACY POLICY");
    }
    // MX
    public static final Map<String, String> MX_URL_LIST_MAP = new HashMap<>();
    static {
        MX_URL_LIST_MAP.put("englishlive.ef.com/es-mx/ ",										" home page");
        MX_URL_LIST_MAP.put("englishlive.ef.com/es-mx/nosotros/",                                                   	" HOW IT WORKS Main menu");
        MX_URL_LIST_MAP.put("englishlive.ef.com/es-mx/como-aprender-ingles/clases-de-ingles/",                                  	" Teachers led Classes");
        MX_URL_LIST_MAP.put("englishlive.ef.com/es-mx/como-aprender-ingles/escuela-de-ingles/lecciones-y-niveles-de-ingles/",   	" Lessons and levels");
        MX_URL_LIST_MAP.put("englishlive.ef.com/es-mx/como-aprender-ingles/diploma-de-ingles/",                                 	" Your Results and certificates");
        MX_URL_LIST_MAP.put("englishlive.ef.com/es-mx/como-aprender-ingles/app-aprender-ingles/",                               	" app EF");
        MX_URL_LIST_MAP.put("englishlive.ef.com/es-mx/cursos-ingles/",                                                          	" ONLINE ENGLISH COURSES Main menu");
        MX_URL_LIST_MAP.put("englishlive.ef.com/es-mx/como-aprender-ingles/escuela-de-ingles/",                                 	" General English");
        MX_URL_LIST_MAP.put("englishlive.ef.com/es-mx/cursos-ingles/examen-toefl/",                                             	" TOEFL Preparation");
        MX_URL_LIST_MAP.put("englishlive.ef.com/es-mx/cursos-ingles/examen-toeic/",                                             	" TOEIC Preparation");
        MX_URL_LIST_MAP.put("englishlive.ef.com/es-mx/cursos-ingles/ingles-negocios/",                                          	" Business English");
        MX_URL_LIST_MAP.put("englishlive.ef.com/es-mx/cursos-ingles/cursos-especializados/",                                    	" Job Specification English courses");
        MX_URL_LIST_MAP.put("englishlive.ef.com/es-mx/cursos-ingles/ingles-para-viajes/",                                       	" Travel English        ");
        MX_URL_LIST_MAP.put("englishlive.ef.com/es-mx/profesores-y-estudiantes/",                                               	" OUR TEACHERS AND STUDENTS Main Menu");
        MX_URL_LIST_MAP.put("englishlive.ef.com/es-mx/profesores-y-estudiantes/profesores-de-ingles/",                          	" Our Teachers");
        MX_URL_LIST_MAP.put("englishlive.ef.com/es-mx/profesores-y-estudiantes/estudiantes/",                                   	" Our Student");
        MX_URL_LIST_MAP.put("englishlive.ef.com/es-mx/oe-free-consultation/",                                                   	" 14 Day Trial link, button Free consultation");
        MX_URL_LIST_MAP.put("englishlive.ef.com/es-mx/lp/ty/latam-ty/",                                                	        " Submit Free consultation form, this is the latam-TY page shown");
        MX_URL_LIST_MAP.put("englishlive.ef.com/es-mx/nosotros/",                                                               	" FOOTER ABOUT US");
        MX_URL_LIST_MAP.put("englishlive.ef.com/es-mx/ayuda/",                                                                  	" FOOTER HELP");
        MX_URL_LIST_MAP.put("englishlive.ef.com/es-mx/contacto/",                                                               	" FOOTER CONTACT US");
        MX_URL_LIST_MAP.put("englishlive.ef.com/es-mx/terminos-y-condiciones/",                                                 	" FOOTER TERMS & CONDITIONS");
        MX_URL_LIST_MAP.put("englishlive.ef.com/es-mx/politica-de-privacidad/",                                                 	" FOOTER PRIVACY POLICY");
    }

    //TW
    public static final Map<String, String> TW_REDIRECT__URL = new LinkedHashMap<>();
    static {
        TW_REDIRECT__URL.put("englishlive.ef.com/zh-tw/lp/oe/biggest_online_2016_01_11/?ptn=gotw&etag=GOTW_Contextual_schoolteacher_ad-copy_214", "englishlive.ef.com/zh-tw/lp/oe/biggest_online_2016_01_11/");
        TW_REDIRECT__URL.put("englishlive.ef.com/zh-tw/lp/oe/cnn_2016_01_02/?ptn=gotw&etag=GOTW_Interest-new_English-Skills-Listening/Speaking_{keyword}_190", "englishlive.ef.com/zh-tw/lp/oe/cnn_2016_01_02/");
        TW_REDIRECT__URL.put("englishlive.ef.com/zh-tw/lp/oe/native_teacher_2016_01_19_0/?ptn=gotw&etag=GOTW_Cultivation-FreeApproach-new_Email-English_{keyword}_175", "englishlive.ef.com/zh-tw/lp/oe/native_teacher_2016_01_19_0/");
    }


    // no domain and country
    public static final Map<String, String> ALL_LINKS_URL_LIST_MAP = new LinkedHashMap<>();
    static {
        ALL_LINKS_URL_LIST_MAP.put("",									                                        " home page");
        ALL_LINKS_URL_LIST_MAP.put("como-aprender-ingles/",                                                   	" HOW IT WORKS Main menu");
        ALL_LINKS_URL_LIST_MAP.put("como-aprender-ingles/clases-de-ingles/",                                  	" Teachers led Classes");
        ALL_LINKS_URL_LIST_MAP.put("como-aprender-ingles/escuela-de-ingles/lecciones-y-niveles-de-ingles/",   	" Lessons and levels");
        ALL_LINKS_URL_LIST_MAP.put("como-aprender-ingles/diploma-de-ingles/",                                 	" Your Results and certificates");
        ALL_LINKS_URL_LIST_MAP.put("como-aprender-ingles/app-aprender-ingles/",                               	" app EF");
        ALL_LINKS_URL_LIST_MAP.put("cursos-ingles/",                                                          	" ONLINE ENGLISH COURSES Main menu");
        ALL_LINKS_URL_LIST_MAP.put("como-aprender-ingles/escuela-de-ingles/",                                 	" General English");
        ALL_LINKS_URL_LIST_MAP.put("cursos-ingles/examen-toefl/",                                             	" TOEFL Preparation");
        ALL_LINKS_URL_LIST_MAP.put("cursos-ingles/examen-toeic/",                                             	" TOEIC Preparation");
        ALL_LINKS_URL_LIST_MAP.put("cursos-ingles/ingles-negocios/",                                          	" Business English");
        ALL_LINKS_URL_LIST_MAP.put("cursos-ingles/cursos-especializados/",                                    	" Job Specification English courses");
        ALL_LINKS_URL_LIST_MAP.put("cursos-ingles/ingles-para-viajes/",                                       	" Travel English        ");
        ALL_LINKS_URL_LIST_MAP.put("profesores-y-estudiantes/",                                               	" OUR TEACHERS AND STUDENTS Main Menu");
        ALL_LINKS_URL_LIST_MAP.put("profesores-y-estudiantes/profesores-de-ingles/",                          	" Our Teachers");
        ALL_LINKS_URL_LIST_MAP.put("profesores-y-estudiantes/estudiantes/",                                   	" Our Student");
        ALL_LINKS_URL_LIST_MAP.put("oe-free-consultation/",                                                   	" 14 Day Trial link, button Free consultation");
        ALL_LINKS_URL_LIST_MAP.put("lp/ty/latam-ty/",                                                	        " Submit Free consultation form, this is the latam-TY page shown");
        ALL_LINKS_URL_LIST_MAP.put("nosotros/",                                                               	" FOOTER ABOUT US");
        ALL_LINKS_URL_LIST_MAP.put("ayuda/",                                                                  	" FOOTER HELP");
        ALL_LINKS_URL_LIST_MAP.put("contacto/",                                                               	" FOOTER CONTACT US");
        ALL_LINKS_URL_LIST_MAP.put("terminos-y-condiciones/",                                                 	" FOOTER TERMS & CONDITIONS");
        ALL_LINKS_URL_LIST_MAP.put("politica-de-privacidad/",                                                 	" FOOTER PRIVACY POLICY");
    }
    // list of links on the tabs/menus on the website -> ES language
    public static String [] allRolaUrlsList = {
            //home page
            "englishlive.ef.com/es-co/ ",
            //HOW IT WORKS
            "englishlive.ef.com/es-co/como-aprender-ingles/",                                                   // Main page for this menu
            "englishlive.ef.com/es-co/como-aprender-ingles/clases-de-ingles/",                                  // Teachers led Classes
            "englishlive.ef.com/es-co/como-aprender-ingles/escuela-de-ingles/lecciones-y-niveles-de-ingles/",   // Lessons and levels
            "englishlive.ef.com/es-co/como-aprender-ingles/diploma-de-ingles/",                                 // Your Results and certificates
            "englishlive.ef.com/es-co/como-aprender-ingles/app-aprender-ingles/",                               // app EF
            // ONLINE ENGLISH COURSES
            "englishlive.ef.com/es-co/cursos-ingles/",                                                          // Main page for this menu
            "englishlive.ef.com/es-co/como-aprender-ingles/escuela-de-ingles/",                                 // General English
            "englishlive.ef.com/es-co/cursos-ingles/examen-toefl/",                                             // TOEFL Preparation
            "englishlive.ef.com/es-co/cursos-ingles/examen-toeic/",                                             // TOEIC Preparation
            "englishlive.ef.com/es-co/cursos-ingles/ingles-negocios/",                                          // Business English
            "englishlive.ef.com/es-co/cursos-ingles/cursos-especializados/",                                    // Job Specification English courses
            "englishlive.ef.com/es-co/cursos-ingles/ingles-para-viajes/",                                       // Travel English
            // OUR TEACHERS AND STUDENTS
            "englishlive.ef.com/es-co/profesores-y-estudiantes/",                                               // Main Page Menu
            "englishlive.ef.com/es-co/profesores-y-estudiantes/profesores-de-ingles/",                          // Our Teachers
            "englishlive.ef.com/es-co/profesores-y-estudiantes/estudiantes/",                                   // Our Student
            // PRICES
            // nothing on ES site
            // 14 Day Trial  link / button
            "englishlive.ef.com/es-co/oe-free-consultation/",                                                   // Free consultation
            // LINKs at the bottom footer
            "englishlive.ef.com/es-co/nosotros/",                                                               // ABOUT US
            "englishlive.ef.com/es-co/ayuda/",                                                                  // HELP
            "englishlive.ef.com/es-co/contacto/",                                                               // CONTACT US
            "englishlive.ef.com/es-co/terminos-y-condiciones/",                                                 // TERMS & CONDITIONS
            "englishlive.ef.com/es-co/politica-de-privacidad/",                                                 // PRIVACY POLICY
            // OUR COMMUNITY   SITE MAP  this dont exist on ES site
    };

    // e.g try us mostly goes to pnp pages
    public static String [] allPinkTopRightBtn = {
            "englishlive.ef.com/fr-fr/lp/oe/reservation-cours-particulier/",
            "englishlive.ef.com/it-it/offerta-inglese/",
            "englishlive.ef.com/de-de/buy/default/member/",
            "englishlive.ef.com/en-gb/buy/default/member/",
            "englishlive.ef.com/es-us/planes-y-precios/",
            "englishlive.ef.com/en-us/study-plans-and-prices/",
            "englishlive.ef.com/en-wws/prices/?ctr=fi",
            "englishlive.ef.com/ar-wws/study-plans-and-prices/?ctr=om",
            "englishlive.ef.com/fr-wws/formations-et-tarifs/?ctr=pf",
            "englishlive.ef.com/de-wws/angebote-und-preise/?ctr=at",
            "englishlive.ef.com/es-wws/oe-free-consultation/?ctr=cr",
            "englishlive.ef.com/tr-tr/buy/default/member/",
            "englishlive.ef.com/ru-ru/%D0%B2%D0%B0%D1%80%D0%B8%D0%B0%D0%BD%D1%82%D1%8B-%D0%BF%D1%80%D0%BE%D0%B3%D1%80%D0%B0%D0%BC%D0%BC-%D0%B8-%D1%86%D0%B5%D0%BD%D1%8B/",
            "englishlive.ef.com/es-es/planes-y-precios/",
            "englishlive.ef.com/en-wws/prices/?ctr=sa",
            "englishlive.ef.com/en-wws/prices/?ctr=se",
            "englishlive.ef.com/zh-tw/oe/free-consultation/",
            "englishlive.ef.com/th-th/study-plans-and-prices/",
            "englishlive.ef.com/id-id/study-plans-and-prices/",
            "englishlive.ef.com/ko-kr/study-plans-and-prices/",
            "englishlive.ef.com/es-co/oe-free-consultation/",
            "englishlive.ef.com/ja-jp/study-plans-and-prices/",
            "englishlive.ef.com/ar-sa/study-plans-and-prices/",
            "englishlive.ef.com/es-wws/oe-free-consultation/?ctr=ar",
            "englishlive.ef.com/es-pe/oe-free-consultation/",
            "englishlive.ef.com/es-ve/oe-free-consultation/",
            "englishlive.ef.com/es-cl/oe-free-consultation/",
            ".englishtown.com.br/lp/os/sep15_ls55/",
    };


    // Fantastic 3 .... CountryList [DE, GB, RU, SA, IT, FR, JP, US, MX, CO, PE, VE, CL, TW]
    public static final Map<String, String> REDIRECT_EFET__URL = new LinkedHashMap<>();
    static {
        REDIRECT_EFET__URL.put( ".efenglishtown.com/?ctr=de",           ".efenglishtown.com/de-de/lp/os/home/" );
        REDIRECT_EFET__URL.put( ".efenglishtown.com/?ctr=gb",           ".efenglishtown.com/en-gb/lp/os/home/" );
      /*  Reduced
        REDIRECT_EFET__URL.put( ".efenglishtown.com/?ctr=ru",           ".efenglishtown.com/ru-ru/lp/os/home/" );
        REDIRECT_EFET__URL.put( ".efenglishtown.com/?ctr=sa",           ".efenglishtown.com/ar-sa/lp/os/home/" );
        REDIRECT_EFET__URL.put( ".efenglishtown.com/?ctr=it",           ".efenglishtown.com/it-it/lp/os/home/" );
        REDIRECT_EFET__URL.put( ".efenglishtown.com/?ctr=fr",           ".efenglishtown.com/fr-fr/lp/oe/home/" );
        REDIRECT_EFET__URL.put( ".efenglishtown.com/fr-fr/apprendre-l-anglais-en-ligne/",           "englishlive.ef.com/fr-fr/apprendre-l-anglais-en-ligne/" );
        // these sims to fail ... htmlunit driver fail
        REDIRECT_EFET__URL.put( ".efenglishtown.com/?ctr=co",           ".efenglishtown.com/es-co/lp/oe/home/" );
        REDIRECT_EFET__URL.put( ".efenglishtown.com/?ctr=pe",           ".efenglishtown.com/es-pe/lp/oe/home/" );
        REDIRECT_EFET__URL.put( ".efenglishtown.com/?ctr=ve",           ".efenglishtown.com/es-ve/lp/oe/home/" );
        REDIRECT_EFET__URL.put( ".efenglishtown.com/?ctr=cl",           ".efenglishtown.com/es-cl/lp/oe/home/" );
        REDIRECT_EFET__URL.put( ".efenglishtown.com/?ctr=tw",           ".efenglishtown.com/zh-tw/lp/oe/home/" );
        REDIRECT_EFET__URL.put( ".efenglishtown.com/?ctr=tr",           ".efenglishtown.com/tr-tr/lp/os/home/" );
        REDIRECT_EFET__URL.put( ".efenglishtown.com/?ctr=jp",           ".efenglishtown.com/ja-jp/lp/os/home/" );
        * end reduced test */
        REDIRECT_EFET__URL.put( ".efenglishtown.com/?ctr=us",           ".efenglishtown.com/es-us/lp/os/home/" );
        REDIRECT_EFET__URL.put( ".efenglishtown.com/?ctr=mx",           ".efenglishtown.com/es-mx/lp/oe/home/" );
    }

    public static final Map<String, String> REDIRECT_ECENTRE_ALL_TESTS_URL = new LinkedHashMap<>();
    static {
        REDIRECT_ECENTRE_ALL_TESTS_URL.put("englishcenters.ef.com/",    "englishcenters.ef.com/");
        REDIRECT_ECENTRE_ALL_TESTS_URL.put("englishcenters.ef.com/?city=md_md",    "englishcenters.ef.com/?city=md_md");
        REDIRECT_ECENTRE_ALL_TESTS_URL.put("englishcenters.ef.com/?city=br_bc",    "englishcenters.ef.com/?city=br_bc");
        REDIRECT_ECENTRE_ALL_TESTS_URL.put("englishcenters.ef.com/?city=sa_ss",    "englishlive.ef.com/es-es/?city=sa_ss");
        REDIRECT_ECENTRE_ALL_TESTS_URL.put("englishcenters.ef.com/?city=none",     "englishlive.ef.com/es-es/?city=none");
        REDIRECT_ECENTRE_ALL_TESTS_URL.put("englishlive.ef.com/es-es/?city=br_bc", "englishcenters.ef.com/?city=br_bc");
        REDIRECT_ECENTRE_ALL_TESTS_URL.put("englishlive.ef.com/es-es/?city=md_md", "englishcenters.ef.com/?city=md_md");
        REDIRECT_ECENTRE_ALL_TESTS_URL.put("englishlive.ef.com/es-es/?city=sa_ss", "englishlive.ef.com/es-es/?city=sa_ss"); // other
    }

    public static final Map<String, String> REDIRECT_EMAILENGLISH_TESTS_URL = new LinkedHashMap<>();
    static {
        REDIRECT_EMAILENGLISH_TESTS_URL.put(".emailenglish.net/?ctr=mx",                    "emailenglish.net/es-mx/lp/ee/email_english/");
        REDIRECT_EMAILENGLISH_TESTS_URL.put(".emailenglish.net/?ctr=co",                    "emailenglish.net/es-mx/lp/ee/email_english/");
        REDIRECT_EMAILENGLISH_TESTS_URL.put(".emailenglish.net/?ctr=ag",                    "emailenglish.net/es-mx/lp/ee/email_english/");
        //  REDIRECT_EMAILENGLISH_TESTS_URL.put(".emailenglish.net/en-gb/",             "emailenglish.net/es-wws/lp/ee/email_english/");
        REDIRECT_EMAILENGLISH_TESTS_URL.put(".emailenglish.net/es-mx/?ctr=mx",              "emailenglish.net/es-mx/lp/ee/email_english/");
        REDIRECT_EMAILENGLISH_TESTS_URL.put(".emailenglish.net/es-mx/about-us/?ctr=mx",    "emailenglish.net/es-mx/lp/ee/email_english/");
        REDIRECT_EMAILENGLISH_TESTS_URL.put(".efenglishtown.com/fr-fr/lp/oe/et-reservation-cours-particulier", ".efenglishtown.com/fr-fr/lp/oe/et-reservation-cours-particulier/");
        //https://jira-bos.englishtown.com/browse/SAND-3040
        REDIRECT_EMAILENGLISH_TESTS_URL.put(".emailenglish.net/es-co/lp/ee/email_english/",  "emailenglish.net/es-mx/lp/ee/email_english/");
        REDIRECT_EMAILENGLISH_TESTS_URL.put(".efenglishtown.com/es-co/lp/oe/home/",          "efenglishtown.com/es-mx/lp/oe/home/");

    }

    /**
     * HREFLANG and sitemap index xml  redirect tests
     * eTown redirect to eLive
     */
    public static final Map<String, String> REDIRECT_HREFLANG = new LinkedHashMap<>();
    static {
        REDIRECT_HREFLANG.put(".englishtown.com.sa/hreflang-sitemap.xml",    "englishlive.ef.com/ar-sa/hreflang-sitemap.xml");
        REDIRECT_HREFLANG.put(".englishtown.de/hreflang-sitemap.xml",        "englishlive.ef.com/de-de/hreflang-sitemap.xml");
        REDIRECT_HREFLANG.put(".englishtown.com/en-gb/hreflang-sitemap.xml", "englishlive.ef.com/en-gb/hreflang-sitemap.xml");
        REDIRECT_HREFLANG.put(".englishtown.com/en-us/hreflang-sitemap.xml", "englishlive.ef.com/en-us/hreflang-sitemap.xml");
        REDIRECT_HREFLANG.put(".englishtown.es/hreflang-sitemap.xml",        "englishlive.ef.com/es-es/hreflang-sitemap.xml");
        REDIRECT_HREFLANG.put(".englishtown.com/es-mx/hreflang-sitemap.xml", "englishlive.ef.com/es-mx/hreflang-sitemap.xml");
        REDIRECT_HREFLANG.put(".englishtown.com/es-us/hreflang-sitemap.xml", "englishlive.ef.com/es-mx/hreflang-sitemap.xml");
        REDIRECT_HREFLANG.put(".englishtown.com/es-wws/hreflang-sitemap.xml","englishlive.ef.com/es-mx/hreflang-sitemap.xml");
        REDIRECT_HREFLANG.put(".englishtown.fr/hreflang-sitemap.xml",        "englishlive.ef.com/fr-fr/hreflang-sitemap.xml");
        REDIRECT_HREFLANG.put(".englishtown.it/hreflang-sitemap.xml",        "englishlive.ef.com/it-it/hreflang-sitemap.xml");
        REDIRECT_HREFLANG.put(".englishtown.co.jp/hreflang-sitemap.xml",     "englishlive.ef.com/ja-jp/hreflang-sitemap.xml");
        REDIRECT_HREFLANG.put(".englishtown.com.br/hreflang-sitemap.xml",    "englishlive.ef.com/pt-br/hreflang-sitemap.xml");
        REDIRECT_HREFLANG.put(".englishtown.com/zh-tw/hreflang-sitemap.xml", "englishlive.ef.com/zh-tw/hreflang-sitemap.xml");
    }

    public static final Map<String, String> REDIRECT_SITEMAP = new LinkedHashMap<>();
    static {
        REDIRECT_SITEMAP.put(".englishtown.com/sitemap-index.xml",			"englishlive.ef.com/sitemap-index.xml");
        REDIRECT_SITEMAP.put(".englishtown.com.sa/sitemap-index.xml",		"englishlive.ef.com/ar-sa/sitemap-index.xml");

       // REDIRECT_SITEMAP.put(".englishtown.com/ar-wws/sitemap-index.xml",  "englishlive.ef.com/ar-wws/sitemap-index.xml");

        REDIRECT_SITEMAP.put(".englishtown.de/sitemap-index.xml",			"englishlive.ef.com/de-de/sitemap-index.xml");
        REDIRECT_SITEMAP.put(".englishtown.com/de-wws/sitemap-index.xml",  "englishlive.ef.com/de-de/sitemap-index.xml");
        REDIRECT_SITEMAP.put(".englishtown.com/en-gb/sitemap-index.xml",   "englishlive.ef.com/en-gb/sitemap-index.xml");
        REDIRECT_SITEMAP.put(".englishtown.com/en-us/sitemap-index.xml",   "englishlive.ef.com/en-us/sitemap-index.xml");
       // REDIRECT_SITEMAP.put(".englishtown.com/en-wws/sitemap-index.xml",  "englishlive.ef.com/en-gb/sitemap-index.xml");
        REDIRECT_SITEMAP.put(".englishtown.es/sitemap-index.xml",			"englishlive.ef.com/es-es/sitemap-index.xml");
        REDIRECT_SITEMAP.put(".englishtown.com/es-mx/sitemap-index.xml",   "englishlive.ef.com/es-mx/sitemap-index.xml");
        REDIRECT_SITEMAP.put(".englishtown.com/es-us/sitemap-index.xml",   "englishlive.ef.com/es-mx/sitemap-index.xml");
        REDIRECT_SITEMAP.put(".englishtown.com/es-wws/sitemap-index.xml",  "englishlive.ef.com/es-mx/sitemap-index.xml");
        REDIRECT_SITEMAP.put(".englishtown.fr/sitemap-index.xml",			"englishlive.ef.com/fr-fr/sitemap-index.xml");
        REDIRECT_SITEMAP.put(".englishtown.com/fr-wws/sitemap-index.xml",  "englishlive.ef.com/fr-fr/sitemap-index.xml");
        REDIRECT_SITEMAP.put(".englishtown.com/id-id/sitemap-index.xml",   "englishlive.ef.com/id-id/sitemap-index.xml");
        REDIRECT_SITEMAP.put(".englishtown.it/sitemap-index.xml",			"englishlive.ef.com/it-it/sitemap-index.xml");
        REDIRECT_SITEMAP.put(".englishtown.co.jp/sitemap-index.xml",		"englishlive.ef.com/ja-jp/sitemap-index.xml");
        REDIRECT_SITEMAP.put(".englishtown.com/ko-kr/sitemap-index.xml",   "englishlive.ef.com/ko-kr/sitemap-index.xml");
        REDIRECT_SITEMAP.put(".englishtown.com.br/sitemap-index.xml",		"englishlive.ef.com/pt-br/sitemap-index.xml");
        REDIRECT_SITEMAP.put(".englishtown.ru/sitemap-index.xml",			"englishlive.ef.com/ru-ru/sitemap-index.xml");
        REDIRECT_SITEMAP.put(".englishtown.com/th-th/sitemap-index.xml",   "englishlive.ef.com/th-th/sitemap-index.xml");
        REDIRECT_SITEMAP.put(".englishtown.com/tr-tr/sitemap-index.xml",   "englishlive.ef.com/tr-tr/sitemap-index.xml");
        REDIRECT_SITEMAP.put(".englishtown.com/zh-tw/sitemap-index.xml",   "englishlive.ef.com/zh-tw/sitemap-index.xml");
    }

//    public static final Map<String, String> ROLA_ALL_LINKS_URLS = new HashMap<>();
//    static {
//        for(int i=0; i<allRolaUrlsList.length; i++) {
//            ROLA_ALL_LINKS_URLS.put(String.valueOf(i), allRolaUrlsList[i]);
//        }
//    }

    // list of partners for Rola - ordered by visits
    public static String [] ROLA_PARTNER_ARRAY = {
            "Root", "memb", "goco", "gorol", "mkge", "None", "gous", "2sna", "gope", "gocl", "gove", "corp", "goes",
            "gdmx", "af10", "mslt", "gdco", "gomx", "mxte", "myef", "efcl", "e1ef", "em05", "eaps"
    };
    public static final Map<String, String> ROLA_PARTNER = new HashMap<>();
    static {
        for(int i=0; i<ROLA_PARTNER_ARRAY.length; i++) {
            ROLA_PARTNER.put(String.valueOf(i), ROLA_PARTNER_ARRAY[i]);
        }
    }

    public static String [] ENVIRONMENTS={"live","qa","staging","uat","local","englishlive","qa-","stg-"};

    // move to englishlive
    public static final Map<String, String> ENVIRONMENT_MAP = new HashMap<>();
    static {
        ENVIRONMENT_MAP.put("http://www", "http://");
        ENVIRONMENT_MAP.put("http://qa", "http://qa-");
        ENVIRONMENT_MAP.put("http://staging", "http://stg-");
    }

    public static final Map<String, String> mxFreeTrialFormMapWithPhoneType = new LinkedHashMap<>();
    static {
        mxFreeTrialFormMapWithPhoneType.put( "first_name", "AutoTestCiroMx");
        mxFreeTrialFormMapWithPhoneType.put( "last_name",  "AutoLastNameTest");
        mxFreeTrialFormMapWithPhoneType.put( "telephone-type", "selectMeSelectOpt&true&mobile");
        mxFreeTrialFormMapWithPhoneType.put( "telephone",  "44922700");
        mxFreeTrialFormMapWithPhoneType.put( "age",  "selectMeSelectOpt&true&26-30");
        mxFreeTrialFormMapWithPhoneType.put( "emailenglish", "selectMeChk_false");
    }

    public static final Map<String, String> coFormMap = new LinkedHashMap<>();
    static {
        coFormMap.put( "first_name", "AutoTestCiroMx");
        coFormMap.put( "last_name",  "AutoLastNameTest");
        coFormMap.put( "telephone-type", "selectMeSelectOpt&true&mobile");
        coFormMap.put( "telephone",  "200000000");
        coFormMap.put( "age",  "selectMeSelectOpt&true&26-30");
        coFormMap.put( "emailenglish", "selectMeChk_false");
    }

    public static final Map<String, String> frFreeTrialFormMap = new LinkedHashMap<>();
    static {
        frFreeTrialFormMap.put( "first_name", "AutoTestCiroMx");
        frFreeTrialFormMap.put( "last_name",  "AutoLastNameTest");
        frFreeTrialFormMap.put("studyMotivation", "selectMeSelectOpt&true&Career");
        frFreeTrialFormMap.put( "telephone",  "0449227000");
        frFreeTrialFormMap.put( "country",    "selectMeSelectOpt&true&fr");
        frFreeTrialFormMap.put( "dynamicsubscribe", "selectMeChk_true");
    }

    public static final Map<String, String> FRNEWOSFORMMAP = new LinkedHashMap<>();
    static {
        String randomStrInt = TestUtil.generateRandomStringNumber();
        Long currTime = System.nanoTime();
        FRNEWOSFORMMAP.put( "firstname", "defalutMichael");
        FRNEWOSFORMMAP.put( "lastname", "Platini");
        FRNEWOSFORMMAP.put( "email", TEST_MAIL_START_TOKEN+currTime+"_"+randomStrInt+"_"+TEST_MAIL_END_TOKEN+"@qp1.org");
        FRNEWOSFORMMAP.put( "telephone", "0449227000");
        FRNEWOSFORMMAP.put( "mypassword", BaseTestConfig.getPassword8());
        FRNEWOSFORMMAP.put( "dynamicsubscribe", "selectMeChk_true");


    }

    public static final Map<String, String> passwordform = new LinkedHashMap<>();
    static {
        passwordform.put( "password",BaseTestConfig.getPassword8());
        passwordform.put( "educationlevel", "selectMeSelectOpt&true&Bachelor");
        passwordform.put( "studyhoursperweek",  "selectMeSelectOpt&true&4 - 6");
    }

    public static String [] ET_BASE_URLS    = {"http://www", "http://qa", "http://staging", "http://uat", "http://webus1",  "http://webus2" }; //"http://eng","qa-","stg-"}; // url start with

    public static String [] ELIVE_BASE_URLS = {  "http://", "http://qa-", "http://stg-",   "http://uat", "http://webus1.", "http://webus2." }; // url start with

}

