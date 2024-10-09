package com.sun.furn.entity;

public class User {
    private String uname;
    private String sno;
    private String pwd;
    private int role;

    public User() {
        System.out.println("user构造...");
    }
    public void init() {
        System.out.println("user init...");
    }
    public void destroy() {
        System.out.println("user 析构");
    }

    public User(String uname,String sno,String pwd,int role) {
        this.uname = uname;
        this.sno = sno;
        this.pwd = pwd;
        this.role = role;
    }

    public String getUname() {
        return uname;
    }
    public void setUname(String uname) {
        this.uname = uname;
    }
    public String getSno() {
        return sno;
    }
    public void setSno(String sno) {
        this.sno = sno;
    }
    public String getPwd() {
        return pwd;
    }
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    public int getRole() {
        return role;
    }
    public void setRole(int role) {
        this.role = role;
    }


}