package com.englishlive.tests.smoke.pub;

/**
* Smoke test for Home pages  :  DE, FR, IT, JA, GB
* pub1 and pub2
*/

import com.englishtown.helpers.utils.TestUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;

public class SmokeDirectPub4Test extends BaseSmokeDirectPubTest {
   private static final Logger logger = LoggerFactory.getLogger(SmokeDirectPub4Test.class);

   @BeforeClass
   public void setupPub4(){
      isPub4 =  true;
   }
}


