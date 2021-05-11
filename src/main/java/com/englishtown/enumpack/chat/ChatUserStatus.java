package com.englishtown.enumpack.chat;
/**
 * Nikol Apr 2018
 *
 *'1': 'online',
 '2': 'offline', // really offline
 '3': 'idle',
 '4': 'busy',
 '5': 'offline' // appear offline
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum ChatUserStatus {

    ONLINE(1),
    //NOT SUPPOSE TO USE [TEDDY]
    OFFLINE(2),   // REALLY OFFLINE
    IDLE(3),
    BUSY(4),
    APPEAR_OFFLINE(5);

    private int id;

    public int getId() {
        return id;
    }



    ChatUserStatus(int id ){
        this.id = id;
    }


    private static final Logger logger = LoggerFactory.getLogger(ChatUserStatus.class);

}
