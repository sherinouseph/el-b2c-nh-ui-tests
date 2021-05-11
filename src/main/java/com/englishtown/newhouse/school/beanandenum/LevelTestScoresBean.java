package com.englishtown.newhouse.school.beanandenum;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LevelTestScoresBean {

    private static final Logger logger = LoggerFactory.getLogger(LevelTestScoresBean.class);
    protected  String totalScoreLevelTest;
    protected  String grammarScore;
    protected  String vocabularyScore;
    protected  String readingScore;
    protected  String listeningScore;

    public LevelTestScoresBean() {
    }

    public LevelTestScoresBean(String totalScoreLevelTest, String grammarScore, String vocabularyScore, String readingScore, String listeningScore) {
        this.totalScoreLevelTest = totalScoreLevelTest;
        this.grammarScore = grammarScore;
        this.vocabularyScore = vocabularyScore;
        this.readingScore = readingScore;
        this.listeningScore = listeningScore;
    }

    public String getTotalScoreLevelTest() {
        return totalScoreLevelTest;
    }

    public void setTotalScoreLevelTest(String totalScoreLevelTest) {
        this.totalScoreLevelTest = totalScoreLevelTest;
    }

    public String getGrammarScore() {
        return grammarScore;
    }

    public void setGrammarScore(String grammarScore) {
        this.grammarScore = grammarScore;
    }

    public String getVocabularyScore() {
        return vocabularyScore;
    }

    public void setVocabularyScore(String vocabularyScore) {
        this.vocabularyScore = vocabularyScore;
    }

    public String getReadingScore() {
        return readingScore;
    }

    public void setReadingScore(String readingScore) {
        this.readingScore = readingScore;
    }

    public String getListeningScore() {
        return listeningScore;
    }

    public void setListeningScore(String listeningScore) {
        this.listeningScore = listeningScore;
    }
}
