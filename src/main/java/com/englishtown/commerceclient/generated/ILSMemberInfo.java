
package com.englishtown.commerceclient.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <summary>
 * 
 *                         </summary>
 * 
 * <p>Java class for ILSMemberInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ILSMemberInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{EFSchools.Englishtown.Commerce.Client.Members}PartnerMemberInfo">
 *       &lt;sequence>
 *         &lt;element name="Student_id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="StartDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="EndDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="CancelledDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="BookedDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="UpdateDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="CurrentDestinationCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SalesOfficeCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CourseTypeCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ProgramCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CourseIntensityCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RedemptionCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SchoolCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="IsActive" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ILSMemberInfo", namespace = "EFSchools.Englishtown.Commerce.Client.Members", propOrder = {
    "studentId",
    "startDate",
    "endDate",
    "cancelledDate",
    "bookedDate",
    "updateDate",
    "currentDestinationCode",
    "salesOfficeCode",
    "courseTypeCode",
    "programCode",
    "courseIntensityCode",
    "redemptionCode",
    "schoolCode",
    "isActive"
})
public class ILSMemberInfo
    extends PartnerMemberInfo
{

    @XmlElement(name = "Student_id", required = true, nillable = true)
    protected String studentId;
    @XmlElement(name = "StartDate", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar startDate;
    @XmlElement(name = "EndDate", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar endDate;
    @XmlElement(name = "CancelledDate", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar cancelledDate;
    @XmlElement(name = "BookedDate", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar bookedDate;
    @XmlElement(name = "UpdateDate", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar updateDate;
    @XmlElement(name = "CurrentDestinationCode", required = true, nillable = true)
    protected String currentDestinationCode;
    @XmlElement(name = "SalesOfficeCode", required = true, nillable = true)
    protected String salesOfficeCode;
    @XmlElement(name = "CourseTypeCode", required = true, nillable = true)
    protected String courseTypeCode;
    @XmlElement(name = "ProgramCode", required = true, nillable = true)
    protected String programCode;
    @XmlElement(name = "CourseIntensityCode", required = true, nillable = true)
    protected String courseIntensityCode;
    @XmlElement(name = "RedemptionCode", required = true, nillable = true)
    protected String redemptionCode;
    @XmlElement(name = "SchoolCode", required = true, nillable = true)
    protected String schoolCode;
    @XmlElement(name = "IsActive")
    protected boolean isActive;

    /**
     * Gets the value of the studentId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStudentId() {
        return studentId;
    }

    /**
     * Sets the value of the studentId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStudentId(String value) {
        this.studentId = value;
    }

    /**
     * Gets the value of the startDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getStartDate() {
        return startDate;
    }

    /**
     * Sets the value of the startDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setStartDate(XMLGregorianCalendar value) {
        this.startDate = value;
    }

    /**
     * Gets the value of the endDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEndDate() {
        return endDate;
    }

    /**
     * Sets the value of the endDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEndDate(XMLGregorianCalendar value) {
        this.endDate = value;
    }

    /**
     * Gets the value of the cancelledDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCancelledDate() {
        return cancelledDate;
    }

    /**
     * Sets the value of the cancelledDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCancelledDate(XMLGregorianCalendar value) {
        this.cancelledDate = value;
    }

    /**
     * Gets the value of the bookedDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getBookedDate() {
        return bookedDate;
    }

    /**
     * Sets the value of the bookedDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setBookedDate(XMLGregorianCalendar value) {
        this.bookedDate = value;
    }

    /**
     * Gets the value of the updateDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getUpdateDate() {
        return updateDate;
    }

    /**
     * Sets the value of the updateDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setUpdateDate(XMLGregorianCalendar value) {
        this.updateDate = value;
    }

    /**
     * Gets the value of the currentDestinationCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrentDestinationCode() {
        return currentDestinationCode;
    }

    /**
     * Sets the value of the currentDestinationCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrentDestinationCode(String value) {
        this.currentDestinationCode = value;
    }

    /**
     * Gets the value of the salesOfficeCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSalesOfficeCode() {
        return salesOfficeCode;
    }

    /**
     * Sets the value of the salesOfficeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSalesOfficeCode(String value) {
        this.salesOfficeCode = value;
    }

    /**
     * Gets the value of the courseTypeCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCourseTypeCode() {
        return courseTypeCode;
    }

    /**
     * Sets the value of the courseTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCourseTypeCode(String value) {
        this.courseTypeCode = value;
    }

    /**
     * Gets the value of the programCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProgramCode() {
        return programCode;
    }

    /**
     * Sets the value of the programCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProgramCode(String value) {
        this.programCode = value;
    }

    /**
     * Gets the value of the courseIntensityCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCourseIntensityCode() {
        return courseIntensityCode;
    }

    /**
     * Sets the value of the courseIntensityCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCourseIntensityCode(String value) {
        this.courseIntensityCode = value;
    }

    /**
     * Gets the value of the redemptionCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRedemptionCode() {
        return redemptionCode;
    }

    /**
     * Sets the value of the redemptionCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRedemptionCode(String value) {
        this.redemptionCode = value;
    }

    /**
     * Gets the value of the schoolCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSchoolCode() {
        return schoolCode;
    }

    /**
     * Sets the value of the schoolCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSchoolCode(String value) {
        this.schoolCode = value;
    }

    /**
     * Gets the value of the isActive property.
     * 
     */
    public boolean isIsActive() {
        return isActive;
    }

    /**
     * Sets the value of the isActive property.
     * 
     */
    public void setIsActive(boolean value) {
        this.isActive = value;
    }

}
