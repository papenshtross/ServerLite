package org.linnaeus.server.bean;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by IntelliJ IDEA.
 * User: Romchee
 * Date: 19/07/11
 * Time: 13:33
 * To change this template use File | Settings | File Templates.
 */
@XmlRootElement
public class Trend {

    private String value;
    private int mentions;

    public Trend() {
    }

    public Trend(String value, int mentions) {
        this.value = value;
        this.mentions = mentions;
    }

    public int getMentions() {
        return mentions;
    }

    public void setMentions(int mentions) {
        this.mentions = mentions;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
