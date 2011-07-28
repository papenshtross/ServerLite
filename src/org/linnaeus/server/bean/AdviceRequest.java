package org.linnaeus.server.bean;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by IntelliJ IDEA.
 * User: Romchee
 * Date: 28/07/11
 * Time: 12:41
 * To change this template use File | Settings | File Templates.
 */
@XmlRootElement
public class AdviceRequest {

    private int lat;
    private int lng;
    private int distance;
    private String adviceRequest;

    public AdviceRequest(int lat, int lng, int distance, String adviceRequest) {
        this.lat = lat;
        this.lng = lng;
        this.distance = distance;
        this.adviceRequest = adviceRequest;
    }

    public AdviceRequest() {
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

    public String getAdviceRequest() {
        return adviceRequest;
    }

    public void setAdviceRequest(String adviceRequest) {
        this.adviceRequest = adviceRequest;
    }
}
