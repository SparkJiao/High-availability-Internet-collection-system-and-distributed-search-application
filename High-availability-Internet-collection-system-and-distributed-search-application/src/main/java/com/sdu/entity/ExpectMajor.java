package com.sdu.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by kkkkkk on 2018/7/3.
 */

@Entity
@Table(name = "expect_major")
@IdClass(ExpectMajorKey.class)
public class ExpectMajor {

    @Id
    @NotNull
    private String username;
    @Id
    @NotNull
    private String major;

    public ExpectMajor(String username, String major) {
        this.username = username;
        this.major = major;
    }

    public ExpectMajor() {
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
