package com.example.hotelapplicationexam.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.hotelapplicationexam.R;
import com.example.hotelapplicationexam.data.local.UserLocalData;
import com.example.hotelapplicationexam.data.remote.models.response.LoginResponse;
import com.example.hotelapplicationexam.data.remote.repositories.AuthRepository;
import com.example.hotelapplicationexam.network.ApiCallbackResponse;
import com.example.hotelapplicationexam.utils.MessageUtils;

public class LoginActivity extends AppCompatActivity {
    private EditText etUsername, etPassword;
    private ProgressBar progressBar;
    private Button btnLogin,btnRegister;
    private AuthRepository authRepository;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initView();
//        etPassword = findViewById(R.id.etPassword);
//        etUsername = findViewById(R.id.etUsername);
//        progressBar = findViewById(R.id.progressBar);
//        btnLogin = findViewById(R.id.btnLogin);
//        authRepository = new AuthRepository();

    }

    private void initView(){
        etPassword = findViewById(R.id.etPassword);
        etUsername = findViewById(R.id.etUsername);
        progressBar = findViewById(R.id.progressBar);
        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);
        authRepository = new AuthRepository();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                register();
//                Intent intent = new Intent();
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
//                finish();
            }
        });
    }

    private void login(){
        String username = etUsername.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        if(username.isEmpty() || password.isEmpty()){
            MessageUtils.showToastMessage("Please Enter your username and password", this);
            return;
        }

        authRepository.login(username, password, new ApiCallbackResponse<LoginResponse>() {
            @Override
            public void onLoading(String message) {
                progressBar.setVisibility(View.VISIBLE);
            }

            @Override
            public void onSuccess(LoginResponse response) {
                progressBar.setVisibility(View.GONE);
                UserLocalData.setUserData(response,LoginActivity.this);
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }

            @Override
            public void onError(String message) {
                progressBar.setVisibility(View.GONE);
            }
        });
    }
}