package com.englishtown.dataprovider.bin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created by nikol.marku on 2/7/2017.
 * Store data for name
 *
 */
public class CountryBean {
    private static final Logger logger = LoggerFactory.getLogger(CountryBean.class);

    private String name;            // italy
    private String twoLetterCode;   // it ISO
    private String threeLetterCode; // it
    private String mainLanguage;    // it
    private String capital;         // [default city selected]
    private String relativeUrl;     // /en-us/ the part after englishlive.ef.com
    private String[][][][] dept_City_PhoneType_DefaultValue;  //Dept | City | PhoneType | default Phone No  /*private List<String> departmentList;    private List<String> city;    private List<String> cityPhoneDefaultValues;  //(54)-93835-  -    (54)-911-    -*/
    private boolean hasDept;
    private String defaultMobilePhoneMask; // note this will depend on department thats why we should use dept_City_PhoneType_DefaultValue
    private String defaultHomePhoneMask;
    private String phoneNumber;    // number to call

    public CountryBean(){
        //empty
    }

    public CountryBean(String name, String twoLetterCode, String mainLanguage, String capital, String relativeUrl,
                       boolean hasDept, String defaultMobilePhoneMask, String defaultHomePhoneMask, String phoneNumber) {
        this.name = name;
        this.twoLetterCode = twoLetterCode;
        this.mainLanguage  = mainLanguage;
        this.capital       = capital;
        this.relativeUrl   = relativeUrl;
        this.hasDept       = hasDept;
        this.defaultMobilePhoneMask = defaultMobilePhoneMask;
        this.defaultHomePhoneMask = defaultHomePhoneMask;
        this.phoneNumber = phoneNumber;
    }

    public String toString() {
        String sFormat = "%1$-25s %2$-25s";
        String s = "\n";
        s = s + String.format(sFormat,  "\nCountryName :", name );
        s = s + String.format(sFormat,  "\ntwoLetterCode :", twoLetterCode) ;
        s = s + String.format(sFormat,  "\nthreeLetterCode :", threeLetterCode) ;
        s = s + String.format(sFormat,  "\nmainLanguage :", mainLanguage );
        s = s + String.format(sFormat,  "\ncapital :", capital) ;
        s = s + String.format(sFormat,  "\nrelativeUrl :", relativeUrl );
        s = s + String.format(sFormat,  "\nhasDept :", hasDept );
        s = s + String.format(sFormat,  "\ndefaultMobilePhoneMask: ", defaultMobilePhoneMask) ;
        s = s + String.format(sFormat,  "\ndefaultHomePhoneMask :", defaultHomePhoneMask );
        s = s + String.format(sFormat,  "\nPhomeNumber :", phoneNumber);
        return s;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTwoLetterCode() {
        return twoLetterCode;
    }

    public void setTwoLetterCode(String twoLetterCode) {
        this.twoLetterCode = twoLetterCode;
    }

    public String getMainLanguage() {
        return mainLanguage;
    }

    public void setMainLanguage(String mainLanguage) {
        this.mainLanguage = mainLanguage;
    }

    public String getRelativeUrl() {
        return relativeUrl;
    }

    public void setRelativeUrl(String relativeUrl) {
        this.relativeUrl = relativeUrl;
    }

    public String[][][][] getDept_City_PhoneType_DefaultValue() {
        return dept_City_PhoneType_DefaultValue;
    }

    public void setDept_City_PhoneType_DefaultValue(String[][][][] dept_City_PhoneType_DefaultValue) {
        this.dept_City_PhoneType_DefaultValue = dept_City_PhoneType_DefaultValue;
    }

    public String getThreeLetterCode() {
        return threeLetterCode;
    }

    public void setThreeLetterCode(String threeLetterCode) {
        this.threeLetterCode = threeLetterCode;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public boolean isHasDept() {
        return hasDept;
    }

    public void setHasDept(boolean hasDept) {
        this.hasDept = hasDept;
    }


    public String getDefaultMobilePhoneMask() {
        return defaultMobilePhoneMask;
    }

    public void setDefaultMobilePhoneMask(String defaultMobilePhoneMask) {
        this.defaultMobilePhoneMask = defaultMobilePhoneMask;
    }

    public String getDefaultHomePhoneMask() {
        return defaultHomePhoneMask;
    }

    public void setDefaultHomePhoneMask(String defaultHomePhoneMask) {
        this.defaultHomePhoneMask = defaultHomePhoneMask;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }




}
