package com.englishtown.tests.core.community;

import com.englishtown.driver.BaseRemoteWebDriver;
import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.WebElementHelper;
import com.englishtown.pages.community.BaseCommunityPage;
import com.englishtown.pages.community.CommunityHomePage;
import com.englishtown.pages.community.CommunityLoginPage;
import com.englishtown.pages.core.BasePage;
import com.englishtown.tests.core.BaseLandingPageTest;
import com.englishtown.tests.core.BaseTestHelper;
import com.englishtown.tests.core.IEarningsCalculator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.Matchers.is;

/**
 * Created by nikol.marku on 06/05/2015.
 * All community test use this
 *
 */

public abstract class BaseCommunityTest extends BaseTestHelper {
    private static final Logger logger = LoggerFactory.getLogger(BaseCommunityTest.class);
    protected CommunityHomePage communityHomePage;
    protected CommunityLoginPage communityLoginPage;
    protected String testCommunityUsername; // tesst should set this up
    protected String testCommunityUserPass;
    protected String msg; // this is the message shown on the top of page
    // qa cancelled  test12345et1456167611568@qp1.org
    protected static final String [] COMMUNITY_USERS = {"a4sdf3583asd@qp1.org","","","",""};

    /**
     * Get username base on environment
     * @return
     */
    public String getActiveUserPerEnv() throws NullPointerException{
        String user = null;
        switch (getENVIRONMENT()){
            case "live"      : user = "a4sdf3583asd@qp1.org";
                break;
            case "qa-"       : user = "asdf5as5df6@qp1.org";
                break;
            case "qa"        : user = "asdf5as5df6@qp1.org";
                break;
            case "stg-"       : user = "asd4f5asd8f98@qp1.org";
                break;
            case "staging"   : user = "asd4f5asd8f98@qp1.org";
                break;
            default:
                logger.warn("Could map user per this environment ["+getENVIRONMENT()+"]");
        }
        return user;
    }

    public String getActiveTeacherPerEnv() throws NullPointerException{
        String user = null;
        switch (getENVIRONMENT()){
            case "live"      : user = "Rzhang4917";
                break;
            case "qa"       : user = "Eshanghai2";
                break;
            case "qa-"       : user = "Eshanghai2";
                break;
            default:
                logger.warn("Could map user per this environment ["+getENVIRONMENT()+"]");
        }
        return user;
    }

    public String getGuestUserPerEnv(){
        return "nikol_comunity_guest@qp1.org";
    }

    public String getCancelledUserPerEnv(){
        return "test_comunity_us_ex_student@qp1.org";
    }



}
