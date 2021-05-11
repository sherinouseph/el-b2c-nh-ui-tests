package com.englishtown.helpers.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 *
 * Date: 25/11/14
 *
 *
 */
public class Offer {
    private static final Logger logger = LoggerFactory.getLogger(Offer.class);

    protected String pcode;
    protected String offerId;
    protected String currency;
    protected int price;
    protected Date offerStartDate;
    protected Date offerEndDate;

    Offer(String pcode,String offerId,  String currency, int price){
        this.pcode=pcode;
        this.offerId=offerId;
        this.currency=currency;
        this.price=price;
    }
    Offer(String pcode,String offerId,  String currency, int price,Date offerStartDate,  Date offerEndDate){
        this.pcode=pcode;
        this.offerId=offerId;
        this.currency=currency;
        this.price=price;
        this.offerStartDate = offerStartDate;
        this.offerEndDate = offerEndDate;
    }

    Offer(Map offer){
        for(Object key: offer.keySet()) {
            if(key.equals("pcode")){
                this.pcode=offer.get(key).toString();
            }else if(key.equals("offerId")){
                this.offerId=offer.get(key).toString();
            }else if(key.equals("currency")){
                this.currency=offer.get(key).toString();
            }else if(key.equals("price")){
                this.price=Integer.valueOf(offer.get(key).toString());
            }else{
                logger.warn(" Could not find the key on Offer object ... !"+key.toString());
            }

        }

    }


    public String getPcode() {
        return pcode;
    }

    public void setPcode(String pcode) {
        this.pcode = pcode;
    }

    public Date getOfferEndDate() {
        return offerEndDate;
    }

    public void setOfferEndDate(Date offerEndDate) {
        this.offerEndDate = offerEndDate;
    }

    public Date getOfferStartDate() {
        return offerStartDate;
    }

    public void setOfferStartDate(Date offerStartDate) {
        this.offerStartDate = offerStartDate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getOfferId() {
        return offerId;
    }

    public void setOfferId(String offerId) {
        this.offerId = offerId;
    }


}


/**    BAseTest
 //     * Return true if full match[isAllMatch=true] or at least one match if [isAllMatch=false]
 //     *
 //     */
//    public boolean isValueInMap(Map offer, boolean isAllMatch, String ... containsValues){
//        boolean isMatch = false;
//        int matchCount = 0;
//        int failCount  = 0;
//
//        for(Object value : containsValues){
//            if(offer.containsValue(value)){
//                isMatch=true;
//                matchCount++;
//            } else {
//                isMatch=false;
//                failCount++;
//            }
//        }
//        if(isAllMatch) {
//            if(failCount==0){
//                  return true ;
//            }else return false;
//        }else {
//            if(matchCount > 0)
//                return true;
//            else
//                return false;
//        }
//    }






// TEST
//   public static void main(String[] args){
//         Offer offer1 = new Offer(EfConstants.OFFER_30345);
//         Offer offer2 = new Offer(EfConstants.OFFER_30582);
//        logger.info(offer1.toString());
//        logger.info(offer2.toString());   //
//        logger.info(" 1 "+ offer1.isValueInMap(EfConstants.OFFER_30345, false,"30345","AFFTRA2M","GBP", "125" )  );
//        logger.info(" 1 "+ offer1.isValueInMap(EfConstants.OFFER_30345, "AFFTRA2M"));
//        logger.info(" 1 "+ offer1.isValueInMap(EfConstants.OFFER_30345, "GBP"));
//        logger.info(" 1 "+ offer1.isValueInMap(EfConstants.OFFER_30345, "125"));
//   }

