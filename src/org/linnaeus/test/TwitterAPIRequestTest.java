package org.linnaeus.test;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.linnaeus.server.bean.Advice;
import org.linnaeus.server.bean.AdviceRequest;
import org.linnaeus.server.bean.SearchCircle;
import org.linnaeus.server.bean.Trend;
import org.linnaeus.server.manager.AdviceManager;
import org.linnaeus.server.manager.NativeRequestManager;
import org.linnaeus.server.manager.RequestManager;
import org.linnaeus.server.manager.TrendManager;

import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: Romchee
 * Date: 22/07/11
 * Time: 12:49
 * To change this template use File | Settings | File Templates.
 */
public class TwitterAPIRequestTest extends TestCase {

    private final int TEST_LAT = 56851117;
    private final int TEST_LNG = 14831659;
    private final int TEST_RAD = 2000000;
    private final String TEST_ADVICE_REQUEST_VALUE = "iphone";
    private final String TEST_ADVICE_TYPE_INFO = "info";
    private final String TEST_ADVICE_TYPE_PLACES = "places";

    private SearchCircle searchCircle;
    private NativeRequestManager nativeRequestManager;
    private RequestManager requestManager;

    @Before
    public void setUp(){
        nativeRequestManager = NativeRequestManager.getInstance();
        requestManager = RequestManager.getInstance();
        searchCircle = new SearchCircle(TEST_LAT, TEST_LNG, TEST_RAD);
    }

    /*@Ignore
    @Test
    public void testNativeSearchRequest(){
        String result = nativeRequestManager.requestTweetsBySearchCircle(searchCircle);
        assertNotNull(result);
        System.out.println(result);
    }

    @Ignore
    @Test
    public void testSearchRequest(){
        List<Tweet> tweets = requestManager.getTweetsBySearchCircle(searchCircle);
        assertNotNull(tweets);
        System.out.print(tweets);
    }*/

    @Test
    public void testTrendManager(){
        ArrayList<Trend> trends = TrendManager.getInstance().acquireTrends(searchCircle);
        assertNotNull(trends);
        System.out.print(trends);
    }

    @Test
    public void testAdviceFunctionality(){
        ArrayList<Advice> advices;
        AdviceManager adviceManager = AdviceManager.getInstance();
        AdviceRequest adviceRequest = new AdviceRequest();
        adviceRequest.setLat(TEST_LAT);
        adviceRequest.setLng(TEST_LNG);
        adviceRequest.setDistance(TEST_RAD);
        adviceRequest.setAdviceRequest(TEST_ADVICE_REQUEST_VALUE);
        adviceRequest.setType(TEST_ADVICE_TYPE_PLACES);
        advices = adviceManager.acquireAdvices(adviceRequest);
        assertNotNull(advices);
        System.out.print(advices);
        adviceRequest.setType(TEST_ADVICE_TYPE_INFO);
        advices = adviceManager.acquireAdvices(adviceRequest);
        assertNotNull(advices);
        System.out.print(advices);
    }
}
