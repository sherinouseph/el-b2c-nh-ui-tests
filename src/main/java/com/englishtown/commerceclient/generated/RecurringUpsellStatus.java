
package com.englishtown.commerceclient.generated;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RecurringUpsellStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RecurringUpsellStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NotAvailable"/>
 *     &lt;enumeration value="NoUpsell_OneEuroNotConsumed"/>
 *     &lt;enumeration value="NoUpsell_OneEuroConsumed"/>
 *     &lt;enumeration value="Upsell_OneEuro"/>
 *     &lt;enumeration value="Upsell_Other"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RecurringUpsellStatus", namespace = "EFSchools.Englishtown.Commerce.Client.Orders")
@XmlEnum
public enum RecurringUpsellStatus {


    /**
     * <summary>
     *                                 The student's status is not configured to be calculated
     *                                 </summary>
     * 
     */
    @XmlEnumValue("NotAvailable")
    NOT_AVAILABLE("NotAvailable"),

    /**
     * <summary>
     *                                 The student currently has no recurring charged upsell, and never consumed recurring
     *                                 charged 1-Euro offer
     *                                 </summary>
     * 
     */
    @XmlEnumValue("NoUpsell_OneEuroNotConsumed")
    NO_UPSELL_ONE_EURO_NOT_CONSUMED("NoUpsell_OneEuroNotConsumed"),

    /**
     * <summary>
     *                                 The student currently has no recurring charged upsell, but once consumed recurring
     *                                 charged 1-Euro offer
     *                                 </summary>
     * 
     */
    @XmlEnumValue("NoUpsell_OneEuroConsumed")
    NO_UPSELL_ONE_EURO_CONSUMED("NoUpsell_OneEuroConsumed"),

    /**
     * <summary>
     *                                 The student is currently paying the 1-Euro recurring charged offer
     *                                 </summary>
     * 
     */
    @XmlEnumValue("Upsell_OneEuro")
    UPSELL_ONE_EURO("Upsell_OneEuro"),

    /**
     * <summary>
     *                                 The student is currently paying other recurring charged offer
     *                                 </summary>
     * 
     */
    @XmlEnumValue("Upsell_Other")
    UPSELL_OTHER("Upsell_Other");
    private final String value;

    RecurringUpsellStatus(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static RecurringUpsellStatus fromValue(String v) {
        for (RecurringUpsellStatus c: RecurringUpsellStatus.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
