
package com.englishtown.commerceclient.generated;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfGetAllFeatureAccessGrantsWithFilterResult_FeatureAccessGrant complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfGetAllFeatureAccessGrantsWithFilterResult_FeatureAccessGrant">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GetAllFeatureAccessGrantsWithFilterResult_FeatureAccessGrant" type="{EFSchools.Englishtown.Commerce.Client.Accounts}GetAllFeatureAccessGrantsWithFilterResult_FeatureAccessGrant" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfGetAllFeatureAccessGrantsWithFilterResult_FeatureAccessGrant", namespace = "EFSchools.Englishtown.Commerce.Client.Accounts", propOrder = {
    "getAllFeatureAccessGrantsWithFilterResultFeatureAccessGrant"
})
public class ArrayOfGetAllFeatureAccessGrantsWithFilterResultFeatureAccessGrant {

    @XmlElement(name = "GetAllFeatureAccessGrantsWithFilterResult_FeatureAccessGrant", nillable = true)
    protected List<GetAllFeatureAccessGrantsWithFilterResultFeatureAccessGrant> getAllFeatureAccessGrantsWithFilterResultFeatureAccessGrant;

    /**
     * Gets the value of the getAllFeatureAccessGrantsWithFilterResultFeatureAccessGrant property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the getAllFeatureAccessGrantsWithFilterResultFeatureAccessGrant property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGetAllFeatureAccessGrantsWithFilterResultFeatureAccessGrant().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GetAllFeatureAccessGrantsWithFilterResultFeatureAccessGrant }
     * 
     * 
     */
    public List<GetAllFeatureAccessGrantsWithFilterResultFeatureAccessGrant> getGetAllFeatureAccessGrantsWithFilterResultFeatureAccessGrant() {
        if (getAllFeatureAccessGrantsWithFilterResultFeatureAccessGrant == null) {
            getAllFeatureAccessGrantsWithFilterResultFeatureAccessGrant = new ArrayList<GetAllFeatureAccessGrantsWithFilterResultFeatureAccessGrant>();
        }
        return this.getAllFeatureAccessGrantsWithFilterResultFeatureAccessGrant;
    }

}
