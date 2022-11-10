package com.germangascon.toolbar;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
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
        if(id == R.id.action_saluda) {
            Toast.makeText(this, R.string.hello, Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.action_settings) {
            Toast.makeText(this, R.string.settings, Toast.LENGTH_SHORT).show();
            return true;
        } else
            return super.onOptionsItemSelected(item);
    }
}
