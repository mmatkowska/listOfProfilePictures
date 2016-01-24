package com.gosiamatkowska.listofprofilepictures.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UserWrapper {

    @SerializedName("items") private List<User> mUsers;

    public List<User> getUsers() {
        return mUsers;
    }
}
