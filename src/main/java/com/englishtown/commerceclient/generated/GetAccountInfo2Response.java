
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
 *         &lt;element name="GetAccountInfo2Result" type="{EFSchools.Englishtown.Commerce.Client.Accounts}AccountInfo" minOccurs="0"/>
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
    "getAccountInfo2Result"
})
@XmlRootElement(name = "GetAccountInfo2Response")
public class GetAccountInfo2Response {

    @XmlElementRef(name = "GetAccountInfo2Result", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<AccountInfo> getAccountInfo2Result;

    /**
     * Gets the value of the getAccountInfo2Result property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AccountInfo }{@code >}
     *     
     */
    public JAXBElement<AccountInfo> getGetAccountInfo2Result() {
        return getAccountInfo2Result;
    }

    /**
     * Sets the value of the getAccountInfo2Result property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AccountInfo }{@code >}
     *     
     */
    public void setGetAccountInfo2Result(JAXBElement<AccountInfo> value) {
        this.getAccountInfo2Result = value;
    }

}
