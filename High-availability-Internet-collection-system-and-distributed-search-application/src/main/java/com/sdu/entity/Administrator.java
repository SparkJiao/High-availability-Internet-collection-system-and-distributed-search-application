package com.sdu.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Created by kkkkkk on 2018/7/6.
 */

@Entity
@Table(name = "administrator")
public class Administrator {

    @Id
    @NotNull
    private String username;
    @NotNull
    private String password;

    public Administrator(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Administrator() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
