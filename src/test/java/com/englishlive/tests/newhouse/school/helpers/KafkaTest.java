package com.englishlive.tests.newhouse.school.helpers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import static com.englishtown.tests.core.school.core.ISchoolTest.SCHOOL_LITE_QA;
//        Precondition - Current Level of Student =GE 6, Unit 3, Unit Topic = Problems and Solutions,Goal = 5+)
//        Test Cases
//        Change Goal to 3-5 hours for GE Level 6
//        Change to Level 7 GE(Current Unit = 2, Unit Topic = )
//        Change to BE(Level 3, Current Unit =1, Unit Topic =Meetings)
//        Change Goal BE to 1-2
//        Change to IND(Level 2, Current Unit =1, Unit Topic = Banking and Finance)
//        Change Goal IND to my own pace
//        Change to TRV(Level 1,Current Unit =1,Unit Topic= Level english)
//        Change Goal TRV to 5+
//        Change to Level 6 of GE(Current Unit =3, Unit Topic = Problems and Solutions)

public class KafkaTest extends BaseSchoolOneTest {
    private static final Logger logger = LoggerFactory.getLogger(KafkaTest.class);
    protected String testUsername;

    @BeforeClass
    public void setup() {
        printTestName(logger);
        setThreadSafeDriver();
        testStartUrl = "https://qa.school.englishlive.ef.com/";
        username = "sftestuser2512+1212@gmail.com";
        password = "Cardinal2020";
        //username="sf-bkmo@qp1.org";
        openUrl(getWebDriver(), testStartUrl);
        sleep(2000);
    }

    @AfterClass
        protected void testAfterClass () {
            destroyDriver();
        }
}
