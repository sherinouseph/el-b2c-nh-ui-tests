package com.englishtown.enumpack;

/**
 * Classroom status
 * CLASS IS CLOSED
 * CLASS OPENS IN
 * CLASS IS OPEN
 * Your class is booked
 */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum ClassroomStatus {

    OPEN("CLASS OPENS IN"),
    CLOSED("CLASS IS CLOSED"),
    OPEN_IN("CLASS IS OPEN"),
    BOOKED("Your class is booked");

    private final String classroomStatus;

    private ClassroomStatus(String classroomStatus) {
        this.classroomStatus = classroomStatus;
    }

    public String getClassroomStatus(){
        return this.classroomStatus;
    }

    private static final Logger logger = LoggerFactory.getLogger(ClassroomStatus.class);

}
