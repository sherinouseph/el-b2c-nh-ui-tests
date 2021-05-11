
package com.englishtown.commerceclient.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 *         &lt;element name="CheckHeadsetOrderResult" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
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
    "checkHeadsetOrderResult"
})
@XmlRootElement(name = "CheckHeadsetOrderResponse")
public class CheckHeadsetOrderResponse {

    @XmlElement(name = "CheckHeadsetOrderResult")
    protected Boolean checkHeadsetOrderResult;

    /**
     * Gets the value of the checkHeadsetOrderResult property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCheckHeadsetOrderResult() {
        return checkHeadsetOrderResult;
    }

    /**
     * Sets the value of the checkHeadsetOrderResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCheckHeadsetOrderResult(Boolean value) {
        this.checkHeadsetOrderResult = value;
    }

}
