package com.englishtown.dataprovider.bin;

/**
 * Created by nikol.marku on 3/14/2017.
 * https://jira-bos.englishtown.com/browse/SAND-3711
 */

public class ContentTargetBean {

    private String groupName;
    private boolean isDefault;
    private String ctr;
    private String ipctr; // cookie only
    private String ptn;
    private String etag;
    private String exp;
    private String offerId;
    private String comment;

    public ContentTargetBean() {

    }

    public ContentTargetBean(String groupName, boolean isDefault, String ctr, String ipctr, String ptn, String etag, String exp, String offerId, String comment) {
        this.groupName = groupName;
        this.isDefault = isDefault;
        this.ctr = ctr;
        this.ipctr = ipctr;
        this.ptn = ptn;
        this.etag = etag;
        this.exp = exp;
        this.offerId = offerId;
        this.comment = comment;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public void setDefault(boolean aDefault) {
        isDefault = aDefault;
    }

    public String getCtr() {
        return ctr;
    }

    public void setCtr(String ctr) {
        this.ctr = ctr;
    }

    public String getIpctr() {
        return ipctr;
    }

    public void setIpctr(String ipctr) {
        this.ipctr = ipctr;
    }

    public String getPtn() {
        return ptn;
    }

    public void setPtn(String ptn) {
        this.ptn = ptn;
    }

    public String getEtag() {
        return etag;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }

    public String getOfferId() {
        return offerId;
    }

    public void setOfferId(String offerId) {
        this.offerId = offerId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }





}
