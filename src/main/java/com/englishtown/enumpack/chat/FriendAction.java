package com.englishtown.enumpack.chat;
/**
 * Nikol Apr 2018
 *
 * Post Fried actions list
 * POST   /chat/2.0/friend
 *
 * "add/approve/reject/delete/cancel/block/unblock" all actions
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum FriendAction {

    ADD("add"),
    APPROVE("approve"),
    REJECT("reject"),
    DELETE("delete"),
    CANCEL("cancel"),
    BLOCK("block"),
    UNBLOCK("unblock");

    private final String action;

    private FriendAction(String action) {
        this.action = action;
    }

    public String getAction(){
        return this.action;
    }

    private static final Logger logger = LoggerFactory.getLogger(FriendAction.class);

}
