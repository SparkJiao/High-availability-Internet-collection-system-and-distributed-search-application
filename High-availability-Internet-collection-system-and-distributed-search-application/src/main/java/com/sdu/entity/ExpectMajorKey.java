package com.sdu.entity;

import java.io.Serializable;

/**
 * Created by kkkkkk on 2018/7/24.
 */
public class ExpectMajorKey implements Serializable{

    private String username;
    private String major;

    public ExpectMajorKey(String username, String major) {
        this.username = username;
        this.major = major;
    }

    public ExpectMajorKey() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExpectMajorKey that = (ExpectMajorKey) o;

        if (!getUsername().equals(that.getUsername())) return false;
        return getMajor().equals(that.getMajor());
    }

    @Override
    public int hashCode() {
        int result = getUsername().hashCode();
        result = 31 * result + getMajor().hashCode();
        return result;
    }
}
