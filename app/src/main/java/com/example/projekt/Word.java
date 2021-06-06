package com.example.projekt;

public class Word {
    String foreignWord;
    String polishWord;
    int category;
    String progress;
    int id;

    Word (String foreignWord, String polishWord, int category, String progress, int id) {
        this.foreignWord = foreignWord;
        this.polishWord = polishWord;
        this.category = category;
        this.progress = progress;
        this.id = id;
    }

    public String getProgress() {
        return this.progress;
    }

    public void setProgress(String p) {
        this.progress = p;
    }
}
