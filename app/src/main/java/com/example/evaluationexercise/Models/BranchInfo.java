package com.example.evaluationexercise.Models;

import com.google.gson.annotations.SerializedName;

public class BranchInfo {

    @SerializedName("Id")
    private String id ;
    @SerializedName("Bgroup")
    private String group;
    @SerializedName("BranchCity")
    private String city;
    @SerializedName("BranchArea")
    private String area;
    @SerializedName("BranchName")
    private String name;
    @SerializedName("BranchPassword")
    private  String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "BranchInfo{" +
                "id='" + id + '\'' +
                ", group='" + group + '\'' +
                ", city='" + city + '\'' +
                ", area='" + area + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
