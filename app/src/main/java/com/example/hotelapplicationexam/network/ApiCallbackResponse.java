package com.example.hotelapplicationexam.network;

public interface ApiCallbackResponse<T> {
    void onLoading(String message);
    void onSuccess(T response);
    void onError(String message);
}
