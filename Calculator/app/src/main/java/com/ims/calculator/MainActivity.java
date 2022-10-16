package com.ims.calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



   Button bt1;Button bt2;Button bt3;Button bt4;Button bt5;
   Button bt6;Button bt7;Button bt8;Button bt9;Button div;
   Button x;Button plus; Button min; Button mod;Button bt0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iniciarButtons();
        onClickPocho();
        //tv = findViewById(R.id.calculate);

    }

    private void iniciarButtons() {
        bt0 = findViewById(R.id.bt0);
        bt1 = findViewById(R.id.bt1);
        bt2 = findViewById(R.id.bt2);
        bt3 = findViewById(R.id.bt3);
        bt4 = findViewById(R.id.bt4);
        bt5 = findViewById(R.id.bt5);
        bt6 = findViewById(R.id.bt6);
        bt7 = findViewById(R.id.bt7);
        bt8 = findViewById(R.id.bt8);
        bt9 = findViewById(R.id.bt9);
        div = findViewById(R.id.btDiv);
        x = findViewById(R.id.btX);
        plus = findViewById(R.id.btPlus);
        min = findViewById(R.id.btMin);
        mod = findViewById(R.id.btMod);

    }

    private void onClickPocho() {
        TextView tv = findViewById(R.id.calculate);
        bt0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BotonNumero.choiceNum(tv, 0);
            }
        });
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BotonNumero.choiceNum(tv, 1);
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BotonNumero.choiceNum(tv, 2);
            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BotonNumero.choiceNum(tv, 3);
            }
        });
        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BotonNumero.choiceNum(tv, 4);
            }
        });
        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BotonNumero.choiceNum(tv, 5);
            }
        });
        bt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BotonNumero.choiceNum(tv, 6);
            }
        });
        bt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BotonNumero.choiceNum(tv, 7);
            }
        });
        bt8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BotonNumero.choiceNum(tv, 8);
            }
        });
        bt9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BotonNumero.choiceNum(tv, 9);
            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BotonUtilidad.printDiv(tv);
            }
        });
        x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BotonUtilidad.X(tv);
            }
        });
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BotonUtilidad.printPlus(tv);
            }
        });
        min.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BotonUtilidad.printMin(tv);
            }
        });
        mod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BotonUtilidad.printMod(tv);
            }
        });


    }
/*
    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.bt1:
                Toast.makeText(this,"bt1",Toast.LENGTH_LONG);
                BotonNumero.choiceNum(tv,1);
                break;
            case R.id.bt2:
                BotonNumero.choiceNum(tv,2);
                break;
            case R.id.bt3:
                BotonNumero.choiceNum(tv,3);
                break;
            case R.id.bt4:
                BotonNumero.choiceNum(tv,4);
                break;
            case R.id.bt5:
                BotonNumero.choiceNum(tv,5);
                break;
            case R.id.bt6:
                BotonNumero.choiceNum(tv,6);
                break;
            case R.id.bt7:
                BotonNumero.choiceNum(tv,7);
                break;
            case R.id.bt8:
                BotonNumero.choiceNum(tv,8);
                break;
            case R.id.bt9:
                BotonNumero.choiceNum(tv,9);
                break;
            case R.id.btAC:

                break;
            case R.id.btDiv:
                BotonUtilidad.printDiv(tv);
                break;
            case R.id.btPlus:
                BotonUtilidad.printPlus(tv);
                break;
            case R.id.btMod:
                BotonUtilidad.printMod(tv);
                break;
            case R.id.btMin:
                BotonUtilidad.printMin(tv);
                break;
            case R.id.btX:
                BotonUtilidad.X(tv);
                break;
            case R.id.btEq:
                break;
        }
    }
*/

}