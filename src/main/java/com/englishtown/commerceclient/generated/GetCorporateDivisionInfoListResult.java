
package com.englishtown.commerceclient.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetCorporateDivisionInfoListResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetCorporateDivisionInfoListResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CorporateDivisionInfoList" type="{EFSchools.Englishtown.Commerce.Client.Corporates}ArrayOfCorporateDivisionInfo"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetCorporateDivisionInfoListResult", namespace = "EFSchools.Englishtown.Commerce.Client.Corporates", propOrder = {
    "corporateDivisionInfoList"
})
public class GetCorporateDivisionInfoListResult {

    @XmlElement(name = "CorporateDivisionInfoList", required = true, nillable = true)
    protected ArrayOfCorporateDivisionInfo corporateDivisionInfoList;

    /**
     * Gets the value of the corporateDivisionInfoList property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfCorporateDivisionInfo }
     *     
     */
    public ArrayOfCorporateDivisionInfo getCorporateDivisionInfoList() {
        return corporateDivisionInfoList;
    }

    /**
     * Sets the value of the corporateDivisionInfoList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfCorporateDivisionInfo }
     *     
     */
    public void setCorporateDivisionInfoList(ArrayOfCorporateDivisionInfo value) {
        this.corporateDivisionInfoList = value;
    }

}
