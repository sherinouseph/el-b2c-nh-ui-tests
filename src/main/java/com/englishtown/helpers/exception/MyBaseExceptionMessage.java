package com.englishtown.helpers.exception;

/**
 * Custom exception handling
 * General Exception
 *
 */
public class MyBaseExceptionMessage extends Exception implements Messageable{

    public MyBaseExceptionMessage(String msg){
        super(msg);
    }

}
