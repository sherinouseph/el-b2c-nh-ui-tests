
package com.englishtown.commerceclient.generated;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfReceiptInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfReceiptInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ReceiptInfo" type="{EFSchools.Englishtown.Commerce.Client.Accounts}ReceiptInfo" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfReceiptInfo", namespace = "EFSchools.Englishtown.Commerce.Client.Accounts", propOrder = {
    "receiptInfo"
})
public class ArrayOfReceiptInfo {

    @XmlElement(name = "ReceiptInfo", nillable = true)
    protected List<ReceiptInfo> receiptInfo;

    /**
     * Gets the value of the receiptInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the receiptInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReceiptInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ReceiptInfo }
     * 
     * 
     */
    public List<ReceiptInfo> getReceiptInfo() {
        if (receiptInfo == null) {
            receiptInfo = new ArrayList<ReceiptInfo>();
        }
        return this.receiptInfo;
    }

}
