
package com.englishtown.commerceclient.generated;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfMemberJobIndustryLkp complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfMemberJobIndustryLkp">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MemberJobIndustryLkp" type="{EFSchools.Englishtown.Commerce.Client.Members}MemberJobIndustryLkp" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfMemberJobIndustryLkp", namespace = "EFSchools.Englishtown.Commerce.Client.Members", propOrder = {
    "memberJobIndustryLkp"
})
public class ArrayOfMemberJobIndustryLkp {

    @XmlElement(name = "MemberJobIndustryLkp", nillable = true)
    protected List<MemberJobIndustryLkp> memberJobIndustryLkp;

    /**
     * Gets the value of the memberJobIndustryLkp property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the memberJobIndustryLkp property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMemberJobIndustryLkp().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MemberJobIndustryLkp }
     * 
     * 
     */
    public List<MemberJobIndustryLkp> getMemberJobIndustryLkp() {
        if (memberJobIndustryLkp == null) {
            memberJobIndustryLkp = new ArrayList<MemberJobIndustryLkp>();
        }
        return this.memberJobIndustryLkp;
    }

}
