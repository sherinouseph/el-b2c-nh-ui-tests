package com.englishtown.helpers.bean;

/**
 * Created by nikol.marku on 20/05/2016.
 */
public class MyHttpResponse {

    int resposneCode;
    String responseContent;

    public MyHttpResponse(int resposneCode, String responseContent) {
        this.resposneCode = resposneCode;
        this.responseContent = responseContent;
    }

    public int getResposneCode() {
        return resposneCode;
    }

    public void setResposneCode(int resposneCode) {
        this.resposneCode = resposneCode;
    }

    public String getResponseContent() {
        return responseContent;
    }

    public void setResponseContent(String responseContent) {
        this.responseContent = responseContent;
    }



}
