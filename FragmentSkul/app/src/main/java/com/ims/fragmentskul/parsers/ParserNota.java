package com.ims.fragmentskul.parsers;

import android.content.Context;

import com.ims.fragmentskul.Nota;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;
import java.io.InputStream;

public class ParserNota {
    public Nota[] parse(Context context, String fileName) {
        String json = null;
        String mark;
        String courseCode;

        try {
            json = read(context,fileName);
            JSONTokener tokener = new JSONTokener(json);
            JSONArray jsonArray = new JSONArray(tokener);
            Nota[] datos = new Nota[jsonArray.length()];
            for (int i = 0; i < jsonArray.length(); i++) {
                // create a JSONObject for fetching single user data
                JSONObject userDetail = jsonArray.getJSONObject(i);
                // fetch email and name and store it in arraylist
                courseCode = String.valueOf(userDetail.getInt("codAsig"));
                mark = userDetail.getString("calificacion");

                datos[i] = new Nota(mark,courseCode);
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
