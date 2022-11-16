package com.ims.twogamestoolbar;

import android.content.Context;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class WordsParser {

    private final InputStream wordsFile;
    private Context c;
    private List<String> words;

    public WordsParser(Context c) throws IOException {
        this.wordsFile = c.getResources().openRawResource(R.raw.words_es);
    }

    public boolean parse() throws IOException {
        Reader reader = new InputStreamReader(wordsFile);
        BufferedReader readerB = new BufferedReader(reader);
        words = new ArrayList<>();
        String word;
        while(readerB.readLine()!=null) {
            word = readerB.readLine();
            words.add(word);
        }
        if(words == null) {
            return false;
        }
        return true;
    }

    public List<String> getWords() {
        return words;
    }
}
