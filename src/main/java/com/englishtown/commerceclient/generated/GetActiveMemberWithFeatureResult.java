
package com.englishtown.commerceclient.generated;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetActiveMemberWithFeatureResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetActiveMemberWithFeatureResult">
 *   &lt;complexContent>
 *     &lt;extension base="{EFSchools.Englishtown.Commerce.Client}CommerceServiceResultBase">
 *       &lt;sequence>
 *         &lt;element name="MemberIds" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfint" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetActiveMemberWithFeatureResult", namespace = "EFSchools.Englishtown.Commerce.Client.Accounts", propOrder = {
    "memberIds"
})
public class GetActiveMemberWithFeatureResult
    extends CommerceServiceResultBase
{

    @XmlElementRef(name = "MemberIds", namespace = "EFSchools.Englishtown.Commerce.Client.Accounts", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfint> memberIds;

    /**
     * Gets the value of the memberIds property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfint }{@code >}
     *     
     */
    public JAXBElement<ArrayOfint> getMemberIds() {
        return memberIds;
    }

    /**
     * Sets the value of the memberIds property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfint }{@code >}
     *     
     */
    public void setMemberIds(JAXBElement<ArrayOfint> value) {
        this.memberIds = value;
    }

}
