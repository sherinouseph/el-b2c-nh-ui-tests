package com.englishtown.tests.checkout.common;
/**
 *  IGNORE
 */

import com.englishtown.pages.checkout.legacy.MemberPage;
import com.englishtown.pages.forms.DynamicMembersForm;
import org.openqa.selenium.WebDriver;

public class DynamicMemberPageTest extends StandardMemberPageTest {//InteractiveCheckoutPageTest<MemberForm, MemberPage> {

    protected String age;
    protected String state;
    protected String phoneNo;
    protected boolean isAgreeSign = false;
    protected int stateIndex = 3;

    CheckoutConstantsTestData memberData;


    DynamicMemberPageTest( WebDriver webDriver, String testFirstName, String testLastName,
                                      String testPassword, String pageUrl, String age, String state,
                                      String phoneNo, boolean isAgreeSign, int stateIndex, String country) {

        super(webDriver, testFirstName, testLastName, testPassword, pageUrl);
        setCountrySpecificData(country);
         //this.age = age; this.phoneNo = phoneNo; this.state = state;  this.isAgreeSign = isAgreeSign; //        this.stateIndex = stateIndex;
    }


    // use this to contstract the page
    public void setCountrySpecificData ( String country ) {
        switch (country) {
            case "JP":                  //dmpt = new DynamicMemberPageTest(); //( webDriver, testFirstName,testLastName,testPassword,                  pageUrl,  // 0 is for JP
                this.age         = memberData.MEMBERS_PAGE_DATA_LIST.get(0).age;
                this.state       = "";                         //CheckoutConstantsTestData.MEMBERS_PAGE_DATA_LIST.get(0).state,
                this.phoneNo     = memberData.MEMBERS_PAGE_DATA_LIST.get(0).phoneNo ;
                this.isAgreeSign = memberData.MEMBERS_PAGE_DATA_LIST.get(0).isAgreeSign ;
                this.stateIndex  =memberData.MEMBERS_PAGE_DATA_LIST.get(0).stateIndex ;
                break;
            default:
                throw new IllegalArgumentException("Invalid Country..! : " + country);
        }

    }
    // TODO refactor for market      //JP test     DynamicMembersForm
    public DynamicMembersForm createMemberAndReturnMForm(String country) {
        this.createMember(false);                             // base member created  - dont submit
        DynamicMembersForm dmf = new DynamicMembersForm(getWebDriver());       //dmf =dmf.setCountrySpecificData(this.getWebDriver(), dmf,country);
        dmf.getAge().selectValue(this.getAge());                         //("23-25");        dmf.getState().selectIndex(this.stateIndex);  //3
        dmf.getPhoneNo().setTextValue(this.getPhoneNo());                      // jp 0941023130  add this to props         //try {Thread.sleep(3000);} catch(Exception e) {e.printStackTrace();}
        dmf.getState().selectIndex(this.stateIndex)  ;
        if (this.isAgreeSign) {
            dmf.getAgreeSign().click();
            dmf.getAgreeSign().ensureChecked();
        }                  // try {Thread.sleep(3000);} catch(Exception e) {e.printStackTrace();}
        return dmf;
    }



    public String getAge() {
        return age;
    }
    public void setAge(String age) {
        this.age = age;
    }
    public boolean isAgreeSign() {
        return isAgreeSign;
    }
    public void setAgreeSign(boolean agreeSign) {
        isAgreeSign = agreeSign;
    }
    public String getPhoneNo() {
        return phoneNo;
    }
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }

    @Override
    protected MemberPage createPage() {
        return new MemberPage(this.getWebDriver(), this.pageUrl);
    }
}
