package com.ims.twogamestoolbar;

import android.content.Context;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
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



}
