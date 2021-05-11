
package com.englishtown.commerceclient.generated;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfCorporateDivisionInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfCorporateDivisionInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CorporateDivisionInfo" type="{EFSchools.Englishtown.Commerce.Client.Corporates}CorporateDivisionInfo" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfCorporateDivisionInfo", namespace = "EFSchools.Englishtown.Commerce.Client.Corporates", propOrder = {
    "corporateDivisionInfo"
})
public class ArrayOfCorporateDivisionInfo {

    @XmlElement(name = "CorporateDivisionInfo", nillable = true)
    protected List<CorporateDivisionInfo> corporateDivisionInfo;

    /**
     * Gets the value of the corporateDivisionInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the corporateDivisionInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCorporateDivisionInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CorporateDivisionInfo }
     * 
     * 
     */
    public List<CorporateDivisionInfo> getCorporateDivisionInfo() {
        if (corporateDivisionInfo == null) {
            corporateDivisionInfo = new ArrayList<CorporateDivisionInfo>();
        }
        return this.corporateDivisionInfo;
    }

}
