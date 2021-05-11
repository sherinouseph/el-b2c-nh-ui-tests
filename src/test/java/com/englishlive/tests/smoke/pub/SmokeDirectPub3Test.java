package com.englishlive.tests.smoke.pub;

/**
* Smoke test for Home pages  :  DE, FR, IT, JA, GB
* pub1 and pub2
*/

import com.englishlive.tests.smoke.SmokeDataProvider;
import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WebClientResponseHelper;
import com.englishtown.pages.core.BasePage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.hamcrest.core.Is.is;

public class SmokeDirectPub3Test extends BaseSmokeDirectPubTest {
   private static final Logger logger = LoggerFactory.getLogger(SmokeDirectPub3Test.class);

   @BeforeClass
   public void setupPub4(){
      isPub3 =  true;
   }

}


