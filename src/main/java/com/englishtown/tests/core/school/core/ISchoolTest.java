package com.englishtown.tests.core.school.core;

public interface ISchoolTest {

    String REGEXP_YYYY_MM_DD = "20[1-9]{2}-[0-9]{2}-[0-9]{2}";
    String REGEXP_MMM_DD_YYYY = "[A-Za-z]{3} [0-9]{2}, [0-9]{4}"; // e.g. "Jan 16, 2021"

    String SCHOOL_LITE_QA = "https://qa.school.englishlive.ef.com/";
}
