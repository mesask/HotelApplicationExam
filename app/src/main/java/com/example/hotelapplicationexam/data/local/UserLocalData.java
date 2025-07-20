package com.example.hotelapplicationexam.data.local;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.hotelapplicationexam.data.remote.models.response.LoginResponse;

public class UserLocalData {
    public static void setUserData(LoginResponse data, Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences("USER_DATA",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("ACCESS_TOKEN",data.getAccessToken());
        editor.putString("REFRESH_TOKEN",data.getRefreshToken());
        editor.apply();
    }

    public static String getAccessToken(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences("USER_DATA",MODE_PRIVATE);
        return sharedPreferences.getString("ACCESS_TOKEN","REFRESH_TOKEN");
    }

    public static void removeUserData(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences("USER_DATA",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove("ACCESS_TOKEN");
        editor.remove("REFRESH_TOKEN");
        editor.apply();
    }
}
