package com.sdu.entity;

import javax.persistence.*;

/**
 * Created by kkkkkk on 2018/7/2.
 */

@Entity
@Table(name = "model")
public class Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String website_name;
    private String channel_name;
    private String channel_url;
    private String start_time;
    private String stop_time;
    private String status;

    public Model(String website_name, String channel_name, String channel_url, String status) {
        this.website_name = website_name;
        this.channel_name = channel_name;
        this.channel_url = channel_url;
        this.status = status;
    }

    public Model(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWebsite_name() {
        return website_name;
    }

    public void setWebsite_name(String website_name) {
        this.website_name = website_name;
    }

    public String getChannel_name() {
        return channel_name;
    }

    public void setChannel_name(String channel_name) {
        this.channel_name = channel_name;
    }

    public String getChannel_url() {
        return channel_url;
    }

    public void setChannel_url(String channel_url) {
        this.channel_url = channel_url;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getStop_time() {
        return stop_time;
    }

    public void setStop_time(String stop_time) {
        this.stop_time = stop_time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
