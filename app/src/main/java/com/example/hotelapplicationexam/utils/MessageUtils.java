package com.example.hotelapplicationexam.utils;

import android.content.Context;
import android.widget.Toast;

import com.example.hotelapplicationexam.activities.MainActivity;

public class MessageUtils {
    public static void showToastMessage(String message, Context context){
        Toast.makeText(context,message,Toast.LENGTH_LONG).show();
    }
}
