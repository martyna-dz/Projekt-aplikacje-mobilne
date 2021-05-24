package com.example.projekt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
    int[] buttonArray = new int[6];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);
        buttonArray = createButtonArray();
        sqLiteHelper = new SQLiteHelper(this);
        spinner = (Spinner) findViewById(R.id.spinner);
        languages = this.getResources().getStringArray(R.array.spinnerChoices);
        images = new int[]{R.drawable.british_flag, R.drawable.spanish_flag, R.drawable.german_flag};
        currentLanguage = "english";
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
        switch (item.getItemId()) {
            case R.id.info:
                Intent intent = new Intent(this,InfoActivity.class);
                startActivity(intent);
                return true;
            case R.id.progress:
                Intent intent2 = new Intent(this, ProgressActivity.class);
                startActivity(intent2);
                return true;
            case R.id.exit:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        currentLanguage = parent.getItemAtPosition(position).toString();
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

    public int[] createButtonArray() {
        int[] buttonArray = new int[6];
        buttonArray[0] = R.id.buttonFurniture;
        buttonArray[1] = R.id.buttonClothes;
        buttonArray[2] = R.id.buttonVegetables;
        buttonArray[3] = R.id.buttonFruits;
        buttonArray[4] = R.id.buttonBody;
        buttonArray[5] = R.id.buttonTransport;
        return buttonArray;
    }

    public int getButtonCategory(View view) {
        for (int i = 0; i < buttonArray.length; i++) {
            if (findViewById(buttonArray[i]) == view) {
                return i;
            }
        }
        return 0;
    }

    public int getLanguageId(String lang) {
        Log.i("currlang", currentLanguage);
        if (currentLanguage.equals("Angielski")) {
            return 1;
        } else if (currentLanguage.equals("Hiszpański")) {
            return 2;
        } else {
            return 3;
        }
    }


    public void click(View view) {
        int[] val = new int[2];
        Bundle przycisk = new Bundle();
        val = new int[] {getButtonCategory(view), getLanguageId(currentLanguage)};
        przycisk.putIntArray("przycisk", val);
        final Intent intencja = new Intent(this, FlashcardsActivity.class);
        intencja.putExtras(przycisk);
        startActivity(intencja);
    }

}