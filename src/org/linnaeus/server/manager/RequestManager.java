package org.linnaeus.server.manager;

import org.linnaeus.server.bean.AdviceRequest;
import org.linnaeus.server.bean.SearchCircle;
import org.linnaeus.server.twitter.Login;
import org.linnaeus.server.twitter.TwitterRequest;
import org.linnaeus.utils.BeanFormatUtil;
import twitter4j.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Romchee
 * Date: 25/07/11
 * Time: 11:28
 * To change this template use File | Settings | File Templates.
 */
public class RequestManager {

    private static RequestManager instance = new RequestManager();
    public static int TWEETS_AMOUNT_BEFORE_TRENDS = 20;
    private Twitter twitter;

    private RequestManager(){
        twitter  = new TwitterFactory().getInstance();
        Login.login(twitter);
    }

    public static RequestManager getInstance(){
        return instance;
    }

    public List<Tweet> getTweetsBySearchCircle(SearchCircle searchCircle){
        Query query = new Query();
        setSearchCircleToQuery(query, searchCircle);
        query.setRpp(TwitterRequest.SEARCH_QUERY_PARAM_RPP_INT);
        List<Tweet> tweets;
        try {
            QueryResult result = twitter.search(query);
            tweets = result.getTweets();
        } catch (TwitterException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return tweets;
    }

    public ArrayList<org.linnaeus.server.bean.Trend> getTrendsBySearchCircle(SearchCircle searchCircle) {
        ArrayList<org.linnaeus.server.bean.Trend> trends;
        List<Tweet> tweets = getTweetsBySearchCircle(searchCircle);
        if (tweets.size() < TWEETS_AMOUNT_BEFORE_TRENDS){
            trends = BeanFormatUtil.convertTweetsToTrends(tweets);
        } else {
            try {
                ResponseList<Location> availableTrends =
                        twitter.getAvailableTrends(getGeoLocationBySearchCircle(searchCircle));
                Trends twitterTrends = twitter.getLocationTrends(availableTrends.get(0).getWoeid());
                trends = BeanFormatUtil.convertTwitterTrendsToTrends(twitterTrends);
            } catch (TwitterException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
        return trends;
    }

    private GeoLocation getGeoLocationBySearchCircle(SearchCircle searchCircle){
        return new GeoLocation(searchCircle.getLat() / TwitterRequest.GEO_TO_E6_FACTOR
                , searchCircle.getLng() / TwitterRequest.GEO_TO_E6_FACTOR);
    }

    private GeoLocation getGeoLocationByAdviceRequest(AdviceRequest adviceRequest){
        return new GeoLocation(adviceRequest.getLat() / TwitterRequest.GEO_TO_E6_FACTOR
                , adviceRequest.getLng() / TwitterRequest.GEO_TO_E6_FACTOR);
    }

    public ResponseList<Place> getPlacesByAdviceRequest(AdviceRequest adviceRequest){
        ResponseList<Place> places = null;
        GeoQuery geoQuery = new GeoQuery(getGeoLocationByAdviceRequest(adviceRequest));
        geoQuery.setGranularity(TwitterRequest.GEO_SEARCH_GRANULARITY_POI);
        geoQuery.setAccuracy(String.valueOf(adviceRequest.getDistance()));
        geoQuery.setMaxResults(TwitterRequest.GEO_SEARCH_MAX_RESULTS);
        try {
            places = twitter.searchPlaces(geoQuery);
        } catch (TwitterException e) {
            e.printStackTrace();
        }
        return places;
    }

    public List<Tweet> getTweetsByAdviceRequest(AdviceRequest adviceRequest) {
        Query query = new Query(adviceRequest.getAdviceRequest());
        SearchCircle searchCircle = new SearchCircle(adviceRequest);
        setSearchCircleToQuery(query, searchCircle);
        query.setRpp(TwitterRequest.SEARCH_QUERY_PARAM_RPP_INT);
        List<Tweet> tweets;
        try {
            QueryResult result = twitter.search(query);
            tweets = result.getTweets();
        } catch (TwitterException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return tweets;
    }

    private void setSearchCircleToQuery(Query query, SearchCircle searchCircle){
        query.setGeoCode(getGeoLocationBySearchCircle(searchCircle)
                , searchCircle.getDistance()
                / TwitterRequest.GEO_TO_METERS_FACTOR, Query.KILOMETERS);
    }
}
