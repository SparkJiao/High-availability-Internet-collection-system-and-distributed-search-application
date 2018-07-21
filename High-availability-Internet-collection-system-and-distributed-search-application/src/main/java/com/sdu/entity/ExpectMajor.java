package com.sdu.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by kkkkkk on 2018/7/3.
 */

@Entity
@Table(name = "expect_major")
public class ExpectMajor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    private String username;
    @NotNull
    private String major;

    public ExpectMajor(String username, String major) {
        this.username = username;
        this.major = major;
    }

    public ExpectMajor() {
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

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}
