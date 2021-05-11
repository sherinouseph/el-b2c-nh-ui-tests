
package com.englishtown.commerceclient.generated;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfSalesOrderItemInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfSalesOrderItemInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SalesOrderItemInfo" type="{EFSchools.Englishtown.Commerce.Client.Orders}SalesOrderItemInfo" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfSalesOrderItemInfo", namespace = "EFSchools.Englishtown.Commerce.Client.Orders", propOrder = {
    "salesOrderItemInfo"
})
public class ArrayOfSalesOrderItemInfo {

    @XmlElement(name = "SalesOrderItemInfo", nillable = true)
    protected List<SalesOrderItemInfo> salesOrderItemInfo;

    /**
     * Gets the value of the salesOrderItemInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the salesOrderItemInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSalesOrderItemInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SalesOrderItemInfo }
     * 
     * 
     */
    public List<SalesOrderItemInfo> getSalesOrderItemInfo() {
        if (salesOrderItemInfo == null) {
            salesOrderItemInfo = new ArrayList<SalesOrderItemInfo>();
        }
        return this.salesOrderItemInfo;
    }

}
