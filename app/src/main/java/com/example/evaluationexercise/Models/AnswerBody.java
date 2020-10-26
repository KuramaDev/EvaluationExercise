package com.example.evaluationexercise.Models;

import com.google.gson.annotations.SerializedName;

import androidx.annotation.NonNull;

public class AnswerBody {
    @SerializedName("BranchId")
    String branchId ;
    @SerializedName("Vhappy")
    int vhappy;
    @SerializedName("Happy")
    int happy;
    @SerializedName("NotHappy")
    int notHappy;
    @SerializedName("Bad")
    int bad;
    @SerializedName("An1")
    int an1;
    @SerializedName("An2")
    int an2;
    @SerializedName("An3")
    int an3;
    @SerializedName("An4")
    int an4;
    @SerializedName("An5")
    int an5;
    @SerializedName("Text")
    String text = "";
    @SerializedName("time")
    int time = 123456789;

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    public int getVhappy() {
        return vhappy;
    }

    public void setVhappy(int vhappy) {
        this.vhappy = vhappy;
    }

    public int getHappy() {
        return happy;
    }

    public void setHappy(int happy) {
        this.happy = happy;
    }

    public int getNotHappy() {
        return notHappy;
    }

    public void setNotHappy(int notHappy) {
        this.notHappy = notHappy;
    }

    public int getBad() {
        return bad;
    }

    public void setBad(int bad) {
        this.bad = bad;
    }

    public int getAn1() {
        return an1;
    }

    public void setAn1(int an1) {
        this.an1 = an1;
    }

    public int getAn2() {
        return an2;
    }

    public void setAn2(int an2) {
        this.an2 = an2;
    }

    public int getAn3() {
        return an3;
    }

    public void setAn3(int an3) {
        this.an3 = an3;
    }

    public int getAn4() {
        return an4;
    }

    public void setAn4(int an4) {
        this.an4 = an4;
    }

    public int getAn5() {
        return an5;
    }

    public void setAn5(int an5) {
        this.an5 = an5;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @NonNull
    @Override
    public String toString() {
        return "Answer{" +
                "branchId='" + branchId + '\'' +
                ", vhappy=" + vhappy +
                ", happy=" + happy +
                ", notHappy=" + notHappy +
                ", bad=" + bad +
                ", an1=" + an1 +
                ", an2=" + an2 +
                ", an3=" + an3 +
                ", an4=" + an4 +
                ", an5=" + an5 +
                ", text='" + text + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
