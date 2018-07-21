package com.sdu.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by kkkkkk on 2018/7/3.
 */

@Entity
@Table(name = "collection")
public class Collection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    private String username;
    @NotNull
    private String school;

    public Collection(String username, String school) {
        this.username = username;
        this.school = school;
    }

    public Collection() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
