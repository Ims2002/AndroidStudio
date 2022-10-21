package com.ims.fragmentskul.parsers;

import android.content.Context;
import android.util.Log;

import com.ims.fragmentskul.Alumno;
import com.ims.fragmentskul.Asignatura;
import com.ims.fragmentskul.Nota;
import com.ims.fragmentskul.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class ParserAlumno {

    InputStream alumnosFile;
    ArrayList<Nota> notas = null;
    Alumno[] datos = null;

    public Alumno[] parse(Context context) {

        String json = null;
        Nota n;
        int nia;
        String name;
        String surname1;
        String surname2;
        String birthDate;
        String email;
        String codAsig;
        String mark;
        this.alumnosFile = context.getResources().openRawResource(R.raw.alumnos_notas);

        try {

            int size = alumnosFile.available();
            byte[] buffer = new byte[size];
            alumnosFile.read(buffer);
            alumnosFile.close();
            json = new String(buffer,"UTF-8");
            JSONTokener tokener = new JSONTokener(json);
            JSONArray jsonArray = new JSONArray(tokener);
            datos = new Alumno[jsonArray.length()];

            for (int i = 0; i < jsonArray.length(); i++) {

                // create a JSONObject for fetching single user data
                JSONObject userDetail = jsonArray.getJSONObject(i);
                // fetch email and name and store it in arraylist

                nia = userDetail.getInt("nia");
                name = userDetail.getString("nombre");
                surname1 = userDetail.getString("apellido1");
                surname2 = userDetail.getString("apellido2");
                birthDate = userDetail.getString("fechaNacimiento");
                email = userDetail.getString("email");
                Log.d("In parser","Simple date ended");
                JSONArray arrayNotas = userDetail.getJSONArray("notas");
                for(int j = 0;j<arrayNotas.length();j++) {
                    notas = new ArrayList<>();
                    JSONObject notaDetail = arrayNotas.getJSONObject(j);

                    mark = notaDetail.getString("calificacion");
                    codAsig = notaDetail.getString("codAsig");

                    n = new Nota(mark,codAsig);

                    notas.add(n);
                }

                //notas = parserNota.parse(context, fileName);

                datos[i] = new Alumno(String.valueOf(nia),name,surname1,surname2,birthDate,email,notas);
            }
            return datos;
        } catch (JSONException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String read(Context context, String fileName) throws IOException {
        String jsonString;
        try {
            InputStream is = context.getAssets().open(fileName);

            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            jsonString = new String(buffer, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return jsonString;

    }
}
