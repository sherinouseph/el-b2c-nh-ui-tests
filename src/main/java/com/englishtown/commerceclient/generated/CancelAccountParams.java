
package com.englishtown.commerceclient.generated;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CancelAccountParams complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CancelAccountParams">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Member_id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Reason" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Comments" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CancelAccountParams", namespace = "EFSchools.Englishtown.Commerce.Client.Accounts", propOrder = {
    "memberId",
    "reason",
    "comments"
})
public class CancelAccountParams {

    @XmlElement(name = "Member_id")
    protected int memberId;
    @XmlElement(name = "Reason", required = true, nillable = true)
    protected String reason;
    @XmlElementRef(name = "Comments", namespace = "EFSchools.Englishtown.Commerce.Client.Accounts", type = JAXBElement.class, required = false)
    protected JAXBElement<String> comments;

    /**
     * Gets the value of the memberId property.
     * 
     */
    public int getMemberId() {
        return memberId;
    }

    /**
     * Sets the value of the memberId property.
     * 
     */
    public void setMemberId(int value) {
        this.memberId = value;
    }

    /**
     * Gets the value of the reason property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReason() {
        return reason;
    }

    /**
     * Sets the value of the reason property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReason(String value) {
        this.reason = value;
    }

    /**
     * Gets the value of the comments property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getComments() {
        return comments;
    }

    /**
     * Sets the value of the comments property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setComments(JAXBElement<String> value) {
        this.comments = value;
    }

}
