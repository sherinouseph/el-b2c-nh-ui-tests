
package com.englishtown.commerceclient.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <summary>
 * 
 *                         </summary>
 * 
 * <p>Java class for MemberJobIndustryLkp complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MemberJobIndustryLkp">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Code" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DisplayOrder" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Descr" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Blurb_id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ValidDateFrom" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="ValidDateTo" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MemberJobIndustryLkp", namespace = "EFSchools.Englishtown.Commerce.Client.Members", propOrder = {
    "code",
    "name",
    "displayOrder",
    "descr",
    "blurbId",
    "validDateFrom",
    "validDateTo"
})
public class MemberJobIndustryLkp {

    @XmlElement(name = "Code", required = true, nillable = true)
    protected String code;
    @XmlElement(name = "Name", required = true, nillable = true)
    protected String name;
    @XmlElement(name = "DisplayOrder")
    protected int displayOrder;
    @XmlElement(name = "Descr", required = true, nillable = true)
    protected String descr;
    @XmlElement(name = "Blurb_id")
    protected int blurbId;
    @XmlElement(name = "ValidDateFrom", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar validDateFrom;
    @XmlElement(name = "ValidDateTo", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar validDateTo;

    /**
     * Gets the value of the code property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCode(String value) {
        this.code = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
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
     * Gets the value of the descr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescr() {
        return descr;
    }

    /**
     * Sets the value of the descr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescr(String value) {
        this.descr = value;
    }

    /**
     * Gets the value of the blurbId property.
     * 
     */
    public int getBlurbId() {
        return blurbId;
    }

    /**
     * Sets the value of the blurbId property.
     * 
     */
    public void setBlurbId(int value) {
        this.blurbId = value;
    }

    /**
     * Gets the value of the validDateFrom property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getValidDateFrom() {
        return validDateFrom;
    }

    /**
     * Sets the value of the validDateFrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setValidDateFrom(XMLGregorianCalendar value) {
        this.validDateFrom = value;
    }

    /**
     * Gets the value of the validDateTo property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getValidDateTo() {
        return validDateTo;
    }

    /**
     * Sets the value of the validDateTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setValidDateTo(XMLGregorianCalendar value) {
        this.validDateTo = value;
    }

}
