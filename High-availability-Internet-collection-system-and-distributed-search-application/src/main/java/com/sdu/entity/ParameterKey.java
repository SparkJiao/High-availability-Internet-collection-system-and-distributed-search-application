package com.sdu.entity;

import java.io.Serializable;

/**
 * Created by kkkkkk on 2018/7/13.
 */
public class ParameterKey implements Serializable{

    private String url;
    private int rank;

    public ParameterKey(String url, int rank) {
        this.url = url;
        this.rank = rank;
    }

    public ParameterKey() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ParameterKey that = (ParameterKey) o;

        if (getRank() != that.getRank()) return false;
        return getUrl().equals(that.getUrl());
    }

    @Override
    public int hashCode() {
        int result = getUrl().hashCode();
        result = 31 * result + getRank();
        return result;
    }
}
