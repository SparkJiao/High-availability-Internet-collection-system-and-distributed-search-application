package com.sdu.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by kkkkkk on 2018/7/23.
 */

@Entity
@Table(name = "major")
public class Major {

    @Id
    private String major;

    public Major(String major) {
        this.major = major;
    }

    public Major() {
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}
