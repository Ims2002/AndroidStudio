package com.germangascon.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

public class FragmentListado extends Fragment {
    private final Correo[] datos = new Correo[] {
            new Correo("Persona 1", "Asunto del correo 1", "Texto del correo 1"),
            new Correo("Persona 2", "Asunto del correo 2", "Texto del correo 2"),
            new Correo("Persona 3", "Asunto del correo 3", "Texto del correo 3"),
            new Correo("Persona 4", "Asunto del correo 4", "Texto del correo 4"),
            new Correo("Persona 5", "Asunto del correo 5", "Texto del correo 5")
    };
    private ICorreosListener listener;

    public FragmentListado() {
        super(R.layout.fragment_listado);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ListView lstListado = view.findViewById(R.id.LstListado);
        lstListado.setAdapter(new AdaptadorCorreos(this, datos));
        lstListado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long id) {
                if(listener!=null) {
                    listener.onCorreoSeleccionado((Correo)adapterView.getItemAtPosition(pos));
                }
            }
        });
    }

    public Correo[] getDatos() {
        return datos;
    }

    public void setCorreosListener(ICorreosListener listener) {
        this.listener = listener;
    }
}

