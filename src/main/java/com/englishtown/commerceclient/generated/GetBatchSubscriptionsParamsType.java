
package com.englishtown.commerceclient.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetBatchSubscriptionsParamsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetBatchSubscriptionsParamsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MemberIds" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfint"/>
 *         &lt;element name="ActiveOnly" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetBatchSubscriptionsParamsType", namespace = "EFSchools.Englishtown.Commerce.Client.Subscriptions", propOrder = {
    "memberIds",
    "activeOnly"
})
public class GetBatchSubscriptionsParamsType {

    @XmlElement(name = "MemberIds", required = true, nillable = true)
    protected ArrayOfint memberIds;
    @XmlElement(name = "ActiveOnly")
    protected boolean activeOnly;

    /**
     * Gets the value of the memberIds property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfint }
     *     
     */
    public ArrayOfint getMemberIds() {
        return memberIds;
    }

    /**
     * Sets the value of the memberIds property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfint }
     *     
     */
    public void setMemberIds(ArrayOfint value) {
        this.memberIds = value;
    }

    /**
     * Gets the value of the activeOnly property.
     * 
     */
    public boolean isActiveOnly() {
        return activeOnly;
    }

    /**
     * Sets the value of the activeOnly property.
     * 
     */
    public void setActiveOnly(boolean value) {
        this.activeOnly = value;
    }

}
