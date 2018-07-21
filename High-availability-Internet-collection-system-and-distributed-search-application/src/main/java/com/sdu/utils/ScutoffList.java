package com.sdu.utils;

import com.sdu.entity.Scutoff;

import java.util.List;

/**
 * Created by kkkkkk on 2018/7/18.
 */
public class ScutoffList {

    private List<Scutoff> scutoffs;

    public ScutoffList(List<Scutoff> scutoffs) {
        this.scutoffs = scutoffs;
    }

    public ScutoffList() {
    }

    public List<Scutoff> getScutoffs() {
        return scutoffs;
    }

    public void setScutoffs(List<Scutoff> scutoffs) {
        this.scutoffs = scutoffs;
    }
}
