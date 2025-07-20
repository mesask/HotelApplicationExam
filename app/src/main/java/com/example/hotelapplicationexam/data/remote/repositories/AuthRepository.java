package com.example.hotelapplicationexam.data.remote.repositories;

import com.example.hotelapplicationexam.data.remote.models.request.LoginRequest;
import com.example.hotelapplicationexam.data.remote.models.response.LoginResponse;
import com.example.hotelapplicationexam.network.ApiCallbackResponse;
import com.example.hotelapplicationexam.network.ApiClient;
import com.example.hotelapplicationexam.network.ApiNetwork;

import com.example.hotelapplicationexam.data.remote.models.request.RegisterRequest;
import com.example.hotelapplicationexam.data.remote.models.response.RegisterResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AuthRepository {
    private final ApiNetwork apiNetwork;
    public AuthRepository(){
        apiNetwork = ApiClient.getClient().create(ApiNetwork.class);
    }

    public void login(String username, String password, ApiCallbackResponse<LoginResponse> callbackResponse){
        callbackResponse.onLoading("Loading");
        try {
            LoginRequest loginRequest = new LoginRequest();
            loginRequest.setPhoneNumber(username);
            loginRequest.setPassword(password);
            apiNetwork.login(loginRequest).enqueue(new Callback<LoginResponse>() {
                @Override
                public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                    if (response.isSuccessful() && response.body() != null) {
                        callbackResponse.onSuccess(response.body());
                    } else {
                        callbackResponse.onError("Your username and password are incorrect !!!");
                    }
                }

                @Override
                public void onFailure(Call<LoginResponse> call, Throwable t) {
                    callbackResponse.onError("Internal Server Error - Unhandled Exception" + t.getMessage());
                }
            });
        }catch (Throwable e){
            callbackResponse.onError("General Error : "+e.getMessage());
        }
    }
}
