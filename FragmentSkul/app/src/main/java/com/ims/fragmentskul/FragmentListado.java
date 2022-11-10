package com.ims.fragmentskul;

import android.content.Context;
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

    public interface IOnAttachListener {
        Alumno[] getAlumnos();
    }

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
        AlumnoAdapter adapter = new AlumnoAdapter(getContext(),listener,alumnos);
        RecyclerView rvListado = view.findViewById(R.id.rvMainAlumnos);
        rvListado.setHasFixedSize(true);
        rvListado.setAdapter(adapter);
        rvListado.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listener = (IClickListener) context;
        IOnAttachListener attachListener = (IOnAttachListener) context;
        alumnos = attachListener.getAlumnos();
    }

}
