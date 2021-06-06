package com.example.projekt;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class SQLiteHelper extends SQLiteOpenHelper {

    ContentInterface content = new Content();
    ArrayList<String> categories = content.getCategoriesList();
    ArrayList<String> polish = content.getPolishWordsList();
    ArrayList<String> english = content.getEnglishWordsList();
    ArrayList<String> spanish = content.getSpanishWordsList();
    ArrayList<String> german = content.getGermanWordsList();

    public SQLiteHelper(Context context) {
        super(context, "nauka_slowek2.db", null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table english (id integer PRIMARY KEY AUTOIncrement, category integer, polishWord text, foreignWord text, progress text)");
        db.execSQL("create table spanish (id integer PRIMARY KEY AUTOIncrement, category integer, polishWord text, foreignWord text, progress text)");
        db.execSQL("create table german (id integer PRIMARY KEY AUTOIncrement, category integer, polishWord text, foreignWord text, progress text)");
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
        String query = "insert into " + tableName + " (category, polishWord, foreignWord, progress) values (" +
                category + ", '" + polishWord + "', '" + foreignWord + "', '" + 0 + "')";
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
            words.add(new Word(cursor.getString(3), cursor.getString(2), cursor.getInt(1), cursor.getString(4), cursor.getInt(0)));
            //words.get(words.size() - 1).progress
            cursor.moveToNext();
        }
        return words;
    }

    public int getCategoryId(SQLiteDatabase db, String name) {
        String query = "Select id from categories where name = \"" + name + "\"";
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();
        return cursor.getInt(0);
    }

    public void changeProgress(SQLiteDatabase db, String language, int id) {
        String query = "Update " + language + " set progress = '1' where id = " + id;
        db.execSQL(query);
    }

    public void changeProgressZero(SQLiteDatabase db, String language, int id) {
        String query = "Update " + language + " set progress = '0' where id = " + id;
        db.execSQL(query);
    }

    public int getSum(SQLiteDatabase db, int category, String language) {
        String query = "Select sum(progress) from " + language + " where category = " + category;
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();
        return cursor.getInt(0);
    }

    public int getNumberOfWords(SQLiteDatabase db, int category, String language) {
        String query = "Select count(progress) from " + language + " where category = " + category;
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();
        return cursor.getInt(0);
    }

    public void resetProgress(SQLiteDatabase db) {
        String query = "Update english set progress = '0'";
        db.execSQL(query);
        query = "Update spanish set progress = '0'";
        db.execSQL(query);
        query = "Update german set progress = '0'";
        db.execSQL(query);
    }

    public String[] getCategories(SQLiteDatabase db) {
        ArrayList<String> categories= new ArrayList<>();
        String query = "SELECT * FROM categories";
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();
        while (cursor.isAfterLast() == false) {
            categories.add(cursor.getString(1));
            cursor.moveToNext();
        }
        return categories.toArray(new String[0]);
    }

}
