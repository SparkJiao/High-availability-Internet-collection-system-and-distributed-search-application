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
    private String grade;

    public CutoffNoMajorOrBatch(String school_name, String province, String year, String category, String grade) {
        this.school_name = school_name;
        this.province = province;
        this.year = year;
        this.category = category;
        this.grade = grade;
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

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
