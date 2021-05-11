package com.englishtown.newhouse.apicore.bean;
/**
 * Created by nikol.marku on 18/10/2017.
 * api req bean
 *
 */
import org.codehaus.jackson.annotate.JsonProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class BaseReqBean {
    private static final Logger logger = LoggerFactory.getLogger(BaseReqBean.class);

    /*private String GatewayType ;
    private String RefNumber ;
    private String Email ;
    private String Amount ;
    private String Currency ;
    private String User_id ;*/
    @JsonProperty("GatewayType")
    private String GatewayType ;
    @JsonProperty("RefNumber")
    private String RefNumber ;
    @JsonProperty("Email")
    private String Email ;
    @JsonProperty("Amount")
    private float Amount ;
    @JsonProperty("Currency")
    private String Currency ;
    @JsonProperty("User_id")
    private String User_id ;


    public BaseReqBean (){
        // empty obj
    }

    public BaseReqBean(String gatewayType, String refNumber, String email, float amount, String currency, String user_id) {
        GatewayType = gatewayType;
        RefNumber = refNumber;
        Email = email;
        Amount = amount;
        Currency = currency;
        User_id = user_id;
    }

    public String toString() {
        String sFormat = "%1$-25s %2$-25s";
        String s = "\n***********************************************************************\n";
        s = s + String.format(sFormat,  "\nGatewayType :", getGatewayType() );
        s = s + String.format(sFormat,  "\nRefNumber :", getRefNumber()) ;
        s = s + String.format(sFormat,  "\nEmail :", getEmail()) ;
        s = s + String.format(sFormat,  "\nAmount :", getAmount() );
        s = s + String.format(sFormat,  "\nCurrency :", getCurrency()) ;
        s = s + String.format(sFormat,  "\nUser_id :", getUser_id() );
        s = s + "\n***********************************************************************\n";
        return s;
    }

    public String getGatewayType() {
        return GatewayType;
    }

    public void setGatewayType(String gatewayType) {
        GatewayType = gatewayType;
    }

    public String getRefNumber() {
        return RefNumber;
    }

    public void setRefNumber(String refNumber) {
        RefNumber = refNumber;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public float getAmount() {
        return Amount;
    }

    public void setAmount(float amount) {
        Amount = amount;
    }

    public String getCurrency() {
        return Currency;
    }

    public void setCurrency(String currency) {
        Currency = currency;
    }

    public String getUser_id() {
        return User_id;
    }

    public void setUser_id(String user_id) {
        User_id = user_id;
    }

}
