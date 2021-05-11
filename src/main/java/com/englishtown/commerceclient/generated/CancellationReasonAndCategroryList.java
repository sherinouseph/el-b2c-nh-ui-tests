
package com.englishtown.commerceclient.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <summary>
 * 
 *                         </summary>
 * 
 * <p>Java class for CancellationReasonAndCategroryList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CancellationReasonAndCategroryList">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CategoryList" type="{EFSchools.Englishtown.Commerce.Client.Subscriptions}ArrayOfCancellationReasonCategory"/>
 *         &lt;element name="ReasonList" type="{EFSchools.Englishtown.Commerce.Client.Subscriptions}ArrayOfCancellationReason"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CancellationReasonAndCategroryList", namespace = "EFSchools.Englishtown.Commerce.Client.Subscriptions", propOrder = {
    "categoryList",
    "reasonList"
})
public class CancellationReasonAndCategroryList {

    @XmlElement(name = "CategoryList", required = true, nillable = true)
    protected ArrayOfCancellationReasonCategory categoryList;
    @XmlElement(name = "ReasonList", required = true, nillable = true)
    protected ArrayOfCancellationReason reasonList;

    /**
     * Gets the value of the categoryList property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfCancellationReasonCategory }
     *     
     */
    public ArrayOfCancellationReasonCategory getCategoryList() {
        return categoryList;
    }

    /**
     * Sets the value of the categoryList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfCancellationReasonCategory }
     *     
     */
    public void setCategoryList(ArrayOfCancellationReasonCategory value) {
        this.categoryList = value;
    }

    /**
     * Gets the value of the reasonList property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfCancellationReason }
     *     
     */
    public ArrayOfCancellationReason getReasonList() {
        return reasonList;
    }

    /**
     * Sets the value of the reasonList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfCancellationReason }
     *     
     */
    public void setReasonList(ArrayOfCancellationReason value) {
        this.reasonList = value;
    }

}
