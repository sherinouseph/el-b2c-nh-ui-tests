
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
 * <p>Java class for CancellationReasonCategory complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CancellationReasonCategory">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CategoryCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="NameBlurbId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="DisplayOrder" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="IsInternalUse" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CancellationReasonCategory", namespace = "EFSchools.Englishtown.Commerce.Client.Subscriptions", propOrder = {
    "categoryCode",
    "nameBlurbId",
    "displayOrder",
    "isInternalUse"
})
public class CancellationReasonCategory {

    @XmlElement(name = "CategoryCode", required = true, nillable = true)
    protected String categoryCode;
    @XmlElement(name = "NameBlurbId")
    protected int nameBlurbId;
    @XmlElement(name = "DisplayOrder")
    protected int displayOrder;
    @XmlElement(name = "IsInternalUse")
    protected boolean isInternalUse;

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
     */
    public boolean isIsInternalUse() {
        return isInternalUse;
    }

    /**
     * Sets the value of the isInternalUse property.
     * 
     */
    public void setIsInternalUse(boolean value) {
        this.isInternalUse = value;
    }

}
