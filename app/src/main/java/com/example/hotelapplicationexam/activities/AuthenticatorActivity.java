package com.example.hotelapplicationexam.activities;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hotelapplicationexam.data.local.UserLocalData;

public class AuthenticatorActivity extends AppCompatActivity {

    @Override
    protected void onResume(){
        super.onResume();
        if(UserLocalData.getAccessToken(this).isEmpty()){
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            finish();
        }
    }
}

