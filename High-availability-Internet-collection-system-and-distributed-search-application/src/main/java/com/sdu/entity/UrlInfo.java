package com.sdu.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by kkkkkk on 2018/7/13.
 */

@Entity
@Table(name = "url_info")
public class UrlInfo {

    @Id
    @NotNull
    private String url;
    @NotNull
    private String startUrl;
    @NotNull
    private int currentLevel;

    public UrlInfo(@NotNull String url, @NotNull String startUrl, @NotNull Integer currentLevel) {
        this.url = url;
        this.startUrl = startUrl;
        this.currentLevel = currentLevel;
    }

    public UrlInfo() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getStartUrl() {
        return startUrl;
    }

    public void setStartUrl(String startUrl) {
        this.startUrl = startUrl;
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;
    }
}
