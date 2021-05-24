package com.example.projekt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    /*SQLiteHelper sqLiteHelper;


        sqLiteHelper = new SQLiteHelper(this);
        SQLiteDatabase sq = sqLiteHelper.getWritableDatabase();
        ArrayList<Word> words = sqLiteHelper.getWords(sq, "english", 2);
        Intent intent = new Intent(this, CategoryCreator.class);
        intent.putExtra("english", "english");
        startActivity(intent);
    */

    Spinner spinner;
    SpinnerAdapter sadapter;
    String[] languages;
    int[] images;
    SQLiteHelper sqLiteHelper;
    String currentLanguage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);
        sqLiteHelper = new SQLiteHelper(this);
        spinner = (Spinner) findViewById(R.id.spinner);
        languages = this.getResources().getStringArray(R.array.spinnerChoices);
        images = new int[]{R.drawable.british_flag, R.drawable.spanish_flag, R.drawable.german_flag};
        currentLanguage = languages[0];
        sadapter = new com.example.projekt.SpinnerAdapter(this, languages, images);

            spinner.setOnItemSelectedListener(this);
            spinner.setAdapter(sadapter);

        final Intent intent = new Intent(this, InstructionActivity.class);
        FloatingActionButton instructionButton = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        instructionButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });

        /*Button buttonFurniture = findViewById(R.id.buttonFurniture);
        Button buttonClothes = findViewById(R.id.buttonClothes);
        Button buttonVegetables = findViewById(R.id.buttonVegetables);
        Button buttonFruits = findViewById(R.id.buttonFruits);
        Button buttonBody = findViewById(R.id.buttonBody);
        Button buttonTransport = findViewById(R.id.buttonTransport);*/

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return true;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        currentLanguage = parent.getItemAtPosition(position).toString();
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

}