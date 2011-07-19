package org.linnaeus.server.manager;

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
    private String testTrendValue = "Test Trend";

    private TrendManager(){

    }

    public static TrendManager getInstance(){
        return instance;
    }

    public ArrayList<Trend> acquireTrends(){
        //Test method realization
        ArrayList<Trend> testTrends = new ArrayList<Trend>();
		for (int i = 0; i < 5; i++){
            testTrends.add(new Trend(testTrendValue));
        }
        return testTrends;
    }

    public ArrayList<Trend> acquireTrends(String trendValue){
        testTrendValue = trendValue;
        return acquireTrends();
    }
}
