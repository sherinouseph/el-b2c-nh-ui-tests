package com.englishtown.util.db.testdbbean;

import java.util.Date;

/**
 * Created by nikol.marku on 02/11/2015.
 */
public class RunBean {

    protected int id;
    protected Date testRunDate;
    protected String note;

    public RunBean(int id, Date testRunDate, String note) {
        this.id = id;
        this.testRunDate = testRunDate;
        this.note = note;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getTestRunDate() {
        return testRunDate;
    }

    public void setTestRunDate(Date testRunDate) {
        this.testRunDate = testRunDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return " id: " + this.id + " testRunDate: " + this.testRunDate + " note: " + this.note;
    }

}
