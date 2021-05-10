package com.example.projekt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SQLiteHelper sqLiteHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sqLiteHelper = new SQLiteHelper(this);
        SQLiteDatabase sq = sqLiteHelper.getWritableDatabase();
        ArrayList<Word> words = sqLiteHelper.getWords(sq, "english", 2);
        Intent intent = new Intent(this, CategoryCreator.class);
        intent.putExtra("english", "english");
        startActivity(intent);
    }




}