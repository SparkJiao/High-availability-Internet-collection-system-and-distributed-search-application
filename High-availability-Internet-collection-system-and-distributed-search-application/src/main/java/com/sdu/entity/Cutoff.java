package com.sdu.entity;

import org.hibernate.annotations.DynamicUpdate;
import sun.util.calendar.CalendarUtils;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by kkkkkk on 2018/7/2.
 */

@Entity
@Table(name = "cutoff")
@IdClass(CutoffKey.class)
public class Cutoff {

    @Id
    @NotNull(message = "学校名称不能为空")
    private String schoolName;
    @Id
    @NotNull(message = "省份不能为空")
    private String province;
    @Id
    @NotNull(message = "年份不能为空")
    private String year;
    @Id
    @NotNull(message = "文理分科不能为空")
    private String category;
    @Id
    @NotNull(message = "专业不能为空")
    private String major;
    @Id
    @NotNull(message = "批次不能为空")
    private String batch;
    private String avegrade;
    private String maxgrade;
    private String mingrade;

    public Cutoff(String schoolName, String province, String year, String category, String major, String batch, String avegrade, String maxgrade, String mingrade) {
        this.schoolName = schoolName;
        this.province = province;
        this.year = year;
        this.category = category;
        this.major = major;
        this.batch = batch;
        this.avegrade = avegrade;
        this.maxgrade = maxgrade;
        this.mingrade = mingrade;
    }

    public Cutoff(){}

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
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
        return this.getAvegrade() + " " + this.getMaxgrade() + " " + this.getMingrade();
    }
}
