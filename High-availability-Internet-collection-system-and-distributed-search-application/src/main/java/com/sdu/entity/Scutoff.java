package com.sdu.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Created by kkkkkk on 2018/7/18.
 */

@Entity
@Table(name = "scutoff")
@IdClass(ScutoffKey.class)
public class Scutoff {

    @Id
    @NotNull
    private String school;
    @Id
    @NotNull
    private String year;
    @Id
    @NotNull
    private String province;
    @Id
    @NotNull
    private String category;
    @Id
    @NotNull
    private String batch;
    private String avegrade;
    private String maxgrade;
    private String mingrade;

    public Scutoff(@NotNull String school, @NotNull String year, @NotNull String province, @NotNull String category, @NotNull String batch, String avegrade, String maxgrade, String mingrade) {
        this.school = school;
        this.year = year;
        this.province = province;
        this.category = category;
        this.batch = batch;
        this.avegrade = avegrade;
        this.maxgrade = maxgrade;
        this.mingrade = mingrade;
    }

    public Scutoff() {
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getAvegrade() {
        return avegrade;
    }

    public void setAvegrade(String avegrade) {
        this.avegrade = avegrade;
    }

    public String getMaxgrade() {
        return maxgrade;
    }

    public void setMaxgrade(String maxgrade) {
        this.maxgrade = maxgrade;
    }

    public String getMingrade() {
        return mingrade;
    }

    public void setMingrade(String mingrade) {
        this.mingrade = mingrade;
    }

    @Override
    public String toString() {
        return "Scutoff{" +
                "school='" + school + '\'' +
                ", year='" + year + '\'' +
                ", province='" + province + '\'' +
                ", category='" + category + '\'' +
                ", batch='" + batch + '\'' +
                ", avegrade='" + avegrade + '\'' +
                ", maxgrade='" + maxgrade + '\'' +
                ", mingrade='" + mingrade + '\'' +
                '}';
    }
}
