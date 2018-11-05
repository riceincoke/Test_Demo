package com.blog.user.entity;

import org.apache.ibatis.type.Alias;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Alias(value = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer uid;
    private String username;
    private String userpassword;
    private Integer adminid;
    private Integer userinfo;
    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", userpassword='" + userpassword + '\'' +
                ", adminid=" + adminid +
                ", userinfo=" + userinfo +
                '}';
    }

    public User() {
    }

    public User(String username, String userpassword, Integer adminid, Integer userinfo) {
        this.username = username;
        this.userpassword = userpassword;
        this.adminid = adminid;
        this.userinfo = userinfo;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    public Integer getAdminid() {
        return adminid;
    }

    public void setAdminid(Integer adminid) {
        this.adminid = adminid;
    }

    public Integer getUserinfo() {
        return userinfo;
    }

    public void setUserinfo(Integer userinfo) {
        this.userinfo = userinfo;
    }
}