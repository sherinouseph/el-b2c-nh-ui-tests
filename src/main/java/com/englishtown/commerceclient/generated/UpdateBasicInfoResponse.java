
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
 *         &lt;element name="UpdateBasicInfoResult" type="{EFSchools.Englishtown.Commerce.Client.Accounts}UpdateMemberResult" minOccurs="0"/>
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
    "updateBasicInfoResult"
})
@XmlRootElement(name = "UpdateBasicInfoResponse")
public class UpdateBasicInfoResponse {

    @XmlElementRef(name = "UpdateBasicInfoResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<UpdateMemberResult> updateBasicInfoResult;

    /**
     * Gets the value of the updateBasicInfoResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link UpdateMemberResult }{@code >}
     *     
     */
    public JAXBElement<UpdateMemberResult> getUpdateBasicInfoResult() {
        return updateBasicInfoResult;
    }

    /**
     * Sets the value of the updateBasicInfoResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link UpdateMemberResult }{@code >}
     *     
     */
    public void setUpdateBasicInfoResult(JAXBElement<UpdateMemberResult> value) {
        this.updateBasicInfoResult = value;
    }

}
