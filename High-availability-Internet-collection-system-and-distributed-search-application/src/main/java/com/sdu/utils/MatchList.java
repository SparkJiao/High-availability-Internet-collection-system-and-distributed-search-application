package com.sdu.utils;

import java.util.List;

/**
 * Created by kkkkkk on 2018/7/16.
 */
public class MatchList {

    private List<MatchModel> matchModelList;

    public MatchList(List<MatchModel> matchModelList) {
        this.matchModelList = matchModelList;
    }

    public MatchList() {
    }

    public List<MatchModel> getMatchModelList() {
        return matchModelList;
    }

    public void setMatchModelList(List<MatchModel> matchModelList) {
        this.matchModelList = matchModelList;
    }
}
