package com.englishtown.helpers.bean;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nikol.marku on 04/08/2015.
 */
public class OfferFeature extends BaseOffer{
    private static final Logger logger = LoggerFactory.getLogger(OfferFeature.class);

    protected String offerFeaturesListCss = ".icon-ok~span"; // gb
    protected String offerPriceWithDiscountCss = "#rightCol_offer_header-parsys_spacer-3 p>b"; // gb gets elements {30 days trial offer:[  and    [£1] }
    protected String offerPriceNoDiscountCss   = ".offer-component p>span>span"; //   [£1]
    protected String priceFirstMonth;   // after the discount first pay
    protected String privateClasses ;   // PL
    protected String groupClasses;      // GL
    protected List<String> expectedOfferFeatureList;   //privateClasses + groupClasses
    protected String market;                 // e.g 'it-it' en-gb de-wws etc englishlive.ef.com/+market+/buy/default/member/?offerid=
    protected String currency;               // $ £ E  , TR -> TL
    protected boolean isNoDiscountOffer;     // if offer appears like e.g  49 -48 = 1 then this is false
    protected int numberOfFeatures;          // pls, gls, toefl ..etc


    public OfferFeature(int id, String market, String currency, String priceFirstMonth, String privateClasses,
                        String groupClasses, String description, boolean isNoDiscountOffer,String offerPriceWithDiscountCss, String offerPriceNoDiscountCss ){
        super(id, description);
        this.market          = market;
        this.currency        = currency;
        this.priceFirstMonth = priceFirstMonth;
        this.privateClasses  = privateClasses;
        this.groupClasses    = groupClasses;
        this.isNoDiscountOffer = isNoDiscountOffer;
        expectedOfferFeatureList = new ArrayList<>();
        expectedOfferFeatureList.add(privateClasses);
        expectedOfferFeatureList.add(groupClasses);
        if(!StringUtils.isBlank(offerPriceNoDiscountCss))
            this.offerPriceNoDiscountCss=offerPriceNoDiscountCss;
        if(!StringUtils.isBlank(offerPriceWithDiscountCss))
            this.offerPriceWithDiscountCss=offerPriceWithDiscountCss;
    }

    public OfferFeature(int id, String market, String currency, String priceFirstMonth, String privateClasses,
                        String groupClasses, String description, boolean isNoDiscountOffer,String offerPriceWithDiscountCss, String offerPriceNoDiscountCss, int numberOfFeatures ){
        super(id, description);
        this.market          = market;
        this.currency        = currency;
        this.priceFirstMonth = priceFirstMonth;
        this.privateClasses  = privateClasses;
        this.groupClasses    = groupClasses;
        this.isNoDiscountOffer = isNoDiscountOffer;
        this.numberOfFeatures  = numberOfFeatures;
        expectedOfferFeatureList = new ArrayList<>();
        expectedOfferFeatureList.add(privateClasses);
        expectedOfferFeatureList.add(groupClasses);
        if(!StringUtils.isBlank(offerPriceNoDiscountCss))
            this.offerPriceNoDiscountCss=offerPriceNoDiscountCss;
        if(!StringUtils.isBlank(offerPriceWithDiscountCss))
            this.offerPriceWithDiscountCss=offerPriceWithDiscountCss;
    }

    public void print(){
        super.print();
        if(this != null){
            logger.info("offerFeaturesListCss      :"+this.getOfferFeaturesListCss());
            logger.info("offerPriceWithDiscountCss :"+this.getOfferPriceWithDiscountCss());
            logger.info("offerPriceNoDiscountCss   :"+this.getOfferPriceNoDiscountCss());
            logger.info("priceFirstMonth       :"+this.getPriceFirstMonth());
            logger.info("market                :"+this.getMarket());
            logger.info("currency              :"+this.getCurrency());
            logger.info("privateClasses        :"+this.getPrivateClasses());
            logger.info("groupClasses          :"+this.getGroupClasses());
            logger.info("expectedOfferFeatureList  :"+expectedOfferFeatureList);
            logger.info("numberOfFeatures  :"+numberOfFeatures);
            logger.info("*******************n***********************");
        }
    }

    

    public String getOfferFeaturesListCss() {
        return offerFeaturesListCss;
    }

    public void setOfferFeaturesListCss(String offerFeaturesListCss) {
        this.offerFeaturesListCss = offerFeaturesListCss;
    }

    public String getOfferPriceWithDiscountCss() {
        return offerPriceWithDiscountCss;
    }

    public void setOfferPriceWithDiscountCss(String offerPriceWithDiscountCss) {
        this.offerPriceWithDiscountCss = offerPriceWithDiscountCss;
    }

    public String getPriceFirstMonth() {
        return priceFirstMonth;
    }

    public void setPriceFirstMonth(String priceFirstMonth) {
        this.priceFirstMonth = priceFirstMonth;
    }

    public String getPrivateClasses() {
        return privateClasses;
    }

    public void setPrivateClasses(String privateClasses) {
        this.privateClasses = privateClasses;
    }

    public String getGroupClasses() {
        return groupClasses;
    }

    public void setGroupClasses(String groupClasses) {
        this.groupClasses = groupClasses;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public List<String> getExpectedOfferFeatureList() {
        return expectedOfferFeatureList;
    }

    public String getOfferPriceNoDiscountCss() {
        return offerPriceNoDiscountCss;
    }

    public void setOfferPriceNoDiscountCss(String offerPriceNoDiscountCss) {
        this.offerPriceNoDiscountCss = offerPriceNoDiscountCss;
    }

    public boolean isNoDiscountOffer() {
        return isNoDiscountOffer;
    }

    public void setNoDiscountOffer(boolean noDiscountOffer) {
        isNoDiscountOffer = noDiscountOffer;
    }


    public int getNumberOfFeatures() {
        return numberOfFeatures;
    }

    public void setNumberOfFeatures(int numberOfFeatures) {
        this.numberOfFeatures = numberOfFeatures;
    }


}
