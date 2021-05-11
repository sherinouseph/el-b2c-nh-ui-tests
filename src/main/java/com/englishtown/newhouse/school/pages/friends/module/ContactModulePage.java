package com.englishtown.newhouse.school.pages.friends.module;
/**
 * Nikol May 2018
 * module shown on search results or my friends
 * model one and reuse; it contains [avatar, status, name, flag]
 *
 *
 */

import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WebElementHelper;
import com.englishtown.newhouse.school.beanandenum.enums.ContactCardDetails;
import com.englishtown.newhouse.school.pages.core.BaseSchoolPage;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


public class ContactModulePage extends BaseSchoolPage {

    public static final Logger logger = LoggerFactory.getLogger(ContactModulePage.class);
    public static final String pageUrl = "/campus/class-booking/index?type=School.BookPL.2012#step=0";

    public static final String CONTACT_BASE_CSS = "div[class^='page'] [class^='contact']";
    public static final String CONTACT_LIST_CSS = CONTACT_BASE_CSS + " a";
    //contact details for one card
    public static final String CONTACT_AVATAR_CSS    = CONTACT_LIST_CSS + " [class^='avatar_'] [class^='avatar_'] span";
    public static final String CONTACT_STATUS_CSS    = CONTACT_LIST_CSS + " [class^='avatar_'] [class^='avatar_'] div";                  // status ...if online class = status_12Ks9 online_2SYVR
    public static final String CONTACT_FULLNAME_CSS  = CONTACT_LIST_CSS + " [class^='name_']";
    public static final String CONTACT_FLAG_CSS      = CONTACT_LIST_CSS + " [class^='flag_']";


    @FindBy(css = CONTACT_LIST_CSS)
    public List<WebElement> contactListWe;

    /**
     * @return we from the list of WEs
     */
    public WebElement getCard(int cardTopicIndex){
        return contactListWe.get(cardTopicIndex);
    }

    public int getNumberOfCards(){
        return contactListWe.size();
    }

    /**
     * Find elements on the parent element
     *
     * @param index
     * @param contactCardDetails
     * @return WebElement
     *
     * TODO : this is not test
     */
    public WebElement getContactCardElement(int index, ContactCardDetails contactCardDetails){
        WebElement webElement = null;

        switch (contactCardDetails){
            case AVATAR:
                logger.info("Case [{}]", contactCardDetails);
                webElement = WebElementHelper.safeFindElement(contactListWe.get(index), By.cssSelector(CONTACT_AVATAR_CSS));
                break;

            case STATUS:
                logger.info("Case [{}]", contactCardDetails);
                webElement = WebElementHelper.safeFindElement(contactListWe.get(index), By.cssSelector(CONTACT_STATUS_CSS));
                break;

            case NAME:
                logger.info("Case [{}]", contactCardDetails);
                webElement = WebElementHelper.safeFindElement(contactListWe.get(index), By.cssSelector(CONTACT_FULLNAME_CSS));
                break;

            case FLAG:
                logger.info("Case [{}]", contactCardDetails);
                webElement = WebElementHelper.safeFindElement(contactListWe.get(index), By.cssSelector(CONTACT_FLAG_CSS));
                break;


            default:
                logger.error("Cant find this element [{}]", contactCardDetails);
                throw new InvalidArgumentException("Can't find element for :"+contactCardDetails);
        }

        if(null == webElement)
            failTest("Cant find Web Element ...! for :"+contactCardDetails);

        return webElement;
    }

    public void checkAllTopicCardsElementsDisplayed(int index){
        for(ContactCardDetails cardDetails : ContactCardDetails.values()){
            logger.info("Checking card Element [{}] ..!", cardDetails);
            AssertHelper.assertWebElementDisplayed(getContactCardElement(index, cardDetails));
        }
    }

    public void checkName(int index, String chatUsername){
        logger.info("checkUserName");
        //(TestUtil.getWebElementText(getContactCardElement(index, ContactCardDetails.NAME)),chatUsername,"Full Name does not match ...!");
        AssertHelper.assertWebElementTextContains(chatUsername, getContactCardElement(index, ContactCardDetails.NAME));
    }

    public void clickOnCard(int index){
        logger.info("clickOnCard ...!");
        click(contactListWe.get(index));
    }


    ///-------------------------------------------------------------------------------------

    public ContactModulePage(WebDriver webDriver){
        super(webDriver);
    }
    public ContactModulePage(WebDriver webDriver, String url) {
        super(webDriver, url);
    }
    public ContactModulePage(WebDriver webDriver, int timeoutSec) {
        super(webDriver, timeoutSec);
    }
    public ContactModulePage() {
        this(null, null);
    }
    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public ExpectedCondition getPageLoadedCondition() {
        return ExpectedConditions.visibilityOf(contactListWe.get(0));
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public boolean simpleTest() {
        logger.info("simpleTest Assert Main element displayed ...!");
        AssertHelper.assertComponentsDisplayed(contactListWe.get(0));
        return true;
    }

    @Override
    public boolean checkAllPageComponentsDisplayed() {
        logger.info("checkAllModuleComponents for module index 0...!");
        checkAllTopicCardsElementsDisplayed(0);

        return true;
    }

    public void checkNumberOfContactModules(int numberOfContacts){
        logger.info("checkNumberOfContactModules ...is [{}]", numberOfContacts);
        AssertHelper.assertElementSizeEqual(getWebDriver(), contactListWe , numberOfContacts);
    }

}
