package com.michal.testapp;

import com.michal.testapp.Model.ObjListUsers;
import com.michal.testapp.Model.ObjUser;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by michal on 14.06.17.
 */

public interface Restapi {
    @GET("/api/users")
    Call<ObjListUsers> groupList(@Query("page") int numerPage);

    @GET("/api/users/{id}")
    Call<ObjUser> getObjUser(@Path("id") int userId);


}

