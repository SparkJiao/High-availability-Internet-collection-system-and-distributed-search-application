package com.sdu.entity;

import java.io.Serializable;

/**
 * Created by kkkkkk on 2018/7/24.
 */
public class CollectionKey implements Serializable{

    private String username;
    private String school;

    public CollectionKey(String username, String school) {
        this.username = username;
        this.school = school;
    }

    public CollectionKey() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CollectionKey that = (CollectionKey) o;

        if (!getUsername().equals(that.getUsername())) return false;
        return getSchool().equals(that.getSchool());
    }

    @Override
    public int hashCode() {
        int result = getUsername().hashCode();
        result = 31 * result + getSchool().hashCode();
        return result;
    }
}
