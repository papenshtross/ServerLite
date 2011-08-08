package org.linnaeus.server.manager;

import org.linnaeus.server.analyser.TwitterAnalyser;
import org.linnaeus.server.bean.Advice;
import org.linnaeus.server.bean.AdviceRequest;
import twitter4j.Place;
import twitter4j.ResponseList;
import twitter4j.Tweet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Romchee
 * Date: 28/07/11
 * Time: 12:44
 * To change this template use File | Settings | File Templates.
 */
public class AdviceManager {

    public static final String ADVICE_REQUEST_TYPE_INFO = "info";
    public static final String ADVICE_REQUEST_TYPE_PLACES = "places";

    private static AdviceManager instance = new AdviceManager();
    private RequestManager requestManager;

    private AdviceManager(){
        requestManager = RequestManager.getInstance();
    }

    public static AdviceManager getInstance(){
        return instance;
    }

    public ArrayList<Advice> acquireAdvices(AdviceRequest adviceRequest){
        ArrayList<Advice> advices = new ArrayList<Advice>();
        if (adviceRequest.getType().equals(ADVICE_REQUEST_TYPE_PLACES)){
            advices = getAdvicesBasedOnPlaces(adviceRequest);
        } else {
            if (adviceRequest.getType().equals(ADVICE_REQUEST_TYPE_INFO)){
                advices = getAdvicesBasedOnTweets(adviceRequest);
            }
        }
        return advices;
    }

    private ArrayList<Advice> getAdvicesBasedOnPlaces(AdviceRequest adviceRequest){
        ArrayList<Advice> advices = new ArrayList<Advice>();
        ResponseList<Place> places = requestManager.getPlacesByAdviceRequest(adviceRequest);
        for(Place place : places){
            advices.add(obtainAdviceFromPlace(place));
        }
        return advices;
    }

    //Analyse tweets about the place and returns compiled advice
    private Advice obtainAdviceFromPlace(Place place){
        Advice advice = new Advice();
        advice.setName(place.getFullName());
        advice.setDescription(buildAdviceDescriptionFromPlace(place));
        List<Tweet> tweets = requestManager.getTweetsByPlace(place);
        double rating = TwitterAnalyser.getInstance().retrieveRatingByTweets(tweets);
        advice.setRating(rating);
        return advice;
    }

    private ArrayList<Advice> getAdvicesBasedOnTweets(AdviceRequest adviceRequest){
        List<Tweet> tweets = requestManager.getTweetsByAdviceRequest(adviceRequest);
        TwitterAnalyser analyser = TwitterAnalyser.getInstance();
        return analyser.analyseTweeterFlow(tweets);
    }

    private String buildAdviceDescriptionFromPlace(Place place){
        StringBuilder description = new StringBuilder();
        description.append("Type: ").append(place.getPlaceType()).append("\n");
        description.append("Address: ").append(place.getStreetAddress());
        return description.toString();
    }
}
