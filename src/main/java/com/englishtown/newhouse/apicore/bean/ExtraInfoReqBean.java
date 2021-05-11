package com.englishtown.newhouse.apicore.bean;
/**
 * Created by nikol.marku on 18/10/2017.
 * api req bean
 *
 */
import org.codehaus.jackson.annotate.JsonProperty;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Set;

///// TODO refactor inner class ... check read from file as well
public class ExtraInfoReqBean extends BaseReqBean {
    private static final Logger logger = LoggerFactory.getLogger(ExtraInfoReqBean.class);

    public ExtraInfo extraInfo;


    public ExtraInfoReqBean() {
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


}

