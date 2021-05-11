
package com.englishtown.commerceclient.generated;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfMemberExtraInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfMemberExtraInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MemberExtraInfo" type="{EFSchools.Englishtown.Commerce.Client.Members}MemberExtraInfo" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfMemberExtraInfo", namespace = "EFSchools.Englishtown.Commerce.Client.Members", propOrder = {
    "memberExtraInfo"
})
public class ArrayOfMemberExtraInfo {

    @XmlElement(name = "MemberExtraInfo", nillable = true)
    protected List<MemberExtraInfo> memberExtraInfo;

    /**
     * Gets the value of the memberExtraInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the memberExtraInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMemberExtraInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MemberExtraInfo }
     * 
     * 
     */
    public List<MemberExtraInfo> getMemberExtraInfo() {
        if (memberExtraInfo == null) {
            memberExtraInfo = new ArrayList<MemberExtraInfo>();
        }
        return this.memberExtraInfo;
    }

}
