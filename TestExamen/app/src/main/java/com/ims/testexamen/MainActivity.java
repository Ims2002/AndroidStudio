package com.ims.testexamen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import com.ims.testexamen.parsers.CarParserJson;

public class MainActivity extends AppCompatActivity implements FragmentListado.IOnAttachListener, FragmentDetalle.IOnAttachListener, IOnClickListener {

    private static final String SELECTED_CAR_KEY = "com.ims.testexamen.cars";
    private static final String CARS_KEY = "com.ims.testexamen.car";
    private Car[] cars;
    private Car selectedCar;
    private FragmentDetalle fragmentDetalle;
    private boolean tablet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if(savedInstanceState != null) {
            cars = (Car[]) savedInstanceState.getSerializable(CARS_KEY);
            selectedCar = (Car) savedInstanceState.getSerializable(SELECTED_CAR_KEY);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //La toolbar esta implementada de modo que al hacer click en un item del listado se mantiene
        //en el caso de querer cambiar los datos de los items de la toolbar, se cambiarian desde el
        //main_menu.xml añadiendo items y aplicandoles funcionalidad en el metodo onOptionsItemSelected
        Toolbar toolbar = findViewById(R.id.tbAppBar);
        setSupportActionBar(toolbar);

        Button btCompartir = findViewById(R.id.btShare);
        btCompartir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compartirApp();
            }
        });

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



        tablet = findViewById(R.id.frgDetalle)!=null;
        if (tablet) {
            FragmentManager manager = getSupportFragmentManager();
            fragmentDetalle = (FragmentDetalle) manager.findFragmentById(R.id.frgDetalle);
        }
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


    private void cargarDatos() {
        CarParserJson json = new CarParserJson(this);
        //CarParserXML xml = new CarParserXML(this);

        if (json.parse()) {
            cars = json.getCars();

        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putSerializable(CARS_KEY,cars);
        outState.putSerializable(SELECTED_CAR_KEY,selectedCar);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onClick(int position) {
        selectedCar = cars[position];
        if (tablet) {
            Car car = selectedCar;
            setTitle(car.getCarCode()+car.getCarName());
            fragmentDetalle.mostrarDetalle(car);
        }else {
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction()
                    .addToBackStack(null)
                    .setReorderingAllowed(true)
                    .replace(R.id.frgListado,FragmentDetalle.class,null)
                    .commit();
        }
    }

    @Override
    public Car getCar() {
        if(cars == null) {
            cargarDatos();
        }
        if (selectedCar == null) {
            selectedCar = cars[0];
        }

        Car car = selectedCar;
        setTitle(car.getCarCode()+car.getCarName());
        return car;
    }

    @Override
    public Car[] getCars() {
        if(cars == null) {
            cargarDatos();
        }
        return cars;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        setTitle(R.string.app_name);
    }

    private void compartirApp() {
        try {
            Intent i = new Intent(Intent.ACTION_SEND);
            i.setType("text/plain");
            i.putExtra(Intent.EXTRA_SUBJECT,getResources().getString(R.string.app_name));
            String aux = "Descarga la app\n";
            //aux = aux + "https://play.google.com/store/apps/details?id="+getBaseContext().getPackageName();
            aux = aux+"https://play.google.com/store/apps/details?id=com.ims.testexamen";
            i.putExtra(Intent.EXTRA_TEXT,aux);
            startActivity(i);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}