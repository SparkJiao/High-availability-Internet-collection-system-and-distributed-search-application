package com.sdu.utils;

/**
 * Created by kkkkkk on 2018/7/16.
 */
public class MatchView {

    private String token;
    private String pattern;
    private int wherePagenumber;
    private int whereSize;
    private int total;

    public MatchView(String token, String pattern, int wherePagenumber, int whereSize, int total) {
        this.token = token;
        this.pattern = pattern;
        this.wherePagenumber = wherePagenumber;
        this.whereSize = whereSize;
        this.total = total;
    }

    public MatchView() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public int getWherePagenumber() {
        return wherePagenumber;
    }

    public void setWherePagenumber(int wherePagenumber) {
        this.wherePagenumber = wherePagenumber;
    }

    public int getWhereSize() {
        return whereSize;
    }

    public void setWhereSize(int whereSize) {
        this.whereSize = whereSize;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
