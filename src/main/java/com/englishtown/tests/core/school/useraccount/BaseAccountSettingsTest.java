package com.englishtown.tests.core.school.useraccount;
/**
 *
 * User: nikol.marku
 * Date: 06/02/18
 *
 * 1. go to account setting my account page
 *
 */

import com.englishtown.helpers.WaitTool;
import com.englishtown.tests.core.school.BaseSchoolHomePageTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;


public abstract class BaseAccountSettingsTest extends BaseSchoolHomePageTest {
    private static final Logger logger = LoggerFactory.getLogger(BaseAccountSettingsTest.class);

    protected int subscriptionFeatureNumber = 3; // default
    // set to EN lan
    protected String displayProfileStatus    = "Appear Online";
    protected String profileViewableByStatus = "Everyone";
    protected String chatAccessibilityStatus = "Only my friends";


    @Test (dependsOnMethods = "checkMyPage")
    public void goToMyAccountPage(){
        initSchoolHeaderAndFooter();
        schoolHeaderAndFooterPage.schoolHeaderPage.goToMyAccountSetting();
        initMyAccountPage();
//        myAccountPage.getPageLoadedCondition();
//        myAccountPage.waitForAccountPageSpinnerDisappear(WaitTool.MED_WAIT_4_ELEMENT25);
    }

}