package com.sdu.utils;

/**
 * Created by kkkkkk on 2018/7/2.
 */
public class CutoffModel {

    /*
    限定专业和批次
     */
    private String school_name;
    private String province;
    private String year;
    private String category;
    private String major;
    private String batch;
    private String grade;

    public CutoffModel(String school_name, String province, String year, String category, String major, String batch, String grade) {
        this.school_name = school_name;
        this.province = province;
        this.year = year;
        this.category = category;
        this.major = major;
        this.batch = batch;
        this.grade = grade;
    }

    public CutoffModel() {
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

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
