
package com.englishtown.commerceclient.generated;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ExtendAccountType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ExtendAccountType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Days"/>
 *     &lt;enumeration value="Date"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ExtendAccountType", namespace = "EFSchools.Englishtown.Commerce.Client.Accounts")
@XmlEnum
public enum ExtendAccountType {

    @XmlEnumValue("Days")
    DAYS("Days"),
    @XmlEnumValue("Date")
    DATE("Date");
    private final String value;

    ExtendAccountType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ExtendAccountType fromValue(String v) {
        for (ExtendAccountType c: ExtendAccountType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
