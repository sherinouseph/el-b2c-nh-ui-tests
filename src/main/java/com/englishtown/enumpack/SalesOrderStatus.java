package com.englishtown.enumpack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.annotation.XmlEnumValue;

public enum SalesOrderStatus {

    UNKNOWN("Unknown"),

    NEW("New"),

    PENDING("Pending"),

    ORDERED("Ordered"),

    ERROR("Error"),

    CANCELLED("Cancelled"),

    SUSPENDED("Suspended"),

    COMPLETED("Completed");


    private final String salesOrderStatus;

    private SalesOrderStatus(String salesOrderStatus) {
        this.salesOrderStatus = salesOrderStatus;
    }

    public String getSalesOrderStatus(){
        return this.salesOrderStatus;
    }

    private static final Logger logger = LoggerFactory.getLogger(SalesOrderStatus.class);

}
