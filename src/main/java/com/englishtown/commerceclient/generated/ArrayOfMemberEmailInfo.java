
package com.englishtown.commerceclient.generated;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfMemberEmailInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfMemberEmailInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MemberEmailInfo" type="{EFSchools.Englishtown.Commerce.Client.Members}MemberEmailInfo" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfMemberEmailInfo", namespace = "EFSchools.Englishtown.Commerce.Client.Members", propOrder = {
    "memberEmailInfo"
})
public class ArrayOfMemberEmailInfo {

    @XmlElement(name = "MemberEmailInfo", nillable = true)
    protected List<MemberEmailInfo> memberEmailInfo;

    /**
     * Gets the value of the memberEmailInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the memberEmailInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMemberEmailInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MemberEmailInfo }
     * 
     * 
     */
    public List<MemberEmailInfo> getMemberEmailInfo() {
        if (memberEmailInfo == null) {
            memberEmailInfo = new ArrayList<MemberEmailInfo>();
        }
        return this.memberEmailInfo;
    }

}
