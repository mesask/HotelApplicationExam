package com.example.hotelapplicationexam.data.remote.repositories;

import android.content.Context;

import com.example.hotelapplicationexam.data.local.UserLocalData;
import com.example.hotelapplicationexam.data.remote.models.request.BaseRequest;
import com.example.hotelapplicationexam.data.remote.models.response.BaseResponse;
import com.example.hotelapplicationexam.data.remote.models.response.Category;
import com.example.hotelapplicationexam.network.ApiCallbackResponse;
import com.example.hotelapplicationexam.network.ApiClient;
import com.example.hotelapplicationexam.network.ApiNetwork;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryRepository {
    private final ApiNetwork apiNetwork;

    public CategoryRepository() {
        this.apiNetwork = ApiClient.getClient().create(ApiNetwork.class);
    }

    public void getAll(BaseRequest req, ApiCallbackResponse<List<Category>> callbackResponse, Context context){
        try {
            callbackResponse.onLoading("Loading get all category !!!");
            apiNetwork.getAllCategories(req, UserLocalData.getHeaderAccessToken(context)).enqueue(new Callback<BaseResponse<List<Category>>>() {
                @Override
                public void onResponse(Call<BaseResponse<List<Category>>> call, Response<BaseResponse<List<Category>>> response) {
                    if (response.isSuccessful() && response.body() != null) {
                        callbackResponse.onSuccess(response.body().getData());
                    } else {
                        callbackResponse.onError("Get All Category error !");
                    }
                }

                @Override
                public void onFailure(Call<BaseResponse<List<Category>>> call, Throwable t) {
                    callbackResponse.onError("Error call to server api!!!: "+t.getMessage());
                }
            });
        }catch(Throwable e){
            callbackResponse.onError("General Error :"+e.getMessage());
        }
    }
}
