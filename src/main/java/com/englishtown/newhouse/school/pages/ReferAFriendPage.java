package com.englishtown.newhouse.school.pages;

//sherin - 30/01/2018
//Refer A friend  page object

import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WebDriverWindowHelper;
import com.englishtown.helpers.WebElementHelper;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.newhouse.school.pages.core.BaseSchoolPage;
import com.englishtown.tests.core.EfConstants;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ReferAFriendPage extends BaseSchoolPage {
    public static final Logger logger = LoggerFactory.getLogger(ReferAFriendPage.class);
    public static final String pageUrl = "/school/courseservices/Referrals.aspx";
    protected String emailid;
    protected String friendName;


    @FindBy(css = "textarea[class='message']")
    public List<WebElement> messageWe;

    @FindBy(css = "button[class='submit btn btn-primary']")
    public  List<WebElement> referBtnWe;


    @FindBy(css =".active.email.tab")
    public WebElement emailIconWe;

    @FindBy(css =".facebook.tab")// ".inner a[href='facebook-page']"
    public WebElement fbIconWe;

    @FindBy(id = "svg-icon-twitter")
    public WebElement twitterIconWe;

    //email items

    @FindBy(css = "div[name='email-page'] h2")
    public WebElement referAFriendTitleWe;

    @FindBy(css = ".import.btns a")
    public List <WebElement> emailproviderIconWe;

    //facebook
    @FindBy(css = "div[name='facebook-page'] h2")
    public WebElement facebookTitleWe;

    String facebookUrl="https://www.facebook.com/v2.5/dialog/oauth?app_id";

    //twitter
    @FindBy(css = "div[name='twitter-page'] h2")
    public WebElement twitterTitleWe;

    String twitterUrl="https://twitter.com/intent/tweet?text";


    //your referals fo far section

    @FindBy(css = ".the-referrals h2")
    public WebElement yourReferalHeadingWe;

    @FindBy(css = ".list th")
    public List<WebElement> yourReferalTableHeadingWe;

               //Get the last row element

    @FindBy(css = "tbody.the-referrals-tbody tr:last-child  td:nth-child(1)")
    public WebElement inviteeFriendName;

    @FindBy(css = "tbody.the-referrals-tbody tr:last-child  td:nth-child(2)")
    public WebElement inviteeFriendEmailId;

    @FindBy(css = "tbody.the-referrals-tbody tr:last-child  td:nth-child(3)")
    public WebElement inviteeFriendStatus;



    //frequently asked questions

    @FindBy(css = ".the-frequently-asked-question h2")
    public WebElement freQAskedQuestHeadingWe;

    @FindBy(css = ".questions li")
    public List <WebElement> freQAskedQuestAndAnsWe;



    public ReferAFriendPage(WebDriver webDriver){
        super(webDriver);
    }

    public ReferAFriendPage(WebDriver webDriver, String url) {
        super(webDriver, url);
    }

    public ReferAFriendPage() {
        this(null, null);
    }

    public ReferAFriendPage(WebDriver webDriver, int waitSec){
        super(webDriver, waitSec);
    }

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }



    public boolean simpleTest() {
        logger.info("check firstname is displayed...!");
        AssertHelper.assertWebElementDisplayed(referBtnWe.get(0));
        return true;
    }

    public ExpectedCondition getPageLoadedCondition() {
        return ExpectedConditions.visibilityOf(emailIconWe);
    }

    public void clickEmailIcon() {
        logger.info("clickEmailIcon");
        click(emailIconWe);
    }

    public void clickFBIcon() {
        logger.info("clickFBIcon");
        click(fbIconWe);
    }

    public void clickTwitterIcon() {
        logger.info("clickTwitterIcon");
        click(twitterIconWe);
    }


    public void referFriend_email(){
        AssertHelper.assertStringContains(referAFriendTitleWe.getText(),"REFER A FRIEND","refer a friend title wrong");
        WebElementHelper.sendKeys(getWebDriver(),messageWe.get(0),generateEmail_referAFriend(System.nanoTime(), TestUtil.generateRandomStringNumber()),false);
        click(referBtnWe.get(0));
        sleep(1000);
        WebDriverWindowHelper.closeAlertAndGetItsText(getWebDriver(),true);
        logger.info("Successfully clicked on refer button");
    }

    public void shareOnFacebook(String message ){
        AssertHelper.assertStringContains(facebookTitleWe.getText(),"SHARE ON FACEBOOK","Share on facebook title wrong");
        WebElementHelper.sendKeys(getWebDriver(),messageWe.get(1),message,false);
        click(referBtnWe.get(1));
    }

    public void shareOnTwitter(String message){
        AssertHelper.assertStringContains(twitterTitleWe.getText(),"SHARE ON TWITTER","Share on Twitter title wrong");
        WebElementHelper.sendKeys(getWebDriver(),messageWe.get(2),message,false);
        click(referBtnWe.get(2));

    }

    public void  checkAllEmailProviderIconsArePresent(){
        logger.info("check all email providers icons are present");
        AssertHelper.assertElementSizeEqual(getWebDriver(),emailproviderIconWe,5);

    }

    public void verifyYourReferrals(String status){
        checkAllPageComponentsDisplayed(yourReferalHeadingWe,yourReferalTableHeadingWe.get(0),yourReferalTableHeadingWe.get(1),yourReferalTableHeadingWe.get(2));
        AssertHelper.assertStringContains(inviteeFriendName.getText(),getFriendName(),"Invitee  Name wrong");
        AssertHelper.assertStringContains(inviteeFriendEmailId.getText(),emailid,"Invitee  email id  wrong");
        AssertHelper.assertStringContains(inviteeFriendStatus.getText(),status,"Invitee  status wrong");

    }

    @Override
    public boolean checkAllPageComponentsDisplayed(){
        logger.info("checkAllPageComponents [ ..]...!");
                checkAllPageComponentsDisplayed(referAFriendTitleWe,referBtnWe.get(0),messageWe.get(0),emailIconWe,freQAskedQuestHeadingWe);

        return true;
    }

    public void assertFreqAskedQuestion() {
        AssertHelper.assertElementSizeMoreThanOrEqual(getWebDriver(), freQAskedQuestAndAnsWe, 5);
        logger.info("More than or equal to 5 questions are present in thhe fre asked question section");
    }

    public String generateEmail_referAFriend( Long currTime, String randomStrInt){
        emailid = "";
        emailid = EfConstants.TEST_MAIL_START_TOKEN+"_" + currTime +  "@qp1.org";
        logger.info(" email generated ["+ emailid+"]");
        return emailid;
    }

    public String getFriendName(){
        String[] parts = emailid.split("_@");
        friendName= parts[0];
        return friendName;
    }

    @Override
    public String getPageUrl() {
        return pageUrl;
    }
}
