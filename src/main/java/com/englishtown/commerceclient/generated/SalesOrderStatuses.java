
package com.englishtown.commerceclient.generated;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SalesOrderStatuses.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="SalesOrderStatuses">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Unknown"/>
 *     &lt;enumeration value="New"/>
 *     &lt;enumeration value="Pending"/>
 *     &lt;enumeration value="Ordered"/>
 *     &lt;enumeration value="Error"/>
 *     &lt;enumeration value="Cancelled"/>
 *     &lt;enumeration value="Suspended"/>
 *     &lt;enumeration value="Completed"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "SalesOrderStatuses", namespace = "http://schemas.datacontract.org/2004/07/EFSchools.Englishtown.Commerce.Orders")
@XmlEnum
public enum SalesOrderStatuses {

    @XmlEnumValue("Unknown")
    UNKNOWN("Unknown"),
    @XmlEnumValue("New")
    NEW("New"),
    @XmlEnumValue("Pending")
    PENDING("Pending"),
    @XmlEnumValue("Ordered")
    ORDERED("Ordered"),
    @XmlEnumValue("Error")
    ERROR("Error"),
    @XmlEnumValue("Cancelled")
    CANCELLED("Cancelled"),
    @XmlEnumValue("Suspended")
    SUSPENDED("Suspended"),
    @XmlEnumValue("Completed")
    COMPLETED("Completed");
    private final String value;

    SalesOrderStatuses(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SalesOrderStatuses fromValue(String v) {
        for (SalesOrderStatuses c: SalesOrderStatuses.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
