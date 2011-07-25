package org.linnaeus.server.manager;

import org.linnaeus.server.bean.SearchCircle;
import org.linnaeus.server.bean.Trend;
import org.linnaeus.server.twitter.TwitterRequest;
import org.linnaeus.utils.BeanFormatUtil;
import twitter4j.GeoLocation;
import twitter4j.Tweet;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.api.LocalTrendsMethods;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Romchee
 * Date: 19/07/11
 * Time: 13:04
 * To change this template use File | Settings | File Templates.
 */
public class TrendManager {

    private static TrendManager instance = new TrendManager();
    private static String testTrendValue = "Test Trend";

    private TrendManager(){

    }

    public static TrendManager getInstance(){
        return instance;
    }

    public ArrayList<Trend> acquireTrends(SearchCircle searchCircle){
		RequestManager requestManager = RequestManager.getInstance();
        return requestManager.getTrendsBySearchCircle(searchCircle);
    }

     public ArrayList<Trend> acquireTrends(){
        //Test method realization
        ArrayList<Trend> testTrends = new ArrayList<Trend>();
		for (int i = 0; i < 5; i++){
            testTrends.add(new Trend(testTrendValue, 124));
        }
        return testTrends;
    }
}




