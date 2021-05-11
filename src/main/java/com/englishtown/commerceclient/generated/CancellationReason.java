
package com.englishtown.commerceclient.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <summary>
 * 
 *                         </summary>
 * 
 * <p>Java class for CancellationReason complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CancellationReason">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ReasonCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="NameBlurbId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="CategoryCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DisplayOrder" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="IsInternalUse" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CancellationReason", namespace = "EFSchools.Englishtown.Commerce.Client.Subscriptions", propOrder = {
    "reasonCode",
    "nameBlurbId",
    "categoryCode",
    "displayOrder",
    "isInternalUse"
})
public class CancellationReason {

    @XmlElement(name = "ReasonCode", required = true, nillable = true)
    protected String reasonCode;
    @XmlElement(name = "NameBlurbId")
    protected int nameBlurbId;
    @XmlElement(name = "CategoryCode", required = true, nillable = true)
    protected String categoryCode;
    @XmlElement(name = "DisplayOrder")
    protected int displayOrder;
    @XmlElement(name = "IsInternalUse")
    protected Boolean isInternalUse;

    /**
     * Gets the value of the reasonCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReasonCode() {
        return reasonCode;
    }

    /**
     * Sets the value of the reasonCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReasonCode(String value) {
        this.reasonCode = value;
    }

    /**
     * Gets the value of the nameBlurbId property.
     * 
     */
    public int getNameBlurbId() {
        return nameBlurbId;
    }

    /**
     * Sets the value of the nameBlurbId property.
     * 
     */
    public void setNameBlurbId(int value) {
        this.nameBlurbId = value;
    }

    /**
     * Gets the value of the categoryCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCategoryCode() {
        return categoryCode;
    }

    /**
     * Sets the value of the categoryCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCategoryCode(String value) {
        this.categoryCode = value;
    }

    /**
     * Gets the value of the displayOrder property.
     * 
     */
    public int getDisplayOrder() {
        return displayOrder;
    }

    /**
     * Sets the value of the displayOrder property.
     * 
     */
    public void setDisplayOrder(int value) {
        this.displayOrder = value;
    }

    /**
     * Gets the value of the isInternalUse property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsInternalUse() {
        return isInternalUse;
    }

    /**
     * Sets the value of the isInternalUse property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsInternalUse(Boolean value) {
        this.isInternalUse = value;
    }

}
