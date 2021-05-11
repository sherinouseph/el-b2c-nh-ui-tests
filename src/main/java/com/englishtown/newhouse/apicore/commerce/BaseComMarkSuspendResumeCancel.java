package com.englishtown.newhouse.apicore.commerce;
/**
 * Nikol 2017 Dec
 Note: Mark cancelled will cancel after the current faze.
 Test order for cancel/mark and suspend
 1. MarkCancelled – getMember should show CancellationMark: true : need some api to be able to check the the student is cancelled at the end of faze ...
 2. Unmarked
 3. Suspend
 4. Resume
 5. Cancel
 6. get member
 7. get order check is cancelled

 * check response data
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;


public class BaseComMarkSuspendResumeCancel extends BaseCommercePurchaseSpec {
    public static final Logger logger = LoggerFactory.getLogger(BaseComMarkSuspendResumeCancel.class);


    @Test(dependsOnMethods = "commercePurchaseTest")
    public void markCancelTest() {
        commerceMarkCancelled();
    }

    @Test(dependsOnMethods = "markCancelTest")
    public void getMemberCheckMarkedCancelledTest() {
        resultCancellationMark = true;
        commerceGetMember();
    }

    @Test(dependsOnMethods = "getMemberCheckMarkedCancelledTest")
    public void unMarkCancelledTest() {
        commerceUnMarkCancelled();
    }

    @Test(dependsOnMethods = "unMarkCancelledTest")
    public void getMemberCheckUnMarkedCancelledTest() {
        resultCancellationMark = false;
        resultHasCancellationReason = false;
        commerceGetMember();
    }

    @Test(dependsOnMethods = "getMemberCheckUnMarkedCancelledTest")
    public void suspendMemberTest() {
        commerceSuspendMember();
    }

    @Test(dependsOnMethods = "suspendMemberTest")
    public void resumeMemberTest() {
        commerceResumeMember();
    }

    @Test(dependsOnMethods = "resumeMemberTest")
    public void cancelMemberTest() {
        commerceCancelMember();
    }

    @Test(dependsOnMethods = "cancelMemberTest")
    public void getMemberCheckIsCancelledTest() {
        resultCancellationMark = false;
        resultStatus = "Inactive";
        resultHasCancellationReason = true;
        commerceGetMember();
    }

    @Test(dependsOnMethods = "getMemberCheckIsCancelledTest")
    public void getOrderCheckStatusTest() {
        isOrderCancelled = true;
        commerceGetOrder(commerceGetOrderUrl);
    }


}

