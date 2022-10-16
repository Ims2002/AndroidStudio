package com.ims.fileview;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lvCountries = findViewById(R.id.lvCountries);
        Parser parser = new Parser(this);

        if(parser.parse()) {
            Country[] countries = parser.getCountries();
            Optimizaciones adapter = new Optimizaciones(this,countries);
            lvCountries.setAdapter(adapter);
        }else
            Toast.makeText(this, "No se pudieron obtener los datos de los países", Toast.LENGTH_SHORT).show();
    }
}