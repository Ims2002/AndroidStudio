package com.ims.morelessgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.ims.morelessgame.Libs.Lib;

public class MainActivity extends AppCompatActivity {
    int numeroRandom;
    final int INTENTOSMAX = 3;
    int intentos = INTENTOSMAX;

    Button bt1;Button bt2;Button bt3;
    Button bt4;Button bt5;Button bt6;
    Button bt7;Button bt8;Button bt9;
    Button bt10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iniciarButtons();
        numeroRandom = Lib.aleatorio(1,10);
        intentoNumeros();
    }

    private void iniciarButtons() {
        bt1 = findViewById(R.id.bt1);
        bt2 = findViewById(R.id.bt2);
        bt3 = findViewById(R.id.bt3);
        bt4 = findViewById(R.id.bt4);
        bt5 = findViewById(R.id.bt5);
        bt6 = findViewById(R.id.bt6);
        bt7 = findViewById(R.id.bt7);
        bt8 = findViewById(R.id.bt8);
        bt9 = findViewById(R.id.bt9);
        bt10 = findViewById(R.id.bt10);
    }

    private void intentoNumeros() {
        TextView tv1 = findViewById(R.id.tv1);
        for (int i = intentos; i>0; i--) {
            tv1.setText("Intentos Restantes: "+ intentos);

            bt1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (numeroRandom == 1) {
                        ToastWin();
                    }
                    else
                        ToastMayor();

                }
            });
            bt2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (numeroRandom == 2)
                        ToastWin();
                    else if (numeroRandom > 2)
                        ToastMayor();
                    else
                        ToastMenor();
                }
            });
            bt3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (numeroRandom == 3)
                        ToastWin();
                    else if (numeroRandom > 3)
                        ToastMayor();
                    else
                        ToastMenor();
                }
            });
            bt4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (numeroRandom == 4) {
                        ToastWin();
                    } else if (numeroRandom > 4)
                        ToastMayor();
                    else
                        ToastMenor();
                }
            });
            bt5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (numeroRandom == 5)
                        ToastWin();
                    else if (numeroRandom > 5)
                        ToastMayor();
                    else
                        ToastMenor();
                }
            });
            bt6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (numeroRandom == 6)
                        ToastWin();
                    else if (numeroRandom > 6)
                        ToastMayor();
                    else
                        ToastMenor();
                }
            });
            bt7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (numeroRandom == 7)
                        ToastWin();
                    else if (numeroRandom > 7)
                        ToastMayor();
                    else
                        ToastMenor();
                }
            });
            bt8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (numeroRandom == 8)
                        ToastWin();
                    else if (numeroRandom > 8)
                        ToastMayor();
                    else
                        ToastMenor();
                }
            });
            bt9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (numeroRandom == 9)
                        ToastWin();
                    else if (numeroRandom > 9)
                        ToastMayor();
                    else
                        ToastMenor();
                }
            });
            bt10.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (numeroRandom == 10)
                        ToastWin();
                    else
                        ToastMenor();
                }
            });
        }
    }

    public void ToastMayor(){
        Toast.makeText(MainActivity.this,"El numero es mayor",Toast.LENGTH_SHORT).show();
        intentos--;
        if (intentos!=0)
            intentoNumeros();
    }

    public void ToastMenor() {
        Toast.makeText(MainActivity.this,"El numero es menor",Toast.LENGTH_SHORT).show();
        intentos--;
        if (intentos!=0)
            intentoNumeros();
    }

    public void ToastWin() {
        Toast.makeText(MainActivity.this,"Has acertado!",Toast.LENGTH_SHORT).show();
        intentos = 0;

    }

}