package com.englishtown.enumpack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum OfferType {

    DEFAULT(""),
    ALL("All"),
    UNKNOWN("Unknown"),
    UPSELL("Upsell"),
    SUBSCRIPTION("Subscription"),
    FREE("Free"),
    SME("SME");


    private final String offerType;

    private OfferType(String offerType) {
        this.offerType = offerType;
    }

    public String getOfferType(){
        return this.offerType;
    }

    private static final Logger logger = LoggerFactory.getLogger(OfferType.class);

}
