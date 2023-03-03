package com.example.retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class userModel {
    @SerializedName("fact")

    private String mFact;
    @SerializedName("length")

    private int length;


    public userModel() {
    }

    public String getsFact() {
        return mFact;
    }

    public void setsFact(String mFact) {
        this.mFact = mFact;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
