package com.ims.gridviewcountry;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gvCountries = findViewById(R.id.gvCountries);
        CountryParser parser = new CountryParser(this);

        if(parser.parse()) {
            Country[] countries = parser.getCountries();
            CountryAdapter adapter = new CountryAdapter(this,countries);
            gvCountries.setAdapter(adapter);
        }else {
            Toast.makeText(this, "No se pudieron obtener los datos de los países", Toast.LENGTH_SHORT).show();
        }
    }
}