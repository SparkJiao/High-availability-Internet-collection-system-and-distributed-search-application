package com.sdu.entity;

import java.io.Serializable;

/**
 * Created by kkkkkk on 2018/7/12.
 */
public class CutoffKey implements Serializable{

    private String schoolName;
    private String province;
    private String year;
    private String category;
    private String major;
    private String batch;

    public CutoffKey(String schoolName, String province, String year, String category, String major, String batch) {
        this.schoolName = schoolName;
        this.province = province;
        this.year = year;
        this.category = category;
        this.major = major;
        this.batch = batch;
    }

    public CutoffKey() {
    }


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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CutoffKey cutoffKey = (CutoffKey) o;

        if (!getSchoolName().equals(cutoffKey.getSchoolName())) return false;
        if (!getProvince().equals(cutoffKey.getProvince())) return false;
        if (!getYear().equals(cutoffKey.getYear())) return false;
        if (!getCategory().equals(cutoffKey.getCategory())) return false;
        if (!getMajor().equals(cutoffKey.getMajor())) return false;
        return getBatch().equals(cutoffKey.getBatch());
    }

    @Override
    public int hashCode() {
        int result = getSchoolName().hashCode();
        result = 31 * result + getProvince().hashCode();
        result = 31 * result + getYear().hashCode();
        result = 31 * result + getCategory().hashCode();
        result = 31 * result + getMajor().hashCode();
        result = 31 * result + getBatch().hashCode();
        return result;
    }
}
