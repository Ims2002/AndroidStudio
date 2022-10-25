package com.ims.fragmentskul;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ims.fragmentskul.Interfaces.IClickListener;
import com.ims.fragmentskul.adapters.CourseAdapter;
import com.ims.fragmentskul.parsers.ParserAlumno;
import com.ims.fragmentskul.parsers.ParserCourse;

import java.util.Objects;

public class FragmentDetalle extends Fragment {
    public static final String EXTRA_ALUMNO = "com.ims.fragments.EXTRA_ALUMNO";

    private Alumno alumno;
    private IClickListener listener;

    private Alumno[] alumnos;

    public FragmentDetalle() {
        super(R.layout.fragment_detail);
        alumnos = new Alumno[500];
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments()!= null) {
            alumno = (Alumno) getArguments().getSerializable(EXTRA_ALUMNO);


        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ParserAlumno parserA = new ParserAlumno();
        alumnos = parserA.parse(view.getContext());
        RecyclerView lstDetalle = view.findViewById(R.id.rvNotaAsignatura);

        lstDetalle.setAdapter(new CourseAdapter(alumnos,listener));
        lstDetalle.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
    }

    public Alumno[] getAlumnos() {
        return alumnos;
    }

}
