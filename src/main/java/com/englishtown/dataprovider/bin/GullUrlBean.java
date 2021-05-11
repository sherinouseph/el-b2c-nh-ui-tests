package com.englishtown.dataprovider.bin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by nikol.marku on 04/08/2015.
 */
public class GullUrlBean extends UrlBean {
    private static final Logger logger = LoggerFactory.getLogger(GullUrlBean.class);

    private boolean isGulf;

    public GullUrlBean(){

    }


    public GullUrlBean(String url, boolean isGulf){
        super(url);
        this.isGulf = isGulf;
    }

    public void print(){
        super.print();
        if(this != null){
            logger.info("isGulf       :"+this.isGulf());
            logger.info("*******************n***********************");
        }
    }

    public boolean isGulf() {
        return isGulf;
    }

    public void setGulf(boolean gulf) {
        isGulf = gulf;
    }
}
