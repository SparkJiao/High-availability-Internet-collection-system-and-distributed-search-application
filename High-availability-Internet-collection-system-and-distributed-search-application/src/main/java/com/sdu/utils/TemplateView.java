package com.sdu.utils;

import com.sdu.entity.Template;

import java.util.Date;
import java.util.List;

/**
 * Created by kkkkkk on 2018/7/17.
 */
public class TemplateView {

    private String startUrl;
    private int level;
    private String target;
    private String headers;
    private boolean dynamic;
    private String status;
    private Date startTime;
    private Date endTime;
    private List<MatchModel> matchModelList;

    public TemplateView(String startUrl, int level, String target, String headers, boolean dynamic, String status, Date startTime, Date endTime, List<MatchModel> matchModelList) {
        this.startUrl = startUrl;
        this.level = level;
        this.target = target;
        this.headers = headers;
        this.dynamic = dynamic;
        this.status = status;
        this.startTime = startTime;
        this.endTime = endTime;
        this.matchModelList = matchModelList;
    }

    public TemplateView(Template template, List<MatchModel> matchModelsList) {
        this.startUrl = template.getStartUrl();
        this.level = template.getLevel();
        this.target = template.getTarget();
        this.headers = template.getHeaders();
        this.dynamic = template.isDynamic();
        this.status = template.getStatus();
        this.startTime = template.getStartTime();
        this.endTime = template.getEndTime();
        this.matchModelList = matchModelsList;
    }

    public TemplateView() {
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getHeaders() {
        return headers;
    }

    public void setHeaders(String headers) {
        this.headers = headers;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
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

    public List<MatchModel> getMatchModelList() {
        return matchModelList;
    }

    public void setMatchModelList(List<MatchModel> matchModelList) {
        this.matchModelList = matchModelList;
    }

    @Override
    public String toString() {
        return "TemplateView{" +
                "startUrl='" + startUrl + '\'' +
                ", level=" + level +
                ", headers='" + headers + '\'' +
                ", dynamic=" + dynamic +
                ", status='" + status + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", matchModelList=" + matchModelList +
                '}';
    }
}
