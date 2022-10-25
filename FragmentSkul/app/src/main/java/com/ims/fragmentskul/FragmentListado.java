package com.ims.fragmentskul;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ims.fragmentskul.Interfaces.IClickListener;
import com.ims.fragmentskul.adapters.AlumnoAdapter;
import com.ims.fragmentskul.parsers.ParserAlumno;

public class FragmentListado extends Fragment {

    private Alumno[] alumnos;
    private IClickListener listener;

    public FragmentListado() {
        super(R.layout.fragment_main);
    }

    /*public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ParserAlumno parse = new ParserAlumno();
        alumnos = parse.parse(getContext());
        return super.onCreateView(inflater, container, savedInstanceState);

    }*/

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ParserAlumno parse = new ParserAlumno();
        alumnos = parse.parse(getContext());
        RecyclerView lstListado = view.findViewById(R.id.rvMainAlumnos);
        lstListado.setAdapter(new AlumnoAdapter(listener, alumnos));
        lstListado.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));

    }

    public void setAlumnosListener(Alumno[] alumnos, IClickListener listener) {
        this.alumnos = alumnos;
        this.listener = listener;
    }

}
