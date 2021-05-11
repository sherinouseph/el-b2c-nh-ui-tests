
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
 *         &lt;element name="getMemberProductLineParams" type="{EFSchools.Englishtown.Commerce.Client.Accounts}GetMemberProductLineParams" minOccurs="0"/>
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
    "getMemberProductLineParams"
})
@XmlRootElement(name = "GetMemberProductLine")
public class GetMemberProductLine {

    @XmlElementRef(name = "getMemberProductLineParams", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<GetMemberProductLineParams> getMemberProductLineParams;

    /**
     * Gets the value of the getMemberProductLineParams property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link GetMemberProductLineParams }{@code >}
     *     
     */
    public JAXBElement<GetMemberProductLineParams> getGetMemberProductLineParams() {
        return getMemberProductLineParams;
    }

    /**
     * Sets the value of the getMemberProductLineParams property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link GetMemberProductLineParams }{@code >}
     *     
     */
    public void setGetMemberProductLineParams(JAXBElement<GetMemberProductLineParams> value) {
        this.getMemberProductLineParams = value;
    }

}
