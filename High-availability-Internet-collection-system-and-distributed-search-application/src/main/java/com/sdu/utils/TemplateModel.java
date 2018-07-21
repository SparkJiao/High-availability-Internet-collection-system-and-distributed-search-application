package com.sdu.utils;

/**
 * Created by kkkkkk on 2018/7/16.
 */
public class TemplateModel {

    private String startUrl;
    private boolean dynamic;
    private int level;
    private String headers;

    public TemplateModel(String startUrl, int level, String headers, boolean dynamic) {
        this.startUrl = startUrl;
        this.level = level;
        this.headers = headers;
        this.dynamic = dynamic;
    }

    public TemplateModel() {
    }

    public String getHeaders() {
        return headers;
    }

    public void setHeaders(String headers) {
        this.headers = headers;
    }

    public String getStartUrl() {
        return startUrl;
    }

    public void setStartUrl(String startUrl) {
        this.startUrl = startUrl;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public boolean isDynamic() {
        return dynamic;
    }

    public void setDynamic(boolean dynamic) {
        this.dynamic = dynamic;
    }
}
