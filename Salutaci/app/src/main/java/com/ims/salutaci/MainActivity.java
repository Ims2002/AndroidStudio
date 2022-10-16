package com.ims.salutaci;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextInputEditText nom = findViewById(R.id.nom);
        TextInputEditText cognoms = findViewById(R.id.cognom);

        Button salutacio = findViewById(R.id.saluda);
        salutacio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Saluda(String.valueOf(nom.getText()), String.valueOf(cognoms.getText()));
            }
        });
        Saluda(String.valueOf(nom.getText()), String.valueOf(cognoms.getText()));

    }

    public void Saluda(String nom, String cognoms) {

        Toast.makeText(MainActivity.this,"Hola "+nom+cognoms,Toast.LENGTH_SHORT).show();
    }
}