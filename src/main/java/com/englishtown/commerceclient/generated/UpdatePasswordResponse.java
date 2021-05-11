
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
 *         &lt;element name="UpdatePasswordResult" type="{EFSchools.Englishtown.Commerce.Client.Accounts}UpdateMemberResult" minOccurs="0"/>
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
    "updatePasswordResult"
})
@XmlRootElement(name = "UpdatePasswordResponse")
public class UpdatePasswordResponse {

    @XmlElementRef(name = "UpdatePasswordResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<UpdateMemberResult> updatePasswordResult;

    /**
     * Gets the value of the updatePasswordResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link UpdateMemberResult }{@code >}
     *     
     */
    public JAXBElement<UpdateMemberResult> getUpdatePasswordResult() {
        return updatePasswordResult;
    }

    /**
     * Sets the value of the updatePasswordResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link UpdateMemberResult }{@code >}
     *     
     */
    public void setUpdatePasswordResult(JAXBElement<UpdateMemberResult> value) {
        this.updatePasswordResult = value;
    }

}
