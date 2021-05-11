//package com.englishtown.enumpack;
///**
// *  Nikol 2019
// *
// *  Capture Privacy setting on your account page OH
// *
// *  Capture setting id and Text name. Id is used to get the element in account page list
// *
// * PRIVACY_SETTING_ITEMS = {"Promote my profile", "List my profile",
// *             "Display profile status online", "My profile viewable by everyone", "My updates viewable by everyone",
// *             "My photo viewable by everyone", "My live chat accessibility by everyone"};
// */
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//public enum PrivacySettingMyAccountPage {
//         // ID | NAME
//    PROMOTE_PROFILE(0,"Promote my profile"),
//    LIST_PROFILE(1,"List my profile"),
//    DISPLAY_PROFILE_STATUS(2,"Display profile status online"),
//    PROFILE_VIEWABLE_BY_EVERYONE(3,"My profile viewable by everyone"),
//    UPDATES_VIEWABLE_BY_EVERYONE(4,"My updates viewable by everyone"),
//    PHOTOS_VIEWABLE_BY_EVERYONE(5,"My photo viewable by everyone"),
//    LIVECHAT_ACCESSIBLE_BY_EVERYONE(6,"My live chat accessibility by everyone");
//
//
//    private final int id;
//    private final String name;
//
//
//    public int getId() {
//        return id;
//    }
//
//    public String getCode() {
//        return name;
//    }
//
//    PrivacySettingMyAccountPage(int id, String code){
//        this.id = id;
//        this.name = code;
//    }
//
//    private static final Logger logger = LoggerFactory.getLogger(PrivacySettingMyAccountPage.class);
//
//}
