package com.example.hotelapplicationexam.network;

import com.example.hotelapplicationexam.data.remote.models.request.BaseRequest;
import com.example.hotelapplicationexam.data.remote.models.request.LoginRequest;
import com.example.hotelapplicationexam.data.remote.models.request.RegisterRequest;
import com.example.hotelapplicationexam.data.remote.models.response.BaseResponse;
import com.example.hotelapplicationexam.data.remote.models.response.Category;
import com.example.hotelapplicationexam.data.remote.models.response.LoginResponse;
import com.example.hotelapplicationexam.data.remote.models.response.RegisterResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface ApiNetwork {

    @POST("/api/oauth/token")
    Call<LoginResponse> login(@Body LoginRequest req);

    @POST("/api/oauth/register")
    Call<RegisterResponse> register(@Body RegisterRequest req);

    @POST("/api/app/category/list")
    Call<BaseResponse<List<Category>>> getAllCategories(@Body BaseRequest req, @Header("Authorization") String authHeader);

}
