package com.englishtown.enumpack.modules;

/**
 * Select topic page
 *
 * A card contains 4 main components. For each element in cardTopicListWe
 * 1. Title      .title h3
 * 2. image      .image img
 * 3. learnMore  .plb-card-action.action-learn-more   [Click on this shows card details and select this topic]
 * 4. select     .plb-card-action .action-select-topic
 *  // click on learnmore
 *  6. cardDetails .plb-card-details p    ..shows msg
 *  7. select topic .plb-card-action-expanded.action-select-topic
 */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum TopicCardDetails {

    TITLE(""),   // shown on select topic to book a PL
    IMAGE(""),         // same as above
    LEARNMORE("Learn More"),
    SELECT("Select"),
    EXPAND_CARD_DETAILS(""),
    EXPAND_SELECT_TOPIC("Select this topic");

    private final String topicCardDetails;

    private TopicCardDetails(String topicCardDetails) {
        this.topicCardDetails = topicCardDetails;
    }

    public String getTopicCardDetails(){
        return this.topicCardDetails;
    }

    private static final Logger logger = LoggerFactory.getLogger(TopicCardDetails.class);

}
