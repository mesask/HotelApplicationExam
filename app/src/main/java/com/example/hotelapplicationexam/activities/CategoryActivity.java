package com.example.hotelapplicationexam.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hotelapplicationexam.R;
import com.example.hotelapplicationexam.adapter.CategoryAdapter;
import com.example.hotelapplicationexam.data.remote.models.request.BaseRequest;
import com.example.hotelapplicationexam.data.remote.models.response.Category;
import com.example.hotelapplicationexam.data.remote.repositories.CategoryRepository;
import com.example.hotelapplicationexam.network.ApiCallbackResponse;

import java.util.List;

public class CategoryActivity extends AuthenticatorActivity {
    private RecyclerView recyclerViewCategory;

    private CategoryRepository categoryRepository;
    private CategoryAdapter categoryAdapter;
    private ProgressBar progressBar;

    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_category);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initView();
        getData();
    }


    private void initView(){
        recyclerViewCategory = findViewById(R.id.recyclerViewCategory);
        progressBar = findViewById(R.id.progressBar);
        categoryRepository = new CategoryRepository();
        layoutManager = new GridLayoutManager(this,1);
        recyclerViewCategory.setLayoutManager(layoutManager);
    }

    public void getData(){
        BaseRequest req = new BaseRequest();
        categoryRepository.getAll(req, new ApiCallbackResponse<List<Category>>() {
            @Override
            public void onLoading(String message) {
                progressBar.setVisibility(View.VISIBLE);
            }

            @Override
            public void onSuccess(List<Category> response) {
                if(!response.isEmpty()) {
                    categoryAdapter = new CategoryAdapter(CategoryActivity.this, response);
                    recyclerViewCategory.setAdapter(categoryAdapter);
                }
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onError(String message) {
                progressBar.setVisibility(View.GONE);
            }
        },this);
    }

}