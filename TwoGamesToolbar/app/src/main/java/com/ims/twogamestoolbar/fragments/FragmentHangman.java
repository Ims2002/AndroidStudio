package com.ims.twogamestoolbar.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ims.twogamestoolbar.R;
import com.ims.twogamestoolbar.WordsParser;

import java.io.IOException;
import java.util.List;
import java.util.Random;

public class FragmentHangman extends Fragment {

    Button btTry;TextView tvUsedLetters;
    ImageView ivHangedMan;EditText ptLetter;
    TextView tvTries; TextView tvWord; TextView tvCurrentTries;

    private char[] chosenWordLetters;
    private String chosenWord;
    private String separatedWord;
    private String chosenLetter;
    private int tries = 6;
    private List<String> words;

    public FragmentHangman() {
        super(R.layout.fragment_hangman);

    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvCurrentTries = view.findViewById(R.id.tvCurrentTries);
        btTry = view.findViewById(R.id.btTryLetter);
        ivHangedMan = view.findViewById(R.id.ivHangedMan);
        tvUsedLetters = view.findViewById(R.id.tvUsedLetters);
        tvTries = view.findViewById(R.id.tvTries);
        ptLetter = view.findViewById(R.id.ptTriedLetter);
        tvWord = view.findViewById(R.id.tvWord);
        try {
            WordsParser parser = new WordsParser(view.getContext());
            parser.parse();
            words = parser.getWords();
            startGame();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void startGame() {
        restartValues();
        chosenWord = chooseRandomWord();
        separatedWord = concatWord(chosenWord.length());
        String variableWord = separatedWord;
        tvWord.setText(separatedWord);
        btTry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /** TODO
                 * Hacer restart de toda la info cuando se ejecuta el startGame
                 * funciona mal el update de letras que existen
                 * funciona mal si la letra existe
                 */
                if(tries == 0) {
                    Toast.makeText(getContext(),"HAS GANADO!",Toast.LENGTH_LONG).show();
                    startGame();
                }
                if (tries == 6) {
                    tvWord.setText(separatedWord);
                }
                chosenLetter = ptLetter.getText().toString();

                if(chosenWord.contains(chosenLetter)) {
                    StringBuilder b = new StringBuilder();
                    chosenWordLetters = chosenWord.toCharArray();
                    for(int i = 0;i<chosenWord.length();i++) {
                        //letter match
                        if (chosenWordLetters[i]==chosenLetter.charAt(0)) {
                            tvWord.setText(concatWord(chosenWord.length(),chosenLetter));
                            //concatWord(separatedWord,chosenLetter)
                            /*String replacedWord = separatedWord.replace(separatedWord.charAt(i),chosenLetter.charAt(0));
                            //b.setCharAt(i,chosenLetter.charAt(0));
                            tvWord.setText(replacedWord);*/
                        }
                    }
                } else {
                    tries--;
                    tvCurrentTries.setText(String.valueOf(tries));
                    String imgName = "hangman_"+tries;
                    String currentLetters = tvUsedLetters.getText().toString();
                    tvUsedLetters.setText(currentLetters.concat(chosenLetter+" "));
                    int resID = getContext().getResources().getIdentifier(imgName,"drawable",getContext().getPackageName());
                    ivHangedMan.setImageResource(resID);
                }
            }
        });
    }

    private void restartValues() {
        chosenWordLetters = null;
        chosenWord = null;
        separatedWord = null;
        chosenLetter = null;
        tvUsedLetters.setText("");
        tries = 6;
    }

    private String concatWord(int length, CharSequence c) {
        StringBuilder builder = new StringBuilder();
        char currentLetter = c.charAt(0);
        for (int i = 0;i<length;i++) {
            if (chosenWord.toCharArray()[i]==currentLetter) {
                builder.append(currentLetter);
            } else
                builder.append("_ ");
        }
        return builder.toString();
    }

    private String concatWord(String s, CharSequence c) {
        StringBuilder builder = new StringBuilder();
        builder.append(s);
        char currentLetter = c.charAt(0);

        for (int i = 0;i<s.length();i++) {
            if (chosenWord.toCharArray()[i]==currentLetter) {
                builder.replace(builder.charAt(i),builder.charAt(i), s);
            } else
                builder.append(" _");
        }
        Log.w("BUILDER RESULT",builder.toString());
        return builder.toString();
    }


    public String concatWord(int length) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0;i<length;i++) {
            builder.append(" _");
        }
        return builder.toString();
    }


    private String chooseRandomWord() {
        Random rnd = new Random();
        return words.get(rnd.nextInt(words.size()));
    }

}
