
package com.englishtown.commerceclient.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for InvalidateMemberParams complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InvalidateMemberParams">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Member_id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="IncludeIntegratedMemberInfoInResult" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InvalidateMemberParams", namespace = "EFSchools.Englishtown.Commerce.Client.Members", propOrder = {
    "memberId",
    "includeIntegratedMemberInfoInResult"
})
public class InvalidateMemberParams {

    @XmlElement(name = "Member_id")
    protected Integer memberId;
    @XmlElement(name = "IncludeIntegratedMemberInfoInResult")
    protected Boolean includeIntegratedMemberInfoInResult;

    /**
     * Gets the value of the memberId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMemberId() {
        return memberId;
    }

    /**
     * Sets the value of the memberId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMemberId(Integer value) {
        this.memberId = value;
    }

    /**
     * Gets the value of the includeIntegratedMemberInfoInResult property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncludeIntegratedMemberInfoInResult() {
        return includeIntegratedMemberInfoInResult;
    }

    /**
     * Sets the value of the includeIntegratedMemberInfoInResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludeIntegratedMemberInfoInResult(Boolean value) {
        this.includeIntegratedMemberInfoInResult = value;
    }

}
