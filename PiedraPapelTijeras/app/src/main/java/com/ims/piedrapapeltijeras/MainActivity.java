package com.ims.piedrapapeltijeras;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.ims.piedrapapeltijeras.Libs.Lib;

public class MainActivity extends AppCompatActivity {

    private int numRandom;
    ImageButton rock;
    ImageButton paper;
    ImageButton scissors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rock = findViewById(R.id.rock);
        paper = findViewById(R.id.paper);
        scissors = findViewById(R.id.scissors);

        numRandom = Lib.aleatorio(1,3);

        jugar(numRandom);

    }

    private void jugar(int numRandom) {
        rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(numRandom == 1) {
                    Toast.makeText(MainActivity.this,"Has acertado",Toast.LENGTH_SHORT).show();
                } else {
                    hideImages(numRandom);
                }
            }
        });

        paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(numRandom == 2) {
                    Toast.makeText(MainActivity.this,"Has acertado",Toast.LENGTH_SHORT).show();
                } else {
                    hideImages(numRandom);
                }
            }
        });

        scissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(numRandom == 3) {
                    Toast.makeText(MainActivity.this,"Has acertado",Toast.LENGTH_SHORT).show();
                }else {
                    hideImages(numRandom);
                }
            }
        });
    }
    public void hideImages(int num) {
        if(numRandom == 1) {
            scissors.setVisibility(View.INVISIBLE);
            paper.setVisibility(View.INVISIBLE);
            Toast.makeText(MainActivity.this,"La opcion correcta era piedra",Toast.LENGTH_SHORT).show();
        } else if (numRandom == 2) {
            rock.setVisibility(View.INVISIBLE);
            scissors.setVisibility(View.INVISIBLE);
            Toast.makeText(MainActivity.this, "La opcion correcta era papel", Toast.LENGTH_SHORT).show();
        } else {
            rock.setVisibility(View.INVISIBLE);
            paper.setVisibility(View.INVISIBLE);
            Toast.makeText(MainActivity.this,"La opcion correcta era tijeras",Toast.LENGTH_SHORT).show();
        }
    }
}