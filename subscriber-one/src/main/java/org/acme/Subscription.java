package org.acme;

public class Subscription {
    public String pubsubname;
    public String topic;
    public String route;

    public Subscription(String pubsubname, String topic, String route) {
        this.pubsubname = pubsubname;
        this.topic = topic;
        this.route = route;
    }
}
