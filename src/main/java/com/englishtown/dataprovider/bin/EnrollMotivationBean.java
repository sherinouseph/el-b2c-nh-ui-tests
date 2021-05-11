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

import java.util.ArrayList;
import java.util.List;

public class EnrollMotivationBean extends EnrollBean {
    private static final Logger logger = LoggerFactory.getLogger(EnrollMotivationBean.class);


    public EnrollMotivationBean(int id, String code, String name, String descr) {
        super(id, code, name, descr);
    }


    public static List<EnrollMotivationBean> getAllEnrolMotivation() {
        List<EnrollMotivationBean> enrollMotivationBeanList = new ArrayList<>();
        enrollMotivationBeanList.add(new EnrollMotivationBean(2, "career", "Your Career", "Your Career"));
        enrollMotivationBeanList.add(new EnrollMotivationBean(3, "traveling", "Traveling or living abroad", "Traveling or living abroad"));
        enrollMotivationBeanList.add(new EnrollMotivationBean(4, "test", "Taking an English test", "Taking an English test"));
        enrollMotivationBeanList.add(new EnrollMotivationBean(5, "development", "Your personal development", "Your personal development"));
        enrollMotivationBeanList.add(new EnrollMotivationBean(6, "another", "Another reason", "Another reason"));

        return enrollMotivationBeanList;
    }

}