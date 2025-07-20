package com.example.hotelapplicationexam.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hotelapplicationexam.R;
import com.example.hotelapplicationexam.data.remote.models.response.Category;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>{
    private Context context;
    private List<Category> categoryList;

    public CategoryAdapter(Context context, List<Category> categoryList) {
        this.context = context;
        this.categoryList = categoryList;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.category_card_item_layout,null,false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        Category category = categoryList.get(position);
        if(!category.getName().isEmpty()){
            holder.txtTitle.setText(category.getName().toString());
        }
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }


    public static class CategoryViewHolder extends RecyclerView.ViewHolder{
        TextView txtTitle;
        ImageView ivEdit,ivDelete;
        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            ivDelete = itemView.findViewById(R.id.ivDelete);
            ivEdit = itemView.findViewById(R.id.ivEdit);
            txtTitle = itemView.findViewById(R.id.txtCategoryName);
        }
    }
}
