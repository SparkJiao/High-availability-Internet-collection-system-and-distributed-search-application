package com.sdu.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Created by kkkkkk on 2018/7/13.
 */

@Entity
@Table(name = "parameter")
@IdClass(ParameterKey.class)
public class Parameter {

    @Id
    @NotNull
    private String url;
    @Id
    @NotNull
    private int rank;
    @NotNull
    private String name;
    private String value;

    public Parameter(@NotNull String url, @NotNull int rank, @NotNull String name, String value) {
        this.url = url;
        this.rank = rank;
        this.name = name;
        this.value = value;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Parameter() {
    }
}
