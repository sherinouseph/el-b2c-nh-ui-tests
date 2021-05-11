package com.englishlive.tests.newhouse.salesforce.base;
/**
 * Click on Add Product button
 * Select the product
 * Verify if the product is Added
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public abstract class BaseAddProductTest extends BaseOpportunityTest {
    private static final Logger logger = LoggerFactory.getLogger(BaseAddProductTest.class);


    @Test(dependsOnMethods = "checkOpportunityPageTest")
    protected void addProduct(){
        if(!isPCI) {
            clickAddProductBtn();
            sleep(1000);
            selectProductVTP();
        }else{
            clickAddProductPCIBtn();
            sleep(1000);
            selectProductPCI();
        }
    }

    @Test(dependsOnMethods = "addProduct")
    protected void verifyProductTest(){
        verifyProduct();
    }


}
