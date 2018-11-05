package com.blog.admin.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "admin")
public class Admin implements Serializable{
    @Id
    @Column(name = "a_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer aid;//实体唯一便是
    @Column(name = "ad_name")
    private String adName;//name
    @Column(name = "ad_password")
    private String adPassword;//pwd

    public Admin(Integer aid, String adName, String adPassword) {
        this.aid = aid;
        this.adName = adName;
        this.adPassword = adPassword;
    }

    public Admin() {
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getAdName() {
        return adName;
    }

    public void setAdName(String adName) {
        this.adName = adName;
    }

    public String getAdPassword() {
        return adPassword;
    }

    public void setAdPassword(String adPassword) {
        this.adPassword = adPassword;
    }
}
