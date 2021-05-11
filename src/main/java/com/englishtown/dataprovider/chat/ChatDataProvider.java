package com.englishtown.dataprovider.chat;

import org.testng.annotations.DataProvider;

/**
 * Data provider for Tel No IT
 * User: nikol.marku
 * Date: 01/09/14
 *
 */
public class ChatDataProvider {


    @DataProvider(name = "createChatUsers")// , parallel = true)
    public static Object[][] createChatUsers() {
        return new Object[][] {
                { 1, false },  // incoming
                { 2, true },
                { 3, true }
        };
    }
}
