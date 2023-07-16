package com.example.daggerdemo;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface LoginRetrofitService {

    @GET("users/{user}/repos")
    Call<List<String>> login(@Path("user") String user);
}
