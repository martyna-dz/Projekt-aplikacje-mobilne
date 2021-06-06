package com.example.projekt;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Collections;

public class AddActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    Spinner spinner, spinner1;
    SpinnerAdapter sadapter, sadapter1;
    String[] languages, categories;
    int[] images, images1;
    SQLiteHelper sqLiteHelper;
    String currentLanguage;
    SQLiteDatabase sq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        sqLiteHelper = new SQLiteHelper(this);
        sq = sqLiteHelper.getWritableDatabase();
        spinner = (Spinner) findViewById(R.id.spinner2);
        spinner1 = (Spinner) findViewById(R.id.spinner3);
        languages = this.getResources().getStringArray(R.array.spinnerChoices);
        categories = sqLiteHelper.getCategories(sq);

        images = new int[]{R.drawable.british_flag, R.drawable.spanish_flag, R.drawable.german_flag};
        images1 = new int[]{R.drawable.sofa_icon, R.drawable.dress_icon, R.drawable.carrott_icon,
                R.drawable.pear_icon, R.drawable.brain_icon, R.drawable.car_icon};
        currentLanguage = "english";
        sadapter = new SpinnerAdapter(this, languages, images);
        sadapter1 = new SpinnerAdapter(this, categories, images1);

        spinner.setOnItemSelectedListener(this);
        spinner.setAdapter(sadapter);

        spinner1.setOnItemSelectedListener(this);
        spinner1.setAdapter(sadapter1);

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void back(View view) {
        this.finish();
        onBackPressed();
    }

    public void add(View view) {
        EditText editTextForeign = (EditText) findViewById(R.id.editText1);
        EditText editTextPolish = (EditText) findViewById(R.id.editText);

        currentLanguage = spinner.getItemAtPosition(spinner.getSelectedItemPosition()).toString();
        if (currentLanguage.equals("Angielski")) {
            currentLanguage = "english";
        } else if (currentLanguage.equals("Niemiecki")) {
            currentLanguage = "german";
        } else {
            currentLanguage = "spanish";
        }
        sqLiteHelper.insertWord(sq, currentLanguage, spinner1.getSelectedItemPosition() + 1, editTextPolish.getText().toString(), editTextForeign.getText().toString());
        back(view);
    }
}
