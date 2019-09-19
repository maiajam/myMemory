package com.maiajam.mymemory.data.models;

import androidx.lifecycle.LiveData;

public class Memories extends LiveData<Memories> {

    private String Id;
    private String memoriesContent;


    public Memories() {
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }


    public String getMemoriesContent() {
        return memoriesContent;
    }

    public void setMemoriesContent(String memoriesContent) {
        this.memoriesContent = memoriesContent;
    }

}
