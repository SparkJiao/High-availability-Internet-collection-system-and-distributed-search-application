package com.sdu.entity;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by kkkkkk on 2018/7/18.
 */
public class ScutoffKey implements Serializable{

    private String school;
    private String year;
    private String province;
    private String category;
    private String batch;

    public ScutoffKey(String school, String year, String province, String category, String batch) {
        this.school = school;
        this.year = year;
        this.province = province;
        this.category = category;
        this.batch = batch;
    }

    public ScutoffKey() {
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
}
