package com.englishtown.util.db.testdbbean;

/**
 * Created by nikol.marku on 02/11/2015.
 */
public class TestRunBean {

    protected int runId;
    protected int testId;
    protected float loadtime;  // <127

    public TestRunBean(int runId, int testId, byte loadtime) {
        this.runId = runId;
        this.testId = testId;
        this.loadtime = loadtime;
    }

    public float getLoadtime() {
        return loadtime;
    }

    public void setLoadtime(float loadtime) {
        this.loadtime = loadtime;
    }

    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    public int getRunId() {
        return runId;
    }

    public void setRunId(int runId) {
        this.runId = runId;
    }

    @Override
    public String toString() {
        return " id: " + this.runId+" testId"+this.testId +" loadTime: " + this.loadtime ;
    }



}
