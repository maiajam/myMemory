package com.maiajam.mymemory.data.models;

import androidx.lifecycle.LiveData;

public class Memories extends LiveData<Memories> {

    private String id;
    private String memoriesContent;


    public Memories() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        id = id;
    }


    public String getMemoriesContent() {
        return memoriesContent;
    }

    public void setMemoriesContent(String memoriesContent) {
        this.memoriesContent = memoriesContent;
    }

}
