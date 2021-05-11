package com.englishtown.newhouse.apicore.dataprovider;
/**
 * Created by nikol.marku on 12/12/2017.
 * Data provider for all API test
 */

import com.englishtown.dataprovider.BaseDataProvider;
import com.englishtown.enumpack.CardType;

import com.englishtown.enumpack.TestCard;
import org.testng.annotations.DataProvider;

import java.util.EnumSet;
import java.util.concurrent.atomic.AtomicInteger;


public abstract class ApiDataProvider extends BaseDataProvider{

    static AtomicInteger id = new AtomicInteger(0);
    /**
     * Return all test card
     * @return
     */
    @DataProvider(name = "allTestCards", parallel = true)
    public static Object[][] rolaTopCountries() {
        return new Object[][] {
                {TestCard.MASTERCARD_1},
                {TestCard.MASTERCARD_2},
                {TestCard.AMEX},
                {TestCard.VISA_QA},
                {TestCard.DINE},
                {TestCard.DISCOVER},
                {TestCard.JCB},                                        //{TestCard.LASER},
                {TestCard.MAESTRO_INT_1},
                {TestCard.MAESTRO_INT_2},
                {TestCard.MAESTRO_UKDOM},
                {TestCard.MAESTRO_UKDOM_1DIGITREQ},
                {TestCard.MAESTRO_UKDOM_2DIGITREQ},                //{TestCard.SOLO_1ISSUENUM},                {TestCard.SOLO_2ISSUENUM},                {TestCard.SOLO_NOISSUENUM},                {TestCard.UATP}
        };
    }

    @DataProvider(name = "apiHealthMonitorUrls")//, parallel = true)
    public static Object[][] apiMonitorUrls() {
        return new Object[][] {
                ///{id.getAndIncrement(),  new String("http://commerce.vagrant.f8/api/health")},
                {id.getAndIncrement(),  new String("/api/commerce-api/api/health")},
                ///{id.getAndIncrement(),  new String("http://campus-enrollment.vagrant.f8/health")},
               // {id.getAndIncrement(),  new String("http://campus-enrollment.ui.vagrant.f8/health")},
                ///{id.getAndIncrement(),  new String("http://school-gateway.vagrant.f8/health")},
                //{id.getAndIncrement(),  new String("http://payment.vagrant.f8/api/health")},
                /*{id.getAndIncrement(), ""},
                {id.getAndIncrement(), ""},
                {id.getAndIncrement(), ""},
                {id.getAndIncrement(), ""},*/

        };
    }
}

