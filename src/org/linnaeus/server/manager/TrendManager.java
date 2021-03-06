package org.linnaeus.server.manager;

import org.linnaeus.server.bean.SearchCircle;
import org.linnaeus.server.bean.Trend;

import java.util.ArrayList;

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
        //Test method implementation
        ArrayList<Trend> testTrends = new ArrayList<Trend>();
		for (int i = 0; i < 5; i++){
            testTrends.add(new Trend(testTrendValue, 124));
        }
        return testTrends;
    }
}




