
package com.englishtown.commerceclient.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="reSchedule_id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="status" type="{http://schemas.datacontract.org/2004/07/EFSchools.Englishtown.Commerce.Orders}SalesOrderStatuses" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "reScheduleId",
    "status"
})
@XmlRootElement(name = "UpdateOrderStatusToSFByReScheduleId")
public class UpdateOrderStatusToSFByReScheduleId {

    @XmlElement(name = "reSchedule_id")
    protected Integer reScheduleId;
    protected SalesOrderStatuses status;

    /**
     * Gets the value of the reScheduleId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getReScheduleId() {
        return reScheduleId;
    }

    /**
     * Sets the value of the reScheduleId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setReScheduleId(Integer value) {
        this.reScheduleId = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link SalesOrderStatuses }
     *     
     */
    public SalesOrderStatuses getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link SalesOrderStatuses }
     *     
     */
    public void setStatus(SalesOrderStatuses value) {
        this.status = value;
    }

}
