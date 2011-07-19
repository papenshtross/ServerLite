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

    public Trend() {
    }

    public Trend(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
