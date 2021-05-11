package com.englishtown.enumpack;
/**
 * Nikol 2018
 * Used for Rest calls .. get, post etc
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum RestCallType {

    GET("get"),
    PUT("put"),
    PATCH("patch"),
    POST("post");


    private final String method;

    private RestCallType(String method) {
        this.method = method;
    }

    public String getMethod(){
        return this.method;
    }

    private static final Logger logger = LoggerFactory.getLogger(RestCallType.class);


    public static RestCallType getGender(String method){
        RestCallType restCallType = null;

        method = method.toLowerCase().trim();

        logger.info("method [{}]",method);

        switch (method){
            case "post":
                restCallType =  RestCallType.POST;
                break;

            case "get":
                restCallType =  RestCallType.GET;
                break;

            case "put":
                restCallType =  RestCallType.PUT;
                break;

            case "patch":
                restCallType =  RestCallType.PATCH;
                break;

            default:
                logger.warn("Can not get Rest Method from string [{}]", method);
                break;
        }

        return restCallType;
    }

}
