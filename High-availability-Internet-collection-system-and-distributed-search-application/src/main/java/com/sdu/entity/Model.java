package com.sdu.entity;

import com.sdu.utils.MatchModel;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by kkkkkk on 2018/7/13.
 */

@Entity
@Table(name = "model")
public class Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    private String startUrl;
    @NotNull
    private int currentLevel;
    @NotNull
    private String token;
    @NotNull
    private String pattern;
    @NotNull
    private int total;
    @NotNull
    private int wherePagenumber;
    @NotNull
    private int whereSize;

    public Model(@NotNull String startUrl, @NotNull int currentLevel, @NotNull String token, @NotNull String pattern, @NotNull int wherePagenumber, @NotNull int whereSize, @NotNull int total) {
        this.startUrl = startUrl;
        this.currentLevel = currentLevel;
        this.token = token;
        this.pattern = pattern;
        this.wherePagenumber = wherePagenumber;
        this.whereSize = whereSize;
        this.total = total;
    }

    public Model(@NotNull String startUrl, MatchModel matchModel){
        this.startUrl = startUrl;
        this.currentLevel = matchModel.getCurrentLevel();
        this.token = matchModel.getToken();
        this.pattern = matchModel.getPattern();
        this.wherePagenumber = matchModel.getWherePagenumber();
        this.whereSize = matchModel.getWhereSize();
        this.total = matchModel.getTotal();
    }

    public Model() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStartUrl() {
        return startUrl;
    }

    public void setStartUrl(String startUrl) {
        this.startUrl = startUrl;
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;
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

    @Override
    public String toString() {
        return "Model{" +
                "startUrl='" + startUrl + '\'' +
                ", currentLevel=" + currentLevel +
                ", token='" + token + '\'' +
                ", pattern='" + pattern + '\'' +
                ", total=" + total +
                ", wherePagenumber=" + wherePagenumber +
                ", whereSize=" + whereSize +
                '}';
    }
}
