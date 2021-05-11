
package com.englishtown.commerceclient.generated;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "CommerceServiceExceptionDetail", targetNamespace = "EFSchools.Englishtown.Commerce.Client.Exceptions")
public class ISubscriptionServiceIsRecurringOrderCommerceServiceExceptionDetailFaultFaultMessage
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private CommerceServiceExceptionDetail faultInfo;

    /**
     * 
     * @param message
     * @param faultInfo
     */
    public ISubscriptionServiceIsRecurringOrderCommerceServiceExceptionDetailFaultFaultMessage(String message, CommerceServiceExceptionDetail faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param message
     * @param faultInfo
     * @param cause
     */
    public ISubscriptionServiceIsRecurringOrderCommerceServiceExceptionDetailFaultFaultMessage(String message, CommerceServiceExceptionDetail faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: com.englishtown.commerceclient.generated.CommerceServiceExceptionDetail
     */
    public CommerceServiceExceptionDetail getFaultInfo() {
        return faultInfo;
    }

}
