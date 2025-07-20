// RegisterActivity.java
package com.example.hotelapplicationexam.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hotelapplicationexam.R;
import com.example.hotelapplicationexam.data.remote.repositories.AuthRepository;
import com.example.hotelapplicationexam.network.ApiCallbackResponse;
import com.example.hotelapplicationexam.utils.MessageUtils;

public class RegisterActivity extends AppCompatActivity {

    private EditText etUsername, etPassword;
    private Button btnRegister;
    private AuthRepository authRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);
        btnRegister = findViewById(R.id.btn_register);

        authRepository = new AuthRepository();

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsername.getText().toString().trim();
                String password = etPassword.getText().toString().trim();

                authRepository.register(username, password, new ApiCallbackResponse() {
                    @Override
                    public void onLoading(String message) {
                        MessageUtils.showToastMessage("Registering...", RegisterActivity.this);
                    }

                    @Override
                    public void onSuccess(Object response) {
                        MessageUtils.showToastMessage("Registered successfully!", RegisterActivity.this);
                        finish(); // Go back to login
                    }

                    @Override
                    public void onError(String message) {
                        MessageUtils.showToastMessage("Failed: " + message, RegisterActivity.this);
                    }
                });
            }
        });
    }
}
//package com.example.hotelapplicationexam.activities;
//
//import android.os.Bundle;
//
//import androidx.activity.EdgeToEdge;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.core.graphics.Insets;
//import androidx.core.view.ViewCompat;
//import androidx.core.view.WindowInsetsCompat;
//
//import com.example.hotelapplicationexam.R;
//
//public class RegisterActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
//        setContentView(R.layout.activity_register);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
//    }
//}