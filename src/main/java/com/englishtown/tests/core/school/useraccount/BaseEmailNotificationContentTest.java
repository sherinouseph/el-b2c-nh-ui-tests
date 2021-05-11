package com.englishtown.tests.core.school.useraccount;
/**
 *
 * User: sherin.ouseph
 * Date:03/02/2020
 *
 * 1. check page elements
 * 2. check toggles status
 *
 *
 */
import com.englishtown.helpers.AssertHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import static com.englishtown.helpers.CaseInsensitiveSubstringMatcher.containsIgnoringCase;


public abstract class BaseEmailNotificationContentTest extends BaseEmailNotificationTest {
    private static final Logger logger = LoggerFactory.getLogger(BaseEmailNotificationContentTest.class);


//    @Test (dependsOnMethods = "goToEmailNotificationPageFromAccountPageSubNav")
//    public void checkEmailNotificationPageComponentsDisplayed(){
//        emailAndNotificationPage.checkAllPageComponentsDisplayed();
//    }

    @Test (dependsOnMethods = "goToEmailNotificationPageFromAccountPageSubNav")
    public void checkCoachingEmail(){
        emailAndNotificationPage.assert_toggle_status(emailAndNotificationPage.notificationSettingToggleList.get(0),
                studentProfileSettingBean.isMotivationEmails());
    }

    @Test (dependsOnMethods = "goToEmailNotificationPageFromAccountPageSubNav")
    public void checkUpdatesSpecialOffers(){
        emailAndNotificationPage.assert_toggle_status(emailAndNotificationPage.notificationSettingToggleList.get(1),
                studentProfileSettingBean.isUpdatesAndSpecialOffers());
    }

    @Test (dependsOnMethods = "goToEmailNotificationPageFromAccountPageSubNav")
    public void checkDailyEnglishLesson(){
        emailAndNotificationPage.assert_toggle_status(emailAndNotificationPage.notificationSettingToggleList.get(2),
                studentProfileSettingBean.isDailyEnglishLesson());
    }


    @Test (dependsOnMethods = "goToEmailNotificationPageFromAccountPageSubNav")
    public void checkOnboardingAndSchoolTips(){
        emailAndNotificationPage.assert_toggle_status(emailAndNotificationPage.notificationSettingToggleList.get(3),
                studentProfileSettingBean.isNotificationOnSchooltips());
    }


    @Test (dependsOnMethods = "goToEmailNotificationPageFromAccountPageSubNav")
    public void checkNews(){
        emailAndNotificationPage.assert_toggle_status(emailAndNotificationPage.notificationSettingToggleList.get(4),
                studentProfileSettingBean.isNotificationOnNews());
    }



}

