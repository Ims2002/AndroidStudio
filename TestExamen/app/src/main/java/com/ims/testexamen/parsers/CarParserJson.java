package com.ims.testexamen.parsers;

import android.content.Context;
import android.util.Log;

import com.ims.testexamen.Car;
import com.ims.testexamen.R;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.InputStream;

public class CarParserJson {
    /** Array que contendrá los objetos Contacto */
    private Car[] cars;
    /** InputStream para poder leer del archivo contacts.json */
    private final InputStream carsFile;

    /** Al constructor le pasamos el contexto para que pueda tener acceso a los recursos de la aplicación */
    public CarParserJson(Context c) {
        /* Obtenemos una referencia al archivo /res/raw/contact.json */
        this.carsFile = c.getResources().openRawResource(R.raw.testjson);
    }

    /**
     * Obtiene los datos de los países desde un archivo xml mediante DOM,
     * y los carga en el array countries.
     * @return boolean Devuelve verdadero si ha ido bien. False en caso contrario.
     */
    public boolean parse() {
        /* Parsed controla si se han podido parsear los datos. Inicialmente a false */
        boolean parsed = false;
        String json = null;
        /* Inicializamos a null el array de contactos */
        cars = null;

        try {

            int size = carsFile.available();
            byte[] buffer = new byte[size];
            carsFile.read(buffer);
            carsFile.close();
            json = new String(buffer, "UTF-8");
            JSONTokener tokener = new JSONTokener(json);
            JSONArray jsonArray = new JSONArray(tokener);
            /* Inicializamos el array con el tamaño del array en el JSON */
            cars = new Car[jsonArray.length()];

            for(int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                String carCode = jsonObject.getString("carCode");
                String carName = jsonObject.getString("carName");
                String km = String.valueOf(jsonObject.getInt("km"));
                String fabricadoEn = jsonObject.getString("fabricadoEn");

                cars[i] = new Car(carCode, carName, km, fabricadoEn);
            }
            /* Si hemos llegado hasta aquí, podemos asegurar que el documento json ha sido parseado correctamente */
            parsed = true;
        } catch (Exception e) {
            Log.e("CountryParser", "Unknown Exception: "+e.getLocalizedMessage());
        }
        return parsed;
    }

    /**
     * Devuelve la lista de contactos
     * @return Contacto[]
     */
    public Car[] getCars() {
        return this.cars;
    }
}
