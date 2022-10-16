package com.ims.contacts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Parser parser = new Parser(this);
        if(parser.parse())
            Toast.makeText(this,"TodoOk",Toast.LENGTH_LONG).show();
        Toast.makeText(this,"F",Toast.LENGTH_SHORT).show();
    }
}