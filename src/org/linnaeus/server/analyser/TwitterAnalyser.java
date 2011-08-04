package org.linnaeus.server.analyser;

import org.linnaeus.server.bean.Advice;
import twitter4j.Tweet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Romchee
 * Date: 04/08/11
 * Time: 15:49
 * To change this template use File | Settings | File Templates.
 */
public class TwitterAnalyser {

    private static TwitterAnalyser instance = new TwitterAnalyser();

    private TwitterAnalyser(){

    }

    public static TwitterAnalyser getInstance(){
        return instance;
    }

    public ArrayList<Advice> analyseTweeterFlow(List<Tweet> tweets){
        ArrayList<Advice> advices = new ArrayList<Advice>();
        for (Tweet tweet : tweets){
            Advice advice = new Advice();
            advice.setName(tweet.getText());
            advice.setDescription(compileAdviceDescriptionFromTweet(tweet));
            advices.add(advice);
        }
        return advices;
    }

    private String compileAdviceDescriptionFromTweet(Tweet tweet){
        StringBuilder description = new StringBuilder();
        description.append("Location: ").append(tweet.getLocation());
        description.append("Date: ").append(tweet.getCreatedAt());
        return description.toString();
    }
}
