package com.ims.fragmentskul;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.ims.fragmentskul.parsers.ParserAlumno;
import com.ims.fragmentskul.parsers.ParserCourse;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Alumno[] alumnos;
        Asignatura[] asignaturas;

        ParserAlumno parserAlumno = new ParserAlumno();
        ParserCourse parserCourse = new ParserCourse();

        alumnos = parserAlumno.parse(this);

        asignaturas = parserCourse.parse(this);

        /*for(Alumno a: alumnos){
            Log.d("TestAlumnos",a.getNia()+"  "+a.getName()+"  "+a.getNotas().get(0).getMark());
        }*/
    }
}