package com.gosiamatkowska.listofprofilepictures.model;

import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("profile_image") private String mPhotoURL;

    public String getPhotoURL() {
        return mPhotoURL;
    }
}
