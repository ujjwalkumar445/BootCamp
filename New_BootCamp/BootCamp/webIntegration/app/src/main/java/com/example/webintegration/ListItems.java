package com.example.webintegration;

import com.google.gson.annotations.SerializedName;

public class ListItems {

    @SerializedName("name")
    String name;
    @SerializedName("message")
    String message;

    @SerializedName("profileImage")
    String ProfileImage;

    public ListItems(String name, String message, String profileImage) {
        this.name = name;
        this.message = message;
        this.ProfileImage = profileImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getProfileImage() {
        return ProfileImage;
    }

    public void setProfileImage(String profileImage) {
        ProfileImage = profileImage;
    }
}
