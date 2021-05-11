package com.englishtown.dataprovider.bin.validation;
/**
 * Nikol 2018
 * MemberPage validation message for the form
 *
 */

import com.englishtown.dataprovider.bin.CountryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MemberPageValidationMsgBean {
    private static final Logger logger = LoggerFactory.getLogger(CountryBean.class);


    protected String firstName_validationMsg        = "test should set this up";

    protected String lastName_validationMsg         = "test should set this up";

    protected String email_validationMsg            = "test should set this up";

    protected String email_inuse_validationMsg      = "test should set this up";

    protected String password_validationMsg         = "test should set this up";

    protected String termAndCondition_validationMsg = "test should set this up";



    public MemberPageValidationMsgBean() {
        //empty
    }

    public MemberPageValidationMsgBean(String firstName_validationMsg, String lastName_validationMsg,
                                       String email_validationMsg, String email_inuse_validationMsg,
                                       String password_validationMsg, String termAndCondition_validationMsg) {
        this.firstName_validationMsg = firstName_validationMsg;
        this.lastName_validationMsg = lastName_validationMsg;
        this.email_validationMsg = email_validationMsg;
        this.email_inuse_validationMsg = email_inuse_validationMsg;
        this.password_validationMsg = password_validationMsg;
        this.termAndCondition_validationMsg = termAndCondition_validationMsg;
        logger.info(this.toString());
    }

    public String toString() {
        String sFormat = "%1$-25s %2$-25s";
        String s = "\n";
        s = s + String.format(sFormat,  "\nfirstName_validationMsg :", firstName_validationMsg );
        s = s + String.format(sFormat,  "\nlastName_validationMsg :", lastName_validationMsg) ;
        s = s + String.format(sFormat,  "\nemail_validationMsg :", email_validationMsg) ;
        s = s + String.format(sFormat,  "\nemail_inuse_validationMsg :", email_inuse_validationMsg) ;
        s = s + String.format(sFormat,  "\npassword_validationMsg :", password_validationMsg );
        s = s + String.format(sFormat,  "\ntermAndCondition_validationMsg :", termAndCondition_validationMsg) ;
        return s;
    }

    public String getFirstName_validationMsg() {
        return firstName_validationMsg;
    }

    public void setFirstName_validationMsg(String firstName_validationMsg) {
        this.firstName_validationMsg = firstName_validationMsg;
    }

    public String getLastName_validationMsg() {
        return lastName_validationMsg;
    }

    public void setLastName_validationMsg(String lastName_validationMsg) {
        this.lastName_validationMsg = lastName_validationMsg;
    }

    public String getEmail_validationMsg() {
        return email_validationMsg;
    }

    public void setEmail_validationMsg(String email_validationMsg) {
        this.email_validationMsg = email_validationMsg;
    }

    public String getEmail_inuse_validationMsg() {
        return email_inuse_validationMsg;
    }

    public void setEmail_inuse_validationMsg(String email_inuse_validationMsg) {
        this.email_inuse_validationMsg = email_inuse_validationMsg;
    }


    public String getPassword_validationMsg() {
        return password_validationMsg;
    }

    public void setPassword_validationMsg(String password_validationMsg) {
        this.password_validationMsg = password_validationMsg;
    }

    public String getTermAndCondition_validationMsg() {
        return termAndCondition_validationMsg;
    }

    public void setTermAndCondition_validationMsg(String termAndCondition_validationMsg) {
        this.termAndCondition_validationMsg = termAndCondition_validationMsg;
    }

}
