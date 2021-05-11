
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
 *         &lt;element name="CreateAccountForMemberResult" type="{EFSchools.Englishtown.Commerce.Client.Accounts}CreateAccountResult" minOccurs="0"/>
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
    "createAccountForMemberResult"
})
@XmlRootElement(name = "CreateAccountForMemberResponse")
public class CreateAccountForMemberResponse {

    @XmlElementRef(name = "CreateAccountForMemberResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<CreateAccountResult> createAccountForMemberResult;

    /**
     * Gets the value of the createAccountForMemberResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link CreateAccountResult }{@code >}
     *     
     */
    public JAXBElement<CreateAccountResult> getCreateAccountForMemberResult() {
        return createAccountForMemberResult;
    }

    /**
     * Sets the value of the createAccountForMemberResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link CreateAccountResult }{@code >}
     *     
     */
    public void setCreateAccountForMemberResult(JAXBElement<CreateAccountResult> value) {
        this.createAccountForMemberResult = value;
    }

}
