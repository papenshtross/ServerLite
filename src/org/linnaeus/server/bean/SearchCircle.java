package org.linnaeus.server.bean;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by IntelliJ IDEA.
 * User: Romchee
 * Date: 20/07/11
 * Time: 13:28
 * To change this template use File | Settings | File Templates.
 */
@XmlRootElement
public class SearchCircle {

    private int lat;
    private int lng;
    private int distance;


    public SearchCircle() {
    }

    public SearchCircle(int lat, int lng, int distance) {
        this.lat = lat;
        this.lng = lng;
        this.distance = distance;
    }

    public SearchCircle(AdviceRequest adviceRequest){
        this.lat = adviceRequest.getLat();
        this.lng = adviceRequest.getLng();
        this.distance = adviceRequest.getDistance();
    }

    public int getLat() {
        return lat;
    }

    public void setLat(int lat) {
        this.lat = lat;
    }

    public int getLng() {
        return lng;
    }

    public void setLng(int lng) {
        this.lng = lng;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}
