package com.englishtown.pages.component.core.modules;
/**
 * Created by nikol.marku on 11/23/2016.
 * Model a tap item .. e.g in how it works
 *       active tab name and content
 */


public interface ITab {
    String TAB_CSS                = ".tabs";
    String TAB_ITEMS_CSS          = TAB_CSS+" .tab-item";   // list
    String ACTIVE_TAB_ITEM_CSS    = TAB_ITEMS_CSS+".active";
    String ACTIVE_TAB_NAME_CSS    = ACTIVE_TAB_ITEM_CSS+" .caption span";
    String ACTIVE_TAB_CONTENT_CSS = ACTIVE_TAB_ITEM_CSS+" .desc p";  // desc got more and disclaimer


}
