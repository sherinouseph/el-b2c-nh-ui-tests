package com.englishlive.tests.newhouse.school.account;
/**
 *
 * User: nikol.marku
 * Date: 2020
 *
 */

import com.englishtown.newhouse.school.beanandenum.SchoolStudentBean;
import com.englishtown.tests.core.school.useraccount.lite.BaseProfileTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class ProfileTest extends BaseProfileTest {
    private static final Logger logger = LoggerFactory.getLogger(ProfileTest.class);
    @Value("#{applicationPropertiesList['user.profile']}")
    protected String testUsername;



    @BeforeClass
    protected void setup(){
        setThreadSafeDriver();
        username = testUsername;
        schoolStudentUpdatedBean = new SchoolStudentBean();
        schoolStudentUpdatedBean.setFirstName("Testfirstname");
        schoolStudentUpdatedBean.setLastName("Testlastname");
        schoolStudentUpdatedBean.setMobilePhone("2922914173");
        schoolStudentUpdatedBean.setUserEmail(username);
        schoolStudentUpdatedBean2 = new SchoolStudentBean();
        schoolStudentUpdatedBean2.setFirstName("firstnameupdate");
        schoolStudentUpdatedBean2.setLastName("lastnameupdate");
        schoolStudentUpdatedBean2.setMobilePhone("122222222903");
        schoolStudentUpdatedBean2.setUserEmail(username);
        openUrl(getWebDriver(), getBASEURL());
        assertIsUrlContaining("englishlive");
    }


    @AfterClass
    protected void testAfterClass(){
        logger.info("Current \n"+schoolStudentBean.toString());
        logger.info("Updated \n " +schoolStudentUpdatedBean.toString());
        schoolStudentBean        = null;
        schoolStudentUpdatedBean = null;
        sleep(5000); // tmp
        destroyDriver();
    }

}
