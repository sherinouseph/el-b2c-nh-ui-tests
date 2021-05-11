package com.englishtown.enumpack;

import com.englishtown.driver.MyBrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by nikol.marku on 10-Jul-17.
 */

public enum CrmTestType {

    OE("oe"),
    OS("os"),
    Other("other");

    private final String crmTestType;

    private CrmTestType(String crmTestType) {
        this.crmTestType = crmTestType;
    }

    public String getCrmTestType(){
        return this.crmTestType;
    }

    private static final Logger logger = LoggerFactory.getLogger(CrmTestType.class);


    /**
     * Get test type from str
     * @param testType
     * @return CrmTestType
     */
    public static CrmTestType getCrmTestTypeFromString(String testType) {
        CrmTestType crmTestType = CrmTestType.Other;
        logger.info("Get Test type for [{}]", testType);

        if(null != testType) {

            switch (testType) {
                case "oe":
                    crmTestType = CrmTestType.OE;
                    break;
                case "os":
                    crmTestType = CrmTestType.OS;
                    break;
                case "other":
                    crmTestType = CrmTestType.Other;
                    break;

                default:
                    logger.warn(testType + " Is not on the test type list ...!");
            }
        } else {
            logger.error("Test type set to Other as testType entered as null ...!");
        }
        return crmTestType;
    }


}