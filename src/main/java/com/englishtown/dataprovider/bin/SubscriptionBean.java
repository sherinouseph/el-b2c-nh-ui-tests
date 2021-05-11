package com.englishtown.dataprovider.bin;

public class SubscriptionBean{

    protected String efid;
    protected String country;
    protected String status; //Active or inactive suspend
    protected boolean cancellationMark;


    public SubscriptionBean(){
        // empty
    }
    public SubscriptionBean(String efid, String country, String status, boolean cancellationMark) {
        this.efid = efid;
        this.country = country;
        this.status = status;
        this.cancellationMark = cancellationMark;
    }

    public String getEfid() {
        return efid;
    }

    public void setEfid(String efid) {
        this.efid = efid;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isCancellationMark() {
        return cancellationMark;
    }

    public void setCancellationMark(boolean cancellationMark) {
        this.cancellationMark = cancellationMark;
    }

}




/**
 *
 curl -X GET --header 'Accept: application/json' 'http://commerce.vagrant.f8/subscription/e3362a7e-5530-4a15-8ff9-6118f6f71ce0'
 {
 "EFId": "e3362a7e-5530-4a15-8ff9-6118f6f71ce0",
 "Country": "GB",
 "Status": "Inactive",
 "CancellationMark": false
 }



 curl -X GET --header 'Accept: application/json' 'http://commerce-api.vagrant.f8/_api/commerce/subscription/Get?EFId=e3362a7e-5530-4a15-8ff9-6118f6f71ce0'
 {
 "Success": true,
 "Result": {
 "EFId": "e3362a7e-5530-4a15-8ff9-6118f6f71ce0",
 "Country": "GB",
 "Status": "Inactive",
 "CancellationMark": false,
 "DateActivated": "0001-01-01T00:00:00",
 "DateDeactivated": "0001-01-01T00:00:00",
 "DateExpires": "0001-01-01T00:00:00",
 "UpdateDate": "0001-01-01T00:00:00",
 "InsertDate": "0001-01-01T00:00:00"
 }
 }

 */