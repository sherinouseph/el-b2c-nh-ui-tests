package com.englishlive.tests.newhouse.salesforce.base.permission;
/**
 * Login to sales force
 * Check number of tabs in main navigation
 * and the number or AppMenu items top right
 *
 *
 Check number of tabs in main navigation

 and the number or AppMenu items top right
 This are not the same for admin and agent

 Admin and Agent see different menu items and apps






 *
 * Nikol
 * Nov 2017
 */

import com.englishlive.tests.newhouse.salesforce.base.BaseSalesforceTest;
import com.englishtown.newhouse.salesforce.pages.core.SalesForceConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public abstract class BasePermissionTest extends BaseSalesforceTest {
    private static final Logger logger = LoggerFactory.getLogger(BasePermissionTest.class);

    protected int noOfTabs;
    protected int noOfAppMenuItems;


    @Test
    protected void checkNumberOfMainNavigationTabs(){
        homeSalesForcePage.checkNumberOfTabsMainNavigator(noOfTabs);
    }

    @Test(dependsOnMethods = "checkNumberOfMainNavigationTabs")
    protected void checkNumberAppMenuItems(){
        homeSalesForcePage.checkNumberOfAppMenuItems(noOfAppMenuItems);
    }


}
