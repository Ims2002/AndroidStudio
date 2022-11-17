package com.ims.testexamen.parsers;


import android.content.Context;

import com.ims.testexamen.Car;
import com.ims.testexamen.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.Iterator;


/*public class ArrayInto {

    private Car[] cars;
    private Detail[] car;
    //tendria un calse detail con 2 strings para meter los datos del array
    /** InputStream para poder leer del archivo contacts.json */
    /*private final InputStream carsFile;

    /** Al constructor le pasamos el contexto para que pueda tener acceso a los recursos de la aplicación */
    /*public ArrayInto(Context c) throws JSONException, IOException {
        /* Obtenemos una referencia al archivo /res/raw/contact.json */
        /*this.carsFile = c.getResources().openRawResource(R.raw.testjson);
    }
    /* Parsed controla si se han podido parsear los datos. Inicialmente a false */
    /*public boolean parse() {
        boolean parsed = false;
        String json = null;
        /* Inicializamos a null el array de contactos */
        /*cars = null;

        try {

            int size = carsFile.available();
            byte[] buffer = new byte[size];
            carsFile.read(buffer);
            carsFile.close();
            json = new String(buffer, "UTF-8");
            JSONTokener tokener = new JSONTokener(json);
            JSONArray jsonArray = new JSONArray(tokener);
            cars = new Car[jsonArray.length()];
            //Object obj = parser.parse(new FileReader("c:\\file.json"));
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                String name = (String) jsonObject.get("name");
                String city = (String) jsonObject.get("city");
                String job = (String) jsonObject.get("job");
                // loop array
                JSONArray arrayNotas = jsonObject.getJSONArray("notas");
               /* ArrayIntoCars[] detail = new ArrayIntoCars[arrayNotas.length()];
                for(int j = 0;j<arrayNotas.length();j++) {
                    //notas = new Nota[arrayNotas.length()];
                    JSONObject notaDetail = arrayNotas.getJSONObject(j);

                    mark = notaDetail.getString("calificacion");
                    codAsig = notaDetail.getString("codAsig");
                    //Log.w("",codAsig+" "+mark);
                    notas[j] = new Nota(mark,codAsig);
            }
            parsed = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return parsed;
    } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
                return parsed;
            }
        }
    }
}*/