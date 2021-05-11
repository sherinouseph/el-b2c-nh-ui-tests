package com.englishtown.newhouse.school.beanandenum.bean;
/**
 * Nikol Apr 2018
 *
 * All translation test should use this to do the testing of school page language
 *
 */

import com.englishtown.enumpack.Language;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


public abstract class TranslationTestDataBean extends TranslationDataBeanConfig{
    private static final Logger logger = LoggerFactory.getLogger(TranslationTestDataBean.class);


    protected Language language;            // user language
    // header and footer
    protected List<String> headerMainMenu;  //new ArrayList<String>();
    protected List<String> footerMainMenu;
    // content
    protected String myPageCurrentLevel;
    protected String myPageBookPLmsg;
    protected String coursePageLessonHeading;  // Introduction
    protected String bookPlHeading;             //PRIVATE CLASS BOOKING
    protected String translatorPageFromLang;    //Da:  Inglese      a:  Inglese
    protected String translatorPageToLang;      //  a:  Inglese


    public TranslationTestDataBean( ) {

    }

    public TranslationTestDataBean(Language language) {
        this.language = language;
    }

    public TranslationTestDataBean(Language language, List<String> headerMainMenu, List<String> footerMainMenu,
                                   String myPageCurrentLevel, String myPageBookPLmsg, String coursePageLessonHeading,
                                   String bookPlHeading, String translatorPageFromLang, String translatorPageToLang) {
        this.language = language;
        this.headerMainMenu = headerMainMenu;
        this.footerMainMenu = footerMainMenu;
        this.myPageCurrentLevel = myPageCurrentLevel;
        this.myPageBookPLmsg = myPageBookPLmsg;
        this.coursePageLessonHeading = coursePageLessonHeading;
        this.bookPlHeading = bookPlHeading;
        this.translatorPageFromLang = translatorPageFromLang;
        this.translatorPageToLang = translatorPageToLang;
    }

    @Override
    public String toString() {
        return  "\n$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$\n"+
                "TranslationTestDataBean{" +
                " \nlanguage=" + language +
                ", \nheaderMainMenu=" + headerMainMenu +
                ", footerMainMenu=" + footerMainMenu +
                ", \nmyPageCurrentLevel='" + myPageCurrentLevel + '\'' +
                ", \nmyPageBookPLmsg='" + myPageBookPLmsg + '\'' +
                ", \ncoursePageLessonHeading='" + coursePageLessonHeading + '\'' +
                ", \nbookPlHeading='" + bookPlHeading + '\'' +
                ", \ntranslatorPageFromLang='" + translatorPageFromLang + '\'' +
                ", \ntranslatorPageToLang='" + translatorPageToLang + '\'' +
                '}'+ "\n$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$\n";
    }

    // Setter and getter
    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public List<String> getHeaderMainMenu() {
        return headerMainMenu;
    }

    public void setHeaderMainMenu(List<String> headerMainMenu) {
        this.headerMainMenu = headerMainMenu;
    }

    public List<String> getFooterMainMenu() {
        return footerMainMenu;
    }

    public void setFooterMainMenu(List<String> footerMainMenu) {
        this.footerMainMenu = footerMainMenu;
    }

    public String getMyPageCurrentLevel() {
        return myPageCurrentLevel;
    }

    public void setMyPageCurrentLevel(String myPageCurrentLevel) {
        this.myPageCurrentLevel = myPageCurrentLevel;
    }

    public String getMyPageBookPLmsg() {
        return myPageBookPLmsg;
    }

    public void setMyPageBookPLmsg(String myPageBookPLmsg) {
        this.myPageBookPLmsg = myPageBookPLmsg;
    }

    public String getCoursePageLessonHeading() {
        return coursePageLessonHeading;
    }

    public void setCoursePageLessonHeading(String coursePageLessonHeading) {
        this.coursePageLessonHeading = coursePageLessonHeading;
    }

    public String getBookPlHeading() {
        return bookPlHeading;
    }

    public void setBookPlHeading(String bookPlHeading) {
        this.bookPlHeading = bookPlHeading;
    }

    public String getTranslatorPageFromLang() {
        return translatorPageFromLang;
    }

    public void setTranslatorPageFromLang(String translatorPageFromLang) {
        this.translatorPageFromLang = translatorPageFromLang;
    }

    public String getTranslatorPageToLang() {
        return translatorPageToLang;
    }

    public void setTranslatorPageToLang(String translatorPageToLang) {
        this.translatorPageToLang = translatorPageToLang;
    }


}
