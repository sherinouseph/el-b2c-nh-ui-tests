
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
 *         &lt;element name="loadMemberParams" type="{EFSchools.Englishtown.Commerce.Client.Members}LoadMemberByFirstNameAndLastNameParams" minOccurs="0"/>
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
    "loadMemberParams"
})
@XmlRootElement(name = "GetMemberByFirstNameAndLastName")
public class GetMemberByFirstNameAndLastName {

    @XmlElementRef(name = "loadMemberParams", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<LoadMemberByFirstNameAndLastNameParams> loadMemberParams;

    /**
     * Gets the value of the loadMemberParams property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LoadMemberByFirstNameAndLastNameParams }{@code >}
     *     
     */
    public JAXBElement<LoadMemberByFirstNameAndLastNameParams> getLoadMemberParams() {
        return loadMemberParams;
    }

    /**
     * Sets the value of the loadMemberParams property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LoadMemberByFirstNameAndLastNameParams }{@code >}
     *     
     */
    public void setLoadMemberParams(JAXBElement<LoadMemberByFirstNameAndLastNameParams> value) {
        this.loadMemberParams = value;
    }

}
