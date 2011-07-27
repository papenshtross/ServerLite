package org.linnaeus.server.twitter;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

/**
 * Created by IntelliJ IDEA.
 * User: Romchee
 * Date: 27/07/11
 * Time: 13:04
 * To change this template use File | Settings | File Templates.
 */
public class Login {

    public static void login(Twitter twitter){
        twitter.setOAuthConsumer(Constants.CONSUMER_KEY, Constants.CONSUMER_SECRET);
        AccessToken accessToken = new AccessToken(Constants.AUTH_TOKEN, Constants.AUTH_TOKEN_SECRET);
        twitter.setOAuthAccessToken(accessToken);
    }
}
