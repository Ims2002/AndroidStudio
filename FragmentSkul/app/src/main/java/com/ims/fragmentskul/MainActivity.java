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

public class MainActivity extends AppCompatActivity implements IClickListener, FragmentOnAttachListener {

    private FragmentListado frgListado;
    private FragmentDetalle frgDetalle;
    private ParserAlumno pA;
    private ParserCourse pC;
    private boolean tabletLayout;
    private Alumno[] alumnos;
    private Asignatura[] asignaturas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tabletLayout = findViewById(R.id.FrgDetalle) != null;
        if(savedInstanceState == null) {
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().setReorderingAllowed(true)
                    .add(R.id.FrgListado,FragmentListado.class,null)
                    .commit();
            manager.addFragmentOnAttachListener(this);
        }
        alumnos = pA.parse(this);
        asignaturas =  pC.parse(this);

    }

    public MainActivity() {
        super(R.layout.activity_main);
        frgListado = null;
        frgDetalle = null;
        tabletLayout = false;
        pA = new ParserAlumno();
        pC = new ParserCourse();
    }


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
    }
//MAL
    @Override
    public void onClick(int position) {
        Alumno alumno = alumnos[position];
        //Asignatura asignatura = asignaturas[alumnos[position].getNotas().length];
        if(tabletLayout) {
           // frgDetalle = ;
        } else {
            Intent i = new Intent(this,DetalleActivity.class);
            //i.putExtra(DetalleActivity.EXTRA_COURSE,asignatura);
            i.putExtra(DetalleActivity.EXTRA_ALUMNO,alumno);
            startActivity(i);
        }
    }
}