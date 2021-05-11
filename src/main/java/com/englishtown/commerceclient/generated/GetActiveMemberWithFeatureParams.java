
package com.englishtown.commerceclient.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetActiveMemberWithFeatureParams complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetActiveMemberWithFeatureParams">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="featureAccessIds" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfint"/>
 *         &lt;element name="partnerCodes" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfstring"/>
 *         &lt;element name="startMemberId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="maxRecordCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetActiveMemberWithFeatureParams", namespace = "EFSchools.Englishtown.Commerce.Client.Accounts", propOrder = {
    "featureAccessIds",
    "partnerCodes",
    "startMemberId",
    "maxRecordCount"
})
public class GetActiveMemberWithFeatureParams {

    @XmlElement(required = true, nillable = true)
    protected ArrayOfint featureAccessIds;
    @XmlElement(required = true, nillable = true)
    protected ArrayOfstring partnerCodes;
    protected int startMemberId;
    protected int maxRecordCount;

    /**
     * Gets the value of the featureAccessIds property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfint }
     *     
     */
    public ArrayOfint getFeatureAccessIds() {
        return featureAccessIds;
    }

    /**
     * Sets the value of the featureAccessIds property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfint }
     *     
     */
    public void setFeatureAccessIds(ArrayOfint value) {
        this.featureAccessIds = value;
    }

    /**
     * Gets the value of the partnerCodes property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfstring }
     *     
     */
    public ArrayOfstring getPartnerCodes() {
        return partnerCodes;
    }

    /**
     * Sets the value of the partnerCodes property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfstring }
     *     
     */
    public void setPartnerCodes(ArrayOfstring value) {
        this.partnerCodes = value;
    }

    /**
     * Gets the value of the startMemberId property.
     * 
     */
    public int getStartMemberId() {
        return startMemberId;
    }

    /**
     * Sets the value of the startMemberId property.
     * 
     */
    public void setStartMemberId(int value) {
        this.startMemberId = value;
    }

    /**
     * Gets the value of the maxRecordCount property.
     * 
     */
    public int getMaxRecordCount() {
        return maxRecordCount;
    }

    /**
     * Sets the value of the maxRecordCount property.
     * 
     */
    public void setMaxRecordCount(int value) {
        this.maxRecordCount = value;
    }

}
