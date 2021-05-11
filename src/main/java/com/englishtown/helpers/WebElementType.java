package com.englishtown.helpers;

/**
 * 
 * Created by nikol.marku on 14/07/2015.
 */

enum WebElementType {
    INPUT_TEXT     ("text"),
    INPUT_EMAIL    ("email"),
    INPUT_PASSWROD ("password"),
    CHECKBOX       ("checkbox"),
    RADIOBUTTON    ("radio"),
    SELECT         ("select"),
    TEXTAREA       ("textarea"),
    OTHER          ("other");

    String type;

    WebElementType(String type){
        this.type = type;
    }

    String getType(){
        return type;
    }
}
