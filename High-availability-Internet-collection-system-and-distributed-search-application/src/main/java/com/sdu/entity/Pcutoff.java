package com.sdu.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by kkkkkk on 2018/7/2.
 */
@Entity
@Table(name = "pcutoff")
public class Pcutoff {
    @Id
    private String province;
    private int ifdiv = 1;
    private String benke;
    private String zhuanke;
    private String yiben;
    private String erben;

    public Pcutoff(String province, int ifdiv, String benke, String zhuanke, String yiben, String erben) {
        this.province = province;
        this.ifdiv = ifdiv;
        this.benke = benke;
        this.zhuanke = zhuanke;
        this.yiben = yiben;
        this.erben = erben;
    }

    public Pcutoff() {
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public int getIfdiv() {
        return ifdiv;
    }

    public void setIfdiv(int ifdiv) {
        this.ifdiv = ifdiv;
    }

    public String getBenke() {
        return benke;
    }

    public void setBenke(String benke) {
        this.benke = benke;
    }

    public String getZhuanke() {
        return zhuanke;
    }

    public void setZhuanke(String zhuanke) {
        this.zhuanke = zhuanke;
    }

    public String getYiben() {
        return yiben;
    }

    public void setYiben(String yiben) {
        this.yiben = yiben;
    }

    public String getErben() {
        return erben;
    }

    public void setErben(String erben) {
        this.erben = erben;
    }
}
