
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
 *         &lt;element name="LoadMemberEmailListByMemberResult" type="{EFSchools.Englishtown.Commerce.Client.Members}ArrayOfMemberEmailInfo" minOccurs="0"/>
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
    "loadMemberEmailListByMemberResult"
})
@XmlRootElement(name = "LoadMemberEmailListByMemberResponse")
public class LoadMemberEmailListByMemberResponse {

    @XmlElementRef(name = "LoadMemberEmailListByMemberResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfMemberEmailInfo> loadMemberEmailListByMemberResult;

    /**
     * Gets the value of the loadMemberEmailListByMemberResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfMemberEmailInfo }{@code >}
     *     
     */
    public JAXBElement<ArrayOfMemberEmailInfo> getLoadMemberEmailListByMemberResult() {
        return loadMemberEmailListByMemberResult;
    }

    /**
     * Sets the value of the loadMemberEmailListByMemberResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfMemberEmailInfo }{@code >}
     *     
     */
    public void setLoadMemberEmailListByMemberResult(JAXBElement<ArrayOfMemberEmailInfo> value) {
        this.loadMemberEmailListByMemberResult = value;
    }

}
