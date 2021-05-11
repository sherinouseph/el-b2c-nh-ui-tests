package com.englishtown.tests.checkout.common.core;
/**
 *
 *
 */

import com.englishtown.helpers.WaitTool;
import com.englishtown.tests.core.BaseTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;


public abstract class BaseCheckTrackingServerOnMemberPage extends BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(BaseCheckTrackingServerOnMemberPage.class);

    @Test
    public void checkTrackingServerExist(){
        checkTrackingServeExist(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
    }

}

