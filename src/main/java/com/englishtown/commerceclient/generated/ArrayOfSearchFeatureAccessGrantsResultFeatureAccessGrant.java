
package com.englishtown.commerceclient.generated;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfSearchFeatureAccessGrantsResult_FeatureAccessGrant complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfSearchFeatureAccessGrantsResult_FeatureAccessGrant">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SearchFeatureAccessGrantsResult_FeatureAccessGrant" type="{EFSchools.Englishtown.Commerce.Client.Accounts}SearchFeatureAccessGrantsResult_FeatureAccessGrant" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfSearchFeatureAccessGrantsResult_FeatureAccessGrant", namespace = "EFSchools.Englishtown.Commerce.Client.Accounts", propOrder = {
    "searchFeatureAccessGrantsResultFeatureAccessGrant"
})
public class ArrayOfSearchFeatureAccessGrantsResultFeatureAccessGrant {

    @XmlElement(name = "SearchFeatureAccessGrantsResult_FeatureAccessGrant", nillable = true)
    protected List<SearchFeatureAccessGrantsResultFeatureAccessGrant> searchFeatureAccessGrantsResultFeatureAccessGrant;

    /**
     * Gets the value of the searchFeatureAccessGrantsResultFeatureAccessGrant property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the searchFeatureAccessGrantsResultFeatureAccessGrant property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSearchFeatureAccessGrantsResultFeatureAccessGrant().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SearchFeatureAccessGrantsResultFeatureAccessGrant }
     * 
     * 
     */
    public List<SearchFeatureAccessGrantsResultFeatureAccessGrant> getSearchFeatureAccessGrantsResultFeatureAccessGrant() {
        if (searchFeatureAccessGrantsResultFeatureAccessGrant == null) {
            searchFeatureAccessGrantsResultFeatureAccessGrant = new ArrayList<SearchFeatureAccessGrantsResultFeatureAccessGrant>();
        }
        return this.searchFeatureAccessGrantsResultFeatureAccessGrant;
    }

}
