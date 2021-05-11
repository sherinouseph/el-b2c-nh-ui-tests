package com.englishtown.enumpack;
/**
 * 2018 @Nikol
 * Payment gateway returns flow status with different values
 *
 * "FlowStatus": "RedirectWait", "Success"
 * Request URL
 * http://paymentgateway.vagrant.f8/paymentflow/standalone
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum PaymentFlowStatus {

    SUCCESS("Success"),
    REDIRECT_WAIT("RedirectWait"),
    FAIL("Fail");

    private final String flowStatus;

    private PaymentFlowStatus(String flowStatus) {
        this.flowStatus = flowStatus;
    }

    public String getFlowStatus(){
        return this.flowStatus;
    }

    private static final Logger logger = LoggerFactory.getLogger(CrmTestType.class);

}
