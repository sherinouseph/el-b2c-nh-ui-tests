package com.englishtown.enumpack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum Channel {

    DEFAULT("ALL"),
    ONLINE("Online"),
    TELESALES("Telesales");


    private final String channel;

    private Channel(String channel) {
        this.channel = channel;
    }

    public String getChannel(){
        return this.channel;
    }

    private static final Logger logger = LoggerFactory.getLogger(Channel.class);

}
