package com.maiajam.mymemory.data.models;

import androidx.lifecycle.LiveData;

public class Memories extends LiveData<Memories> {

    private int Id;
    private String memoriesContent;
    private String memoriesOwner;
    private String UserId;


    public Memories() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getMemoriesContent() {
        return memoriesContent;
    }

    public void setMemoriesContent(String memoriesContent) {
        this.memoriesContent = memoriesContent;
    }

    public String getMemoriesOwner() {
        return memoriesOwner;
    }

    public void setMemoriesOwner(String memoriesOwner) {
        this.memoriesOwner = memoriesOwner;
    }
}
