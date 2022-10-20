package com.ims.fragmentskul;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.ims.fragmentskul.parsers.ParserAlumno;
import com.ims.fragmentskul.parsers.ParserCourse;
import com.ims.fragmentskul.parsers.ParserNota;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int i = 0;

        Alumno[] alumnos;
        Asignatura[] asignaturas;

        ParserAlumno parserAlumno = new ParserAlumno();
        ParserCourse parserCourse = new ParserCourse();

        alumnos = parserAlumno.parse(this, "alumnos_notas.json");

        //asignaturas = parserCourse.parse(this, "asignaturas.json");

        //Log.d(getClass().getSimpleName(), Arrays.toString(alumnos));
        for(Alumno a: alumnos){
            Log.d("TestAlumnos",a.getNia()+a.getName());
        }
        //Log.d("TestParser", asignaturas.toString());
    }
}