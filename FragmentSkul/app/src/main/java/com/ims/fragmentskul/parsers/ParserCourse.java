package com.ims.fragmentskul.parsers;

import android.content.Context;

import com.ims.fragmentskul.Asignatura;
import com.ims.fragmentskul.Nota;
import com.ims.fragmentskul.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;
import java.io.InputStream;

public class ParserCourse {

    InputStream coursesFile;

    public Asignatura[] parse(Context context) {
        Asignatura[] datos = null;
        String json = null;
        String courseCode;
        String courseName;
        this.coursesFile = context.getResources().openRawResource(R.raw.asignaturas);

        try {
            int size = coursesFile.available();
            byte[] buffer = new byte[size];
            coursesFile.read(buffer);
            coursesFile.close();
            json = new String(buffer,"UTF-8");
            JSONTokener tokener = new JSONTokener(json);
            JSONArray jsonArray = new JSONArray(tokener);
            datos = new Asignatura[jsonArray.length()];
            for (int i = 0; i < jsonArray.length(); i++) {
                // create a JSONObject for fetching single user data
                JSONObject userDetail = jsonArray.getJSONObject(i);
                // fetch email and name and store it in arraylist
                courseCode = userDetail.getString("codAsig");
                courseName = userDetail.getString("nomAsig");

                datos[i] = new Asignatura(courseCode,courseName);
            }
            return datos;
        } catch (JSONException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
