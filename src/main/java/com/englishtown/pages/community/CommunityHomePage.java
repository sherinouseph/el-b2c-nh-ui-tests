package com.englishtown.pages.community;

import com.englishtown.helpers.AssertHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by nikol.marku on 09/03/2016.
 * User loged in is shown with this page
 * nikol_comunity_guest@qp1.org
 */


public class CommunityHomePage extends BaseCommunityPage {

    public static final Logger logger = LoggerFactory.getLogger(CommunityHomePage.class);
    public static final String pageUrl = "http://englishlive.ef.com/community/Home/?login=1";

    public static final String NON_STUDENT_PAGE_URL_CONTAINS = "nonstudentmessage"; // = "englishlive.ef.com/community/home/nonstudentmessage.aspx";




    @FindBy(id = "newmembers")
    public WebElement onlineMembers;  // online members shown here

    @FindBy(className = "innerMessage")
    public WebElement communityShutdownAlertMessage;

    @FindBy(id = "et-wdg-referral-email-addr")
    public WebElement referralEmailAddress;

    @FindBy(className = "btnSearch")
    public WebElement SearchFriendBtn;

    @FindBy(css = ".profileInfo a")
    public WebElement editProfileLink;

    @FindBy(id = "aspnetForm")
    public WebElement changedForm; // NON ACTIVE STUDENT

    public CommunityHomePage(WebDriver webDriver){
        super(webDriver);
    }

    /*public CommunityLoginPage(WebDriver webDriver, String url) {
        super(webDriver, url);
    }*
    public CommunityLoginPage() {
        this(null, null);
    }*/
    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public boolean simpleTest() {
        logger.info(" simpleTest editProfileLink ...!");
        return editProfileLink.isDisplayed() ;
    }
    public boolean simpleTest(WebElement we) {
        logger.info(" simpleTest ...!");
        return we.isDisplayed() ;
    }
    public ExpectedCondition getPageLoadedCondition() {
        return ExpectedConditions.visibilityOf(editProfileLink);
    }
    public String getPageUrl() {
        return pageUrl;
    }

    public void isActiveStudent(){
        AssertHelper.assertThat("Invite friend referralEmailAddress not shown ...!", referralEmailAddress.isDisplayed());
        AssertHelper.assertThat("Invite friend onlineMembers not shown ...!", onlineMembers.isDisplayed());
        AssertHelper.assertThat("Invite friend SearchFriendBtn not shown ...!", SearchFriendBtn.isDisplayed());
    }

    public void isNotActiveStudent(){
        AssertHelper.assertThat("changedForm should be shown ...!",        changedForm.isDisplayed() );
        /*AssertHelper.assertThat("Invite friend referralEmailAddress shown and should not ...!", referralEmailAddress == null);
        AssertHelper.assertThat("Invite friend onlineMembers shown and should not...!",        onlineMembers == null );
        AssertHelper.assertThat("Invite friend SearchFriendBtn shown and should not ...!",      SearchFriendBtn == null);*/
    }

}
