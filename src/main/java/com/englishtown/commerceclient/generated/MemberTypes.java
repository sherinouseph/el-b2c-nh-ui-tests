
package com.englishtown.commerceclient.generated;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MemberTypes.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="MemberTypes">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Unknown"/>
 *     &lt;enumeration value="Member"/>
 *     &lt;enumeration value="SuperMember"/>
 *     &lt;enumeration value="Student"/>
 *     &lt;enumeration value="Teacher"/>
 *     &lt;enumeration value="Advisor"/>
 *     &lt;enumeration value="Manager"/>
 *     &lt;enumeration value="ManagerTransfer"/>
 *     &lt;enumeration value="SuperManager"/>
 *     &lt;enumeration value="ILabTeacher"/>
 *     &lt;enumeration value="ILabActivityDirector"/>
 *     &lt;enumeration value="ILabSalesMan"/>
 *     &lt;enumeration value="ILabAgent"/>
 *     &lt;enumeration value="ILabAdmin"/>
 *     &lt;enumeration value="ILabSuperAdmin"/>
 *     &lt;enumeration value="COSA"/>
 *     &lt;enumeration value="COA"/>
 *     &lt;enumeration value="Sales"/>
 *     &lt;enumeration value="Agent"/>
 *     &lt;enumeration value="SuperAgent"/>
 *     &lt;enumeration value="SoftFB"/>
 *     &lt;enumeration value="Admin"/>
 *     &lt;enumeration value="SuperAdmin"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "MemberTypes", namespace = "http://schemas.datacontract.org/2004/07/EFSchools.Englishtown.MembersET")
@XmlEnum
public enum MemberTypes {


    /**
     * <summary>
     * 
     *                                 </summary>
     * 
     */
    @XmlEnumValue("Unknown")
    UNKNOWN("Unknown"),

    /**
     * <summary>
     * 
     *                                 </summary>
     * 
     */
    @XmlEnumValue("Member")
    MEMBER("Member"),

    /**
     * <summary>
     * 
     *                                 </summary>
     * 
     */
    @XmlEnumValue("SuperMember")
    SUPER_MEMBER("SuperMember"),

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
    @XmlEnumValue("Teacher")
    TEACHER("Teacher"),

    /**
     * <summary>
     * 
     *                                 </summary>
     * 
     */
    @XmlEnumValue("Advisor")
    ADVISOR("Advisor"),

    /**
     * <summary>
     * 
     *                                 </summary>
     * 
     */
    @XmlEnumValue("Manager")
    MANAGER("Manager"),

    /**
     * <summary>
     * 
     *                                 </summary>
     * 
     */
    @XmlEnumValue("ManagerTransfer")
    MANAGER_TRANSFER("ManagerTransfer"),

    /**
     * <summary>
     * 
     *                                 </summary>
     * 
     */
    @XmlEnumValue("SuperManager")
    SUPER_MANAGER("SuperManager"),

    /**
     * <summary>
     * 
     *                                 </summary>
     * 
     */
    @XmlEnumValue("ILabTeacher")
    I_LAB_TEACHER("ILabTeacher"),

    /**
     * <summary>
     * 
     *                                 </summary>
     * 
     */
    @XmlEnumValue("ILabActivityDirector")
    I_LAB_ACTIVITY_DIRECTOR("ILabActivityDirector"),

    /**
     * <summary>
     * 
     *                                 </summary>
     * 
     */
    @XmlEnumValue("ILabSalesMan")
    I_LAB_SALES_MAN("ILabSalesMan"),

    /**
     * <summary>
     * 
     *                                 </summary>
     * 
     */
    @XmlEnumValue("ILabAgent")
    I_LAB_AGENT("ILabAgent"),

    /**
     * <summary>
     * 
     *                                 </summary>
     * 
     */
    @XmlEnumValue("ILabAdmin")
    I_LAB_ADMIN("ILabAdmin"),

    /**
     * <summary>
     * 
     *                                 </summary>
     * 
     */
    @XmlEnumValue("ILabSuperAdmin")
    I_LAB_SUPER_ADMIN("ILabSuperAdmin"),

    /**
     * <summary>
     * 
     *                                 </summary>
     * 
     */
    COSA("COSA"),

    /**
     * <summary>
     * 
     *                                 </summary>
     * 
     */
    COA("COA"),

    /**
     * <summary>
     * 
     *                                 </summary>
     * 
     */
    @XmlEnumValue("Sales")
    SALES("Sales"),

    /**
     * <summary>
     * 
     *                                 </summary>
     * 
     */
    @XmlEnumValue("Agent")
    AGENT("Agent"),

    /**
     * <summary>
     * 
     *                                 </summary>
     * 
     */
    @XmlEnumValue("SuperAgent")
    SUPER_AGENT("SuperAgent"),

    /**
     * <summary>
     * 
     *                                 </summary>
     * 
     */
    @XmlEnumValue("SoftFB")
    SOFT_FB("SoftFB"),

    /**
     * <summary>
     * 
     *                                 </summary>
     * 
     */
    @XmlEnumValue("Admin")
    ADMIN("Admin"),

    /**
     * <summary>
     * 
     *                                 </summary>
     * 
     */
    @XmlEnumValue("SuperAdmin")
    SUPER_ADMIN("SuperAdmin");
    private final String value;

    MemberTypes(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static MemberTypes fromValue(String v) {
        for (MemberTypes c: MemberTypes.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
