package com.sdu.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by kkkkkk on 2018/7/23.
 */

@Entity
@Table(name = "school")
public class School {

    @Id
    private String school;

    public School() {
    }

    public School(String school) {
        this.school = school;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }
}
