package com.englishtown.helpers.bean.handler;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonSetter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by nikol.marku on 07/04/2016.
 * Define the basic info this handler post to the server
 *
 *
 */
public class EfFullDataBean extends BasicPostDataHandler {
    private static final Logger logger = LoggerFactory.getLogger(EfFullDataBean.class);
    //@JsonProperty("MemberId")   ->add this above class definition  @JsonAutoDetect  //if you don't want to have getters and setters for each JsonProperty
    protected String MemberId;
    protected String Partner;
    protected String LastName;
    protected String HomePhone;
    protected String WorkPhone;
    protected String Age;
    protected String CallTime;
    protected String Region;
    protected String Campaign;
    protected String Etag;
    protected String Province;
    protected String City;
    protected String OmnitureFriendlyName;
    protected String MobilePhone;
    protected String Lead_id;
    protected String GAClientId;
    protected String AdobeVisitorId;


    public EfFullDataBean (String firstname, String email, String leadtype, String local){
        super(firstname, email, leadtype, local);
    }

    public EfFullDataBean(String firstname, String email, String leadtype, String local, String memberId,
                          String partner, String lastName, String homePhone, String workPhone, String age,
                          String callTime, String region, String campaign, String etag, String province, String city,
                          String omnitureFriendlyName, String mobilePhone, String lead_id){ //} String GAClientId,  String adobeVisitorId) {
        super(firstname, email, leadtype, local);
        MemberId = memberId;
        Partner = partner;
        LastName = lastName;
        HomePhone = homePhone;
        WorkPhone = workPhone;
        Age = age;
        CallTime = callTime;
        Region = region;
        Campaign = campaign;
        Etag = etag;
        Province = province;
        City = city;
        OmnitureFriendlyName = omnitureFriendlyName;
        MobilePhone = mobilePhone;
        Lead_id = lead_id;
        /*this.GAClientId = GAClientId;
        AdobeVisitorId = adobeVisitorId;*/
    }

    public EfFullDataBean(){
        super();
    }


    public void setEfFullBeanObjectValue(String key, String value){
        logger.info("setObjectValue [key:"+key+" ; value :"+value+"]");
        key = key.toLowerCase();
        switch(key){
            case "first_name": this.setFirstname(value);
                break;
            case "firstname": this.setFirstname(value);
                break;
            case "last_name": this.setLastName(value);
                break;
            case "lastname": this.setLastName(value);
                break;
            case "email": this.setEmail(value);
                break;
            case "countrycode": this.setLocal(value);
                break;
            case "local": this.setLocal(value);
                break;
            case "leadtype": this.setLeadtype(value);
                break;
            case "lead_type": this.setLeadtype(value);
                break;
            case "partnerCode": this.setPartner(value);
                break;
            case "partner": this.setPartner(value);
                break;
            case "telephone": this.setHomePhone(value);
                break;
            case "homephone": this.setHomePhone(value);
                break;
            case "workphone": this.setWorkPhone(value);
                break;
            case "mobilephone": this.setMobilePhone(value);
                break;
            case "age": this.setAge(value);
                break;
            case "calltime": this.setCallTime(value);
                break;
            case "region": this.setRegion(value);
                break;
            case "campaign": this.setCampaign(value);
                break;
            case "etag": this.setEtag(value);
                break;
            case "province": this.setProvince(value);
                break;
            case "city": this.setCity(value);
                break;
            case "omniturefriendlyname": this.setOmnitureFriendlyName(value);
                break;
            case "leadid": this.setLead_id(value);
                break;
            case "member_id": this.setMemberId(value);
                break;
            case "gaclientid": this.setGAClientId(value);
                break;
            case "member.gaclientid": this.setGAClientId(value);
                break;
            case "adobevisitorid": this.setAdobeVisitorId(value);
                break;
            case "member.adobevisitorid": this.setAdobeVisitorId(value);
                break;

            default:
                logger.error("Can't set the object value for this key ...! [key:"+key);
                break;
        }
    }


