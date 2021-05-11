
package com.englishtown.commerceclient.generated;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetBatchSubscriptionsResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetBatchSubscriptionsResult">
 *   &lt;complexContent>
 *     &lt;extension base="{EFSchools.Englishtown.Commerce.Client}CommerceServiceResultBase">
 *       &lt;sequence>
 *         &lt;element name="Subscriptions" type="{EFSchools.Englishtown.Commerce.Client.Subscriptions}ArrayOfSubscriptionInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetBatchSubscriptionsResult", namespace = "EFSchools.Englishtown.Commerce.Client.Subscriptions", propOrder = {
    "subscriptions"
})
public class GetBatchSubscriptionsResult
    extends CommerceServiceResultBase
{

    @XmlElementRef(name = "Subscriptions", namespace = "EFSchools.Englishtown.Commerce.Client.Subscriptions", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfSubscriptionInfo> subscriptions;

    /**
     * Gets the value of the subscriptions property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfSubscriptionInfo }{@code >}
     *     
     */
    public JAXBElement<ArrayOfSubscriptionInfo> getSubscriptions() {
        return subscriptions;
    }

    /**
     * Sets the value of the subscriptions property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfSubscriptionInfo }{@code >}
     *     
     */
    public void setSubscriptions(JAXBElement<ArrayOfSubscriptionInfo> value) {
        this.subscriptions = value;
    }

}
