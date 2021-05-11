package com.englishtown.helpers.bean.handler;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonSetter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by nikol.marku on 2/13/2017.
 */
//@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateMemberBean{//} extends BasicHandler{
    private static final Logger logger = LoggerFactory.getLogger(EfFullDataBean.class);
    //@JsonProperty("FirstName")
    private String firstname;
    //@JsonProperty("LastName")
    private String lastname;
    //@JsonProperty("Email")
    private String email;
    //@JsonProperty("HomePhone")
    private String homePhone	;  //"MobilePhone":"0755654565",
    //@JsonProperty("Password")
    private String password;
    //@JsonProperty("ETag")
    private String etag	;
    //@JsonProperty("CountryCode")
    private String countryCode;
    //@JsonProperty("LanguageCode")
    private String languageCode;
    //@JsonProperty("PartnerCode")
    private String partnerCode;
    //@JsonProperty("Member_id")
    private String memberId;
    //@JsonProperty("MemberType")
    private String memberType; //:"M",
    //@JsonProperty("OmnitureFriendlyName")
    private String omnitureFriendlyName;   //NOte this is not being populated s.. to do with value "Checkout:default:member"

    // make json happy
    public CreateMemberBean(){}

    public CreateMemberBean(String firstname, String lastname, String email, String homePhone, String password,
                            String etag, String countryCode, String languageCode, String partnerCode,
                            String memberId, String memberType, String omnitureFriendlyName) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.homePhone = homePhone;
        this.password = password;
        this.etag = etag;
        this.countryCode = countryCode;
        this.languageCode = languageCode;
        this.partnerCode = partnerCode;
        this.memberId = memberId;
        this.memberType = memberType;
        this.omnitureFriendlyName = omnitureFriendlyName;
    }

    @Override
    public String toString() {
        return super.toString()+"\n"+"\nCreateMemberBean [ {" +
                " \n Firstname='" + firstname + '\'' +
                ",\n LastName='" + lastname + '\'' +
                ",\n email='" + email + '\'' +
                ",\n homePhone='" + homePhone + '\'' +
                ",\n password='" + password + '\'' +
                ",\n etag='" + etag + '\'' +
                ",\n countryCode='" + countryCode + '\'' +
                ",\n languageCode='" + languageCode + '\'' +
                ",\n partnerCode='" + partnerCode + '\'' +
                ",\n memberId='" + memberId + '\'' +
                ",\n memberType='" + memberType + '\'' +
                ",\n OmnitureFriendlyName='" + omnitureFriendlyName + '\'' +
                '}';
    }



    public String getFirstName() {
        return firstname;
    }
    @JsonSetter("FirstName")
    public void setFirstName(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }
    @JsonSetter("LastName")
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }
    @JsonSetter("Email")
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
    @JsonSetter("Password")
    public void setPassword(String password) {
        this.password = password;
    }

    public String getEtag() {
        return etag;
    }
    @JsonSetter("ETag")
    public void setEtag(String etag) {
        this.etag = etag;
    }

    public String getCountryCode() {
        return countryCode;
    }
    @JsonSetter("CountryCode")
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getLanguageCode() {
        return languageCode;
    }
    @JsonSetter("LanguageCode")
    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    public String getPartnerCode() {
        return partnerCode;
    }
    @JsonSetter("PartnerCode")
    public void setPartnerCode(String partnerCode) {
        this.partnerCode = partnerCode;
    }

    public String getHomePhone() {
        return homePhone;
    }
    @JsonSetter("HomePhone")
    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getMemberId() {
        return memberId;
    }
    @JsonSetter("Member_id")
    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getMemberType() {
        return memberType;
    }
    @JsonSetter("MemberType")
    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }

    public String getOmnitureFriendlyName() {
        return omnitureFriendlyName;
    }
    @JsonSetter("OmnitureFriendlyName")
    public void setOmnitureFriendlyName(String omnitureFriendlyName) {
        omnitureFriendlyName = omnitureFriendlyName;
    }



}
