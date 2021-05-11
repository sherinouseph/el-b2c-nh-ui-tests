package com.englishlive.tests.landing.tw.oe;

import com.englishlive.tests.landing.base.BaseOEPageTest;
import com.englishtown.pages.landing.OELandingPage;
import com.englishtown.tests.core.EfConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public abstract class BaseTWOEPageTest extends BaseOEPageTest {

    @Test(dependsOnMethods = { "isLeadType" })
    public void isCubit(){
        assertStateObjectValue(stateObjKeyTrackEventCubit, "true");
    }

}

