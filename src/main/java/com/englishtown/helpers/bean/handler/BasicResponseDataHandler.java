package com.englishtown.helpers.bean.handler;

import com.englishtown.helpers.utils.TestUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by nikol.marku on 08/04/2016.
 *
 * response.content.text() : {"Success":true,"RedirectUrl":"http://www.englishtown.com/online/pt-thankyou.aspx?omnievents=event5,event34,event4,event33&omniproducts=;EmailEnglish_LeadOE;1;0;event34=0|event33=0&csf=eyJmaXJzdF9uYW1lIjoidGVzdERCc3RvcmUiLCJlbWFpbCI6ImRiMV8xNDYwMTA5NzMyNTAzQHFwMS5vcmciLCJsZWFkX2lkIjozODUxNDY5N30%3d","LeadId":38514697}
 */
public class BasicResponseDataHandler {
    private static final Logger logger = LoggerFactory.getLogger(BasicResponseDataHandler.class);
    protected String response;       // response.content.text();
    protected String successStatus;   // Success : true ... could do it as boolean
    protected String redirectUrl ;   // RedirectUrl : ....
    protected String leadId;         //"LeadId":38514697
    protected int responseStatus;       // response.conte.text();
    protected String orderId;

    public BasicResponseDataHandler() {    }

    public BasicResponseDataHandler(String response, String successStatus, String redirectUrl, String leadId, int responseStatus) {
        this.response = response;
        this.successStatus = successStatus;
        this.redirectUrl = redirectUrl;
        this.leadId = leadId;
        this.responseStatus = responseStatus;
    }

    /**
     * Setup up data from response.content() and response status
     * @param response
     * @param responseStatus
     *
     *  Note: Does not work for create member
     **/
    public static BasicResponseDataHandler setBasicResponseObject(String response, int responseStatus){
        logger.info("setBasicObjectValue from ["+response+"]");
        BasicResponseDataHandler basicResponseDataHandler = new BasicResponseDataHandler();
        basicResponseDataHandler.setResponse(response);
        basicResponseDataHandler.setResponseStatus(responseStatus);
        basicResponseDataHandler.setSuccessStatus(TestUtil.getResponseSuccessStatus(response,"Success", ":", 4)); //(TestUtil.getStringPart(response, "Success", ",\"RedirectUrl", "\"", "", true));
        basicResponseDataHandler.setRedirectUrl(TestUtil.getStringPart(response, "RedirectUrl", "?omnievents=", "\"", "", false));
        basicResponseDataHandler.setLeadId(TestUtil.getStringPart(response, "LeadId", "}", "\"", "", true) );

        return basicResponseDataHandler;
    }
    public static BasicResponseDataHandler setCreateMemberResponseObject(String response, int responseStatus){
        logger.info("setBasicObjectValue from ["+response+"]");
        BasicResponseDataHandler basicResponseDataHandler = new BasicResponseDataHandler();
        basicResponseDataHandler.setResponse(response);
        basicResponseDataHandler.setResponseStatus(responseStatus);
        basicResponseDataHandler.setSuccessStatus(TestUtil.getResponseSuccessStatus(response,"Success", ":", 4)); //(TestUtil.getStringPart(response, "Success", ",\"RedirectUrl", "\"", "", true));
        //basicResponseDataHandler.setRedirectUrl(TestUtil.getStringPart(response, "AutoLoginRedirect", "?omnievents=", "\"", "", false));
        basicResponseDataHandler.setLeadId(TestUtil.getResponseSuccessStatus(response,"Member_id", ":", 8)); //(TestUtil.getStringPart(response, "Member_id", "}", "\"", "", true) );

        return basicResponseDataHandler;
    }

    public static BasicResponseDataHandler setPayPostResponseObject(String response, int responseStatus){
        logger.info("setBasicObjectValue from ["+response+"]");
        BasicResponseDataHandler basicResponseDataHandler = new BasicResponseDataHandler();
        basicResponseDataHandler.setResponse(response);
        basicResponseDataHandler.setResponseStatus(responseStatus);
        basicResponseDataHandler.setSuccessStatus(TestUtil.getResponseSuccessStatus(response,"Success", ":", 4)); //(TestUtil.getStringPart(response, "Success", ",\"RedirectUrl", "\"", "", true));
        basicResponseDataHandler.setOrderId(TestUtil.getJasonKeyValue(response, "Result") );

        return basicResponseDataHandler;
    }


    public String getSuccessStatus() {
        return successStatus;
    }

    public void setSuccessStatus(String successStatus) {
        this.successStatus = successStatus;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    public String getLeadId() {
        return leadId;
    }

    public void setLeadId(String leadId) {
        this.leadId = leadId;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public int getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(int responseStatus) {
        this.responseStatus = responseStatus;
    }


    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString(){
        return "BasicResponseDataHandler [Response="+this.getResponse()+"; ResponseStatus="+this.getResponseStatus()+
                "; LeadId="+this.getLeadId()+"; RedirectUrl="+this.getRedirectUrl()+"; OrderIde="+this.getOrderId()+
                "; SuccessStatus="+this.getSuccessStatus()+"]";
    }

}