    @Override
    public String toString() {
        return super.toString()+"\n"+"\nEfFullDataBean [ {" +
                "\nMemberId='" + MemberId + '\'' +
                ",\n Partner='" + Partner + '\'' +
                ",\n LastName='" + LastName + '\'' +
                ",\n HomePhone='" + HomePhone + '\'' +
                ",\n WorkPhone='" + WorkPhone + '\'' +
                ",\n Age='" + Age + '\'' +
                ",\n CallTime='" + CallTime + '\'' +
                ",\n Region='" + Region + '\'' +
                ",\n Campaign='" + Campaign + '\'' +
                ",\n Etag='" + Etag + '\'' +
                ",\n Province='" + Province + '\'' +
                ",\n City='" + City + '\'' +
                ",\n OmnitureFriendlyName='" + OmnitureFriendlyName + '\'' +
                ",\n MobilePhone='" + MobilePhone + '\'' +
                ",\n Lead_id='" + Lead_id + '\'' +
                /*",\n GAClientId='" + GAClientId + '\'' +
                ",\n AdobeVisitorId='" + AdobeVisitorId + '\'' +*/
                '}';
    }

    //---------------------

    public String getMemberId() {
        return MemberId;
    }
    @JsonSetter("MemberId")
    public void setMemberId(String memberId) {
        MemberId = memberId;
    }

    public String getPartner() {
        return Partner;
    }
    @JsonSetter("Partner")
    public void setPartner(String partner) {
        Partner = partner;
    }

    public String getLastName() {
        return LastName;
    }
    @JsonSetter("LastName")
    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getHomePhone() {
        return HomePhone;
    }
    @JsonSetter("HomePhone")
    public void setHomePhone(String homePhone) {
        HomePhone = homePhone;
    }

    public String getWorkPhone() {
        return WorkPhone;
    }
    @JsonSetter("WorkPhone")
    public void setWorkPhone(String workPhone) {
        WorkPhone = workPhone;
    }

    public String getAge() {
        return Age;
    }
    @JsonSetter("Age")
    public void setAge(String age) {
        Age = age;
    }

    public String getCallTime() {
        return CallTime;
    }
    @JsonSetter("CallTime")
    public void setCallTime(String callTime) {
        CallTime = callTime;
    }

    public String getRegion() {
        return Region;
    }
    @JsonSetter("Region")
    public void setRegion(String region) {
        Region = region;
    }

    public String getCampaign() {
        return Campaign;
    }
    @JsonSetter("Campaign")
    public void setCampaign(String campaign) {
        Campaign = campaign;
    }

    public String getEtag() {
        return Etag;
    }
    @JsonSetter("Etag")
    public void setEtag(String etag) {
        Etag = etag;
    }

    public String getProvince() {
        return Province;
    }
    @JsonSetter("Province")
    public void setProvince(String province) {
        Province = province;
    }

    public String getCity() {
        return City;
    }
    @JsonSetter("City")
    public void setCity(String city) {
        City = city;
    }

    public String getOmnitureFriendlyName() {
        return OmnitureFriendlyName;
    }
    @JsonSetter("OmnitureFriendlyName")
    public void setOmnitureFriendlyName(String omnitureFriendlyName) {
        OmnitureFriendlyName = omnitureFriendlyName;
    }

    public String getMobilePhone() {
        return MobilePhone;
    }
    @JsonSetter("MobilePhone")
    public void setMobilePhone(String mobilePhone) {
        MobilePhone = mobilePhone;
    }

    public String getLead_id() {
        return Lead_id;
    }
    @JsonSetter("Lead_id")
    public void setLead_id(String lead_id) {
        Lead_id = lead_id;
    }

    public String getGAClientId() {
        return GAClientId;
    }
    @JsonSetter("GAClientId")
    public void setGAClientId(String GAClientId) {
        this.GAClientId = GAClientId;
    }

