package org.linnaeus.test;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.linnaeus.server.bean.SearchCircle;
import org.linnaeus.server.bean.Trend;
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
    private final int TEST_RAD = 20000;

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
}
