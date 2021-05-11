package com.englishtown.enumpack;
/**
 * select option on book classroom
 * PL
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum ClassTopic {

    BUSINESS("BE"),         // shown on select topic to book a PL
    TOEIC("TOEIC"),         // same as above
    BEGINNERS_1("GE_0A"),
    BEGINNERS_2("GE_0B"),
    BEGINNERS_3("GE_1"),

    ELEMENTARY_4("GE_2"),
    ELEMENTARY_5("GE_3"),
    ELEMENTARY_6("GE_4"),

    INTERMEDIATE_7("GE_5"),
    INTERMEDIATE_8("GE_6"),
    INTERMEDIATE_9("GE_7"),

    UPPER_INTERMEDIATE_10("GE_8"),
    UPPER_INTERMEDIATE_11("GE_9"),
    UPPER_INTERMEDIATE_12("GE_10"),

    ADVANCED_13("GE_11"),
    ADVANCED_14("GE_12"),
    ADVANCED_15("GE_13"),

    UPPER_ADVANCED_16("GE_14");


    private final String classTopicValue;

    private ClassTopic(String classTopicValue) {
        this.classTopicValue = classTopicValue;
    }

    public String getClassTopicValue(){
        return this.classTopicValue;
    }

    private static final Logger logger = LoggerFactory.getLogger(ClassTopic.class);

}
