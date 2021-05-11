package com.englishtown.pages.forms;

import com.englishtown.helpers.WebElementHelper;
import com.englishtown.pages.forms.legacy.MemberForm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Create form dynamically with the element that are present/visible
 *
 * e.g. JP checkout test
 */


public class DynamicMembersForm extends MemberForm {

    protected WebElementHelper<MemberForm> age;
    protected WebElementHelper<MemberForm> state;
    protected WebElementHelper<MemberForm> agreeSign;
    protected WebElementHelper<MemberForm> phoneNo;

    //TODO test this if it works
    public DynamicMembersForm(WebDriver webDriver) {
        super(webDriver);
        this.age   = this.createHelper(By.name("AgeRange"));
        this.state = this.createHelper(By.name("State"));
        this.agreeSign = this.createHelper(By.name("AgreeSign"));
        this.phoneNo = this.createHelper(By.name("Telephone"));
    }

    @Override
    protected By getFormLocator() {
        return By.id("memberform");
    }

    public void setAge() {
        this.age = this.createHelper(By.name("AgeRange"));;
    }
    public void setState() {
        this.state = this.createHelper(By.name("State"));
    }
    public void setAgreeSign() {
        this.agreeSign = this.createHelper(By.name("AgreeSign"));
    }
    public void setPhoneNo() {
        this.phoneNo = this.createHelper(By.name("Telephone"));
    }
    public void setAge(WebElementHelper<MemberForm> age) {
        this.age = age;
    }
    public void setState(WebElementHelper<MemberForm> state) {
        this.state = state;
    }
    public void setAgreeSign(WebElementHelper<MemberForm> agreeSign) {
        this.agreeSign = agreeSign;
    }
    public WebElementHelper<MemberForm> getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(WebElementHelper<MemberForm> phoneNo) {
        this.phoneNo = phoneNo;
    }
    public WebElementHelper<MemberForm> getAge() {
        return age;
    }
    public WebElementHelper<MemberForm> getState() {
        return state;
    }
    public WebElementHelper<MemberForm> getAgreeSign() {
        return agreeSign;
    }



}
