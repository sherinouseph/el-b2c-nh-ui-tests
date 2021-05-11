package com.englishtown.helpers.mail;
/**
 * Nikol 2018
 *
 *
 */
/**
 * TODO
 * Use Environment System variable for password  and then call and endpoint to get other passes
 * OR use Configuration manager
 * OR Create spring app min that return json
 *
 * Other :
 * String p = "kjasghfdkgasdfjlkasfljkahgdsfjhgdjsfh".substring(8, 15);
 * https://stackoverflow.com/questions/1132567/encrypt-password-in-configuration-files
 */



public interface IMail {

    String G_PASS = "TKjaPass99PassPass100109Forgt";
    String G_HOST = "pop.gmail.com";
    String G_STORE_TYPE = "pop3";
    String G_USERNAME = "b2c.london@gmail.com";
    String C = G_PASS;

    String PASS_RESET_EMAIL_SUBJECT = "ifrenizi mi unuttunuz"; //"EF Password Reset";
}
