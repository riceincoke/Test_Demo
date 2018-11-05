package com.blog.user.entity;

import org.apache.ibatis.type.Alias;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "userInfo")
@Alias(value = "UserInfo")
public class UserInfo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "infoId")
    private Integer infoId;
    @Column(name = "grade")
    private String grade;
    @Column(name = "age")
    private Integer age;
    @Column(name = "addr")
    private String addr;
    @Column(name = "status")
    private boolean status;

    public UserInfo() {
    }

    public UserInfo(String grade, Integer age, String addr, boolean status) {
        this.grade = grade;
        this.age = age;
        this.addr = addr;
        this.status = status;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "infoId=" + infoId +
                ", grade='" + grade + '\'' +
                ", age=" + age +
                ", addr='" + addr + '\'' +
                ", status=" + status +
                '}';
    }

    public Integer getInfoId() {
        return infoId;
    }

    public void setInfoId(Integer infoId) {
        this.infoId = infoId;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
