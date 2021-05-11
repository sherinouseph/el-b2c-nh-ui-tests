package com.englishtown.newhouse.school.beanandenum;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum StudyGoals {

    GOAL_1_2(0,"1-2"),
    GOAL_3_5(1,"3-5"),
    GOAL_5_PLUS(2,"5+"),
    GOAL(3,"I will Study");


    private static final Logger logger = LoggerFactory.getLogger(StudyGoals.class);


    private final int goalHoursIndex;
    private String goalhours;

    StudyGoals(int goalHoursIndex,String goalhours) {

        this.goalHoursIndex = goalHoursIndex;
        this.goalhours=goalhours;

    }

    public int getGoalHoursIndex(){

        return goalHoursIndex;
    }

    public String getGoalHours(){

        return goalhours;
    }

}









