package com.englishtown.dataprovider.factory;

import org.testng.annotations.Factory;

/**
 * Created by nikol.marku on 10/25/2016.
 */
public class GeoIPRedirectFactoryImp {


    @Factory
    public Object[] createTest() {
        Object[] res = new Object[3];
        /*res[0] = new FactoryTestClass(2, 2);
        res[1] = new FactoryTestClass(2, 3);
        res[2] = new FactoryTestClass(2, 4);*/

        return res;
    }

}
