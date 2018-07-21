package com.sdu.utils;

/**
 * Created by kkkkkk on 2018/7/2.
 */
public class CutoffNoBatch {

    /*
    不限批次
     */

    private String school_name;
    private String province;
    private String year;
    private String category;
    private String batch;
    private String avegrade;
    private String maxgrade;
    private String mingrade;

    public CutoffNoBatch(String school_name, String province, String year, String category, String batch, String avegrade, String maxgrade, String mingrade) {
        this.school_name = school_name;
        this.province = province;
        this.year = year;
        this.category = category;
        this.batch = batch;
        this.avegrade = avegrade;
        this.maxgrade = maxgrade;
        this.mingrade = mingrade;
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

    public CutoffNoBatch() {
    }

    public String getSchool_name() {
        return school_name;
    }

    public void setSchool_name(String school_name) {
        this.school_name = school_name;
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

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }


}
