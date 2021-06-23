package org.acme;

public class DaprJson {
    public String datacontenttype;
    public String source;
    public String topic;
    public String pubsubname;
    public String traceid;
    public String id;
    public String specversion;
    public String type;
    public String data;

    public DaprJson( String datacontenttype, String source, String topic, String pubsubname, String traceid, String id, String specversion, String type, String data){
    this.datacontenttype = datacontenttype;
    this.source = source;
    this.topic = topic;
    this.pubsubname = pubsubname;
    this.traceid = traceid;
    this.id = id;
    this.specversion = specversion;
    this.type = type;
    this.data = data;

    }
}
