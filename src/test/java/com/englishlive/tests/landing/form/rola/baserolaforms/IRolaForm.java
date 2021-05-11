package com.englishlive.tests.landing.form.rola.baserolaforms;

/**
 * Created by nikol.marku on 13/11/2015.
 */
public interface IRolaForm {
    String COUNTRY_CSS    = "select[name=country]";   // name ID ... selector
    String DEPT_SELECT    = "select[name=location-state]"; // id name
    String CITY_CSS       = "select[name=location-city]";
    String TEL_CSS        = "input[name=telephone]";
    String PHONE_TYPE_RADIO_BTNS = ".control-group-telephone-type input";  //CSS
    String PHONE_TYPE_SELECT_CSS        = "select[name=telephone-type]";  //CSS name
    String PHONE_TYPE_SELECT_OPTION_CSS = "select[name=telephone-type] option";
    String DEFAULT_PHONE_TYPE_VALUE = "Móvil";
    String PHONE_TYPE_VALUE_HOME     = "Fijo"; //landline
    String MOBILE_PHONE_TYPE_VALUE_EN = "mobile";
    String LANDLINE_TYPE_VALUE_EN     = "landline"; //landline
    String[] CL_DEP_LIST_VALUES   = {"ohiggins", "biobio", "valparaiso", "antofagasta", "los-rios","maule", "tarapaca"}; // NOTE this is not the full list
    String[] CL_CITY_LIST_VALUES  = {"cachapoal", "cardenal-caro", "colchagua", "rancagua"};                              //<option value="cachapoal">Cachapoal</option>

    String[] AR_DEP_LIST_VALUES   = {"buenos-aires", "cordoba", "los-formosa", "tucuman"};
    String[] AR_CITY_LIST_VALUES  = {"abasto", "alberti", "zelaya"};

    String[] CO_DEP_LIST_VALUES   = {"bogota", "santander", "vichada"}; // ONLY FEW
    String[] PE_DEP_LIST_VALUES   = {"piura", "loreto", "ucayali"}; // ONLY FEW

    // FAILS MSGs
    String FAIL_MSG_DEPT_SHOULD_NOT_SHOW = "Form Element Department Should NOT be shown on this form...!!!";                                // err shown if dept is shown and it should not
    String FAIL_MSG_DEPT_SHOULD_SHOW     = "Form Element Department Should Be shown on this form...!!!";
    String FAIL_MSG_CITY_SHOULD_NOT_SHOW = "Form Element CITY Should NOT be shown on this form...!!!";                                // err shown if dept is shown and it should not
    String FAIL_MSG_CITY_SHOULD_SHOW     = "Form Element CITY Should Be shown on this form...!!!";

    // phone
    String CR_PHONE_INVALID_MSG    = "Por favor ingresa ";
    String CR_VALID_MOBILE_PHONE   = "77777777";
    String CR_INVALID_MOBILE_PHONE = "5654-3453";
    String CR_INVALID_HOME_PHONE   = "22222222";

    String CL_VALID_HOME_PHONE     = "333333";
    String CL_INVALID_HOME_PHONE   = "88888888";

}
