package com.ims.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

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
    }
}