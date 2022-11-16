package com.ims.twogamestoolbar;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.ims.twogamestoolbar.fragments.FragmentHangman;
import com.ims.twogamestoolbar.fragments.FragmentTicTacToe;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    FragmentManager manager = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Toolbar toolbar = findViewById(R.id.appbar);
        setSupportActionBar(toolbar);
        Button bShowHide = findViewById(R.id.bShowHide);
        bShowHide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActionBar actionBar = getSupportActionBar();
                assert actionBar != null;
                if(actionBar.isShowing()) {
                    bShowHide.setText(R.string.show_bar);
                    actionBar.hide();
                } else {
                    bShowHide.setText(R.string.hide_bar);
                    actionBar.show();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Cambio switch por if para contentar a Google
        int id = item.getItemId();
        if(id == R.id.action_hangman) {
            //Toast.makeText(this, R.string.hello, Toast.LENGTH_SHORT).show();
            manager.beginTransaction()
                    .addToBackStack(null)
                    .replace(R.id.frgDefault, FragmentHangman.class, null)
                    .commit();
            return true;
        } else if (id == R.id.action_tic_tac_toe) {
            manager.beginTransaction()
                    .addToBackStack(null)
                    .replace(R.id.frgDefault, FragmentTicTacToe.class, null)
                    .commit();
            return true;
        } else
            return super.onOptionsItemSelected(item);
    }
}