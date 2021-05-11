//package com.englishtown.dataprovider.bin;
// // Use CountryBean ...
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
///**
// * Created by nikol.marku on 04/08/2015.
// */
//public class PhoneValidationBean extends UrlBean {
//    private static final Logger logger = LoggerFactory.getLogger(PhoneValidationBean.class);
//
//    private String mobileStartNo;  // first predefined digits +659
//    private String landLineStartNo;
//
//
//    public PhoneValidationBean(String mobileStartNo, String landLineStartNo, String url){
//        super(url);
//        this.mobileStartNo   = mobileStartNo;
//        this.landLineStartNo = landLineStartNo;
//
//    }
//
//    public void print(){
//        super.print();
//        if(this != null){
//            logger.info("mobileStartNo   :"+this.getMobileStartNo());
//            logger.info("landLineStartNo :"+this.getLandLineStartNo());
//            logger.info("*******************n***********************");
//        }
//    }
//
//    public String getMobileStartNo() {
//        return mobileStartNo;
//    }
//
//    public void setMobileStartNo(String mobileStartNo) {
//        this.mobileStartNo = mobileStartNo;
//    }
//
//    public String getLandLineStartNo() {
//        return landLineStartNo;
//    }
//
//    public void setLandLineStartNo(String landLineStartNo) {
//        this.landLineStartNo = landLineStartNo;
//    }
//}
