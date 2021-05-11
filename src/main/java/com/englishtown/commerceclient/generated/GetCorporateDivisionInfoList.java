
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
 *         &lt;element name="param" type="{EFSchools.Englishtown.Commerce.Client.Corporates}GetCorporateDivisionInfoListParams" minOccurs="0"/>
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
    "param"
})
@XmlRootElement(name = "GetCorporateDivisionInfoList")
public class GetCorporateDivisionInfoList {

    @XmlElementRef(name = "param", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<GetCorporateDivisionInfoListParams> param;

    /**
     * Gets the value of the param property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link GetCorporateDivisionInfoListParams }{@code >}
     *     
     */
    public JAXBElement<GetCorporateDivisionInfoListParams> getParam() {
        return param;
    }

    /**
     * Sets the value of the param property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link GetCorporateDivisionInfoListParams }{@code >}
     *     
     */
    public void setParam(JAXBElement<GetCorporateDivisionInfoListParams> value) {
        this.param = value;
    }

}
