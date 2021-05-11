package com.englishtown.enumpack;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum Language {

    DEFAULT("",""),
    AR("ar","Arabic"),
    CH("ch","TC (Taiwan)"),
    CS("cs","Chinese(GB)"),
    CT("ct","Catalan"),
    EN("en","English"),
    ES("es","Spanish(Sp.)"),
    FI("fi","Finnish"),
    FR("fr","French"),
    GE("ge","German"),
    HK("hk","TC (Hong Kong)"),
    IN("in","Indonesian"),
    IT("it","Italian"),
    JA("ja","Japanese"),
    KO("ko","Korean"),
    MX("mx","Mexican"),
    NO("no","Norwegian"),
    PL("pl","Polish"),
    PP("pp","Portuguese(Portugal)"),
    PT("pt","Portuguese(Brazil)"),
    RU("ru","Russian"),
    SP("sp","Spanish(L.Am.)"),
    SW("sw","Swedish"),
    TH("th","Thai"),
    TR("tr","TÜRKÇE"), //"Turkish"),
    TT("tt","Tatar"),
    VI("vi","Vietnamese");


    private final String langCode;
    private final String langName;

    private Language(String langCode, String langName) {
        this.langCode = langCode;
        this.langName = langName;
    }

    public String getLangCode(){
        return this.langCode;
    }

    public String getLangName(){
        return this.langName;
    }

    private static final Logger logger = LoggerFactory.getLogger(Language.class);

    public static Language fromCodeString(String langCodeStr) {
        logger.info("Get Language fromCodeString String ... [{}]", langCodeStr);
        for (Language lang : Language.values()) {
            if (StringUtils.equalsIgnoreCase(lang.langCode, langCodeStr)) {
                logger.info("Returning match [{}]", lang);
                return lang;
            }
        }
        logger.warn("Returning Default lang ...!");
        return Language.DEFAULT;
    }

    public static Language fromNameString(String langNameStr) {
        logger.info("Get Language fromNameString String ... [{}]", langNameStr);
        for (Language lang : Language.values()) {
            if (StringUtils.equalsIgnoreCase(lang.langName, langNameStr)) {
                logger.info("Returning match [{}]", lang);
                logger.info("langName [{}]", lang.langName);
                return lang;
            }
        }
        logger.warn("Returning Default lang ...!");
        return Language.DEFAULT;
    }

}




/**
 *
 *

 public Language getLanguageFromString(String lang){
 logger.info("Get Language from string {[]}", lang);


 switch (lang){


 default: logger.warn("Cant find Language for String {{}}, returning Default EN lang ....!", lang);
 }

 return Language.EN;
 }


 public Language getLanguageFromString(String lang){
 logger.info("Get Language from string {[]}", lang);


 switch (lang){
  case DEFAULT :
 break;
 case AR :
 return Language.EN ;

 case CH :
 return Language.EN ;

 case CS :
 return Language.EN ;

 case CT :
 return Language.EN ;

 case EN :
 return Language.EN ;

 case ES :
 return Language.EN ;

 case FI :
 return Language.EN ;

 case FR :
 return Language.EN ;

 case GE :
 return Language.EN ;

 case HK :
 return Language.EN ;

 case IN :
 return Language.EN ;

 case IT :
 return Language.EN ;

 case JA :
 return Language.EN ;

 case KO :
 return Language.EN ;

 case MX :
 return Language.EN ;

 case NO :
 return Language.EN ;

 case PL :
 return Language.EN ;

 case PP :
 return Language.EN ;

 case PT :
 return Language.EN ;

 case RU :
 return Language.EN ;

 case SP :
 return Language.EN ;

 case SW :
 return Language.EN ;

 case TH :
 return Language.EN ;

 case TR :
 return Language.EN ;

 case TT :
 return Language.EN ;

 case VI :
 return Language.EN ;

//default: logger.warn("Cant find Language for String {{}}, returning Default EN lang ....!", lang);
 //       }

//        return Language.EN;
//        }

 */