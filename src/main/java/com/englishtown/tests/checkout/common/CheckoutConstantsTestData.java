package com.englishtown.tests.checkout.common;

import java.util.ArrayList;
import java.util.List;

/**
 * Test data
 */
public class CheckoutConstantsTestData {

    public static final List<MembersData> MEMBERS_PAGE_DATA_LIST ;
    static  {
        MEMBERS_PAGE_DATA_LIST = new ArrayList<MembersData>();
        MEMBERS_PAGE_DATA_LIST.add(new MembersData("23-25", 3, true,"0941023130") ) ;   //JP

    }



}

class MembersData{
    protected String age;
//    protected String state;
    protected String phoneNo;
    protected boolean isAgreeSign = false;
    protected int stateIndex = 3;

    MembersData(String age, int stateIndex, boolean agreeSign, String phoneNo) {
        this.age = age;
        this.stateIndex = stateIndex;
        isAgreeSign = agreeSign;
        this.phoneNo = phoneNo;

    }




}
