package com.example.projekt;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
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
    SQLiteDatabase sq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flashcards);
        switchDone = findViewById(R.id.switchDone);
        text = findViewById(R.id.tekst1);
        Bundle bundle = getIntent().getExtras();
        params = bundle.getIntArray("przycisk");
        sqLiteHelper = new SQLiteHelper(this);
        sq = sqLiteHelper.getWritableDatabase();
        words = sqLiteHelper.getWords(sq, setLanguage(), params[0] + 1);
        Collections.shuffle(words);
        myShuffle();

        index = 0;
        text.setText(words.get(index).polishWord);
        language = words.get(index);
        if (words.get(index).progress.equals("1")) {
            switchDone.setChecked(true);
        }
    }

    public void myShuffle() {
        ArrayList<Word> newWords = new ArrayList<>();
        for (int i = 0; i < words.size(); i++) {
            if (words.get(i).progress.equals("0")) {
                newWords.add(0, words.get(i));
            } else {
                newWords.add(words.get(i));
            }
        }
        words = newWords;
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

        index++; //krok 2

        if (switchDone.isChecked()) {
            sqLiteHelper.changeProgress(sq, setLanguage(), words.get(index-1).id);
            switchDone.setChecked(false);
        } else {
            sqLiteHelper.changeProgressZero(sq, setLanguage(), words.get(index-1).id);
        }

        if (index == sqLiteHelper.getNumberOfWords(sq, words.get(0).category, setLanguage())) {
            this.finish();
            onBackPressed();
        } else {
            language = words.get(index);
            text.setText(language.polishWord);
            if (words.get(index).progress.equals("1")) {
                switchDone.setChecked(true);
            }
        }

    }

}