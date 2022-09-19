package com.ims.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //usar siempre R.id.nombreCualquiera xq se puede cambiar solo el numero de base
        //y en caso de poner el número el programa dejaría de funcionar

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        /*TextView tvSaludo = findViewById(R.id.textView);
        tvSaludo.setText("Esto es una prueba");*/
        //mensajer de depuracion, informativos, errores... LOGCAT!
        //Log.e(getClass().getSimpleName(), "Error Falso");

        button = findViewById(R.id.ImaButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity2();
            }
        });

        }
    private void openActivity2() {
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }
}