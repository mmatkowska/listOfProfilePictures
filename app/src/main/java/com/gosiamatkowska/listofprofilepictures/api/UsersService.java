package com.gosiamatkowska.listofprofilepictures.api;

import com.gosiamatkowska.listofprofilepictures.model.UserWrapper;

import retrofit2.Call;
import retrofit2.http.GET;

public interface UsersService {
    @GET("users?site=stackoverflow")
    Call<UserWrapper> getUserWrapper();
}
