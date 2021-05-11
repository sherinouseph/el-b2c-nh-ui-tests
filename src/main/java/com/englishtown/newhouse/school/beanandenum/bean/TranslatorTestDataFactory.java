package com.englishtown.newhouse.school.beanandenum.bean;
/**
 * Nikol Apr 2018
 *
 * Create test data for different languages
 *
 */
import com.englishtown.enumpack.Language;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class TranslatorTestDataFactory extends TranslationTestDataBean {
    private static final Logger logger = LoggerFactory.getLogger(TranslationTestDataBean.class);


    public TranslatorTestDataFactory(Language language) {
        super(language);

        switch (language){
            case EN:
                logger.info("Create EN test data ...!");
                this.setHeaderMainMenu(HEADER_MAIN_MENU_EN);
                this.setFooterMainMenu(FOOTER_MAIN_MENU_EN);
                this.setMyPageCurrentLevel(MYPAGE_CURRENT_LEVEL_EN);
                this.setMyPageBookPLmsg(MYPAGE_BOOKPL_MSG_EN);
                this.setCoursePageLessonHeading(COURSE_PAGE_LESSON_HEADING_EN);
                this.setBookPlHeading(BOOK_PL_PAGE_HEADING_EN);
                this.setTranslatorPageFromLang(TRANSLATOR_PAGE_FROM_LANG_EN);
                this.setTranslatorPageToLang(TRANSLATOR_PAGE_TO_LANG_EN);
                break;

            case TR:
                logger.info("Create EN test data ...!");
                this.setHeaderMainMenu(HEADER_MAIN_MENU_TR);
                this.setFooterMainMenu(FOOTER_MAIN_MENU_TR);
                this.setMyPageCurrentLevel(MYPAGE_CURRENT_LEVEL_TR);
                this.setMyPageBookPLmsg(MYPAGE_BOOKPL_MSG_TR);
                this.setCoursePageLessonHeading(COURSE_PAGE_LESSON_HEADING_TR);
                this.setBookPlHeading(BOOK_PL_PAGE_HEADING_TR);
                this.setTranslatorPageFromLang(TRANSLATOR_PAGE_FROM_LANG_TR);
                this.setTranslatorPageToLang(TRANSLATOR_PAGE_TO_LANG_TR);
                break;

            case PT:
                logger.info("Create PT test data ...!");
                this.setHeaderMainMenu(HEADER_MAIN_MENU_PT);
                this.setFooterMainMenu(FOOTER_MAIN_MENU_PT);
                this.setMyPageCurrentLevel(MYPAGE_CURRENT_LEVEL_PT);
                this.setMyPageBookPLmsg(MYPAGE_BOOKPL_MSG_PT);
                this.setCoursePageLessonHeading(COURSE_PAGE_LESSON_HEADING_PT);
                this.setBookPlHeading(BOOK_PL_PAGE_HEADING_PT);
                this.setTranslatorPageFromLang(TRANSLATOR_PAGE_FROM_LANG_PT);
                this.setTranslatorPageToLang(TRANSLATOR_PAGE_TO_LANG_PT);
                break;

            default: logger.error("Can not get test translation data");
                throw new IllegalArgumentException("Can not get test translation data ...!");
        }
        logger.info(this.toString());

    }
}
