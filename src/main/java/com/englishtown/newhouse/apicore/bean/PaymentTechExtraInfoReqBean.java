package com.englishtown.newhouse.apicore.bean;
/**
 * Created by nikol.marku on 18/10/2017.
 * api req bean
 *
 */
import org.codehaus.jackson.annotate.JsonProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

/**
 * TODO: remove and use ExtraInfoReqBean
 */
public class PaymentTechExtraInfoReqBean extends BaseReqBean {
    private static final Logger logger = LoggerFactory.getLogger(PaymentTechExtraInfoReqBean.class);

    public ExtraInfo extraInfo;


    public PaymentTechExtraInfoReqBean() {
        extraInfo = new ExtraInfo();
    }

    public ExtraInfo getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(ExtraInfo extraInfo) {
        this.extraInfo = extraInfo;
    }

    public void setExtraInfoBeanFromMap(HashMap<String, String> extraInfoMap) {
        extraInfo.setExtraInfoFromMap(extraInfoMap);
    }


    public String toString() {
        String sFormat = "%1$-25s %2$-25s";
        String s = super.toString();
        s = s + extraInfo.toString();
        return s;
    }


    class ExtraInfo {

        private final Logger logger = LoggerFactory.getLogger(PaymentTechExtraInfo.class);

        @JsonProperty("country")
        private String country;

        @JsonProperty("accountType")
        private String accountType;

        @JsonProperty("ddAccountName")
        private String ddAccountName;

        @JsonProperty("ddCountry")
        private String ddCountry;

        @JsonProperty("ddBIC")
        private String ddBIC;

        @JsonProperty("ddRibCode")
        private String ddRibCode;

        @JsonProperty("ddIBAN")
        private String ddIBAN;



    /*PaymentTechExtraInfo(){
        //
    }*/

        public void setExtraInfoFromMap(HashMap<String, String> extraInfoMap) {
            try {
                this.country       = extraInfoMap.get("country");
                this.accountType   = extraInfoMap.get("accountType");
                this.ddAccountName = extraInfoMap.get("ddAccountName");
                this.ddCountry     = extraInfoMap.get("ddCountry");
                this.ddBIC         = extraInfoMap.get("ddBIC");
                this.ddRibCode     = extraInfoMap.get("ddRibCode");
                this.ddIBAN        = extraInfoMap.get("ddIBAN");
            } catch (Exception e) {
                logger.info("Could not set extra info :" + e.getMessage());
            }
        }


    @Override
    public String toString() {
        String sFormat = "%1$-25s %2$-25s";
        String s = "\n************************** Extra Info ********************************\n";
        s = s + String.format(sFormat,  "\ncountry :", getCountry() );
        s = s + String.format(sFormat,  "\naccountType :", getAccountType()) ;
        s = s + String.format(sFormat,  "\nddAccountName :", getDdAccountName()) ;
        s = s + String.format(sFormat,  "\nddCountry :", getDdCountry() );
        s = s + String.format(sFormat,  "\nddBIC :", getDdBIC() );
        s = s + String.format(sFormat,  "\nddRibCode :", getDdRibCode() );
        s = s + String.format(sFormat,  "\nddIBAN :", getDdIBAN() );
        s = s + "\n***********************************************************************\n";
        return s;
    }


        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getAccountType() {
            return accountType;
        }

        public void setAccountType(String accountType) {
            this.accountType = accountType;
        }

        public String getDdAccountName() {
            return ddAccountName;
        }

        public void setDdAccountName(String ddAccountName) {
            this.ddAccountName = ddAccountName;
        }

        public String getDdCountry() {
            return ddCountry;
        }

        public void setDdCountry(String ddCountry) {
            this.ddCountry = ddCountry;
        }

        public String getDdBIC() {
            return ddBIC;
        }

        public void setDdBIC(String ddBIC) {
            this.ddBIC = ddBIC;
        }

        public String getDdIBAN() {
            return ddIBAN;
        }

        public void setDdIBAN(String ddIBAN) {
            this.ddIBAN = ddIBAN;
        }

        public String getDdRibCode() {
            return ddRibCode;
        }

        public void setDdRibCode(String ddRibCode) {
            this.ddRibCode = ddRibCode;
        }

    }

}
