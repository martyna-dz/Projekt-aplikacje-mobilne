package com.example.projekt;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class CategoryCreatorActivity extends Activity {

    EditText editText;
    TextView textView;
    Button button;
    SQLiteHelper sqLiteHelper;
    SQLiteDatabase sq;
    String language;
    String polishWord;
    String foreignWord;
    boolean isCreated = false;
    int categoryId = 6;
    boolean polish = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category_creator_layout);
        editText = (EditText) findViewById(R.id.editText0);
        textView = (TextView) findViewById(R.id.textView0);
        button = (Button) findViewById(R.id.button0);
        sqLiteHelper= new SQLiteHelper(this);
        sq = sqLiteHelper.getWritableDatabase();
        Intent intent = getIntent();
        Bundle extras = getIntent().getExtras();
        language = extras.getString("english");
        textView.setText("Podaj nazwe kategorii");
        editText.setText("");
    }

    public void processInput(View view) {
        if (isCreated == false) {
            String categoryName = String.valueOf(editText.getText());
            sqLiteHelper.insertCategory(sq, categoryName);
            categoryId = sqLiteHelper.getCategoryId(sq, categoryName);
            isCreated = true;
            polish = true;
            textView.setText("Podaj polskie słówko");
            editText.setText("");
        } else {
            if (polish == true) {
                polishWord = String.valueOf(editText.getText());
                polish = false;
                textView.setText("Podaj tłumaczenie");
                editText.setText("");
            } else {
                foreignWord = String.valueOf(editText.getText());
                sqLiteHelper.insertWord(sq, language, categoryId, polishWord, foreignWord);
                polish = true;
                textView.setText("Podaj polskie słówko");
                editText.setText("");
            }
        }
    }



}
