package org.linnaeus.utils;

import org.linnaeus.server.bean.Trend;
import twitter4j.Trends;
import twitter4j.Tweet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Romchee
 * Date: 25/07/11
 * Time: 11:55
 * To change this template use File | Settings | File Templates.
 */
public class BeanFormatUtil {

    public static ArrayList<Trend> convertTweetsToTrends(List<Tweet> tweets){
        ArrayList<Trend> trends = new ArrayList<Trend>();
        for (Tweet tweet : tweets){
            trends.add(new Trend(tweet.getText(), 0));
        }
        return trends;
    }

    public static ArrayList<Trend> convertTwitterTrendsToTrends(Trends twitterTrends){
        ArrayList<Trend> trends = new ArrayList<Trend>();
        for (twitter4j.Trend trend : twitterTrends.getTrends()){
            trends.add(new Trend(trend.getName(), 0));
        }
        return trends;
    }
}
