package com.englishtown.newhouse.salesforce.enumpack;

/**
 *
 */
public enum RetentionRecordType {
    BRAZIL("Brazil "),
    EUROPE("Europe "),
    MEXICO("Mexico "),
    TAIWAN("Taiwan ");


    String retentionRecordType;

    RetentionRecordType(String retentionRecordType){
        this.retentionRecordType = retentionRecordType;
    }

    public String getRetentionRecordType(){
        return retentionRecordType;
    }

}
