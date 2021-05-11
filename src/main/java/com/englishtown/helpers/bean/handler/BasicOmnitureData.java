package com.englishtown.helpers.bean.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by nikol.marku on 11/04/2016.
 */
public class BasicOmnitureData extends BasicHandler {
    private static final Logger logger = LoggerFactory.getLogger(BasicOmnitureData.class);

    protected String pageName; // pageName=LandingPages    :ee:emailenglish
    protected String c11;      // Root ... ptn
    protected String c12;      // fr
    protected String c15;      // fr-fr
    protected String c25;      // fr
    protected String v0;       //OmniTestEtagNikol
    protected String statusCode; //200


    public BasicOmnitureData(String pageName, String c11, String c12, String c15, String c25, String v0, String statusCode) {
        super();
        this.pageName = pageName;
        this.statusCode = statusCode;
        this.c11 = c11;
        this.c12 = c12;
        this.c25 = c25;
        this.c15 = c15;
        this.v0  = v0;
    }
    public BasicOmnitureData() {
        super();
    }

    public String getC11() {
        return c11;
    }

    public void setC11(String c11) {
        this.c11 = c11;
    }

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    public String getC12() {
        return c12;
    }

    public void setC12(String c12) {
        this.c12 = c12;
    }

    public String getC25() {
        return c25;
    }

    public void setC25(String c25) {
        this.c25 = c25;
    }

    public String getC15() {
        return c15;
    }

    public void setC15(String c15) {
        this.c15 = c15;
    }

    public String getV0() {
        return v0;
    }

    public void setV0(String v0) {
        this.v0 = v0;
    }


    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }


}
