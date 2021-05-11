package com.englishtown.newhouse.school.beanandenum.bean.chat;
/**
 * Chat friends search result model   ...
 * json object called Hits it has many [hits [source] ]
 *
 *
 * Nikol Apr 2018
 *
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class ChatFriendsSearchResultBean {
    private static final Logger logger = LoggerFactory.getLogger(ChatFriendsSearchResultBean.class);

    protected int    hitsTotal;
    protected String maxScore;
    protected String index;
    protected String type;
    protected String id;    // "_id": "member:29768318",
    protected String score; // "_score": 9.997765,

    public HitSourceBean hitSourceBean;
    public List<HitSourceBean> hitSourceBeanList = new ArrayList<>();

    public void addHitSource(HitSourceBean hitSourceBean){
        hitSourceBeanList.add(hitSourceBean);
    }

    public ChatFriendsSearchResultBean(){}

    public ChatFriendsSearchResultBean(int hitsTotal, String maxScore, String index, String type, String id, String score, HitSourceBean hitSourceBean) {
        this.hitsTotal = hitsTotal;
        this.maxScore = maxScore;
        this.index = index;
        this.type = type;
        this.id = id;
        this.score = score;
        this.hitSourceBean = hitSourceBean;
        hitSourceBeanList.add(hitSourceBean);
    }

    public int getHitsTotal() {
        return hitsTotal;
    }

    public void setHitsTotal(int hitsTotal) {
        this.hitsTotal = hitsTotal;
    }

    public String getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(String maxScore) {
        this.maxScore = maxScore;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public List getHitSourceBeanList(){
        return hitSourceBeanList;
    }

    @Override
    public String toString() {
        return "ChatFriendsSearchResultBean{" +
                "hitsTotal=" + hitsTotal +
                ", maxScore='" + maxScore + '\'' +
                ", index='" + index + '\'' +
                ", type='" + type + '\'' +
                ", id='" + id + '\'' +
                ", score='" + score + '\'' +
                ", hitSourceBeanList=" + hitSourceBeanList +
                '}';
    }

    public void print(){
        logger.info(this.toString());
    }

}



/**
 empty search
 {
 "took": 4,
 "timed_out": false,
 "_shards": {
 "total": 5,
 "successful": 5,
 "skipped": 0,
 "failed": 0
 },
 "hits": {
 "total": 0,
 "max_score": null,[main] INFO com.englishlive.tests.newhouse.apitest.chat.ChatFriendSearchTest - @ After Class ...!

 "hits": [

 [main] INFO com.englishtown.newhouse.apicore.BaseApiHelper - BaseApiTest tart destroyDriver.......!
 ]


 /**
 * Search return
 *
 *
 "hits": {
 "total": 80,
 "max_score": 9.997765,
 "hits": [ {
 "_index": "chat_profile",
 "_type": "profile",
 "_id": "member:29768318",
 "_score": 9.997765,
 "_source": {
 "given_name": "auto",
 "family_name": "tester",
 "identifier": "29768318",
 "identifier_type": "member",
 "gender": "U",
 "country_code": "un",
 "email": "e3041489bfaf479fb67ea804931636fd9a0ff02ac8e8cc14d3bf17aebb74353b",
 "profile_privacy": "public",
 "chat_privacy": "public",
 "english_level": "Beginner",
 "english_level_code": "0",
 "update_timestamps": {
 "member/created": 1524653099229,
 "member/updated": 1524721225075
 }
 }
 },
 {
 "_index": "chat_profile",
 "_type": "profile",
 "_id": "member:11403328",
 "_score": 9.993378,
 "_source": {
 "given_name": "auto",
 "family_name": "iris",
 "identifier": "11403328",
 "identifier_type": "member",
 "gender": "U",
 "country_code": "un",
 "email": "4232e868e575c4624dd33bf72d6ea6e32dccf4fc02a83d243c2c02340c30d850",
 "profile_privacy": "public",
 "chat_privacy": "public",
 "update_timestamps": {
 "member/created": 1524105912633,
 "member/updated": 1524105927725
 },
 "english_level": "Elementary",
 "english_level_code": "2"
 }
 },*/

