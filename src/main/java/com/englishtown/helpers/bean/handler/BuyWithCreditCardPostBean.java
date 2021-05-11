package com.englishtown.helpers.bean.handler;
/**
 * POST /services/commerce-v4/offermanager/buywithcreditcard HTTP/1.1
 >post data is :
 CreditCardNumber=4222222222222222
 &ExpirationMonth=4
 &ExpirationYear=2021&
 CardVerificationCode=1234
 CreditCardName=teste+test
 CCAuthorized=on&
 CCType=Visa&CouponCode=&
 CCMarketCode=de
 &etag=&
 cmus=ADMANQAzADYAMQAwADkAOQB8ADEANAA4ADcANQA4ADQANwAyADcAOQA1ADEAfAB0AHQAZQBzAHQAMgA4ADQANQA1AHwATQB8AE4A&
 purchaseInfo.CouponCode=&purchaseInfo.Etag=&purchaseInfo.MarketCode=de&
 purchaseInfo.MemberId=35361099&
 purchaseInfo.OfferId=9262
 purchaseInfo.PartnerCode=None
 CCFirstName=teste
 CCLastName=test
 offerid=9262
 marketCode=de
 memberid=35361099
 partnerCode=None
 campaign=&OnSuccessUrl=..%2Fthankyou%2F

 > "Result":14522264,"Success":true    .. order id

 */


import org.codehaus.jackson.annotate.JsonSetter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class BuyWithCreditCardPostBean {
    private static final Logger logger = LoggerFactory.getLogger(EfFullDataBean.class);

    private String CreditCardNumber;
    private String ExpirationMonth;
    private String ExpirationYear;
    private String CardVerificationCode;
    private String CCMarketCode;
    private String memberid;
    //private String offerid;

    // make json happy
    public BuyWithCreditCardPostBean(){}

    public BuyWithCreditCardPostBean(String creditCardNumber, String expirationMonth, String expirationYear,
                                     String cardVerificationCode, String CCMarketCode, String memberid) {
        CreditCardNumber = creditCardNumber;
        ExpirationMonth = expirationMonth;
        ExpirationYear = expirationYear;
        CardVerificationCode = cardVerificationCode;
        this.CCMarketCode = CCMarketCode;
        this.memberid = memberid;
        //this.offerid = offerid;
    }


    public void setBenValue(java.lang.String key, java.lang.String value){
        logger.info("setObjectValue [key:"+key+" ; value :"+value+"]");
        key = key.toLowerCase();
        switch(key){
            case "creditcardnumber":
                setCreditCardNumber(value);
                break;
            case "expirationmonth":         this.setExpirationMonth(value);
                break;
            case "expirationyear":          this.setExpirationYear(value);
                break;
            case "cardverificationcode":    this.setCardVerificationCode(value);
                break;
            case "ccmarketcode":            this.setCCMarketCode(value);
                break;
            case "memberid":                this.setMemberid(value);
                break;
            /*case "offerid":                 this.setOfferid(value);
                break;*/

            default:
                logger.error("Can't set the object value for this key ...! [key:"+key);
                break;
        }
    }


    @Override
    public String toString() {
        return super.toString()+"\n"+"\nEfFullDataBean [ {" +
                "\nCreditCardNumber='" + CreditCardNumber + '\'' +
                ",\n ExpirationMonth='" + ExpirationMonth + '\'' +
                ",\n ExpirationYear='" + ExpirationYear + '\'' +
                ",\n CardVerificationCode='" + CardVerificationCode + '\'' +
                ",\n CCMarketCode='" + CCMarketCode + '\'' +
                ",\n memberid='" + memberid + '\'' +
                //",\n offerid='" + offerid + '\'' +
                '}';
    }

    public String getCreditCardNumber() {
        return CreditCardNumber;
    }
    @JsonSetter("CreditCardNumber")
    public void setCreditCardNumber(String creditCardNumber) {
        CreditCardNumber = creditCardNumber;
    }

    public String getExpirationMonth() {
        return ExpirationMonth;
    }
    @JsonSetter("ExpirationMonth")
    public void setExpirationMonth(String expirationMonth) {
        ExpirationMonth = expirationMonth;
    }

    public String getExpirationYear() {
        return ExpirationYear;
    }
    @JsonSetter("ExpirationYear")
    public void setExpirationYear(String expirationYear) {
        ExpirationYear = expirationYear;
    }

    public String getCardVerificationCode() {
        return CardVerificationCode;
    }
    @JsonSetter("CardVerificationCode")
    public void setCardVerificationCode(String cardVerificationCode) {
        CardVerificationCode = cardVerificationCode;
    }

    public String getCCMarketCode() {
        return CCMarketCode;
    }
    @JsonSetter("CCMarketCode")
    public void setCCMarketCode(String CCMarketCode) {
        this.CCMarketCode = CCMarketCode;
    }

    public String getMemberid() {
        return memberid;
    }
    @JsonSetter("memberid")
    public void setMemberid(String memberid) {
        this.memberid = memberid;
    }
/*
    public String getOfferid() {
        return offerid;
    }
    @JsonSetter("offerid")
    public void setOfferid(String offerid) {
        this.offerid = offerid;
    }

*/


}
