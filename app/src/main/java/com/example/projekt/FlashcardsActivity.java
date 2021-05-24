package com.example.projekt;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;

public class FlashcardsActivity extends AppCompatActivity {


    TextView text;

    Switch switchDone;
    SQLiteHelper sqLiteHelper;
    ArrayList<Word> words;
    int[]params;
    Word language;
    int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //id, shuffle, Word
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flashcards);
        switchDone = findViewById(R.id.switchDone);
        text = findViewById(R.id.tekst1);
        Bundle bundle = getIntent().getExtras();
        params = bundle.getIntArray("przycisk");
        sqLiteHelper = new SQLiteHelper(this);
        SQLiteDatabase sq = sqLiteHelper.getWritableDatabase();
        words = sqLiteHelper.getWords(sq, setLanguage(), params[0] + 1);
        Collections.shuffle(words);

        index = 0;
        text.setText(words.get(index).polishWord);
        language = words.get(index);
    }

    public String setLanguage() {
        if (params[1] == 1) {
            return "english";
        } else if (params[1] == 2) {
            return "spanish";
        } else {
            return "german";
        }
    }

    public void back(View view) {
        this.finish();
        onBackPressed();
    }

    public void changeLanguage(View view) {

        text = findViewById(R.id.tekst1);
        if (text.getText() == language.polishWord) {
            text.setText(language.foreignWord);
        }
        else text.setText(language.polishWord);
    }


    public void next(View view) {
        index++;
        if (index == 12) {
            //slowka ktore nie sa zapamietane
        } else {
            language = words.get(index);
            text.setText(language.polishWord);
        }
        if (switchDone.isChecked()) {
            //zapis do bazy danych progresu
        }
    }

}