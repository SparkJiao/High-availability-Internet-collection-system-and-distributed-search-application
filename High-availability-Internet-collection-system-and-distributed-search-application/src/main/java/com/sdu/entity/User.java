package com.sdu.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

/**
 * Created by kkkkkk on 2018/7/3.
 */

@Entity
@Table(name = "user")
public class User {

    @Id
    private String username;
    private String password;
    private String category;
    private String province;
    private String grade;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String username, String password, String category, String province, String grade) {
        this.username = username;
        this.password = password;
        this.category = category;
        this.province = province;
        this.grade = grade;
    }

    public User() {
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
