package com.englishtown.newhouse.apicore;

import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.services.MyHttpClient;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by nikol.marku on 02-Oct-17.
 *
*/


public abstract class BaseSpecSuite extends BaseApiSpec {
    public static final Logger logger = LoggerFactory.getLogger(BaseSpecSuite.class);



    @AfterSuite
    protected void CleanUpAndCancelSubscription(){
        logger.info("@ After suite ...!");

        cleanUp();
        //TODO: clean up this mess ... newhouse old house once old house is not used
        if (null != chatTestUserBean1) {
            try {
                if (isNewHousePayment) {
                    cancelSubscription(chatTestUserBean1.getEfId());
                } else {
                    cancelSubscription(chatTestUserBean1.getUserName());
                }
            }catch (AssertionError ae){
                logger.error("Failed to cancel subscription ...!");
            }
        }

        if (null != chatTestUserBean2) {
            try {
                if (isNewHousePayment) {
                    cancelSubscription(chatTestUserBean2.getEfId());
                } else {
                    cancelSubscription(chatTestUserBean2.getUserName());
                }
            } catch (AssertionError ae) {
                logger.error("Failed to cancel subscription ...!");
            }
        }

        if (null != chatTestUserBean3) {
            try {
                if (isNewHousePayment) {
                    cancelSubscription(chatTestUserBean3.getEfId());
                } else {
                    cancelSubscription(chatTestUserBean3.getUserName());
                }
            } catch (AssertionError ae) {
                logger.error("Failed to cancel subscription ...!" );
            }
        }

        if(null != studentBean && !StringUtils.isBlank(studentBean.getUser_id())) {
            try {
                if (isNewHousePayment) {
                    if(!StringUtils.isBlank(studentBean.getUser_id()))
                        cancelSubscription(studentBean.getUser_id());
                    else
                        logger.error("Failed to cancel subscription for null/empty email...! " );
                } else {
                    if(!StringUtils.isBlank(studentBean.getUserEmail()))
                        cancelSubscription(studentBean.getUserEmail());
                    else
                        logger.error("Failed to cancel subscription for null/empty email...! " );
                }
            } catch (AssertionError ae) {
                logger.error("Failed to cancel subscription ...! " );
            }
        }

    }


    /**
     * Call chat migration via cmd
     * @param userId
     */
    public void migrateChatUser(String userId){
        Process process;
        String command ="cmd /C start cmd.exe /C curl -X POST \"http://qa.englishtown.com/chat/2.0/legacyfriend/"+userId+"/migrate\" -H \"X-EF-ACCESS: eyJhbGciOiJSUzI1NiIsImtpZCI6ImtleXMvcHVibGljL2NoYXQvY2hhdC5wZW0ifQ.eyJpc3MiOiJjaGF0IiwiZXhwIjoxNTUzNjYwODg0LCJpYXQiOjE1MjIxMjQ4ODR9.eIh2fWNVAf_8l7EDs-DXMO5tjMmIz_DzJ6JfSls2dApQdCa_jqrAArrh4wROk3vjHR2zD5Ps3qVArcWEnAt4fKZL-Eeb4vBcHu4Qw0uMWu7EWQKGcz10q1cyQ1tKxmCLpn-9mb0nOwWPiGTcJ_uxvfcxq5izmR8bW5zcbVU8pFU\" -H \"Content-Length: 0\"";
        logger.info("Migrate - "+command);

        try {
            process = Runtime.getRuntime().exec(command);
            TestUtil.mySleep(3000);
            final BufferedReader is = new BufferedReader(new InputStreamReader(process.getInputStream()));
            //String line = is.readLine();     //while((line = is.readLine())!= null){        //  logger.info("line : \n"+line);          //}
        } catch (IOException e){
            logger.error("Failed to execute command ...."+ e.getMessage());
            e.printStackTrace();
        }
    }


}
