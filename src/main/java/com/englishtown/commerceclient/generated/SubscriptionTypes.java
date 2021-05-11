
package com.englishtown.commerceclient.generated;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SubscriptionTypes.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="SubscriptionTypes">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="SelfStudy"/>
 *     &lt;enumeration value="TeacherLed"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "SubscriptionTypes", namespace = "EFSchools.Englishtown.Commerce.Client.Subscriptions")
@XmlEnum
public enum SubscriptionTypes {


    /**
     * <summary>
     * 
     *                                 </summary>
     * 
     */
    @XmlEnumValue("SelfStudy")
    SELF_STUDY("SelfStudy"),

    /**
     * <summary>
     * 
     *                                 </summary>
     * 
     */
    @XmlEnumValue("TeacherLed")
    TEACHER_LED("TeacherLed");
    private final String value;

    SubscriptionTypes(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SubscriptionTypes fromValue(String v) {
        for (SubscriptionTypes c: SubscriptionTypes.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
