package com.englishtown.newhouse.apicore.bean;
/**
 * Chat test user bean
 *
 * Nikol Apr 2018
 *
 */

import com.englishtown.enumpack.chat.ChatUserStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ChatTestUserBean {
    private static final Logger logger = LoggerFactory.getLogger(BaseReqBean.class);


    private String userName;        // email
    private String userId;
    private String efId;
    private String uuid;
    private String cmusCookie;      // "CMus", user1_cookie_cmus
    private String etSidCookie;     // "et_sid", user1_cookie_et_sid
    private boolean incoming;       // if a user has send friend request when he get the request list this is false
    private ChatUserStatus chatUserStatus;


    public ChatTestUserBean() {
    }

    public ChatTestUserBean(String userName, String userId) {
        this.userName = userName;
        this.userId = userId;
    }

    public ChatTestUserBean(String userName, String userId, String cmusCookie, String etSidCookie) {
        this.userName = userName;
        this.userId = userId;
        this.cmusCookie = cmusCookie;
        this.etSidCookie = etSidCookie;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }


    public void setUserId(String userId) {
        this.userId = userId;
    }


    public String getEfId() {
        return efId;
    }

    public void setEfId(String efId) {
        this.efId = efId;
    }

    public String getCmusCookie() {
        return cmusCookie;
    }

    public void setCmusCookie(String cmusCookie) {
        this.cmusCookie = cmusCookie;
    }

    public String getEtSidCookie() {
        return etSidCookie;
    }

    public void setEtSidCookie(String etSidCookie) {
        this.etSidCookie = etSidCookie;
    }

    public boolean isIncoming() {
        return incoming;
    }

    public void setIncoming(boolean incoming) {
        this.incoming = incoming;
    }


    public ChatUserStatus getChatUserStatus() {
        return chatUserStatus;
    }

    public void setChatUserStatus(ChatUserStatus chatUserStatus) {
        this.chatUserStatus = chatUserStatus;
    }


    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }


    @Override
    public String toString() {
        return "\nChatTestUserBean{" +
                "\n\tuserName='" + userName + '\'' +
                "\n\t userId='" + userId + '\'' +
                "\n\t efId='" + efId + '\'' +
                "\n\t uuid='" + uuid + '\'' +
                "\n\t cmusCookie='" + cmusCookie + '\'' +
                "\n\t etSidCookie='" + etSidCookie + '\'' +
                "\n\t incoming='" + incoming + '\'' +
                "\n\t OnlineStatus='" + chatUserStatus + '\'' +
                '}';
    }

}
