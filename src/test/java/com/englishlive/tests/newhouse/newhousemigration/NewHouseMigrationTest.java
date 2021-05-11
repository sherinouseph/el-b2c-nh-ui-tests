package com.englishlive.tests.newhouse.newhousemigration;
/**
 * Migrate the old house user to newhouse
 */
import com.englishtown.services.MyHttpClient;
import com.englishtown.tests.checkout.common.core.CheckCampusPageTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;


public  abstract class NewHouseMigrationTest extends CheckCampusPageTest {
    private static final Logger logger = LoggerFactory.getLogger(NewHouseMigrationTest.class);
    protected String requestUrl = "https://qa-b2c.eflabs.io/api/commerce-migration/commerce/migrateMember?client_id=englishlive";

    @Test(dependsOnMethods = { "checkAtCampusPage" })
    public void migrateUserToNewHouse(){
        MyHttpClient.post(memberId,requestUrl);
        logger.info("Offer Id = "+offer_id);
        logger.info("Member Id = "+memberId+" Order Id = "+orderId);

    }





}