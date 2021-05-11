package com.englishlive.tests.newhouse.dispatcher.dataprovider;

import org.testng.annotations.DataProvider;

public class DispatcherTestDataProvider {


    @DataProvider(name = "dispacherOhToNh", parallel = true)
    public static Object[][] dispacherOhToNh() {
        // username state
        return new Object[][]{
                {"auto_143237518577000_zqk792_xdelx@qp1.org", "LoginNH"},
                {"auto_gb_1682397015430000_pho136_xdelx@qp1.org", "Reregister"},
                {"auto_de_6003401649208800_KMD586_xdelx@qp1.org", "LoginOH"},
                {"molly-olly-bolly@qp1.org", "LoginOH"},
                {"nzb2c@qp1.org", "LoginNH"},
                {"auto_gb_88064704597600_gtk127_xdelx@qp1.org", "LoginNH"},
                {"noexist1_negtest_xdelx@niko.org", "NotExist"},
        };
    }


}
