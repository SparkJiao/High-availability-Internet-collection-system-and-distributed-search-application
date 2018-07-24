package com.sdu.utils;

import com.sdu.entity.Cutoff;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by kkkkkk on 2018/7/23.
 */
public class CutoffView {

    private Map<String, List<Cutoff>> map;

    public CutoffView(){
        map = new HashMap<>();
    }

    public Map<String, List<Cutoff>> getMap() {
        return map;
    }

    public void setMap(Map<String, List<Cutoff>> map) {
        this.map = map;
    }

    public void addCutoff(Cutoff cutoff){
        if(this.map.containsKey(cutoff.getMajor())){
            this.map.get(cutoff.getMajor()).add(cutoff);
        }else{
            this.map.put(cutoff.getMajor(), new ArrayList<>());
        }
    }
}
