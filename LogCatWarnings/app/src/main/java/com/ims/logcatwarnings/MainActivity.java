package com.ims.logcatwarnings;
//5.0 16 coretto
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Log.d("Test","Test Log");

        String TAG = "First Log";
        Log.d(TAG,"My First Log Message");*/
    }

    /*@Override
    protected void onCreate() {
        super.onCreate();
    }*/

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Pause","La app se ha pausado");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Stop","Se ha cerrado la app");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Start","Se ha iniciado la app");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Restart","Se ha reiniciado la app");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Resume", "La app ha vuelto a funcionar");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Destroy", "El sistena ha finalizado o destruido la app");
    }
}