package com.englishtown.newhouse.salesforce.enumpack;

/**
 *
 */
public enum RetentionStatus {
    DEFAULT("--None-- "),
    NOTRETAINED("Not retained"),
    INRETENTION("In retention"),
    PENDINGSUPERVISORAPPROVAL("Pending supervisor approval"),
    PENDINGAPPROVAL("Pending audit approval");


    String retentionStatus;

    RetentionStatus(String retentionStatus){
        this.retentionStatus = retentionStatus;
    }

    public String getRetentionStatus(){
        return retentionStatus;
    }

}
