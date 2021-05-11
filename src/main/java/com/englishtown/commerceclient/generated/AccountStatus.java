
package com.englishtown.commerceclient.generated;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AccountStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AccountStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NoneSuchMember"/>
 *     &lt;enumeration value="FreeMember"/>
 *     &lt;enumeration value="FreeAlumniMember"/>
 *     &lt;enumeration value="FreeTrial"/>
 *     &lt;enumeration value="Student"/>
 *     &lt;enumeration value="Suspended"/>
 *     &lt;enumeration value="FreeTownStudent"/>
 *     &lt;enumeration value="FreeTownPremiumStudent"/>
 *     &lt;enumeration value="FreeTrialMarkedForCancelled"/>
 *     &lt;enumeration value="RecurringMarkedForCancelled"/>
 *     &lt;enumeration value="RecurringStudent"/>
 *     &lt;enumeration value="PrepaidStudent"/>
 *     &lt;enumeration value="SinglePaymentOnlineStudent"/>
 *     &lt;enumeration value="InstallmentStudent"/>
 *     &lt;enumeration value="ChargeFailedSuspend"/>
 *     &lt;enumeration value="InstallmentMarkedForCancelled"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AccountStatus", namespace = "EFSchools.Englishtown.Commerce.Client.Accounts")
@XmlEnum
public enum AccountStatus {


    /**
     * <summary>
     * 
     *                                 </summary>
     * 
     */
    @XmlEnumValue("NoneSuchMember")
    NONE_SUCH_MEMBER("NoneSuchMember"),

    /**
     * <summary>
     * 
     *                                 </summary>
     * 
     */
    @XmlEnumValue("FreeMember")
    FREE_MEMBER("FreeMember"),

    /**
     * <summary>
     * 
     *                                 </summary>
     * 
     */
    @XmlEnumValue("FreeAlumniMember")
    FREE_ALUMNI_MEMBER("FreeAlumniMember"),

    /**
     * <summary>
     * 
     *                                 </summary>
     * 
     */
    @XmlEnumValue("FreeTrial")
    FREE_TRIAL("FreeTrial"),

    /**
     * <summary>
     * 
     *                                 </summary>
     * 
     */
    @XmlEnumValue("Student")
    STUDENT("Student"),

    /**
     * <summary>
     * 
     *                                 </summary>
     * 
     */
    @XmlEnumValue("Suspended")
    SUSPENDED("Suspended"),

    /**
     * <summary>
     * 
     *                                 </summary>
     * 
     */
    @XmlEnumValue("FreeTownStudent")
    FREE_TOWN_STUDENT("FreeTownStudent"),

    /**
     * <summary>
     * 
     *                                 </summary>
     * 
     */
    @XmlEnumValue("FreeTownPremiumStudent")
    FREE_TOWN_PREMIUM_STUDENT("FreeTownPremiumStudent"),

    /**
     * <summary>
     * 
     *                                 </summary>
     * 
     */
    @XmlEnumValue("FreeTrialMarkedForCancelled")
    FREE_TRIAL_MARKED_FOR_CANCELLED("FreeTrialMarkedForCancelled"),

    /**
     * <summary>
     * 
     *                                 </summary>
     * 
     */
    @XmlEnumValue("RecurringMarkedForCancelled")
    RECURRING_MARKED_FOR_CANCELLED("RecurringMarkedForCancelled"),

    /**
     * <summary>
     * 
     *                                 </summary>
     * 
     */
    @XmlEnumValue("RecurringStudent")
    RECURRING_STUDENT("RecurringStudent"),

    /**
     * <summary>
     * 
     *                                 </summary>
     * 
     */
    @XmlEnumValue("PrepaidStudent")
    PREPAID_STUDENT("PrepaidStudent"),

    /**
     * <summary>
     * 
     *                                 </summary>
     * 
     */
    @XmlEnumValue("SinglePaymentOnlineStudent")
    SINGLE_PAYMENT_ONLINE_STUDENT("SinglePaymentOnlineStudent"),

    /**
     * <summary>
     * 
     *                                 </summary>
     * 
     */
    @XmlEnumValue("InstallmentStudent")
    INSTALLMENT_STUDENT("InstallmentStudent"),

    /**
     * <summary>
     * 
     *                                 </summary>
     * 
     */
    @XmlEnumValue("ChargeFailedSuspend")
    CHARGE_FAILED_SUSPEND("ChargeFailedSuspend"),

    /**
     * <summary>
     * 
     *                                 </summary>
     * 
     */
    @XmlEnumValue("InstallmentMarkedForCancelled")
    INSTALLMENT_MARKED_FOR_CANCELLED("InstallmentMarkedForCancelled");
    private final String value;

    AccountStatus(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AccountStatus fromValue(String v) {
        for (AccountStatus c: AccountStatus.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
