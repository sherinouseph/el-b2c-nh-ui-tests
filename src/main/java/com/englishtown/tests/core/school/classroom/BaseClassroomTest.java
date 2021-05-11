package com.englishtown.tests.core.school.classroom;
/**
 * Login an existing user and
 * User: nikol.marku
 * Date: 05/02/18
 *
 *
 */
import com.englishtown.tests.core.school.BaseSchoolHomePageTest;
import com.englishtown.tests.core.school.BaseSimpleLogin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public abstract class BaseClassroomTest extends BaseSimpleLogin {
    private static final Logger logger = LoggerFactory.getLogger(BaseClassroomTest.class);

    protected int selectTopicIndex    = 0;
    protected int selectTimeSlotIndex = 0;


}
