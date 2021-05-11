
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
 *         &lt;element name="SendCurrentPwdMailResult" type="{EFSchools.Englishtown.Commerce.Client.Members}SendForgotPwdEmailResult" minOccurs="0"/>
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
    "sendCurrentPwdMailResult"
})
@XmlRootElement(name = "SendCurrentPwdMailResponse")
public class SendCurrentPwdMailResponse {

    @XmlElementRef(name = "SendCurrentPwdMailResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<SendForgotPwdEmailResult> sendCurrentPwdMailResult;

    /**
     * Gets the value of the sendCurrentPwdMailResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link SendForgotPwdEmailResult }{@code >}
     *     
     */
    public JAXBElement<SendForgotPwdEmailResult> getSendCurrentPwdMailResult() {
        return sendCurrentPwdMailResult;
    }

    /**
     * Sets the value of the sendCurrentPwdMailResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link SendForgotPwdEmailResult }{@code >}
     *     
     */
    public void setSendCurrentPwdMailResult(JAXBElement<SendForgotPwdEmailResult> value) {
        this.sendCurrentPwdMailResult = value;
    }

}
