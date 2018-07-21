package com.sdu.entity;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Created by kkkkkk on 2018/7/2.
 */
@Entity
@Table(name = "pcutoff")
@IdClass(PcutoffKey.class)
public class Pcutoff {
    @Id
    @NotNull
    private String province;
    @Id
    @NotNull
    private String year;
    @Id
    @NotNull
    private String category;
    @Id
    @NotNull
    private String batch;
    @NotNull
    private String grade;

    public Pcutoff(@NotNull String province, @NotNull String year, @NotNull String category, @NotNull String batch, @NotNull String grade) {
        this.province = province;
        this.year = year;
        this.category = category;
        this.batch = batch;
        this.grade = grade;
    }

    public Pcutoff() {
    }

    public String getProvince() {
        return province;
    }


    public void setProvince(String province) {
        this.province = province;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Pcutoff{" +
                "province='" + province + '\'' +
                ", year='" + year + '\'' +
                ", category='" + category + '\'' +
                ", batch='" + batch + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }
}
