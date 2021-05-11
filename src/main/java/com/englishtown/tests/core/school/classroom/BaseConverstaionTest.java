package com.englishtown.tests.core.school.classroom;
/**
 *
 * User: nikol.marku
 * Date: 06/02/18
 *
 * 1. go to current GL page
 * 2. check page elements
 * 3. check schedule
 * 4. check download [ check response 200 for url]
 *
 */

import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.newhouse.school.pages.classroom.ConversationClassPage;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;


public abstract class BaseConverstaionTest extends BaseClassroomTest {
    private static final Logger logger = LoggerFactory.getLogger(BaseConverstaionTest.class);

    @Test (dependsOnMethods = "checkUserIsAtSchoolHomePage")
    public void goToConversationGLpage(){
        initSchoolHeaderAndFooter();
        schoolHeaderAndFooterPage.schoolHeaderPage.goToBookGroupClass();
        conversationClassPage = new ConversationClassPage(getWebDriver());
        waitForUrlContains(getWebDriver(), "evc/gl?icid=School.GroupClass", 25);
        assertIsUrlContaining("evc/gl?icid=School.GroupClass");
    }

    @Test (dependsOnMethods = "goToConversationGLpage")
    public void checkConversationPageAllElements(){
       WaitTool.waitForElementClickable_fluentWait(getWebDriver(),findElement(By.className("classScheduleDropdownCss")),5,1000);
        //click(findElement(By.className("evc-ui-widget-announcementbar-toggler-on")));
        AssertHelper.assertWebElementDisplayed(conversationClassPage.classScheduleDropdownWe);
        conversationClassPage.checkAllPageComponentsDisplayed();
    }

    @Test (dependsOnMethods = "checkConversationPageAllElements")
    public void checkShowClassScheduleDaysAndTitleSize_isSevenAndClosePopup(){
        sleep(3000);
       WaitTool.waitForElementClickable_fluentWait(getWebDriver(),conversationClassPage.classScheduleDropdownWe,5,1000);
        click(conversationClassPage.classScheduleDropdownWe);
        conversationClassPage = new ConversationClassPage(getWebDriver());
        waitForElementCondition(ExpectedConditions.visibilityOf(conversationClassPage.scheduleDaysListWe.get(3)),
                getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
      conversationClassPage = new ConversationClassPage(getWebDriver());
 //     sleep(2000);
     //AssertHelper.assertWebElementDisplayed(conversationClassPage.scheduleTitleListWe.get(6));
      //  conversationClassPage.checkClassScheduleDaysAndTitleSize_isSeven();
        // click to close the popup
        click(conversationClassPage.classScheduleDropdownWe);
        waitForElementCondition(ExpectedConditions.invisibilityOf(conversationClassPage.scheduleDaysListWe.get(3)),
                getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        AssertHelper.assertWebElementNotDisplayed(conversationClassPage.scheduleDaysListWe.get(3));
    }


    @Test (dependsOnMethods = "checkShowClassScheduleDaysAndTitleSize_isSevenAndClosePopup")
    public void checkDownloadLinkReturns_200(){
            conversationClassPage = new ConversationClassPage(getWebDriver());
            click(conversationClassPage.downloadPreparationMaterialWe);
            String donloadPdfUrl = getAttributeValue(conversationClassPage.downloadPreparationMaterialWe, "href");
            openUrl_AssertResponse(donloadPdfUrl, 200);
            logger.info(" new tab open ..!");

    }

    //TODO click on buy more
    //TODO click on download




}