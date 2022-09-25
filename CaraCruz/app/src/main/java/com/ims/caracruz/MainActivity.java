package com.ims.caracruz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.ims.caracruz.Livs.Lib;

public class MainActivity extends AppCompatActivity {
    int numRandom;
    Button cara;
    Button cruz;
    ImageView imgcara;
    ImageView imgcruz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button next = findViewById(R.id.next);

        cara = findViewById(R.id.cara);
        cruz = findViewById(R.id.creu);

        imgcruz= findViewById(R.id.imgcruz);
        imgcara = findViewById(R.id.imgcara);

        imgcara.setVisibility(View.INVISIBLE);
        imgcruz.setVisibility(View.INVISIBLE);

        numRandom = Lib.aleatorio(1,2);

        elegirCaraCruz(numRandom);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(getIntent());
            }
        });

    }

    private void elegirCaraCruz(int numRandom) {
        TextView resultat = findViewById(R.id.resultat);
        cara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(numRandom == 1) {
                    imgcara.setVisibility(View.VISIBLE);
                    resultat.setText("Has guanyat!!");

                } else {
                    imgcruz.setVisibility(View.VISIBLE);
                    resultat.setText("Looooser");
                }

            }
        });

        cruz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(numRandom == 2) {
                    imgcruz.setVisibility(View.VISIBLE);
                    resultat.setText("Has guanyat!!");

                } else {
                    imgcara.setVisibility(View.VISIBLE);
                    resultat.setText("Looooser");
                }
            }
        });
    }



}