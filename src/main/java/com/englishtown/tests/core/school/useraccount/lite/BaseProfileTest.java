package com.englishtown.tests.core.school.useraccount.lite;
/**
 *
 * User: nikol.marku
 * Date: 2020
 *
 * 1. Check and Change Profile details
 */

import com.englishtown.newhouse.school.beanandenum.SchoolStudentBean;
import com.englishtown.newhouse.school.pages.account.MyAccountPage;
import com.englishtown.newhouse.school.pages.account.ProfilePage;
import com.englishtown.tests.core.school.BaseSchoolHomePageTest;
import com.englishtown.tests.core.school.BaseSimpleLogin;
import com.englishtown.tests.core.school.useraccount.BaseAccountSettingsTest;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;


public abstract class BaseProfileTest extends BaseAccountSettingsTest {
    private static final Logger logger = LoggerFactory.getLogger(BaseProfileTest.class);


    @Test(dependsOnMethods = "goToMyAccountPage")
    public void goToProfilePage() {
        myAccountPage.goToYourProfile();
        profilePage = new ProfilePage(getWebDriver(), 35);
        profilePage.getPageLoadedCondition();
        schoolStudentBean  = new SchoolStudentBean();
    }

    @Test(dependsOnMethods = "goToProfilePage")
    public void checkProfilePageElementsShown() {
        profilePage.checkAllPageComponentsDisplayed();
    }

    @Test(dependsOnMethods = "checkProfilePageElementsShown")
    public void checkProfile_userDataNotEmpty() {
        sleep(1000);
        profilePage.checkPersonalDetailsNotEmptyOrNull();
    }

    @Test(dependsOnMethods = "checkProfile_userDataNotEmpty")
    public void getUserDetails() {
        schoolStudentBean = profilePage.getSchoolStudentBean();
    }

    @Test(dependsOnMethods = "getUserDetails")
    public void updateFirstName() {
        logger.info("update First Name ...!");
        if(StringUtils.containsIgnoreCase(schoolStudentBean.getFirstName(),schoolStudentUpdatedBean.getFirstName()))
            profilePage.updateField_checkSavedMsgShown_fieldUpdatedToNewValue(profilePage.firstNameWe, schoolStudentUpdatedBean2.getFirstName());
        else
            profilePage.updateField_checkSavedMsgShown_fieldUpdatedToNewValue(profilePage.firstNameWe, schoolStudentUpdatedBean.getFirstName());
        sleep(700);
    }

    @Test(dependsOnMethods = "getUserDetails")
    public void updateLastName() {
        logger.info("updateLastName ...!");
        if(StringUtils.containsIgnoreCase(schoolStudentBean.getLastName(),schoolStudentUpdatedBean.getLastName()))
            profilePage.updateField_checkSavedMsgShown_fieldUpdatedToNewValue(profilePage.lastNameWe, schoolStudentUpdatedBean2.getLastName());
        else
            profilePage.updateField_checkSavedMsgShown_fieldUpdatedToNewValue(profilePage.lastNameWe, schoolStudentUpdatedBean.getLastName());
        sleep(700);
    }


    @Test(dependsOnMethods = "getUserDetails")
    public void updateMobNumber() {
        logger.info("updateMobNumber  ...!");
        if(StringUtils.containsIgnoreCase(schoolStudentBean.getMobilePhone(),schoolStudentUpdatedBean.getMobilePhone()))
            profilePage.updateField_checkSavedMsgShown_fieldUpdatedToNewValue(profilePage.mobilePhoneWe, schoolStudentUpdatedBean2.getMobilePhone());
        else
            profilePage.updateField_checkSavedMsgShown_fieldUpdatedToNewValue(profilePage.mobilePhoneWe, schoolStudentUpdatedBean.getMobilePhone());
        sleep(700);
    }

    // TODO: once DEVs stop using Mocks
    //       refresh(getWebDriver()); Logout and login

}