package com.ims.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.VideoView;

public class MainActivity2 extends AppCompatActivity {
    ImageButton clk;
    VideoView vv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        clk = (ImageButton) findViewById(R.id.closeButton);
        clk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickBackButton();
            }
        });
        //vv = (VideoView) findViewById(R.id.videoPlay);
    }

    public void clickBackButton() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
/*
    public void videoPlay(View v) {
        String videoPath = "android.resource://com.ims.helloworld/"+R.raw.;
        Uri uri = Uri.parse(videoPath);
        vv.setVideoURI(uri);
        vv.start();
    }*/
}