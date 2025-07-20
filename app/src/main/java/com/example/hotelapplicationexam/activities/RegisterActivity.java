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

    private EditText etFirstName, etLastName, etUsername, etEmail, etPhone, etPassword, etConfirmPassword;
    private Button btnRegister;
    private AuthRepository authRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Bind UI
        etFirstName = findViewById(R.id.et_first_name);
        etLastName = findViewById(R.id.et_last_name);
        etUsername = findViewById(R.id.et_username);
        etEmail = findViewById(R.id.et_email);
        etPhone = findViewById(R.id.et_phone);
        etPassword = findViewById(R.id.et_password);
        etConfirmPassword = findViewById(R.id.et_confirm_password);
        btnRegister = findViewById(R.id.btn_register);

        authRepository = new AuthRepository();

        btnRegister.setOnClickListener(v -> {
            String firstName = etFirstName.getText().toString().trim();
            String lastName = etLastName.getText().toString().trim();
            String username = etUsername.getText().toString().trim();
            String email = etEmail.getText().toString().trim();
            String phone = etPhone.getText().toString().trim();
            String password = etPassword.getText().toString().trim();
            String confirmPassword = etConfirmPassword.getText().toString().trim();

            if (!password.equals(confirmPassword)) {
                MessageUtils.showToastMessage("Passwords do not match!", this);
                return;
            }

            authRepository.register(
                    firstName,
                    lastName,
                    username,
                    email,
                    phone,
                    password,
                    new ApiCallbackResponse() {
                        @Override
                        public void onLoading(String message) {
                            MessageUtils.showToastMessage("Registering...", RegisterActivity.this);
                        }

                        @Override
                        public void onSuccess(Object response) {
                            MessageUtils.showToastMessage("Registered successfully!", RegisterActivity.this);
                            finish(); // Back to login
                        }

                        @Override
                        public void onError(String message) {
                            MessageUtils.showToastMessage("Failed: " + message, RegisterActivity.this);
                        }
                    }
            );
        });
    }
}



//// RegisterActivity.java
//package com.example.hotelapplicationexam.activities;
//
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.example.hotelapplicationexam.R;
//import com.example.hotelapplicationexam.data.remote.repositories.AuthRepository;
//import com.example.hotelapplicationexam.network.ApiCallbackResponse;
//import com.example.hotelapplicationexam.utils.MessageUtils;
//
//public class RegisterActivity extends AppCompatActivity {
//
//    private EditText etUsername, etPassword;
//    private Button btnRegister;
//    private AuthRepository authRepository;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_register);
//
//        etUsername = findViewById(R.id.et_username);
//        etPassword = findViewById(R.id.et_password);
//        btnRegister = findViewById(R.id.btn_register);
//
//        authRepository = new AuthRepository();
//
//        btnRegister.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String username = etUsername.getText().toString().trim();
//                String password = etPassword.getText().toString().trim();
//
//                authRepository.register(username, password, new ApiCallbackResponse() {
//                    @Override
//                    public void onLoading(String message) {
//                        MessageUtils.showToastMessage("Registering...", RegisterActivity.this);
//                    }
//
//                    @Override
//                    public void onSuccess(Object response) {
//                        MessageUtils.showToastMessage("Registered successfully!", RegisterActivity.this);
//                        finish(); // Go back to login
//                    }
//
//                    @Override
//                    public void onError(String message) {
//                        MessageUtils.showToastMessage("Failed: " + message, RegisterActivity.this);
//                    }
//                });
//            }
//        });
//    }
//}
////package com.example.hotelapplicationexam.activities;
////
////import android.os.Bundle;
////
////import androidx.activity.EdgeToEdge;
////import androidx.appcompat.app.AppCompatActivity;
////import androidx.core.graphics.Insets;
////import androidx.core.view.ViewCompat;
////import androidx.core.view.WindowInsetsCompat;
////
////import com.example.hotelapplicationexam.R;
////
////public class RegisterActivity extends AppCompatActivity {
////
////    @Override
////    protected void onCreate(Bundle savedInstanceState) {
////        super.onCreate(savedInstanceState);
////        EdgeToEdge.enable(this);
////        setContentView(R.layout.activity_register);
////        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
////            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
////            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
////            return insets;
////        });
////    }
////}