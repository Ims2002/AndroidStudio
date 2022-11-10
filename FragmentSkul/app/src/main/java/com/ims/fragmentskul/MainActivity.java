package com.ims.fragmentskul;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentOnAttachListener;

import android.content.Intent;
import android.os.Bundle;

import com.ims.fragmentskul.Interfaces.IClickListener;
import com.ims.fragmentskul.parsers.ParserAlumno;
import com.ims.fragmentskul.parsers.ParserCourse;

public class MainActivity extends AppCompatActivity implements FragmentDetalle.IOnAttachListener,IClickListener, FragmentListado.IOnAttachListener {

    private FragmentDetalle frgDetalle;
    private static final String STUDENT_KEY = "com.ims.fragmentsSkul.student";
    private static final String SELECTED_STUDENT_KEY = "com.ims.fragmentsSkul.selectedStudent";
    private Alumno selectedStudent;
    private boolean tabletLayout;
    private Alumno[] alumnos;
    private Asignatura[] asignaturas;
    private Nota nota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if(savedInstanceState != null) {
            alumnos = (Alumno[]) savedInstanceState.getSerializable(STUDENT_KEY);
            nota = (Nota) savedInstanceState.getSerializable(SELECTED_STUDENT_KEY);
            /*FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().setReorderingAllowed(true)
                    .add(R.id.FrgListado,FragmentListado.class,null)
                    .commit();
            manager.addFragmentOnAttachListener(this);*/
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabletLayout = findViewById(R.id.FrgDetalle) != null;

        if(tabletLayout) {
            FragmentManager manager = getSupportFragmentManager();
            frgDetalle = (FragmentDetalle) manager.findFragmentById(R.id.FrgDetalle);
        }
        //alumnos = pA.parse(this);
        //asignaturas =  pC.parse(this);

    }
/*
    public MainActivity() {
        super(R.layout.activity_main);
        frgListado = null;
        frgDetalle = null;
        tabletLayout = false;
        pA = new ParserAlumno();
        pC = new ParserCourse();
    }
*/

    private void loadData() {
        ParserAlumno parserA = new ParserAlumno(this);
        if(parserA.parse()!=null) {
            alumnos = parserA.getDatos();
            nota = alumnos[0].getNotas()[0];
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putSerializable(STUDENT_KEY,alumnos);
        outState.putSerializable(SELECTED_STUDENT_KEY,getNota());
        super.onSaveInstanceState(outState);
    }

    /*
        @Override
        public void onAttachFragment(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
            if(fragment.getId() == R.id.FrgListado) {
                frgListado = (FragmentListado) fragment;
                frgListado.setAlumnosListener(alumnos,this);
                if(tabletLayout) {
                    Bundle bundle = new Bundle();
                    bundle.putSerializable(FragmentDetalle.EXTRA_ALUMNO,alumnos[0]);
                    FragmentManager manager = getSupportFragmentManager();
                    manager.beginTransaction().setReorderingAllowed(false)
                            .add(R.id.FrgDetalle,FragmentDetalle.class,bundle)
                            .commit();
                }
            }
            if(fragment.getId() == R.id.FrgDetalle) {
                frgDetalle = (FragmentDetalle) fragment;
            }
        }*/
//MAL
    @Override
    public void onClick(int position) {
        selectedStudent = alumnos[position];
        //Asignatura asignatura = asignaturas[alumnos[position].getNotas().length];
        if(tabletLayout) {
            Nota nota = selectedStudent.getNotas()[0];
            setTitle(selectedStudent.getName());
            frgDetalle.mostrarDetalle(nota);
        } else {

            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction()
                    .setReorderingAllowed(true)
                    .addToBackStack(null)
                    .replace(R.id.FrgListado, FragmentDetalle.class, null)
                    .commit();

            /*Intent i = new Intent(this,DetalleActivity.class);
            i.putExtra(DetalleActivity.EXTRA_COURSE,asignatura);
            i.putExtra(DetalleActivity.EXTRA_ALUMNO,alumno);
            startActivity(i);*/
        }
    }

    @Override
    public Nota getNota() {
        if(alumnos == null) {
            loadData();
        }
        if (selectedStudent == null) {
            selectedStudent = alumnos[0];
        }

        Nota nota = selectedStudent.getNotas()[0];
        setTitle(selectedStudent.getName());
        return nota;
    }

    @Override
    public Alumno[] getAlumnos() {
        if(alumnos == null) {
            loadData();
        }
        return alumnos;
    }
}