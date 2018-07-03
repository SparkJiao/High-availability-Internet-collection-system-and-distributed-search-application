package com.sdu.entity;

import javax.persistence.*;

/**
 * Created by kkkkkk on 2018/7/2.
 */

@Entity
@Table(name = "school_info")
public class SchoolInfo {

    @Id
    private String name;
    private String location;
    private String url;

    public SchoolInfo(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public SchoolInfo(String name, String location, String url) {
        this.name = name;
        this.location = location;
        this.url = url;
    }

    public SchoolInfo() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
