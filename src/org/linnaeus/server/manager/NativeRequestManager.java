package org.linnaeus.server.manager;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import org.linnaeus.server.bean.SearchCircle;
import org.linnaeus.server.twitter.TwitterRequest;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;

/**
 * Created by IntelliJ IDEA.
 * User: Romchee
 * Date: 22/07/11
 * Time: 12:42
 * To change this template use File | Settings | File Templates.
 */
public class NativeRequestManager {

    private static NativeRequestManager instance = new NativeRequestManager();
    private static final int PAGE_MIN = 1;
    private static final int PAGE_MAX = 16;

    public static NativeRequestManager getInstance(){
        return instance;
    }

    private NativeRequestManager(){
    }

    public String requestTweetsBySearchCircle(SearchCircle searchCircle){
        String response;
        ClientConfig config = new DefaultClientConfig();
        Client client = Client.create(config);
        WebResource service = client.resource(getBaseURI());
        StringBuilder result = new StringBuilder();
        // Get JSON
        int i = PAGE_MIN;
        do {
            response = executeQuery(service, searchCircle, i);
            result.append(response);
            i++;
        } while (response.contains(TwitterRequest.SEARCH_QUERY_PARAM_NEXT_PAGE)
                && !response.contains(TwitterRequest.SEARCH_QUERY_PARAM_NEXT_PAGE + PAGE_MAX));
        return result.toString();
    }

    private static URI getBaseURI() {
        return UriBuilder.fromUri(TwitterRequest.SEARCH_URL).build();
    }

    private String executeQuery(WebResource service, SearchCircle searchCircle, int page){
        return service.path(TwitterRequest.SEARCH_DATA_TYPE_JSON)
                    .queryParam(TwitterRequest.SEARCH_QUERY_PARAM_GEOCODE
                        , TwitterRequest.getGeocodeParamValue(searchCircle))
                    .queryParam(TwitterRequest.SEARCH_QUERY_PARAM_RPP
                            , TwitterRequest.SEARCH_QUERY_PARAM_RPP_VALUE)
                    .queryParam(TwitterRequest.SEARCH_QUERY_PARAM_PAGE
                            , String.valueOf(page))
                    .accept(MediaType.APPLICATION_JSON).get(String.class);
    }
}
