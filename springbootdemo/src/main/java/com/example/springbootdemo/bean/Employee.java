package com.example.springbootdemo.bean;

import java.io.Serializable;

public class Employee implements Serializable {

    private String id;

    private String usercode;

    private String username;

    private String deptcode;

    public Employee() {
    }

    public Employee(String id, String usercode, String username, String deptcode) {
        this.id = id;
        this.usercode = usercode;
        this.username = username;
        this.deptcode = deptcode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsercode() {
        return usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDeptcode() {
        return deptcode;
    }

    public void setDeptcode(String deptcode) {
        this.deptcode = deptcode;
    }

    @Override
    public String toString() {
        return "{" +
                "id='" + id + '\'' +
                ", usercode='" + usercode + '\'' +
                ", username='" + username + '\'' +
                ", deptcode='" + deptcode + '\'' +
                '}';
    }
}
