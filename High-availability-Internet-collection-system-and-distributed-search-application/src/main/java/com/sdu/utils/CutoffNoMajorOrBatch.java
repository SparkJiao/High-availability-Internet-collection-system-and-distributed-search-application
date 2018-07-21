package com.sdu.utils;

/**
 * Created by kkkkkk on 2018/7/2.
 */
public class CutoffNoMajorOrBatch {

    /*
    不限专业不限批次
     */
    private String school_name;
    private String province;
    private String year;
    private String category;
    private String avegrade;
    private String maxgrade;
    private String mingrade;

    public CutoffNoMajorOrBatch(String school_name, String province, String year, String category, String avegrade, String maxgrade, String mingrade) {
        this.school_name = school_name;
        this.province = province;
        this.year = year;
        this.category = category;
        this.avegrade = avegrade;
        this.maxgrade = maxgrade;
        this.mingrade = mingrade;
    }

    public CutoffNoMajorOrBatch() {
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
}
