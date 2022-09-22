package com.ims.morelessgame;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class WinActivity extends AppCompatActivity {

    ImageButton clk;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);
        tv = findViewById(R.id.winStreak);
        tv.setText("Wins: "+ MainActivity.wins);
        clk = findViewById(R.id.backbt);
        clk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickBackButton();
            }
        });
    }

    private void clickBackButton() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}