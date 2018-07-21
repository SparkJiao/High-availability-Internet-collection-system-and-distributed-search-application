package com.sdu.entity;

import java.io.Serializable;

/**
 * Created by kkkkkk on 2018/7/12.
 */
public class PcutoffKey implements Serializable{

    private String province;
    private String year;
    private String category;
    private String batch;

    public PcutoffKey(String province, String year, String category, String batch) {
        this.province = province;
        this.year = year;
        this.category = category;
        this.batch = batch;
    }

    public PcutoffKey() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PcutoffKey that = (PcutoffKey) o;

        if (!getProvince().equals(that.getProvince())) return false;
        if (!getYear().equals(that.getYear())) return false;
        if (!getCategory().equals(that.getCategory())) return false;
        return getBatch().equals(that.getBatch());
    }

    @Override
    public int hashCode() {
        int result = getProvince().hashCode();
        result = 31 * result + getYear().hashCode();
        result = 31 * result + getCategory().hashCode();
        result = 31 * result + getBatch().hashCode();
        return result;
    }
}
