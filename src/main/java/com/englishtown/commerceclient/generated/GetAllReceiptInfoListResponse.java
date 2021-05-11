
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
 *         &lt;element name="GetAllReceiptInfoListResult" type="{EFSchools.Englishtown.Commerce.Client.Accounts}ArrayOfReceiptInfo" minOccurs="0"/>
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
    "getAllReceiptInfoListResult"
})
@XmlRootElement(name = "GetAllReceiptInfoListResponse")
public class GetAllReceiptInfoListResponse {

    @XmlElementRef(name = "GetAllReceiptInfoListResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfReceiptInfo> getAllReceiptInfoListResult;

    /**
     * Gets the value of the getAllReceiptInfoListResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfReceiptInfo }{@code >}
     *     
     */
    public JAXBElement<ArrayOfReceiptInfo> getGetAllReceiptInfoListResult() {
        return getAllReceiptInfoListResult;
    }

    /**
     * Sets the value of the getAllReceiptInfoListResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfReceiptInfo }{@code >}
     *     
     */
    public void setGetAllReceiptInfoListResult(JAXBElement<ArrayOfReceiptInfo> value) {
        this.getAllReceiptInfoListResult = value;
    }

}
