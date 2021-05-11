package com.englishtown.dataprovider.bin;
/**
 *
 * // LEVEL
 * "levelCode": null,
 "id": 1,
 "code": "Test your English",
 "name": "I'm not sure I want to take a placement test(20 minutes).",
 "descr": "This test resu
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EnrollBean {
    private static final Logger logger = LoggerFactory.getLogger(EnrollBean.class);

    protected int id;
    protected String code;
    protected String name;
    protected String descr;


    public EnrollBean(int id, String code, String name, String descr) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.descr = descr;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }



}


/**

 [
 {
 "levelCode": null,
 "id": 1,
 "code": "Test your English",
 "name": "I'm not sure I want to take a placement test(20 minutes).",
 "descr": "This test result will reflect your current level of English. It will take approximately 20 minutes."
 },
 {
 "levelCode": "01",
 "id": 3,
 "code": "Beginner",
 "name": "I know almost no English.",
 "descr": "Hello"
 },
 {
 "levelCode": "04",
 "id": 4,
 "code": "Elementary",
 "name": "I can give basic information about my personal life and my school or work.",
 "descr": "I'm an engineer. I work in a big company. I live in Asia."
 },
 {
 "levelCode": "07",
 "id": 5,
 "code": "Intermediate",
 "name": "I can talk about my background and about my hopes and plans for the future.",
 "descr": "I worked in the UK for five years. I'm planning to move to China next year."
 },
 {
 "levelCode": "10",
 "id": 6,
 "code": "Upper Intermediate",
 "name": "I can deal with most transactions that arise in daily life and traveling.",
 "descr": "I'd like to make a reservation to fly to Los Angeles on the 5th. I'll be returning on October 15th."
 },
 {
 "levelCode": "13",
 "id": 7,
 "code": "Advanced",
 "name": "I can exchange complex information about my personal and work life.",
 "descr": "Before going back for my MBA, I had been working in an internet company for five years."
 },
 {
 "levelCode": "16",
 "id": 8,
 "code": "Upper Advanced",
 "name": "I can use language flexibly and effectively - including emotional, nuanced and joking usage - \" +\r\n                    \"even when people are speaking quickly.",
 "descr": "In my opinion, homelessness is the most critical issue facing society. \" +\r\n                    \"We have to develop effective policies for reintegrating homeless people into mainstream society."
 }
 ]


 */