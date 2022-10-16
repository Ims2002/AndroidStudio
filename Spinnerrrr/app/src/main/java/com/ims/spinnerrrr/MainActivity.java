package com.ims.spinnerrrr;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    Spinner sCountry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sCountry = findViewById(R.id.sCountry);

        //cargamos el string-array countryes_array desde el archivo de recursos
        ArrayAdapter<CharSequence> country = ArrayAdapter.createFromResource(this,R.array.countries_array, android.R.layout.simple_spinner_item);

        //establecemos el layout de cada elemento para cuando el spinner esta desplegado
        country.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //establecemos el adaptador creado previamente
        sCountry.setAdapter(country);

    }
}