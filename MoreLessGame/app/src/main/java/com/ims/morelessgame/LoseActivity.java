package com.ims.morelessgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class LoseActivity extends AppCompatActivity {

    ImageButton clk;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lose);
        tv = findViewById(R.id.loses);
        tv.setText("Loses: "+MainActivity.loses);
        clk = findViewById(R.id.backbtL);
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