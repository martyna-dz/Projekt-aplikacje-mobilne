package com.example.projekt;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class SQLiteHelper extends SQLiteOpenHelper {

    contentInterface content = new Content();
    ArrayList<String> categories = content.getCategoriesList();
    ArrayList<String> polish = content.getPolishWordsList();
    ArrayList<String> english = content.getEnglishWordsList();
    ArrayList<String> spanish = content.getSpanishWordsList();
    ArrayList<String> german = content.getGermanWordsList();

    public SQLiteHelper(Context context) {
        super(context, "nauka_slowek.db", null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table english (id integer PRIMARY KEY AUTOIncrement, category integer, polishWord text, foreignWord text)");
        db.execSQL("create table spanish (id integer PRIMARY KEY AUTOIncrement, category integer, polishWord text, foreignWord text)");
        db.execSQL("create table german (id integer PRIMARY KEY AUTOIncrement, category integer, polishWord text, foreignWord text)");
        db.execSQL("create table categories (id integer PRIMARY KEY AUTOIncrement, name text)");
        fillTables(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS english");
        db.execSQL("DROP TABLE IF EXISTS spanish");
        db.execSQL("DROP TABLE IF EXISTS german");
        db.execSQL("DROP TABLE IF EXISTS categories");
        onCreate(db);
    }

    public void insertCategory(SQLiteDatabase db, String name) {
        String query = "insert into categories (name) values ('" +
                name + "')";
        db.execSQL(query);
    }

    public void insertWord(SQLiteDatabase db, String tableName, int category, String polishWord, String foreignWord) {
        String query = "insert into " + tableName + " (category, polishWord, foreignWord) values (" +
                category + ", '" + polishWord + "', '" + foreignWord + "')";
        db.execSQL(query);
    }

    public void fillTables(SQLiteDatabase db) {
        for (int i = 0; i < categories.size(); i++) {
            insertCategory(db, categories.get(i));
        }

        for (int i = 0; i < categories.size(); i++) {
            for (int j = 0; j < 12; j++) {
                insertWord(db, "english", i+1, polish.get(i*12 + j), english.get(i*12 + j));
                insertWord(db, "spanish", i+1, polish.get(i*12 + j), spanish.get(i*12 + j));
                insertWord(db, "german", i+1, polish.get(i*12 + j), german.get(i*12 + j));
            }
        }
    }

    public ArrayList<Word> getWords(SQLiteDatabase db, String tableName, int category) {
        ArrayList<Word> words= new ArrayList<>();
        String query = "SELECT * FROM " + tableName + " WHERE category = " + category;
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();
        while (cursor.isAfterLast() == false) {
            words.add(new Word(cursor.getString(3), cursor.getString(2), cursor.getInt(1)));
            cursor.moveToNext();
        }
        return words;
    }

}
