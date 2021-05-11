
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
 *         &lt;element name="GetCorporateMemberResult" type="{EFSchools.Englishtown.Commerce.Client.Members}CorporateMember" minOccurs="0"/>
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
    "getCorporateMemberResult"
})
@XmlRootElement(name = "GetCorporateMemberResponse")
public class GetCorporateMemberResponse {

    @XmlElementRef(name = "GetCorporateMemberResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<CorporateMember> getCorporateMemberResult;

    /**
     * Gets the value of the getCorporateMemberResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link CorporateMember }{@code >}
     *     
     */
    public JAXBElement<CorporateMember> getGetCorporateMemberResult() {
        return getCorporateMemberResult;
    }

    /**
     * Sets the value of the getCorporateMemberResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link CorporateMember }{@code >}
     *     
     */
    public void setGetCorporateMemberResult(JAXBElement<CorporateMember> value) {
        this.getCorporateMemberResult = value;
    }

}
