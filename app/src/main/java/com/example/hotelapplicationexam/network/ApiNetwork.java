package com.example.hotelapplicationexam.network;

import com.example.hotelapplicationexam.data.remote.models.request.LoginRequest;
import com.example.hotelapplicationexam.data.remote.models.response.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiNetwork {

    @POST("/api/oauth/token")
    Call<LoginResponse> login(@Body LoginRequest req);
}
