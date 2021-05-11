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
public class BasicPostDataHandler extends BasicHandler {
    private static final Logger logger = LoggerFactory.getLogger(BasicPostDataHandler.class);
    //@JsonProperty("firstname")
    protected String firstname;   // first_name    protected String lastname;
    //@JsonProperty("email")
    protected String email;
    //@JsonProperty("local")
    protected String local;      // e.g fr
    //@JsonProperty("leadtype")
    protected String leadtype;   // (oe|ee|ft|.....)


    public BasicPostDataHandler(){
        super();
        this.firstname = "";
        this.leadtype = "";
        this.local = "";
        this.email = "";
    }
    public BasicPostDataHandler(String firstname, String email, String leadtype, String local) {
        super();
        this.firstname = firstname;
        this.email = email;
        this.leadtype = leadtype;
        this.local = local;
    }

    /**
     :first_name       :testDBstore
     :email              :db1_1460034211844@qp1.org
     :local   :fr
     :leadtype  :ee
     */
    public void setBasicObjectValue(String key, String value){
        logger.info("setObjectValue [key:"+key+" ; value :"+value+"]");

        switch(key){
            case "first_name": this.setFirstname(value);
                break;
            case "firstname": this.setFirstname(value);
                break;
            case "email": this.setEmail(value);
                break;
            case "local": this.setLocal(value);
                break;
            case "leadtype": this.setLeadtype(value);
                break;

            default:
                logger.error("Can't set the object value for this key ...! [key:"+key);
                break;

        }
    }

    /**
     * Note : Response is not considered for the obj to be ==
     * @param compareObj
     * @return
     */
    @Override
    public boolean equals(Object compareObj) {
        if (compareObj instanceof BasicPostDataHandler)   {
            BasicPostDataHandler obj = (BasicPostDataHandler) compareObj;
            if( this.getFirstname().equals(obj.getFirstname()) && this.getEmail().equals(obj.getEmail())
                 && this.getLeadtype().equals(obj.getLeadtype()) && this.getLocal().equals(obj.getLocal())  )
                return true;
        }
        return false;
    }

    public String getLeadtype() {
        return leadtype;
    }
    @JsonSetter("LeadType")
    public void setLeadtype(String leadtype) {
        this.leadtype = leadtype;
    }

    public String getLocal() {
        return local;
    }
    @JsonSetter("Locale")
    public void setLocal(String local) {
        this.local = local;
    }

    public String getEmail() {
        return email;
    }
    @JsonSetter("Email")
    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }
    @JsonSetter("FirstName")
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Override
    public String toString(){
        return "\nBasicPostDataHandler [ {\nfirstname :"+getFirstname()+ ",\nleadtype :"+getLeadtype()+
                ",\nlocal :" +getLocal()+ ",\nemail :"+getEmail()+"\n} ]";
    }


}
