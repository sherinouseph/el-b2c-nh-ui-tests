package com.englishtown.tests.core;

import com.englishtown.helpers.WebElementHelper;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.tests.checkout.common.core.NewBaseCheckoutFlow;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * Created by nikol.marku on 20-Jun-17.
 *
 * auto_7031993305688600_XFZIL5593_xdelx@qp1.org
 */
public class UniqueDataObject {
    private static final Logger logger = LoggerFactory.getLogger(UniqueDataObject.class);

    /**
     * TODO : 13 DEC emails gen updated to use more random str [from 5 to 7] and longer number No [99999 to 999999999]
     *        if we still see the error email in use need to add the hostname or mac address to the email...
     */
    // unique data
    String email;



    public UniqueDataObject(String leadRecordType){
        this.email = generateEmail(leadRecordType, System.nanoTime(), TestUtil.generateRandomStringNumber());
    }
    public UniqueDataObject(){
        this.email = generateEmail(System.nanoTime(), TestUtil.generateRandomStringNumber());
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String generateEmail(Long currTime, String randomStrInt){
        String email = "";
        email = EfConstants.TEST_MAIL_START_TOKEN + currTime + "_" + randomStrInt + EfConstants.TEST_MAIL_END_TOKEN + "@qp1.org";
        //logger.info(" email generated ["+ email+"]");
        return email;
    }

    public String generateEmail(String leadType, Long currTime, String randomStrInt){
        String email = "";
        email = EfConstants.TEST_MAIL_START_TOKEN+leadType+"_" + currTime + "_" + randomStrInt + EfConstants.TEST_MAIL_END_TOKEN + "@qp1.org";
        logger.info(" email generated ["+ email+"]");

        return email;
    }

    public String getEmail(){
        return email;
    }

    public String getEmail(String market){
        return email.replace("auto_", "auto_"+ market +"_");
    }


    public String getGmail(String market, int strLength, int numberLength){
        String randomStrNo = TestUtil.generateRandomStringNumber(strLength, numberLength);
        String email = "b2c.london+_"+market+"_"+ randomStrNo + "@gmail.com";
        return email.replace("auto_", "auto_"+ market +"_");
    }
}
