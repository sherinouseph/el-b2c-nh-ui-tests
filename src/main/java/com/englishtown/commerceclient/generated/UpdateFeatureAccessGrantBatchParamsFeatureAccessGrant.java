
package com.englishtown.commerceclient.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for UpdateFeatureAccessGrantBatchParams_FeatureAccessGrant complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UpdateFeatureAccessGrantBatchParams_FeatureAccessGrant">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Grant_id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Quantity" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="ActiveFrom" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="ActiveTo" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UpdateFeatureAccessGrantBatchParams_FeatureAccessGrant", namespace = "EFSchools.Englishtown.Commerce.Client.Accounts", propOrder = {
    "grantId",
    "quantity",
    "activeFrom",
    "activeTo"
})
public class UpdateFeatureAccessGrantBatchParamsFeatureAccessGrant {

    @XmlElement(name = "Grant_id")
    protected int grantId;
    @XmlElement(name = "Quantity")
    protected Integer quantity;
    @XmlElement(name = "ActiveFrom")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar activeFrom;
    @XmlElement(name = "ActiveTo")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar activeTo;

    /**
     * Gets the value of the grantId property.
     * 
     */
    public int getGrantId() {
        return grantId;
    }

    /**
     * Sets the value of the grantId property.
     * 
     */
    public void setGrantId(int value) {
        this.grantId = value;
    }

    /**
     * Gets the value of the quantity property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * Sets the value of the quantity property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setQuantity(Integer value) {
        this.quantity = value;
    }

    /**
     * Gets the value of the activeFrom property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getActiveFrom() {
        return activeFrom;
    }

    /**
     * Sets the value of the activeFrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setActiveFrom(XMLGregorianCalendar value) {
        this.activeFrom = value;
    }

    /**
     * Gets the value of the activeTo property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getActiveTo() {
        return activeTo;
    }

    /**
     * Sets the value of the activeTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setActiveTo(XMLGregorianCalendar value) {
        this.activeTo = value;
    }

}