    public String getAdobeVisitorId() {
        return AdobeVisitorId;
    }
    @JsonSetter("AdobeVisitorId")
    public void setAdobeVisitorId(String adobeVisitorId) {
        AdobeVisitorId = adobeVisitorId;
    }

}


/**
full data posted when form is submited.   oe form
 "Id":280467,
 "MemberId":-1
 "Locale":"pe"
 "Partner":"None"
 "FirstName":"testDBstore"
 "LastName":"FnameTCJC"
 "Email":"db1_1486719622427@qp1.org"
 "HomePhone":""
 "WorkPhone":""
 "DateEntered":"2017-02-10T04:40:47.587Z"
 "LearnReason":null
 "Proficiency":null
 "Occupation":null
 "Age":"21-25"
 "CallTime":null
 "Region":""
 "StudyFocus":null
 "Campaign":null
 "Etag":""
 "Province":"amazonas"
 "City":"capital-federal"
 "WorkDistrict":null
 "EventId":null
 "DoubleConfirm":0
 "WantCall":false
 "Gender":null
 "StudyMotivation":null
 "StudyFrequency":null
 "JobFunction":null
 "JobSeniority":null
 "HeardAboutUs":null
 "JPAffliatedTrackId":null
 "AreasToImprove":null
 "Industry":null
 "IsValidEmail":true
 "OmnitureFriendlyName":"SalesPages:Home"
 "MobilePhone":"(51)-922-334-454"
 "NearbyCenter":null
 "AcademicQualification":null
 "InternetSpeed":null
 "DeviceType":null
 "OS":null
 "SearchEngineCode":null
 "SearchEngineKeyword":null
 "LeadFormVersion":null
 "InsertDate":"2017-02-10T04:40:47.570Z"
 "UpdateDate":"2017-02-10T04:40:47.570Z"
 "HashCode":"E8-80-24-20-F7-0D-74-7B-6E-10-06-53-E9-AF-8A-54"
 "Lead_id":280467
 "LeadType":"oe"
 "TestScore":""
 "CEFHistory":""
 "ReferrerUserName":""
 "JobTitle":""
 "BusinessNature":""
 "NumberOfStaff":null
 "NumberOfSet":null
 "Description":"AEM;OE;pageMarketCode=ar"
 "CountryOrigin":""
 "PartnerOrigin":""
 "LivingDistrict":""
 "Company":""
 "EnglishLevel":""
 "Rating":""
 "MemberCreateDate":null
 "LeadScore":null
 "School":null
 "IsValidLead":false
 "Reason":null
 "SourceType":0
 "Message":""
 "HasOffersTransactionId":""
 "GoogleClickId":""
 "MarinClickId":""
 "EFGuid":"f3830248-d2b6-4c85-a77c-af513781a9f3"
 "TradeDoublerUId":null
 "Postcode":""
 "EventId_Update":null
 "Etag_Update":null
 "OmnitureFriendlyName_Update":null
 "NearbyCenter_Update":null
 "E1IsSubscriber":null
 "E1FormType":null
 "E1OdinFirstName":null
 "E1OdinLastName":null
 "E1OdinCity":null
 "E1OdinSchool":null
 "E1OdinCourseLevel":null
 "E1OdinCountry":null
 "E1OdinStatus":null
 "E1OdinSubStatus":null
 "E1OdinVisitBookedDate":null
 "E1OdinVisitDate":null
 "E1OdinFirstPaidDate":null
 "E1OdinEnquiryDate":null
 "E1OdinLastSubStatusChangeDate":null
 "LocalMarketing":null
 "HeardAboutUs_Update":null
 "PayMethod":null
 "StaffEmail":null
 "UtmSource":""
 "UtmMedium":""
 "UtmCampaign":""
 "UtmTerm":""
 "UtmContent":""
 "AdGroup":""
 "GAClientId":"613736956.1486719628"
 "AdobeVisitorId":"70254562326752446524111944744665579445"
 "ReferredBy":null
 "ReferredFrom":""
 "EFSETTestLevel":null
 "FacebookQuestion1":null
 "FacebookAnswer1":null
 "FacebookQuestion2":null
 "FacebookAnswer2":null
 "FacebookQuestion3":null
 "FacebookAnswer3":null
 "SmsSendStatus":null
 "Birthday":null}


 /// Data retrived from DB  String url = "http://qa-englishlive.ef.com/services/commerce-v4/leadsmanager/getbyemail?email=getEmail();
 {"Id":280769,"MemberId":-1,"Locale":"pe","Partner":"None","FirstName":"FautoNik","LastName":"LMak","Email":"auto_1486998074413_xdelx@qp1.org",
 "HomePhone":"","WorkPhone":"","DateEntered":"2017-02-13T10:01:43.363Z","LearnReason":null,"Proficiency":null,"Occupation":null,"Age":"21-25",
 "CallTime":null,"Region":"","StudyFocus":null,"Campaign":null,"Etag":"","Province":"amazonas","City":"capital-federal","WorkDistrict":null,"
 EventId":null,"DoubleConfirm":0,"WantCall":false,"Gender":null,"StudyMotivation":null,"StudyFrequency":null,"JobFunction":null,"JobSeniority":null,
 "HeardAboutUs":null,"JPAffliatedTrackId":null,"AreasToImprove":null,"Industry":null,"IsValidEmail":true,"OmnitureFriendlyName":"SalesPages:Home",
 "MobilePhone":"(51)-922-334-454","NearbyCenter":null,"AcademicQualification":null,"InternetSpeed":null,"DeviceType":null,"OS":null,
 "SearchEngineCode":null,"SearchEngineKeyword":null,"LeadFormVersion":null,"InsertDate":"2017-02-13T10:01:43.577Z",
 "UpdateDate":"2017-02-13T10:01:43.577Z","HashCode":"E9-DA-0C-FA-77-77-40-74-D4-F8-71-03-1A-06-63-95","Lead_id":280769,
 "LeadType":"oe","TestScore":"","CEFHistory":"","ReferrerUserName":"","JobTitle":"","BusinessNature":"","NumberOfStaff":null,
 "NumberOfSet":null,"Description":"AEM;OE;pageMarketCode=ar","CountryOrigin":"","PartnerOrigin":"","LivingDistrict":"","Company":"",
 "EnglishLevel":"","Rating":"","MemberCreateDate":null,"LeadScore":null,"School":null,"IsValidLead":false,"Reason":null,"SourceType":0,
 "Message":"","HasOffersTransactionId":"","GoogleClickId":"","MarinClickId":"","EFGuid":"60e974d5-03f0-40d5-b67d-444d0742546a","TradeDoublerUId":null,
 "Postcode":"","EventId_Update":null,"Etag_Update":null,"OmnitureFriendlyName_Update":null,"NearbyCenter_Update":null,"E1IsSubscriber":null,
 "E1FormType":null,"E1OdinFirstName":null,"E1OdinLastName":null,"E1OdinCity":null,"E1OdinSchool":null,"E1OdinCourseLevel":null,
 "E1OdinCountry":null,"E1OdinStatus":null,"E1OdinSubStatus":null,"E1OdinVisitBookedDate":null,"E1OdinVisitDate":null,"E1OdinFirstPaidDate":null,"E1OdinEnquiryDate":null,"E1OdinLastSubStatusChangeDate":null,"LocalMarketing":null,"HeardAboutUs_Update":null,"PayMethod":null,"StaffEmail":null,"UtmSource":"","UtmMedium":"","UtmCampaign":"","UtmTerm":"","UtmContent":"","AdGroup":"","GAClientId":"1836975828.1486998089","AdobeVisitorId":"75987136158589553370902758162906055197","ReferredBy":null,"ReferredFrom":"","EFSETTestLevel":null,"FacebookQuestion1":null,"FacebookAnswer1":null,"FacebookQuestion2":null,"FacebookAnswer2":null,"FacebookQuestion3":null,"FacebookAnswer3":null,"SmsSendStatus":null,"Birthday":null}

 */