package com.ims.testexamen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.util.Log;

import com.ims.testexamen.parsers.CarParserJson;
import com.ims.testexamen.parsers.CarParserXML;

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

        tablet = findViewById(R.id.frgDetalle)!=null;
        if (tablet) {
            FragmentManager manager = getSupportFragmentManager();
            fragmentDetalle = (FragmentDetalle) manager.findFragmentById(R.id.frgDetalle);
        }
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
}