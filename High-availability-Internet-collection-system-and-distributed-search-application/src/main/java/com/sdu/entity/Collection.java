package com.sdu.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by kkkkkk on 2018/7/3.
 */

@Entity
@Table(name = "collection")
@IdClass(CollectionKey.class)
public class Collection {

    @Id
    @NotNull
    private String username;
    @Id
    @NotNull
    private String school;

    public Collection(String username, String school) {
        this.username = username;
        this.school = school;
    }

    public Collection() {
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
