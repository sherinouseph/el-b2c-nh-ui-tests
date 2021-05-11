
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
 *         &lt;element name="GetMemberJobSeniorityLkpListResult" type="{EFSchools.Englishtown.Commerce.Client.Members}ArrayOfMemberJobSeniorityLkp" minOccurs="0"/>
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
    "getMemberJobSeniorityLkpListResult"
})
@XmlRootElement(name = "GetMemberJobSeniorityLkpListResponse")
public class GetMemberJobSeniorityLkpListResponse {

    @XmlElementRef(name = "GetMemberJobSeniorityLkpListResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfMemberJobSeniorityLkp> getMemberJobSeniorityLkpListResult;

    /**
     * Gets the value of the getMemberJobSeniorityLkpListResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfMemberJobSeniorityLkp }{@code >}
     *     
     */
    public JAXBElement<ArrayOfMemberJobSeniorityLkp> getGetMemberJobSeniorityLkpListResult() {
        return getMemberJobSeniorityLkpListResult;
    }

    /**
     * Sets the value of the getMemberJobSeniorityLkpListResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfMemberJobSeniorityLkp }{@code >}
     *     
     */
    public void setGetMemberJobSeniorityLkpListResult(JAXBElement<ArrayOfMemberJobSeniorityLkp> value) {
        this.getMemberJobSeniorityLkpListResult = value;
    }

}
