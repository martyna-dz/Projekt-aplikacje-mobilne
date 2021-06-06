package com.example.projekt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProgressActivity extends AppCompatActivity {

    ListView list1,list2,list3;
    SQLiteHelper sqLiteHelper;
    SQLiteDatabase sq;
    int[] images;
    ArrayList<Integer> sumy1 = new ArrayList<>();
    ArrayList<Integer> sumy2 = new ArrayList<>();
    ArrayList<Integer> sumy3 = new ArrayList<>();
    ArrayList<String> max1 = new ArrayList<>();
    ArrayList<String> max2 = new ArrayList<>();
    ArrayList<String> max3 = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progres);
        sqLiteHelper = new SQLiteHelper(this);
        sq = sqLiteHelper.getWritableDatabase();
        list1=findViewById(R.id.lista1);
        list2=findViewById(R.id.lista2);
        list3=findViewById(R.id.lista3);
        images = new int[]{R.drawable.sofa_icon, R.drawable.dress_icon, R.drawable.carrott_icon,
                R.drawable.pear_icon, R.drawable.brain_icon, R.drawable.car_icon};
        getSumArray();
        getMaxArray();
        ListAdapter adapter1=new ListAdapter(this, sumy1.stream().mapToInt(i -> i).toArray(), max1.toArray(new String[0]), images);
        list1.setAdapter(adapter1);
        ListAdapter adapter2=new ListAdapter(this,sumy2.stream().mapToInt(i -> i).toArray(), max2.toArray(new String[0]), images);
        list2.setAdapter(adapter2);
        ListAdapter adapter3=new ListAdapter(this,sumy3.stream().mapToInt(i -> i).toArray(), max3.toArray(new String[0]), images);
        list3.setAdapter(adapter3);
    }
    public void getSumArray() {
        for (int i = 0; i < 6; i++) {
            int sum = sqLiteHelper.getSum(sq, i + 1, "english");
            sumy1.add(sum);
        }
        for (int i = 0; i < 6; i++) {
            int sum = sqLiteHelper.getSum(sq, i + 1, "german");
            sumy2.add(sum);
        }
        for (int i = 0; i < 6; i++) {
            int sum = sqLiteHelper.getSum(sq, i + 1, "spanish");
            sumy3.add(sum);
        }
    }
    public void getMaxArray(){
        for (int i = 0; i < 6; i++) {
            int sum = sqLiteHelper.getNumberOfWords(sq, i + 1, "english");
            max1.add(String.valueOf(sum));
        }
        for (int i = 0; i < 6; i++) {
            int sum = sqLiteHelper.getNumberOfWords(sq, i + 1, "german");
            max2.add(String.valueOf(sum));
        }
        for (int i = 0; i < 6; i++) {
            int sum = sqLiteHelper.getNumberOfWords(sq, i + 1, "spanish");
            max3.add(String.valueOf(sum));
        }
    }

    public void back(View view){
        onBackPressed();
    }
    public void toReset(View view){
        sqLiteHelper.resetProgress(sq);
    }
}