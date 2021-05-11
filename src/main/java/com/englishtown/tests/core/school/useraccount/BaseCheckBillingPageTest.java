package com.englishtown.tests.core.school.useraccount;
/**
 *
 * User: nikol.marku
 * Date: 23/10/18
 *
 * 1. check page elements
 *
 *
 */
import com.englishtown.enumpack.BillingTables;
import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.utils.hamcrest.mymatcher.RegexMatcher;
import com.englishtown.newhouse.school.pages.account.BillingPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.text.IsEmptyString.isEmptyOrNullString;


public abstract class BaseCheckBillingPageTest extends BaseAccountSettingsTest {
    private static final Logger logger = LoggerFactory.getLogger(BaseCheckBillingPageTest.class);

    protected int subscriptionFeatureNumber = 3; // default


    @Test (dependsOnMethods = "goToMyAccountPage")
    public void goToBillingPageFromAccountPageSubNav(){
        myAccountPage.goToBilling();
        billingPage = new BillingPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        billingPage.getPageLoadedCondition();
        billingPage.simpleTest();
    }

    @Test (dependsOnMethods = "goToBillingPageFromAccountPageSubNav")
    public void checkBillPageAllComponentsDisplayedTest(){
        billingPage.checkAllPageComponentsDisplayed();
    }

    @Test (dependsOnMethods = "checkBillPageAllComponentsDisplayedTest")
    public void checkPaymentTableHeading(){
        AssertHelper.assertThat("Table Heading is NULL or Empty...! ...!",
                billingPage.getTableColumnHeadingText(billingPage.getTable(BillingTables.PAYMENT), 0),
                not(isEmptyOrNullString()));
    }

    @Test (dependsOnMethods = "checkBillPageAllComponentsDisplayedTest")
    public void checkSubscriptionTableHeading(){
        AssertHelper.assertThat("Table heading is NULL or Empty...! ...!",
                billingPage.getTableColumnHeadingText(billingPage.getTable(BillingTables.SUBSCRIPTION), 2),
                not(isEmptyOrNullString()));
    }

    // TODO    Payment date	Course	Payment Id	Price	Next billing date	2018-10-11	1 Euro - 59 per month after	2659860	1(EUR)	2018-11-10
   /* @Test (dependsOnMethods = "checkBillPageAllComponentsDisplayedTest")
    public void checkFirstPaymentDate(){
        String firstBillDate = billingPage.getTableCellText(billingPage.getTable(BillingTables.PAYMENT), 0); //billingPage.getPaymentTableCell(1);
        AssertHelper.assertThat("First bill date is NULL or Empty...! ...!",firstBillDate, not(isEmptyOrNullString()));
        AssertHelper.assertThat("First Bill Date is not the expected one ...!", firstBillDate, RegexMatcher.matchesRegex(REGEXP_YYYY_MM_DD));
    }*/

    @Test (dependsOnMethods = "checkBillPageAllComponentsDisplayedTest")
    public void checkPaymentTableRows(){
        AssertHelper.assertThat("Table rows missing  ...!",
                billingPage.getTableRowNumber(billingPage.getTable(BillingTables.PAYMENT)),  greaterThan(0));
    }

    @Test (dependsOnMethods = "checkBillPageAllComponentsDisplayedTest")
    public void checkSubscriptionExpireDate(){
        String firstSubscriptionDate = billingPage.getTableCellText(billingPage.getTable(BillingTables.SUBSCRIPTION_ITEMS), 3);
        //billingPage.getSubscriptionTableCell(4);
        AssertHelper.assertThat("Subscription Expire Date is NULL or Empty...! ...!",firstSubscriptionDate, not(isEmptyOrNullString()));
        //AssertHelper.assertThat("Subscription Expire Date is not the expected one ...!", firstSubscriptionDate, RegexMatcher.matchesRegex(REGEXP_MMM_DD_YYYY));
    }

    /*@Test (dependsOnMethods = "checkBillPageAllComponentsDisplayedTest")
    public void checkSubscriptionTableRows(){
        AssertHelper.assertThat("First bill date is NULL or Empty...! ...!",
                billingPage.getTableRowNumber(billingPage.subscriptionTableWe), greaterThan(8) );
    }*/

}

