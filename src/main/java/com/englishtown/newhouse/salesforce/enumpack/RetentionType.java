package com.englishtown.newhouse.salesforce.enumpack;

/**
 *
 */
public enum RetentionType {
    DEFAULT("--None--"),
    EXTEND("Extend"),
    CANCELLATION("Cancellation"),
    REFUND("Refund"),
    OTHER("Others"),
    DISCOUNT("Discount"),
    SUSPEND("Suspend");



    String retentionType;

    RetentionType(String retentionType){
        this.retentionType = retentionType;
    }

    public String getRetentionType(){
        return retentionType;
    }

}
