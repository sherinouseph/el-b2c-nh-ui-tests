package com.englishtown.enumpack.modules;

/**
 * Nikol May 2018
 * On grammarlab page are many topics
 *
 * A topic card contains 5 main components. For each element in topicCardListWe
 * 1. Title
 * 2. image
 * 3. Desc
 * 4. No of Lessons
 * 5. GetStarted btn
 */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum GrammarLabTopic {

    TITLE(""),   // shown on select topic to book a PL
    IMAGE(""),         // same as above
    DESC(""),
    LESSON_COUNT(""),
    BTN("");

    private final String topicCardDetails;

    private GrammarLabTopic(String topicCardDetails) {
        this.topicCardDetails = topicCardDetails;
    }

    public String getTopicCardDetails(){
        return this.topicCardDetails;
    }

    private static final Logger logger = LoggerFactory.getLogger(GrammarLabTopic.class);

}
