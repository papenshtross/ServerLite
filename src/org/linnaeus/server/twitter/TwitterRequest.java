package org.linnaeus.server.twitter;

import org.linnaeus.server.bean.SearchCircle;

/**
 * Created by IntelliJ IDEA.
 * User: Romchee
 * Date: 22/07/11
 * Time: 12:45
 * To change this template use File | Settings | File Templates.
 */
public class TwitterRequest {

    public final static String SEARCH_URL = "http://search.twitter.com";
    public final static String SEARCH_DATA_TYPE_JSON = "search.json";
    public final static String SEARCH_QUERY_PARAM_GEOCODE = "geocode";
    public final static String SEARCH_QUERY_PARAM_RPP = "rpp";
    public final static String SEARCH_QUERY_PARAM_RPP_VALUE = "100";
    public final static int SEARCH_QUERY_PARAM_RPP_INT = 100;
    public final static String SEARCH_QUERY_PARAM_PAGE = "page";
    public final static String SEARCH_QUERY_PARAM_NEXT_PAGE = "\"next_page\":\"?page=";
    private final static double GEO_FROM_E6_FACTOR = 0.000001;
    public final static double GEO_TO_E6_FACTOR = 1000000.0;
    public final static double GEO_TO_METERS_FACTOR = 1000.0;
    private final static double GEO_FROM_METERS_FACTOR = 0.001;
    private final static String GEO_KM = "km";
    public final static String GEO_SEARCH_GRANULARITY_POI = "poi";
    public final static int GEO_SEARCH_MAX_RESULTS = 100;
    public static int TWEETS_AMOUNT_BEFORE_TRENDS = 20;
    public static String SEARCH_QUERY_PARAM_PLACE = "place:";
    public static int SEARCH_MAX_PAGES = 15;

    public static final String getGeocodeParamValue(SearchCircle searchCircle){
        StringBuilder geoParam = new StringBuilder();
        geoParam.append(searchCircle.getLat() * GEO_FROM_E6_FACTOR).append(",");
        geoParam.append(searchCircle.getLng() * GEO_FROM_E6_FACTOR).append(",");
        geoParam.append(searchCircle.getDistance() * GEO_FROM_METERS_FACTOR).append(GEO_KM);
        return geoParam.toString();
    }
}
