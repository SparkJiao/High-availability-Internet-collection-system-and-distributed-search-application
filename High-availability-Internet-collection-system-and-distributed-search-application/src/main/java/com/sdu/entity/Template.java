package com.sdu.entity;

import com.sdu.utils.TemplateView;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by kkkkkk on 2018/7/13.
 */

@Entity
@Table(name = "template")
@DynamicInsert
public class Template {

    @Id
    @NotNull
    private String startUrl;
    @NotNull
    private boolean dynamic;
    @NotNull
    private int level;
    @NotNull
    private String headers;
    private String status;
    private Date startTime;
    private Date endTime;

    public Template(@NotNull String startUrl, @NotNull boolean dynamic, @NotNull int level, @NotNull String headers) {
        this.startUrl = startUrl;
        this.dynamic = dynamic;
        this.level = level;
        this.headers  = headers;
        this.status = "未采集";
    }

    public Template(@NotNull String startUrl, @NotNull boolean dynamic, @NotNull int level, @NotNull String headers, String status, Date startTime, Date endTime) {
        this.startUrl = startUrl;
        this.dynamic = dynamic;
        this.level = level;
        this.headers = headers;
        this.status = status;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Template(TemplateView templateView){
        this.startUrl = templateView.getStartUrl();
        this.dynamic = templateView.isDynamic();
        this.level = templateView.getLevel();
        this.headers = templateView.getHeaders();
        if(templateView.getStatus() == null){
            this.status = "未采集";
        }
    }

    public Template() {
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

    public boolean isDynamic() {
        return dynamic;
    }

    public void setDynamic(boolean dynamic) {
        this.dynamic = dynamic;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
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

    @Override
    public String toString() {
        return "Template{" +
                "startUrl='" + startUrl + '\'' +
                ", dynamic=" + dynamic +
                ", level=" + level +
                ", headers='" + headers + '\'' +
                ", status='" + status + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}

