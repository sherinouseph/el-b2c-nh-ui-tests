package com.englishlive.tests.smoke.pub.qa;

/**
* Smoke test for Home pages  :  DE, FR, IT, JA, GB
* pub1 and pub2
*/

import com.englishlive.tests.smoke.pub.BaseSmokeDirectPubTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;

public class Qa2SmokeDirectTest extends BaseSmokeDirectPubTest {
   private static final Logger logger = LoggerFactory.getLogger(Qa2SmokeDirectTest.class);

   @BeforeClass
   public void setupPub4(){
      isQA2 = true;
   }

}


