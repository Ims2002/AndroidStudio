package com.ims.factorial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button calcular = findViewById(R.id.calcula);
        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextInputEditText numeroCalc = findViewById(R.id.num1);
                int num = calculaFactorial(Integer.parseInt(String.valueOf(numeroCalc.getText())));
                TextView resultado = findViewById(R.id.resultado);
                resultado.setText(String.valueOf(num));
            }
        });

    }

    public int calculaFactorial(int num) {
        if (num==0)
            return 1;
        else
            return num * calculaFactorial(num-1);
    }

}