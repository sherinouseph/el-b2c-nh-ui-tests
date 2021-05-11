
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
 *         &lt;element name="SendForgotPwdEmailResult" type="{EFSchools.Englishtown.Commerce.Client.Members}SendForgotPwdEmailResult" minOccurs="0"/>
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
    "sendForgotPwdEmailResult"
})
@XmlRootElement(name = "SendForgotPwdEmailResponse")
public class SendForgotPwdEmailResponse {

    @XmlElementRef(name = "SendForgotPwdEmailResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<SendForgotPwdEmailResult> sendForgotPwdEmailResult;

    /**
     * Gets the value of the sendForgotPwdEmailResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link SendForgotPwdEmailResult }{@code >}
     *     
     */
    public JAXBElement<SendForgotPwdEmailResult> getSendForgotPwdEmailResult() {
        return sendForgotPwdEmailResult;
    }

    /**
     * Sets the value of the sendForgotPwdEmailResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link SendForgotPwdEmailResult }{@code >}
     *     
     */
    public void setSendForgotPwdEmailResult(JAXBElement<SendForgotPwdEmailResult> value) {
        this.sendForgotPwdEmailResult = value;
    }

}
