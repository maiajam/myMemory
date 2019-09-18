package com.maiajam.mymemory;

public class GlobalValueSaver {

    private static GlobalValueSaver instance ;
    private String UserId ;
    private String UserName;
    private String FailerMessage;
    private String allDataFailerMessage;

    public static GlobalValueSaver getInstance() {
        if(instance == null)
        {
            instance = new GlobalValueSaver();
        }
        return instance;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public void setCreatUserFailerMessage(String FailerMessage) {
        this.FailerMessage = FailerMessage;
    }

    public String getFailerMessage() {
        return FailerMessage;
    }

    public void setGetAllDataFailerMessage(String failerMessage) {
        this.allDataFailerMessage = failerMessage;
    }

    public String getAllDataFailerMessage() {
        return allDataFailerMessage;
    }
}
