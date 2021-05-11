package com.englishtown.newhouse.school.beanandenum.bean;
/**
 * Nikol Apr 2018
 *
 * All translation test data configuration
 * For all languages or at least 2
 * EN and PT
 *
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;


public abstract class TranslationDataBeanConfig {
    private static final Logger logger = LoggerFactory.getLogger(TranslationDataBeanConfig.class);

    // HEADER
    //Java ArrayList class maintains insertion order.
    protected static final List<String> HEADER_MAIN_MENU_EN = new ArrayList<String>();
    static{
        HEADER_MAIN_MENU_EN.add("Course");
        HEADER_MAIN_MENU_EN.add("Classroom");
        HEADER_MAIN_MENU_EN.add("Friends");
        HEADER_MAIN_MENU_EN.add("Support");
    }

    protected static final List<String> HEADER_MAIN_MENU_TR = new ArrayList<String>();
    static{
        HEADER_MAIN_MENU_TR.add("Kurs");
        HEADER_MAIN_MENU_TR.add("Sınıf");
        HEADER_MAIN_MENU_TR.add("Friends");
        HEADER_MAIN_MENU_TR.add("Support");
    }

    protected static final List<String> HEADER_MAIN_MENU_PT = new ArrayList<String>();
    static{
        HEADER_MAIN_MENU_PT.add("Curso");
        HEADER_MAIN_MENU_PT.add("Sala de aula");
        HEADER_MAIN_MENU_PT.add("Friends");
        HEADER_MAIN_MENU_PT.add("Suporte");
    }
    //FOOTER
    protected static final List<String> FOOTER_MAIN_MENU_PT = new ArrayList<String>();
    static{
        FOOTER_MAIN_MENU_PT.add("FALE CONOSCO");
        FOOTER_MAIN_MENU_PT.add("Intercâmbios EF");
        FOOTER_MAIN_MENU_PT.add("Central de Ajuda");
    }
    protected static final List<String> FOOTER_MAIN_MENU_EN = new ArrayList<String>();
    static{
        FOOTER_MAIN_MENU_EN.add("All EF Programs");
        FOOTER_MAIN_MENU_EN.add("Help center");
        FOOTER_MAIN_MENU_EN.add("Privacy Policy");
    }

    protected static final List<String> FOOTER_MAIN_MENU_TR= new ArrayList<String>();
    static{
        FOOTER_MAIN_MENU_TR.add("Tüm EF programları");
        FOOTER_MAIN_MENU_TR.add("Kişisel yardım merkezi");
        FOOTER_MAIN_MENU_TR.add("Gizlilik Politikası");
    }

    // content
    protected static final String MYPAGE_CURRENT_LEVEL_EN = "1-Beginner";
    protected static final String MYPAGE_CURRENT_LEVEL_TR = "1-Beginner";
    protected static final String MYPAGE_CURRENT_LEVEL_PT = "1-Iniciante";
    protected static final String MYPAGE_BOOKPL_MSG_EN    = "Book a private class with your teacher";
    protected static final String MYPAGE_BOOKPL_MSG_TR    = "Öğretmeninizle bir özel ders rezervasyonu yapın";
    protected static final String MYPAGE_BOOKPL_MSG_PT    = "Agende uma aula particular com seu professor";

    protected static final String COURSE_PAGE_LESSON_HEADING_EN = "INTRODUCING YOURSELF";  //
    protected static final String COURSE_PAGE_LESSON_HEADING_TR = "KENDINI TANITMA";  //
    protected static final String COURSE_PAGE_LESSON_HEADING_PT = "APRESENTANDO-SE";       // Introduction

    protected static final String BOOK_PL_PAGE_HEADING_EN = "PRIVATE CLASS BOOKING";        //PRIVATE CLASS BOOKING
    protected static final String BOOK_PL_PAGE_HEADING_TR = "ÖZEL DERS REZERVASYONU YAPMA";        //PRIVATE CLASS BOOKING
    protected static final String BOOK_PL_PAGE_HEADING_PT = "AGENDAMENTO DE AULA PARTICULAR";

    protected static final String TRANSLATOR_PAGE_FROM_LANG_EN = "English";    //Da:  Inglese      a:  Inglese
    protected static final String TRANSLATOR_PAGE_FROM_LANG_TR = "Türkçe";    //Da:  Inglese      a:  Inglese
    protected static final String TRANSLATOR_PAGE_FROM_LANG_PT = "Inglês";    //Da:  Inglese      a:  Inglese
    protected static final String TRANSLATOR_PAGE_TO_LANG_EN   = "English";    //Da:  Inglese      a:  Inglese
    protected static final String TRANSLATOR_PAGE_TO_LANG_TR   = "Türkçe";    //Da:  Inglese      a:  Inglese
    protected static final String TRANSLATOR_PAGE_TO_LANG_PT   = "Inglês";    //Da:  Inglese      a:  Inglese



}
