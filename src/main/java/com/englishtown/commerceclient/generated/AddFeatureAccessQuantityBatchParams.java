
package com.englishtown.commerceclient.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AddFeatureAccessQuantityBatchParams complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AddFeatureAccessQuantityBatchParams">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="featureAccess_id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="memberIds" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfint"/>
 *         &lt;element name="quantity" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AddFeatureAccessQuantityBatchParams", namespace = "EFSchools.Englishtown.Commerce.Client.Accounts", propOrder = {
    "featureAccessId",
    "memberIds",
    "quantity"
})
public class AddFeatureAccessQuantityBatchParams {

    @XmlElement(name = "featureAccess_id")
    protected int featureAccessId;
    @XmlElement(required = true, nillable = true)
    protected ArrayOfint memberIds;
    protected int quantity;

    /**
     * Gets the value of the featureAccessId property.
     * 
     */
    public int getFeatureAccessId() {
        return featureAccessId;
    }

    /**
     * Sets the value of the featureAccessId property.
     * 
     */
    public void setFeatureAccessId(int value) {
        this.featureAccessId = value;
    }

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
     * Gets the value of the quantity property.
     * 
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the value of the quantity property.
     * 
     */
    public void setQuantity(int value) {
        this.quantity = value;
    }

}
