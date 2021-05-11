package com.englishtown.newhouse.salesforce.enumpack;

/**
 On QA, I’ve setup the test products for the New Payment Flow:
 For EMEA countries, the product name is: “EU PT 52 12m”
 For Taiwan, the product name is: “23388 (6888) 12M120GL12PL”
 These same products (with same name) exists also on LIVE.
 I’ll work on the ones for MX/ROLA/US after I come back from holiday.
 Regards,
 Minlin

 */
public enum Product {
    DEFAULT("--None--"),
    EMEA("EU PT 52 12m"),
    TAIWAN("23388 (6888) 12M120GL12PL");



    String productName;

    Product(String productName){
        this.productName = productName;
    }

    public String getProductName(){
        return productName;
    }

}
