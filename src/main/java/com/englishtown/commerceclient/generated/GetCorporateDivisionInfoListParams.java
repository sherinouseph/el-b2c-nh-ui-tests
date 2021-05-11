
package com.englishtown.commerceclient.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetCorporateDivisionInfoListParams complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetCorporateDivisionInfoListParams">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DivisionCodeList" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfstring"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetCorporateDivisionInfoListParams", namespace = "EFSchools.Englishtown.Commerce.Client.Corporates", propOrder = {
    "divisionCodeList"
})
public class GetCorporateDivisionInfoListParams {

    @XmlElement(name = "DivisionCodeList", required = true, nillable = true)
    protected ArrayOfstring divisionCodeList;

    /**
     * Gets the value of the divisionCodeList property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfstring }
     *     
     */
    public ArrayOfstring getDivisionCodeList() {
        return divisionCodeList;
    }

    /**
     * Sets the value of the divisionCodeList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfstring }
     *     
     */
    public void setDivisionCodeList(ArrayOfstring value) {
        this.divisionCodeList = value;
    }

}
