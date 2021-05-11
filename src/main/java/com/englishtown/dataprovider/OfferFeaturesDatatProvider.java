package com.englishtown.dataprovider;

import com.englishtown.helpers.bean.OfferFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;

/**
 * Created by nikol.marku on 26-Jul-17.
 *
 *
 */
public class OfferFeaturesDatatProvider extends BaseDataProvider{

    private static final Logger logger = LoggerFactory.getLogger(OfferFeaturesDatatProvider.class);


    @DataProvider(name = "getOfferFeature")//, parallel = true)
    public static Object[][] getOfferFeatureObj() {
        return new Object[][]{
                //(                           id,    market, currency, priceFirstMonth, privateClasses,      groupClasses,       description,   isNoDiscountOffer, withDiscountCss, noDiscoutCss
               /* new Object[]{new OfferFeature(29183, "en-gb", "£","1"," ", "30 group classes per month", "description", false, "","")}, // default
                new Object[]{new OfferFeature(30582, "en-gb", "£","19"," ","2 group classes",  "description", true, "", "")},
                new Object[]{new OfferFeature(30999, "en-gb", "£","79","3 Private teacher-led classes",  "30 group classes", "description", false,"", "")},
                 new Object[]{new OfferFeature(30999, "en-gb", "£", "79", "3 Private teacher-led classes", "30 group classes", "description", false, "", "")},
               */
                new Object[]{new OfferFeature(29894, "de-de", "€", "19"," ", "2 Gruppenstunden im Monat",  "description",true, "", ".offer-component p span")},
                new Object[]{new OfferFeature(29877, "de-de", "€", "79","3 Privatstunden",  "30 Gruppenstunden im Monat","description",true, "", ".offer-component p span")},
                //
                //new Object[]{new OfferFeature(30675, "it-it", "€", "79", "3 lezioni private", "30 classi di conversazione di gruppo ogni mese", "description", true, "", ".header-parsys.parsys span.small")},
                new Object[]{new OfferFeature(29877, "de-de", "€", "79", "3 Privatstunden", "30 Gruppenstunden im Monat", "description", true, "", ".offer-component p span")},
                //new Object[]{new OfferFeature(31338, "fr-fr", "€", "59", "1 cours particulier / semaine", "5 cours collectifs / semaine", "description", true, "", ".offer-component p span.small")},
                //new Object[]{new OfferFeature(31361, "tr-tr", "TL", "239", "3 Özel ders", "30 Grup dersi", "description", true, "", ".offer-component p span.small")},

                new Object[]{new OfferFeature(29658, "ar-sa", "$", "79", "1 درس خاص مع مدرس مختص باللغة الإنجليزية", "1 فصل محادثة جماعية مع مدرس", "description", false, ".offer-component p span", "")},
                //*********
                // only return offer new Object[]{new OfferFeature(31304, "en-gb", '£',     "139",           "2 Private teacher-led classes",  "30 group classes", "description", false)},
        };
    }

    /**
     * New house
     *
     */
    @DataProvider(name = "getOfferFeatureNewHouse")
    public static Object[][] getOfferFeatureNewHouseObj() {
        return new Object[][]{
                //( id,    market, currency, priceFirstMonth, privateClasses,      groupClasses,       description,   isNoDiscountOffer, withDiscountCss, noDiscoutCss
                new Object[]{new OfferFeature(29183, "en-gb", "£", "49", "none", "30", "£49 per month after", false, "", "")},
                //new Object[]{new OfferFeature(30582, "en-gb", "£", "19", "none", "2", "No minimum", false, "", "")},
                //new Object[]{new OfferFeature(30999, "en-gb", "£", "79", "3", "30", "your", false, "", "")},
                new Object[]{new OfferFeature(31618, "it-it", "€", "29", "none", "10", "€29 al mese", false, "", "")},
                // TODO css not the same for TR ...
                //new Object[]{new OfferFeature(32044, "tr-tr", "TL", "99", "none", "none", "aylık 99TL", false, "", "")},
        };
    }




}
