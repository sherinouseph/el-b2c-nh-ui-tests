package com.englishtown.util.db.testdbbean;

import com.englishtown.util.db.core.DbManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nikol.marku on 02/11/2015.
 */



public class TestBean {

    protected int id;
    protected String testName;
    protected String url;
    protected String note;
    protected int countryId;
    protected int groupId;

    public TestBean(int id, String testName, String url, String note, int countryId, int groupId) {
        this.id         = id;
        this.testName   = testName;
        this.url        = url;
        this.note       = note;
        this.countryId  = countryId;
        this.groupId    = groupId;
    }
//TODO  - lets do it on DB manager
//    public List<TestBean> getTestBean(){
//        List<TestBean> testBeanList = new ArrayList();
//        DbManager.connectToDB(); //SELECT_TESTS_SQL
//        return testBeanList;
//    }




    public int getId() {
        return id;
    }
    public String getTestName() {
        return testName;
    }
    public void setTestName(String testName) {
        this.testName = testName;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getNote() {
        return note;
    }
    public void setNote(String note) {
        this.note = note;
    }
    public int getCountryId() {
        return countryId;
    }
    public void setCountryId(int groupId) {
        this.groupId = groupId;
    }
    public void setGroupId(int groupId){
        this.groupId = groupId;
    }
    public int getGroupId(){
        return countryId;
    }

    @Override
    public String toString() {
        return " id :"+this.id+"; Url :"+this.url+"; note :"+this.note+"; countryID :"+this.countryId+"; groupId :"+this.groupId;
    }


}
