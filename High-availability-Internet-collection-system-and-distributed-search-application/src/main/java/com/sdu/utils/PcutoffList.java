package com.sdu.utils;

import com.sdu.entity.Pcutoff;

import java.util.List;

/**
 * Created by kkkkkk on 2018/7/13.
 */
public class PcutoffList {

    private List<Pcutoff> pcutoffs;

    public PcutoffList(List<Pcutoff> pcutoffs) {
        this.pcutoffs = pcutoffs;
    }

    public PcutoffList() {
    }

    public List<Pcutoff> getPcutoffs() {
        return pcutoffs;
    }

    public void setPcutoffs(List<Pcutoff> pcutoffs) {
        this.pcutoffs = pcutoffs;
    }
}
