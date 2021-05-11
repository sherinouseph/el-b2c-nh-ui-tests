package com.englishtown.tests.core.stateobject;
/**
 * Created by nikol.marku on 04/07/2016.
 * https://jira-bos.englishtown.com/browse/SAND-3037
 * Open URL with redemption code and check state obj stores it
 state object should store the value
 Scenarios:
 1. valid rcode -> state object store validRcode
 *
 */
import com.englishtown.tests.core.BaseTestHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;


public abstract class BaseRcodeStoredInStateObjectTest extends BaseTestHelper {
    private static final Logger logger = LoggerFactory.getLogger(BaseRcodeStoredInStateObjectTest.class);

    protected String redemptionCode = "SOME-OTHER-CODE";
    protected final String orderRedemptionKey = "order.redemptionCode";   // state object key for redemption

    @Test
    void checkStateObjectOrderRedemptionCode(){
        assertStateObjectElementValue(orderRedemptionKey,redemptionCode, true);
    }
    

    // TODO Once this is live and Auther are using it should add test to check the default value set on form
    // is stored in state obje and it could be ovverrinde with url value
}



