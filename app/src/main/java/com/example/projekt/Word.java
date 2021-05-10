package com.example.projekt;

public class Word {
    String foreignWord;
    String polishWord;
    int category;

    Word (String foreignWord, String polishWord, int category) {
        this.foreignWord = foreignWord;
        this.polishWord = polishWord;
        this.category = category;
    }
}
