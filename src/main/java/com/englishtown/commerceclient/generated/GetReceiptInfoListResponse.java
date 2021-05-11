
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
 *         &lt;element name="GetReceiptInfoListResult" type="{EFSchools.Englishtown.Commerce.Client.Accounts}ArrayOfReceiptInfo" minOccurs="0"/>
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
    "getReceiptInfoListResult"
})
@XmlRootElement(name = "GetReceiptInfoListResponse")
public class GetReceiptInfoListResponse {

    @XmlElementRef(name = "GetReceiptInfoListResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfReceiptInfo> getReceiptInfoListResult;

    /**
     * Gets the value of the getReceiptInfoListResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfReceiptInfo }{@code >}
     *     
     */
    public JAXBElement<ArrayOfReceiptInfo> getGetReceiptInfoListResult() {
        return getReceiptInfoListResult;
    }

    /**
     * Sets the value of the getReceiptInfoListResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfReceiptInfo }{@code >}
     *     
     */
    public void setGetReceiptInfoListResult(JAXBElement<ArrayOfReceiptInfo> value) {
        this.getReceiptInfoListResult = value;
    }

}
