package com.sdu.utils;

import com.sdu.entity.Cutoff;

import java.util.List;

/**
 * Created by kkkkkk on 2018/7/6.
 */
public class CutoffList {
    private List<Cutoff> cutoffs;

    public CutoffList(List<Cutoff> cutoffs) {
        this.cutoffs = cutoffs;
    }

    public CutoffList() {
    }

    public List<Cutoff> getCutoffs() {
        return cutoffs;
    }

    public void setCutoffs(List<Cutoff> cutoffs) {
        this.cutoffs = cutoffs;
    }
}
