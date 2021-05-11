
package com.englishtown.commerceclient.generated;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfUpdateFeatureAccessGrantBatchParams_FeatureAccessGrant complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfUpdateFeatureAccessGrantBatchParams_FeatureAccessGrant">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="UpdateFeatureAccessGrantBatchParams_FeatureAccessGrant" type="{EFSchools.Englishtown.Commerce.Client.Accounts}UpdateFeatureAccessGrantBatchParams_FeatureAccessGrant" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfUpdateFeatureAccessGrantBatchParams_FeatureAccessGrant", namespace = "EFSchools.Englishtown.Commerce.Client.Accounts", propOrder = {
    "updateFeatureAccessGrantBatchParamsFeatureAccessGrant"
})
public class ArrayOfUpdateFeatureAccessGrantBatchParamsFeatureAccessGrant {

    @XmlElement(name = "UpdateFeatureAccessGrantBatchParams_FeatureAccessGrant", nillable = true)
    protected List<UpdateFeatureAccessGrantBatchParamsFeatureAccessGrant> updateFeatureAccessGrantBatchParamsFeatureAccessGrant;

    /**
     * Gets the value of the updateFeatureAccessGrantBatchParamsFeatureAccessGrant property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the updateFeatureAccessGrantBatchParamsFeatureAccessGrant property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUpdateFeatureAccessGrantBatchParamsFeatureAccessGrant().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UpdateFeatureAccessGrantBatchParamsFeatureAccessGrant }
     * 
     * 
     */
    public List<UpdateFeatureAccessGrantBatchParamsFeatureAccessGrant> getUpdateFeatureAccessGrantBatchParamsFeatureAccessGrant() {
        if (updateFeatureAccessGrantBatchParamsFeatureAccessGrant == null) {
            updateFeatureAccessGrantBatchParamsFeatureAccessGrant = new ArrayList<UpdateFeatureAccessGrantBatchParamsFeatureAccessGrant>();
        }
        return this.updateFeatureAccessGrantBatchParamsFeatureAccessGrant;
    }

}
