package com.ims.fragmentskul;

import android.content.Context;
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

    public interface IOnAttachListener {
        Nota getNota();
    }

    private Nota nota;
    private TextView tvMark;
    private TextView tvCourseCode;
    private Alumno[] alumnos;



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvMark = view.findViewById(R.id.tvNota);
        tvCourseCode = view.findViewById(R.id.tvCourseCode);
        if(nota != null) {
            mostrarDetalle(nota);
        }
        /*RecyclerView lstDetalle = view.findViewById(R.id.rvNotaAsignatura);

        lstDetalle.setAdapter(new CourseAdapter(alumnos,listener));
        lstDetalle.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));*/
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        IOnAttachListener attachListener = (IOnAttachListener) context;
        nota = attachListener.getNota();
    }

    public void mostrarDetalle(Nota nota) {
        this.nota = nota;
        tvMark.setText(String.valueOf(nota.getMark()));
        tvCourseCode.setText(nota.getCourseCode());
    }
}
