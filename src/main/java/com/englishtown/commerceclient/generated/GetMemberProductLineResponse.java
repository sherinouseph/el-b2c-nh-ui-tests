
package com.englishtown.commerceclient.generated;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GetMemberProductLineResult" type="{EFSchools.Englishtown.Commerce.Client.Accounts}GetMemberProductLineResult" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "getMemberProductLineResult"
})
@XmlRootElement(name = "GetMemberProductLineResponse")
public class GetMemberProductLineResponse {

    @XmlElementRef(name = "GetMemberProductLineResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<GetMemberProductLineResult> getMemberProductLineResult;

    /**
     * Gets the value of the getMemberProductLineResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link GetMemberProductLineResult }{@code >}
     *     
     */
    public JAXBElement<GetMemberProductLineResult> getGetMemberProductLineResult() {
        return getMemberProductLineResult;
    }

    /**
     * Sets the value of the getMemberProductLineResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link GetMemberProductLineResult }{@code >}
     *     
     */
    public void setGetMemberProductLineResult(JAXBElement<GetMemberProductLineResult> value) {
        this.getMemberProductLineResult = value;
    }

}
